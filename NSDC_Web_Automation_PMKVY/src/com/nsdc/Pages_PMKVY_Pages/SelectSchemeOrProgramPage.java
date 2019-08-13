package com.nsdc.Pages_PMKVY_Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nsdc.generic.SelectDropDownList;

public class SelectSchemeOrProgramPage {


		 WebDriver driver;
		 private WebDriverWait wait;  
		  @FindBy(xpath="//a[contains(text(),'4')]")
		  private WebElement PageNumber4;
		  @FindBy(xpath="//a[contains(text(),'3')]")
		  private WebElement PageNumber3;
		  
		  @FindBy(xpath="//tbody[@class='m-datatable__body margin-table ']")
		  private WebElement TableSelectSchemeOrProgram;
		  @FindBy(xpath="//select")
		  private WebElement selectDropDownList;
		  @FindBy(xpath="//a[i[@class='la la-ellipsis-h']]")
		  private WebElement spActionbutton;
		  @FindBy(xpath="//div//a[contains(text(),'Add Project')]")
		  private WebElement spAddProjectButton;
		    public SelectSchemeOrProgramPage(WebDriver driver)
		    {
		        this.driver = driver;
		        PageFactory.initElements(driver, this);
		        wait = new WebDriverWait(driver, 30);
		    }
		

		    public void ClickPageNumber4() throws Exception
		    {

				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", PageNumber4);
				
		    	//wait.until(ExpectedConditions.elementToBeClickable(PageNumber4)).click();
		    }
		    public void ClickPageNumber3() throws Exception
		    {

				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", PageNumber3);
				
		    	//wait.until(ExpectedConditions.elementToBeClickable(PageNumber4)).click();
		    }
		    public void selectValue(String value)
		    {
		    	selectDropDownList.click();
		    	SelectDropDownList.selectDropDownListByVisibleText(selectDropDownList, value);
		    }
		    public void clickOnSpAction()
		    {
		    	spActionbutton.click();
		    }
		    public void clickOnSPAddProject()
		    {
		    	spAddProjectButton.click();
		    }
		    
		    public void SelectSchemeOrProgram()
		    {
		    	
				List<WebElement> rowstable = TableSelectSchemeOrProgram.findElements(By.tagName("tr"));

				int rows_count = rowstable.size();

				for (int row = 0; row < rows_count; row++) {

					List<WebElement> Columnsrow = rowstable.get(row).findElements(By.tagName("td"));

					int columnscount = Columnsrow.size();

					for (int column = 0; column < columnscount; column++) {

						String celtext = Columnsrow.get(column).getText();
						
						if(celtext.equals("PMKVY-CSCM") && Columnsrow.get(column+2).getText().equals("PMKK"))
						{
							Columnsrow.get(8).click();
						}
						// celtext.getClass();
					}
		    }
		    }
		    
		
	}

	
