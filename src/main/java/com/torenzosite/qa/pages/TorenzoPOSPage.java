package com.torenzosite.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.torenzosite.qa.base.TestBase;

public class TorenzoPOSPage extends TestBase{
	
	@FindBy(xpath="//h2[@class='font-36 text-center' ]//strong[text()='A Point of Sale Solution for the Modern Restaurant ']")
    WebElement 	textFromTorenzoPOSPage;
	
/*	@FindBy(xpath="//(@text='A Point of Sale Solution for the Modern Restaurant')")
    WebElement 	textFromTorenzoPOSPage;*/

	//Xpath=//input[@type='text']
	@FindBy(xpath = "//a[contains(text(),'POINT OF SALE']")
	WebElement PointsOfSale;
	
	public TorenzoPOSPage() throws IOException, InterruptedException {
		PageFactory.initElements(driver, this);
		
	}
	
	public String validatetextFromTorenzoPOSPage(){
		return textFromTorenzoPOSPage.getText();
	}
	public String validateTorenzoPOSPageTitle(){
		
		return driver.getTitle();
	}	
}
