package com.torenzosite.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.torenzosite.qa.base.TestBase;

public class PricingPage extends TestBase {
	
	
	@FindBy(xpath= "//a[@class='btn btn-primary btn-lg' and text()='TRY TORENZO FOR FREE']")
	WebElement tryTorenzoForFree;
	
	public PricingPage() throws IOException, InterruptedException {
		PageFactory.initElements(driver, this);
	}

	public ContactUsPage clickOnTryTorenzoForFree() throws IOException, InterruptedException{
		tryTorenzoForFree.click();
		return new ContactUsPage();
		
	}
	
	public String validatePricingPageTitle(){
		
		return driver.getTitle();
	}

}
