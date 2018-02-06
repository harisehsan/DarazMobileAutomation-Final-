package helper;

import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin.son.ton on 1/28/18.
 */
public class YamlHelper {

    @SuppressWarnings("unchecked")
    public static Map<String,Object> loadToMap(String path){
        Yaml yaml = new Yaml();
        Map<String,Object> resultMap;
        try (InputStream in = YamlHelper.class.getResourceAsStream(path)) {
            resultMap =  (Map<String, Object>) yaml.loadAll(in).iterator().next();
        }catch (Exception ex){
            throw new RuntimeException("Yaml File: %s Cannot be loaded");
        }
        return resultMap;
    }
}
