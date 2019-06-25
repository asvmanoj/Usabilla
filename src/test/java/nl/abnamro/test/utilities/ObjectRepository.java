package nl.abnamro.test.utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.Properties;

public final class ObjectRepository implements WebDriverFactoryConstants{

    private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private static Properties properties;

    private ObjectRepository() {
    }

    static {
        String configPath = BROWSER_PATH + "\\object_repo\\page_objects.properties";
        Properties defaultProps = new Properties();
        try (FileInputStream in = new FileInputStream(configPath)) {
            defaultProps.load(in);
            properties = defaultProps;
            LOG.info("Test will use repository: " + configPath);
        } catch (IOException e) {
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