package com.nsdc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.nsdc.generic.AddingDaysToCurrentDate;
import com.nsdc.generic.SelectDropDownList;

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
			
	
	public SSC_ToT_ToA_ToMT_ToMA_BatchCreationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public void selectSubSector(String subSector)
	{
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
	//Batch Duration
	public void selectTrainingStartDateForBatch() throws InterruptedException
	{
		trainingStartDateTextField.click();
		Thread.sleep(2000);
		if(driver.findElements(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(15)+"']")).size()>1)
		{
			if(driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(15)+"'])[2]")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(15)+"'])[1]")).click();
			}
			else
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(15)+"'])[2]")).click();
			}
		}
		else
		{
			if(driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(15)+"']")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[button[@class='btn btn-link ngb-dp-arrow-btn']])[2]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(15)+"']")).click();
			}
			else
			{
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(15)+"']")).click();
			}
		}
	}
	public void clickToCloseTrainingStartDateCalender()
	{
		closeTrainingStartDateCalenderIcon.click();
	}
	public void selectTrainingEndDateForNewBatch() throws InterruptedException 
	{
		trainingEndDateTextField.click();
		Thread.sleep(2000);
		if(driver.findElements(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(25)+"']")).size()>1)
		{
			if(driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(25)+"'])[2]")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(25)+"'])[1]")).click();
			}
			else
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(25)+"'])[2]")).click();
			}
		}
		else
		{
			if(driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(25)+"']")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[button[@class='btn btn-link ngb-dp-arrow-btn']])[2]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(25)+"']")).click();
			}
			else
			{
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(25)+"']")).click();
			}
		}
	}
	public void selectTrainingEndDateForExistingBatch() throws InterruptedException
	{	
		trainingEndDateTextField.click();
		Thread.sleep(2000);
		if(driver.findElements(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(18)+"']")).size()>1)
		{
			if(driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(18)+"'])[2]")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(18)+"'])[1]")).click();
			}
			else
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(18)+"'])[2]")).click();
			}
		}
		else
		{
			if(driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(18)+"']")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[button[@class='btn btn-link ngb-dp-arrow-btn']])[2]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(18)+"']")).click();
			}
			else
			{
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(18)+"']")).click();
			}
		}
	}
	public void clickToCloseTrainingEndDateCalender()
	{
		closeTrainingEndDateCalenderIcon.click();
	}
	public void selectDomainJobRole(String domainJobRole) throws InterruptedException
	{
		domainJobRoleCheckBoxList.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[contains(text(),'"+domainJobRole+"')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'Domain Job Role')]")).click();
	}
	public void selectPlatformJobRole(String platformJobRole) throws InterruptedException
	{
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
	public void selectDomainTrainingStartDate() throws InterruptedException
	{
		domainTrainingStartDateTextField.click();
		Thread.sleep(2000);
		if(driver.findElements(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(15)+"']")).size()>1)
		{
			if(driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(15)+"'])[2]")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(15)+"'])[1]")).click();
			}
			else
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(15)+"'])[2]")).click();
			}
		}
		else
		{
			if(driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(15)+"']")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[button[@class='btn btn-link ngb-dp-arrow-btn']])[2]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(15)+"']")).click();
			}
			else
			{
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(15)+"']")).click();
			}
		}
		
	}
	public void clickTocloseDomainTrainingStartDateCalender()
	{
		closeDomainTrainingStartDateCalenderIcon.click();
	}
	public void selectDomainTrainingEndDateForNewBatch() throws InterruptedException
	{
		domainTrainingEndDateTextField.click();
		Thread.sleep(2000);
		if(driver.findElements(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"']")).size()>1)
		{
			if(driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"'])[2]")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"'])[1]")).click();
			}
			else
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"'])[2]")).click();
			}
		}
		else
		{
			if(driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"']")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[button[@class='btn btn-link ngb-dp-arrow-btn']])[2]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"']")).click();
			}
			else
			{
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"']")).click();
			}
		}
		
	}
	public void selectDomainTrainingEndDateForExistingBatch() throws InterruptedException
	{
		domainTrainingEndDateTextField.click();
		Thread.sleep(2000);
		if(driver.findElements(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"']")).size()>1)
		{
			if(driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"'])[2]")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"'])[1]")).click();
			}
			else
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"'])[2]")).click();
			}
		}
		else
		{
			if(driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"']")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[button[@class='btn btn-link ngb-dp-arrow-btn']])[2]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"']")).click();
			}
			else
			{
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"']")).click();
			}
		}
	}
	public void clickToCloseDomainTrainingEndDateCalender()
	{
		closeDomainTrainingEndDateCalenderIcon.click();
	}
	//Domain Assessment Dates
	public void selectDomainAssessmentStartDateForNewBatch() throws InterruptedException
	{
		domainAssessmentStartDateTextField.click();
		Thread.sleep(2000);
		if(driver.findElements(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"']")).size()>1)
		{
			if(driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"'])[2]")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"'])[1]")).click();
			}
			else
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"'])[2]")).click();
			}
		}
		else
		{
			if(driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"']")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[button[@class='btn btn-link ngb-dp-arrow-btn']])[2]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"']")).click();
			}
			else
			{
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"']")).click();
			}
		}
	}
	public void selectDomainAssessmentStartDateForExistingBatch() throws InterruptedException
	{
		domainAssessmentStartDateTextField.click();
		Thread.sleep(2000);
		if(driver.findElements(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"']")).size()>1)
		{
			if(driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"'])[2]")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"'])[1]")).click();
			}
			else
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"'])[2]")).click();
			}
		}
		else
		{
			if(driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"']")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[button[@class='btn btn-link ngb-dp-arrow-btn']])[2]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"']")).click();
			}
			else
			{
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"']")).click();
			}
		}
	}
	public void clickToCloseDomainAssessmentstartDateCalender()
	{
		closeDomainAssessmentStartDateCalenderIcon.click();
	}
	public void selectDomainAssessmentEndDateForNewBatch() throws InterruptedException
	{
		domainAssessmentEndDateTextField.click();
		Thread.sleep(2000);
		if(driver.findElements(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(25)+"']")).size()>1)
		{
			if(driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(25)+"'])[2]")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(25)+"'])[1]")).click();
			}
			else
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(25)+"'])[2]")).click();
			}
		}
		else
		{
			if(driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(25)+"']")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[button[@class='btn btn-link ngb-dp-arrow-btn']])[2]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(25)+"']")).click();
			}
			else
			{
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(25)+"']")).click();
			}
		}
	}
	public void selectDomainAssessmentEndDateForExistingBatch() throws InterruptedException
	{
		domainAssessmentEndDateTextField.click();
		Thread.sleep(2000);
		if(driver.findElements(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(18)+"']")).size()>1)
		{
			if(driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(18)+"'])[2]")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(18)+"'])[1]")).click();
			}
			else
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(18)+"'])[2]")).click();
			}
		}
		else
		{
			if(driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(18)+"']")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[button[@class='btn btn-link ngb-dp-arrow-btn']])[2]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(18)+"']")).click();
			}
			else
			{
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(18)+"']")).click();
			}
		}
		
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
	public void selectPlatformTrainingStartDate() throws InterruptedException
	{
		platformTrainingStartDateTextField.click();
		Thread.sleep(2000);
		if(driver.findElements(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(15)+"']")).size()>1)
		{
			if(driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(15)+"'])[2]")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(15)+"'])[1]")).click();
			}
			else
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(15)+"'])[2]")).click();
			}
		}
		else
		{
			if(driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(15)+"']")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[button[@class='btn btn-link ngb-dp-arrow-btn']])[2]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(15)+"']")).click();
			}
			else
			{
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(15)+"']")).click();
			}
		}
	}
	public void clickToclosePlatformTrainingStartDateCalender()
	{
		closePlatformTrainingStartDateCalenderIcon.click();
	}
	public void selectPlatformTrainingEndDateForNewBatch() throws InterruptedException
	{
		platformTrainingEndDateTextField.click();
		Thread.sleep(2000);
		if(driver.findElements(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"']")).size()>1)
		{
			if(driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"'])[2]")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"'])[1]")).click();
			}
			else
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"'])[2]")).click();
			}
		}
		else
		{
			if(driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"']")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[button[@class='btn btn-link ngb-dp-arrow-btn']])[2]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"']")).click();
			}
			else
			{
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"']")).click();
			}
		}
	}
	public void selectPlatformTrainingEndDateForExistingBatch() throws InterruptedException
	{
		platformTrainingEndDateTextField.click();
		Thread.sleep(2000);
		if(driver.findElements(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"']")).size()>1)
		{
			if(driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"'])[2]")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"'])[1]")).click();
			}
			else
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"'])[2]")).click();
			}
		}
		else
		{
			if(driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"']")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[button[@class='btn btn-link ngb-dp-arrow-btn']])[2]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"']")).click();
			}
			else
			{
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"']")).click();
			}
		}
	}
	public void clickToClosePlatformTrainingEndDateCalender()
	{
		closePlatformTrainingEndDateCalenderIcon.click();
	}
	//Platform Assessment Dates
	public void selectPlatformAssessmentStartDateForNewBatch() throws InterruptedException
	{
		platformAssessmentStartDateTextField.click();
		if(driver.findElements(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"']")).size()>1)
		{
			if(driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"'])[2]")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"'])[1]")).click();
			}
			else
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"'])[2]")).click();
			}
		}
		else
		{
			if(driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"']")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[button[@class='btn btn-link ngb-dp-arrow-btn']])[2]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"']")).click();
			}
			else
			{
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"']")).click();
			}
		}
		
	}
	public void selectPlatformAssessmentStartDateForExistingBatch() throws InterruptedException
	{
		platformAssessmentStartDateTextField.click();
		if(driver.findElements(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"']")).size()>1)
		{
			if(driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"'])[2]")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"'])[1]")).click();
			}
			else
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"'])[2]")).click();
			}
		}
		else
		{
			if(driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"']")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[button[@class='btn btn-link ngb-dp-arrow-btn']])[2]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"']")).click();
			}
			else
			{
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"']")).click();
			}
		}
	}
	public void clickToClosePlatformAssessmentstartDateCalender()
	{
		closePlatformAssessmentStartDateCalenderIcon.click();
	}
	public void selectPlatformAssessmentEndDateForNewBatch() throws InterruptedException
	{
		platformAssessmentEndDateTextField.click();
		if(driver.findElements(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(25)+"']")).size()>1)
		{
			if(driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(25)+"'])[2]")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(25)+"'])[1]")).click();
			}
			else
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(25)+"'])[2]")).click();
			}
		}
		else
		{
			if(driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(25)+"']")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[button[@class='btn btn-link ngb-dp-arrow-btn']])[2]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(25)+"']")).click();
			}
			else
			{
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(25)+"']")).click();
			}
		}
	}
	public void selectPlatformAssessmentEndDateForExistingBatch() throws InterruptedException
	{
		platformAssessmentEndDateTextField.click();
		if(driver.findElements(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(18)+"']")).size()>1)
		{
			if(driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(18)+"'])[2]")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(18)+"'])[1]")).click();
			}
			else
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(18)+"'])[2]")).click();
			}
		}
		else
		{
			if(driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(18)+"']")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[button[@class='btn btn-link ngb-dp-arrow-btn']])[2]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(18)+"']")).click();
			}
			else
			{
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(18)+"']")).click();
			}
		}
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
	public void selectDomain2TrainingStartDate() throws InterruptedException
	{
		domain2TrainingStartDateTextField.click();
		if(driver.findElements(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(15)+"']")).size()>1)
		{
			if(driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(15)+"'])[2]")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(15)+"'])[1]")).click();
			}
			else
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(15)+"'])[2]")).click();
			}
		}
		else
		{
			if(driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(15)+"']")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[button[@class='btn btn-link ngb-dp-arrow-btn']])[2]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(15)+"']")).click();
			}
			else
			{
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(15)+"']")).click();
			}
		}
		
	}
	public void clickTocloseDomain2TrainingStartDateCalender()
	{
		closeDomain2TrainingStartDateCalenderIcon.click();
	}
	public void selectDomain2TrainingEndDateForNewBatch() throws InterruptedException
	{
		domain2TrainingEndDateTextField.click();
		if(driver.findElements(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"']")).size()>1)
		{
			if(driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"'])[2]")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"'])[1]")).click();
			}
			else
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"'])[2]")).click();
			}
		}
		else
		{
			if(driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"']")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[button[@class='btn btn-link ngb-dp-arrow-btn']])[2]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"']")).click();
			}
			else
			{
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"']")).click();
			}
		}
		
	}
	public void selectDomain2TrainingEndDateForExistingBatch() throws InterruptedException
	{
		domain2TrainingEndDateTextField.click();
		if(driver.findElements(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"']")).size()>1)
		{
			if(driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"'])[2]")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"'])[1]")).click();
			}
			else
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"'])[2]")).click();
			}
		}
		else
		{
			if(driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"']")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[button[@class='btn btn-link ngb-dp-arrow-btn']])[2]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"']")).click();
			}
			else
			{
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"']")).click();
			}
		}
	}
	public void clickToCloseDomain2TrainingEndDateCalender()
	{
		closeDomain2TrainingEndDateCalenderIcon.click();
	}
	public void selectDomain2AssessmentStartDateForNewBatch() throws InterruptedException
	{
		domain2AssessmentStartDateTextField.click();
		if(driver.findElements(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"']")).size()>1)
		{
			if(driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"'])[2]")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"'])[1]")).click();
			}
			else
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"'])[2]")).click();
			}
		}
		else
		{
			if(driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"']")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[button[@class='btn btn-link ngb-dp-arrow-btn']])[2]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"']")).click();
			}
			else
			{
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"']")).click();
			}
		}
	}
	public void selectDomain2AssessmentStartDateForExistingBatch() throws InterruptedException
	{
		domain2AssessmentStartDateTextField.click();
		if(driver.findElements(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"']")).size()>1)
		{
			if(driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"'])[2]")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"'])[1]")).click();
			}
			else
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"'])[2]")).click();
			}
		}
		else
		{
			if(driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"']")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[button[@class='btn btn-link ngb-dp-arrow-btn']])[2]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"']")).click();
			}
			else
			{
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"']")).click();
			}
		}
	}
	public void clickToCloseDomain2AssessmentstartDateCalender()
	{
		closeDomain2AssessmentStartDateCalenderIcon.click();
	}
	public void selectDomain2AssessmentEndDateForNewBatch() throws InterruptedException
	{
		domain2AssessmentEndDateTextField.click();
		if(driver.findElements(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(25)+"']")).size()>1)
		{
			if(driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(25)+"'])[2]")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(25)+"'])[1]")).click();
			}
			else
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(25)+"'])[2]")).click();
			}
		}
		else
		{
			if(driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(25)+"']")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[button[@class='btn btn-link ngb-dp-arrow-btn']])[2]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(25)+"']")).click();
			}
			else
			{
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(25)+"']")).click();
			}
		}
	}
	public void selectDomain2AssessmentEndDateForExistingBatch() throws InterruptedException
	{
		domain2AssessmentEndDateTextField.click();
		if(driver.findElements(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(18)+"']")).size()>1)
		{
			if(driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(18)+"'])[2]")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(18)+"'])[1]")).click();
			}
			else
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(18)+"'])[2]")).click();
			}
		}
		else
		{
			if(driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(18)+"']")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[button[@class='btn btn-link ngb-dp-arrow-btn']])[2]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(18)+"']")).click();
			}
			else
			{
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(18)+"']")).click();
			}
		}
		
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
	public void selectrPlatformTrainingStartDate() throws InterruptedException
	{
		rplatformTrainingStartDateTextField.click();
		if(driver.findElements(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(15)+"']")).size()>1)
		{
			if(driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(15)+"'])[2]")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(15)+"'])[1]")).click();
			}
			else
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(15)+"'])[2]")).click();
			}
		}
		else
		{
			if(driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(15)+"']")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[button[@class='btn btn-link ngb-dp-arrow-btn']])[2]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(15)+"']")).click();
			}
			else
			{
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(15)+"']")).click();
			}
		}
	}
	public void clickTocloserPlatformTrainingStartDateCalender()
	{
		rclosePlatformTrainingStartDateCalenderIcon.click();
	}
	public void selectrPlatformTrainingEndDateForNewBatch() throws InterruptedException
	{
		rplatformTrainingEndDateTextField.click();
		if(driver.findElements(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"']")).size()>1)
		{
			if(driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"'])[2]")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"'])[1]")).click();
			}
			else
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"'])[2]")).click();
			}
		}
		else
		{
			if(driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"']")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[button[@class='btn btn-link ngb-dp-arrow-btn']])[2]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"']")).click();
			}
			else
			{
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"']")).click();
			}
		}
	}
	public void selectrPlatformTrainingEndDateForExistingBatch() throws InterruptedException
	{
		rplatformTrainingEndDateTextField.click();
		if(driver.findElements(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"']")).size()>1)
		{
			if(driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"'])[2]")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"'])[1]")).click();
			}
			else
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"'])[2]")).click();
			}
		}
		else
		{
			if(driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"']")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[button[@class='btn btn-link ngb-dp-arrow-btn']])[2]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"']")).click();
			}
			else
			{
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"']")).click();
			}
		}
	}
	public void clickToCloserPlatformTrainingEndDateCalender()
	{
		rclosePlatformTrainingEndDateCalenderIcon.click();
	}
	public void selectrPlatformAssessmentStartDateForNewBatch() throws InterruptedException
	{
		rplatformAssessmentStartDateTextField.click();
		if(driver.findElements(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"']")).size()>1)
		{
			if(driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"'])[2]")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"'])[1]")).click();
			}
			else
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"'])[2]")).click();
			}
		}
		else
		{
			if(driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"']")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[button[@class='btn btn-link ngb-dp-arrow-btn']])[2]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"']")).click();
			}
			else
			{
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(23)+"']")).click();
			}
		}
		
	}
	public void selectrPlatformAssessmentStartDateForExistingBatch() throws InterruptedException
	{
		rplatformAssessmentStartDateTextField.click();
		if(driver.findElements(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"']")).size()>1)
		{
			if(driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"'])[2]")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"'])[1]")).click();
			}
			else
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"'])[2]")).click();
			}
		}
		else
		{
			if(driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"']")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[button[@class='btn btn-link ngb-dp-arrow-btn']])[2]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"']")).click();
			}
			else
			{
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"']")).click();
			}
		}
	}
	public void clickToCloserPlatformAssessmentstartDateCalender()
	{
		rclosePlatformAssessmentStartDateCalenderIcon.click();
	}
	public void selectrPlatformAssessmentEndDateForNewBatch() throws InterruptedException
	{
		rplatformAssessmentEndDateTextField.click();
		if(driver.findElements(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(25)+"']")).size()>1)
		{
			if(driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(25)+"'])[2]")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(25)+"'])[1]")).click();
			}
			else
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(25)+"'])[2]")).click();
			}
		}
		else
		{
			if(driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(25)+"']")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[button[@class='btn btn-link ngb-dp-arrow-btn']])[2]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(25)+"']")).click();
			}
			else
			{
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(25)+"']")).click();
			}
		}
	}
	public void selectrPlatformAssessmentEndDateForExistingBatch() throws InterruptedException
	{
		rplatformAssessmentEndDateTextField.click();
		if(driver.findElements(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(18)+"']")).size()>1)
		{
			if(driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(18)+"'])[2]")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(18)+"'])[1]")).click();
			}
			else
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(18)+"'])[2]")).click();
			}
		}
		else
		{
			if(driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(18)+"']")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[button[@class='btn btn-link ngb-dp-arrow-btn']])[2]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(18)+"']")).click();
			}
			else
			{
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(18)+"']")).click();
			}
		}
	}
	public void clickToCloserPlatformAssessmentEndDateCalender()
	{
		rclosePlatformAssessmentEndDateCalenderIcon.click();
	}
}
