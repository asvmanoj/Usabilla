package seleniumscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BasicScript {
	WebDriver driver;
	String url;
 
	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--dns-prefetch-disable");
        options.addArguments("--always-authorize-plugins");
        options.addArguments("--incognito");
        options.addArguments("--window-size=800,600");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--ignore-ssl-errors");
        options.addArguments("--ssl-protocol=any");
        options.addArguments("--allow-insecure-localhost");
        options.addArguments("--allow-running-insecure-content");
        options.addArguments("--no-sandbox");
        options.addArguments("--v");
        options.addArguments("--disable-setuid-sandbox");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-debugging-port=9222");
        options.setExperimentalOption("useAutomationExtension", false);
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		
		System.setProperty("webdriver.ie.driver", "C:\\Users\\C55586\\IEDriverServer.exe");
		WebDriver driver=new InternetExplorerDriver();
		driver.get("http://portal-c61.nl.eu.abnamro.com:9997/portalserver/my-abnamro/self-service/sign/index.html");

	}
			
}
