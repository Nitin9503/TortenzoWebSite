package com.torenzosite.qa.pages;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.torenzosite.qa.base.TestBase;
import static com.torenzosite.qa.util.TestUtil.title;
public class HomePage extends TestBase {
	
	@FindBy(linkText= "Torenzo POS")
	@CacheLookup
	WebElement torenzoPOS;
	
	@FindBy(linkText= "Features")
	@CacheLookup
	WebElement features;


	@FindBy(linkText= "Hardware")
	@CacheLookup
	WebElement hardware;


	@FindBy(linkText= "Pricing")
	@CacheLookup
	WebElement pricing;


	@FindBy(linkText= "About Us")
	@CacheLookup
	WebElement aboutUs;

	@FindBy(xpath= "//*[contains(text(),'Try Torenzo For Free')]")	
	 WebElement tryTorenzoForFree;
	
	@FindBy(xpath= "//input[@type='text' and @placeholder='Email Address']")
	@CacheLookup
	WebElement emailAddress;
	
	@FindBy(xpath= "//input[@type='submit' and @value='CLICK HERE TO TRY TORENZO FOR FREE']")
	@CacheLookup
	WebElement ClickHereToTryTorenzoForFree;
		
	@FindBy(xpath= "//a[text()='Leave us a message']")
	@CacheLookup
	WebElement LeaveUsaMessage;
	
	@FindBy(xpath= "//a[text()='Privacy Policy']")
	WebElement privacyPolicy;
	
	@FindBy(xpath= "//a[text()='Website by Pronto' ]")
	WebElement websiteByPronto;
	
	
	@FindBy(xpath= "//a[text()='Home']")
	@CacheLookup
	WebElement home;
	

	@FindBy(xpath= "//a[text()='Contact Us' ]")
	@CacheLookup
	public static WebElement contactUs;

	
	@FindBy(xpath= "//a[text()='Blog' ]")
	@CacheLookup
	WebElement blog;
		

	public HomePage() throws IOException, InterruptedException{
		PageFactory.initElements(driver, this);
	}

		public String validateHomePageTitle(){
			
			return driver.getTitle();
		}	
		
		public TorenzoPOSPage clickOnTorenzoPOS() throws IOException, InterruptedException{
			torenzoPOS.click();
			return new TorenzoPOSPage();
			
			
		}
		
		public FeaturesPage clickOnFeatures() throws IOException, InterruptedException{
			features.click();
			return new FeaturesPage();
			
		}
		
		public HardwarePage clickOnHardware() throws IOException, InterruptedException{
			hardware.click();
			return new HardwarePage();
			
		}
			
	
		public PricingPage clickOnPricing() throws IOException, InterruptedException{
			pricing.click();
			return new PricingPage();
			
		}
	
		public TryTorenzoForFreePage clickOnTryTorenzoForFree() throws IOException, InterruptedException{
			   Thread.sleep(2000);
			tryTorenzoForFree.click();
			return new TryTorenzoForFreePage();
			
		}
		
		public AboutUsPage clickOnAboutUs() throws IOException, InterruptedException{
			aboutUs.click();
			return new AboutUsPage();
			
		}
		
		public void passEmailAddress(String email)throws IOException{
		
			emailAddress.click();
			emailAddress.sendKeys(email);
		
		}
		
		public void ClickHereOnToTryTorenzoForFree(){
			ClickHereToTryTorenzoForFree.click();
		 title = driver.getTitle();
			
		}
		
		public LeaveUsPage ClickOnLeaveUsaMessage() throws IOException, InterruptedException{
			
			LeaveUsaMessage.click();
			
			return new LeaveUsPage();	 
			
		}
		
		public void ClickOnPrivacyPolicy(){
			privacyPolicy.click();
	
			
		}
		
		public void ClickOnWebsiteByPronto(){
			websiteByPronto.click();
	
			
		}
		
		public HomePage ClickOnHome() throws IOException, InterruptedException{
			home.click();
             return new HomePage();	
			
		}
		
		public ContactUsPage ClickOnContactUs() throws IOException, InterruptedException{
			contactUs.click();
			return new ContactUsPage();
	
			
		}
		
		public void ClickOnBlog(){
			blog.click();
	
			
		}
}




/*public HomePage login(String un, String pwd){
	username.sendKeys(un);
	password.sendKeys(pwd);
	//loginBtn.click();
	    	JavascriptExecutor js = (JavascriptExecutor)driver;
	    	js.executeScript("arguments[0].click();", loginBtn);
	    	
	return new HomePage();
}
*/