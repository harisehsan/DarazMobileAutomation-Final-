package helper;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class EnvHelper {

    private static final String ENV_KEY = "environment";
    private static final String ENV_RESOURCE_FILE = "env.conf";

    static String getEnvKey(String env){
        Config config = ConfigFactory.parseResources(ENV_RESOURCE_FILE);
        if(!config.getAnyRefList(ENV_KEY).contains(env)){
            throw new RuntimeException(
                    "The Environment you choose is not valid. " +
                            "Please Choose one in this list: "+
                            config.getAnyRefList(ENV_KEY));
        }
        return env;
    }


}
