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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import com.torenzosite.qa.base.TestBase;

import io.appium.java_client.functions.ExpectedCondition;

public class TestUtil extends TestBase {

	public TestUtil() throws IOException, InterruptedException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static long PAGE_LOAD_TIMEOUT = 120;
	public static long IMPLICIT_WAIT = 120;
	public static String title = "";
	public static String OSName = "";

	public static String screenshotName = "";

	public static void scrollUpByPixel(int pixel) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 'pixel')");

	}

	public static void scrollUpAtEndOFPage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

	}

	public static void scrollUpHorizontalORVIsibilityOFElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);

	}

	public static void clickOn(WebElement element, int timeouts) {

		new WebDriverWait(driver, timeouts)
				.until(ExpectedConditions.elementToBeClickable(element));
		element.click();

		/*WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(eleke));option for the same*/ 
	}

	public static void flashOnElement(WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String bgcolor = element.getCssValue("backgroundColor");
	
		for (int i = 0; i < 50; i++) {
			changeColor("rgb(139,0,0)", element);
			changeColor(bgcolor ,element);
		}
	}

	public static void changeColor( String color, WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroundcolor = '"+color+"'", element);
 
	}
	public void typeText(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}

	public static void selectValuefromDropDown(WebElement element, int value) {
		Select sel = new Select(element);
		sel.selectByIndex(value);
	}

	public static boolean isElementDisplayed(WebElement element) {
		return element.isDisplayed();
	}

	public static void runJavaScript(String command) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(command);
	}

	public static void uploadfile(WebElement element, String path) {
		element.sendKeys(path);
	}
	public static void waitForElement(WebElement element, int maxTimeout) {
		WebDriverWait wait = new WebDriverWait(driver, maxTimeout);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

	public static void waitForElementforClick(WebElement element, int maxTimeout) {
		WebDriverWait wait = new WebDriverWait(driver, maxTimeout);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

	public static void waitForElementforType(WebElement element, int maxTimeout, String value) {
		WebDriverWait wait = new WebDriverWait(driver, maxTimeout);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.sendKeys(value);
	}

}
