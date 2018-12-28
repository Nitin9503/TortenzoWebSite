package com.torenzosite.qa.testcases;

import org.testng.annotations.AfterMethod;
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
import com.torenzosite.qa.pages.FeaturesPage;
import com.torenzosite.qa.pages.HomePage;
import com.torenzosite.qa.pages.TorenzoPOSPage;
@Listeners(com.torenzosite.qa.listener.Listener.class)
public class TorenzoPOSPageTest extends TestBase {

	HomePage homePage;
	TorenzoPOSPage torenzoPOSPage;  
	
	public TorenzoPOSPageTest() throws IOException, InterruptedException {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException{
		
		initialization();
		homePage = new HomePage();
		torenzoPOSPage = new TorenzoPOSPage();
		
	} 
	
	@Test(priority=10)
	public void verifyHomePageTitle(){
			
		System.out.println("Title==>" +	homePage.validateHomePageTitle());
		Assert.assertEquals(homePage.validateHomePageTitle(), "Mobile POS Software for Businesses, Point of Sale Hardware, Retail Management Systems - Detroit, Ann Arbor, Warren | Torenzo", "Torenzo titile not found");
		 		
	}
	
	@Test(priority=11)
	public void verifyTextFromTorenzoPOSPage() throws IOException, InterruptedException{
		torenzoPOSPage=homePage.clickOnTorenzoPOS();
		Thread.sleep(3000);
		System.out.println("TextFromTorenzoPOSPage ==>" +torenzoPOSPage.validatetextFromTorenzoPOSPage());
		Assert.assertEquals(torenzoPOSPage.validateTorenzoPOSPageTitle(), "Mobile POS Software for Businesses, Point of Sale Hardware, Retail Management Systems - Detroit, Ann Arbor, Warren | Torenzo", "Torenzo titile not found");		 
		 System.out.println("Title of torenzopos==>" +torenzoPOSPage.validateTorenzoPOSPageTitle());
	
		System.out.println("hello1");
		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
}
