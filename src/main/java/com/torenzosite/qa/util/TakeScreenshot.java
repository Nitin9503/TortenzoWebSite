package com.torenzosite.qa.util;

import java.io.IOException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import static com.torenzosite.qa.util.TestUtil.OSName;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;


import static com.torenzosite.qa.util.TestUtil.screenshotName;
import com.torenzosite.qa.base.TestBase;

public class TakeScreenshot extends TestBase{

	public TakeScreenshot() throws IOException, InterruptedException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void takeScreenshot() throws IOException
		{

	SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
	Date date = new Date();
	screenshotName = sdf.format(date);
    TakesScreenshot screenshot = (TakesScreenshot) driver;
    File src=screenshot.getScreenshotAs(OutputType.FILE);

    if(OSName.equalsIgnoreCase("Windows 7") || OSName.equalsIgnoreCase("Windows 10")  ){
		 FileUtils.copyFile(src, new File(".\\Screenshot\\"+screenshotName+".jpeg"));
		
	 }
	 else if(OSName.equalsIgnoreCase("Mac OS X")){
		 
		 FileUtils.copyFile(src, new File("./Screenshot/"+screenshotName+".jpeg"));
		}
	 
	System.out.println("screenshot name is==>"+screenshotName);


}
	
}
