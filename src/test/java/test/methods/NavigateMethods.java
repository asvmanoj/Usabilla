package test.methods;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import test.utilities.Config;


public class NavigateMethods extends SelectElementByType implements BaseTest
{
	private WebElement element=null;
	private String old_win = null;
	private String lastWinHandle;

	public void navigateTo(String url) 
	{
		driver.get(url);
	}
	
	public void closeDriver()
	{
		driver.close();
	}
	

	public void maximizeBrowser()
	{
		driver.manage().window().maximize();
	}
	
    

    public void switchFrame(String accessType, String accessName)
    {
    	if(accessType.equalsIgnoreCase("index"))
    		driver.switchTo().frame(accessName);
    	else
    	{
    		element = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
    		driver.switchTo().frame(element);
    	}
    }

}
