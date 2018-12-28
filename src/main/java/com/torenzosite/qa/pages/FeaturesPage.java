package com.torenzosite.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.torenzosite.qa.base.TestBase;

public class FeaturesPage extends TestBase{
	
	@FindBy(xpath = "//a[contains(text(),'Sell')]")
	WebElement sell;

	@FindBy(xpath = "//a[contains(text(),'Manage')]")
	WebElement manage;

	@FindBy(xpath = "//a[contains(text(),'Report')]")
	WebElement report;

	@FindBy(xpath = "//a[contains(text(),'Grow')]")
	WebElement grow;
		
	@FindBy(xpath = "//*[text()='POINT OF SALE']")
	WebElement PointsOfSale;
	
	
	//*[@class='featured-box']
	
	@FindBy(xpath = "//*[text()='PRODUCTS']")
	WebElement Products;
	
	@FindBy(xpath = "//*[text()='CUSTOM REPORTS']")
	WebElement CustomReports;
	
	@FindBy(xpath = "//*[text()='SCALABILITY']")
	WebElement Scalability;

	@FindBy(xpath = "//a[@class='btn btn-primary btn-lg' and text()='Try Torenzo For Free']")
  public static WebElement tryTorenzoForFree;

	
	

		
	public FeaturesPage() throws IOException , InterruptedException {
		PageFactory.initElements(driver, this);
		
	}
	
	public String validateFeaturesPageTitle(){
		
		return driver.getTitle();
	}	
	
		public String validatePointsOfSaleTitle(){
				
				return PointsOfSale.getText();
			}
		
		public String validateProductsTitle(){
			
			return Products.getText();
		}
		
		public String validateCustomReportsTitle(){
			
			return CustomReports.getText();
		}
		
		public String validateScalabilityTitle(){
			
			return Scalability.getText();
		}

	public void clickOnSell(){
		sell.click();
		
	}
	
	public void clickOnManage(){
		manage.click();
		
	}
	
	public void clickOnReport(){
		report.click();
		
	}
	
	public void clickOnGrow(){
		grow.click();
		
	}
	
	public String getTextFromGrow(){
		return grow.getText();
		
	}
	
	public TryTorenzoForFreePage ClickOnTryTorenzoForFreePage() throws IOException, InterruptedException{
		
		tryTorenzoForFree.click();
		return new TryTorenzoForFreePage();
		
	}
	
	
}
