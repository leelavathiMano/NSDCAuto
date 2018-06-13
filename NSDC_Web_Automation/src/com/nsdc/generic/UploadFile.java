package com.nsdc.generic;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;

public class UploadFile
{
    
    public static void upload(String filePath) throws Exception
    {
    	File file = new File(filePath);
        
        StringSelection stringSelection= new StringSelection(file.getAbsolutePath());
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
        
        Robot robot = new Robot();
             
        String osType = ReadWriteData.getData("./TestData/TestData-Config.xls", "Config", 1, 2);
        
        if (osType.equals("Windows"))
        {
        	 //Paste the clipboard value
        	
        	robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);
            
            //Press Enter key to close the Goto window and Upload window
            
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            
        }
        
        else if (osType.equals("Mac OS"))
        {
        	//Perform click in middle screen
            
            robot.mouseMove(635, 285);
            robot.mousePress(InputEvent.BUTTON1_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_MASK);
       
            //Open Goto window
            
            robot.keyPress(KeyEvent.VK_META);
            robot.keyPress(KeyEvent.VK_SHIFT);
            robot.keyPress(KeyEvent.VK_G);
            robot.keyRelease(KeyEvent.VK_META);
            robot.keyRelease(KeyEvent.VK_SHIFT);
            robot.keyRelease(KeyEvent.VK_G);
            
            robot.delay(500);
            
            //Paste the clipboard value
            
            robot.keyPress(KeyEvent.VK_META);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_META);
            robot.keyRelease(KeyEvent.VK_V);
            
            //Press Enter key to close the Goto window and Upload window
            
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            
            robot.delay(500);
            
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            
        }
        
        else if (osType.equals("Ubuntu"))
        {
            
        }
        
    }
    
}

