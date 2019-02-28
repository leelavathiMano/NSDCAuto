package com.nsdc.regressionTest;


import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nsdc.generic.ReadMultipleDataFromExcel;
import com.nsdc.generic.ReadWriteData;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.StartsActivity;
import io.appium.java_client.touch.offset.PointOption;

public class CandidateSync_WorkflowTestSC_19
{

public String createdCandidateId;
	@SuppressWarnings("rawtypes")
	public static void scrollScreenForMobile(AppiumDriver appDriver) throws Exception 
	{
		Thread.sleep(2000);
		Dimension winsize = appDriver.manage().window().getSize();
		
		int startx = (winsize.width * 0)/100;
		int endx = (winsize.width * 15)/100;
		int starty = (winsize.width * 0)/100;
		int endy = (winsize.width * 80)/100;
		
		TouchAction act = new TouchAction(appDriver);
		act.press(new PointOption().withCoordinates(startx, starty)).waitAction(waitOptions(Duration.ofSeconds(2))).moveTo(point(endx, endy)).release().perform();
		Thread.sleep(3000);
	}
	
	@SuppressWarnings("rawtypes")
	public static void scrollScreenForMobileForDone(AppiumDriver appDriver) throws Exception 
	{
		Thread.sleep(2000);
		Dimension winsize = appDriver.manage().window().getSize();
		
		int startx = (winsize.width * 0)/100;
		int endx = (winsize.width * 25)/100;
		int starty = (winsize.width * 0)/100;
		int endy = (winsize.width * 35)/100;
		
		TouchAction act = new TouchAction(appDriver);
		act.press(new PointOption().withCoordinates(startx, starty)).waitAction(waitOptions(Duration.ofSeconds(2))).moveTo(point(endx, endy)).release().perform();
		Thread.sleep(3000);
	}
	
	
	@SuppressWarnings("rawtypes")
	public static void scrollScreenForMobileUp(AppiumDriver appDriver) throws Exception 
	{
		Thread.sleep(2000);
		Dimension winsize = appDriver.manage().window().getSize();
		
		int startx = (winsize.width * 25)/100;
		int endx = (winsize.width * 0)/100;
		int starty = (winsize.width * 40)/100;
		int endy = (winsize.width * 0)/100;
		
		TouchAction act = new TouchAction(appDriver);
		act.press(new PointOption().withCoordinates(startx, starty)).waitAction(waitOptions(Duration.ofSeconds(2))).moveTo(point(endx, endy)).release().perform();
		Thread.sleep(3000);
	}
	
	@DataProvider
    public Object[][] registrationData()
    {
        return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/CandidateSync-Workflow.xls", "CandidateRegisteration_Offline");
    }
    
    @SuppressWarnings("rawtypes")
	@Test(dataProvider="registrationData")
    public void canSyncOfflineTC_01(String fullName, String Guardianname, String EmailAddress, String MobileNumber,String gender, String pincode) throws MalformedURLException, Exception

	{
		   DesiredCapabilities cap = new DesiredCapabilities();
	        
		        cap.setCapability("platformName", "Android");
	           cap.setCapability("platformVersion", "8.1.0");
	           cap.setCapability("deviceName", "032872488T062365");
	           cap.setCapability("appPackage", "com.sdms.candidate_offline");
	           cap.setCapability("appActivity", "com.sdms.candidate_offline.MainActivity");
	           cap.setCapability("noReset", "true");

	           AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);
	          
	           driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
	           ((AppiumDriver)driver).runAppInBackground(Duration.ofSeconds(2));
	           ((StartsActivity)driver).currentActivity();
	           driver.findElement(By.xpath("//android.widget.Button[@text='Register']")).click();
	           driver.findElement(By.xpath("//android.widget.Image[@text='registrationlogo']")).click();
	           driver.findElementById("com.mediatek.camera:id/rlk_camera_switcher").click();
	           driver.findElementById("com.mediatek.camera:id/shutter_button").click();
	           driver.findElementById("com.mediatek.camera:id/done_button").click();
	           Thread.sleep(4000);
	           driver.findElementById("userName").clear();
	           driver.findElementById("userName").sendKeys(fullName);
	           driver.findElementById("guardianName").clear();
	           driver.findElementById("guardianName").sendKeys(Guardianname);
	           driver.findElementById("email").clear();
	          driver.findElementById("email").sendKeys(EmailAddress);
	           driver.findElementById("mobileNumber").clear();
	           driver.findElementById("mobileNumber").sendKeys(MobileNumber);
	           Thread.sleep(4000);
	           driver.findElementById("gender").click();
	           driver.findElement(By.xpath("//android.view.View[@text='"+gender+"']")).click();
	           driver.findElementById("dob").click();
	           Thread.sleep(2000);
	           CandidateSync_WorkflowTestSC_19.scrollScreenForMobile(driver);
	           ((AppiumDriver)driver).runAppInBackground(Duration.ofSeconds(2));
	           ((StartsActivity)driver).currentActivity();
	           driver.findElement(By.xpath("//android.widget.Button[contains(@text,'DONE')]")).click();
	           Thread.sleep(6000);
	           CandidateSync_WorkflowTestSC_19.scrollScreenForMobile(driver);
	           driver.findElement(By.xpath("(//android.widget.Spinner)[3]")).click();
	           Thread.sleep(7000);
	           driver.findElement(By.xpath("(//android.widget.RadioButton)[4]")).click();
	           Thread.sleep(5000);
	           driver.findElementById("pincode").clear();
	           driver.findElementById("pincode").sendKeys(pincode);
	           Thread.sleep(3000);
	          CandidateSync_WorkflowTestSC_19.scrollScreenForMobile(driver);
	          CandidateSync_WorkflowTestSC_19.scrollScreenForMobile(driver);
	          Thread.sleep(3000);
	           driver.findElement(By.xpath("(//android.widget.Spinner)[4]")).click();
	           driver.findElement(By.xpath("(//android.widget.RadioButton)[4]")).click();
	           Thread.sleep(6000);
	           CandidateSync_WorkflowTestSC_19.scrollScreenForMobile(driver);
	           CandidateSync_WorkflowTestSC_19.scrollScreenForMobile(driver);
	           driver.findElement(By.xpath("(//android.widget.Spinner)[5]")).click();
	           Thread.sleep(6000);
	           driver.findElement(By.xpath("(//android.widget.RadioButton)[5]")).click();
	           CandidateSync_WorkflowTestSC_19.scrollScreenForMobileForDone(driver);
	           driver.findElementById("program").click();
	           driver.findElement(By.xpath("(//android.widget.RadioButton)[2]")).click();
	           Thread.sleep(4000);
	           driver.findElementById("organation").click();
	           driver.findElement(By.xpath("(//android.widget.RadioButton)[3]")).click();
	           driver.findElementById("cio").click();
	           driver.findElement(By.xpath("(//android.widget.RadioButton)[3]")).click();
	          Thread.sleep(4000);
	           CandidateSync_WorkflowTestSC_19.scrollScreenForMobileForDone(driver);
	           driver.findElement(By.xpath("(//android.widget.RadioButton)[1]")).click();
	           driver.findElement(By.xpath("//android.widget.Button[@text='Submit Details']")).click();
	           Assert.assertEquals(driver.findElement(By.xpath("//android.view.View[@text='User registered successfully.']")).getText().trim(), "User registered successfully.");
	           Thread.sleep(4000);
	           driver.findElement(By.xpath("//android.widget.Button[contains(@text,'OKAY')]")).click();
	           Thread.sleep(8000);
	        /*   CandidateSync.scrollScreenForMobileUp(driver);
	         //  Thread.sleep(3000);
	           CandidateSync.scrollScreenForMobileUp(driver);
	         //  Thread.sleep(3000);
	           CandidateSync.scrollScreenForMobileUp(driver);
	           CandidateSync.scrollScreenForMobileUp(driver);
	           //  Thread.sleep(3000);
	             CandidateSync.scrollScreenForMobileUp(driver);
	           //  Thread.sleep(3000);
	             CandidateSync.scrollScreenForMobileUp(driver);
	           driver.findElement(By.xpath("//android.widget.Button[contains(@text,'arrow back')]")).click();
	           Thread.sleep(4000);
	           driver.findElement(By.xpath("//android.widget.Button[contains(@text,'View Registered Data')]")).click();
	           Thread.sleep(5000);
	           driver.findElement(By.xpath("//android.widget.Button[contains(@text,'Sync')]")).click();
	           Thread.sleep(3000);
	           driver.findElement(By.xpath("//android.widget.Button[contains(@text,'OKAY')]")).click();*/

	}
    
    
    
    
    @DataProvider
    public Object[][] registrationData1()
    {
        return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/CandidateSync-Workflow.xls", "CandidateRegisteration_Online");
    }
    
    @SuppressWarnings("rawtypes")
	@Test(dataProvider="registrationData1")
    public void canSyncOnlineTC_02(String sno,String fullName, String guardianname, String emailAddress, String mobileNumber,String gender, String pincode, String candidate_Username, String candidate_Password, String candidate_Confirm_Password) throws MalformedURLException, Exception

	{
		   DesiredCapabilities cap = new DesiredCapabilities();
	        
		        cap.setCapability("platformName", "Android");
	           cap.setCapability("platformVersion", "8.1.0");
	           cap.setCapability("deviceName", "032872488T062365");
	           cap.setCapability("appPackage", "com.sdms.candidate");
	           cap.setCapability("appActivity", "com.sdms.candidate.MainActivity");
	           cap.setCapability("noReset", "true");

	           AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);
	          
	           driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
	           ((AppiumDriver)driver).runAppInBackground(Duration.ofSeconds(2));
	           ((StartsActivity)driver).currentActivity();
	           driver.findElement(By.xpath("//android.widget.Button[@text='Register']")).click();
	           driver.findElement(By.xpath("//android.widget.Image[@text='registrationlogo']")).click();
	           driver.findElementById("com.mediatek.camera:id/rlk_camera_switcher").click();
	           driver.findElementById("com.mediatek.camera:id/shutter_button").click();
	           driver.findElementById("com.mediatek.camera:id/done_button").click();
	           Thread.sleep(4000);
	           driver.findElementById("userName").clear();
	           driver.findElementById("userName").sendKeys(fullName);
	           driver.findElementById("guardianName").clear();
	           driver.findElementById("guardianName").sendKeys(guardianname);
	           driver.findElementById("email").clear();
	          driver.findElementById("email").sendKeys(emailAddress);
	           driver.findElementById("mobileNumber").clear();
	           driver.findElementById("mobileNumber").sendKeys(mobileNumber);
	           Thread.sleep(4000);
	           driver.findElementById("gender").click();
	           driver.findElement(By.xpath("//android.view.View[@text='"+gender+"']")).click();
	           driver.findElementById("dob").click();
	           Thread.sleep(2000);
	           CandidateSync_WorkflowTestSC_19.scrollScreenForMobile(driver);
	           ((AppiumDriver)driver).runAppInBackground(Duration.ofSeconds(2));
	           ((StartsActivity)driver).currentActivity();
	           driver.findElement(By.xpath("//android.widget.Button[contains(@text,'DONE')]")).click();
	           Thread.sleep(6000);
	           CandidateSync_WorkflowTestSC_19.scrollScreenForMobile(driver);
	           driver.findElement(By.xpath("(//android.widget.Spinner)[3]")).click();
	           Thread.sleep(7000);
	           driver.findElement(By.xpath("(//android.widget.RadioButton)[4]")).click();
	           Thread.sleep(5000);
	           driver.findElementById("pincode").clear();
	           driver.findElementById("pincode").sendKeys(pincode);
	           Thread.sleep(3000);
	          CandidateSync_WorkflowTestSC_19.scrollScreenForMobile(driver);
	          CandidateSync_WorkflowTestSC_19.scrollScreenForMobile(driver);
	          Thread.sleep(3000);
	           driver.findElement(By.xpath("(//android.widget.Spinner)[4]")).click();
	           driver.findElement(By.xpath("(//android.widget.RadioButton)[4]")).click();
	           Thread.sleep(6000);
	           CandidateSync_WorkflowTestSC_19.scrollScreenForMobile(driver);
	           CandidateSync_WorkflowTestSC_19.scrollScreenForMobile(driver);
	           driver.findElement(By.xpath("(//android.widget.Spinner)[5]")).click();
	           Thread.sleep(6000);
	           driver.findElement(By.xpath("(//android.widget.RadioButton)[5]")).click();
	           CandidateSync_WorkflowTestSC_19.scrollScreenForMobileForDone(driver);
	           driver.findElementById("program").click();
	           driver.findElement(By.xpath("(//android.widget.RadioButton)[2]")).click();
	           Thread.sleep(4000);
	           driver.findElementById("organation").click();
	           driver.findElement(By.xpath("(//android.widget.RadioButton)[3]")).click();
	           driver.findElementById("cio").click();
	           driver.findElement(By.xpath("(//android.widget.RadioButton)[3]")).click();
	          Thread.sleep(4000);
	           CandidateSync_WorkflowTestSC_19.scrollScreenForMobileForDone(driver);
	           driver.findElement(By.xpath("(//android.widget.RadioButton)[1]")).click();
	           driver.findElement(By.xpath("//android.widget.Button[@text='Submit Details']")).click();
	           Assert.assertEquals(driver.findElement(By.xpath("//android.view.View[contains(@text,'Successfully ')]")).getText().trim(), "Successfully Registered !!");
	           Thread.sleep(4000);
	           String candidateId = driver.findElement(By.xpath("//android.view.View[contains(@text,'Your Candidate ID ')]")).getText();
	           System.out.println(candidateId);
	          //createdCandidateId= candidateId.replace("Your Candidate ID ", "");
	         //  System.out.println(createdCandidateId);
	          String createdCandidateUserName =  candidateId.substring(18, 28);
	           System.out.println(createdCandidateUserName);
	           ReadWriteData.setExcelData("./TestData/Workflow/CandidateSync-Workflow.xls", "CandidateRegisteration_Online",Integer.parseInt(sno), 7, createdCandidateUserName);
	           ReadWriteData.setExcelData("./TestData/Workflow/CandidateSync-Workflow.xls", "CandidateRegisteration_Online",Integer.parseInt(sno), 8, createdCandidateUserName);
	           driver.findElement(By.xpath("//android.widget.Button[contains(@text,'LOGIN')]")).click();
	           driver.findElement(By.xpath("//android.view.View[contains(@text,'ENTER YOUR USER ID')]")).clear();
	           driver.findElement(By.xpath("//android.view.View[contains(@text,'ENTER YOUR USER ID')]")).sendKeys(createdCandidateUserName);
	           Thread.sleep(3000);
	           driver.findElement(By.xpath("//android.view.View[contains(@text,'ENTER PASSWORD')]")).clear();
	           driver.findElement(By.xpath("//android.view.View[contains(@text,'ENTER PASSWORD')]")).sendKeys(createdCandidateUserName);
	           Thread.sleep(4000);
	           driver.findElement(By.xpath("//android.widget.Button[contains(@text,'Sign In')]")).click();
	           Thread.sleep(8000);
	           driver.findElement(By.xpath("//android.view.View[contains(@text,'OLD PASSWORD')]")).clear();
	           driver.findElement(By.xpath("//android.view.View[contains(@text,'OLD PASSWORD')]")).sendKeys(createdCandidateUserName);
	           Thread.sleep(3000);
	           driver.findElement(By.xpath("//android.view.View[contains(@text,'NEW PASSWORD')]")).clear();
	           driver.findElement(By.xpath("//android.view.View[contains(@text,'NEW PASSWORD')]")).sendKeys(candidate_Confirm_Password);
	           Thread.sleep(3000);
	           driver.findElement(By.xpath("//android.view.View[contains(@text,'CONFIRM PASSWORD')]")).clear();
	           driver.findElement(By.xpath("//android.view.View[contains(@text,'CONFIRM PASSWORD')]")).sendKeys(candidate_Confirm_Password);
	           Thread.sleep(3000);
	           driver.findElement(By.xpath("//android.widget.Button[contains(@text,'CONTINUE')]")).click();
	           Thread.sleep(8000);
	           driver.findElement(By.xpath("//android.widget.Button[contains(@text,'OK')]")).click();
	           Thread.sleep(3000);
	           driver.findElement(By.xpath("//android.view.View[contains(@text,'ENTER YOUR USER ID')]")).clear();
	           driver.findElement(By.xpath("//android.view.View[contains(@text,'ENTER YOUR USER ID')]")).sendKeys(createdCandidateUserName);
	           Thread.sleep(3000);
	           driver.findElement(By.xpath("//android.view.View[contains(@text,'ENTER PASSWORD')]")).clear();
	           driver.findElement(By.xpath("//android.view.View[contains(@text,'ENTER PASSWORD')]")).sendKeys(candidate_Confirm_Password);
	           Thread.sleep(4000);
	           driver.findElement(By.xpath("//android.widget.Button[contains(@text,'Sign In')]")).click();
	           Thread.sleep(8000);
	           driver.findElement(By.xpath("//android.widget.Button[contains(@text,'menu')]")).click();
	           Thread.sleep(4000);
	           driver.findElement(By.xpath("//android.widget.Button[contains(@text,'log out-outline Log Out')]")).click();
	           Thread.sleep(4000);
	           Assert.assertEquals(driver.findElement(By.xpath("//android.view.View[contains(@text,'Your are logged out Successfully')]")).getText().trim(), "Your are logged out Successfully");
	           driver.findElement(By.xpath("//android.widget.Button[contains(@text,'OK')]")).click();
	        /*   CandidateSync.scrollScreenForMobileUp(driver);
	         //  Thread.sleep(3000);
	           CandidateSync.scrollScreenForMobileUp(driver);
	         //  Thread.sleep(3000);
	           CandidateSync.scrollScreenForMobileUp(driver);
	           CandidateSync.scrollScreenForMobileUp(driver);
	           //  Thread.sleep(3000);
	             CandidateSync.scrollScreenForMobileUp(driver);
	           //  Thread.sleep(3000);
	             CandidateSync.scrollScreenForMobileUp(driver);
	           driver.findElement(By.xpath("//android.widget.Button[contains(@text,'arrow back')]")).click();
	           Thread.sleep(4000);
	           driver.findElement(By.xpath("//android.widget.Button[contains(@text,'View Registered Data')]")).click();
	           Thread.sleep(5000);
	           driver.findElement(By.xpath("//android.widget.Button[contains(@text,'Sync')]")).click();
	           Thread.sleep(3000);
	           driver.findElement(By.xpath("//android.widget.Button[contains(@text,'OKAY')]")).click();*/

	}
	}