package com.nsdc.androidMobile;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class CAFF_Mobile {
	
	

	public static void MobileMainMethod(String Module, String UserName, String Password) throws MalformedURLException, InterruptedException
	{
		AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
		service.start();
		AndroidDriver<AndroidElement> driver=Android.capabilities(Module);
//        FileWriter fr=new FileWriter("./src/PageSource.txt");
//        BufferedWriter br=new BufferedWriter(fr);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByXPath("(//*[@class='android.view.View'])[13]").click();
		Thread.sleep(1000);
		driver.findElementByXPath("//*[@class='android.widget.EditText']").sendKeys(UserName);
		driver.findElementByXPath("(//*[@class='android.view.View'])[14]").click();
		driver.findElementByXPath("(//*[@class='android.widget.EditText'])[2]").sendKeys(Password);
		driver.findElementByXPath("//*[@text='LOG IN']").click();
		driver.findElementByXPath("//android.widget.Button[@text='ALLOW ALL THE TIME']").click();// Gps allow button
		Thread.sleep(17000);	
		
//		SDMSTCCI_CenterAreas mobobj=new SDMSTCCI_CenterAreas(driver);
//		mobobj.RunCenterAreas();

//		SDMSTCCI_GeneralDetails gd= new SDMSTCCI_GeneralDetails(driver);
//		gd.RunGeneralDetails();
//		
//		SDMSTCCI_Trainer t=new SDMSTCCI_Trainer(driver);
//		t.RunTrainer();
//		
//		SDMSTCCI_ClassRoom cr= new SDMSTCCI_ClassRoom(driver);
//		cr.RunClassRoom();
//		
//		SDMSTCCI_LaboratoryDetails ld= new SDMSTCCI_LaboratoryDetails(driver);
//		ld.RunLaboratoryDetails();
//		
//		SDMSTCCI_CenterAreas ca= new SDMSTCCI_CenterAreas(driver);
//		ca.RunCenterAreas();
//		
//		SDMSTCCI_Facilities f = new SDMSTCCI_Facilities(driver);
//		f.RunFacilities();
//
//		SDMSTCCI_Equipment e=new SDMSTCCI_Equipment(driver);
//		e.RunEquipment();
//		CAAF_ResidentialFacilities rf= new CAAF_ResidentialFacilities(driver);
//		rf.RunResidentialFacilities();
		SDMSTCCI_Hybrid hd= new SDMSTCCI_Hybrid(driver);
		hd.RunHybridDetails();

// ********************************* ResidentialFacilities ************************************************
//		driver.findElementByXPath("//*[@text='ResidentialFacilities']").click();
//		driver.findElementByXPath("//*[@text='arrow back']").click();		
		
// ********************************* Hybrid Details ************************************************
//		driver.findElementByXPath("//*[@text='Hybrid Details']").click();
//		driver.findElementByXPath("//*[@text='arrow back']").click();		
						
	}

	
	
}
