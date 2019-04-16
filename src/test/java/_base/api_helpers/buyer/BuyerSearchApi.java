package _base.api_helpers.buyer;

import _base.api_helpers.ApiService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import global.Global;
import helper.UrlHelper;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BuyerSearchApi {

    private ApiService apiService;
    private static String buyerSiteHomeUrl = Global.getConfig().getString("homepage.home_url");
    private static final String SELLER_URL_PREFIX = "shop/site/api/seller/products?shopId=";
    private static final String CATALOG_URL_PREFIX = "catalog/?ajax=true&from=input&service=COD&q=";

    public BuyerSearchApi() {
        this.apiService = new ApiService();
    }

    public String getQnaPdpFromCatalog(String searchKeyword){
        String apiUrl = buyerSiteHomeUrl+CATALOG_URL_PREFIX+searchKeyword;
        List<String> productsListUrls = getListProductUrlsFromCatalog(apiUrl);
        String productUrl = getQnaProduct(productsListUrls);
        if(!productUrl.equalsIgnoreCase("")){ return productUrl;}
        throw new RuntimeException("Can not search Qna product From catalog with URL: "+apiUrl);
    }

    public String getCodPdpFromCatalog(String searchKeyword){
        String apiUrl = buyerSiteHomeUrl+CATALOG_URL_PREFIX+searchKeyword;
        List<String> productsListUrls = getListProductUrlsFromCatalog(apiUrl);
        String productUrl = getCodProduct(productsListUrls);
        if(!productUrl.equalsIgnoreCase("")){ return productUrl;}
        throw new RuntimeException("Can not search COD product From catalog with URL: "+apiUrl);
    }

    public String getPdpFromCatalog(String searchKeyword){
        String apiUrl = buyerSiteHomeUrl+CATALOG_URL_PREFIX+searchKeyword;
        List<String> productsListUrls = getListProductUrlsFromCatalog(apiUrl);
        String productUrl = getNormalProduct(productsListUrls);
        if(!productUrl.equalsIgnoreCase("")){ return productUrl;}
        throw new RuntimeException("Can not search Normal pdp from Catalog with URL: " +apiUrl);
    }

    public String getImPdpFromCatalog(String searchKeyword){
        String apiUrl = buyerSiteHomeUrl+CATALOG_URL_PREFIX+searchKeyword;
        List<String> productsListUrls = getListProductUrlsFromCatalog(apiUrl);
        String productUrl = getIMProduct(productsListUrls);
        if(!productUrl.equalsIgnoreCase("")){ return productUrl;}
        throw new RuntimeException("Can not search IM product from Catalog with URL: "+apiUrl);
    }

    public String getCodPdpOfTestSellers(){
        List<String> sellerUrls = getListTestSellerUrls();
        if(sellerUrls==null) throw new RuntimeException("Can not search COD product");
        for(String url: sellerUrls){
            List<String> productsListUrls = getListProductUrlsFromSeller(url);
            String productUrl = getCodProduct(productsListUrls);
            if(!productUrl.equalsIgnoreCase("")) return productUrl;
        }
        throw new RuntimeException("Can not search COD product");
    }

    public String getQnaPdpOfTestSellers(){
        List<String> sellerUrls = getListTestSellerUrls();
        if(sellerUrls==null) throw new RuntimeException("Can not search COD product");
        for(String url: sellerUrls){
            List<String> productsListUrls = getListProductUrlsFromSeller(url);
            String productUrl = getQnaProduct(productsListUrls);
            if(!productUrl.equalsIgnoreCase("")) return productUrl;
        }
        throw new RuntimeException("Can not search QNA product");
    }

    public String getIMPdpOfTestSellers(){List<String> sellerUrls = getListTestSellerUrls();
        if(sellerUrls==null) throw new RuntimeException("Can not search COD product");
        for(String url: sellerUrls){
            List<String> productsListUrls = getListProductUrlsFromSeller(url);
            String productUrl = getIMProduct(productsListUrls);
            if(!productUrl.equalsIgnoreCase("")) return productUrl;
        }
        throw new RuntimeException("Can not search IM product");
    }


    @SuppressWarnings("unchecked")
    private List<String> getListTestSellerUrls(){
        List<Object> listTestSellers  = Global.getConfig().getList("seller.test_seller").unwrapped();
        Collections.shuffle(listTestSellers);
        return listTestSellers.stream().map(seller -> buyerSiteHomeUrl+SELLER_URL_PREFIX+((Map<String, String>)seller).get("shop_id")).collect(Collectors.toList());
    }

    private String getCodProduct(List<String> productListUrls){
        if(productListUrls==null) return "";
        return productListUrls.stream()
                .filter(productUrl -> UrlHelper.isUrlOK(productUrl) && new PdpApi(productUrl).isCodPdp()).findAny().orElse("");
    }

    private String getQnaProduct(List<String> productListUrls){
        if(productListUrls==null) return "";
        return productListUrls.stream()
                .filter(productUrl -> UrlHelper.isUrlOK(productUrl) && new PdpApi(productUrl).isQnaPdp()).findAny().orElse("");
    }

    private String getIMProduct(List<String> productListUrls){
        if(productListUrls==null) return "";
        return productListUrls.stream()
                .filter(productUrl -> UrlHelper.isUrlOK(productUrl) && new PdpApi(productUrl).isChatAvailable()).findAny().orElse("");
    }

    private String getNormalProduct(List<String> productListUrls){
        if(productListUrls==null) return "";
        return productListUrls.stream()
                .filter(UrlHelper::isUrlOK).findAny().orElse("");
    }


    private List<String> getListProductUrlsFromSeller(String sellerApiUrl) {
        try {
            if (!UrlHelper.isUrlOK(sellerApiUrl)) return null;
            JsonObject json = apiService.get(sellerApiUrl);
            JsonArray productArray = json.getAsJsonObject("result").getAsJsonArray("products");
            List<JsonElement> productList = getListProducts(productArray);
            return productList.stream().map(product -> product.getAsJsonObject().get("mobileUrl").getAsString()).collect(Collectors.toList());
        } catch (IOException | NullPointerException ex) {
            throw new RuntimeException("Can not search cod product using this url: " + sellerApiUrl + " Error: " + ex.getMessage());
        }
    }

    private List<String> getListProductUrlsFromCatalog(String catalogApiUrl) {
        try {
            if (!UrlHelper.isUrlOK(catalogApiUrl)) return null;
            JsonObject json = apiService.get(catalogApiUrl);
            JsonArray productArray = json.getAsJsonObject("mods").getAsJsonArray("listItems");
            List<JsonElement> productList = getListProducts(productArray);
            return productList.stream().map(product -> formatProductUrl(product.getAsJsonObject().get("productUrl").getAsString())).collect(Collectors.toList());
        } catch (IOException | NullPointerException ex) {
            throw new RuntimeException("Can not search cod product using this url: " + catalogApiUrl + " Error: " + ex.getMessage());
        }
    }

    private List<JsonElement> getListProducts(JsonArray productArray){
            if (productArray.size() == 0) return new ArrayList<>();
            Type listType = new TypeToken<List<JsonElement>>() {}.getType();
            List<JsonElement> productList = new Gson().fromJson(productArray, listType);
            Collections.shuffle(productList);
            return productList;
    }

    private String formatProductUrl(String unformattedUrl) {
        unformattedUrl = unformattedUrl.replace("//","");
        return UrlHelper.https(unformattedUrl);
    }

}
