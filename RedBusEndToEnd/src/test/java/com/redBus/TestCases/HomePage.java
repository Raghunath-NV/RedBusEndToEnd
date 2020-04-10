package com.redBus.TestCases;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.redBus.browser.GetBrowser;
import com.redBus.homePage.HomePageOperations;
import com.redBus.screenshot.TakeScreenShots;

public class HomePage {
	
	@Test
	public void EnterLocation() throws Exception
	{
		String url ="https://www.redbus.in";
		String browserType="Chrome";
		String src="Bangalore",dest="Hyderabad";
		String dateOfTravel ="09-May-2020";
		WebDriver driver;
		
		driver = GetBrowser.getDriver(browserType);
		driver.get(url);
		TakeScreenShots.getScreenshot(driver, "homePage");
		
		driver.findElement(By.id("src")).sendKeys(src);
		
		//Select from suggested list
		HomePageOperations.selectLocationFromList(driver, 0);
		driver.findElement(By.id("dest")).sendKeys(dest);
		//Select from suggested list
		HomePageOperations.selectLocationFromList(driver, 0);
		HomePageOperations.selectDate(driver, dateOfTravel);
		JavascriptExecutor javascriptExecutor=(JavascriptExecutor) driver;
		javascriptExecutor.executeScript("document.getElementById('onward_cal').value='"+dateOfTravel+"'");
		//driver.findElement(By.xpath("//label[text()='Onward Date']")).value=dateOfTravel;
		TakeScreenShots.getScreenshot(driver, "After Entering Data in Home Page");
		driver.findElement(By.id("search_btn")).click();
		TakeScreenShots.getScreenshot(driver, "Bus Search Page");
		//Thread.sleep(3000);
		//driver.quit();
	}

}
