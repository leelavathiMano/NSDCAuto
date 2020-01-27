package com.nsdc.generic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToT_ToA_Batch_DatePicker 
{
	public static void chooseDate(WebDriver driver, String date, WebElement dateTextField, WebElement monthDropdownList, WebElement yearDropdownList ) throws InterruptedException
	{
		/*
		 * WebDriverWait wait=new WebDriverWait(driver,60);
		 * wait.until(ExpectedConditions.elementToBeClickable(dateTextField));
		 */Thread.sleep(2000);
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click();", dateTextField);
		//Thread.sleep(2000);
		String parts[]=date.split("-");
		String day=parts[0];
		if(day.startsWith("0"))
		{
			day=day.replace("0", "");
		}
		String month=parts[1];
		String year=parts[2];
		SelectDropDownList.selectDropDownListByValue(yearDropdownList, year);
		SelectDropDownList.selectDropDownListByVisibleText(monthDropdownList, month);
		if(driver.findElements(By.xpath("//div[text()='"+day+"']")).size()>1)
		{
			if(driver.findElement(By.xpath("(//div[text()='"+day+"'])[1]")).getAttribute("class").contains("mute"))
			{
				driver.findElement(By.xpath("(//div[text()='"+day+"'])[2]")).click();
			}
			else
			{
				driver.findElement(By.xpath("(//div[text()='"+day+"'])[1]")).click();
			}
		}
		else
		{
			driver.findElement(By.xpath("//div[text()='"+day+"']")).click();
		}
	}
	
	///////////////////////////
	
	
	
	
	public static void SelectDate(WebDriver driver, String date, WebElement dateTextField, WebElement monthDropdownList) throws InterruptedException
	{
		/*
		 * WebDriverWait wait=new WebDriverWait(driver,60);
		 * wait.until(ExpectedConditions.elementToBeClickable(dateTextField));
		 */Thread.sleep(2000);
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click();", dateTextField);
		//Thread.sleep(2000);
		String parts[]=date.split("-");
		String day=parts[0];
		if(day.startsWith("0"))
		{
			day=day.replace("0", "");
		}
		String month=parts[1];
		//String year=parts[2];
		//SelectDropDownList.selectDropDownListByValue(yearDropdownList, year);
		SelectDropDownList.selectDropDownListByVisibleText(monthDropdownList, month);
		if(driver.findElements(By.xpath("//div[text()='"+day+"']")).size()>1)
		{
			if(driver.findElement(By.xpath("(//div[text()='"+day+"'])[1]")).getAttribute("class").contains("mute"))
			{
				driver.findElement(By.xpath("(//div[text()='"+day+"'])[2]")).click();
			}
			else
			{
				driver.findElement(By.xpath("(//div[text()='"+day+"'])[1]")).click();
			}
		}
		else
		{
			driver.findElement(By.xpath("//div[text()='"+day+"']")).click();
		}
	}
	
	
	
	
	
}