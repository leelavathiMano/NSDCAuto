package com.nsdc.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.SelectDropDownList;

public class IA_TC_ContinousMonitoringPage 
{
	WebDriver driver;
	
	@FindBy(linkText="Continuous Monitoring")
	private WebElement continiousMoniteringButton;
	@FindBy(xpath="//input[@id='generalSearch']")
	private WebElement searchTextbox;
	@FindBy(xpath="(//select[@formcontrolname='assignTo'])[1]")
	private WebElement assignedToDropDownList;
	@FindBy(xpath="//input[@formcontrolname='revertByDate']")
	private WebElement revertByDateTextbox;
	@FindBy(xpath="//button[contains(text(),'Assign Desktop Assessor')]")
	private WebElement assignDesktopAssessorButton;
	@FindBy(xpath="(//button[contains(text(),'Cancel')])[2]")
	private WebElement cancelButton;
	
	
	
	
	public IA_TC_ContinousMonitoringPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	public void clickOnContiniousMonitering()
	{
		continiousMoniteringButton.click();
	}
	
	public void enterForSearch(String tcID)
	{
		searchTextbox.clear();
		searchTextbox.sendKeys(tcID);
	}
	
//	public void selectForAssignedTo(String assignedTo)
//	{
//		SelectDropDownList.selectDropDownListByVisibleText(assignedToDropDownList, assignedTo);
//	}
	
	public void selectForAssignedTo(String assignedTo)
	{
		SelectDropDownList.selectDropDownListByIndex(assignedToDropDownList, 1);
	}
	
	public void enterRevertByDate()
	{
		revertByDateTextbox.click();
		revertByDateTextbox.sendKeys(Keys.ARROW_RIGHT, Keys.ENTER, Keys.TAB);
	}
	
	public void clickOnAssignDesktopAssessor()
	{
		assignDesktopAssessorButton.click();
	}
	
	public void clickOnCancel()
	{
		cancelButton.click();
	}

}
