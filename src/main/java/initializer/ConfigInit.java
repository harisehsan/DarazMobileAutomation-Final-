package initializer;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import helper.FileHelper;

import java.io.File;
import java.nio.file.Path;
import java.util.List;


public class ConfigInit {

    private static final String CONF_FOLDER = "src/main/resources/config/";
    private static final String CONF_FILE_EXTENSION = ".conf";
    private static final String COMMON_CONF_KEY = "common";

    public static Config loadConfig(String env){
        return loadAllConfigOfEnv(EnvPicker.getEnvKey(env));
    }

    private static Config loadAllConfigOfEnv(String env){
        File configFolder = new File(CONF_FOLDER);
        List<Path> listConfigPath = FileHelper.listAllInDirectory(configFolder,CONF_FILE_EXTENSION);
        Config finalConfig = ConfigFactory.load();
        for (Path configPath : listConfigPath) {
            String subConfigName = extractConfigFileName(configPath.toFile());
            Config subConfig = ConfigFactory.parseResources(subConfigName);
            finalConfig = finalConfig.withFallback(subConfig);
        }
        Config common = finalConfig.resolve().getConfig(COMMON_CONF_KEY);
        Config venture = finalConfig.resolve().getConfig(env);
        return venture.withFallback(common);
    }

    private static String extractConfigFileName(File configFile){
        File configFolder = new File(CONF_FOLDER);
        String resourceFolderPath = configFolder.getParentFile().getAbsolutePath()+File.separator;
        return configFile.getAbsolutePath().replace(resourceFolderPath,"");
    }
}
