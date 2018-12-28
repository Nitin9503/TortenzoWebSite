
package com.torenzosite.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.torenzosite.qa.base.TestBase;

public class HardwarePage extends TestBase {


	@FindBy(xpath= "//a[@class='btn btn-primary btn-lg']")
	WebElement tryTorenzoForFree;
	
	@FindBy(xpath= "//a[text()='Contact Us Today']")
	WebElement contactUsToday;
	
	
	public HardwarePage() throws IOException, InterruptedException {
		PageFactory.initElements(driver, this);
	}
	
	public String validateHardwarePageTitle(){
		
		return driver.getTitle();
	}
	
	public ContactUsPage clickOnTryTorenzoForFree() throws IOException, InterruptedException{
		
		tryTorenzoForFree.click();
		return new ContactUsPage();
	}
	
	public ContactUsPage clickOnContactUsToday() throws IOException, InterruptedException{
		contactUsToday.click();
		return new ContactUsPage();
	}

}
