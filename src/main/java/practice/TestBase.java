package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.torenzosite.qa.util.TestUtil;
public class TestBase {
	
	public static WebDriver driver ;
	public static Properties prop;
	
	public TestBase() throws IOException, InterruptedException{
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("E:\\SeleniumWorkSpace\\torenzowebsite\\TorenzoWebSite\\src\\main\\java\\practice\\config.properties");
			prop.load(ip);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			
		}
		
	}
	
	public static void initialization() throws InterruptedException, MalformedURLException{
		
		String broweserName = prop.getProperty("browser");
		if(broweserName.equals("FF")){
			
			System.setProperty("webdriver.gecko.driver", "E:\\SeleniumWorkSpace\\torenzowebsite\\TorenzoWebSite\\FileDriver\\geckodriver.exe");
			System.setProperty("webdriver.firefox.marionette", "false");
			driver = new FirefoxDriver();
		
		}
		else if (broweserName.equals("chrome")){

			System.setProperty("webdriver.chrome.driver", "E:\\SeleniumWorkSpace\\torenzowebsite\\TorenzoWebSite\\FileDriver\\chromedriver.exe");		
			
			driver = new ChromeDriver();

		}	
		
		else if (broweserName.equals("IE")){

	
			System.setProperty("webdriver.ie.driver", "E:\\SeleniumWorkSpace\\torenzowebsite\\TorenzoWebSite\\FileDriver\\IEDriverServer.exe");		
		
			driver = new InternetExplorerDriver();
			
		}
		

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);		
		driver.get(prop.getProperty("url"));	

}
	
	
	
}
