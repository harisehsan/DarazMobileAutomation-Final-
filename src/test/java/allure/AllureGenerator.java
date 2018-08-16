package allure;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

public interface AllureGenerator {

    static void removeAllureResultFolder(){
        File allureResultFolder = new File(System.getProperty("allure.results.directory"));
        try {
            FileUtils.deleteDirectory(allureResultFolder);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
