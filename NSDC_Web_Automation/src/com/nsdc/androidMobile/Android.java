package com.nsdc.androidMobile;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Android {

	
	public static  AndroidDriver<AndroidElement> capabilities(String module) throws MalformedURLException {
//		File appDir = new File("src");
//		File app = new File(appDir, "FeebasedTC(0.0.9).apk");
		DesiredCapabilities dc = new DesiredCapabilities();
//		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Demo");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
//		dc.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");

		if(module=="CAFF")
		{dc.setCapability("appPackage","com.transneuron.nsdl");
		 dc.setCapability("appActivity", "com.transneuron.nsdl.MainActivity");			
		}
		
		if(module=="FeeBased")
		{dc.setCapability("appPackage","io.ionic.feebasedtcskillindia");
		 dc.setCapability("appActivity", "io.ionic.feebasedtcskillindia.MainActivity");		
		}

// ******************FeeBased APP*******************

//		dc.setCapability("appPackage","io.ionic.feebasedtcskillindia");
//		dc.setCapability("appActivity", "io.ionic.feebasedtcskillindia.MainActivity");

// ******************Assessor APP*******************		
		
//		dc.setCapability("appPackage","com.nsdc.tntplt");
//		dc.setCapability("appActivity", "com.nsdc.tntplt.MainActivity");
		
// ******************Assessor APP*******************	
		
//		dc.setCapability("appPackage","com.nsdc.assessor");
//		dc.setCapability("appActivity", "acpl.com.simple_rdservicecalldemo_android.LoginActivity");		

// ******************CAFF APP*******************		
		
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),dc);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	return driver;
		
	
	}

}
