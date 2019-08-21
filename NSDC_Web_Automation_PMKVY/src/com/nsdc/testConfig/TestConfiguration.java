package com.nsdc.testConfig;

import java.nio.file.Paths;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.nsdc.generic.ReadWriteData;
import com.nsdc.generic.Screenshot;
import com.nsdc.generic.ZipFolder;

import io.appium.java_client.AppiumDriver;

public class TestConfiguration
{
    public WebDriver driver;
    public AppiumDriver appDriver;
       
    @BeforeSuite
    public void preSuite() throws Exception
    {
        ZipFolder zf = new ZipFolder();
        
        Date d = new Date();
        String date = d.toString().replace(":", "_");
        
        String folderToZip = "./target/surefire-reports";
        
 //       String folderToZip = "./test-output";
        
        String zipName = "./ReportBackup/"+date+".zip";
        
        zf.zipFolder(Paths.get(folderToZip), Paths.get(zipName));
    }
    
    
    @BeforeMethod
    public void precondition()
    {
        String browsername = ReadWriteData.getData("./TestData/Configurations.xls", "Config", 1, 0);
        String url = ReadWriteData.getData("./TestData/Configurations.xls", "Config", 1, 1);
        String osType = ReadWriteData.getData("./TestData/Configurations.xls", "Config", 1, 2);   
        
        if (browsername.equals("Chrome") && osType.equals("Mac OS"))
        {
            System.setProperty("webdriver.chrome.driver", "./Browsers-exe/Mac-OS/chromedriver");
            driver = new ChromeDriver();
        }
        else if (browsername.equals("Firefox") && osType.equals("Mac OS"))
        {
            System.setProperty("webdriver.gecko.driver", "./Browsers-exe/Mac-OS/geckodriver");
            driver = new FirefoxDriver();
        }
        else if (browsername.equals("Chrome") && osType.equals("Windows"))
        {
            System.setProperty("webdriver.chrome.driver", "./Browsers-exe/Windows/chromedriver.exe");
            driver = new ChromeDriver();
        	//DebugMode();
        }
        else if (browsername.equals("Firefox") && osType.equals("Windows"))
        {
            System.setProperty("webdriver.gecko.driver", "./Browsers-exe/Windows/geckodriver.exe");
            driver = new FirefoxDriver();
        }
        else if (browsername.equals("Chrome") && osType.equals("Ubuntu"))
        {
            System.setProperty("webdriver.chrome.driver", "./Browsers-exe/Linux/chromedriver");
            driver = new ChromeDriver();
        }
        else if (browsername.equals("Firefox") && osType.equals("Ubuntu"))
        {
            System.setProperty("webdriver.gecko.driver", "./Browsers-exe/Linux/geckodriver");
            driver = new FirefoxDriver();
        }
  
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(url);
    }
    
   @AfterMethod
    public void postcondition(ITestResult result) throws Exception
    {
        if(ITestResult.FAILURE == result.getStatus())
        {
            Screenshot.takeScreenshot(driver, result.getName());
        }
       	//driver.close();       	    	
    }
    
    public void DebugMode()
    {
    	System.setProperty("webdriver.chrome.driver", "./Browsers-exe/Windows/chromedriver.exe");
    	ChromeOptions co= new ChromeOptions();
    	co.setExperimentalOption("debuggerAddress", "localhost:2216");
    	 driver =new ChromeDriver(co);
    	
    }
    
    

 }