package nl.abnamro.test.utilities;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

final class WebDriverFactory {

    private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private static final String BROWSER_TYPE_KEY = "Test_BROWSER";
    private static final String SAUCELABS_USER = "SAUCELABS_USER";
    private static final String SAUCELABS_KEY = "SAUCELABS_KEY";

    private WebDriverFactory() {
    }

    static WebDriver createWebDriver() {
        String browser = System.getProperty(BROWSER_TYPE_KEY, "HEADLESS_CHROME").toLowerCase();

        WebDriver driver;
        switch (browser) {
            case "firefox":
                driver = FirefoxDriverFactory.firefoxDriver();
                break;
            case "headless_firefox":
                driver = FirefoxDriverFactory.headlessFirefoxDriver();
                break;
            case "phantomjs":
                driver = PhantomJSDriverFactory.phantomjsDriver();
                break;
            case "chrome":
                driver = ChromeDriverFactory.chromeDriver();
                break;
            case "saucelabs":
                String userName = System.getProperty(SAUCELABS_USER, "");
                String accessKey = System.getProperty(SAUCELABS_KEY, "");
                driver = SaucelabsDriverFactory.saucelabsDriver(userName, accessKey);
                break;
            case "headless_chrome":
            default:
                driver = ChromeDriverFactory.headlessChromeDriver();
        }
        LOG.info("Configured WebDriver for browser '{}'", browser);
        return driver;
    }
}