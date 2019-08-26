package test.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

final class FirefoxDriverFactory implements WebDriverFactoryConstants {

    private static final String FIREFOX_PATH = BROWSER_PATH + "/firefox/firefox.exe";
    private static final String FIREFOX_DRIVER_VERSION = "0.21.0";

    private FirefoxDriverFactory() {
    }

    static WebDriver firefoxDriver() {
       /* FirefoxOptions options = firefoxOptions();
        WebDriverManager
                .firefoxdriver()
                .proxy("http://localhost:2000")
                .setup();
        return new FirefoxDriver(options);*/
        
        
        DesiredCapabilities capability = DesiredCapabilities.firefox();
    	WebDriver driver = null;
		try {
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
    	return driver;
        
    }

    static WebDriver headlessFirefoxDriver() {
        FirefoxOptions options = headlessFirefoxOptions();
        WebDriverManager
                .firefoxdriver()
                .version(FIREFOX_DRIVER_VERSION)
                .targetPath(WEB_DRIVER_PATH.getAbsolutePath())
                .forceCache()
                .setup();
        return new FirefoxDriver(options);
    }

    private static FirefoxOptions firefoxOptions() {
        return new FirefoxOptions();
    }

    private static FirefoxOptions headlessFirefoxOptions() {
        FirefoxOptions options = firefoxOptions();
        File ffBinary = new File(FIREFOX_PATH);
        options.setBinary(ffBinary.getAbsolutePath());
//        options.addArguments("-headless");
        options.addArguments("-private");

        Proxy proxy = new Proxy();
        proxy.setHttpProxy(PROXY_URL);
        options.setProxy(proxy);

        options.setProfile(firefoxProfile());

        return options;
    }

    private static FirefoxProfile firefoxProfile() {
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("network.proxy.type", 1);
        profile.setPreference("network.proxy.http", PROXY_HOST);
        profile.setPreference("network.proxy.http_port", PROXY_PORT);
        profile.setAcceptUntrustedCertificates(true);
        profile.setPreference("app.update.auto", false);
        profile.setPreference("app.update.enabled", false);
        profile.setPreference("app.update.silent", true);
        profile.setPreference("extensions.update.enabled", false);
        return profile;
    }

}
