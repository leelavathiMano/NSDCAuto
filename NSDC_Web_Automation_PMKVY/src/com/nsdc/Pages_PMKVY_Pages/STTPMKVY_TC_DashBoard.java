package com.nsdc.Pages_PMKVY_Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class STTPMKVY_TC_DashBoard {
	
	WebDriver driver;
	@FindBy(xpath="//div[@id='m_header_menu']//ul//li[3]//span[2]")
	private WebElement MySchemesTab;
	@FindBy(xpath="//tbody[@class='m-datatable__body margin-table ']")
	private WebElement MySchemesListTable;
	@FindBy(xpath="//div[contains(@style,'position')]//a[contains(text(),'View Details')]")
	//@FindBy(xpath="//div[@x-placement='top-end']//a[contains(text(),'View Details')]")
	private WebElement ViewDetailsIcon;
	

	@FindBy(xpath="//p[contains(text(),'View All Batches')]")
	private WebElement ViewAllBatches;
	
	@FindBy(xpath="//button[contains(text(),'Create Batch')]")
	private WebElement CreateBatchBtn;
	
	
	public STTPMKVY_TC_DashBoard (WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	public void ClickMySchemeTab()
	{
		MySchemesTab.click();
		
	}
	
	public void ClickOnViewDetails() throws InterruptedException
	{
		Thread.sleep(2000);
		ViewDetailsIcon.click();
	}
	
	public void ClickViewAllBatches() throws InterruptedException
	{
		Thread.sleep(2000);
		ViewAllBatches.click();
	}
	
	public void ClickCreateBatchBtn() throws InterruptedException
	{
		Thread.sleep(2000);

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", CreateBatchBtn);
	}
	
	
	
	public void SelectProjectIDThatsApproved(String ProjectID) throws NumberFormatException, Exception {
		Thread.sleep(1000);
		List<WebElement> rowstable = MySchemesListTable.findElements(By.tagName("tr"));

		int rows_count = rowstable.size();

		for (int row = 1; row < rows_count; row++) {

			WebElement Columnsrow = driver.findElement(By.xpath("//tbody[@class='m-datatable__body margin-table ']//tr["+row+"]//td[2]"));

		//	int columnscount = Columnsrow.size();

				String celtext = Columnsrow.getText();
				//String ProjectID="AutoTest_213";
				if (celtext.equals(ProjectID)) {
					
				/*
				 * ReadWriteData.setExcelData(
				 * "./TestData/Workflow/PMKVY_STT/ProjectCreationWorkflowExcel.xls",
				 * "ProjectAndBatchCreation", Integer.parseInt(SLNo), 8, celtext);
				 */WebElement RadionButton1st = driver.findElement(By.xpath("//tbody[@class='m-datatable__body margin-table ']//tr["+row+"]//td[10]//span//a[@href='#']"));

					Thread.sleep(2000);
					JavascriptExecutor executor = (JavascriptExecutor) driver;
					executor.executeScript("arguments[0].click();", RadionButton1st);
					break;
				}
				// celtext.getClass();
			}
	}


	
	public void SelectSchemeOfSTT() throws NumberFormatException, Exception {
		Thread.sleep(1000);
		List<WebElement> rowstable = MySchemesListTable.findElements(By.tagName("tr"));

		int rows_count = rowstable.size();

		for (int row = 1; row < rows_count; row++) {

			WebElement Columnsrow = driver.findElement(By.xpath("//tbody[@class='m-datatable__body margin-table ']//tr["+row+"]//td[4]"));

		//	int columnscount = Columnsrow.size();

				String celtext = Columnsrow.getText();
				String ProjectID="PMKK";
				if (celtext.equals(ProjectID)) {
					
				/*
				 * ReadWriteData.setExcelData(
				 * "./TestData/Workflow/PMKVY_STT/ProjectCreationWorkflowExcel.xls",
				 * "ProjectAndBatchCreation", Integer.parseInt(SLNo), 8, celtext);
				 */WebElement RadionButton1st = driver.findElement(By.xpath("//tbody[@class='m-datatable__body margin-table ']//tr["+row+"]//td[7]//span//a[@href='#']"));

					Thread.sleep(2000);
					JavascriptExecutor executor = (JavascriptExecutor) driver;
					executor.executeScript("arguments[0].click();", RadionButton1st);
					break;
				}
				// celtext.getClass();
			}
	}
	
	
	
}
