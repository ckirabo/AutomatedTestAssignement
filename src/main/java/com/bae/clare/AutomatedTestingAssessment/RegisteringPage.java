package com.bae.clare.AutomatedTestingAssessment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class RegisteringPage {

	
	@FindBy(xpath ="//*[@id=\"root\"]/div/div/div/button")
	private WebElement dropDown;
	
	
	@FindBy(xpath ="//*[@id=\"root\"]/div/div/div/div/a[1]")
	private WebElement ukDropDown;
	
	@FindBy(xpath ="//*[@id=\"root\"]/div/div/div/div/a[2]")
	private WebElement franceDropDown;
	
	@FindBy(xpath ="//*[@id=\"root\"]/div/div/div/div/a[3]")
	private WebElement germanyDropDown;
	
	
	@FindBy(id ="nameInput")
	private WebElement email;
	
	@FindBy(id ="passInput")
	private WebElement password;
	
	@FindBy(id ="passInput2")
	private WebElement passwordConfirmed;
	
	@FindBy(xpath ="//*[@id=\"root\"]/div/div/button")
	private WebElement submit;
	
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div/h1")
	private WebElement success;

	@FindBy(xpath="//*[@id=\"root\"]/div/div/p[10]")
	private WebElement doesNotExist;
	
	public void dropDown(WebDriver driver, String country) {
		
		
		Actions action = new Actions(driver);
		action.moveToElement(dropDown).click().perform();
		
		if(country.equals("United Kingdom")) {
			ukDropDown.click();
		}
		if(country.equals("France")) {
			franceDropDown.click();
		}
		if(country.equals("Germany")) {
			germanyDropDown.click();
		}
		
		
	}
	
	public void enterEmail(String nEmail) {
		email.sendKeys(nEmail);	
	}
	
	
	public void enterPassWord(String nPasswrod) {
		password.sendKeys(nPasswrod);
		
	}
	

	public void confirmPassWord(String nConfirmPasswrod) {
		passwordConfirmed.sendKeys(nConfirmPasswrod);
		
	}
	
	public void submitButton() {
		submit.click();
	}
	
	
	
	public String Success() {
		if(success.isDisplayed() && success.isEnabled()) {
			return success.getText();	
		}
		
		return "";
	}
	
	
	public String doesNotMatch() {
		if(doesNotExist.isDisplayed() && doesNotExist.isEnabled()) {
			return doesNotExist.getText();	
		}
		
		return "";
	}
	
}
