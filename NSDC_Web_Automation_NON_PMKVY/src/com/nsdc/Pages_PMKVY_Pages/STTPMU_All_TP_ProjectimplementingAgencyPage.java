package com.nsdc.Pages_PMKVY_Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nsdc.generic.ReadWriteData;

public class STTPMU_All_TP_ProjectimplementingAgencyPage {
	WebDriver driver;
	@FindBy(xpath="(//a[i[@class='la la-ellipsis-h']])[1]")
	private WebElement ActionButton;
	@FindBy(xpath="//div[contains(@style,'position')]//a[contains(text(),'View Details')]")
	//@FindBy(xpath="//div[@x-placement='top-end']//a[contains(text(),'View Details')]")
	private WebElement ViewDetailsIcon;
	
	@FindBy(xpath="//div[@id='pending']//tbody[@class='m-datatable__body margin-table ']")
	private WebElement AllTrainingPartnerTable;
	//
	public STTPMU_All_TP_ProjectimplementingAgencyPage (WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
//
	public void ClickOnAction()
	{
		ActionButton.click();
	}
	public void ClickOnViewDetails() throws InterruptedException
	{
		Thread.sleep(2000);
		ViewDetailsIcon.click();
	}
	
	

	public void SelectAllTrainingPartnerTable(String ProjectProposalID, String SLNo) throws NumberFormatException, Exception {
		Thread.sleep(2000);
		List<WebElement> rowstable = AllTrainingPartnerTable.findElements(By.tagName("tr"));

		int rows_count = rowstable.size();

		for (int row = 1; row < rows_count; row++) {

			WebElement Columnsrow = driver.findElement(By.xpath("//div[@id='pending']//tbody[@class='m-datatable__body margin-table ']//tr["+row+"]//td[4]"));

		//	int columnscount = Columnsrow.size();

				String celtext = Columnsrow.getText();
				//String AllTPID="sdfdsf";
				if (celtext.equals(ProjectProposalID)) {
					
				/*
				 * ReadWriteData.setExcelData(
				 * "./TestData/Workflow/PMKVY_STT/ProjectCreationWorkflowExcel.xls",
				 * "ProjectAndBatchCreation", Integer.parseInt(SLNo), 8, celtext);
				 */WebElement RadionButton1st = driver.findElement(By.xpath("//div[@id='pending']//tbody[@class='m-datatable__body margin-table ']//tr["+row+"]//td[10]//span//a[@href='#']"));

					Thread.sleep(2000);
					JavascriptExecutor executor = (JavascriptExecutor) driver;
					executor.executeScript("arguments[0].click();", RadionButton1st);
					break;
				}
				// celtext.getClass();
			}
	}

}
