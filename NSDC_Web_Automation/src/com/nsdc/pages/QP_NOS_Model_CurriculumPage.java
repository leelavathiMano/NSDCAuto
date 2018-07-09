package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QP_NOS_Model_CurriculumPage 
{
	WebDriver driver;
	
	@FindBy(xpath="(//div[@class='m-widget17__item'])[1]")
	private WebElement createQP_Tab;
	@FindBy(xpath="(//div[@class='m-widget17__item'])[2]")
	private WebElement viewAllExistingQP_Tab;
	@FindBy(xpath="(//div[@class='m-widget17__item'])[3]")
	private WebElement createNOS_Tab;
	@FindBy(xpath="(//div[@class='m-widget17__item'])[4]")
	private WebElement viewAllNOSs_Tab;
	
	public QP_NOS_Model_CurriculumPage(WebDriver driver)
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
