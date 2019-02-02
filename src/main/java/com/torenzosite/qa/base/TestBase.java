package com.torenzosite.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import static com.torenzosite.qa.util.TestUtil.OSName;

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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import com.torenzosite.qa.util.TestUtil;

import io.appium.java_client.android.AndroidDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	// public static String hubURL1 = "http://192.168.1.32:5566/wd/hub";
	public static WebDriver driver;
	public static Properties prop;
	public static String hubURL = "http://192.168.1.39:5568/wd/hub";
	Logger log = Logger.getLogger(TestBase.class) ;	
	public static final String USERNAME = "sachin1";
	public static final String ACCESS_KEY = "0576f84d-89b5-4a1e-8eee-f19e4bb26729";
	public static final String SauceLabURL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";	
	
	public TestBase() throws IOException, InterruptedException {
		OSName = System.getProperty("os.name");
		System.out.println(OSName);
		if (OSName.equalsIgnoreCase("Mac OS X")) {
			System.out.println(OSName);
			prop = new Properties();
			FileInputStream fis = new FileInputStream(
					"/Users/rahul.kardel/Documents/TorenzoWebSite/src/main/java/com/torenzosite/qa/config/config.properties");
			prop.load(fis);
			System.out.println(OSName);
		} else if (OSName.equalsIgnoreCase("Windows 10") || OSName.equalsIgnoreCase("Windows 7")) {
			System.out.println(OSName);
			prop = new Properties();
			System.out.println(OSName);
			FileInputStream fis = new FileInputStream(
					"E:\\SeleniumWorkSpace\\torenzowebsite\\TorenzoWebSite\\src\\main\\java\\com\\torenzosite\\qa\\config\\config.properties");
			prop.load(fis);
			System.out.println(OSName);
		}
	}

	public static void initialization() throws InterruptedException, MalformedURLException {
		String broweserName = prop.getProperty("browser");
		String headlessmode = prop.getProperty("headlessmode");
        String testOnCloud = prop.getProperty("cloud");    
        String cloudBrowser = prop.getProperty("browserOnCloud");  
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
					  /*System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
					  System.setProperty("webdriver.firefox.marionette", "false");*/				
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
				
				if (cloudBrowser.equalsIgnoreCase("FF")){		
					System.out.println("Execution on SauceLa FF Browser");
					System.out.println("Testing Sauce Lab Cloud");
					DesiredCapabilities caps =  new DesiredCapabilities().firefox();
					caps.setCapability("platform", "Windows 10");
					caps.setCapability("version", "52");
					caps.setCapability("name", "Testing on Firfox 52");
					driver = new RemoteWebDriver(new URL(SauceLabURL), caps);
					
				}
				else if (cloudBrowser.equalsIgnoreCase("chrome")){
					System.out.println("Execution on SauceLa chrome Browser");
					System.out.println("Testing Sauce Lab Cloud");
					DesiredCapabilities caps =  new DesiredCapabilities().chrome();
					caps.setCapability("platform", "Windows 8");
					caps.setCapability("version", "65");
					caps.setCapability("name", "Testing on Chrome 65");
					driver = new RemoteWebDriver(new URL(SauceLabURL), caps);
				}
				else if (cloudBrowser.equalsIgnoreCase("IE")){
					System.out.println("Execution on SauceLa IE Browser");
					System.out.println("Testing Sauce Lab Cloud");
					DesiredCapabilities caps =  new DesiredCapabilities().internetExplorer();
					caps.setCapability("platform", "Windows 7");
					caps.setCapability("version", "11");
					caps.setCapability("name", "Testing on IE 11");
					driver = new RemoteWebDriver(new URL(SauceLabURL), caps);				
				}
				else if (cloudBrowser.equalsIgnoreCase("safari")){
					System.out.println("Execution on SauceLa IE Browser");
					System.out.println("Testing Sauce Lab Cloud");
					DesiredCapabilities caps = DesiredCapabilities.safari();
					caps.setCapability("platform", "OS X 10.9");
					caps.setCapability("version", "7.0");
					caps.setCapability("name", "Testing on Safari 7.0");
					driver = new RemoteWebDriver(new URL(SauceLabURL), caps);				
				}
				
			}						
		
		} else if (OSName.equalsIgnoreCase("Windows 10") || OSName.equalsIgnoreCase("Windows 7")) {
			if (broweserName.equals("FF")) {	
				  System.setProperty("webdriver.gecko.driver", "E:\\SeleniumWorkSpace\\torenzowebsite\\TorenzoWebSite\\FileDriver\\geckodriver.exe"
				  ); System.setProperty("webdriver.firefox.marionette", "false");
			//	WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
			else if (broweserName.equalsIgnoreCase("chrome")) {
				 System.setProperty("webdriver.chrome.driver","E:\\SeleniumWorkSpace\\torenzowebsite\\TorenzoWebSite\\FileDriver\\chromedriver.exe" );
				//WebDriverManager.firefoxdriver().setup();
				driver = new ChromeDriver();
			}

			else if (broweserName.equalsIgnoreCase("IE")) {
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
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
