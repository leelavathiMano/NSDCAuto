package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RozgarMelaDetailSectionsPage
{
	WebDriver driver;
	@FindBy(xpath="//button[contains(text(),'Mela Details')]")
	private WebElement melaDetailsButton;
	@FindBy(xpath="//button[contains(text(),'Participating Candidates')]")
	private WebElement participatingCandidatesButton;
	@FindBy(xpath="//button[contains(text(),'Participating Employers')]")
	private WebElement participatingEmployersButton;
	@FindBy(xpath="//button[contains(text(),'Participating Centres')]")
	private WebElement participatingCentresButton;
	@FindBy(xpath="//button[contains(text(),'Participation Summary')]")
	private WebElement participationSummaryButton;
	@FindBy(xpath="//button[contains(text(),'Offered Job Vacancies')]")
	private WebElement offeredJobVacanciesButton;
	@FindBy(xpath="//button[contains(text(),'Update Post Placement Details ')]")
	private WebElement updatePostPlacementDetailsButton;
	@FindBy(xpath="//button[contains(text(),'Back')]")
	private WebElement backButton;
	//Participating Candidates Section
	@FindBy(xpath="//button[contains(text(),'Upload Candidate Registration List')]")
	private WebElement uploadCandidateRegistrationListButton;
	@FindBy(xpath="(//input[@formcontrolname='excelFile'])[1]")
	private WebElement candidateListFileBrowseButton;
	@FindBy(xpath="(//button[contains(text(),'Upload')])[2]")
	private WebElement candidateListUploadButton;
//	@FindBy(xpath="//button[contains(text(),'Back')]")
//	private WebElement backButton;
//	@FindBy(xpath="//button[contains(text(),'Back')]")
//	private WebElement backButton;
	
	public RozgarMelaDetailSectionsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickToViewMelaDetails()
	{
		melaDetailsButton.click();
	}
	public void clickToGoToParticipatingCandidatesSection()
	{
		participatingCandidatesButton.click();
	}
	public void clickToGoToParticipatingEmployersSection()
	{
		participatingEmployersButton.click();
	}
	public void clickToGoToParticipatingCentresSection()
	{
		participatingCentresButton.click();
	}
	public void clickToViewParticipationSummary()
	{
		participationSummaryButton.click();
	}
	public void clickToViewOfferedJobVacancies()
	{
		offeredJobVacanciesButton.click();
	}
	public void clickUpdatePostPlacementDetails()
	{
		updatePostPlacementDetailsButton.click();
	}
	public void clickBack()
	{
		backButton.click();
	}
	public void clickToGetUploadCandidateRegistrationListWindow()
	{
		uploadCandidateRegistrationListButton.click();
	}
	public void clickToBrowseCandidateListfile()
	{
		candidateListFileBrowseButton.click();
	}
	public void clickToUploadSelectedCandidateListFile()
	{
		candidateListUploadButton.click();
	}
}