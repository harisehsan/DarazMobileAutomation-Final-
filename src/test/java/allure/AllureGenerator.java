package allure;

import java.io.IOException;

public interface AllureGenerator {

    static void generateResult(){
        if(System.getProperty("allure.results.directory")==null){
            return;
        }
        String [] cmdArray = new String[5];
        cmdArray[0] = "allure";
        cmdArray[1] = "generate";
        cmdArray[2] = System.getProperty("allure.results.directory");
        cmdArray[3] = "-o";
        cmdArray[4] = System.getProperty("allure.results.directory")+"/html";
        try{
            Runtime rt = Runtime.getRuntime();
            Process p = rt.exec(cmdArray);
            p.waitFor();
            p.destroy();
        }catch(IOException| InterruptedException ex){
            throw new RuntimeException(String.format("Cannot Generate Allure report: %s | Error: %s",cmdArray[2],ex.getMessage()));
        }
    }
}
