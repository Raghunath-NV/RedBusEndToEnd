package com.redBus.screenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenShots {

	public static String getScreenshot(WebDriver driver,String fileName)
	{
		String dest = "./Screenshot";
		TakesScreenshot ts = (TakesScreenshot) driver;
		File f = ts.getScreenshotAs(OutputType.FILE);
		String time = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(new Date());
		try {
			FileUtils.copyFile(f, new File(dest + "/" + fileName + "_" + time + "_" + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error while taking screenshot "+e.getMessage());
		}

		return dest;
	}
}
