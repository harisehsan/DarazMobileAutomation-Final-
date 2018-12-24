package _base.api_helpers.buyer;

import _base.api_helpers.ApiService;
import _base.page_helpers.BuyerSitePageHelper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.typesafe.config.Config;
import global.Global;
import helper.UrlHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.json.Json;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Collectors;

public class BuyerSearchApi {

    private ApiService apiService;
    private static String buyerSiteHomeUrl = Global.config.getString("homepage.home_url");
    private static final String SELLER_URL_SUFFIX = "/?from=wangpu&q=All-Products&ajax=true";
    private static final String CATALOG_URL_PREFIX = "catalog/?ajax=true&from=input&service=COD&q=";

    public BuyerSearchApi() {
        this.apiService = new ApiService();
    }

    public String getQnaPdpFromCatalog(String searchKeyword){
        String apiUrl = buyerSiteHomeUrl+CATALOG_URL_PREFIX+searchKeyword;
        List<String> productsListUrls = getListProductUrls(apiUrl);
        String productUrl = getQnaProduct(productsListUrls);
        if(!productUrl.equalsIgnoreCase("")){ return productUrl;}
        throw new RuntimeException("Can not search Qna product From catalog with URL: "+apiUrl);
    }

    public String getCodPdpFromCatalog(String searchKeyword){
        String apiUrl = buyerSiteHomeUrl+CATALOG_URL_PREFIX+searchKeyword;
        List<String> productsListUrls = getListProductUrls(apiUrl);
        String productUrl = getCodProduct(productsListUrls);
        if(!productUrl.equalsIgnoreCase("")){ return productUrl;}
        throw new RuntimeException("Can not search COD product From catalog with URL: "+apiUrl);
    }

    public String getPdpFromCatalog(String searchKeyword){
        String apiUrl = buyerSiteHomeUrl+CATALOG_URL_PREFIX+searchKeyword;
        List<String> productsListUrls = getListProductUrls(apiUrl);
        String productUrl = getNormalProduct(productsListUrls);
        if(!productUrl.equalsIgnoreCase("")){ return productUrl;}
        throw new RuntimeException("Can not search Normal pdp from Catalog with URL: " +apiUrl);
    }

    public String getImPdpFromCatalog(String searchKeyword){
        String apiUrl = buyerSiteHomeUrl+CATALOG_URL_PREFIX+searchKeyword;
        List<String> productsListUrls = getListProductUrls(apiUrl);
        String productUrl = getIMProduct(productsListUrls);
        if(!productUrl.equalsIgnoreCase("")){ return productUrl;}
        throw new RuntimeException("Can not search IM product from Catalog with URL: "+apiUrl);
    }

    public String getCodPdpOfTestSellers(){List<String> sellerUrls = getListTestSellerUrls();
        if(sellerUrls==null) throw new RuntimeException("Can not search COD product");
        for(String url: sellerUrls){
            List<String> productsListUrls = getListProductUrls(url);
            String productUrl = getCodProduct(productsListUrls);
            if(!productUrl.equalsIgnoreCase("")) return productUrl;
        }
        throw new RuntimeException("Can not search COD product");
    }

    public String getQnaPdpOfTestSellers(){List<String> sellerUrls = getListTestSellerUrls();
        if(sellerUrls==null) throw new RuntimeException("Can not search COD product");
        for(String url: sellerUrls){
            List<String> productsListUrls = getListProductUrls(url);
            String productUrl = getQnaProduct(productsListUrls);
            if(!productUrl.equalsIgnoreCase("")) return productUrl;
        }
        throw new RuntimeException("Can not search QNA product");
    }

    public String getIMPdpOfTestSellers(){List<String> sellerUrls = getListTestSellerUrls();
        if(sellerUrls==null) throw new RuntimeException("Can not search COD product");
        for(String url: sellerUrls){
            List<String> productsListUrls = getListProductUrls(url);
            String productUrl = getIMProduct(productsListUrls);
            if(!productUrl.equalsIgnoreCase("")) return productUrl;
        }
        throw new RuntimeException("Can not search IM product");
    }


    @SuppressWarnings("unchecked")
    private List<String> getListTestSellerUrls(){
        List<Object> listTestSellers  = Global.config.getList("seller.test_seller").unwrapped();
        Collections.shuffle(listTestSellers);
        return listTestSellers.stream().map(seller -> buyerSiteHomeUrl+((Map<String, String>)seller).get("partial_shop_url")+SELLER_URL_SUFFIX).collect(Collectors.toList());
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


    private List<String> getListProductUrls(String apiUrl) {
        try {
            if (!UrlHelper.isUrlOK(apiUrl)) return null;
            JsonObject json = apiService.get(apiUrl);
            JsonArray productArray = json.getAsJsonObject("mods").getAsJsonArray("listItems");
            if (productArray.size() == 0) return null;
            Type listType = new TypeToken<List<JsonElement>>() {}.getType();
            List<JsonElement> productList = new Gson().fromJson(productArray, listType);
            Collections.shuffle(productList);
            return productList.stream().map(product -> formatProductUrl(product.getAsJsonObject().get("productUrl").getAsString())).collect(Collectors.toList());
        } catch (IOException | NullPointerException ex) {
            throw new RuntimeException("Can not search cod product using this url: " + apiUrl + " Error: " + ex.getMessage());
        }
    }

    private String formatProductUrl(String unformattedUrl) {
        unformattedUrl = unformattedUrl.replace("//","");
        return UrlHelper.https(unformattedUrl);
    }

}
