package com.nsdc.testConfig;

import java.nio.file.Paths;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.nsdc.generic.ReadWriteData;
import com.nsdc.generic.Screenshot;
import com.nsdc.generic.ZipFolder;

public class TestConfiguration
{
    public WebDriver driver;
    @BeforeSuite
    public void preSuite() throws Exception
    {
        ZipFolder zf = new ZipFolder();
        
        Date d = new Date();
        String date = d.toString().replace(":", "_");
        
        String folderToZip = "./target/surefire-reports";
        
        String zipName = "./ReportBackup/"+date+".zip";
        
        zf.zipFolder(Paths.get(folderToZip), Paths.get(zipName));
    }
    
    @BeforeMethod
    public void precondition()
    {
        String browsername = ReadWriteData.getData("./TestData/TestData-Config.xls", "Config", 1, 0);
        String url = ReadWriteData.getData("./TestData/TestData-Config.xls", "Config", 1, 1);
        if (browsername.equals("Firefox"))
        {
            System.setProperty("webdriver.gecko.driver", "./Browsers-exe/geckodriver");
            driver = new FirefoxDriver();
        }
        else if (browsername.equals("Chrome"))
        {
            System.setProperty("webdriver.chrome.driver", "./Browsers-exe/chromedriver");
            driver = new ChromeDriver();
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
        
        driver.close();
    }
    
}

