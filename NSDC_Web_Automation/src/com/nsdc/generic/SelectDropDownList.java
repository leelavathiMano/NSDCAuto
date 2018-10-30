package com.nsdc.generic;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDownList
{
    
    public static void selectDropDownListByIndex(WebElement ddl, int index)
    {
        Select sct = new Select(ddl);
        sct.selectByIndex(index);
    }
    public static void selectDropDownListByValue(WebElement ddl, String value)
    {
        Select sct = new Select(ddl);
        sct.selectByValue(value);
    }
    public static void selectDropDownListByVisibleText(WebElement ddl, String VisibleText)
    {
        Select sct = new Select(ddl);
        sct.selectByVisibleText(VisibleText);
    }
    
}

