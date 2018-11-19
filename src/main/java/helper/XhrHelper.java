package helper;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import global.Global;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.JavascriptExecutor;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;

public class XhrHelper {

    private static final String XHR_SCRIPT_FOLDER = "src/test/resources/xhr_script/";

    public static JsonObject executeXhrRequest(String scriptName, String [] args){
        String script = getXhrScript(scriptName);
        JavascriptExecutor jsExec = Global.browser.getJsExecutor();
        Object result =  jsExec.executeAsyncScript(script, (Object[]) args);
        JsonParser parser = new JsonParser();
        return parser.parse(String.valueOf(result)).getAsJsonObject();
    }

    private static String getXhrScript(String scriptName){
        try {
            File jsScript =new File(XHR_SCRIPT_FOLDER+scriptName);
            return IOUtils.toString( new FileInputStream(jsScript), Charset.forName("utf-8"));
        } catch (IOException e) {
            throw new RuntimeException(String.format("Something wrong with your xhr script path: %s . ERROR: %s",scriptName,e.getMessage()));
        }

    }
}
