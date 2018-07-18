package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ST_ViewQPDetailsPage 
{
	WebDriver driver;
	@FindBy(xpath="//a[@href='#qpDetails']")
	private WebElement QPDetailsTab;
	@FindBy(xpath="(//div[label[contains(text(),'Review Comments')]]/div/div/label/span)[1]")
	private WebElement compliant_SubSectorReviewCommentsRadioButton;
	@FindBy(xpath="(//div[label[contains(text(),'Review Comments')]]/div/div/label/span)[2]")
	private WebElement nonCompliant_SubSectorReviewCommentsRadioButton;
	@FindBy(css=".form-control.m-input.ng-pristine.ng-touched.ng-invalid")
	private WebElement subSector_ReviewCommentsTextbox;
	@FindBy(xpath="(//div[label[contains(text(),'Review Comments')]]/div/div/label/span)[3]")
	private WebElement compliant_NCOCodeReviewCommentsRadioButton;
	@FindBy(xpath="(//div[label[contains(text(),'Review Comments')]]/div/div/label/span)[4]")
	private WebElement nonCompliant_NCOCodeReviewCommentsRadioButton;
	@FindBy()
	

}
