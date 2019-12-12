package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SchemeAdmin_UpdateSchemePage {
	WebDriver driver;

	@FindBy(xpath = "//tr[td[contains(text(),'RPL')]]/td/span/div/a[@href='#']")
	private WebElement rplActionButton;
	@FindBy(xpath = "//tr[td[contains(text(),'RPL')]]/td/span/div/div/span[contains(text(),' Update Scheme Details')]")
	private WebElement rplUpdateSchemeButton;
	@FindBy(xpath = "//tr[td[contains(text(),'STT')]]/td/span/div/a[@href='#']")
	private WebElement sttActionButton;
	@FindBy(xpath = "//tr[td[contains(text(),'STT')]]/td/span/div/div/span[contains(text(),' Update Scheme Details')]")
	private WebElement sttUpdateSchemeButton;
	@FindBy(xpath = "//tr[td[contains(text(),'India Internal')]]/td/span/div/a[@href='#']")
	private WebElement indiaInternalActionButton;
	@FindBy(xpath = "//tr[td[contains(text(),'India Internal')]]/td/span/div/div/span[contains(text(),' Update Scheme Details')]")
	private WebElement indiaInternalUpdateSchemeButton;
	@FindBy(xpath = "//tr[td[contains(text(),'Special Project')]]/td/span/div/a[@href='#']")
	private WebElement specialProjectActionButton;
	@FindBy(xpath = "//tr[td[contains(text(),'Special Project')]]/td/span/div/div/span[contains(text(),' Update Scheme Details')]")
	private WebElement specialProjectUpdateSchemeButton;
	@FindBy(xpath = "//tr[td[contains(text(),'Others')]]/td/span/div/a[@href='#']")
	private WebElement othersActionButton;
	@FindBy(xpath = "//tr[td[contains(text(),'Others')]]/td/span/div/div/span[contains(text(),' Update Scheme Details')]")
	private WebElement othersUpdateSchemeButton;
	@FindBy(xpath = "//tr[td[contains(text(),'Non PMKVY Scheme')]]/td/span/div/a[@href='#']")
	private WebElement nonPMKVYActionButton;
	@FindBy(xpath = "//tr[td[contains(text(),'Non PMKVY Scheme')]]/td/span/div/div/span[contains(text(),' Update Scheme Details')]")
	private WebElement nonPMKVYUpdateSchemeButton;
	@FindBy(xpath = "//tr[td[contains(text(),'Integration Scheme')]]/td/span/div/a[@href='#']")
	private WebElement integrationActionButton;
	@FindBy(xpath = "//tr[td[contains(text(),'Integration Scheme')]]/td/span/div/div/span[contains(text(),' Update Scheme Details')]")
	private WebElement integrationUpdateSchemeButton;

	public SchemeAdmin_UpdateSchemePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnRplAction() {
		rplActionButton.click();
	}

	public void clickOnRplUpdateScheme() {
		rplUpdateSchemeButton.click();
	}

	public void clickOnSTTAction() {
		sttActionButton.click();
	}

	public void clickOnSTTUpdateScheme() {
		sttUpdateSchemeButton.click();
	}

	public void clickOnIndiaInternalAction() {
		indiaInternalActionButton.click();
	}

	public void clickOnIndiaInternalUpdateScheme() {
		indiaInternalUpdateSchemeButton.click();
	}

	public void clickOnSpecialProjectAction() {
		specialProjectActionButton.click();
	}

	public void clickOnSpecialProjectUpdateScheme() {
		specialProjectUpdateSchemeButton.click();
	}

	public void clickOnOthersAction() {
		othersActionButton.click();
	}

	public void clickOnOthersUpdateScheme() {
		othersUpdateSchemeButton.click();
	}

	public void clickOnNonPMKVYAction() {
		nonPMKVYActionButton.click();
	}

	public void clickOnNonPMKVYUpdateScheme() {
		nonPMKVYUpdateSchemeButton.click();
	}

	public void clickOnIntegrationAction() {
		integrationActionButton.click();
	}

	public void clickOnIntegrationUpdateScheme() {
		integrationUpdateSchemeButton.click();
	}
}
