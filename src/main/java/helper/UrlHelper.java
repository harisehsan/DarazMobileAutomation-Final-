package helper;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Created by admin.son.ton on 1/26/18.
 */
public interface UrlHelper {

    static String removePrefix(String url){
        try{
            URI uri = new URI(url);
            return uri.getPath();
        }catch (URISyntaxException ex){
            throw new RuntimeException("Wrong Url Syntax");
        }

    }

    static String https(String url){
        String httpsPrefix = "https://";
        return httpsPrefix + removePrefix(url);
    }

    static boolean isUrlOK (String url) {
        return getUrlStatusCode(url)==HttpURLConnection.HTTP_OK;
    }

    static int getUrlStatusCode(String url){
        HttpURLConnection connection =null;
        try{
            URL checkUrl = new URL(url);
            connection = (HttpURLConnection)checkUrl.openConnection();
            return connection.getResponseCode();
        }catch (IOException ex){
            throw new RuntimeException("Can not get status code of URL: "+ url + "Error: "+ex.getMessage());
        }finally {
            if(connection !=null){
                connection.disconnect();
            }
        }
    }
}
