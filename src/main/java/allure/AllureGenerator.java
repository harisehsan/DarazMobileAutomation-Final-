package allure;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public interface AllureGenerator {

    static void removeAllureResultFolder(){
        String allureFilePath = System.getProperty("allure.results.directory");
        if(allureFilePath!=null){
            File allureResultFolder = new File(allureFilePath);
            try {
                FileUtils.deleteDirectory(allureResultFolder);
            } catch (IOException e) {
                throw new RuntimeException("Cannot delete allure result folder");
            }
        }
    }
}
