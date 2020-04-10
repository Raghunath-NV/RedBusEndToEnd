package com.redBus.homePage;

import java.util.List;

import org.apache.tools.ant.taskdefs.optional.depend.constantpool.StringCPInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.redBus.screenshot.TakeScreenShots;

public class HomePageOperations {
	
	public static void selectLocationFromList(WebDriver driver,int position)
	{
		List<WebElement> CityList = driver.findElements(By.xpath("//ul[@class='autoFill']/li"));
		if(CityList.size()>position)
		{
		CityList.get(position).click();
		}
		else {
			CityList.get(1).click();	
		}
	}
	
	public static void selectDate(WebDriver driver,String dateOfTravel) throws Exception {
		
		driver.findElement(By.xpath("//label[text()='Onward Date']")).click();
		Thread.sleep(2000);
		int i=1;
		while (true) {
			Thread.sleep(1000);
			String path="\"(//td[@class='monthTitle'])["+i+"]\"";
			WebElement calendarMonthYear = driver.findElement(By.xpath(path));
			WebElement monthNext = driver.findElement(By.xpath("//*[@id='rb-calendar_onward_cal']//td[@class='next']"));
			System.out.println("Month is "+calendarMonthYear.getText());
			if (((calendarMonthYear.getText().equalsIgnoreCase("Apr 2020")))) {
				driver.findElement(By.xpath("//*[@id='rb-calendar_onward_cal']/table/tbody//td[text()='15']")).click();
				break;
			}
			monthNext.click();
			i=2;
		}
		
	}

}
