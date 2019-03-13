package com.nsdc.generic;

import java.io.File;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class Screenshot
{
    public static void takeScreenshot(WebDriver driver, String name) throws Exception
    {
        Date d = new Date();
      
        String date = d.toString().replace(":", "_");
        String currentUrl = driver.getCurrentUrl().toString().replace(":", "_").replace("//", "_").replace(".", "_").replace("/", "_");
        EventFiringWebDriver edriver = new EventFiringWebDriver(driver);
        File  scrImg = edriver.getScreenshotAs(OutputType.FILE);
        File tarpath = new File("./Screenshots/"+ currentUrl +" " +name+" "+date+".jpg");
        FileHandler.copy(scrImg, tarpath);
    }
    
}



