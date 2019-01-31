package com.nsdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.SelectDropDownList;

public class SchemeAdmin_AddQpsToSchemePage {

	WebDriver driver;

	@FindBy(xpath = "//select[@name='batchType']")
	private WebElement selectSectorDropDownList;
	@FindBy(xpath = "//select[@name='jobRole']")
	private WebElement selectSubSectorDropDownlist;
	@FindBy(id = "Search")
	private WebElement searchByQpCodeTextBox;
	@FindBy(xpath = "//button[contains(text(),'Search')]")
	private WebElement searchButton;
	@FindBy(xpath = "//a[@href='#']")
	private WebElement actionButton;
	@FindBy(xpath= "//div[span[contains(text(),'Add to Scheme')]]")
	private WebElement addToSchemeButton;
	@FindBy(xpath="//div[span[contains(text(),'View Details')]]")
	private WebElement viewDetailsButton;

	public SchemeAdmin_AddQpsToSchemePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void selectSector(String select_Sector) {
		SelectDropDownList.selectDropDownListByVisibleText(selectSectorDropDownList, select_Sector);
	}

	public void selectSubSector(String select_SubSector) {
		SelectDropDownList.selectDropDownListByVisibleText(selectSubSectorDropDownlist, select_SubSector);
	}

	public void enterSearchByQPCode(String search_By_QpCode) {
		searchByQpCodeTextBox.sendKeys(search_By_QpCode);
	}

	public void clickOnSearch() {
		searchButton.click();
	}

	public void clickOnAction() {
		actionButton.click();
	}
	
	public void clickOnAddToScheme() {
		addToSchemeButton.click();
	}
	
	public void clickOnViewDetails() {
		viewDetailsButton.click();
	}
	
	
}
