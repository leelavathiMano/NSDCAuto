package com.nsdc.generic;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class FilePreview
{
	public static void closeWindow(WebDriver driver)
	{
		 String mainWindow=driver.getWindowHandle();	
		 
		 Set<String> set =driver.getWindowHandles();	
		 Iterator<String> itr= set.iterator();
		 
		 while(itr.hasNext())
		 {
			 String childWindow=itr.next();
		   
			 if(!mainWindow.equals(childWindow))
			 {
				 driver.switchTo().window(childWindow);
				 System.out.println(driver.switchTo().window(childWindow).getTitle());
				 driver.close();
			 }
		 }
		 
		 driver.switchTo().window(mainWindow);	
	}
	
}
