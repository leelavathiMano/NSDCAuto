package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.SelectDropDownList;

public class SA_ViewJobRoleRecommendationRequestPage 
{
	
	WebDriver driver;
	
	@FindBy(xpath="//select[@formcontroname='trainingCentreName']")
	private WebElement tcNameDropDownList;
	@FindBy(xpath="//select[@formcontroname='jobRole']")
	private WebElement jobRoleDropDownList;
	@FindBy(xpath="//select[@formcontroname='status']")
	private WebElement statusDropDownList;
	@FindBy(xpath="//select[@formcontroname='assignedOn']")
	private WebElement assignOnDropDownList;
	@FindBy(xpath="//button[text()='Apply']")
	private WebElement applyButton;
	@FindBy(xpath="//button[text()='Back']")
	private WebElement backButton;
	//tr[td[span[text()='Government Training Centre']]]//a[contains(text(),'Approve/Reject')]
	//tr[td[span[text()='Government Training Centre']]]//a[contains(text(),'View Job Role Details')]
	//tr[td[span[text()='Government Training Centre']]]//a[contains(text(),'View Submitted CAAF')]
	@FindBy(xpath="//label[input[@value='approved']]/span")
	private WebElement approvedRadioButton;
	@FindBy(xpath="//label[input[@value='rejected']]/span")
	private WebElement notApprovedRadioButton;
	@FindBy(xpath="//textarea[@formcontrolname='comment']")
	private WebElement reviewCommentTextbox;
	@FindBy(xpath="//button[contains(text(),'Submit')]")
	private WebElement submitButton;
	@FindBy(xpath="//button[contains(text(),'Close')]")
	private WebElement closeButton;
	@FindBy(xpath="//button[text()='OK']")
	private WebElement okButton;
	
	
	public SA_ViewJobRoleRecommendationRequestPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void selectTrainingCentreName(String tcName)
	{
		SelectDropDownList.selectDropDownListByVisibleText(tcNameDropDownList, tcName);
	}
	
	public void selectJobRole(String jobRole)
	{
		SelectDropDownList.selectDropDownListByVisibleText(jobRoleDropDownList, jobRole);
	}
	
	public void selectStatus(String status)
	{
		SelectDropDownList.selectDropDownListByVisibleText(statusDropDownList, status);
	}
	
	public void selectAssignedOn(String assignedOn)
	{
		SelectDropDownList.selectDropDownListByVisibleText(assignOnDropDownList, assignedOn);
	}
	
	public void clickOnApply()
	{
		applyButton.click();
	}
	
	public void clickOnBack()
	{
		backButton.click();
	}
	
	public void clickOnApproved()
	{
		approvedRadioButton.click();
	}
	
	public void clickOnNotApproved()
	{
		notApprovedRadioButton.click();
	}
	
	public void enterReviewComments(String reviewComments)
	{
		reviewCommentTextbox.clear();
		reviewCommentTextbox.sendKeys(reviewComments);
	}
	
	public void clickOnSubmit()
	{
		submitButton.click();
	}
	
	public void clickOnClose()
	{
		closeButton.click();
	}
	
	public void clickOnOK()
	{
		okButton.click();
	}

}
