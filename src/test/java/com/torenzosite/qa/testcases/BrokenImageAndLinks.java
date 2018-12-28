package com.torenzosite.qa.testcases;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.torenzosite.qa.base.TestBase;
import com.torenzosite.qa.pages.ContactUsPage;
import com.torenzosite.qa.pages.HomePage;
import com.torenzosite.qa.pages.TryTorenzoForFreePage;
@Listeners(com.torenzosite.qa.listener.Listener.class)
public class BrokenImageAndLinks extends TestBase{

	HomePage homePage;
	ContactUsPage contactUsPage;
	public BrokenImageAndLinks() throws IOException, InterruptedException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException{
		
		initialization();
		homePage = new HomePage();
		contactUsPage =new ContactUsPage();
		
	} 
	
	@Test(priority=0)
	public void findBrokenLinkOnTorenzoMainPage() throws IOException{
	
	List<WebElement>linksList=driver.findElements(By.tagName("a"));
	linksList.addAll(driver.findElements(By.tagName("img")));
	
	List<WebElement>activeLinks = new ArrayList<WebElement>();
	
	for (int i=0; i<linksList.size(); i++){
		
		//System.out.println(linksList.get(i).getAttribute("href"));
		if(linksList.get(i).getAttribute("href")!=null &&(!linksList.get(i).getAttribute("href").contains("javascript"))) {
			activeLinks.add(linksList.get(i));
			
		}
		
	}
	System.out.println("Active Total no. of links and images==> " +activeLinks.size());
	for(int j=0; j<activeLinks.size();j++){
		HttpURLConnection connection=(HttpURLConnection)new URL(activeLinks.get(j).getAttribute("href")).openConnection();
		connection.setConnectTimeout(30000);
		connection.connect();
	   String response= connection.getResponseMessage();
	    connection.disconnect();
	    System.out.println(activeLinks.get(j).getAttribute("href") +"===>"+response);
		
		
	}
	
		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.close();
		
	}
	
}
