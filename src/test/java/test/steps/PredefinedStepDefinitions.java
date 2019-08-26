package test.steps;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import test.methods.BaseTest;
import test.methods.TestCaseFailed;
import test.utilities.*;
import test.methods.ProgressMethods;

public class PredefinedStepDefinitions implements BaseTest, WebDriverFactoryConstants {
	protected WebDriver driver = DriverUtil.getDefaultDriver();
	// Navigation Steps
	public Scenario scenario;

	// Step to navigate to specified URL
	@Before
	public void beforeTest(Scenario scenario) {
		System.out.println("In Before scenario "+scenario.getName());
		this.scenario = scenario;
	}

	@After
	public void afterTest(Scenario scenario) {
		System.out.println("In after scenario "+scenario.getName());
		if(scenario.isFailed()) {
			screenshotObj.addScreenshotTestreport(scenario);
		}
	}
	@Given("^I navigate to \"([^\"]*)\"$")
	public void navigate_to(String link)
	{
		System.out.println("Navigating to link "+Config.get(link));
		navigationObj.navigateTo(Config.get(link));
	}
	
	// wait for specific period of time
	@Then("^I wait for (\\d+) sec$")
	public void wait(String time) throws NumberFormatException, InterruptedException {
		System.out.println("wait for "+time);
		progressObj.wait(time);
	}

	// step to maximize browser
	@When("^I maximize browser window$")
	public void maximize_browser() {
		System.out.println(" maximize browser window");
		navigationObj.maximizeBrowser();
	}
	
		@When("^I click on element having \"(.*?)\"$")
	public void click(String accessName) throws Exception {
		String[] keyAccess = miscmethodObj.splitAndGet(accessName);
		System.out.println("clcik on element having  "+keyAccess[0]+" "+keyAccess[1]);
		miscmethodObj.validateLocator(keyAccess[0]);
		clickObj.click(keyAccess[0], keyAccess[1]);
		
	}
	
		// Step to switch to frame by web element
	@When("^I switch to frame having (.+) \"(.*?)\"$")
	public void switch_frame_by_element(String method, String value)
	{
		System.out.println("switch to frame having "+method+" value :"+value);
		navigationObj.switchFrame(method, value);
	}
	
		@Then("^I take screenshot$")
	public void take_screenshot() throws IOException {
		System.out.println("take screenshot");
		screenshotObj.addScreenshotTestreport(this.scenario);
	}
	
	@Then("^I should\\s*((?:not)?)\\s+see page title having partial text as \"(.*?)\"$")
	public void check_partial_text(String present, String partialTextTitle) throws TestCaseFailed
	{
		System.out.println("checking partial with "+partialTextTitle);
		assertionObj.checkPartialTitle(partialTextTitle, present.isEmpty());
	}
	
	// enter text into input field steps
		@When("^I enter \"([^\"]*)\" into input field having \"([^\"]*)\"$")
		public void enter_text(String text, String accessName) throws Exception {
			String[] keyAccess = miscmethodObj.splitAndGet(accessName);
			System.out.println("enter input value"+text+" having "+keyAccess[0]+" "+ keyAccess[1]);
			miscmethodObj.validateLocator(keyAccess[0]);
			inputObj.enterText(keyAccess[0], text, keyAccess[1]);
		}
		
		// select option by text/value from dropdown
		@When("^I select \"(.*?)\" option by (.+) from dropdown having \"(.*?)\"$")
		public void select_option_from_dropdown(String option, String optionBy, String accessName)
				throws Exception {
			String[] keyAccess = miscmethodObj.splitAndGet(accessName);
			System.out.println("select "+option+" dropdown with "+keyAccess[0]+" "+keyAccess[1]);
			miscmethodObj.validateLocator(keyAccess[0]);
			miscmethodObj.validateOptionBy(optionBy);
			inputObj.selectOptionFromDropdown(keyAccess[0], optionBy, option, keyAccess[1]);
		}

	}