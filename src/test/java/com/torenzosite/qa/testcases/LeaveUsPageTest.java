package com.torenzosite.qa.testcases;

import static com.torenzosite.qa.pages.TryTorenzoForFreePage.phoneNo;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.torenzosite.qa.base.TestBase;
import com.torenzosite.qa.pages.ContactUsPage;
import com.torenzosite.qa.pages.FeaturesPage;
import com.torenzosite.qa.pages.HomePage;
import com.torenzosite.qa.pages.LeaveUsPage;
import com.torenzosite.qa.pages.TryTorenzoForFreePage;
import com.torenzosite.qa.util.TestUtil;
import com.torenzosite.qa.util.XlsReader;
@Listeners(com.torenzosite.qa.listener.Listener.class)
public class LeaveUsPageTest extends TestBase{

	HomePage homePage;
	LeaveUsPage leaveUsPage;
	ContactUsPage contactUsPage;
	FeaturesPage featuresPage;
	TryTorenzoForFreePage tryTorenzoForFreePage;
	
	public LeaveUsPageTest() throws IOException, InterruptedException {
		super();
	
	}

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException{
		
		initialization();
		homePage = new HomePage();	
		leaveUsPage = new LeaveUsPage();
		contactUsPage =new ContactUsPage();
		featuresPage =new FeaturesPage();
		tryTorenzoForFreePage =new TryTorenzoForFreePage();
	} 
	
	@Test(priority=22)
	public void verifyHomePageTitle(){
			
		System.out.println("Title==>" +	homePage.validateHomePageTitle());
		Assert.assertEquals(homePage.validateHomePageTitle(), "Mobile POS Software for Businesses, Point of Sale Hardware, Retail Management Systems - Detroit, Ann Arbor, Warren | Torenzo", "Torenzo titile not found");		 			
	}
	
	
	@Test(priority=23)
	public void verifyLeaveUsPageTitle() throws IOException, InterruptedException{
		
		XlsReader reader = new XlsReader("E:\\SeleniumWorkSpace\\torenzowebsite\\TorenzoWebSite\\src\\main\\java\\com\\torenzosite\\qa\\testdata\\TorenzoWorkBook.xlsx");
		   int rowCount=reader.getRowCount("Sheet2");
		   for(int rowNum=2; rowNum<=rowCount; rowNum++)
		   {
			   Thread.sleep(4000);
			   leaveUsPage = homePage.ClickOnLeaveUsaMessage();
			   Thread.sleep(5000);
			   System.out.println("Title==>" +leaveUsPage.validateLeaveUsMessageTitle());
				Assert.assertEquals(leaveUsPage.validateLeaveUsMessageTitle(), "Support", "Leave Us Message Page Not not found upon clicking on Leave Us Message");		 			
			
				Thread.sleep(5000);
		       String Name = reader.getCellData("Sheet2", "Name", rowNum); 
		       System.out.println(Name);
		       
		       String Email = reader.getCellData("Sheet2", "Email", rowNum);
		          System.out.println(Email);
		          
		          String PhoneNumber = reader.getCellData("Sheet2", "Phone Number", rowNum);
		           System.out.println(PhoneNumber);
		          
		          String Message = reader.getCellData("Sheet2", "Message", rowNum);
		          System.out.println(Message);
		          Thread.sleep(2000);
		          leaveUsPage.passFirstName(Name);
		  		leaveUsPage.passEmailID(Email);
		  		leaveUsPage.passPhoneNo(PhoneNumber);
		  		leaveUsPage.passMessage(Message);
		  		leaveUsPage.clickOnSubmit();	
		  		Thread.sleep(8000);
		  		
		  		if(rowNum==2){
		  			Thread.sleep(8000);
		  		Assert.assertEquals(contactUsPage.validateThankYouPageTitle(), "Thank You! - Detroit, Ann Arbor, Warren | Torenzo", "Thank You Page Title not found after failing form and clicking on Submit");			
		  		System.out.println("Done");
		  		
		  		}
		  		else if(rowNum==3 || rowNum==4 || rowNum==5 || rowNum==6 ||rowNum==7 ){
		  			
		  			Thread.sleep(3000);
					System.out.println("Alert Message ==>" +contactUsPage.getTextFromAlertMessage());
					Assert.assertEquals(contactUsPage.getTextFromAlertMessage(), "There was a problem with your submission. Errors have been highlighted below.","Validation message is missing as keeping all field empty");			
					System.out.println("Done");
					System.out.println("Validation Message ==>" +contactUsPage.getTextFromValidationMessage());
					Assert.assertEquals(contactUsPage.getTextFromValidationMessage(), "This field is required.", "Validation message is missing upon clicking on Submit with empty data");			
					System.out.println("Done");
					leaveUsPage.clickOnClose();
		  		}
		
					else if(rowNum==8){
						Thread.sleep(8000);
						System.out.println("Alert Message ==>" +contactUsPage.getTextFromAlertMessage());
						Assert.assertEquals(contactUsPage.getTextFromAlertMessage(), "There was a problem with your submission. Errors have been highlighted below.","Validation message is missing as keeping all field empty");			
						System.out.println("Done");
						System.out.println("Validation Message ==>" +contactUsPage.getTextFromValidationMessage());
						Assert.assertEquals(contactUsPage.getTextFromValidationMessage(), "Please enter a valid email address.", "Validation message is missing upon clicking on Submit with empty email id");			
						System.out.println("Done");	
						leaveUsPage.clickOnClose();
						
					}
						
					driver.navigate().refresh();
					System.out.println("rowNum==>" +rowNum);				
		 
		   }			
			
		   driver.navigate().refresh();
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}





















/*	
			@Test(priority=13)
	public void closeToForm() throws IOException, InterruptedException{
		
		  leaveUsPage = homePage.ClickOnLeaveUsaMessage();
		
		  Thread.sleep(5000);
		   System.out.println("Title==>" +leaveUsPage.validateLeaveUsMessageTitle());
			Assert.assertEquals(leaveUsPage.validateLeaveUsMessageTitle(), "Support", "Leave Us Message Page Not not found upon clicking on Leave Us Message");		 			
		
			leaveUsPage.clickOnClose();
	}


	
	
	
}



	leaveUsPage = homePage.ClickOnLeaveUsaMessage();
		Thread.sleep(3000);
		System.out.println("Title==>" +leaveUsPage.validateLeaveUsMessageTitle());
		Assert.assertEquals(leaveUsPage.validateLeaveUsMessageTitle(), "Support", "Leave Us Message Page Not not found upon clicking on Leave Us Message");		 			
		leaveUsPage.passFirstName("Sachin");
		leaveUsPage.passEmailID("sachin.patil.uk@gmail.com");
		leaveUsPage.passPhoneNo("9552619077");
		leaveUsPage.passMessage("Hello");
		leaveUsPage.clickOnSubmit();	
		Thread.sleep(8000);
		Assert.assertEquals(contactUsPage.validateThankYouPageTitle(), "Thank You! - Detroit, Ann Arbor, Warren | Torenzo", "Thank You Page Title not found after failing form and clicking on Submit");			
		System.out.println("Done");
		}
	
	@Test(priority=14)
	public void fillFormWithEmptyDataLeaveUsMessage() throws IOException, InterruptedException{
		
		leaveUsPage = homePage.ClickOnLeaveUsaMessage();
		Thread.sleep(3000);
		System.out.println("Title==>" +leaveUsPage.validateLeaveUsMessageTitle());
		Assert.assertEquals(leaveUsPage.validateLeaveUsMessageTitle(), "Support", "Leave Us Message Page Not not found upon clicking on Leave Us Message");		 				
		leaveUsPage.clickOnSubmit();	
		System.out.println("Alert Message ==>" +contactUsPage.getTextFromAlertMessage());
		Assert.assertEquals(contactUsPage.getTextFromAlertMessage(), "There was a problem with your submission. Errors have been highlighted below.","Validation message is missing as keeping all field empty");			
		System.out.println("Done");
		System.out.println("Validation Message ==>" +contactUsPage.getTextFromValidationMessage());
		Assert.assertEquals(contactUsPage.getTextFromValidationMessage(), "This field is required.", "Validation message is missing upon clicking on Submit with empty data");			
		System.out.println("Done");
		
	}
	
	@Test(priority=15)
	public void fillFormWithEmptyName() throws IOException, InterruptedException{
		
		leaveUsPage = homePage.ClickOnLeaveUsaMessage();
		Thread.sleep(3000);
		System.out.println("Title==>" +leaveUsPage.validateLeaveUsMessageTitle());
		Assert.assertEquals(leaveUsPage.validateLeaveUsMessageTitle(), "Support", "Leave Us Message Page Not not found upon clicking on Leave Us Message");		 			
	//	leaveUsPage.passFirstName("Sachin");
		leaveUsPage.passEmailID("sachin.patil.uk@gmail.com");
		leaveUsPage.passPhoneNo("9552619077");
		leaveUsPage.passMessage("Hello");
		leaveUsPage.clickOnSubmit();	
		Thread.sleep(8000);
		System.out.println("Alert Message ==>" +contactUsPage.getTextFromAlertMessage());
		Assert.assertEquals(contactUsPage.getTextFromAlertMessage(), "There was a problem with your submission. Errors have been highlighted below.","Validation message is missing as keeping all field empty");			
		System.out.println("Done");
		System.out.println("Validation Message ==>" +contactUsPage.getTextFromValidationMessage());
		Assert.assertEquals(contactUsPage.getTextFromValidationMessage(), "This field is required.", "Validation message is missing upon clicking on Submit with empty data");			
		System.out.println("Done");
		
	}
	
	@Test(priority=16)
	public void fillFormWithEmptyEmailId() throws IOException, InterruptedException{
		
		leaveUsPage = homePage.ClickOnLeaveUsaMessage();
		Thread.sleep(3000);
		System.out.println("Title==>" +leaveUsPage.validateLeaveUsMessageTitle());
		Assert.assertEquals(leaveUsPage.validateLeaveUsMessageTitle(), "Support", "Leave Us Message Page Not not found upon clicking on Leave Us Message");		 			
		leaveUsPage.passFirstName("Sachin");
		//leaveUsPage.passEmailID("sachin.patil.uk@gmail.com");
		leaveUsPage.passPhoneNo("9552619077");
		leaveUsPage.passMessage("Hello");
		leaveUsPage.clickOnSubmit();	
		Thread.sleep(8000);
		System.out.println("Alert Message ==>" +contactUsPage.getTextFromAlertMessage());
		Assert.assertEquals(contactUsPage.getTextFromAlertMessage(), "There was a problem with your submission. Errors have been highlighted below.","Validation message is missing as keeping all field empty");			
		System.out.println("Done");
		System.out.println("Validation Message ==>" +contactUsPage.getTextFromValidationMessage());
		Assert.assertEquals(contactUsPage.getTextFromValidationMessage(), "This field is required.", "Validation message is missing upon clicking on Submit with empty data");			
		System.out.println("Done");
		
	}
	
	@Test(priority=17)
	public void fillFormWithEmptyPhoneNumber() throws IOException, InterruptedException{
		
		leaveUsPage = homePage.ClickOnLeaveUsaMessage();
		Thread.sleep(3000);
		System.out.println("Title==>" +leaveUsPage.validateLeaveUsMessageTitle());
		Assert.assertEquals(leaveUsPage.validateLeaveUsMessageTitle(), "Support", "Leave Us Message Page Not not found upon clicking on Leave Us Message");		 			
		leaveUsPage.passFirstName("Sachin");
		leaveUsPage.passEmailID("sachin.patil.uk@gmail.com");
		//leaveUsPage.passPhoneNo("9552619077");
		leaveUsPage.passMessage("Hello");
		leaveUsPage.clickOnSubmit();	
		Thread.sleep(8000);
		System.out.println("Alert Message ==>" +contactUsPage.getTextFromAlertMessage());
		Assert.assertEquals(contactUsPage.getTextFromAlertMessage(), "There was a problem with your submission. Errors have been highlighted below.","Validation message is missing as keeping all field empty");			
		System.out.println("Done");
		System.out.println("Validation Message ==>" +contactUsPage.getTextFromValidationMessage());
		Assert.assertEquals(contactUsPage.getTextFromValidationMessage(), "This field is required.", "Validation message is missing upon clicking on Submit with empty data");			
		System.out.println("Done");
		
	}
	
	
	@Test(priority=18)
	public void fillFormWithEmptyMessage() throws IOException, InterruptedException{
		
		leaveUsPage = homePage.ClickOnLeaveUsaMessage();
		Thread.sleep(3000);
		System.out.println("Title==>" +leaveUsPage.validateLeaveUsMessageTitle());
		Assert.assertEquals(leaveUsPage.validateLeaveUsMessageTitle(), "Support", "Leave Us Message Page Not not found upon clicking on Leave Us Message");		 			
		leaveUsPage.passFirstName("Sachin");
		leaveUsPage.passEmailID("sachin.patil.uk@gmail.com");
		leaveUsPage.passPhoneNo("9552619077");
	//	leaveUsPage.passMessage("Hello");
		leaveUsPage.clickOnSubmit();	
		Thread.sleep(8000);
		System.out.println("Alert Message ==>" +contactUsPage.getTextFromAlertMessage());
		Assert.assertEquals(contactUsPage.getTextFromAlertMessage(), "There was a problem with your submission. Errors have been highlighted below.","Validation message is missing as keeping all field empty");			
		System.out.println("Done");
		System.out.println("Validation Message ==>" +contactUsPage.getTextFromValidationMessage());
		Assert.assertEquals(contactUsPage.getTextFromValidationMessage(), "This field is required.", "Validation message is missing upon clicking on Submit with empty data");			
		System.out.println("Done");
		
	}
	
	@Test(priority=19)
	public void fillFormWithIncorrectEmilId() throws IOException, InterruptedException{
		
		leaveUsPage = homePage.ClickOnLeaveUsaMessage();
		Thread.sleep(3000);
		System.out.println("Title==>" +leaveUsPage.validateLeaveUsMessageTitle());
		Assert.assertEquals(leaveUsPage.validateLeaveUsMessageTitle(), "Support", "Leave Us Message Page Not not found upon clicking on Leave Us Message");		 			
		leaveUsPage.passFirstName("Sachin");
		leaveUsPage.passEmailID("sachi@@12");
		leaveUsPage.passPhoneNo("9552619077");
		leaveUsPage.passMessage("Hello");
		leaveUsPage.clickOnSubmit();	
		Thread.sleep(8000);
		System.out.println("Alert Message ==>" +contactUsPage.getTextFromAlertMessage());
		Assert.assertEquals(contactUsPage.getTextFromAlertMessage(), "There was a problem with your submission. Errors have been highlighted below.","Validation message is missing as keeping all field empty");			
		System.out.println("Done");
		System.out.println("Validation Message ==>" +contactUsPage.getTextFromValidationMessage());
		Assert.assertEquals(contactUsPage.getTextFromValidationMessage(), "Please enter a valid email address.", "Validation message is missing upon clicking on Submit with empty data");			
		System.out.println("Done");
		
	}*/
	

