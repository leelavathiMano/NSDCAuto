package com.nsdc.Pages_PMKVY_Pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddTrainingCenterPage {

	WebDriver driver;
	private WebDriverWait wait;
	@FindBy(xpath = "//table[@class='table table-striped m-table']//tbody")
	private WebElement AddTrainingCenter;
	@FindBy(xpath = "//button[text()='Save changes']")
	private WebElement SaveChanges;
	public AddTrainingCenterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 30);
	}

	public void ClickOnFirstRadioButton() throws Exception {

		WebElement RadionButton1st = driver.findElement(By.xpath("//table[@class='table table-striped m-table']//tbody//tr[1]//td[1]//label[1]//span[1]"));

		Thread.sleep(2000);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", RadionButton1st);
		
	}
	
	public void ClickOnSaveChanges() throws Exception {

		Thread.sleep(2000);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", SaveChanges);
		
	}
	

}
