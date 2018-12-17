package helper;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpHelper {

    public static int checkHttpResponseCode (String landingpage) throws IOException {
        URL url = new URL(landingpage);
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        return connection.getResponseCode();

    }
}
