package com.nsdc.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.nsdc.generic.SelectDropDownList;
import com.nsdc.generic.ToT_ToA_Batch_DatePicker;

public class SSC_ToT_ToA_ToMT_ToMA_BatchCreationPage 
{
	WebDriver driver;
	@FindBy(xpath="//select[@formcontrolname='subSector']")
	private WebElement subSectorDropdownList;
	@FindBy(xpath="//select[@formcontrolname='batchType']")
	private WebElement batchTypeDropdownList;
	@FindBy(xpath="//select[@formcontrolname='reAssessmentBatch']")
	private WebElement batchCategoryDropdownList;
	@FindBy(xpath="//input[@formcontrolname='startDate']")
	private WebElement trainingStartDateTextField;
	@FindBy(xpath="(//div[@class='input-group-append'])[1]")
	private WebElement closeTrainingStartDateCalenderIcon;
	@FindBy(xpath="//div[@class='datepicker-days']")
	private WebElement datePicker;
	@FindBy(xpath="//input[@formcontrolname='endDate']")
	private WebElement trainingEndDateTextField;
	@FindBy(xpath="(//div[@class='input-group-append'])[2]")
	private WebElement closeTrainingEndDateCalenderIcon;
	@FindBy(xpath="//angular2-multiselect[@formcontrolname='domainJobRole']/div")
	private WebElement domainJobRoleCheckBoxList;
	@FindBy(xpath="//span[@class='c-angle-up']")
	private WebElement angleUpSVG;
	@FindBy(xpath="//angular2-multiselect[@formcontrolname='platformJobRole']/div")
	private WebElement platformJobRoleList;
	@FindBy(xpath="(//label[@class='m-radio m-radio--success']/span)[1]")
	private WebElement domainBaseQpRadioButton;
	@FindBy(xpath="(//input[@formcontrolname='trainingStartDate'])[1]")
	private WebElement domainTrainingStartDateTextField;
	@FindBy(xpath="(//div[@class='input-group-append'])[3]")
	private WebElement closeDomainTrainingStartDateCalenderIcon;
	@FindBy(xpath="(//input[@formcontrolname='trainingEndDate'])[1]")
	private WebElement domainTrainingEndDateTextField;
	@FindBy(xpath="(//div[@class='input-group-append'])[4]")
	private WebElement closeDomainTrainingEndDateCalenderIcon;
	@FindBy(xpath="(//input[@formcontrolname='assessmentStartDate'])[1]")
	private WebElement domainAssessmentStartDateTextField;
	@FindBy(xpath="(//div[@class='input-group-append'])[5]")
	private WebElement closeDomainAssessmentStartDateCalenderIcon;
	@FindBy(xpath="(//input[@formcontrolname='assessmentEndDate'])[1]")
	private WebElement domainAssessmentEndDateTextField;
	@FindBy(xpath="(//div[@class='input-group-append'])[6]")
	private WebElement closeDomainAssessmentEndDateCalenderIcon;
	//Platform
	@FindBy(xpath="(//label[@class='m-radio m-radio--success']/span)[2]")
	private WebElement platformBaseQpRadioButton;
	@FindBy(xpath="(//input[@formcontrolname='trainingStartDate'])[2]")
	private WebElement platformTrainingStartDateTextField;
	@FindBy(xpath="(//div[@class='input-group-append'])[7]")
	private WebElement closePlatformTrainingStartDateCalenderIcon;
	@FindBy(xpath="(//input[@formcontrolname='trainingEndDate'])[2]")
	private WebElement platformTrainingEndDateTextField;
	@FindBy(xpath="(//div[@class='input-group-append'])[8]")
	private WebElement closePlatformTrainingEndDateCalenderIcon;
	@FindBy(xpath="(//input[@formcontrolname='assessmentStartDate'])[2]")
	private WebElement platformAssessmentStartDateTextField;
	@FindBy(xpath="(//div[@class='input-group-append'])[9]")
	private WebElement closePlatformAssessmentStartDateCalenderIcon;
	@FindBy(xpath="(//input[@formcontrolname='assessmentEndDate'])[2]")
	private WebElement platformAssessmentEndDateTextField;
	@FindBy(xpath="(//div[@class='input-group-append'])[10]")
	private WebElement closePlatformAssessmentEndDateCalenderIcon;
	@FindBy(xpath="//input[@formcontrolname='batchFees']")
	private WebElement trainingFeesTextField;
	@FindBy(xpath="//button[contains(text(),'View')]")
	private WebElement viewFeesDetailsButton;
	@FindBy(xpath="//button[contains(text(),'OK')]")
	private WebElement okButton;
	@FindBy(xpath="//select[@formcontrolname='batchSize']")
	private WebElement batchSizeDropdownLiast;
	@FindBy(xpath="//button[contains(text(),'Create Batch')]")
	private WebElement createBatchButton;
	@FindBy(linkText="Cancel")
	private WebElement cancelLink;
	//Rejection Batch Domain2 QP Elements
	@FindBy(xpath="(//input[@formcontrolname='trainingStartDate'])[2]")
	private WebElement domain2TrainingStartDateTextField;
	@FindBy(xpath="(//div[@class='input-group-append'])[7]")
	private WebElement closeDomain2TrainingStartDateCalenderIcon;
	@FindBy(xpath="(//input[@formcontrolname='trainingEndDate'])[2]")
	private WebElement domain2TrainingEndDateTextField;
	@FindBy(xpath="(//div[@class='input-group-append'])[8]")
	private WebElement closeDomain2TrainingEndDateCalenderIcon;
	@FindBy(xpath="(//input[@formcontrolname='assessmentStartDate'])[2]")
	private WebElement domain2AssessmentStartDateTextField;
	@FindBy(xpath="(//div[@class='input-group-append'])[9]")
	private WebElement closeDomain2AssessmentStartDateCalenderIcon;
	@FindBy(xpath="(//input[@formcontrolname='assessmentEndDate'])[2]")
	private WebElement domain2AssessmentEndDateTextField;
	@FindBy(xpath="(//div[@class='input-group-append'])[10]")
	private WebElement closeDomain2AssessmentEndDateCalenderIcon;
	//Rejection Batch Platform QP Elements
	@FindBy(xpath="(//label[@class='m-radio m-radio--success']/span)[3]")
	private WebElement rplatformBaseQpRadioButton;
	@FindBy(xpath="(//input[@formcontrolname='trainingStartDate'])[3]")
	private WebElement rplatformTrainingStartDateTextField;
	@FindBy(xpath="(//div[@class='input-group-append'])[11]")
	private WebElement rclosePlatformTrainingStartDateCalenderIcon;
	@FindBy(xpath="(//input[@formcontrolname='trainingEndDate'])[3]")
	private WebElement rplatformTrainingEndDateTextField;
	@FindBy(xpath="(//div[@class='input-group-append'])[12]")
	private WebElement rclosePlatformTrainingEndDateCalenderIcon;
	@FindBy(xpath="(//input[@formcontrolname='assessmentStartDate'])[3]")
	private WebElement rplatformAssessmentStartDateTextField;
	@FindBy(xpath="(//div[@class='input-group-append'])[13]")
	private WebElement rclosePlatformAssessmentStartDateCalenderIcon;
	@FindBy(xpath="(//input[@formcontrolname='assessmentEndDate'])[3]")
	private WebElement rplatformAssessmentEndDateTextField;
	@FindBy(xpath="(//div[@class='input-group-append'])[14]")
	private WebElement rclosePlatformAssessmentEndDateCalenderIcon;
	@FindBy(xpath="(//select[@class='custom-select'])[1]")
	private WebElement monthDropdownList;
	@FindBy(xpath="(//select[@class='custom-select'])[2]")
	private WebElement yearDropdownList;
	
	public SSC_ToT_ToA_ToMT_ToMA_BatchCreationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public void selectSubSector(String subSector)
	{
		WebDriverWait wait=new WebDriverWait(driver,120);
		wait.until(ExpectedConditions.elementToBeClickable(subSectorDropdownList));
		SelectDropDownList.selectDropDownListByVisibleText(subSectorDropdownList, subSector);
	}
	public void selectBatchType(String batchType)
	{
		SelectDropDownList.selectDropDownListByVisibleText(batchTypeDropdownList, batchType);
	}
	public void selectBatchCategory(String batchCategory)
	{
		SelectDropDownList.selectDropDownListByVisibleText(batchCategoryDropdownList, batchCategory);
	}
	@SuppressWarnings("resource")
	public static void fileSave(String filePath)
	{
		try
		{
        	HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(new File(filePath)));
            XSSFFormulaEvaluator.evaluateAllFormulaCells(wb);
            FileOutputStream out = new FileOutputStream(filePath);
            wb.write(out);
            out.close();
            wb = new HSSFWorkbook(new FileInputStream(new File(filePath)));
		}catch (IOException ex)
        {
            ex.printStackTrace();
        }
	}
	//Batch Duration
	public void selectTrainingStartDateForBatch(String batchStartDate) throws InterruptedException
	{
		ToT_ToA_Batch_DatePicker.chooseDate(driver, batchStartDate, trainingStartDateTextField, monthDropdownList, yearDropdownList);
	}
	public void clickToCloseTrainingStartDateCalender()
	{
		closeTrainingStartDateCalenderIcon.click();
	}
	public void selectTrainingEndDateForNewBatch(String batchEndDate) throws InterruptedException 
	{
		ToT_ToA_Batch_DatePicker.chooseDate(driver, batchEndDate, trainingEndDateTextField, monthDropdownList, yearDropdownList);
	}
	public void selectTrainingEndDateForExistingBatch(String batchEndDate) throws InterruptedException
	{	
		ToT_ToA_Batch_DatePicker.chooseDate(driver, batchEndDate, trainingEndDateTextField, monthDropdownList, yearDropdownList);
	}
	public void clickToCloseTrainingEndDateCalender()
	{
		closeTrainingEndDateCalenderIcon.click();
	}
	public void selectDomainJobRole(String domainJobRole) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(domainJobRoleCheckBoxList));
		domainJobRoleCheckBoxList.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//label[contains(text(),'"+domainJobRole+"')])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'Domain Job Role')]")).click();
	}
	public void selectPlatformJobRole(String platformJobRole) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(platformJobRoleList));
		platformJobRoleList.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[text()='"+platformJobRole+"']")).click();
	}
	//Domain QP
	public void clickToChooseDomainQP()
	{
		domainBaseQpRadioButton.click();
	}
	//Domain Training Dates
	public void selectDomainTrainingStartDate(String domainTrainingStartDate) throws InterruptedException
	{
		ToT_ToA_Batch_DatePicker.chooseDate(driver, domainTrainingStartDate, domainTrainingStartDateTextField, monthDropdownList, yearDropdownList);
	}
	public void clickTocloseDomainTrainingStartDateCalender()
	{
		closeDomainTrainingStartDateCalenderIcon.click();
	}
	public void selectDomainTrainingEndDateForNewBatch(String domainTrainingEndDate) throws InterruptedException
	{
		ToT_ToA_Batch_DatePicker.chooseDate(driver, domainTrainingEndDate, domainTrainingEndDateTextField, monthDropdownList, yearDropdownList);
	}
	public void selectDomainTrainingEndDateForExistingBatch(String domainTrainingEndDate) throws InterruptedException
	{
		ToT_ToA_Batch_DatePicker.chooseDate(driver, domainTrainingEndDate, domainTrainingEndDateTextField, monthDropdownList, yearDropdownList);
	}
	public void clickToCloseDomainTrainingEndDateCalender()
	{
		closeDomainTrainingEndDateCalenderIcon.click();
	}
	//Domain Assessment Dates
	public void selectDomainAssessmentStartDateForNewBatch(String domainAssessmentStartDate) throws InterruptedException
	{
		ToT_ToA_Batch_DatePicker.chooseDate(driver, domainAssessmentStartDate, domainAssessmentStartDateTextField, monthDropdownList, yearDropdownList);
	}
	public void selectDomainAssessmentStartDateForExistingBatch(String domainAssessmentStartDate) throws InterruptedException
	{
		ToT_ToA_Batch_DatePicker.chooseDate(driver, domainAssessmentStartDate, domainAssessmentStartDateTextField, monthDropdownList, yearDropdownList);
	}
	public void clickToCloseDomainAssessmentstartDateCalender()
	{
		closeDomainAssessmentStartDateCalenderIcon.click();
	}
	public void selectDomainAssessmentEndDateForNewBatch(String domainAssessmentEndDate) throws InterruptedException
	{
		ToT_ToA_Batch_DatePicker.chooseDate(driver, domainAssessmentEndDate, domainAssessmentEndDateTextField, monthDropdownList, yearDropdownList);
	}
	public void selectDomainAssessmentEndDateForExistingBatch(String domainAssessmentEndDate) throws InterruptedException
	{
		ToT_ToA_Batch_DatePicker.chooseDate(driver, domainAssessmentEndDate, domainAssessmentEndDateTextField, monthDropdownList, yearDropdownList);
	}
	public void clickToCloseDomainAssessmentEndDateCalender()
	{
		closeDomainAssessmentEndDateCalenderIcon.click();
	}
	//Platform QP
	public void clickToChoosePlatformQP()
	{
		platformBaseQpRadioButton.click();
	}
	//Platform Training Dates
	public void selectPlatformTrainingStartDate(String platformTrainingStartDate) throws InterruptedException
	{
		ToT_ToA_Batch_DatePicker.chooseDate(driver, platformTrainingStartDate, platformTrainingStartDateTextField, monthDropdownList, yearDropdownList);
	}
	public void clickToclosePlatformTrainingStartDateCalender()
	{
		closePlatformTrainingStartDateCalenderIcon.click();
	}
	public void selectPlatformTrainingEndDateForNewBatch(String platformTrainingEndDate) throws InterruptedException
	{
		ToT_ToA_Batch_DatePicker.chooseDate(driver, platformTrainingEndDate, platformTrainingEndDateTextField, monthDropdownList, yearDropdownList);
	}
	public void selectPlatformTrainingEndDateForExistingBatch(String platformTrainingEndDate) throws InterruptedException
	{
		ToT_ToA_Batch_DatePicker.chooseDate(driver, platformTrainingEndDate, platformTrainingEndDateTextField, monthDropdownList, yearDropdownList);
	}
	public void clickToClosePlatformTrainingEndDateCalender()
	{
		closePlatformTrainingEndDateCalenderIcon.click();
	}
	//Platform Assessment Dates
	public void selectPlatformAssessmentStartDateForNewBatch(String platformAssessmentStartDate) throws InterruptedException
	{
		ToT_ToA_Batch_DatePicker.chooseDate(driver, platformAssessmentStartDate, platformAssessmentStartDateTextField, monthDropdownList, yearDropdownList);
	}
	public void selectPlatformAssessmentStartDateForExistingBatch(String platformAssessmentStartDate) throws InterruptedException
	{
		ToT_ToA_Batch_DatePicker.chooseDate(driver, platformAssessmentStartDate, platformAssessmentStartDateTextField, monthDropdownList, yearDropdownList);
	}
	public void clickToClosePlatformAssessmentstartDateCalender()
	{
		closePlatformAssessmentStartDateCalenderIcon.click();
	}
	public void selectPlatformAssessmentEndDateForNewBatch(String platformAssessmentEndDate) throws InterruptedException
	{
		ToT_ToA_Batch_DatePicker.chooseDate(driver, platformAssessmentEndDate, platformAssessmentEndDateTextField, monthDropdownList, yearDropdownList);
	}
	public void selectPlatformAssessmentEndDateForExistingBatch(String platformAssessmentEndDate) throws InterruptedException
	{
		ToT_ToA_Batch_DatePicker.chooseDate(driver, platformAssessmentEndDate, platformAssessmentEndDateTextField, monthDropdownList, yearDropdownList);
	}
	public void clickToClosePlatformAssessmentEndDateCalender()
	{
		closePlatformAssessmentEndDateCalenderIcon.click();
	}
	public void isFeesReadOnly()
	{
		Assert.assertFalse(trainingFeesTextField.isEnabled());
	}
	public void clickToViewFees()
	{
		trainingFeesTextField.click();
	}
	public void clickToGetInDetailBatchFees()
	{
		viewFeesDetailsButton.click();
	}
	public void selectBatchSize(String batchSize)
	{
		SelectDropDownList.selectDropDownListByVisibleText(batchSizeDropdownLiast, batchSize);
	}
	public void clickToCreateBatch()
	{
		createBatchButton.click();
	}
	public void clickToCancelBatchCreation()
	{
		cancelLink.click();
	}
	public void clickOk()
	{
		WebDriverWait wait=new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(okButton));
		okButton.click();
	}
	public void clickBatchAction(String createdBatchID)
	{
		driver.findElement(By.xpath("(//tr[td[contains(text(),'"+createdBatchID+"')]]//a)[1]")).click();
	}
	public void selectAssignOption(String createdBatchID)
	{
		driver.findElement(By.xpath("//tr[td[contains(text(),'"+createdBatchID+"')]]//a/span[contains(text(),'Assign')]")).click();
	}
	public void clickViewDetailsOption(String createdBatchID)
	{
		driver.findElement(By.xpath("//tr[td[contains(text(),'"+createdBatchID+"')]]//a/span[contains(text(),'View Details')]")).click();
	}
	//Rejection Batch Elements Function
	public void selectDomain2TrainingStartDate(String domainTrainingStartDate) throws InterruptedException
	{
		ToT_ToA_Batch_DatePicker.chooseDate(driver, domainTrainingStartDate, domain2TrainingStartDateTextField, monthDropdownList, yearDropdownList);
	}
	public void clickTocloseDomain2TrainingStartDateCalender()
	{
		closeDomain2TrainingStartDateCalenderIcon.click();
	}
	public void selectDomain2TrainingEndDateForNewBatch(String domainTrainingEndDate) throws InterruptedException
	{
		ToT_ToA_Batch_DatePicker.chooseDate(driver, domainTrainingEndDate, domain2TrainingEndDateTextField, monthDropdownList, yearDropdownList);
	}
	public void selectDomain2TrainingEndDateForExistingBatch(String domainTrainingEndDate) throws InterruptedException
	{
		ToT_ToA_Batch_DatePicker.chooseDate(driver, domainTrainingEndDate, domain2TrainingEndDateTextField, monthDropdownList, yearDropdownList);
	}
	public void clickToCloseDomain2TrainingEndDateCalender()
	{
		closeDomain2TrainingEndDateCalenderIcon.click();
	}
	public void selectDomain2AssessmentStartDateForNewBatch(String domainAssessemntStartDate) throws InterruptedException
	{
		ToT_ToA_Batch_DatePicker.chooseDate(driver, domainAssessemntStartDate, domain2AssessmentStartDateTextField, monthDropdownList, yearDropdownList);
	}
	public void selectDomain2AssessmentStartDateForExistingBatch(String domainAssessemntStartDate) throws InterruptedException
	{
		ToT_ToA_Batch_DatePicker.chooseDate(driver, domainAssessemntStartDate, domain2AssessmentStartDateTextField, monthDropdownList, yearDropdownList);
	}
	public void clickToCloseDomain2AssessmentstartDateCalender()
	{
		closeDomain2AssessmentStartDateCalenderIcon.click();
	}
	public void selectDomain2AssessmentEndDateForNewBatch(String domainAssessemntEndDate) throws InterruptedException
	{
		ToT_ToA_Batch_DatePicker.chooseDate(driver, domainAssessemntEndDate, domain2AssessmentEndDateTextField, monthDropdownList, yearDropdownList);
	}
	public void selectDomain2AssessmentEndDateForExistingBatch(String domainAssessemntEndDate) throws InterruptedException
	{
		ToT_ToA_Batch_DatePicker.chooseDate(driver, domainAssessemntEndDate, domain2AssessmentEndDateTextField, monthDropdownList, yearDropdownList);
	}
	public void clickToCloseDomain2AssessmentEndDateCalender()
	{
		closeDomain2AssessmentEndDateCalenderIcon.click();
	}
	//Platform QP
	public void clickToChooserPlatformQP()
	{
		rplatformBaseQpRadioButton.click();
	}
	public void selectrPlatformTrainingStartDate(String platformTrainingStartDate) throws InterruptedException
	{
		ToT_ToA_Batch_DatePicker.chooseDate(driver, platformTrainingStartDate, rplatformTrainingStartDateTextField, monthDropdownList, yearDropdownList);
	}
	public void clickTocloserPlatformTrainingStartDateCalender()
	{
		rclosePlatformTrainingStartDateCalenderIcon.click();
	}
	public void selectrPlatformTrainingEndDateForNewBatch(String platformTrainingEndDate) throws InterruptedException
	{
		ToT_ToA_Batch_DatePicker.chooseDate(driver, platformTrainingEndDate, rplatformTrainingEndDateTextField, monthDropdownList, yearDropdownList);
	}
	public void selectrPlatformTrainingEndDateForExistingBatch(String platformTrainingEndDate) throws InterruptedException
	{
		ToT_ToA_Batch_DatePicker.chooseDate(driver, platformTrainingEndDate, rplatformTrainingEndDateTextField, monthDropdownList, yearDropdownList);
	}
	public void clickToCloserPlatformTrainingEndDateCalender()
	{
		rclosePlatformTrainingEndDateCalenderIcon.click();
	}
	public void selectrPlatformAssessmentStartDateForNewBatch(String platformAssessmentStartDate) throws InterruptedException
	{
		ToT_ToA_Batch_DatePicker.chooseDate(driver, platformAssessmentStartDate, rplatformAssessmentStartDateTextField, monthDropdownList, yearDropdownList);
	}
	public void selectrPlatformAssessmentStartDateForExistingBatch(String platformAssessmentStartDate) throws InterruptedException
	{
		ToT_ToA_Batch_DatePicker.chooseDate(driver, platformAssessmentStartDate, rplatformAssessmentStartDateTextField, monthDropdownList, yearDropdownList);
	}
	public void clickToCloserPlatformAssessmentstartDateCalender()
	{
		rclosePlatformAssessmentStartDateCalenderIcon.click();
	}
	public void selectrPlatformAssessmentEndDateForNewBatch(String platformAssessmentEndDate) throws InterruptedException
	{
		ToT_ToA_Batch_DatePicker.chooseDate(driver, platformAssessmentEndDate, rplatformAssessmentEndDateTextField, monthDropdownList, yearDropdownList);
	}
	public void selectrPlatformAssessmentEndDateForExistingBatch(String platformAssessmentEndDate) throws InterruptedException
	{
		ToT_ToA_Batch_DatePicker.chooseDate(driver, platformAssessmentEndDate, rplatformAssessmentEndDateTextField, monthDropdownList, yearDropdownList);
	}
	public void clickToCloserPlatformAssessmentEndDateCalender()
	{
		rclosePlatformAssessmentEndDateCalenderIcon.click();
	}
}