package com.torenzosite.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import static com.torenzosite.qa.pages.FeaturesPage.tryTorenzoForFree;
import static com.torenzosite.qa.pages.TryTorenzoForFreePage.phoneNo;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.torenzosite.qa.base.TestBase;
import com.torenzosite.qa.pages.ContactUsPage;
import com.torenzosite.qa.pages.FeaturesPage;
import com.torenzosite.qa.pages.HomePage;
import com.torenzosite.qa.pages.PricingPage;
import com.torenzosite.qa.pages.TryTorenzoForFreePage;
import com.torenzosite.qa.util.TestUtil;
@Listeners(com.torenzosite.qa.listener.Listener.class)
public class FeaturePageTest extends TestBase{
	
	HomePage homePage;
	FeaturesPage featuresPage;
	TryTorenzoForFreePage tryTorenzoForFreePage;
	ContactUsPage contactUsPage;
	
	public FeaturePageTest() throws IOException, InterruptedException {
		super();
		
	}
		
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException{
		
		initialization();
		homePage = new HomePage();	
		featuresPage = new FeaturesPage();
		tryTorenzoForFreePage =new TryTorenzoForFreePage ();
		contactUsPage =new ContactUsPage();
	} 	
		
	@Test(priority=12)
	public void verifyHomePageTitle(){
			
		System.out.println("Title==>" +	homePage.validateHomePageTitle());
		Assert.assertEquals(homePage.validateHomePageTitle(), "Mobile POS Software for Businesses, Point of Sale Hardware, Retail Management Systems - Detroit, Ann Arbor, Warren | Torenzo", "Torenzo titile not found");		 
		
	}
	
	@Test(priority=13)
	public void verifyFeaturesPageTitle() throws IOException, InterruptedException{
		featuresPage = homePage.clickOnFeatures();
		Assert.assertEquals(featuresPage.validateFeaturesPageTitle(), "Mobile POS Software for Businesses, Point of Sale Hardware, Retail Management Systems - Detroit, Ann Arbor, Warren | Torenzo", "FeaturePage titile not found");		 
		 System.out.println("Title of torenzopos==>" +featuresPage.validateFeaturesPageTitle());
		 System.out.println("Sell, Manage , Grow, Report");
		 Thread.sleep(1000);
		 featuresPage.clickOnSell();
		 System.out.println("Contain under Sell tab ==>" +featuresPage.validatePointsOfSaleTitle());
		 Assert.assertEquals(featuresPage.validatePointsOfSaleTitle(), "POINT OF SALE", "POINT OF SALE title not found");		 
		 Thread.sleep(1000);
		 featuresPage.clickOnManage();
		 System.out.println("Contain under Manage tab ==>" +featuresPage.validateProductsTitle());
		 Assert.assertEquals(featuresPage.validateProductsTitle(), "PRODUCTS", "PRODUCTS title not found");		 
		 Thread.sleep(1000);
		 featuresPage.clickOnReport();
		 System.out.println("Contain under Report tab ==>" +featuresPage.validateCustomReportsTitle());
		 Assert.assertEquals(featuresPage.validateCustomReportsTitle(), "CUSTOM REPORTS", "CUSTOM REPORTS title not found");		 
		System.out.println("value==>" +featuresPage.getTextFromGrow());
		 Thread.sleep(1000);
		featuresPage.clickOnGrow();
		 System.out.println("Contain under Report tab ==>" +featuresPage.validateScalabilityTitle());
		 Assert.assertEquals(featuresPage.validateScalabilityTitle(), "SCALABILITY", "SCALABILITY title not found");		 
	
	}
		
	@Test(priority=14)
	public void verifyTryTorenzoForFree() throws IOException, InterruptedException{
		featuresPage = homePage.clickOnFeatures();
		Thread.sleep(3000);
		TestUtil.scrollUpByPixel(500);
		tryTorenzoForFree.click();				
		/*JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element =driver.findElement(By.xpath("//a[@class='btn btn-primary btn-lg' and text()='Try Torenzo For Free']"));		
		js.executeScript("arguments[0].scrollIntoView()", element);
	    element.click();	   */
	    Thread.sleep(3000);
	    System.out.println("Title of Contact US page=>" + tryTorenzoForFreePage.validateTryTorenzoForFree());	
	    
		Assert.assertEquals(tryTorenzoForFreePage.validateTryTorenzoForFree(), "Try Torenzo for FREE today", "Try Torenzo for FREE today window not found upon clicking on Try Torenzo for FREE today from Feature page");	
	}
	
	@Test(priority=15)
	public void closeToForm() throws IOException, InterruptedException{
		
		featuresPage = homePage.clickOnFeatures();
		Thread.sleep(3000);
		TestUtil.scrollUpByPixel(500);
		tryTorenzoForFreePage = featuresPage.ClickOnTryTorenzoForFreePage();
		tryTorenzoForFreePage.clickOnClose();
		
	}
	
	
	@Test(priority=16)
	public void fillFormFromFeaturePage() throws IOException, InterruptedException{
		featuresPage = homePage.clickOnFeatures();
		Thread.sleep(3000);
		TestUtil.scrollUpByPixel(500);
		tryTorenzoForFreePage = featuresPage.ClickOnTryTorenzoForFreePage();	
		Thread.sleep(3000);
	    System.out.println("Title of Contact US page=>" + tryTorenzoForFreePage.validateTryTorenzoForFree());	    
		Assert.assertEquals(tryTorenzoForFreePage.validateTryTorenzoForFree(), "Try Torenzo for FREE today", "Try Torenzo for FREE today window not found upon clicking on Try Torenzo for FREE today from Feature page");
		tryTorenzoForFreePage.passFirstName("Sachin");
		tryTorenzoForFreePage.passLastName("Patil");
		tryTorenzoForFreePage.passBussiness("Restarant");
		Select drpCountry = new Select(driver.findElement(By.id("input_6_7")));
		drpCountry.selectByVisibleText("Andorra");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].value='(222)555-4545';", phoneNo);	
		tryTorenzoForFreePage.passEmailID("sachin.patil.uk@gmail.com");
		tryTorenzoForFreePage.clickOnSubmit();
		Thread.sleep(3000);
		
		System.out.println("Sucessfull Message ==>" +contactUsPage.validateThankYouPageTitle());
		Assert.assertEquals(contactUsPage.validateThankYouPageTitle(), "Thank You! - Detroit, Ann Arbor, Warren | Torenzo", "Thank You Page Title not found after failing form and clicking on Submit");			
		System.out.println("Done");
	
	}
	
	@Test(priority=17)
	public void fillFormWithEmptyData() throws IOException, InterruptedException{
		Thread.sleep(2000);
		featuresPage = homePage.clickOnFeatures();
		Thread.sleep(3000);
		TestUtil.scrollUpByPixel(500);
		tryTorenzoForFreePage = homePage.clickOnTryTorenzoForFree();
		Thread.sleep(2000);
		System.out.println("Title==>" +tryTorenzoForFreePage.validateTryTorenzoForFree());
		Assert.assertEquals(tryTorenzoForFreePage.validateTryTorenzoForFree(), "Try Torenzo for FREE today", "Try Torenzo for FREE today page not found");		 	
		tryTorenzoForFreePage.passFirstName("");
		tryTorenzoForFreePage.passLastName("");
		tryTorenzoForFreePage.passBussiness("");	
		Select drpCountry = new Select(driver.findElement(By.id("input_6_7")));
		drpCountry.selectByVisibleText("Andorra");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].value='';", phoneNo);			
		tryTorenzoForFreePage.passEmailID("");
		tryTorenzoForFreePage.clickOnSubmit();	
		Thread.sleep(3000);
		System.out.println("Alert Message ==>" +contactUsPage.getTextFromAlertMessage());
		Assert.assertEquals(contactUsPage.getTextFromAlertMessage(), "There was a problem with your submission. Errors have been highlighted below.","Validation message is missing as keeping all field empty");			
		System.out.println("Done");
		System.out.println("Validation Message ==>" +contactUsPage.getTextFromValidationMessage());
		Assert.assertEquals(contactUsPage.getTextFromValidationMessage(), "This field is required.", "Validation message is missing upon clicking on Submit with empty data");			
		System.out.println("Done");

		
	}
	
	@Test(priority=18)
	public void fillFormWithEmptyPhoneNumber() throws IOException, InterruptedException{
		Thread.sleep(2000);
		featuresPage = homePage.clickOnFeatures();
		Thread.sleep(3000);
		TestUtil.scrollUpByPixel(500);
		tryTorenzoForFreePage = homePage.clickOnTryTorenzoForFree();
		Thread.sleep(2000);
		System.out.println("Title==>" +tryTorenzoForFreePage.validateTryTorenzoForFree());
		Assert.assertEquals(tryTorenzoForFreePage.validateTryTorenzoForFree(), "Try Torenzo for FREE today", "Try Torenzo for FREE today page not found");		 	
		Thread.sleep(3000);
		tryTorenzoForFreePage.passFirstName("Sachin");
		tryTorenzoForFreePage.passLastName("Patil");
		tryTorenzoForFreePage.passBussiness("Restarant");	
		Select drpCountry = new Select(driver.findElement(By.id("input_6_7")));
		drpCountry.selectByVisibleText("Andorra");
		//Passing phone number using javascript 
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].value='';", phoneNo);			
		tryTorenzoForFreePage.passEmailID("sachin.patil.uk@gmail.com");
		tryTorenzoForFreePage.clickOnSubmit();
		Thread.sleep(2000);
		System.out.println("Alert Message ==>" +contactUsPage.getTextFromAlertMessage());
		Assert.assertEquals(contactUsPage.getTextFromAlertMessage(), "There was a problem with your submission. Errors have been highlighted below.","Validation message is missing as keeping all field empty");			
		System.out.println("Done");
		System.out.println("Validation Message ==>" +contactUsPage.getTextFromValidationMessage());
		Assert.assertEquals(contactUsPage.getTextFromValidationMessage(), "This field is required.", "Validation message is missing upon clicking on Submit with empty data");			
		System.out.println("Done");
		
	}
	
	@Test(priority=19)
	public void fillFormWithEmptyEmaildId() throws IOException, InterruptedException{
		Thread.sleep(2000);
		featuresPage = homePage.clickOnFeatures();
		Thread.sleep(3000);
		TestUtil.scrollUpByPixel(500);
		tryTorenzoForFreePage = homePage.clickOnTryTorenzoForFree();
		Thread.sleep(2000);
		System.out.println("Title==>" +tryTorenzoForFreePage.validateTryTorenzoForFree());
		Assert.assertEquals(tryTorenzoForFreePage.validateTryTorenzoForFree(), "Try Torenzo for FREE today", "Try Torenzo for FREE today page not found");		 	
		tryTorenzoForFreePage.passFirstName("Sachin");
		tryTorenzoForFreePage.passLastName("Patil");
		tryTorenzoForFreePage.passBussiness("Restarant");	
		Select drpCountry = new Select(driver.findElement(By.id("input_6_7")));
		drpCountry.selectByVisibleText("Andorra");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].value='(222)555-4545';", phoneNo);			
		tryTorenzoForFreePage.passEmailID("");
		tryTorenzoForFreePage.clickOnSubmit();	
		Thread.sleep(5000);
		System.out.println("Alert Message ==>" +contactUsPage.getTextFromAlertMessage());
		Assert.assertEquals(contactUsPage.getTextFromAlertMessage(), "There was a problem with your submission. Errors have been highlighted below.","Validation message is missing as keeping all field empty");			
		System.out.println("Done");
		System.out.println("Validation Message ==>" +contactUsPage.getTextFromValidationMessage());
		Assert.assertEquals(contactUsPage.getTextFromValidationMessage(), "This field is required.", "Validation message is missing upon clicking on Submit with empty data");			
		System.out.println("Done");
	
	}
	
	@Test(priority=20)
	public void fillFormWithEmptyBussinesName() throws IOException, InterruptedException{
		Thread.sleep(2000);
		featuresPage = homePage.clickOnFeatures();
		Thread.sleep(3000);
		TestUtil.scrollUpByPixel(500);
		tryTorenzoForFreePage = homePage.clickOnTryTorenzoForFree();
		Thread.sleep(2000);
		System.out.println("Title==>" +tryTorenzoForFreePage.validateTryTorenzoForFree());
		Assert.assertEquals(tryTorenzoForFreePage.validateTryTorenzoForFree(), "Try Torenzo for FREE today", "Try Torenzo for FREE today page not found");		 	
		tryTorenzoForFreePage.passFirstName("Sachin");
		tryTorenzoForFreePage.passLastName("Patil");
		//tryTorenzoForFreePage.passBussiness("Torenzo");	
		Select drpCountry = new Select(driver.findElement(By.id("input_6_7")));
		drpCountry.selectByVisibleText("Andorra");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].value='(222)555-4545';", phoneNo);			
		tryTorenzoForFreePage.passEmailID("");
		tryTorenzoForFreePage.clickOnSubmit();		
		System.out.println("Alert Message ==>" +contactUsPage.getTextFromAlertMessage());
		Assert.assertEquals(contactUsPage.getTextFromAlertMessage(), "There was a problem with your submission. Errors have been highlighted below.","Validation message is missing as keeping all field empty");			
		System.out.println("Done");
		System.out.println("Validation Message ==>" +contactUsPage.getTextFromValidationMessage());
		Assert.assertEquals(contactUsPage.getTextFromValidationMessage(), "This field is required.", "Validation message is missing upon clicking on Submit with empty data");			
		System.out.println("Done");
	
	}
	

	@Test(priority=21)
	public void fillFormWithIncorrectEmailId() throws IOException, InterruptedException{
		Thread.sleep(2000);
		featuresPage = homePage.clickOnFeatures();
		Thread.sleep(3000);
		TestUtil.scrollUpByPixel(500);
		tryTorenzoForFreePage = homePage.clickOnTryTorenzoForFree();
		Thread.sleep(2000);
		System.out.println("Title==>" +tryTorenzoForFreePage.validateTryTorenzoForFree());
		Assert.assertEquals(tryTorenzoForFreePage.validateTryTorenzoForFree(), "Try Torenzo for FREE today", "Try Torenzo for FREE today page not found");		 	
		tryTorenzoForFreePage.passFirstName("Sachin");
		tryTorenzoForFreePage.passLastName("Patil");
		tryTorenzoForFreePage.passBussiness("Torenzo");	
		Select drpCountry = new Select(driver.findElement(By.id("input_6_7")));
		drpCountry.selectByVisibleText("Andorra");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].value='(222)555-4545';", phoneNo);			
		tryTorenzoForFreePage.passEmailID("xyz@@123");
		tryTorenzoForFreePage.clickOnSubmit();		
		System.out.println("Alert Message ==>" +contactUsPage.getTextFromAlertMessage());
		Assert.assertEquals(contactUsPage.getTextFromAlertMessage(), "There was a problem with your submission. Errors have been highlighted below.","Validation message is missing as keeping all field empty");			
		System.out.println("Done");
		System.out.println("Validation Message ==>" +contactUsPage.getTextFromValidationMessage());
		Assert.assertEquals(contactUsPage.getTextFromValidationMessage(), "Please enter a valid email address.", "Validation message is missing upon clicking on Submit with empty data");			
		System.out.println("Done");
	
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
