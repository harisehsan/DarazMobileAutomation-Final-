package helper;

//import org.yaml.snakeyaml.Yaml;
//import org.yaml.snakeyaml.DumperOptions;

import java.io.IOException;
//import java.io.InputStream;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.Map;
//import static javafx.scene.input.KeyCode.Y;

import java.io.File;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import helper.yaml.Topup;



public class ConfigHelper {

    public static void main(String[] args) throws IOException {




        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            System.out.println();
//            Topup object = mapper.readValue(
//                    new File("/Users/nikita.bokarev/develop/java/Tests/UI_Automation/src/main/resources/config/topup.yml"),
//                    Topup.class
//            );
//            System.out.println(ReflectionToStringBuilder.toString(object,ToStringStyle.MULTI_LINE_STYLE));
//            System.out.println(object.getUser().getLastname());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
