package com.nsdc.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.nsdc.generic.AddingDaysToCurrentDate;

public class SSC_BatchReSchedulePage
{
	WebDriver driver;
	@FindBy(xpath="//button[contains(text(),'Submit')]")
	private WebElement batchRescheduleSubmitButton;
	@FindBy(xpath="//button[contains(text(),'OK')]")
	private WebElement okButton;
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
	//domain Job QP
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
	//platform QP
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
		
	public SSC_BatchReSchedulePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	public void clickToSubmitRescheduledBatch()
	{
		batchRescheduleSubmitButton.click();
	}
	public void clickOk()
	{
		okButton.click();
	}
	//Batch Duration
	public void selectTrainingStartDateForBatch() throws InterruptedException
	{
		trainingStartDateTextField.click();
		Thread.sleep(2000);
		if(driver.findElements(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"']")).size()>1)
		{
			if(driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"'])[1]")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"'])[2]")).click();
			}
			else
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"'])[1]")).click();
			}
		}
		else
		{
			if(driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"']")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("//div[@class='ngb-dp-arrow right']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"'])[1]")).click();
			}
			else
			{
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"']")).click();
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
		if(driver.findElements(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(26)+"']")).size()>1)
		{
			if(driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(26)+"'])[1]")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(26)+"'])[2]")).click();
			}
			else
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(26)+"'])[1]")).click();
			}
		}
		else
		{
			if(driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(26)+"']")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("//div[@class='ngb-dp-arrow right']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(26)+"'])[1]")).click();
			}
			else
			{
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(26)+"']")).click();
			}
		}
	}
	public void selectTrainingEndDateForExistingBatch() throws InterruptedException
	{	
		trainingEndDateTextField.click();
		Thread.sleep(2000);
		if(driver.findElements(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(19)+"']")).size()>1)
		{
			if(driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(19)+"'])[1]")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(19)+"'])[2]")).click();
			}
			else
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(19)+"'])[1]")).click();
			}
		}
		else
		{
			if(driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(19)+"']")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("//div[@class='ngb-dp-arrow right']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(19)+"'])[1]")).click();
			}
			else
			{
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(19)+"']")).click();
			}
		}
	}
	public void clickToCloseTrainingEndDateCalender()
	{
		closeTrainingEndDateCalenderIcon.click();
	}
	//Domain Training Dates
	public void selectDomainTrainingStartDate() throws InterruptedException
	{
		domainTrainingStartDateTextField.click();
		Thread.sleep(2000);
		if(driver.findElements(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"']")).size()>1)
		{
			if(driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"'])[1]")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"'])[2]")).click();
			}
			else
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"'])[1]")).click();
			}
		}
		else
		{
			if(driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"']")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("//div[@class='ngb-dp-arrow right']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"'])[1]")).click();
			}
			else
			{
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"']")).click();
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
		if(driver.findElements(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(24)+"']")).size()>1)
		{
			if(driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(24)+"'])[1]")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(24)+"'])[2]")).click();
			}
			else
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(24)+"'])[1]")).click();
			}
		}
		else
		{
			if(driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(24)+"']")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("//div[@class='ngb-dp-arrow right']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(24)+"'])[1]")).click();
			}
			else
			{
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(24)+"']")).click();
			}
		}
		
	}
	public void selectDomainTrainingEndDateForExistingBatch() throws InterruptedException
	{
		domainTrainingEndDateTextField.click();
		Thread.sleep(2000);
		if(driver.findElements(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(17)+"']")).size()>1)
		{
			if(driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(17)+"'])[1]")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(17)+"'])[2]")).click();
			}
			else
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(17)+"'])[1]")).click();
			}
		}
		else
		{
			if(driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(17)+"']")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("//div[@class='ngb-dp-arrow right']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(17)+"'])[1]")).click();
			}
			else
			{
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(17)+"']")).click();
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
		if(driver.findElements(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(24)+"']")).size()>1)
		{
			if(driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(24)+"'])[1]")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(24)+"'])[2]")).click();
			}
			else
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(24)+"'])[1]")).click();
			}
		}
		else
		{
			if(driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(24)+"']")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("//div[@class='ngb-dp-arrow right']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(24)+"'])[1]")).click();
			}
			else
			{
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(24)+"']")).click();
			}
		}
	}
	public void selectDomainAssessmentStartDateForExistingBatch() throws InterruptedException
	{
		domainAssessmentStartDateTextField.click();
		Thread.sleep(2000);
		if(driver.findElements(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(17)+"']")).size()>1)
		{
			if(driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(17)+"'])[1]")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(17)+"'])[2]")).click();
			}
			else
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(17)+"'])[1]")).click();
			}
		}
		else
		{
			if(driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(17)+"']")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("//div[@class='ngb-dp-arrow right']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(17)+"'])[1]")).click();
			}
			else
			{
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(17)+"']")).click();
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
		if(driver.findElements(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(26)+"']")).size()>1)
		{
			if(driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(26)+"'])[1]")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(26)+"'])[2]")).click();
			}
			else
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(26)+"'])[1]")).click();
			}
		}
		else
		{
			if(driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(26)+"']")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("//div[@class='ngb-dp-arrow right']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(26)+"'])[1]")).click();
			}
			else
			{
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(26)+"']")).click();
			}
		}
	}
	public void selectDomainAssessmentEndDateForExistingBatch() throws InterruptedException
	{
		domainAssessmentEndDateTextField.click();
		Thread.sleep(2000);
		if(driver.findElements(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(19)+"']")).size()>1)
		{
			if(driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(19)+"'])[1]")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(19)+"'])[2]")).click();
			}
			else
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(19)+"'])[1]")).click();
			}
		}
		else
		{
			if(driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(19)+"']")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("//div[@class='ngb-dp-arrow right']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(19)+"'])[1]")).click();
			}
			else
			{
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(19)+"']")).click();
			}
		}
		
	}
	public void clickToCloseDomainAssessmentEndDateCalender()
	{
		closeDomainAssessmentEndDateCalenderIcon.click();
	}
	//Platform Training Dates
	public void selectPlatformTrainingStartDate() throws InterruptedException
	{
		platformTrainingStartDateTextField.click();
		Thread.sleep(2000);
		if(driver.findElements(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"']")).size()>1)
		{
			if(driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"'])[1]")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"'])[2]")).click();
			}
			else
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"'])[1]")).click();
			}
		}
		else
		{
			if(driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"']")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("//div[@class='ngb-dp-arrow right']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"'])[1]")).click();
			}
			else
			{
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(16)+"']")).click();
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
		if(driver.findElements(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(24)+"']")).size()>1)
		{
			if(driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(24)+"'])[1]")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(24)+"'])[2]")).click();
			}
			else
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(24)+"'])[1]")).click();
			}
		}
		else
		{
			if(driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(24)+"']")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("//div[@class='ngb-dp-arrow right']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(24)+"'])[1]")).click();
			}
			else
			{
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(24)+"']")).click();
			}
		}
	}
	public void selectPlatformTrainingEndDateForExistingBatch() throws InterruptedException
	{
		platformTrainingEndDateTextField.click();
		Thread.sleep(2000);
		if(driver.findElements(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(17)+"']")).size()>1)
		{
			if(driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(17)+"'])[1]")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(17)+"'])[2]")).click();
			}
			else
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(17)+"'])[1]")).click();
			}
		}
		else
		{
			if(driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(17)+"']")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("//div[@class='ngb-dp-arrow right']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(17)+"'])[1]")).click();
			}
			else
			{
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(17)+"']")).click();
			}
		}
	}
	public void clickToClosePlatformTrainingEndDateCalender()
	{
		closePlatformTrainingEndDateCalenderIcon.click();
	}
	public void selectPlatformAssessmentStartDateForNewBatch() throws InterruptedException
	{
		platformAssessmentStartDateTextField.click();
		Thread.sleep(2000);
		if(driver.findElements(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(24)+"']")).size()>1)
		{
			if(driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(24)+"'])[1]")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(24)+"'])[2]")).click();
			}
			else
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(24)+"'])[1]")).click();
			}
		}
		else
		{
			if(driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(24)+"']")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("//div[@class='ngb-dp-arrow right']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(24)+"'])[1]")).click();
			}
			else
			{
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(24)+"']")).click();
			}
		}
		
	}
	//Platform Assessment Dates
	public void selectPlatformAssessmentStartDateForExistingBatch() throws InterruptedException
	{
		platformAssessmentStartDateTextField.click();
		Thread.sleep(2000);
		if(driver.findElements(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(17)+"']")).size()>1)
		{
			if(driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(17)+"'])[1]")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(17)+"'])[2]")).click();
			}
			else
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(17)+"'])[1]")).click();
			}
		}
		else
		{
			if(driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(17)+"']")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("//div[@class='ngb-dp-arrow right']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(17)+"'])[1]")).click();
			}
			else
			{
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(17)+"']")).click();
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
		Thread.sleep(2000);
		if(driver.findElements(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(26)+"']")).size()>1)
		{
			if(driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(26)+"'])[1]")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(26)+"'])[2]")).click();
			}
			else
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(26)+"'])[1]")).click();
			}
		}
		else
		{
			if(driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(26)+"']")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("//div[@class='ngb-dp-arrow right']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(26)+"'])[1]")).click();
			}
			else
			{
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(26)+"']")).click();
			}
		}
	}
	public void selectPlatformAssessmentEndDateForExistingBatch() throws InterruptedException
	{
		platformAssessmentEndDateTextField.click();
		Thread.sleep(2000);
		if(driver.findElements(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(19)+"']")).size()>1)
		{
			if(driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(19)+"'])[1]")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(19)+"'])[2]")).click();
			}
			else
			{
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(19)+"'])[1]")).click();
			}
		}
		else
		{
			if(driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(19)+"']")).getAttribute("ng-reflect-disabled").contains("true"))
			{
				driver.findElement(By.xpath("//div[@class='ngb-dp-arrow right']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(19)+"'])[1]")).click();
			}
			else
			{
				driver.findElement(By.xpath("//div[text()='"+AddingDaysToCurrentDate.addDaysToCurrentDate(19)+"']")).click();
			}
		}
	}
	public void clickToClosePlatformAssessmentEndDateCalender()
	{
		closePlatformAssessmentEndDateCalenderIcon.click();
	}
}
