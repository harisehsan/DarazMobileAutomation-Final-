package _base.api_helpers.buyer;

import _base.api_helpers.ApiService;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import global.Global;
import helper.UrlHelper;

import java.io.IOException;
import java.util.Random;

public class BuyerSearchApi {

    private ApiService apiService;
    private static String buyerSiteHomeUrl = Global.config.getString("homepage.home_url");

    public BuyerSearchApi() {
        this.apiService = new ApiService();
    }

    private JsonObject getAllCodProduct(String searchKeyword) {
        String url = buyerSiteHomeUrl+String.format("catalog/?ajax=true&from=input&q=%s&service=COD",searchKeyword);
        try {
            return apiService.get(url);
        } catch (IOException e) {
            throw new RuntimeException("Can not search cod product using this url: "+url+" Error: "+e.getMessage());
        }
    }


    /**
     * Return a random cod product URL base on the searchKeyword
     * @param searchKeyword
     * @return
     */
    public String searchRandomCodProductUrlWithKeyword(String searchKeyword){
        JsonObject json = getAllCodProduct(searchKeyword);
        JsonArray productArray = json.getAsJsonObject("mods").getAsJsonArray("listItems");
        if(productArray.size()==0) throw new RuntimeException("No product found for keyword: "+searchKeyword);
        JsonObject randomProductJson = (JsonObject) productArray.get(new Random().nextInt(productArray.size()));
        String url = randomProductJson.get("productUrl").getAsString();
        url = url.replace("//","");
        return UrlHelper.https(url);
    }
}
