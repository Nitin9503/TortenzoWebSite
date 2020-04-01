package com.torenzosite.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import static com.torenzosite.qa.util.TestUtil.OSName;
import static com.torenzosite.qa.util.TestUtil.prop;
import static com.torenzosite.qa.util.TestUtil.driverPath;
import static com.torenzosite.qa.util.TestUtil.USERNAME;
import static com.torenzosite.qa.util.TestUtil.ACCESS_KEY;
import static com.torenzosite.qa.util.TestUtil.SauceLabURL;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.torenzosite.qa.util.TestUtil;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	/// public static String hubURL1 = "http://192.168.1.32:5566/wd/hub";
	//Logger log = Logger.getLogger(TestBase.class) ;	
	public static WebDriver driver;
	public static DesiredCapabilities caps;
	public static Properties prop;
	//E:\SeleniumWorkSpace\torenzowebsite\TorenzoWebSite\FileDriver\chromedriver.exe
	public TestBase() throws IOException, InterruptedException {
		 driverPath = System.getProperty("user.dir");
		System.out.println("path==>" +driverPath);
		OSName = System.getProperty("os.name");
		System.out.println(OSName);
		if (OSName.equalsIgnoreCase("Mac OS X")) {
			System.out.println(OSName);
			prop = new Properties();
			FileInputStream fis = new FileInputStream(driverPath+"/src/main/java/com/torenzosite/qa/config/config.properties");
			prop.load(fis);
			System.out.println(OSName);
		} else if (OSName.equalsIgnoreCase("Windows 10") || OSName.equalsIgnoreCase("Windows 7")) {
			System.out.println(OSName);
			prop = new Properties();
			System.out.println(OSName);
			FileInputStream fis = new FileInputStream(driverPath+"/src/main/java/com/torenzosite/qa/config/config.properties");
			prop.load(fis);
			System.out.println("prop"+OSName);
		}
	}

	public static void initialization() throws InterruptedException, MalformedURLException {
		String broweserName = prop.getProperty("browser");
		String headlessmode = prop.getProperty("headlessmode");
        String testOnCloud = prop.getProperty("cloud");    
   //     String cloudBrowser = prop.getProperty("browserOnCloud");  
		if (OSName.equalsIgnoreCase("Mac OS X")) {

			if (broweserName.equalsIgnoreCase("FF")) {				
				if (headlessmode.equalsIgnoreCase("headless")) {
					System.out.println("Execution on HeadLess FF Browser");
					FirefoxBinary binary = new FirefoxBinary();
					binary.addCommandLineOptions("--headless");
					WebDriverManager.firefoxdriver().setup();
					FirefoxOptions option = new FirefoxOptions();
					option.setBinary(binary);
					driver = new FirefoxDriver(option);
				} else {	
					System.out.println("Execution on Normal FF Browser");
					 // System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
					//  System.setProperty("webdriver.firefox.marionette", "false");			
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();					
				}
				
			} else if (broweserName.equalsIgnoreCase("chrome")) {
				if (headlessmode.equalsIgnoreCase("headless")) {
					System.out.println("Execution on HeadLess Chrome Browser");
					WebDriverManager.chromedriver().setup();
					ChromeOptions option = new ChromeOptions();
					option.addArguments("window-size=1400,800");
					option.addArguments("headless");
					driver = new ChromeDriver(option);
				} else {
					System.out.println("Execution on Normal FF Browser");
					WebDriverManager.chromedriver().setup();
					//ChromeDriverManager.getInstance(CHROME).setup();
					driver = new ChromeDriver();           
				}
			} else if (broweserName.equalsIgnoreCase("safari")) {

				driver = new SafariDriver();
			}
			else if (broweserName.equalsIgnoreCase("IE")) {
				// System.setProperty("webdriver.chrome.driver", "/Users/rahul.kardel/Documents/browser/chromedriver");
				WebDriverManager.iedriver().setup();
				driver = new ChromeDriver();
			} else if (broweserName.equalsIgnoreCase("safari")) {
				// System.setProperty("webdriver.chrome.driver",
				// "/Users/rahul.kardel/Documents/browser/chromedriver");
				driver = new SafariDriver();
			}

			else if (testOnCloud.equalsIgnoreCase("SauceLab")){
				System.out.println("Testing Sauce Lab Cloud");				
				switch (prop.getProperty("browserOnCloud")){		
				
				case "firefox-win-saucelab":
					caps = DesiredCapabilities.firefox();
					caps.setCapability("platform", "Windows 8.1");
					caps.setCapability("version", "63.0");
					caps.setCapability("extendedDebugging", true);
					caps.setCapability("name", "Testing on Firfox 63.0");
					break;
				case "chrome-win-saucelab":
					caps = DesiredCapabilities.chrome();
					caps.setCapability("platform", "Windows 10");
					caps.setCapability("version", "71.0");
					caps.setCapability("extendedDebugging", true);
					caps.setCapability("name", "Testing on Chrome 71.0");
					break;
				case "ie-win-saucelab":
					DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
					caps.setCapability("platform", "Windows 10");
					caps.setCapability("version", "11.285");
					caps.setCapability("extendedDebugging", true);
					caps.setCapability("name", "Testing on IE 11.285");
					break;
				case "chrome-mac-saucelab":
					caps = DesiredCapabilities.chrome();
					caps.setCapability("platform", "OS X 10.11");
					caps.setCapability("version", "70.0");
					caps.setCapability("extendedDebugging", true);
					caps.setCapability("name", "Testing on Chrome 70.0");
					break;
				case "firefox-mac-saucelab":
					caps = DesiredCapabilities.firefox();
					caps.setCapability("platform", "OS X 10.11");
					caps.setCapability("version", "64.0");
					caps.setCapability("extendedDebugging", true);
					caps.setCapability("name", "Testing on FireFox 64.0");
					break;
				case "safari-mac-saucelab":
					caps = DesiredCapabilities.safari();
					caps.setCapability("platform", "OS X 10.11");
					caps.setCapability("version", "10.0");
					caps.setCapability("extendedDebugging", true);
					caps.setCapability("name", "Testing on Safaro 10.0");
					break;
				case "safari-ipad-saucelab":
					caps = DesiredCapabilities.iphone();
					caps.setCapability("appiumVersion", "1.9.1");
					caps.setCapability("deviceName","iPad Pro (10.5 inch) Simulator");
					caps.setCapability("deviceOrientation", "portrait");
					caps.setCapability("platformVersion","12.0");
					caps.setCapability("platformName", "iOS");
					caps.setCapability("browserName", "Safari");
					caps.setCapability("name", "Testing on Safari ipad");
					break;
		
					
					default :
						System.out.println("Browser provide is not matched");				
				
				}
				driver = new RemoteWebDriver(new URL(SauceLabURL), caps);				
			}						
		
		} else if (OSName.equalsIgnoreCase("Windows 10") || OSName.equalsIgnoreCase("Windows 7")) {

			if (broweserName.equals("FF")) {	
				  System.setProperty("webdriver.gecko.driver", driverPath+"\\FileDriver\\geckodriver.exe");
				  System.setProperty("webdriver.firefox.marionette", "false");
			//	WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();

			}
			else if (broweserName.equalsIgnoreCase("chrome")) {
				 System.setProperty("webdriver.chrome.driver",driverPath+"\\FileDriver\\chromedriver.exe" );
				//WebDriverManager.firefoxdriver().setup();
				driver = new ChromeDriver();
			}

			else if (broweserName.equalsIgnoreCase("IE")) {
				 System.setProperty("webdriver.ie.driver",driverPath+"\\FileDriver\\IEDriverServer.exe" );
				driver = new InternetExplorerDriver();
			}
			else if (testOnCloud.equalsIgnoreCase("SauceLab")){
				System.out.println("Testing Sauce Lab Cloud");				
				switch (prop.getProperty("browserOnCloud")){		
				
				case "firefox-win-saucelab":
					caps = DesiredCapabilities.firefox();
					caps.setCapability("platform", "Windows 10");
					caps.setCapability("version", "63.0");
					caps.setCapability("extendedDebugging", true);
					caps.setCapability("name", "Testing on Firfox 63.0");
					break;
				case "chrome-win-saucelab":
					caps = DesiredCapabilities.chrome();
					caps.setCapability("platform", "Windows 10");
					caps.setCapability("version", "71.0");
					caps.setCapability("extendedDebugging", true);
					caps.setCapability("name", "Testing on Chrome 71.0");
					break;
				case "ie-win-saucelab":
					DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
					caps.setCapability("platform", "Windows 10");
					caps.setCapability("version", "11.285");
					caps.setCapability("extendedDebugging", true);
					caps.setCapability("name", "Testing on IE 11.285");
					break;
				case "chrome-mac-saucelab":
					caps = DesiredCapabilities.chrome();
					caps.setCapability("platform", "OS X 10.11");
					caps.setCapability("version", "70.0");
					caps.setCapability("extendedDebugging", true);
					caps.setCapability("name", "Testing on Chrome 70.0");
					break;
				case "firefox-mac-saucelab":
					caps = DesiredCapabilities.firefox();
					caps.setCapability("platform", "OS X 10.11");
					caps.setCapability("version", "64.0");
					caps.setCapability("extendedDebugging", true);
					caps.setCapability("name", "Testing on FireFox 64.0");
					break;
				case "safari-mac-saucelab":
					caps = DesiredCapabilities.safari();
					caps.setCapability("platform", "OS X 10.11");
					caps.setCapability("version", "10.0");
					caps.setCapability("extendedDebugging", true);
					caps.setCapability("name", "Testing on Safaro 10.0");
					break;
				case "safari-ipad-saucelab":
					caps = DesiredCapabilities.iphone();
					caps.setCapability("appiumVersion", "1.9.1");
					caps.setCapability("deviceName","iPad Pro (10.5 inch) Simulator");
					caps.setCapability("deviceOrientation", "portrait");
					caps.setCapability("platformVersion","12.0");
					caps.setCapability("platformName", "iOS");
					caps.setCapability("browserName", "Safari");
					caps.setCapability("name", "Testing on Safari ipad");
					break;
				case "52":
					
					default :
						System.out.println("Browser provide is not matched");				
				
				}
				driver = new RemoteWebDriver(new URL(SauceLabURL), caps);				
			}						
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);		
		driver.get(prop.getProperty("torenzoURL"));	
		// driver.get(prop.getProperty("url1"));
		// driver.get("https://www.ixigo.com/trains");
	}
}
