package com.torenzosite.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.AssertJUnit;
import java.io.IOException;
import static com.torenzosite.qa.util.TestUtil.title;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.torenzosite.qa.base.TestBase;
import com.torenzosite.qa.pages.FeaturesPage;
import com.torenzosite.qa.pages.HomePage;
import com.torenzosite.qa.pages.TorenzoPOSPage;
import com.torenzosite.qa.pages.TryTorenzoForFreePage;
@Listeners(com.torenzosite.qa.listener.Listener.class)
public class HomePageTest extends TestBase{
	
	HomePage homePage;

	TryTorenzoForFreePage tryTorenzoForFreePage;
		
	public HomePageTest() throws IOException, InterruptedException {
		super();
		
	}

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException{
		
		initialization();
		homePage = new HomePage();
		tryTorenzoForFreePage = new TryTorenzoForFreePage();
		
	} 
	
	@Test(priority=1)
	public void verifyHomePageTitle(){
			
		System.out.println("Title==>" +	homePage.validateHomePageTitle());
		Assert.assertEquals(homePage.validateHomePageTitle(), "Mobile POS Software for Businesses, Point of Sale Hardware, Retail Management Systems - Detroit, Ann Arbor, Warren | Torenzo", "Torenzo titile not found");
		 		
	}
	
	@Test(priority=2)
	public void verifyEmailAddreeField() throws IOException{
		
		homePage.passEmailAddress("sachin.patiluk@gmail.com");		
		homePage.ClickHereOnToTryTorenzoForFree();
		System.out.println("Title page ==>"+title);
		Assert.assertEquals(title, "Thank You! - Detroit, Ann Arbor, Warren | Torenzo", "After entering valid Email ID IT's not navigating Succefull page");
		
	}
	
	@Test(priority=3)
	public void verifyWithEmptyEmailAddreeField() throws IOException, InterruptedException{
		
		System.out.println("Checking alert message and validation as keeping With Empty Email Addree Field ");
		homePage.passEmailAddress("");		
		homePage.ClickHereOnToTryTorenzoForFree();
		System.out.println("AlertMessage with empty email id ==>"+tryTorenzoForFreePage.getTextFromAlertMessage());
		System.out.println("validation message ==>"+tryTorenzoForFreePage.getTextFromValidationMessage());		
		Assert.assertEquals(tryTorenzoForFreePage.getTextFromValidationMessage(), "This field is required.", "Alert Message is missing with empty email id");
		Assert.assertEquals(tryTorenzoForFreePage.getTextFromAlertMessage(), "There was a problem with your submission. Errors have been highlighted below.","Validation message is missing with empty email id");
		
	}
	
	
	@Test(priority=4)
	public void verifyWithInvalidEmailAddreeField() throws IOException, InterruptedException{
		System.out.println("Checking alert message and validation as keeping With Envalid Email Addree Field ");
		homePage.passEmailAddress("sachini1234");		
		homePage.ClickHereOnToTryTorenzoForFree();
		System.out.println("AlertMessage with empty email id ==>"+tryTorenzoForFreePage.getTextFromAlertMessage());
		System.out.println("validation message ==>"+tryTorenzoForFreePage.getTextFromValidationMessage());		
		Assert.assertEquals(tryTorenzoForFreePage.getTextFromValidationMessage(), "Please enter a valid email address.", "Alert Message is missing with invalid email id");
		Assert.assertEquals(tryTorenzoForFreePage.getTextFromAlertMessage(), "There was a problem with your submission. Errors have been highlighted below.","Validation message is missing with inavalid email id");
		
	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
