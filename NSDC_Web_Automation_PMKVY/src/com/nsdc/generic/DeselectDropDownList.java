package com.nsdc.generic;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DeselectDropDownList
{
    
    public static void deselectDropDownListByIndex(WebElement ddl, int index)
    {
        Select sct = new Select(ddl);
        sct.deselectByIndex(index);
    }
    public static void deselectDropDownListByValue(WebElement ddl, String value)
    {
        Select sct = new Select(ddl);
        sct.deselectByValue(value);
    }
    public static void deselectDropDownListByVisibleText(WebElement ddl, String VisibleText)
    {
        Select sct = new Select(ddl);
        sct.deselectByVisibleText(VisibleText);
    }
    public static void deselectDropDownListAll(WebElement ddl)
    {
        Select sct = new Select(ddl);
        sct.deselectAll();
    }
    
}

