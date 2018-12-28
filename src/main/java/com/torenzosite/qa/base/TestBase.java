package com.torenzosite.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import static com.torenzosite.qa.util.TestUtil.OSName;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.torenzosite.qa.util.TestUtil;

import io.appium.java_client.android.AndroidDriver;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static AndroidDriver driver1;
	
	public TestBase() throws IOException, InterruptedException{
		
		OSName = System.getProperty("os.name");
		
		System.out.println(OSName);
		if (OSName.equalsIgnoreCase("Mac OS X")){
			System.out.println(OSName);
			prop = new Properties();
			FileInputStream fis = new FileInputStream("/Users/rahul.kardel/Documents/TorenzoWebSite/src/main/java/com/torenzosite/qa/config/config.properties");
			prop.load(fis);
			System.out.println(OSName);	
		}
		else if (OSName.equalsIgnoreCase("Windows 10") || OSName.equalsIgnoreCase("Windows 7") ){
			System.out.println(OSName);
			prop = new Properties();
			System.out.println(OSName);
			FileInputStream fis = new FileInputStream("E:\\SeleniumWorkSpace\\torenzowebsite\\TorenzoWebSite\\src\\main\\java\\com\\torenzosite\\qa\\config\\config.properties");
		prop.load(fis);
		System.out.println(OSName);
	
		}
	}
	public static void initialization() throws InterruptedException, MalformedURLException{
		
		String broweserName = prop.getProperty("browser");
		System.out.println("in mobile1");
			if (OSName.equalsIgnoreCase("Mac OS X")){
			
				if(broweserName.equalsIgnoreCase("FF")){
				System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
				System.setProperty("webdriver.firefox.marionette", "false");
				driver = new FirefoxDriver();
			}
				else if (broweserName.equalsIgnoreCase("chrome")){
					System.setProperty("webdriver.chrome.driver", "/Users/rahul.kardel/Downloads/chromedriver");	
					driver = new ChromeDriver();
				}
				
				else if (broweserName.equalsIgnoreCase("IE")){
					System.setProperty("webdriver.chrome.driver", "/Users/rahul.kardel/Documents/browser/chromedriver");	
					driver = new ChromeDriver();
				}
				else if (broweserName.equalsIgnoreCase("safari")){
					//System.setProperty("webdriver.chrome.driver", "/Users/rahul.kardel/Documents/browser/chromedriver");	
					driver = new SafariDriver();
				}
				else if (broweserName.equalsIgnoreCase("mobileChrome")){

					 DesiredCapabilities caps = new DesiredCapabilities();
						caps.setCapability("deviceName", "Honor");
						caps.setCapability("platformName", "Android");
						caps.setCapability("platformVersion", "6.0");
						caps.setCapability("newCommandTimeout","150");
						caps.setCapability("browserName", "Chrome");
						 if(OSName.equalsIgnoreCase("Mac OS X")){	
						caps.setCapability("udid", "192.168.56.101:5555");
						 System.out.println("Mac Emulator device id");
						 }
						 else if(OSName.equalsIgnoreCase("Windows 7")){
						 caps.setCapability("udid", "192.168.208.101:5555");
						 System.out.println("Windows Emulator device id");
						 }		
					    /*caps.setCapability("appPackage", "com.torenzo.torenzocafe");
						caps.setCapability("appActivity", "com.torenzo.torenzopos.StartScreenActivity");*/
					//	caps.setCapability("app", "/Users/rahul.kardel/Downloads/app-release 75.apk");
				
						driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
					
						
					/*caps.setCapability("appPackage", "com.android.chrome");
					caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");*/
				//System.setProperty("webdriver.chrome.driver", "E:\\SeleniumWorkSpace\\torenzowebsite\\TorenzoWebSite\\FileDriver\\chromedriver.exe");		
					
					System.out.println("in mobile");
			
				
			}
			}
		else if (OSName.equalsIgnoreCase("Windows 10") || OSName.equalsIgnoreCase("Windows 7") ){
					
					if (broweserName.equals("FF")){
						System.setProperty("webdriver.gecko.driver", "E:\\SeleniumWorkSpace\\torenzowebsite\\TorenzoWebSite\\FileDriver\\geckodriver.exe");
						System.setProperty("webdriver.firefox.marionette", "false");
						driver = new FirefoxDriver();
					}
					
					else if (broweserName.equalsIgnoreCase("chrome")){

						System.setProperty("webdriver.chrome.driver", "E:\\SeleniumWorkSpace\\torenzowebsite\\TorenzoWebSite\\FileDriver\\chromedriver.exe");		
			
						driver = new ChromeDriver();

					}	
		
					else if (broweserName.equalsIgnoreCase("IE")){

					System.setProperty("webdriver.ie.driver", "E:\\SeleniumWorkSpace\\torenzowebsite\\TorenzoWebSite\\FileDriver\\IEDriverServer.exe");		
				
					driver = new InternetExplorerDriver();
		}
						
		else if (broweserName.equalsIgnoreCase("mobileChrome")){
						DesiredCapabilities caps = new DesiredCapabilities();
						caps.setCapability("deviceName", "Honor");
						caps.setCapability("udid", "192.168.157.101:5555");
						caps.setCapability("platformName", "Android");
						caps.setCapability("platformVersion", "6.0");
						caps.setCapability("browserName", "Chrome");					
						URL url = new URL("http://0.0.0.0:4723/wd/hub");
					 driver = new AndroidDriver(url, caps);
					 
		}
		
		/*else if (broweserName.equals("grid")){
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setBrowserName("chrome");
			caps.setPlatform(Platform.WIN10);
			ChromeOptions options = new ChromeOptions();
			options.merge(caps);			
			String hubUrl = "http://192.168.1.123:4444/wd/hub";			
			WebDriver driver = new RemoteWebDriver(new URL(hubUrl), options);
						
		}*/

		if (broweserName.equals("mobileChrome")){
			
			System.out.println("Testing WebSite on Anddroid Emulator");
		}
		else{
			
			driver.manage().window().maximize();	
			
		}
		
	
			}

			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);		
			 driver.get(prop.getProperty("torenzoURL"));
			 // 	driver.get(prop.getProperty("url1"));
		}
	}
	
	
	
	
	


