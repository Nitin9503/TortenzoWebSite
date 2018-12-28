package com.torenzosite.qa.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.torenzosite.qa.base.TestBase;
import com.torenzosite.qa.pages.ContactUsPage;
import com.torenzosite.qa.pages.FeaturesPage;
import com.torenzosite.qa.pages.HomePage;
import com.torenzosite.qa.pages.PricingPage;
import com.torenzosite.qa.pages.TorenzoPOSPage;
import com.torenzosite.qa.util.TestUtil;

@Listeners(com.torenzosite.qa.listener.Listener.class)
public class PricingPageTest extends TestBase {

	
	HomePage homePage;
	PricingPage pricingPage;
	ContactUsPage contactUsPage;
	
	public PricingPageTest() throws IOException, InterruptedException {
		super();
			}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException{
		
		initialization();
		homePage = new HomePage();	
		pricingPage = new PricingPage();
		contactUsPage =new ContactUsPage();
		
	} 	

	@Test(priority=27)
	public void verifyHomePageTitle(){
			
		System.out.println("Title==>" +	homePage.validateHomePageTitle());
		Assert.assertEquals(homePage.validateHomePageTitle(), "Mobile POS Software for Businesses, Point of Sale Hardware, Retail Management Systems - Detroit, Ann Arbor, Warren | Torenzo", "Torenzo titile not found");		 
		
	}
	
	@Test(priority=28)
	public void verifyPricingPageTitle() throws IOException, InterruptedException{
		pricingPage = homePage.clickOnPricing();
		Thread.sleep(3000);
		System.out.println("Title of pricingPage ==>" +	pricingPage.validatePricingPageTitle());
		Assert.assertEquals(pricingPage.validatePricingPageTitle(), "Pricing - Detroit, Ann Arbor, Warren | Torenzo", "Pricing page titile not found");
		TestUtil.scrollUpByPixel(500);
		Thread.sleep(3000);
		contactUsPage = pricingPage.clickOnTryTorenzoForFree();
		Thread.sleep(3000);
		System.out.println("Title of Contact Us Page ==>" +contactUsPage.validateContactUsPageTitile());
		Assert.assertEquals(contactUsPage.validateContactUsPageTitile(), "Pricing - Detroit, Ann Arbor, Warren | Torenzo", "Contact us page not foubd upon clicking on TryTorenzoForFree");			
		System.out.println("Done");
		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
