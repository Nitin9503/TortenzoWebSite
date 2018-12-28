package com.torenzosite.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.torenzosite.qa.base.TestBase;
import com.torenzosite.qa.pages.ContactUsPage;
import com.torenzosite.qa.pages.FeaturesPage;
import com.torenzosite.qa.pages.HardwarePage;
import com.torenzosite.qa.pages.HomePage;
import com.torenzosite.qa.util.TestUtil;
@Listeners(com.torenzosite.qa.listener.Listener.class)
public class HardwarePageTest extends TestBase{
	
		HomePage homePage;
		HardwarePage hardwarePage;
		ContactUsPage contactUsPage;
		
		public HardwarePageTest() throws IOException, InterruptedException{
			super();
		}
		
		@BeforeMethod
		public void setUp() throws IOException, InterruptedException{			
			initialization();
			homePage = new HomePage();	
			hardwarePage = new HardwarePage();
		    contactUsPage = new ContactUsPage();
			
		} 	
				
		@Test(priority=24)
		public void verifyHomePageTitle(){
				
			System.out.println("Title==>" +	homePage.validateHomePageTitle());
			Assert.assertEquals(homePage.validateHomePageTitle(), "Mobile POS Software for Businesses, Point of Sale Hardware, Retail Management Systems - Detroit, Ann Arbor, Warren | Torenzo", "Torenzo titile not found");		 			
		}
		
		@Test(priority=25)
		public void verifyHardwarePageTitle() throws IOException, InterruptedException{
			hardwarePage = homePage.clickOnHardware();
			System.out.println("Title==>" +hardwarePage.validateHardwarePageTitle());
			Assert.assertEquals(hardwarePage.validateHardwarePageTitle(), "Mobile POS Software, POS Hardware - Detroit, Ann Arbor, Warren | Torenzo", "Hardware Page titile not found");		 		
			//Upon clicking on TryTorenzoForFree from hardware Page its navigating to conatact page instead of FORM
			contactUsPage =hardwarePage.clickOnTryTorenzoForFree();
			Thread.sleep(4000);
			System.out.println("Title of Contact US page=>" +contactUsPage.validateContactUsPageTitile());	
			Assert.assertEquals(contactUsPage.validateContactUsPageTitile(), "Contact Us - Detroit, Ann Arbor, Warren | Torenzo", "Contact us Page is not displayed upon clicking on Contact Us Today");
		
		}
		
		@Test(priority=26)
		public void  verifyContactUsPage() throws InterruptedException, IOException{
			hardwarePage = homePage.clickOnHardware();
		//	JavascriptExecutor js = (JavascriptExecutor) driver;			
			WebElement element = driver.findElement(By.xpath("//a[text()='Contact Us Today']"));		
			//contactUsPage = hardwarePage.clickOnContactUsToday()
		//	js.executeScript("arguments[0].scrollIntoView(true);",element );
			TestUtil.scrollUpHorizontalORVIsibilityOFElement(element);
			element.click();
			Thread.sleep(4000);
			System.out.println("Title of Contact US page=>" +contactUsPage.validateContactUsPageTitile());	
			Assert.assertEquals(contactUsPage.validateContactUsPageTitile(), "Contact Us - Detroit, Ann Arbor, Warren | Torenzo", "Contact us Page is not displayed upon clicking on Contact Us Today");
			
		}
		
		@AfterMethod
		public void tearDown(){
			driver.quit();
		}
		
}
