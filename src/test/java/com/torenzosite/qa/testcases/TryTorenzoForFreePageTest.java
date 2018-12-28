package com.torenzosite.qa.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;

import static com.torenzosite.qa.pages.TryTorenzoForFreePage.phoneNo;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.torenzosite.qa.base.GridChromeTest;
import com.torenzosite.qa.base.TestBase;
import com.torenzosite.qa.pages.ContactUsPage;
import com.torenzosite.qa.pages.HardwarePage;
import com.torenzosite.qa.pages.HomePage;
import com.torenzosite.qa.pages.TryTorenzoForFreePage;
import com.torenzosite.qa.util.TestUtil;
import com.torenzosite.qa.util.XlsReader;
@Listeners(com.torenzosite.qa.listener.Listener.class)
public class TryTorenzoForFreePageTest extends TestBase {
	
	HomePage homePage;
	TryTorenzoForFreePage tryTorenzoForFreePage;
	ContactUsPage contactUsPage;
	 
	  Actions action;
	   
	public TryTorenzoForFreePageTest() throws IOException, InterruptedException {
		super();
		
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException{
			
		String broweserName = prop.getProperty("browser");
	if (broweserName.equals("mobileChrome")){
			
			System.out.println("Testing WebSite on Anddroid Emulator");
			initialization();
			homePage = new HomePage();	
			tryTorenzoForFreePage = new TryTorenzoForFreePage();
			contactUsPage =new ContactUsPage(); 
		}
		else{
			
			initialization();
			homePage = new HomePage();	
			tryTorenzoForFreePage = new TryTorenzoForFreePage();
			contactUsPage =new ContactUsPage(); 
			
		}				
		
	} 
	
	@Test(priority=29)
	public void verifyHomePageTitle(){
        // below xpath for image of torenzo logo 
	
		System.out.println("Title==>" +	homePage.validateHomePageTitle());
		Assert.assertEquals(homePage.validateHomePageTitle(), "Mobile POS Software for Businesses, Point of Sale Hardware, Retail Management Systems - Detroit, Ann Arbor, Warren | Torenzo", "Torenzo titile not found");		 
		
	}
	
	@Test(priority=30)
	public void clickOnTryTorenzoForFreeAndFillForm() throws IOException, InterruptedException{
			
		XlsReader reader = new XlsReader("E:\\SeleniumWorkSpace\\torenzowebsite\\TorenzoWebSite\\src\\main\\java\\com\\torenzosite\\qa\\testdata\\TorenzoWorkBook.xlsx");
		   int rowCount=reader.getRowCount("Sheet1");
		   for(int rowNum=2; rowNum<=rowCount; rowNum++)
		   {
			   Thread.sleep(4000);
				tryTorenzoForFreePage = homePage.clickOnTryTorenzoForFree();
				Thread.sleep(2000);
		       String FirstName = reader.getCellData("Sheet1", "First Name", rowNum); 
		       System.out.println(FirstName);
		       
		       String LastName = reader.getCellData("Sheet1", "Last Name", rowNum);
		          System.out.println(LastName);
		          
		          String BussinessName = reader.getCellData("Sheet1", "Bussiness Name", rowNum);
		           System.out.println(BussinessName);
		          
		          String State = reader.getCellData("Sheet1", "State", rowNum);
		          System.out.println(State);
		          
		          String Phone  = reader.getCellData("Sheet1", "Phone", rowNum);
		          System.out.println(Phone);
		          
		          String Email = reader.getCellData("Sheet1", "Email", rowNum);
		          System.out.println(Email);
		                   
		          System.out.println("Title==>" +tryTorenzoForFreePage.validateTryTorenzoForFree());
					Assert.assertEquals(tryTorenzoForFreePage.validateTryTorenzoForFree(), "Try Torenzo for FREE today", "Try Torenzo for FREE today page not found");		 	
					driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);		
					tryTorenzoForFreePage.passFirstName(FirstName);			
					tryTorenzoForFreePage.passLastName(LastName);			
					tryTorenzoForFreePage.passBussiness(BussinessName);		
					Select drpCountry = new Select(driver.findElement(By.id("input_6_7")));
					drpCountry.selectByVisibleText(State);
					Thread.sleep(2000);
					JavascriptExecutor jse = (JavascriptExecutor)driver;
					System.out.println("Phone==>" +Phone);
					
					System.out.println("rowNum==>" +rowNum);
					if(rowNum==3 || rowNum==4){
						driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);		
						jse.executeScript("arguments[0].value= '';", phoneNo);	
						
					}
					else{
						driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);		
						jse.executeScript("arguments[0].value= '(222)555-4545';", phoneNo);	
					}				
					tryTorenzoForFreePage.passEmailID(Email);			
					tryTorenzoForFreePage.clickOnSubmit();
					Thread.sleep(3000);
					if(rowNum==2){
						Thread.sleep(3000);
						Assert.assertEquals(contactUsPage.validateThankYouPageTitle(), "Thank You! - Detroit, Ann Arbor, Warren | Torenzo", "Thank You Page Title not found after failing form and clicking on Submit");						   
						
					}
					else if(rowNum==3 || rowNum==5 || rowNum==6){
						Thread.sleep(3000);
						System.out.println("Alert Message ==>" +contactUsPage.getTextFromAlertMessage());
						Assert.assertEquals(contactUsPage.getTextFromAlertMessage(), "There was a problem with your submission. Errors have been highlighted below.","Validation message is missing as keeping all field empty");			
						System.out.println("Done");
						System.out.println("Validation Message ==>" +contactUsPage.getTextFromValidationMessage());
						Assert.assertEquals(contactUsPage.getTextFromValidationMessage(), "This field is required.", "Validation message is missing upon clicking on Submit with empty data");			
						System.out.println("Done");
						tryTorenzoForFreePage.clickOnClose();
					}
					
				
					else if(rowNum==7){
						
						System.out.println("Alert Message ==>" +contactUsPage.getTextFromAlertMessage());
						Assert.assertEquals(contactUsPage.getTextFromAlertMessage(), "There was a problem with your submission. Errors have been highlighted below.","Validation message is missing as keeping all field empty");			
						System.out.println("Done");
						System.out.println("Validation Message ==>" +contactUsPage.getTextFromValidationMessage());
						Assert.assertEquals(contactUsPage.getTextFromValidationMessage(), "Please enter a valid email address.", "Validation message is missing upon clicking on Submit with empty email id");			
						System.out.println("Done");	
					}
						
					driver.navigate().refresh();
					System.out.println("	===>>>	TryTorenzoForFreePageTest class Done <====");				
		 
		   }				  
		   
		 }
	

	@AfterMethod
	public void tearDown(){
		
		String broweserName = prop.getProperty("browser");	
		if (broweserName.equals("mobileChrome")){
			
			System.out.println("Testing WebSite on Anddroid Emulator");
		}
		else{
			driver.quit();
			
		}
	
	}
	
	
}





















/*	
	@Test(priority=27)
	public void closeTheForm() throws IOException, InterruptedException{
		Thread.sleep(2000);
		tryTorenzoForFreePage = homePage.clickOnTryTorenzoForFree();
		Thread.sleep(2000);
		System.out.println("Title==>" +tryTorenzoForFreePage.validateTryTorenzoForFree());
		Assert.assertEquals(tryTorenzoForFreePage.validateTryTorenzoForFree(), "Try Torenzo for FREE today", "Try Torenzo for FREE today page not found");		 		
		tryTorenzoForFreePage.clickOnClose();
		System.out.println("Done");
	
	}
		*/
		
	
	
	/*@Test(priority=23)
	public void fillFormWithEmptyData() throws IOException, InterruptedException{
		Thread.sleep(2000);
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
		System.out.println("Alert Message ==>" +contactUsPage.getTextFromAlertMessage());
		Assert.assertEquals(contactUsPage.getTextFromAlertMessage(), "There was a problem with your submission. Errors have been highlighted below.","Validation message is missing as keeping all field empty");			
		System.out.println("Done");
		System.out.println("Validation Message ==>" +contactUsPage.getTextFromValidationMessage());
		Assert.assertEquals(contactUsPage.getTextFromValidationMessage(), "This field is required.", "Validation message is missing upon clicking on Submit with empty data");			
		System.out.println("Done");
		
		
		

		
	}
	
	@Test(priority=24)
	public void fillFormWithEmptyPhoneNumber() throws IOException, InterruptedException{
		Thread.sleep(2000);
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
		jse.executeScript("arguments[0].value='';", phoneNo);			
		tryTorenzoForFreePage.passEmailID("sachin.patil.uk@gmail.com");
		tryTorenzoForFreePage.clickOnSubmit();		
		System.out.println("Alert Message ==>" +contactUsPage.getTextFromAlertMessage());
		Assert.assertEquals(contactUsPage.getTextFromAlertMessage(), "There was a problem with your submission. Errors have been highlighted below.","Validation message is missing as keeping all field empty");			
		System.out.println("Done");
		System.out.println("Validation Message ==>" +contactUsPage.getTextFromValidationMessage());
		Assert.assertEquals(contactUsPage.getTextFromValidationMessage(), "This field is required.", "Validation message is missing upon clicking on Submit with empty data");			
		System.out.println("Done");
		
	}
	
	@Test(priority=25)
	public void fillFormWithEmptyEmaildId() throws IOException, InterruptedException{
		Thread.sleep(2000);
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
		System.out.println("Alert Message ==>" +contactUsPage.getTextFromAlertMessage());
		Assert.assertEquals(contactUsPage.getTextFromAlertMessage(), "There was a problem with your submission. Errors have been highlighted below.","Validation message is missing as keeping all field empty");			
		System.out.println("Done");
		System.out.println("Validation Message ==>" +contactUsPage.getTextFromValidationMessage());
		Assert.assertEquals(contactUsPage.getTextFromValidationMessage(), "This field is required.", "Validation message is missing upon clicking on Submit with empty data");			
		System.out.println("Done");
	
	}
	
	@Test(priority=26)
	public void fillFormWithEmptyBussinesName() throws IOException, InterruptedException{
		Thread.sleep(2000);
		tryTorenzoForFreePage = homePage.clickOnTryTorenzoForFree();
		Thread.sleep(2000);
		System.out.println("Title==>" +tryTorenzoForFreePage.validateTryTorenzoForFree());
		Assert.assertEquals(tryTorenzoForFreePage.validateTryTorenzoForFree(), "Try Torenzo for FREE today", "Try Torenzo for FREE today page not found");		 	
		tryTorenzoForFreePage.passFirstName("Sachin");
		tryTorenzoForFreePage.passLastName("Patil");
		tryTorenzoForFreePage.passBussiness("");	
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
	
	@Test(priority=27)
	public void closeTheForm() throws IOException, InterruptedException{
		Thread.sleep(2000);
		tryTorenzoForFreePage = homePage.clickOnTryTorenzoForFree();
		Thread.sleep(2000);
		System.out.println("Title==>" +tryTorenzoForFreePage.validateTryTorenzoForFree());
		Assert.assertEquals(tryTorenzoForFreePage.validateTryTorenzoForFree(), "Try Torenzo for FREE today", "Try Torenzo for FREE today page not found");		 		
	c
		System.out.println("Done");
	
	}*/
	

	/*@AfterMethod
	public void tearDown(){
		driver.quit();
	}*/







