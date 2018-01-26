package helper;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by admin.son.ton on 1/26/18.
 */
public class UrlHelper {

    public static String removePrefix(String url){
        try{
            URI uri = new URI(url);
            return uri.getPath();
        }catch (URISyntaxException ex){
            return null;
        }

    }
}
