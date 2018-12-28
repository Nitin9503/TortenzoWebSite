package com.torenzosite.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.torenzosite.qa.base.TestBase;

public class LeaveUsPage extends TestBase{

	public LeaveUsPage() throws IOException, InterruptedException {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath= "//input[@type='text' and @id='input_9_9']")
	WebElement firstName;

	@FindBy(xpath= "//input[@type='text' and @id='input_9_4']")
	WebElement 	email;
		
	@FindBy(xpath = "//input[@type='text' and @id='input_9_5']")
	WebElement phoneNumber;
	
	
	@FindBy(xpath = "//textarea[@name='input_6' and @id='input_9_6']")
	WebElement message;
	
	@FindBy(xpath = "//div[@class='gform_footer top_label']//input[@id='gform_submit_button_9' and @type='submit' and @value='Submit']")
	WebElement submit;

	@FindBy(xpath = "//h3[@id='myModalLabel' and text()='Support']")
	WebElement support;

	@FindBy(xpath = ".//*[@id='msg-modal']/div/div/div[1]/button")
	WebElement close;
	
	
	

	
	public String validateLeaveUsMessageTitle(){
		
		return support.getText();
	}
	
	public void passFirstName(String nameFirstPass){
		
		firstName.sendKeys(nameFirstPass);		
	}
	
	public void passEmailID(String emailPass)
	{	
		email.sendKeys(emailPass);
		
	}
			
	public void passPhoneNo(String phoneNumberPass)
	{		
		phoneNumber.sendKeys(phoneNumberPass);
		
	}
	
	public void passMessage(String messagePass)
	{
		
		message.sendKeys(messagePass);
		
	}
	
	public void clickOnSubmit()
	{
		
		submit.click();
		
	}
	
	
	public void clickOnClose()
	{
		
		close.click();
		
	}
	
	
	
}
