package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SSC_QPNOS_Model_CurriculumPage 
{
	WebDriver driver;
	
	@FindBy(xpath="//div[@routerlink='create-qp']")
	private WebElement createQP_Tab;
	@FindBy(xpath="//div[@routerlink='view-all-qps']")
	private WebElement viewAllExistingQP_Tab;
	@FindBy(xpath="//div[@routerlink='nos-general-details']")
	private WebElement createNOS_Tab;
	@FindBy(xpath="//div[@routerlink='view-nos']")
	private WebElement viewAllNOSs_Tab;
	
	public SSC_QPNOS_Model_CurriculumPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOn_CreateQP()
	{
		createQP_Tab.click();
	}
	
	public void clickOn_ViewAllExistingQP()
	{
		viewAllExistingQP_Tab.click();
	}
	
	public void clickOn_CreateNOS()
	{
		createNOS_Tab.click();
	}
	
	public void clickOn_ViewAllNOSs()
	{
		viewAllNOSs_Tab.click();
	}
}
