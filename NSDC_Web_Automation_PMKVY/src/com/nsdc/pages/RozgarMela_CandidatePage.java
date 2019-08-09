package com.nsdc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RozgarMela_CandidatePage
{
	WebDriver driver;
    @FindBy(xpath="//p[contains(text(),'View All Rozgar Melas')]")
    private WebElement viewAllRozgarMelasCardText;
    @FindBy(xpath="//button[text()='Attend']")
    private WebElement attendButton;
    @FindBy(xpath="//button[contains(text(),'Download Admit Card')]")
    private WebElement downloadAdmitCardButton;
    @FindBy(xpath="//button[text()='OK']")
    private WebElement okButton;
    @FindBy(xpath="//button[text()='Enrolled / Attended Rozgar Mela']")
    private WebElement enrolled_attendedRozgarMelaSectionButton;
    
    public RozgarMela_CandidatePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void clickToViewAllRozgarMelas()
    {
    	viewAllRozgarMelasCardText.click();
    }
    public void clickToGetActionMenu(String rozgarMelaName)
    {
        driver.findElement(By.xpath("//tr[td[contains(text(),'"+rozgarMelaName+"')]]//a[i[@class='la la-ellipsis-h']]")).click();
    }
    public void selectAttendThisRozgarMelaOption(String rozgarMelaName)
    {
    	driver.findElement(By.xpath("//tr[td[contains(text(),'"+rozgarMelaName+"')]]//span[contains(text(),'Attend This Rozgar Mela')]")).click();
    }
    public void clickToAttendRozgarMela()
    {
    	attendButton.click();
    }
    public void clickToDownloadAdmitCard()
    {
    	downloadAdmitCardButton.click();
    }
    public void clickOK()
    {
    	okButton.click();
    }
    public void clickToGoToEnrolled_AttendedrozgarMelasection()
    {
    	enrolled_attendedRozgarMelaSectionButton.click();
    }
}