package com.nsdc.mobile.ui.object;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.offset.PointOption;

public class Assessor_MarksUpload_For_IndividualApplicantScreen
{
	AppiumDriver appDriver;
	String instanceName;
	public Assessor_MarksUpload_For_IndividualApplicantScreen(AppiumDriver appDriver)
	{
		this.appDriver=appDriver;
		instanceName=appDriver.getClass().getName();
	}
	public void enterDomainNOS1_TheoryMarks(String dnos1TheoryMarks)
	{
		if(instanceName.contains("Android"))
		{
			appDriver.findElement(By.xpath("(//android.view.View[@text='Theory'])[1]")).clear();
			appDriver.findElement(By.xpath("(//android.view.View[@text='Theory'])[1]")).sendKeys(dnos1TheoryMarks);
		}
	}
	public void enterDomainNOS1_PracticalMarks(String dnos1PracticalMarks)
	{
		if(instanceName.contains("Android"))
		{
			appDriver.findElement(By.xpath("(//android.view.View[@text='Practical'])[1]")).clear();
			appDriver.findElement(By.xpath("(//android.view.View[@text='Practical'])[1]")).sendKeys(dnos1PracticalMarks);
		}
	}
	public void clickToSaveDomainNOS1_Marks()
	{
		if(instanceName.contains("Android"))
		{
			appDriver.findElement(By.xpath("(//android.widget.Button[@text='SAVE'])[1]")).click();
		}
	}
	public void clickOK()
	{
		if(instanceName.contains("Android"))
		{
			appDriver.findElement(By.xpath("//android.widget.Button[@text='OK']")).click();
		}
	}
	//NOS_2
	public void enterDomainNOS2_TheoryMarks(String dnos2TheoryMarks)
	{
		if(instanceName.contains("Android"))
		{
			appDriver.findElement(By.xpath("(//android.view.View[@text='Theory'])[2]")).clear();
			appDriver.findElement(By.xpath("(//android.view.View[@text='Theory'])[2]")).sendKeys(dnos2TheoryMarks);
		}
	}
	public void enterDomainNOS2_PracticalMarks(String dnos2PracticalMarks)
	{
		if(instanceName.contains("Android"))
		{
			appDriver.findElement(By.xpath("(//android.view.View[@text='Practical'])[2]")).clear();
			appDriver.findElement(By.xpath("(//android.view.View[@text='Practical'])[2]")).sendKeys(dnos2PracticalMarks);
		}
	}
	public void clickToSaveDomainNOS2_Marks()
	{
		if(instanceName.contains("Android"))
		{
			appDriver.findElement(By.xpath("(//android.widget.Button[@text='SAVE'])[2]")).click();
		}
	}
	//NOS_3
	public void enterDomainNOS3_TheoryMarks(String dnos3TheoryMarks)
	{
		if(instanceName.contains("Android"))
		{
			appDriver.findElement(By.xpath("(//android.view.View[@text='Theory'])[3]")).clear();
			appDriver.findElement(By.xpath("(//android.view.View[@text='Theory'])[3]")).sendKeys(dnos3TheoryMarks);
		}
	}
	public void enterDomainNOS3_PracticalMarks(String dnos3PracticalMarks)
	{
		if(instanceName.contains("Android"))
		{
			appDriver.findElement(By.xpath("(//android.view.View[@text='Practical'])[3]")).clear();
			appDriver.findElement(By.xpath("(//android.view.View[@text='Practical'])[3]")).sendKeys(dnos3PracticalMarks);
		}
	}
	public void clickToSaveDomainNOS3_Marks()
	{
		if(instanceName.contains("Android"))
		{
			appDriver.findElement(By.xpath("(//android.widget.Button[@text='SAVE'])[3]")).click();
		}
	}
	//NOS_4
	public void enterDomainNOS4_TheoryMarks(String dnos4TheoryMarks)
	{
		if(instanceName.contains("Android"))
		{
			appDriver.findElement(By.xpath("(//android.view.View[@text='Theory'])[4]")).clear();
			appDriver.findElement(By.xpath("(//android.view.View[@text='Theory'])[4]")).sendKeys(dnos4TheoryMarks);
		}
	}
	public void enterDomainNOS4_PracticalMarks(String dnos4PracticalMarks)
	{
		if(instanceName.contains("Android"))
		{
			appDriver.findElement(By.xpath("(//android.view.View[@text='Practical'])[4]")).clear();
			appDriver.findElement(By.xpath("(//android.view.View[@text='Practical'])[4]")).sendKeys(dnos4PracticalMarks);
		}
	}
	public void clickToSaveDomainNOS4_Marks()
	{
		if(instanceName.contains("Android"))
		{
			appDriver.findElement(By.xpath("(//android.widget.Button[@text='SAVE'])[4]")).click();
		}
	}
	//NOS_5
	public void enterDomainNOS5_TheoryMarks(String dnos5TheoryMarks)
	{
		if(instanceName.contains("Android"))
		{
			appDriver.findElement(By.xpath("(//android.view.View[@text='Theory'])[5]")).clear();
			appDriver.findElement(By.xpath("(//android.view.View[@text='Theory'])[5]")).sendKeys(dnos5TheoryMarks);
		}
	}
	public void enterDomainNOS5_PracticalMarks(String dnos5PracticalMarks)
	{
		if(instanceName.contains("Android"))
		{
			appDriver.findElement(By.xpath("(//android.view.View[@text='Practical'])[5]")).clear();
			appDriver.findElement(By.xpath("(//android.view.View[@text='Practical'])[5]")).sendKeys(dnos5PracticalMarks);
		}
	}
	public void clickToSaveDomainNOS5_Marks()
	{
		if(instanceName.contains("Android"))
		{
			appDriver.findElement(By.xpath("(//android.widget.Button[@text='SAVE'])[5]")).click();
		}
	}
	//NOS_6
	public void enterDomainNOS6_TheoryMarks(String dnos6TheoryMarks)
	{
		if(instanceName.contains("Android"))
		{
			appDriver.findElement(By.xpath("(//android.view.View[@text='Theory'])[6]")).clear();
			appDriver.findElement(By.xpath("(//android.view.View[@text='Theory'])[6]")).sendKeys(dnos6TheoryMarks);
		}
	}
	public void enterDomainNOS6_PracticalMarks(String dnos6PracticalMarks)
	{
		if(instanceName.contains("Android"))
		{
			appDriver.findElement(By.xpath("(//android.view.View[@text='Practical'])[6]")).clear();
			appDriver.findElement(By.xpath("(//android.view.View[@text='Practical'])[6]")).sendKeys(dnos6PracticalMarks);
		}
	}
	public void clickToSaveDomainNOS6_Marks()
	{
		if(instanceName.contains("Android"))
		{
			appDriver.findElement(By.xpath("(//android.widget.Button[@text='SAVE'])[6]")).click();
		}
	}
	//NOS_7
	public void enterDomainNOS7_TheoryMarks(String dnos7TheoryMarks)
	{
		if(instanceName.contains("Android"))
		{
			appDriver.findElement(By.xpath("(//android.view.View[@text='Theory'])[7]")).clear();
			appDriver.findElement(By.xpath("(//android.view.View[@text='Theory'])[7]")).sendKeys(dnos7TheoryMarks);
		}
	}
	public void enterDomainNOS7_PracticalMarks(String dnos7PracticalMarks)
	{
		if(instanceName.contains("Android"))
		{
			appDriver.findElement(By.xpath("(//android.view.View[@text='Practical'])[7]")).clear();
			appDriver.findElement(By.xpath("(//android.view.View[@text='Practical'])[7]")).sendKeys(dnos7PracticalMarks);
		}
	}
	public void clickToSaveDomainNOS7_Marks()
	{
		if(instanceName.contains("Android"))
		{
			appDriver.findElement(By.xpath("(//android.widget.Button[@text='SAVE'])[7]")).click();
		}
	}
	//NOS_8
	public void enterDomainNOS8_TheoryMarks(String dnos8TheoryMarks)
	{
		if(instanceName.contains("Android"))
		{
			appDriver.findElement(By.xpath("(//android.view.View[@text='Theory'])[8]")).clear();
			appDriver.findElement(By.xpath("(//android.view.View[@text='Theory'])[8]")).sendKeys(dnos8TheoryMarks);
		}
	}
	public void enterDomainNOS8_PracticalMarks(String dnos8PracticalMarks)
	{
		if(instanceName.contains("Android"))
		{
			appDriver.findElement(By.xpath("(//android.view.View[@text='Practical'])[8]")).clear();
			appDriver.findElement(By.xpath("(//android.view.View[@text='Practical'])[8]")).sendKeys(dnos8PracticalMarks);
		}
	}
	public void clickToSaveDomainNOS8_Marks()
	{
		if(instanceName.contains("Android"))
		{
			appDriver.findElement(By.xpath("(//android.widget.Button[@text='SAVE'])[8]")).click();
		}
	}
	//NOS_9
	public void enterDomainNOS9_TheoryMarks(String dnos9TheoryMarks)
	{
		if(instanceName.contains("Android"))
		{
			appDriver.findElement(By.xpath("(//android.view.View[@text='Theory'])[9]")).clear();
			appDriver.findElement(By.xpath("(//android.view.View[@text='Theory'])[9]")).sendKeys(dnos9TheoryMarks);
		}
	}
	public void enterDomainNOS9_PracticalMarks(String dnos9PracticalMarks)
	{
		if(instanceName.contains("Android"))
		{
			appDriver.findElement(By.xpath("(//android.view.View[@text='Practical'])[9]")).clear();
			appDriver.findElement(By.xpath("(//android.view.View[@text='Practical'])[9]")).sendKeys(dnos9PracticalMarks);
		}
	}
	public void clickToSaveDomainNOS9_Marks()
	{
		if(instanceName.contains("Android"))
		{
			appDriver.findElement(By.xpath("(//android.widget.Button[@text='SAVE'])[9]")).click();
		}
	}
	//NOS_10
	public void enterDomainNOS10_TheoryMarks(String dnos10TheoryMarks)
	{
		if(instanceName.contains("Android"))
		{
			appDriver.findElement(By.xpath("(//android.view.View[@text='Theory'])[10]")).clear();
			appDriver.findElement(By.xpath("(//android.view.View[@text='Theory'])[10]")).sendKeys(dnos10TheoryMarks);
		}
	}
	public void enterDomainNOS10_PracticalMarks(String dnos10PracticalMarks)
	{
		if(instanceName.contains("Android"))
		{
			appDriver.findElement(By.xpath("(//android.view.View[@text='Practical'])[10]")).clear();
			appDriver.findElement(By.xpath("(//android.view.View[@text='Practical'])[10]")).sendKeys(dnos10PracticalMarks);
		}
	}
	public void clickToSaveDomainNOS10_Marks()
	{
		if(instanceName.contains("Android"))
		{
			appDriver.findElement(By.xpath("(//android.widget.Button[@text='SAVE'])[10]")).click();
		}
	}
	//NOS_11
	public void enterDomainNOS11_TheoryMarks(String dnos11TheoryMarks)
	{
		if(instanceName.contains("Android"))
		{
			appDriver.findElement(By.xpath("(//android.view.View[@text='Theory'])[11]")).clear();
			appDriver.findElement(By.xpath("(//android.view.View[@text='Theory'])[11]")).sendKeys(dnos11TheoryMarks);
		}
	}
	public void enterDomainNOS11_PracticalMarks(String dnos11PracticalMarks)
	{
		if(instanceName.contains("Android"))
		{
			appDriver.findElement(By.xpath("(//android.view.View[@text='Practical'])[11]")).clear();
			appDriver.findElement(By.xpath("(//android.view.View[@text='Practical'])[11]")).sendKeys(dnos11PracticalMarks);
		}
	}
	public void clickToSaveDomainNOS11_Marks()
	{
		if(instanceName.contains("Android"))
		{
			appDriver.findElement(By.xpath("(//android.widget.Button[@text='SAVE'])[11]")).click();
		}
	}
	public void clickNext()
	{
		if(instanceName.contains("Android"))
		{
			appDriver.findElement(By.xpath("//android.widget.Button[contains(@text,'NEXT')]")).click();
		}
	}
	public void tapNocCode(String nosCode)
	{
		if(instanceName.contains("Android"))
		{
			int  nosX=appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+nosCode+"')]")).getLocation().getX();
			int nosY=appDriver.findElement(By.xpath("//android.view.View[contains(@text,'"+nosCode+"')]")).getLocation().getY();
			TouchAction act = new TouchAction(appDriver);
			act.press(new PointOption().withCoordinates(nosX, nosY)).waitAction(waitOptions(Duration.ofSeconds(5))).release().perform();
		}
	}
	public void clickSubmit()
	{
		if(instanceName.contains("Android"))
		{
			appDriver.findElement(By.xpath("//android.widget.Button[contains(@text,'SUBMIT')]")).click();
		}
	}
}