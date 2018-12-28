package com.torenzosite.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.torenzosite.qa.base.TestBase;

public class TryTorenzoForFreePage extends TestBase{

	
	@FindBy(linkText= "//*[contains(text(),'Try Torenzo For Free')]")
	WebElement tryTorenzoForFree;

	@FindBy(xpath= "//*[text()='Try Torenzo for FREE today']")
	WebElement 	titleofTryTorenzoforFREEtoday;
		
	@FindBy(xpath = "//*[@id='input_6_6_3']")
	WebElement firstName;
	
	@FindBy(xpath = "//*[@id='input_6_6_6']")
	WebElement lastName;
	
	@FindBy(id = "input_6_4")
	WebElement bussiness;
	
	@FindBy(id = "input_6_7")
	WebElement country;
	
	@FindBy(id = "input_6_8")
	public static WebElement phoneNo;
	
	@FindBy(id = "input_6_2")
	WebElement emailID;
	
	@FindBy(xpath = "//div[@class='gform_footer top_label']//input[@id='gform_submit_button_6' and @type='submit' and @value='Submit']")
	WebElement submit;
	
	@FindBy(xpath = ".//*[@id='ID-NAME']/div/div/div[1]/button")
	WebElement close;
	
	//Validation and error message
	@FindBy(xpath = "//div[@class='alert alert-error']")
	WebElement alertMessage;
	
	@FindBy(xpath = "//div[@class='gfield_description validation_message']")
	WebElement validationMessage;
	
	
	public TryTorenzoForFreePage() throws IOException, InterruptedException {
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickOnTryTorenzoForFree(){
		tryTorenzoForFree.click();
		
	}
	
	public String validateTryTorenzoForFree() throws InterruptedException{
		Thread.sleep(4000);
		return titleofTryTorenzoforFREEtoday.getText();
		
	}
	
	public String getTextFromAlertMessage() throws InterruptedException{
		Thread.sleep(4000);
		return alertMessage.getText();
		
	}
	
	public String getTextFromValidationMessage() throws InterruptedException{
		Thread.sleep(4000);
		return validationMessage.getText();
		
	}
	
	
	public void passFirstName(String nameFirst){
		
		firstName.sendKeys(nameFirst);
		
	}
	
	public void passLastName(String nameLast)
	{
		
		lastName.sendKeys(nameLast);
		
	}
	
	public void passBussiness(String bussinessPass)
	{
		
		bussiness.sendKeys(bussinessPass);
		
	}
	
	public void passCountry(String bussinessPass)
	{
		
		country.sendKeys(bussinessPass);
		
	}
	
	public void passPhoneNo(String phoneNumber)
	{
		 	    
			phoneNo.sendKeys(phoneNumber);
			
		}
	
	
	
	public void passEmailID(String emailPass)
	{
		
		emailID.sendKeys(emailPass);
		
	}

	public ContactUsPage clickOnSubmit() throws IOException, InterruptedException
	{
		
		 submit.click();
		 return new ContactUsPage();
		
	}
	
	public void clickOnClose() throws IOException
	{
		
		close.click();
	
		
	}
	
	


}



/*	driver.findElement(By.xpath("//*[contains(text(),'Try Torenzo For Free')]")).click();

String  title =	driver.findElement(By.xpath("//*[text()='Try Torenzo for FREE today']")).getText();
System.out.println("title" +title);
*/