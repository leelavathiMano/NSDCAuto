package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SSC_DashboardPage 
{
	WebDriver driver;
	@FindBy(xpath="(//a[@class='m-menu__link m-menu__toggle'])[2]")
	private WebElement QP_NOS_ModelCurriculumTab;
	
	public SSC_DashboardPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOn_QP_NOS_ModelCurriculum()
	{
		QP_NOS_ModelCurriculumTab.click();
	}

}
