package _base.api_helpers;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.LaxRedirectStrategy;

import java.io.IOException;
import java.io.InputStream;

public class ApiService {

    private CloseableHttpClient httpClient;

    public ApiService() {
        httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build())
                .setRedirectStrategy(new LaxRedirectStrategy())
                .setDefaultCookieStore(new BasicCookieStore()).build();
    }

    /**
     * This function will execute REST get request
     * and return a Gson - JsonObject
     * @param url
     * @return
     * @throws IOException
     */
    public JsonObject get(String url) throws IOException {
        HttpGet httpGet = new HttpGet(url);
        HttpResponse response = httpClient.execute(httpGet);
        HttpEntity entity = response.getEntity();
        InputStream is = entity.getContent();
        String body = IOUtils.toString(is, "UTF-8");
        is.close();
        try {
            return new Gson().fromJson(body, JsonObject.class);
        }catch (JsonSyntaxException ex){
            return null;
        }
    }

    public boolean isUrlValid(String url) {
        try{
            HttpGet httpGet = new HttpGet(url);
            try(CloseableHttpResponse response = httpClient.execute(httpGet)){
                return response.getStatusLine().getStatusCode() == 200;
            }
        }catch (IOException ex){
            System.out.println("Something wrong with url"+ url);
        }
        return false;
    }
}
