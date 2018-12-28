package practice;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RubiqueCC extends TestBase{

	public RubiqueCC() throws IOException, InterruptedException {
		super();
		
	}

	@BeforeMethod
	public void setUp() throws MalformedURLException, InterruptedException 
	{
		initialization();
		
		
	}  
	
	@Test
	public void testMethod(){
		
		System.out.println("Hello");
		driver.findElement(By.xpath("//a[@href='/credit-card']")).click();
		System.out.println("Hello2");
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
