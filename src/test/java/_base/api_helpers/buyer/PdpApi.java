package _base.api_helpers.buyer;

import _base.api_helpers.ApiService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import old_module.desktop.pages.desktop.pdp.Pdp_Page;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class PdpApi {

    private static final String PDP_JSON_SUFFIX = "?debug=true";

    private ApiService apiService;
    private JsonObject pdpJsonResponse;
    private String pdpUrl;

    PdpApi(String pdpUrl){
        this.apiService = new ApiService();
        this.pdpUrl = formatJsonPdpUrl(pdpUrl);
        this.pdpJsonResponse = extractPdpJsonResponse(this.pdpUrl);
    }

    private JsonObject extractPdpJsonResponse(String url){
        try {
            String jsonPdpUrl = formatJsonPdpUrl(url + PDP_JSON_SUFFIX);
            JsonObject pdpJsonObject = apiService.get(jsonPdpUrl);
            return pdpJsonObject.getAsJsonObject("convertUtil").getAsJsonObject("response");
        } catch (IOException e) {
            throw new RuntimeException("Can not find the response of this url "+url);
        }

    }

    private boolean isUrlRedirect(String url){
        try {
            JsonObject pdpJsonObject = apiService.get(url);
            return pdpJsonObject.getAsJsonObject("DetailService").getAsJsonObject("response").getAsJsonPrimitive("0").getAsString().contains("RedirectException");
        } catch (IOException e) {
            throw new RuntimeException("Can not check if product is redirected or not. url: "+url);
        } catch (NullPointerException ex){
            return false;
        }
    }

    private String formatJsonPdpUrl(String url){
        if(isUrlRedirect(url)){
            return url.replace("/products/","/");
        }
        return url;
    }

    private String getSkuID(){
        return StringUtils.substringBetween(pdpUrl,"-s",".html");
    }

    boolean isQnaPdp(){
        return !pdpJsonResponse.getAsJsonObject("qna").getAsJsonPrimitive("hidden").getAsBoolean();
    }

    boolean isCodPdp(){
        try {
            JsonArray deliveryOptions = pdpJsonResponse.getAsJsonObject("deliveryOptions").getAsJsonArray(getSkuID());
            if(deliveryOptions==null) return false;
            Type listType = new TypeToken<List<JsonElement>>() {}.getType();
            List<JsonElement> deliveryOptionsList = new Gson().fromJson(deliveryOptions,listType);
            JsonElement codDeliveryOtption = deliveryOptionsList.stream().filter(t->t.getAsJsonObject().getAsJsonPrimitive("type").getAsString().equalsIgnoreCase("COD")).findAny().orElse(null);
            return codDeliveryOtption!=null && isStockAvailablePdp();
        } catch (NullPointerException ex){
            return false;
        }
    }

    boolean isStockAvailablePdp(){
        try {
            int pdpStock = pdpJsonResponse.getAsJsonObject("skuInfos").getAsJsonObject(getSkuID()).getAsJsonPrimitive("stock").getAsInt();
            return pdpStock >0;
        } catch (NullPointerException ex){
            return false;
        }
    }
}
