package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TP_FeeBased_DashboardPage 
{
	
	WebDriver driver;
	
	@FindBy(xpath="//div[p[text()='View Training Centres']]")
	private WebElement viewAllTrainingCentreButton;
	@FindBy(xpath="//div[p[text()='View Sector & Courses']]")
	private WebElement viewSectorAndCoursesButton;
	@FindBy(xpath="//div[p[text()='View Trainers']]")
	private WebElement viewTrainersButton;
	@FindBy(xpath="//div[p[text()='View Assessment Agency & Assessors']]")
	private WebElement viewAssessmentAgencyButton;
	
	public TP_FeeBased_DashboardPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnViewTrainingCentres()
	{
		viewAllTrainingCentreButton.click();
	}
	
	public void clickOnViewSectorAndCourses()
	{
		viewSectorAndCoursesButton.click();
	}
	
	public void clickOnViewTrainers()
	{
		viewTrainersButton.click();
	}
	
	public void clickOnViewAssessmentAgencyAndAssessors()
	{
		viewAssessmentAgencyButton.click();
	}

}
