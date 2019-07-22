package Basetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class qploginpage {
	WebDriver driver;
	//declaration
	@FindBy(xpath="//input[@name='email']")
	 private  WebElement loginIDtextbox;
	@FindBy(xpath="//div[@class='errormsg fontSize']")
	 private  WebElement PWTB;
	@FindBy(id="m_login_signin_submit")
	 private  WebElement loginbutton;
	//Initialization
	public  qploginpage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
//utilization
	public  void setloginid(String loginid) {
	loginIDtextbox.sendKeys(loginid);
	}
	public  void setpassword(String password) {
		PWTB.sendKeys(password);
}
	public void clickloginbutton() {
		loginbutton.click();
	}
}