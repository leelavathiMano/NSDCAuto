package com.nsdc.generic;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class FilePreview
{
	public void closeWindow(WebDriver driver)
	{
		Set<String> windows = driver.getWindowHandles();
        Iterator <String> it  = windows.iterator();
        String window1 = it.next();
        String window2 = it.next();
        driver.switchTo().window(window2);
        driver.quit();
        driver.switchTo().window(window1);
	}
	
}
