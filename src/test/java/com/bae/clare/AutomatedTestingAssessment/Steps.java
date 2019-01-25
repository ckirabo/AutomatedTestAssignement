package com.bae.clare.AutomatedTestingAssessment;

import static org.junit.Assert.assertEquals;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;


import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps {

	WebDriver driver;

	@Before
	public void startUp() {
		System.setProperty("webdriver.chrome.driver", Constants.driverLocation);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Given("^I navigate to the React Application$")
	public void i_navigate_to_the_React_Application() {
		driver.get(Constants.URL);

	}

	@When("^I click the Link to Automated Testing Exercise Form$")
	public void i_click_the_Link_to_Automated_Testing_Exercise_Form()  {
		HomePage page1 = PageFactory.initElements(driver, HomePage.class);
		page1.navigateToForm();

	}

	@When("^I fill click the \"([^\"]*)\" dropdown menu$")
	public void i_fill_click_the_dropdown_menu(String arg1)  {
		RegisteringPage page2 = PageFactory.initElements(driver, RegisteringPage.class);
		page2.dropDown(driver, arg1);

	}

	@When("^I fill out the email field with \"([^\"]*)\"$")
	public void i_fill_out_the_email_field_with(String arg1)  {
		RegisteringPage page2method2 = PageFactory.initElements(driver, RegisteringPage.class);
		page2method2.enterEmail(arg1);
	}

	@When("^I fill out the first password field with \"([^\"]*)\"$")
	public void i_fill_out_the_first_password_field_with(String arg1) {
		RegisteringPage page2method3 = PageFactory.initElements(driver, RegisteringPage.class);
		page2method3.enterPassWord(arg1);
	}

	@When("^I fill out the second password field with \"([^\"]*)\"$")
	public void i_fill_out_the_second_password_field_with(String arg1) {
		RegisteringPage page2method4 = PageFactory.initElements(driver, RegisteringPage.class);
		page2method4.confirmPassWord(arg1);
	}

	@Then("^I should see a Success! Message$")
	public void i_should_see_a_Success_Message() throws InterruptedException {
		RegisteringPage page2method5 = PageFactory.initElements(driver, RegisteringPage.class);

		Runner.test = Runner.report.startTest("Local host test....");
		
		Runner.test.log(LogStatus.INFO, "Browser Started");
		
		
		page2method5.submitButton();
		
		if(page2method5.Success().equals("Success!")) {
			Runner.test.log(LogStatus.PASS, "Verify user logged in");
		}
		else {
			Runner.test.log(LogStatus.FAIL, "Verify user logged in");
		}
		
		Runner.test.log(LogStatus.INFO, "Test Has Run");
		
		assertEquals("Success Failed", "Success!", page2method5.Success());
	}

	@When("^I fill out the second password field with the wrong password \"([^\"]*)\"$")
	public void i_fill_out_the_second_password_field_with_the_wrong_password(String arg1)  {
		RegisteringPage page2method6 = PageFactory.initElements(driver, RegisteringPage.class);
		page2method6.confirmPassWord(arg1);
		
	}

	@Then("^I should see a message stating that the passwords do not match\\.$")
	public void i_should_see_a_message_stating_that_the_passwords_do_not_match() {
		RegisteringPage page2method7 = PageFactory.initElements(driver, RegisteringPage.class);
		
		page2method7.submitButton();
		
		if(page2method7.doesNotMatch().equals("The passwords do not match")) {
			Runner.test.log(LogStatus.PASS, "Verify the passwords in");
		}
		else {
			Runner.test.log(LogStatus.FAIL, "Verify the passwords in");
		}
		
		Runner.test.log(LogStatus.INFO, "Test Has Run");
		
		assertEquals("Passwords not matching failed", "The passwords do not match", page2method7.doesNotMatch());
	}

	@After
	public void tearDown() {
		driver.quit();
	}

}
