package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.SelectDropDownList;

public class HA_AllTCRequestPage 
{
	WebDriver driver;
	
	@FindBy(xpath="//input[@type='text']")
	private WebElement TCRequest_searchTextBox;
	@FindBy(css=".btn.m-btn.m-btn--hover-accent.m-btn--icon.m-btn--icon-only.m-btn--pill")
	private WebElement actionButton;
	@FindBy(xpath="//a[contains(text(),'View Details')]")
	private WebElement viewDetailsButton;
	@FindBy(xpath="//a[contains(text(),'Approve/Reject')]")
	private WebElement approveOrRejectButton;
	@FindBy(css=".close")
	private WebElement popupCloseButton;
	@FindBy(xpath="//select[@formcontrolname='approvalstatus']")
	private WebElement reviewCommentsDropDownList;
	@FindBy(xpath="//textarea[@formcontrolname='remark']")
	private WebElement commentTextBox;
	@FindBy(css=".btn.btn-next")
	private WebElement submitButton;
	@FindBy(css=".btn.btn-cancel")
	private WebElement closeButton;
	@FindBy(xpath="//button[text()='OK']")
	private WebElement okButton;
	
	public HA_AllTCRequestPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	public void enterTCDetailsToSearchTCRequest(String search)
	{
		//TCRequest_searchTextBox.clear();
		TCRequest_searchTextBox.sendKeys(search);
	}
	
	public void clickOnAction()
	{
		actionButton.click();
	}
	
	public void clickOnViewDetails()
	{
		viewDetailsButton.click();
	}

	public void clickOnApproveOrReject()
	{
		approveOrRejectButton.click();
	}
	
	public void clickOnPopupClose()
	{
		popupCloseButton.click();
	}
	public void selectReviewComments(String reviewComment)
	{
		SelectDropDownList.selectDropDownListByVisibleText(reviewCommentsDropDownList, reviewComment);
	}
	
	public void enterComment(String comment)
	{
		commentTextBox.clear();
		commentTextBox.sendKeys(comment);
	}
	
	public void clickOnSubmit()
	{
		submitButton.click();
	}
	
	public void clickOnCancel()
	{
		closeButton.click();
	}
	
	public void clickOnOk()
	{
		okButton.click();
	}

}
