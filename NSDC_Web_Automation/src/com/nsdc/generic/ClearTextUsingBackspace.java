package com.nsdc.generic;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class ClearTextUsingBackspace
{
	public static void clearAll(WebElement element)
	{
		String ele = element.getAttribute("value");
		int length = ele.length();
		for(int i=0; i<length; i++)
		{
			element.sendKeys(Keys.BACK_SPACE);
		}
	}
}
