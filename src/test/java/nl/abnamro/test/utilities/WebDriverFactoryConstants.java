package nl.abnamro.test.utilities;

import java.io.File;

public interface WebDriverFactoryConstants {
    File WEB_DRIVER_PATH = new File(System.getProperty("user.dir") + "/webdriver");
    File BROWSER_PATH = new File(System.getProperty("user.dir") + "/browser");
    String PROXY_HOST = "nl-userproxy-access.net.abnamro.com";
    Integer PROXY_PORT = 8080;
    String PROXY_URL = "http://"+PROXY_HOST + ":" + PROXY_PORT;
    String TEST = Config.get("opel_prospect.url");
    String TEST_FOR = ObjectRepository.get("test_for");
}