package com.nsdc.regressionTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nsdc.generic.ReadMultipleDataFromExcel;
import com.nsdc.generic.UploadFile;
import com.nsdc.pages.AddTrainingCentrePage;
import com.nsdc.pages.EnterLoginPage;
import com.nsdc.pages.HA_AllTCRequestPage;
import com.nsdc.pages.HA_DashboardPage;
import com.nsdc.pages.HA_TCViewDetailsPage;
import com.nsdc.pages.LoginPage;
import com.nsdc.pages.PostLoginPage;
import com.nsdc.pages.TrainingPartnerDashboardPage;
import com.nsdc.testConfig.DatabaseConnection;
import com.nsdc.testConfig.TestConfiguration;

public class TrainingCentreWorkflowTestSC_05 extends TestConfiguration
{
	@DataProvider
    public Object[][] TPAddingTC_Data()
    {
        return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/TrainingCentre-Workflow.xls", "TPAddingTC_SC05TC01");
    }
	
	@Test(dataProvider="TPAddingTC_Data")
    public void TP_addingTC_TC_01(String TPname, String address, String SPOC_name, String emailAddress, String mobileNo, String TC_type, String state, String scheme, String holdingAgency, String upload_recommendationLetter) throws Exception
    {
		//DatabaseConnection.deleteTrainingCentre(emailAddress);
		Thread.sleep(2000);
        LoginPage lp = new LoginPage(driver);
        EnterLoginPage elp = new EnterLoginPage(driver);
        lp.clickLogin();
        elp.performlogin("TP332", "Qwerty@123");
        Thread.sleep(4000);
        
        TrainingPartnerDashboardPage dashboard = new TrainingPartnerDashboardPage(driver);
        dashboard.clickOnAddATrainingCentre();
        Thread.sleep(2000);
        
        AddTrainingCentrePage add = new AddTrainingCentrePage(driver);
        add.enterTrainingCentreName(TPname);
        add.enterAddress(address);
        add.enterNameOfTheSPOC(SPOC_name);
        add.enterEmailAddress(emailAddress);
        add.enterMobileNumber(mobileNo);
        if(TC_type.equals("SCHEME"))
        {
        	add.selectTrainingCentreType(TC_type);
            add.selectState(state);
            add.selectSchemeAssociated(scheme);
            add.selectHoldingAgencyAssigned(holdingAgency);
            add.clickOnBrowseToUploadRecommendationLetter();
            Thread.sleep(2000);
            UploadFile.upload(upload_recommendationLetter);
            Thread.sleep(2000);
            add.clickOnUploadToUploadRecommendationLetter();
            Thread.sleep(2000);
            add.clickOnSaveAndNext();
            
        }
        else
        {
        	add.selectTrainingCentreType(TC_type);
        	add.clickOnSaveAndNext();
        	
        }
        
        Assert.assertEquals(driver.findElement(By.xpath("//p[text()='Add a Training Centre']")).getText(), "Add a Training Centre");
    }
	
	@DataProvider
    public Object[][] HA_TCApproval_Data()
    {
        return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/TrainingCentre-Workflow.xls", "HA_TCApproval_SC05TC02");
    }
	
	@Test(dataProvider="HA_TCApproval_Data", dependsOnMethods="TP_addingTC_TC_01")
	public void HA_approvingTC_TC_02(String TC_name, String SPOC_email, String SPOC_mobileNo, String SPOC_name, String review, String comment) throws Exception
	{
		Thread.sleep(2000);
        LoginPage lp = new LoginPage(driver);
        EnterLoginPage elp = new EnterLoginPage(driver);
        lp.clickLogin();
        elp.performlogin("HA_000001", "ekaushal");
        Thread.sleep(4000);
        
        HA_DashboardPage dashboard = new HA_DashboardPage(driver);
        dashboard.clickOnAddingTCRequest();
        Thread.sleep(2000);
        HA_AllTCRequestPage request = new HA_AllTCRequestPage(driver);
        request.enterTCDetailsToSearchTCRequest(SPOC_email);
        Assert.assertEquals(driver.findElement(By.xpath("//td[@data-field='RecordID']")).getText(), "1");
        Assert.assertEquals(driver.findElement(By.xpath("//td[@data-field='OrderID']")).getText(), TC_name);
        String TC_Id = driver.findElement(By.xpath("//td[@data-field='ShipName']")).getText();
        Assert.assertEquals(driver.findElement(By.xpath("//td[@data-field='Currency']")).getText(), SPOC_email);
        Assert.assertEquals(driver.findElement(By.xpath("(//td[@data-field='ShipAddress'])[1]")).getText(), SPOC_mobileNo);
        Assert.assertEquals(driver.findElement(By.xpath("(//td[@data-field='ShipAddress'])[2]")).getText(), SPOC_name);
        
        request.clickOnAction();
        request.clickOnApproveOrReject();
        Thread.sleep(2000);
        if(review.equals("Approved"))
        {
        	request.selectReviewComments(review);
        	request.clickOnSubmit();
        }
        else
        {
        	request.selectReviewComments(review);
            Assert.assertEquals(driver.findElement(By.xpath("//p")).getText(), "Provide reason of Application Rejection");
        	request.enterComment(comment);
        	request.clickOnSubmit();
        }
        Assert.assertEquals(driver.findElement(By.xpath("//h2[text()='Response Recorded Successfully']")).getText(), "Response Recorded Successfully");
        request.clickOnOk();
        Thread.sleep(2000);
        PostLoginPage post = new PostLoginPage(driver);
        post.clickOnProfileLogo();
        post.clickOnLogout();
        Thread.sleep(2000);
        LoginPage login = new LoginPage(driver);
        login.clickLogin();
        Thread.sleep(2000);
        EnterLoginPage enter = new EnterLoginPage(driver);
        enter.enterUsername(TC_Id);
        enter.enterPassword("ekaushal");
        enter.clickLoginToSubmit();
        Assert.assertTrue(driver.findElement(By.xpath("//button[contains(text(),'Reset & Re-login')]")).isDisplayed());
	}
	
	@DataProvider
    public Object[][] HA_TCViewAndApproval_Data()
    {
        return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/TrainingCentre-Workflow.xls", "HA_TCViewAndApproval_SC05TC03");
    }
	
	@Test(dataProvider="HA_TCViewAndApproval_Data", dependsOnMethods="TP_addingTC_TC_01")
	public void HA_viewDetailsAndApprovingTC_TC_03(String TC_name, String address,String SPOC_name, String email, String mobileNo, String type, String state, String schemeAssociated, String HA_assigned, String review, String comment) throws Exception
	{
		Thread.sleep(2000);
        LoginPage lp = new LoginPage(driver);
        EnterLoginPage elp = new EnterLoginPage(driver);
        lp.clickLogin();
        elp.performlogin("HA_000001", "ekaushal");
        Thread.sleep(4000);
        
        HA_DashboardPage dashboard = new HA_DashboardPage(driver);
        dashboard.clickOnAddingTCRequest();
        Thread.sleep(2000);
        HA_AllTCRequestPage request = new HA_AllTCRequestPage(driver);
        request.enterTCDetailsToSearchTCRequest(email);
        String TC_Id = driver.findElement(By.xpath("//td[@data-field='ShipName']")).getText();
        request.clickOnAction();
        request.clickOnViewDetails();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.name("tc-name")).getAttribute("value"), TC_name);
        Assert.assertEquals(driver.findElement(By.name("tc-address")).getAttribute("value"), address);
        Assert.assertEquals(driver.findElement(By.name("Spoc-email")).getAttribute("value"), email);
        Assert.assertEquals(driver.findElement(By.name("mobile-number")).getAttribute("value"), mobileNo);
        Assert.assertEquals(driver.findElement(By.name("SPOC-name")).getAttribute("value"), SPOC_name);
        Assert.assertEquals(driver.findElement(By.name("tcType")).getAttribute("value"), type);
        Assert.assertEquals(driver.findElement(By.name("state")).getAttribute("value"), state);
        Assert.assertEquals(driver.findElement(By.name("scheme")).getAttribute("value"), schemeAssociated);
        Assert.assertEquals(driver.findElement(By.name("assignedHA")).getAttribute("value"), HA_assigned);
        HA_TCViewDetailsPage details = new HA_TCViewDetailsPage(driver);
        if(review.equals("Approved"))
        {
        	details.selectReviewComment(review);
        	details.clickOnSubmit();
        }
        else
        {
        	details.selectReviewComment(review);
            Assert.assertEquals(driver.findElement(By.xpath("//p")).getText(), "Provide reason of Application Rejection");
        	details.enterComment(comment);
        	details.clickOnSubmit();
        }
        
        Assert.assertEquals(driver.findElement(By.xpath("//h2[text()='Response Recorded Successfully']")).getText(), "Response Recorded Successfully");
        request.clickOnOk();
        Thread.sleep(2000);
        PostLoginPage post = new PostLoginPage(driver);
        post.clickOnProfileLogo();
        post.clickOnLogout();
        Thread.sleep(2000);
        LoginPage login = new LoginPage(driver);
        login.clickLogin();
        Thread.sleep(2000);
        EnterLoginPage enter = new EnterLoginPage(driver);
        enter.enterUsername(TC_Id);
        enter.enterPassword("ekaushal");
        enter.clickLoginToSubmit();
        Assert.assertTrue(driver.findElement(By.xpath("//button[contains(text(),'Reset & Re-login')]")).isDisplayed());
	}

}
