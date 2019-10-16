package com.nsdc.Pages_NON_PMKVY_Pages;

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

import com.nsdc.generic.ReadWriteData;

public class AddTrainingCenterPage {

	WebDriver driver;
	private WebDriverWait wait;
	@FindBy(xpath = "//table[@class='table table-striped m-table']//tbody")
	private WebElement AddTrainingCenterTable;
	
	@FindBy(xpath = "//div[@id='AddTrainingCentres']//tbody[@_ngcontent-c16]")
	private WebElement TableForAddTrainingCenter;
	
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
	

	public void SelectTC_FromAddCustomerTable(String SLNo) throws NumberFormatException, Exception {
		Thread.sleep(3000);
		List<WebElement> rowstable = AddTrainingCenterTable.findElements(By.tagName("tr"));

		int rows_count = rowstable.size();

		for (int row = 1; row <= rows_count; row++) {

			WebElement Columnsrow = driver.findElement(By.xpath("//table[@class='table table-striped m-table']//tbody//tr["+row+"]//td[2]"));

		//	int columnscount = Columnsrow.size();

				String celtext = Columnsrow.getText();
				String TCid= "TC201844";
				if (celtext.equals(TCid)) {
					
				//	ReadWriteData.setExcelDataXLSX("./TestData/Workflow/PMKVY_STT/ProjectCreationWorkflowExcel.xlsx","ProjectAndBatchCreation", Integer.parseInt(SLNo), 8, celtext);
					WebElement RadionButton1st = driver.findElement(By.xpath("//table[@class='table table-striped m-table']//tbody//tr["+row+"]//td[1]//label[1]//span[1]"));

					Thread.sleep(2000);
					JavascriptExecutor executor = (JavascriptExecutor) driver;
					executor.executeScript("arguments[0].click();", RadionButton1st);
					break;
				}
				// celtext.getClass();
			}
	}


}
