package test.utilities;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.net.MalformedURLException;
import java.net.URL;

final class SaucelabsDriverFactory implements WebDriverFactoryConstants {

    private static Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private SaucelabsDriverFactory() {
    }

    static RemoteWebDriver saucelabsDriver(String saucelabsUser, String saucelabsKey) {
        if (saucelabsUser == null)
            throw new IllegalArgumentException("user is null");
        if (saucelabsUser.length() == 0)
            throw new IllegalArgumentException("user is empty");

        if (saucelabsKey == null)
            throw new IllegalArgumentException("key is null");
        if (saucelabsKey.length() == 0)
            throw new IllegalArgumentException("key is null");
        String URLlie = "https://" + saucelabsUser + ":" + saucelabsKey + "@ondemand.saucelabs.com:443/wd/hub";

        RemoteWebDriver remoteWebDriver;
        DesiredCapabilities caps = DesiredCapabilities.chrome();
        caps.setCapability("platform", "Windows 10");
        caps.setCapability("version", "latest");
        caps.setCapability("name", "test name");
        LOG.info("Saucelabs caps set" + URLlie);
        try {
            remoteWebDriver = new RemoteWebDriver(new URL(URLlie), caps);
        } catch (MalformedURLException e) {
            LOG.info("Saucelabs URL not correct" + URLlie);
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return remoteWebDriver;
    }
}

