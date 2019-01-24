package com.torenzosite.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hslf.model.Sheet;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.torenzosite.qa.base.TestBase;

import io.appium.java_client.functions.ExpectedCondition;

public class TestUtil extends TestBase{
	
	public TestUtil() throws IOException, InterruptedException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static long PAGE_LOAD_TIMEOUT= 120;
	public static long IMPLICIT_WAIT = 120;
	public static String title = "";
	public static String OSName = "";
	
	
	public static String screenshotName="";
	
	public static void scrollUpByPixel(int pixel){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 'pixel')");
	
	}
	
	public static void scrollUpAtEndOFPage(){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	
	}
	
	public static void scrollUpHorizontalORVIsibilityOFElement(WebElement element){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	
	}
	
	
	public static void clickOn(WebDriver driver, WebElement element, int timeouts){
		
		new WebDriverWait(driver, timeouts).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(element));
		element.click();	
		
	}
	
	

}
