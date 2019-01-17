package com.nsdc.generic;

import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class GUIFunctionality
{
	public static void selectDate() throws Exception
	{
		Pattern datePicker = new Pattern("./SikuliImages/DatePicker.PNG");
		Pattern calendar = new Pattern("./SikuliImages/Calendar.PNG");
		Pattern date = new Pattern("./SikuliImages/Date.PNG");
		Screen src = new Screen();
		src.setAutoWaitTimeout(40);
		Thread.sleep(2000);
		src.click(datePicker);
		src.click(calendar);
		src.click(date);
	}
	
	public static void dateuploadFile() throws Exception
	{
		Pattern login = new Pattern("./SikuliImages/Capture8.PNG");
		Screen src = new Screen();
		src.setAutoWaitTimeout(40);
		Thread.sleep(2000);
		src.click(login);
	}
	
}
