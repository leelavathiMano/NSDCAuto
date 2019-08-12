package com.nsdc.Pages_PMKVY_Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {

	WebDriver driver;
	private WebDriverWait wait;
	@FindBy(xpath = "//div[@class=\"col-xl-6\"][2]//child::div[1]//child::div[2]//descendant::div[3]")
	private WebElement MySchemesAndPrograms;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 30);
	}

	public void ClickMySchemeOrPrograms() throws Exception {
		Thread.sleep(3000);
		Actions actions = new Actions(driver);
		actions.moveToElement(MySchemesAndPrograms).click().perform();
		wait.until(ExpectedConditions.visibilityOf(MySchemesAndPrograms)).click();
		// wait.until(ExpectedConditions.elementToBeClickable(MySchemesAndPrograms)).click();
	}

}
