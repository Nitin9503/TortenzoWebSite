package com.torenzosite.qa.base;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.torenzosite.qa.util.TestUtil;

public class GridChromeTest {
	
	
	public static void Launch() throws MalformedURLException{
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setBrowserName("chrome");
		caps.setPlatform(Platform.WIN10);

		ChromeOptions options = new ChromeOptions();
		options.merge(caps);
		
		String hubUrl = "http://192.168.1.123:4444/wd/hub";
		
		WebDriver driver = new RemoteWebDriver(new URL(hubUrl), options);
		
		//driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("http://www.torenzo.com/");
				
	}
	
	
	

}
