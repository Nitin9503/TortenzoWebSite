package com.torenzosite.qa.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.torenzosite.qa.base.TestBase;
import com.torenzosite.qa.pages.HomePage;
import com.torenzosite.qa.pages.TryTorenzoForFreePage;

public class BrokenLinksOnTorenzoPageTest extends TestBase {

	
	HomePage homePage;
	 String url = "";
     HttpURLConnection huc = null;
     int respCode = 200;
     
	public BrokenLinksOnTorenzoPageTest() throws IOException, InterruptedException {
		super();
		// TODO Auto-generated constructor stub
	}

	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException{
		
		initialization();
		homePage = new HomePage();	
		
	} 
	@Test(priority=0)
	public void verifyHomePageTitle(){
			
		System.out.println("Title==>" +	homePage.validateHomePageTitle());
		AssertJUnit.assertEquals(homePage.validateHomePageTitle(), "Mobile POS Software for Businesses, Point of Sale Hardware, Retail Management Systems - Detroit, Ann Arbor, Warren | Torenzo", "Torenzo titile not found");		 
		
	}
	
	@Test(priority=1)
	public void findBrokenLinkOnTorenzoMainPage() throws IOException{
	  
	       List<WebElement> links =driver.findElements(By.tagName("a"));
	       System.out.println("TOtal NO. Of links on Toronzo Main Page=>" +links.size());
	    Iterator<WebElement> it = links.iterator();
	    
	    while(it.hasNext()){
	    
	    	url =it.next().getAttribute("href");
	    	System.out.println("url=>" +url);
	    	
	    	if(url==null || url.isEmpty()){
	    		
	    		 System.out.println("URL is either not configured for anchor tag or it is empty");
	                continue;
	    	}
	    	
	    	if(!url.startsWith(prop.getProperty("torenzoURL"))){
	    		System.out.println("URL belongs to another domain, skipping it.");
                continue;
	    		
	    	}
	    	
	    	try{
	    		 huc = (HttpURLConnection)(new URL(url).openConnection());
	    	       huc.setRequestMethod("HEAD");
	                 
	                huc.connect();
	                 
	                respCode = huc.getResponseCode();
	                
	                if(respCode>=400){
	                	
	                	  System.out.println(url+" is a broken link");
	                	
	                }
	                else{
	                  
	                }
	    	
	    	}catch(MalformedURLException e){
	    		
	    		
	    	}  catch (IOException e) {
    
                e.printStackTrace();
            }
	    	
	    	
	    }
		
		driver.quit();
	}
	
	
	
}
