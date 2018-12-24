package helper;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpHelper {
    public static int checkHttpResponseCode (String url) throws IOException {
        URL checkUrl = new URL(url);
        HttpURLConnection connection = (HttpURLConnection)checkUrl.openConnection();
        return connection.getResponseCode();
    }
}
