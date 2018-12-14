package _base.api_helpers.buyer;

import _base.api_helpers.ApiService;
import _base.page_helpers.BuyerSitePageHelper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.typesafe.config.Config;
import global.Global;
import helper.UrlHelper;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

public class BuyerSearchApi {

    private ApiService apiService;
    private static String buyerSiteHomeUrl = Global.config.getString("homepage.home_url");

    private static String catalogUrl = Global.config.getString("homepage.home_url");
    private static final String SELLER_URL_SUFFIX = "/?from=wangpu&q=All-Products&service=COD&ajax=true";
    private static final String CATALOG_URL_PREFIX = "catalog/?ajax=true&from=input&service=COD&q=";

    public BuyerSearchApi() {
        this.apiService = new ApiService();
    }


    public String getCodProductFromCatalog(String searchKeyword){
        String apiUrl = buyerSiteHomeUrl+CATALOG_URL_PREFIX+searchKeyword;
        String productUrl = filterOneRandomProduct(apiUrl);
        if(!productUrl.equalsIgnoreCase("")){
            return productUrl;
        }
        throw new RuntimeException("Can not search product");
    }

    @SuppressWarnings("unchecked")
    public String getRandomCodProductFromRandomSeller(){
        List<Object> listTestSellers  = Global.config.getList("seller.test_seller").unwrapped();
        Collections.shuffle(listTestSellers);
        for (Object o: listTestSellers){
            Map<String,String> sellerMap = (Map<String, String>) o;
            String url = getRabdomCodProductFromSpecificSeller(sellerMap.get("partial_shop_url"));
            if(!url.equalsIgnoreCase("")) return url;
        }
        throw new RuntimeException("Can not search COD product");
    }

    private String getRabdomCodProductFromSpecificSeller(String sellerPartialUrl){
        String apiUrl = buyerSiteHomeUrl+sellerPartialUrl+SELLER_URL_SUFFIX;
        String productUrl = filterOneRandomProduct(apiUrl);
        if(!productUrl.equalsIgnoreCase("")){
            Logger.getLogger(this.getClass()).info("Product url: "+productUrl);
            Logger.getLogger(this.getClass()).info("Seller url: "+ apiUrl);
            return productUrl;
        }
        return "";
    }



    private String filterOneRandomProduct(String apiUrl) {
        try{
            if(!apiService.isUrlValid(apiUrl)) return "";
            JsonObject json =  apiService.get(apiUrl);
            JsonArray productArray = json.getAsJsonObject("mods").getAsJsonArray("listItems");
            if (productArray.size()==0) return "";
            Type listType = new TypeToken<List<JsonElement>>() {}.getType();
            List<JsonElement> productList = new Gson().fromJson(productArray,listType);
            Collections.shuffle(productList);
            for(JsonElement o: productList){
                String productUrl = formatProductUrl(o.getAsJsonObject().get("productUrl").getAsString());
                if(apiService.isUrlValid(productUrl)) return productUrl;
            }
            return "";
        }catch (IOException ex){
            throw new RuntimeException("Can not search cod product using this url: "+apiUrl+" Error: "+ex.getMessage());
        }

    }

    private String formatProductUrl(String unformattedUrl) {
        unformattedUrl = unformattedUrl.replace("//","");
        return UrlHelper.https(unformattedUrl);
    }

}
