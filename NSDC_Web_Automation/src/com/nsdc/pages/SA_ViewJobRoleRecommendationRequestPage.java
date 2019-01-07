package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.SelectDropDownList;

public class SA_ViewJobRoleRecommendationRequestPage 
{
	
	WebDriver driver;
	
	@FindBy(xpath="//input[@placeholder='trainingCentreName']")
	private WebElement tcNameTextbox;
	@FindBy(xpath="//select[@formcontroname='jobRole']")
	private WebElement jobRoleDropDownList;
	@FindBy(xpath="//select[@formcontrolname='status']")
	private WebElement statusDropDownList;
	@FindBy(xpath="//select[@formcontroname='assignedOn']")
	private WebElement assignOnDropDownList;
	@FindBy(xpath="//button[text()='Apply']")
	private WebElement applyButton;
	@FindBy(xpath="//button[text()='Reset']")
	private WebElement resetButton;
	@FindBy(xpath="//button[text()='Back']")
	private WebElement backButton;
	@FindBy(xpath="//button[contains(text(),'Go Back')]")
	private WebElement goBackButton;
	@FindBy(xpath="//button[contains(text(),'Approve/Reject')]")
	private WebElement approveOrRejectButton;
	//tr[td[span[text()='Government Training Centre']]]//a[contains(text(),'Approve/Reject')]
	//tr[td[span[text()='Government Training Centre']]]//a[contains(text(),'View Job Role Details')]
	//tr[td[span[text()='Government Training Centre']]]//a[contains(text(),'View Submitted CAAF')]
	@FindBy(xpath="//label[input[@value='approved']]/span")
	private WebElement approvedRadioButton;
	@FindBy(xpath="//label[input[@value='rejected']]/span")
	private WebElement notApprovedRadioButton;
	@FindBy(xpath="//textarea[@formcontrolname='comment']")
	private WebElement reviewCommentTextbox;
	@FindBy(xpath="//button[@class='btn btn-next']")
	private WebElement submitButton;
	@FindBy(xpath="//button[contains(text(),'Close')]")
	private WebElement closeButton;
	@FindBy(xpath="//button[text()='OK']")
	private WebElement okButton;
	@FindBy(xpath="//select[@class='btn btn-secondary ng-untouched ng-pristine ng-valid']")
	private WebElement paginationDropDownList;
	
	@FindBy(xpath="//label[input[@value='accept']]/span")
	private WebElement acceptInspectionDateRadioButton;
	@FindBy(xpath="//label[input[@value='reject']]/span")
	private WebElement rejectInspectionDateRadioButton;
	@FindBy(xpath="//textarea[@formcontrolname='remarks']")
	private WebElement reviewCommentsForInspectionDateTextbox;
	@FindBy(xpath="(//button[@class='btn btn-next'])[1]")
	private WebElement submitForInspectionDateButton;
	@FindBy(xpath="//button[contains(text(),'Cancel')]")
	private WebElement cancelButton;
	
	
	
	public SA_ViewJobRoleRecommendationRequestPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void enterTrainingCentreName(String tcName)
	{
		tcNameTextbox.clear();
		tcNameTextbox.sendKeys(tcName);
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
	
	public void clickOnReset()
	{
		resetButton.click();
	}
	
	public void clickOnBack()
	{
		backButton.click();
	}
	
	public void clickOnGoBack()
	{
		goBackButton.click();
	}
	
	public void clickOnApproveOrReject()
	{
		approveOrRejectButton.click();
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
	
	public void selectForMoreRequests(String page)
	{
		SelectDropDownList.selectDropDownListByVisibleText(paginationDropDownList, "40");
	}
	
	public void clickOn_Accept_InspectionDateButton()
	{
		acceptInspectionDateRadioButton.click();
	}
	
	public void clickOn_Reject_InspectionDateButton()
	{
		acceptInspectionDateRadioButton.click();
	}
	
	public void clickOnSubmit_InspetionDate()
	{
		submitForInspectionDateButton.click();
	}
	
	public void clickOnCancel()
	{
		cancelButton.click();
	}
	
	public void enterReviewComments_ForInspectionDate(String comments)
	{
		reviewCommentsForInspectionDateTextbox.clear();
		reviewCommentsForInspectionDateTextbox.sendKeys(comments);
	}

}
