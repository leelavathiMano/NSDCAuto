package com.nsdc.generic;

import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class GUIFunctionality
{
	public static void dateuploadFile() throws Exception
	{
		Pattern filepath = new Pattern("./UploadFiles/Capture1.PNG");
		Pattern open = new Pattern("./UploadFiles/Capture2.PNG");
		Pattern open2 = new Pattern("./UploadFiles/Capture3.PNG");
		Screen src = new Screen();
		src.setAutoWaitTimeout(40);
		Thread.sleep(2000);
		src.click(filepath);
		src.click(open);
		src.click(open2);
	}
	
	
	
}
