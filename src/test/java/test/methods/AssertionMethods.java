package test.methods;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class AssertionMethods extends SelectElementByType implements BaseTest
{
	private WebElement element=null;
		
	public String getPageTitle()
	{
		return driver.getTitle();
	}
	

	public void checkTitle(String title,boolean testCase) throws TestCaseFailed
	{
		String pageTitle = getPageTitle();
		
		if(testCase)
		{
			if(!pageTitle.equals(title))
				throw new TestCaseFailed("Page Title Not Matched,Given "+title+" Actual Page Title : "+pageTitle);
		}
		else
		{
			if(pageTitle.equals(title))
				throw new TestCaseFailed("Page Title Matched,Given "+title+" Actual Page Title : "+pageTitle);
		}
	}
	

	public void checkPartialTitle(String partialTitle,boolean testCase) throws TestCaseFailed
	{
		String pageTitle = getPageTitle();
		if(testCase)
		{
			if(!pageTitle.contains(partialTitle))
				throw new TestCaseFailed("Partial Page Title Not Present,Given "+partialTitle+" Actual Page Title : "+pageTitle);
		}
		else
		{
			if(pageTitle.contains(partialTitle))
				throw new TestCaseFailed("Partial Page Title Present,Given "+partialTitle+" Actual Page Title : "+pageTitle);
		}
	}


	public String getElementText(String accessType, String accessName)
	{
		element = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		return element.getText();
		
	}
	

}
