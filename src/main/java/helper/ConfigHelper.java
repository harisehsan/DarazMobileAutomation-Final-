package helper;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class ConfigHelper {

    private static final String CONF_FOLDER = "src/main/resources/config/";
    private static final String CONF_FILE_EXTENSION = ".conf";

    public static Config loadConfig(String env){
        return loadAllConfigOfEnv(EnvHelper.getEnvKey(env));
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
        return finalConfig.resolve().getConfig(env);
    }

    private static String extractConfigFileName(File configFile){
        File configFolder = new File(CONF_FOLDER);
        String resourceFolderPath = configFolder.getParentFile().getAbsolutePath()+File.separator;
        return configFile.getAbsolutePath().replace(resourceFolderPath,"");
    }
}
