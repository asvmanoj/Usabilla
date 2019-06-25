package nl.abnamro.test.methods;


import org.openqa.selenium.WebDriver;

import nl.abnamro.test.utilities.DriverUtil;

public class JavascriptHandlingMethods implements BaseTest {
	protected WebDriver driver = DriverUtil.getDefaultDriver();

	public void handleAlert(String decision)
	{
		if(decision.equals("accept"))
			driver.switchTo().alert().accept();
		else
			driver.switchTo().alert().dismiss();
	}
}
