package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrainingPartnerDashboardPage 
{
	WebDriver driver;
	@FindBy(linkText="Other - Rozgar Mela")
	private WebElement otherRozgarMelaLink;
	@FindBy(xpath="//div[@routerlink='./add-tc']")
	private WebElement addTrainingCentreButton;
	@FindBy(xpath="//p[text()='View All Assessment Requests']")
	private WebElement allAssignedRequestButton;
	@FindBy(xpath="//p[text()='My Training Centres']")
	private WebElement trainingCentreListButton;
	@FindBy(xpath="//p[text()='Change My SPOC']")
	private WebElement changeMySPOCButton;
	@FindBy(xpath="//p[text()='Add Authorized Sign']")
	private WebElement addAuthorizedSignButton;
	@FindBy(xpath="//p[text()='All Authorized Signs']")
	private WebElement allAuthorizedSignsButton;
	@FindBy(xpath="//p[text()='Add Candidate']")
	private WebElement addCandidateButton;
	@FindBy(xpath="(//span[@class='m-menu__link-text'])[1]")
	private WebElement dashboardButton;
	@FindBy(xpath="(//span[@class='m-menu__link-text'])[2]")
	private WebElement mySchemesButton;
	@FindBy(xpath="(//span[@class='m-menu__link-text'])[3]")
	private WebElement accrediationAndAffiliationButton;
	@FindBy(xpath="(//span[@class='m-menu__link-text'])[4]")
	private WebElement toTToAToMTToMAButton;
	@FindBy(xpath="(//span[@class='m-menu__link-text'])[5]")
	private WebElement schemeButton;
	@FindBy(xpath="(//span[@class='m-menu__link-text'])[6]")
	private WebElement certificationsButton;
	//TP - Candidates
	@FindBy(xpath="//p[contains(text(),'My Candidates')]")
	private WebElement myCandidatesCard;
	

	public TrainingPartnerDashboardPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	public void clickOtherRozgarMela()
	{
		otherRozgarMelaLink.click();
	}
	
	public void clickOnAddATrainingCentre()
	{
		addTrainingCentreButton.click();
	}
	
	public void clickOnViewAllAssessmentRequest()
	{
		allAssignedRequestButton.click();
	}
	
	public void clickOnTrainingCentreList()
	{
		trainingCentreListButton.click();
	}
	
	public void clickOnChangeMySPOC()
	{
		changeMySPOCButton.click();
	}
	
	public void clickOnAddAuthorizedSign()
	{
		addAuthorizedSignButton.click();
	}
	
	public void clickOnAllAuthorizedSigns()
	{
		allAuthorizedSignsButton.click();
	}
	
	public void clickOnAddCandidate()
	{
		addCandidateButton.click();
	}
	
	public void clickOnDashboard()
	{
		dashboardButton.click();
	}
	
	public void clickOnMySchemes()
	{
		mySchemesButton.click();
	}
	
	public void clickOnAccrediationAndAffiliation()
	{
		accrediationAndAffiliationButton.click();
	}
	
	public void clickOnToTToAToMTToMA()
	{
		toTToAToMTToMAButton.click();
	}
	
	public void clickOnScheme()
	{
		schemeButton.click();
	}
	
	public void clickOnCertifications()
	{
		certificationsButton.click();
	}
	public void clickMyCandidates()
	{
		myCandidatesCard.click();
	}
}	
	

	

	


