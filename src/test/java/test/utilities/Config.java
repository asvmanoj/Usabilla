package test.utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.Properties;

public final class Config implements WebDriverFactoryConstants{

    private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private static final String ENV_VAR = "TEST_ENVIRONMENT";
    public static String environmentRun = "ST";
    private static Properties properties;
    
    private Config() {
    }

    static {
    	File BROWSER_PATH = new File(System.getProperty("user.dir") + "/browser");
        String configPath = BROWSER_PATH + "\\env.properties";
        Properties defaultProps = new Properties();
        try (FileInputStream in = new FileInputStream(configPath)) {
            defaultProps.load(in);
            properties = new Properties(defaultProps);
            String environment = System.getProperty(ENV_VAR);
            LOG.info("Test will run against environment: " + environment);
            if (environment != null && environment.trim().length() > 0) {
            	Config.environmentRun = environment;
                try (FileInputStream input = new FileInputStream(BROWSER_PATH + "\\env-" + environment + ".properties")) {
                    properties.load(input);
                } catch (IOException e) {
                    LOG.error("Error whilst loading properties: {}", e.getMessage(), e);
                }
            }
        } catch (IOException e) {
        	e.printStackTrace();
            LOG.error("Error whilst loading properties: {}", e.getMessage(), e);
        }
    }


    public static String get(String key) {
        return properties.getProperty(key);
    }

    public static String get(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }
}