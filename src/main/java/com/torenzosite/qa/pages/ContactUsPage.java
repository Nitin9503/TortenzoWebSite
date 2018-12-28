package com.torenzosite.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.torenzosite.qa.base.TestBase;

public class ContactUsPage extends TestBase {
	//Contact page form filling  
	
	@FindBy(xpath = "//input[@type='text' and @id='input_1_7_3']")
	WebElement firstName;

	@FindBy(xpath = "//input[@type='text' and @name='input_7.6' ]")
	WebElement lastName;
		
	@FindBy(xpath = "//input[@type='text' and @id='input_1_2' ]")
	WebElement emailId;
	
	@FindBy(xpath = "//div[@class='ginput_container ginput_container_phone']//input[@id='input_1_3']")
	WebElement phoneNo;
	
	@FindBy(xpath = "//input[@id='input_1_4' ]")
	WebElement companyName;
	
	@FindBy(xpath = "//input[@id='input_1_5' ]")
	WebElement subject;
	
	@FindBy(xpath = "//textarea[@class='textarea medium form-control' and @id='input_1_6']")
	public static WebElement message;
	
	//div[@class='gform_footer top_label']//input[@id='gform_submit_button_6' and @type='submit' and @value='Submit']
	@FindBy(xpath = "//input[@id='gform_submit_button_1']")
	WebElement submit;
	
	//Validation and error message
	@FindBy(xpath = "//div[@class='alert alert-error']")
	WebElement alertMessage;
	
	@FindBy(xpath = "//div[@class='gfield_description validation_message']")
	WebElement validationMessage;
		
	public ContactUsPage() throws IOException, InterruptedException{
		PageFactory.initElements(driver, this);
	}
	
	public void passFirstName(String nameFirst){
		
		firstName.sendKeys(nameFirst);
		
	}
	
	public void passLastName(String nameLast)
	{
		
		lastName.sendKeys(nameLast);
		
	}
	
		
	public void passPhoneNo(String phoneNumber)
	{
		
		phoneNo.sendKeys(phoneNumber);
		
	}
	
	public void passEmailID(String EmailId)
	{
		
		emailId.sendKeys(EmailId);
		
	}
	

	public void passCompanyName(String CompanyName)
	{
		
		companyName.sendKeys(CompanyName);
		
	}
	
	public void passSubject(String Subject)
	{
		
		subject.sendKeys(Subject);
		
	}

	public void passMessage(String Message)
	{
		
		message.sendKeys(Message);
		
	}
	
	public void clickOnSubmit()
	{
		
		submit.click();
		
	}
	
	public String validateContactUsPageTitile(){
		
		return driver.getTitle();
	}
	
	public String getTextFromAlertMessage() throws InterruptedException{
		Thread.sleep(4000);
		return alertMessage.getText();
		
	}
	
	public String getTextFromValidationMessage() throws InterruptedException{
		Thread.sleep(4000);
		return validationMessage.getText();
		
	}
	
	public String validateThankYouPageTitle() throws InterruptedException{
		Thread.sleep(1000);
		return driver.getTitle();
		
	}
	
}


