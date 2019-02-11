package com.nsdc.generic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ToT_ToA_Batch_DatePicker 
{
	public static void chooseDate(WebDriver driver, String date, WebElement dateTextField, WebElement monthDropdownList, WebElement yearDropdownList )
	{
		dateTextField.click();
		String parts[]=date.split("-");
		String day=parts[0].replaceAll("0", "");
		int month=Integer.parseInt(parts[1]);
		String year=parts[2];
		SelectDropDownList.selectDropDownListByVisibleText(yearDropdownList, year);
		switch(month)
		{
			case 1:  SelectDropDownList.selectDropDownListByVisibleText(monthDropdownList, "Jan");
			break;
			case 2:  SelectDropDownList.selectDropDownListByVisibleText(monthDropdownList, "Feb");
			break;
			case 3:  SelectDropDownList.selectDropDownListByVisibleText(monthDropdownList, "Mar");
			break;
			case 4:  SelectDropDownList.selectDropDownListByVisibleText(monthDropdownList, "Apr");
			break;
			case 5:  SelectDropDownList.selectDropDownListByVisibleText(monthDropdownList, "May");
			break;
			case 6:  SelectDropDownList.selectDropDownListByVisibleText(monthDropdownList, "Jun");
			break;
			case 7:  SelectDropDownList.selectDropDownListByVisibleText(monthDropdownList, "Jul");
			break;
			case 8:  SelectDropDownList.selectDropDownListByVisibleText(monthDropdownList, "Aug");
			break;
			case 9:  SelectDropDownList.selectDropDownListByVisibleText(monthDropdownList, "Sep");
			break;
			case 10: SelectDropDownList.selectDropDownListByVisibleText(monthDropdownList, "Oct");
			break;
			case 11: SelectDropDownList.selectDropDownListByVisibleText(monthDropdownList, "Nov");
			break;
			case 12: SelectDropDownList.selectDropDownListByVisibleText(monthDropdownList, "Dec");
			break;
		}
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