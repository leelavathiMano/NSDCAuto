package com.nsdc.regressionTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.nsdc.generic.ReadMultipleDataFromExcel;
import com.nsdc.generic.ReadWriteData;
import com.nsdc.generic.UploadFile;
import com.nsdc.pages.DA_Assign_TPRegistrationFormPage;
import com.nsdc.pages.DA_DashboardPage;
import com.nsdc.pages.DesktopAssessor_ViewInspectionPage;
import com.nsdc.pages.EnterLoginPage;
import com.nsdc.pages.InspectionAgency_DashboardPage;
import com.nsdc.pages.InspectionAgency_ViewInspectionPage;
import com.nsdc.pages.LoginPage;
import com.nsdc.pages.PostLoginPage;
import com.nsdc.pages.RegistrationPage;
import com.nsdc.pages.TrainingPartnerReEditRegistrationPage;
import com.nsdc.pages.TrainingPartnerRegistrationPage;
import com.nsdc.testConfig.TestConfiguration;


public class TrainingPartnerWorkflowTestSC_02 extends TestConfiguration
{
	@DataProvider
    public Object[][] tpProfileData()
    {
        return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/TrainingPartner-Workflow.xls", "TPProfileSC02TC01");
    }
    
    @Test(dataProvider="tpProfileData")
    public void tpRegistrationsTC_01(String sno, String userType, String spocName, String email, String mobile, String emailOTP, String mobileOTP, String tpid, String oldPassword, String newPassword, String confirmPassword, String name_Of_Organization, String type_Of_The_Organization, String year_Of_Establishment, String uploadFilePath, String landLine, String website, String name_Of_Ceo, String email_Of_Ceo, String mobile_Number_Of_Ceo, String authorized_Signatory_Name1, String authorized_Signatory_Email1, String authorized_Signatory_Mobile1, String authorized_Signatory_Name2, String authorized_Signatory_Email2, String authorized_Signatory_Mobile2, String addresss_Of_Organization, String near_By_Landmark, String pin_Code, String state, String district, String tehsil, String city, String geo_Location, String parliamentary_constituency, String address_proof, String uploadFile, String pan_Number, String upload_PAN, String gst_Number, String upload_GST, String turnover1, String upload_turnover1, String turnover2, String upload_turnover2, String turnover3, String upload_turnover3, String aadhar_Number, String upload_provisional) throws Exception
    {
        //DatabaseConnection.deleteTrainingPartner(email);
        String year_Establishment = year_Of_Establishment;
        int year = Integer.parseInt(year_Establishment);
        
        Thread.sleep(2000);
        LoginPage lp = new LoginPage(driver);
        Thread.sleep(2000);
        lp.clickRegister();
        RegistrationPage rp = new RegistrationPage(driver);
        rp.selectDropdownList(userType);
        rp.enterSPOCName(spocName);
        rp.enterEmail(email);
        rp.enterMobile(mobile);
        rp.clickIagree();
        rp.clickRegister();
        Thread.sleep(2000);
        rp.enterEmailOTP(emailOTP);
        rp.enterMobileOTP(mobileOTP);
        Thread.sleep(5000);
        rp.clickVerify();
        Thread.sleep(2000);
        
        String username = driver.findElement(By.xpath("//span[@class='text-bold']")).getText();
        ReadWriteData.setExcelData("./TestData/Workflow/TrainingPartner-Workflow.xls", "TPProfileSC02TC01", Integer.parseInt(sno) , 7, username);
        ReadWriteData.setExcelData("./TestData/Workflow/TrainingPartner-Workflow.xls", "TPApprovalSC02TC02", Integer.parseInt(sno), 3, username);
        rp.clickGoToLogin();
        EnterLoginPage elp = new EnterLoginPage(driver);
        elp.performlogin(username, "ekaushal");
        Thread.sleep(2000);
        rp.enterOldPassword(oldPassword);
        rp.enterNewPassword(newPassword);
        rp.enterConfirmPassword(confirmPassword);
        rp.clickResetResubmit();
        Thread.sleep(2000);
        rp.clickConfirmationOkMessage();
        
        elp.performlogin(username, confirmPassword);
        Thread.sleep(4000);
        
        TrainingPartnerRegistrationPage tprp = new TrainingPartnerRegistrationPage(driver);
        tprp.enterNameOfOrganizationTextBox(name_Of_Organization);
        tprp.selectTypeOfTheOrganization(type_Of_The_Organization);
        if(type_Of_The_Organization.equals("Government Institute"))
        {
            tprp.enterLandline(landLine);
        }
        else
        {
        	tprp.selectYearOfEstablishment(year_Of_Establishment);
            Thread.sleep(2000);
            tprp.clickBrowseFile();
            Thread.sleep(2000);
            UploadFile.upload(uploadFilePath);
            Thread.sleep(2000);
            tprp.clickUploadFile();
            Thread.sleep(5000);
            tprp.enterLandline(landLine);
        }
        
        tprp.enterWebsite(website);
        tprp.enterNameOfCeo(name_Of_Ceo);
        tprp.enterEmailOfCeo(email_Of_Ceo);
        tprp.enterMobileNumberOfCeo(mobile_Number_Of_Ceo);
        tprp.clickAuthorizedSignatoryCheckBox();
        
        Thread.sleep(3000);
        tprp.enterAuthorizedSignatoryName(authorized_Signatory_Name1);
        tprp.enterAuthorizedSignatoryEmail(authorized_Signatory_Email1);
        tprp.enterAuthorizedSignatoryMobile(authorized_Signatory_Mobile1);
        tprp.clickAddAnotherSignatoryDetails();
        
        Thread.sleep(3000);
        tprp.enterAuthorizedSignatoryName(authorized_Signatory_Name2);
        tprp.enterAuthorizedSignatoryEmail(authorized_Signatory_Email2);
        tprp.enterAuthorizedSignatoryMobile(authorized_Signatory_Mobile2);
        tprp.clickAddAnotherSignatoryDetails();
        
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[b[text()='1']]]//b[text()='"+name_Of_Ceo+"']")).getText(), name_Of_Ceo);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[b[text()='1']]]//b[text()='"+email_Of_Ceo+"']")).getText(), email_Of_Ceo);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[b[text()='1']]]//b[text()='"+mobile_Number_Of_Ceo+"']")).getText(), mobile_Number_Of_Ceo);
        
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[b[text()='2']]]//b[text()='"+authorized_Signatory_Name1+"']")).getText(), authorized_Signatory_Name1);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[b[text()='2']]]//b[text()='"+authorized_Signatory_Email1+"']")).getText(), authorized_Signatory_Email1);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[b[text()='2']]]//b[text()='"+authorized_Signatory_Mobile1+"']")).getText(), authorized_Signatory_Mobile1);
       
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[b[text()='3']]]//b[text()='"+authorized_Signatory_Name2+"']")).getText(), authorized_Signatory_Name2);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[b[text()='3']]]//b[text()='"+authorized_Signatory_Email2+"']")).getText(), authorized_Signatory_Email2);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[b[text()='3']]]//b[text()='"+authorized_Signatory_Mobile2+"']")).getText(), authorized_Signatory_Mobile2);
        Thread.sleep(3000);
        tprp.clickOn_Delete_Third_AuthorizedSignatory();
        
        Thread.sleep(3000);
        tprp.clickSaveAndNextButton();
        Thread.sleep(3000);
        tprp.enterAddressOfOrganizationTextBox(addresss_Of_Organization);
        tprp.enterNearByLandmark(near_By_Landmark);
        tprp.enterPinCode(pin_Code);
        tprp.selectState(state);
        tprp.selectDistrict(district);
        tprp.selectTehsil(tehsil);
        tprp.selectCity(city);
        tprp.enterGeoLocation(geo_Location);
        Thread.sleep(2000);
        tprp.selectParliamentaryConstituency(parliamentary_constituency);
        Thread.sleep(2000);
        tprp.selectAddressProof(address_proof);
        Thread.sleep(2000);
        tprp.clickBrowseFile();
        Thread.sleep(2000);
        UploadFile.upload(uploadFile);
        Thread.sleep(2000);
        tprp.clickUploadFile();
        Thread.sleep(5000);
        tprp.clickOnCommunicationAddressSameAsPermanentAddress();
        
//        Thread.sleep(3000);
//        Assert.assertEquals(driver.findElement(By.xpath("//textarea[@formcontrolname='address1']")).getAttribute("value"), addresss_Of_Organization);
//        Assert.assertEquals(driver.findElement(By.xpath("(//input[@formcontrolname='landmark'])[2]")).getAttribute("value"), near_By_Landmark);
//        Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='pinCode']")).getAttribute("value"), pin_Code);
//        Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='state'])[2]")).getAttribute("value"), state);
//        Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='district'])[2]")).getAttribute("value"), district);
//        Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='subDistrict'])[2]")).getAttribute("value"), tehsil);
//        Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='village'])[2]")).getAttribute("value"), city);
//        Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='parliamentaryConstituency'])[2]")).getAttribute("value"), parliamentary_constituency);
//        Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='addressProof'])[2]")).getAttribute("value"), address_proof);
       
        Thread.sleep(4000);
        tprp.clickOn_Second_BrowseFile();
        Thread.sleep(3000);
        UploadFile.upload(uploadFile);
        Thread.sleep(3000);
        tprp.clickOn_Second_UploadFile();
        
        Thread.sleep(4000);
        tprp.clickSaveAndNextButton();
        
        if(year_Of_Establishment.equals("2018") && (type_Of_The_Organization.equals("Firm") || type_Of_The_Organization.equals("Society") || type_Of_The_Organization.equals("Trust") || type_Of_The_Organization.equals("Limited Liability Partnership (LLP)")))
        {
        	Thread.sleep(3000);
            tprp.enterPANNumber(pan_Number);
            Thread.sleep(3000);
            tprp.clickBrowseButton1();
            Thread.sleep(3000);
            UploadFile.upload(upload_PAN);
            Thread.sleep(3000);
            tprp.clickUploadButton1();
            Thread.sleep(3000);
            //tprp.enterGSTAccountNumber(gst_Number);
            //Thread.sleep(3000);
            //tprp.clickBrowseButton2();
            //Thread.sleep(3000);
            //UploadFile.upload(upload_GST);
            //Thread.sleep(3000);
            //tprp.clickUploadButton2();
            Thread.sleep(3000);
            tprp.clickBrowseButton2();
            Thread.sleep(3000);
            
            UploadFile.upload(upload_provisional);
            Thread.sleep(3000);
            tprp.clickUploadButton2();
            Thread.sleep(3000);
            
            tprp.clickSaveAndNextButton();
            Thread.sleep(4000);
            
            tprp.clickIAgreeCheckBox();
            Thread.sleep(3000);
            tprp.clickSaveAndContinueToPaymentButton();
            Thread.sleep(3000);
            //tprp.clickPaymentOkButton();
            Thread.sleep(3000);
        }
        
        else if(year_Of_Establishment.equals("2018") && (type_Of_The_Organization.equals("Company")))
        {
        	Thread.sleep(3000);
            tprp.enterPANNumber(pan_Number);
            Thread.sleep(3000);
            tprp.clickBrowseButton1();
            Thread.sleep(3000);
            UploadFile.upload(upload_PAN);
            Thread.sleep(3000);
            tprp.clickUploadButton1();
            Thread.sleep(3000);
            tprp.enterGSTAccountNumber(gst_Number);
            Thread.sleep(3000);
            tprp.clickBrowseButton2();
            Thread.sleep(3000);
            UploadFile.upload(upload_GST);
            Thread.sleep(3000);
            tprp.clickUploadButton2();
            Thread.sleep(3000);
            tprp.clickBrowseButton3();
            Thread.sleep(3000);
            
            UploadFile.upload(upload_provisional);
            Thread.sleep(3000);
            tprp.clickUploadButton3();
            Thread.sleep(3000);
            
            tprp.clickSaveAndNextButton();
            Thread.sleep(4000);
            
            tprp.clickIAgreeCheckBox();
            Thread.sleep(3000);
            tprp.clickSaveAndContinueToPaymentButton();
            Thread.sleep(3000);
            //tprp.clickPaymentOkButton();
            Thread.sleep(3000);
        }
        
        else if(year_Of_Establishment.equals("2018") && type_Of_The_Organization.equals("Proprietorship"))
        {
        	Thread.sleep(3000);
            //tprp.enterAadharNumber(aadhar_Number);
            //tprp.clickToVerifyAadharNumber();
        	tprp.enterPANNumber(pan_Number);
            Thread.sleep(5000);
            tprp.clickBrowseButton1();
            Thread.sleep(4000);
            UploadFile.upload(upload_PAN);
            Thread.sleep(3000);
            tprp.clickUploadButton1();
            
            Thread.sleep(4000);
            tprp.clickBrowseButton2();
            Thread.sleep(3000);
            UploadFile.upload(upload_provisional);
            Thread.sleep(3000);
            tprp.clickUploadButton2();
            Thread.sleep(3000);
            
            tprp.clickSaveAndNextButton();
            Thread.sleep(4000);
            
            tprp.clickIAgreeCheckBox();
            Thread.sleep(3000);
            tprp.clickSaveAndContinueToPaymentButton();
            Thread.sleep(3000);
            //tprp.clickPaymentOkButton();
            Thread.sleep(3000);
        }
        
        else if(year_Of_Establishment.equals("2017") && (type_Of_The_Organization.equals("Firm") || type_Of_The_Organization.equals("Society") || type_Of_The_Organization.equals("Trust") || type_Of_The_Organization.equals("Limited Liability Partnership (LLP)")))
        {
        	Thread.sleep(3000);
            tprp.enterPANNumber(pan_Number);
            Thread.sleep(3000);
            tprp.clickBrowseButton1();
            Thread.sleep(3000);
            UploadFile.upload(upload_PAN);
            Thread.sleep(3000);
            tprp.clickUploadButton1();
            Thread.sleep(3000);
            //tprp.enterGSTAccountNumber(gst_Number);
            //Thread.sleep(3000);
            //tprp.clickBrowseButton2();
            //Thread.sleep(3000);
            //UploadFile.upload(upload_GST);
            //Thread.sleep(3000);
            //tprp.clickUploadButton2();
            //Thread.sleep(4000);
            
            tprp.enterAnnualTurnOver1(turnover1);
            Thread.sleep(4000);
            tprp.clickBrowseButton2();
            Thread.sleep(4000);
            UploadFile.upload(upload_turnover1);
            Thread.sleep(4000);
            tprp.clickUploadButton2();
            Thread.sleep(3000);
            
            tprp.clickSaveAndNextButton();
            Thread.sleep(4000);
            
            tprp.clickIAgreeCheckBox();
            Thread.sleep(3000);
            tprp.clickSaveAndContinueToPaymentButton();
            Thread.sleep(3000);
            //tprp.clickPaymentOkButton();
            Thread.sleep(3000);
        }
        
        else if(year_Of_Establishment.equals("2017") && (type_Of_The_Organization.equals("Company")))
        {
        	Thread.sleep(3000);
            tprp.enterPANNumber(pan_Number);
            Thread.sleep(3000);
            tprp.clickBrowseButton1();
            Thread.sleep(3000);
            UploadFile.upload(upload_PAN);
            Thread.sleep(3000);
            tprp.clickUploadButton1();
            Thread.sleep(3000);
            tprp.enterGSTAccountNumber(gst_Number);
            Thread.sleep(3000);
            tprp.clickBrowseButton2();
            Thread.sleep(3000);
            UploadFile.upload(upload_GST);
            Thread.sleep(3000);
            tprp.clickUploadButton2();
            Thread.sleep(4000);
            
            tprp.enterAnnualTurnOver1(turnover1);
            Thread.sleep(4000);
            tprp.clickBrowseButton3();
            Thread.sleep(4000);
            UploadFile.upload(upload_turnover1);
            Thread.sleep(4000);
            tprp.clickUploadButton3();
            Thread.sleep(3000);
            
            tprp.clickSaveAndNextButton();
            Thread.sleep(4000);
            
            tprp.clickIAgreeCheckBox();
            Thread.sleep(3000);
            tprp.clickSaveAndContinueToPaymentButton();
            Thread.sleep(3000);
            //tprp.clickPaymentOkButton();
            Thread.sleep(3000);
        }
        
        else if(year_Of_Establishment.equals("2017") && type_Of_The_Organization.equals("Proprietorship"))
        {
        	Thread.sleep(3000);
            //tprp.enterAadharNumber(aadhar_Number);
            //tprp.clickToVerifyAadharNumber();
        	tprp.enterPANNumber(pan_Number);
        	Thread.sleep(4000);
            tprp.clickBrowseButton1();
            Thread.sleep(4000);
            UploadFile.upload(upload_PAN);
            Thread.sleep(4000);
            tprp.clickUploadButton1();
            Thread.sleep(5000);
            tprp.enterAnnualTurnOver1(turnover1);
            Thread.sleep(4000);
            tprp.clickBrowseButton2();
            Thread.sleep(4000);
            UploadFile.upload(upload_turnover1);
            Thread.sleep(4000);
            tprp.clickUploadButton2();
            Thread.sleep(3000);
            
            tprp.clickSaveAndNextButton();
            Thread.sleep(4000);
            
            tprp.clickIAgreeCheckBox();
            Thread.sleep(3000);
            tprp.clickSaveAndContinueToPaymentButton();
            Thread.sleep(3000);
            //tprp.clickPaymentOkButton();
            Thread.sleep(3000);
        }
        
        else if(year_Of_Establishment.equals("2016") && (type_Of_The_Organization.equals("Firm") || type_Of_The_Organization.equals("Society") || type_Of_The_Organization.equals("Trust") || type_Of_The_Organization.equals("Limited Liability Partnership (LLP)")))
        {
        	Thread.sleep(3000);
            tprp.enterPANNumber(pan_Number);
            Thread.sleep(3000);
            tprp.clickBrowseButton1();
            Thread.sleep(3000);
            UploadFile.upload(upload_PAN);
            Thread.sleep(3000);
            tprp.clickUploadButton1();
            Thread.sleep(4000);
            //tprp.enterGSTAccountNumber(gst_Number);
            //Thread.sleep(3000);
            //tprp.clickBrowseButton2();
            //Thread.sleep(3000);
            //UploadFile.upload(upload_GST);
            //Thread.sleep(3000);
            //tprp.clickUploadButton2();
            //Thread.sleep(4000);
            
            tprp.enterAnnualTurnOver1(turnover1);
            Thread.sleep(4000);
            tprp.clickBrowseButton2();
            Thread.sleep(4000);
            UploadFile.upload(upload_turnover1);
            Thread.sleep(4000);
            tprp.clickUploadButton2();
            Thread.sleep(5000);
            tprp.enterAnnualTurnOver2(turnover2);
            Thread.sleep(4000);
            tprp.clickBrowseButton3();
            Thread.sleep(4000);
            UploadFile.upload(upload_turnover2);
            Thread.sleep(4000);
            tprp.clickUploadButton3();
            Thread.sleep(4000);
            
            tprp.clickSaveAndNextButton();
            Thread.sleep(4000);
            
            tprp.clickIAgreeCheckBox();
            Thread.sleep(3000);
            tprp.clickSaveAndContinueToPaymentButton();
            Thread.sleep(3000);
            //tprp.clickPaymentOkButton();
            Thread.sleep(3000);
        }
        
        else if(year_Of_Establishment.equals("2016") && (type_Of_The_Organization.equals("Company")))
        {
        	Thread.sleep(3000);
            tprp.enterPANNumber(pan_Number);
            Thread.sleep(3000);
            tprp.clickBrowseButton1();
            Thread.sleep(3000);
            UploadFile.upload(upload_PAN);
            Thread.sleep(3000);
            tprp.clickUploadButton1();
            Thread.sleep(3000);
            tprp.enterGSTAccountNumber(gst_Number);
            Thread.sleep(3000);
            tprp.clickBrowseButton2();
            Thread.sleep(3000);
            UploadFile.upload(upload_GST);
            Thread.sleep(3000);
            tprp.clickUploadButton2();
            Thread.sleep(4000);
            
            tprp.enterAnnualTurnOver1(turnover1);
            Thread.sleep(4000);
            tprp.clickBrowseButton3();
            Thread.sleep(4000);
            UploadFile.upload(upload_turnover1);
            Thread.sleep(4000);
            tprp.clickUploadButton3();
            Thread.sleep(5000);
            tprp.enterAnnualTurnOver2(turnover2);
            Thread.sleep(4000);
            tprp.clickBrowseButton4();
            Thread.sleep(4000);
            UploadFile.upload(upload_turnover2);
            Thread.sleep(4000);
            tprp.clickUploadButton4();
            Thread.sleep(4000);
            
            tprp.clickSaveAndNextButton();
            Thread.sleep(4000);
            
            tprp.clickIAgreeCheckBox();
            Thread.sleep(3000);
            tprp.clickSaveAndContinueToPaymentButton();
            Thread.sleep(3000);
            //tprp.clickPaymentOkButton();
            Thread.sleep(3000);
        }
        
        else if(year_Of_Establishment.equals("2016") && type_Of_The_Organization.equals("Proprietorship"))
        {
        	Thread.sleep(3000);
            //tprp.enterAadharNumber(aadhar_Number);
            //tprp.clickToVerifyAadharNumber();
        	tprp.enterPANNumber(pan_Number);
        	Thread.sleep(5000);
            tprp.clickBrowseButton1();
            Thread.sleep(4000);
            UploadFile.upload(upload_PAN);
            Thread.sleep(4000);
            tprp.clickUploadButton1();
            Thread.sleep(5000);
            tprp.enterAnnualTurnOver1(turnover1);
            Thread.sleep(4000);
            tprp.clickBrowseButton2();
            Thread.sleep(4000);
            UploadFile.upload(upload_turnover1);
            Thread.sleep(4000);
            tprp.clickUploadButton2();
            Thread.sleep(5000);
            tprp.enterAnnualTurnOver2(turnover2);
            Thread.sleep(4000);
            tprp.clickBrowseButton3();
            Thread.sleep(4000);
            UploadFile.upload(upload_turnover2);
            Thread.sleep(4000);
            tprp.clickUploadButton3();
            Thread.sleep(4000);
            
            tprp.clickSaveAndNextButton();
            Thread.sleep(4000);
            
            tprp.clickIAgreeCheckBox();
            Thread.sleep(3000);
            tprp.clickSaveAndContinueToPaymentButton();
            Thread.sleep(3000);
            //tprp.clickPaymentOkButton();
            Thread.sleep(3000);
        }
        
        else if((year < 2016) && (type_Of_The_Organization.equals("Firm") || type_Of_The_Organization.equals("Society") || type_Of_The_Organization.equals("Trust") || type_Of_The_Organization.equals("Limited Liability Partnership (LLP)")))
        {
        	Thread.sleep(3000);
            tprp.enterPANNumber(pan_Number);
            Thread.sleep(3000);
            tprp.clickBrowseButton1();
            Thread.sleep(3000);
            UploadFile.upload(upload_PAN);
            Thread.sleep(3000);
            tprp.clickUploadButton1();
            //Thread.sleep(3000);
            //tprp.enterGSTAccountNumber(gst_Number);
            //Thread.sleep(3000);
            //tprp.clickBrowseButton2();
            //Thread.sleep(3000);
            //UploadFile.upload(upload_GST);
            //Thread.sleep(3000);
            //tprp.clickUploadButton2();
            Thread.sleep(5000);
            
            tprp.enterAnnualTurnOver1(turnover1);
            Thread.sleep(4000);
            tprp.clickBrowseButton2();
            Thread.sleep(4000);
            UploadFile.upload(upload_turnover1);
            Thread.sleep(4000);
            tprp.clickUploadButton2();
            Thread.sleep(5000);
            tprp.enterAnnualTurnOver2(turnover2);
            Thread.sleep(4000);
            tprp.clickBrowseButton3();
            Thread.sleep(4000);
            UploadFile.upload(upload_turnover2);
            Thread.sleep(4000);
            tprp.clickUploadButton3();
            Thread.sleep(5000);
            tprp.enterAnnualTurnOver3(turnover3);
            Thread.sleep(4000);
            tprp.clickBrowseButton4();
            Thread.sleep(4000);
            UploadFile.upload(upload_turnover3);
            Thread.sleep(4000);
            tprp.clickUploadButton4();
            Thread.sleep(3000);
            
            tprp.clickSaveAndNextButton();
            Thread.sleep(4000);
            
            tprp.clickIAgreeCheckBox();
            Thread.sleep(3000);
            tprp.clickSaveAndContinueToPaymentButton();
            Thread.sleep(3000);
            //tprp.clickPaymentOkButton();
            Thread.sleep(3000);
        }
        
        else if((year < 2016) && (type_Of_The_Organization.equals("Company")))
        {
        	Thread.sleep(3000);
            tprp.enterPANNumber(pan_Number);
            Thread.sleep(3000);
            tprp.clickBrowseButton1();
            Thread.sleep(3000);
            UploadFile.upload(upload_PAN);
            Thread.sleep(3000);
            tprp.clickUploadButton1();
            Thread.sleep(3000);
            tprp.enterGSTAccountNumber(gst_Number);
            Thread.sleep(3000);
            tprp.clickBrowseButton2();
            Thread.sleep(3000);
            UploadFile.upload(upload_GST);
            Thread.sleep(3000);
            tprp.clickUploadButton2();
            Thread.sleep(5000);
            
            tprp.enterAnnualTurnOver1(turnover1);
            Thread.sleep(4000);
            tprp.clickBrowseButton3();
            Thread.sleep(4000);
            UploadFile.upload(upload_turnover1);
            Thread.sleep(4000);
            tprp.clickUploadButton3();
            Thread.sleep(5000);
            tprp.enterAnnualTurnOver2(turnover2);
            Thread.sleep(4000);
            tprp.clickBrowseButton4();
            Thread.sleep(4000);
            UploadFile.upload(upload_turnover2);
            Thread.sleep(4000);
            tprp.clickUploadButton4();
            Thread.sleep(5000);
            tprp.enterAnnualTurnOver3(turnover3);
            Thread.sleep(4000);
            tprp.clickBrowseButton5();
            Thread.sleep(4000);
            UploadFile.upload(upload_turnover3);
            Thread.sleep(4000);
            tprp.clickUploadButton5();
            Thread.sleep(3000);
            
            tprp.clickSaveAndNextButton();
            Thread.sleep(4000);
            
            tprp.clickIAgreeCheckBox();
            Thread.sleep(3000);
            tprp.clickSaveAndContinueToPaymentButton();
            Thread.sleep(3000);
            //tprp.clickPaymentOkButton();
            Thread.sleep(3000);
        }
        
        else if((year < 2016) && type_Of_The_Organization.equals("Proprietorship"))
        {
        	Thread.sleep(3000);
            //tprp.enterAadharNumber(aadhar_Number);
            //tprp.clickToVerifyAadharNumber();
        	tprp.enterPANNumber(pan_Number);
        	Thread.sleep(5000);
        	tprp.clickBrowseButton1();
            Thread.sleep(4000);
            UploadFile.upload(upload_PAN);
            Thread.sleep(4000);
            tprp.clickUploadButton1();
            Thread.sleep(5000);
            tprp.enterAnnualTurnOver1(turnover1);
            Thread.sleep(4000);
            tprp.clickBrowseButton2();
            Thread.sleep(4000);
            UploadFile.upload(upload_turnover1);
            Thread.sleep(4000);
            tprp.clickUploadButton2();
            Thread.sleep(5000);
            tprp.enterAnnualTurnOver2(turnover2);
            Thread.sleep(4000);
            tprp.clickBrowseButton3();
            Thread.sleep(4000);
            UploadFile.upload(upload_turnover2);
            Thread.sleep(4000);
            tprp.clickUploadButton3();
            Thread.sleep(5000);
            tprp.enterAnnualTurnOver3(turnover3);
            Thread.sleep(4000);
            tprp.clickBrowseButton4();
            Thread.sleep(4000);
            UploadFile.upload(upload_turnover3);
            Thread.sleep(4000);
            tprp.clickUploadButton4();
            Thread.sleep(4000);
            
            tprp.clickSaveAndNextButton();
            Thread.sleep(4000);
            
            tprp.clickIAgreeCheckBox();
            Thread.sleep(3000);
            tprp.clickSaveAndContinueToPaymentButton();
            Thread.sleep(3000);
            //tprp.clickPaymentOkButton();
            Thread.sleep(3000);
        }
        
        else if(type_Of_The_Organization.equals("Government Institute"))
        {
            Thread.sleep(4000);
            tprp.clickIAgreeCheckBox();
            Thread.sleep(3000);
            tprp.clickSaveAndContinueButton();
            Thread.sleep(3000);
        }
        
        //tprp.clickDownloadButton();
        Thread.sleep(5000);
        tprp.clickLogOutButton();
        Thread.sleep(3000);
        
        Assert.assertEquals(driver.findElement(By.xpath("//li[text()='LOGIN']")).getText(), "LOGIN");
    }
    
    @DataProvider
    public Object[][] tpApproval()
    {
        return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/TrainingPartner-Workflow.xls", "TPApprovalSC02TC02");
    }
    
    @Test(dataProvider="tpApproval")
    public void trainingPartnerApprovalTC_02(String srno, String iausername, String password, String tpID, String establishment_Year, String assignTo, String statusForRequest, String dausername, String Password, String nameReview, String typeReview, String addressReview,String adharReview,  String panReview, String gstReview, String establishmentReview, String provisionalReview, String firstFinancialYearReview, String secondFinancialYearReview, String thirdFinancialYearReview, String finalStatusFile, String tpPassword) throws Exception
    {
    	LoginPage lp = new LoginPage(driver);
    	lp.clickLogin();
    	EnterLoginPage elp = new EnterLoginPage(driver);
    	elp.performlogin(iausername, password);
    	Thread.sleep(4000);
    	
    	InspectionAgency_DashboardPage ia = new InspectionAgency_DashboardPage(driver);
    	Thread.sleep(5000);
    	ia.clickOnViewAllAssessmentRequest();
    	InspectionAgency_ViewInspectionPage ia_vp = new InspectionAgency_ViewInspectionPage(driver);
    	Thread.sleep(2000);
    	ia_vp.enterTPIDForSearch(tpID);
    	Thread.sleep(3000);
    	ia_vp.clickOnApply();
    	Thread.sleep(3000);
    	ia_vp.clickOnAction();
    	ia_vp.clickOnTakeAction();
    	Thread.sleep(2000);
    	ia_vp.selectForAssignTo_Second(assignTo);
    	//ia_vp.selectStatusForRequest(statusForRequest);
    	ia_vp.clickForAssign();
    	Thread.sleep(3000);
    	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[text()='"+tpID+"']]]//span[text()='In-Process DA']")).getText(), "In-Process DA");
    	Thread.sleep(3000);
    	PostLoginPage plp = new PostLoginPage(driver);
    	plp.clickOnProfileLogo();
    	plp.clickOnLogout();
    	Thread.sleep(2000);
    	
    	lp.clickLogin();
    	elp.performlogin(dausername, Password);
    	
    	DA_DashboardPage da = new DA_DashboardPage(driver);
    	Thread.sleep(10000);
    	da.clickOnViewAllAssessmentRequest();
    	Thread.sleep(5000);
    	DesktopAssessor_ViewInspectionPage da_vp = new DesktopAssessor_ViewInspectionPage(driver);
    	Thread.sleep(3000);
    	da_vp.enterKeywordForTPID(tpID);
    	Thread.sleep(3000);
    	da_vp.clickOnApply();
    	Thread.sleep(5000);
    	//String new_tp = driver.findElement(By.xpath("(//td[@class='m-datatable__cell']/span)[1]")).getText(); 
    	da_vp.clickOnAction();
    	Thread.sleep(2000);
    	da_vp.clickOnTakeAction();
    	Thread.sleep(2000);
    	DA_Assign_TPRegistrationFormPage da_tpr = new DA_Assign_TPRegistrationFormPage(driver);
    	Thread.sleep(2000);
    	String type_Organization = driver.findElement(By.xpath("(//input[@class='form-control m-input ng-untouched ng-pristine'])[2]")).getAttribute("value");
    	//da_tpr.clickFordisplayPreviewofAttachedProofDocumentForOrganizationName();
    	//da_tpr.selectReviewCommentsForOrganizationName(nameReview);
    	//da_tpr.selectReviewCommentsForTypeOFOrganization(typeReview);
    	Thread.sleep(8000);
    	da_tpr.clickForDisplayPreviewofAttachedProofDocumentForAddress();
    	da_tpr.selectReviewCommentsForAddress(addressReview);
    	Thread.sleep(2000);
    	da_tpr.clickForSaveAndContinue();
    	int yearOfEstablishment = Integer.parseInt(establishment_Year);
    	Thread.sleep(2000);
    	
    	if(establishment_Year.equals("2018") && (type_Organization.equals("Firm") || type_Organization.equals("Society") || type_Organization.equals("Trust") || type_Organization.equals("Limited Liability Partnership (LLP)")))
        {
    		Thread.sleep(2000);
        	da_tpr.clickOn_First_PreviewAttachedProofDocument();
        	da_tpr.selectReviewCommentForPAN(panReview);
        	Thread.sleep(2000);
        	//da_tpr.clickOn_Second_PreviewAttachedProofDocument();
        	//da_tpr.selectReviewCommentsForGST(gstReview);
        	//Thread.sleep(2000);
        	da_tpr.clickOn_Second_PreviewAttachedProofDocument();
        	da_tpr.selectReviewCommentForEstablishmentYear(establishmentReview);  
    		Thread.sleep(2000);
    		da_tpr.clickOn_Third_PreviewAttachedProofDocument();
    		da_tpr.selectReviewCommentForProvisionalCertificate(provisionalReview);

        }
    	
    	else if(establishment_Year.equals("2018") && (type_Organization.equals("Company")))
    	{
    		Thread.sleep(2000);
        	da_tpr.clickOn_First_PreviewAttachedProofDocument();
        	da_tpr.selectReviewCommentForPAN(panReview);
        	Thread.sleep(2000);
        	da_tpr.clickOn_Second_PreviewAttachedProofDocument();
        	da_tpr.selectReviewCommentsForGST(gstReview);
        	Thread.sleep(2000);
        	da_tpr.clickOn_Third_PreviewAttachedProofDocument();
        	da_tpr.selectReviewCommentForEstablishmentYear(establishmentReview);  
    		Thread.sleep(2000);
    		da_tpr.clickOn_Fourth_PreviewAttachedProofDocument();
    		da_tpr.selectReviewCommentForProvisionalCertificate(provisionalReview);
    	}
    	
    	else if(establishment_Year.equals("2017") && (type_Organization.equals("Firm") || type_Organization.equals("Society") || type_Organization.equals("Trust") || type_Organization.equals("Limited Liability Partnership (LLP)")))
        {
    		Thread.sleep(2000);
        	da_tpr.clickOn_First_PreviewAttachedProofDocument();
        	da_tpr.selectReviewCommentForPAN(panReview);
        	Thread.sleep(2000);
        	//da_tpr.clickOn_Second_PreviewAttachedProofDocument();
        	//da_tpr.selectReviewCommentsForGST(gstReview);
        	//Thread.sleep(2000);
        	da_tpr.clickOn_Second_PreviewAttachedProofDocument();
        	da_tpr.selectReviewCommentForEstablishmentYear(establishmentReview);  
         	Thread.sleep(2000);
       	    da_tpr.clickOn_Third_PreviewAttachedProofDocument();
        	da_tpr.selectReviewCommentForFirstFinancialYear(firstFinancialYearReview);
        	Thread.sleep(2000);

        }
    	
    	else if(establishment_Year.equals("2017") && (type_Organization.equals("Company")))
    	{
    		Thread.sleep(2000);
        	da_tpr.clickOn_First_PreviewAttachedProofDocument();
        	da_tpr.selectReviewCommentForPAN(panReview);
        	Thread.sleep(2000);
        	da_tpr.clickOn_Second_PreviewAttachedProofDocument();
        	da_tpr.selectReviewCommentsForGST(gstReview);
        	Thread.sleep(2000);
        	da_tpr.clickOn_Third_PreviewAttachedProofDocument();
        	da_tpr.selectReviewCommentForEstablishmentYear(establishmentReview);  
         	Thread.sleep(2000);
       	    da_tpr.clickOn_Fourth_PreviewAttachedProofDocument();
        	da_tpr.selectReviewCommentForFirstFinancialYear(firstFinancialYearReview);
        	Thread.sleep(2000);
    	}
    	
        else if(establishment_Year.equals("2016") && (type_Organization.equals("Firm") || type_Organization.equals("Society") || type_Organization.equals("Trust") || type_Organization.equals("Limited Liability Partnership (LLP)")))
        {
        	Thread.sleep(2000);
        	da_tpr.clickOn_First_PreviewAttachedProofDocument();
        	da_tpr.selectReviewCommentForPAN(panReview);
        	Thread.sleep(2000);
        	//da_tpr.clickOn_Second_PreviewAttachedProofDocument();
        	//da_tpr.selectReviewCommentsForGST(gstReview);
        	//Thread.sleep(2000);
        	da_tpr.clickOn_Second_PreviewAttachedProofDocument();
        	da_tpr.selectReviewCommentForEstablishmentYear(establishmentReview);  
        	Thread.sleep(2000);
       	    da_tpr.clickOn_Third_PreviewAttachedProofDocument();
        	da_tpr.selectReviewCommentForFirstFinancialYear(firstFinancialYearReview);
        	Thread.sleep(2000);
        	da_tpr.clickOn_Fourth_PreviewAttachedProofDocument();
        	da_tpr.selectReviewCommentForSecondFinancialYear(secondFinancialYearReview);
        	Thread.sleep(2000);
        }
    	
        else if(establishment_Year.equals("2016") && (type_Organization.equals("Company")))
        {
        	Thread.sleep(2000);
        	da_tpr.clickOn_First_PreviewAttachedProofDocument();
        	da_tpr.selectReviewCommentForPAN(panReview);
        	Thread.sleep(2000);
        	da_tpr.clickOn_Second_PreviewAttachedProofDocument();
        	da_tpr.selectReviewCommentsForGST(gstReview);
        	Thread.sleep(2000);
        	da_tpr.clickOn_Third_PreviewAttachedProofDocument();
        	da_tpr.selectReviewCommentForEstablishmentYear(establishmentReview);  
        	Thread.sleep(2000);
       	    da_tpr.clickOn_Fourth_PreviewAttachedProofDocument();
        	da_tpr.selectReviewCommentForFirstFinancialYear(firstFinancialYearReview);
        	Thread.sleep(2000);
        	da_tpr.clickOn_Fifth_PreviewAttachedProofDocument();
        	da_tpr.selectReviewCommentForSecondFinancialYear(secondFinancialYearReview);
        	Thread.sleep(2000);
        }
    	
        else if((yearOfEstablishment < 2016) && (type_Organization.equals("Firm") || type_Organization.equals("Society") || type_Organization.equals("Trust") || type_Organization.equals("Limited Liability Partnership (LLP)")))
        {
        	Thread.sleep(2000);
        	da_tpr.clickOn_First_PreviewAttachedProofDocument();
        	da_tpr.selectReviewCommentForPAN(panReview);
        	Thread.sleep(2000);
        	//da_tpr.clickOn_Second_PreviewAttachedProofDocument();
        	//da_tpr.selectReviewCommentsForGST(gstReview);
        	//Thread.sleep(2000);
        	da_tpr.clickOn_Second_PreviewAttachedProofDocument();
        	da_tpr.selectReviewCommentForEstablishmentYear(establishmentReview);  
        	Thread.sleep(2000);
       	    da_tpr.clickOn_Third_PreviewAttachedProofDocument();
        	da_tpr.selectReviewCommentForFirstFinancialYear(firstFinancialYearReview);
        	Thread.sleep(2000);
        	da_tpr.clickOn_Fourth_PreviewAttachedProofDocument();
        	da_tpr.selectReviewCommentForSecondFinancialYear(secondFinancialYearReview);
        	Thread.sleep(2000);
        	da_tpr.clickOn_Fifth_PreviewAttachedProofDocument();
        	da_tpr.selectReviewCommentForThirdFinancialYear(thirdFinancialYearReview);
        	Thread.sleep(2000);
        }
    	
        else if((yearOfEstablishment < 2016) && (type_Organization.equals("Company")))
        {
        	Thread.sleep(2000);
        	da_tpr.clickOn_First_PreviewAttachedProofDocument();
        	da_tpr.selectReviewCommentForPAN(panReview);
        	Thread.sleep(2000);
        	da_tpr.clickOn_Second_PreviewAttachedProofDocument();
        	da_tpr.selectReviewCommentsForGST(gstReview);
        	Thread.sleep(2000);
        	da_tpr.clickOn_Third_PreviewAttachedProofDocument();
        	da_tpr.selectReviewCommentForEstablishmentYear(establishmentReview);  
        	Thread.sleep(2000);
       	    da_tpr.clickOn_Fourth_PreviewAttachedProofDocument();
        	da_tpr.selectReviewCommentForFirstFinancialYear(firstFinancialYearReview);
        	Thread.sleep(2000);
        	da_tpr.clickOn_Fifth_PreviewAttachedProofDocument();
        	da_tpr.selectReviewCommentForSecondFinancialYear(secondFinancialYearReview);
        	Thread.sleep(2000);
        	da_tpr.clickOn_Sixth_PreviewAttachedProofDocument();
        	da_tpr.selectReviewCommentForThirdFinancialYear(thirdFinancialYearReview);
        	Thread.sleep(2000);
        }
    	
        else if(establishment_Year.equals("2018") && type_Organization.equals("Proprietorship"))
        {
        	//da_tpr.selectReviewCommentForAadharNumber(adharReview);
        	Thread.sleep(2000);
        	da_tpr.clickOn_First_PreviewAttachedProofDocument();
        	da_tpr.selectReviewCommentForPAN(panReview);
        	Thread.sleep(2000);
        	da_tpr.clickOn_Second_PreviewAttachedProofDocument();
        	da_tpr.selectReviewCommentForEstablishmentYear(establishmentReview);
        	Thread.sleep(2000);
        	da_tpr.clickOn_Third_PreviewAttachedProofDocument();
        	da_tpr.selectReviewCommentForProvisionalCertificate(provisionalReview);
        	
        }
    	
        else if(establishment_Year.equals("2017") && type_Organization.equals("Proprietorship"))
        {
        	//da_tpr.selectReviewCommentForAadharNumber(adharReview);
        	Thread.sleep(2000);
        	da_tpr.clickOn_First_PreviewAttachedProofDocument();
        	da_tpr.selectReviewCommentForPAN(panReview);
        	Thread.sleep(2000);
        	da_tpr.clickOn_Second_PreviewAttachedProofDocument();
        	da_tpr.selectReviewCommentForEstablishmentYear(establishmentReview);
        	Thread.sleep(2000);
       	    da_tpr.clickOn_Third_PreviewAttachedProofDocument();
        	da_tpr.selectReviewCommentForFirstFinancialYear(firstFinancialYearReview);
        	Thread.sleep(2000);

        }
    	
        else if(establishment_Year.equals("2016") && type_Organization.equals("Proprietorship"))
        {
        	//da_tpr.selectReviewCommentForAadharNumber(adharReview);
        	Thread.sleep(2000);
        	da_tpr.clickOn_First_PreviewAttachedProofDocument();
        	Thread.sleep(2000);
        	da_tpr.selectReviewCommentForPAN(panReview);
        	Thread.sleep(2000);
        	da_tpr.clickOn_Second_PreviewAttachedProofDocument();
        	da_tpr.selectReviewCommentForEstablishmentYear(establishmentReview);
        	Thread.sleep(2000);
       	    da_tpr.clickOn_Third_PreviewAttachedProofDocument();
        	da_tpr.selectReviewCommentForFirstFinancialYear(firstFinancialYearReview);
        	Thread.sleep(2000);
        	da_tpr.clickOn_Fourth_PreviewAttachedProofDocument();
        	da_tpr.selectReviewCommentForSecondFinancialYear(secondFinancialYearReview);
        	Thread.sleep(2000);
        }
    	
        else if((yearOfEstablishment < 2016) && type_Organization.equals("Proprietorship"))
        {
        	//da_tpr.selectReviewCommentForAadharNumber(adharReview);
        	Thread.sleep(2000);
        	da_tpr.clickOn_First_PreviewAttachedProofDocument();
        	Thread.sleep(3000);
        	da_tpr.selectReviewCommentForPAN(panReview);
        	Thread.sleep(2000);
        	da_tpr.clickOn_Second_PreviewAttachedProofDocument();
        	da_tpr.selectReviewCommentForEstablishmentYear(establishmentReview);
        	Thread.sleep(2000);
       	    da_tpr.clickOn_Third_PreviewAttachedProofDocument();
        	da_tpr.selectReviewCommentForFirstFinancialYear(firstFinancialYearReview);
        	Thread.sleep(2000);
        	da_tpr.clickOn_Fourth_PreviewAttachedProofDocument();
        	da_tpr.selectReviewCommentForSecondFinancialYear(secondFinancialYearReview);
        	Thread.sleep(2000);
        	da_tpr.clickOn_Fifth_PreviewAttachedProofDocument();
        	da_tpr.selectReviewCommentForThirdFinancialYear(thirdFinancialYearReview);
        	Thread.sleep(2000);
        }
    	
        else if(type_Organization.equals("Government Institute"))
        {
        	Thread.sleep(2000);
        	//da_tpr.clickOn_First_PreviewAttachedProofDocument();
        	//da_tpr.selectReviewCommentForEstablishmentYear(establishmentReview);
        }


    	Thread.sleep(2000);
    	da_tpr.clickForSaveAndContinue();
    	Thread.sleep(3000);
    	da_tpr.clickForFinalStatusBrowseFile();
    	Thread.sleep(5000);
    	UploadFile.upload(finalStatusFile);
    	Thread.sleep(3000);
    	da_tpr.clickForFinalStatusUploadFile();
    	Thread.sleep(8000);
    	da_tpr.clickForSaveAndContinue();
    	Thread.sleep(2000);
    	da_tpr.clickForOK();
    	Thread.sleep(2000);
     	plp.clickOnProfileLogo();
    	plp.clickOnLogout();
    	Thread.sleep(2000);
    	
    	
    	lp.clickLogin();
    	elp.performlogin(tpID, tpPassword);
    	Assert.assertEquals(driver.findElement(By.xpath("//p[contains(text(),'Add a Training Centre')]")).getText(), "Add a Training Centre");
    }
    
  //TP Rejection Flow
    @DataProvider
    public Object[][] tpRejectionProfileData()
    {
        return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/TrainingPartner-Workflow.xls", "RejectionTP_Creation");
    }
    
    @Test(dataProvider="tpRejectionProfileData")
    public void rejectionTPCreationTC_03(String serialNum, String tpID, String userType, String spocName, String email, String mobile, String emailOTP, String mobileOTP, String oldPassword, String newPassword, String confirmPassword, String name_Of_Organization, String type_Of_The_Organization, String year_Of_Establishment, String uploadFilePath, String landLine, String website, String name_Of_Ceo, String email_Of_Ceo, String mobile_Number_Of_Ceo, String authorized_Signatory_Name1, String authorized_Signatory_Email1, String authorized_Signatory_Mobile1, String authorized_Signatory_Name2, String authorized_Signatory_Email2, String authorized_Signatory_Mobile2, String addresss_Of_Organization, String near_By_Landmark, String pin_Code, String state, String district, String tehsil, String city, String geo_Location, String parliamentary_constituency, String address_proof, String uploadFile, String pan_Number, String upload_PAN, String gst_Number, String upload_GST, String turnover1, String upload_turnover1, String turnover2, String upload_turnover2, String turnover3, String upload_turnover3, String aadhar_Number, String upload_provisional) throws Exception
    {
        //DatabaseConnection.deleteTrainingPartner(email);
        String year_Establishment = year_Of_Establishment;
        int year = Integer.parseInt(year_Establishment);
        Thread.sleep(2000);
        LoginPage lp = new LoginPage(driver);
        lp.clickRegister();
        RegistrationPage rp = new RegistrationPage(driver);
        rp.selectDropdownList(userType);
        rp.enterSPOCName(spocName);
        rp.enterEmail(email);
        rp.enterMobile(mobile);
        rp.clickIagree();
        Thread.sleep(2000);
        rp.clickRegister();
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElements(By.xpath("//div[@id='toast-container']/div/div")).size()==0,"!!!Duplicate Mobile/Email OR Something Wrong!!! ");
        rp.enterEmailOTP(emailOTP);
        rp.enterMobileOTP(mobileOTP);
        Thread.sleep(2000);
        rp.clickVerify();
        Thread.sleep(4000);
        //getting registered TP ID and writing it into TP_Rejection_TestCase_Excel
        String createdRejectionTPID=driver.findElement(By.xpath("//h3[contains(text(),'Your Username is:')]/span")).getText();
        ReadWriteData.setExcelData("./TestData/Workflow/TrainingPartner-Workflow.xls", "RejectionTP_Creation", Integer.parseInt(serialNum), 1, createdRejectionTPID);
        ReadWriteData.setExcelData("./TestData/Workflow/TrainingPartner-Workflow.xls", "TP_Rejection", Integer.parseInt(serialNum), 1, createdRejectionTPID);
        Thread.sleep(4000);
        rp.clickGoToLogin();
        EnterLoginPage elp = new EnterLoginPage(driver);
        elp.performlogin(createdRejectionTPID, "ekaushal");
        Thread.sleep(2000);
        rp.enterOldPassword(oldPassword);
        rp.enterNewPassword(newPassword);
        rp.enterConfirmPassword(confirmPassword);
        rp.clickResetResubmit();
        Thread.sleep(2000);
        rp.clickConfirmationOkMessage();
        elp.performlogin(createdRejectionTPID, confirmPassword);
        Thread.sleep(4000);
        TrainingPartnerRegistrationPage tprp = new TrainingPartnerRegistrationPage(driver);
        //Training Partner Details Section
        tprp.enterNameOfOrganizationTextBox(name_Of_Organization);
        Thread.sleep(2000);
        tprp.selectTypeOfTheOrganization(type_Of_The_Organization);
        Thread.sleep(2000);
        if(!type_Of_The_Organization.equals("Government Institute"))
        {
        	tprp.selectYearOfEstablishment(year_Of_Establishment);
            Thread.sleep(2000);
            tprp.clickBrowseFile();
            Thread.sleep(4000);
            UploadFile.upload(uploadFilePath);
            Thread.sleep(5000);
            tprp.clickUploadFile();
            Thread.sleep(5000);
        }
        tprp.enterLandline(landLine);
        Thread.sleep(2000);
        tprp.enterWebsite(website);
        Thread.sleep(2000);
        tprp.enterNameOfCeo(name_Of_Ceo);
        Thread.sleep(2000);
        tprp.enterEmailOfCeo(email_Of_Ceo);
        Thread.sleep(2000);
        tprp.enterMobileNumberOfCeo(mobile_Number_Of_Ceo);
        Thread.sleep(2000);
        tprp.clickAuthorizedSignatoryCheckBox();
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElements(By.xpath("//tr[td[b[contains(text(),'"+email_Of_Ceo+"')]]]")).size()==1,"OMG!!! Added CEO Details as Authorized signatory Record not present OR Something went wrong!");
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[b[contains(text(),'"+email_Of_Ceo+"')]]]/td[2]")).getText().trim(), name_Of_Ceo);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[b[contains(text(),'"+email_Of_Ceo+"')]]]/td[3]")).getText().trim(), email_Of_Ceo);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[b[contains(text(),'"+email_Of_Ceo+"')]]]/td[4]")).getText().trim(), mobile_Number_Of_Ceo);
        tprp.enterAuthorizedSignatoryName(authorized_Signatory_Name1);
        Thread.sleep(2000);
        tprp.enterAuthorizedSignatoryEmail(authorized_Signatory_Email1);
        Thread.sleep(2000);
        tprp.enterAuthorizedSignatoryMobile(authorized_Signatory_Mobile1);
        Thread.sleep(2000);
        tprp.clickAddAnotherSignatoryDetails();
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElements(By.xpath("//tr[td[b[contains(text(),'"+authorized_Signatory_Email1+"')]]]")).size()==1,"OMG!!! Added CEO Details as Authorized signatory Record not present OR Something went wrong!");
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[b[contains(text(),'"+authorized_Signatory_Email1+"')]]]/td[2]")).getText().trim(), authorized_Signatory_Name1);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[b[contains(text(),'"+authorized_Signatory_Email1+"')]]]/td[3]")).getText().trim(), authorized_Signatory_Email1);
        Assert.assertEquals(driver.findElement(By.xpath("//tr[td[b[contains(text(),'"+authorized_Signatory_Email1+"')]]]/td[4]")).getText().trim(), authorized_Signatory_Mobile1);
        tprp.enterAuthorizedSignatoryName(authorized_Signatory_Name2);
        Thread.sleep(2000);
        tprp.enterAuthorizedSignatoryEmail(authorized_Signatory_Email2);
        Thread.sleep(2000);
        tprp.enterAuthorizedSignatoryMobile(authorized_Signatory_Mobile2);
        Thread.sleep(2000);
        tprp.clickSaveAndNextButton();
        //Address Section
        Thread.sleep(2000);
        tprp.enterAddressOfOrganizationTextBox(addresss_Of_Organization);
        Thread.sleep(2000);
        tprp.enterNearByLandmark(near_By_Landmark);
        Thread.sleep(2000);
        tprp.enterPinCode(pin_Code);
        Thread.sleep(2000);
        tprp.selectState(state);
        Thread.sleep(2000);
        tprp.selectDistrict(district);
        Thread.sleep(2000);
        tprp.selectTehsil(tehsil);
        Thread.sleep(2000);
        tprp.selectCity(city);
        Thread.sleep(2000);
        tprp.enterGeoLocation(geo_Location);
        Thread.sleep(2000);
        tprp.selectParliamentaryConstituency(parliamentary_constituency);
        Thread.sleep(2000);
        tprp.selectAddressProof(address_proof);
        Thread.sleep(2000);
        tprp.clickBrowseFile();
        Thread.sleep(4000);
        UploadFile.upload(uploadFile);
        Thread.sleep(5000);
        tprp.clickUploadFile();
        Thread.sleep(5000);
        tprp.clickOnCommunicationAddressSameAsPermanentAddress();
        Thread.sleep(2000);
        //Verifying Communication Address
        Assert.assertEquals(driver.findElement(By.xpath("(//textarea[@id='m_autosize_1'])[2]")).getAttribute("value").trim(), addresss_Of_Organization);
        Assert.assertEquals(driver.findElement(By.xpath("(//input[@ng-reflect-name='landmark'])[2]")).getAttribute("value").trim(), near_By_Landmark);
        Assert.assertEquals(driver.findElement(By.xpath("(//input[@name='pincode'])[2]")).getAttribute("value").trim(), pin_Code);
        Select selectedState=new Select(driver.findElement(By.xpath("(//select[@name='state'])[2]")));        
        Assert.assertEquals(selectedState.getFirstSelectedOption().getText().trim(), state);
        Select selectedDistrict=new Select(driver.findElement(By.xpath("(//select[@name='dist'])[2]")));
        Assert.assertEquals(selectedDistrict.getFirstSelectedOption().getText().trim(), district);
        Select selectedTehsil=new Select(driver.findElement(By.xpath("(//select[@name='tehsil'])[2]")));
        Assert.assertEquals(selectedTehsil.getFirstSelectedOption().getText().trim(), tehsil);
        Select selectedVillage=new Select(driver.findElement(By.xpath("(//select[@name='villlage'])[2]")));
        Assert.assertEquals(selectedVillage.getFirstSelectedOption().getText().trim(), city);
        Select selectedParlimentary=new Select(driver.findElement(By.xpath("(//select[@ng-reflect-name='parliamentaryConstituency'])[2]")));
        Assert.assertEquals(selectedParlimentary.getFirstSelectedOption().getText().trim(), parliamentary_constituency);
        Select selectedAddressProof=new Select(driver.findElement(By.xpath("(//select[@ng-reflect-name='addressProof'])[2]")));
        Assert.assertEquals(selectedAddressProof.getFirstSelectedOption().getText().trim(), address_proof);
        //The Below address proof File Upload should not come as "Permanent and Communication addressess are same
        Thread.sleep(4000);
        tprp.clickOn_Second_BrowseFile();
        Thread.sleep(4000);
        UploadFile.upload(uploadFile);
        Thread.sleep(5000);
        tprp.clickOn_Second_UploadFile();
        Thread.sleep(5000);
        tprp.clickSaveAndNextButton();
        Thread.sleep(4000);
        if(year_Of_Establishment.equals("2018") && (type_Of_The_Organization.equals("Company") || type_Of_The_Organization.equals("Firm") || type_Of_The_Organization.equals("Society") || type_Of_The_Organization.equals("Trust") || type_Of_The_Organization.equals("Limited Liability Partnership (LLP)")))
        {
        	tprp.enterPANNumber(pan_Number);
            Thread.sleep(2000);
            tprp.clickBrowseButton1();
            Thread.sleep(2000);
            UploadFile.upload(upload_PAN);
            Thread.sleep(2000);
            tprp.clickUploadButton1();
            Thread.sleep(3000);
            tprp.clickBrowseButton2();
            Thread.sleep(2000);
            UploadFile.upload(upload_provisional);
            Thread.sleep(2000);
            tprp.clickUploadButton2();
            Thread.sleep(3000);
         	tprp.clickSaveAndNextButton();
            Thread.sleep(2000);
            tprp.clickIAgreeCheckBox();
            Thread.sleep(2000);
            tprp.clickSaveAndContinueToPaymentButton();
            Thread.sleep(2000);
            tprp.clickPaymentOkButton();
            Thread.sleep(2000);
        }
        else if(year_Of_Establishment.equals("2018") && type_Of_The_Organization.equals("Proprietorship"))
        {
        	tprp.enterPANNumber(pan_Number);
          	Thread.sleep(2000);
          	tprp.clickBrowseButton1();
          	Thread.sleep(2000);
          	UploadFile.upload(upload_PAN);
          	Thread.sleep(2000);
          	tprp.clickUploadButton1();
          	Thread.sleep(3000);
        	tprp.clickBrowseButton2();
            Thread.sleep(2000);
            UploadFile.upload(upload_provisional);
            Thread.sleep(2000);
            tprp.clickUploadButton2();
            Thread.sleep(3000);
            tprp.clickSaveAndNextButton();
            Thread.sleep(2000);
            tprp.clickIAgreeCheckBox();
            Thread.sleep(2000);
            tprp.clickSaveAndContinueToPaymentButton();
            Thread.sleep(2000);
            tprp.clickPaymentOkButton();
            Thread.sleep(2000);
        }
        else if(year_Of_Establishment.equals("2017") && (type_Of_The_Organization.equals("Company") || type_Of_The_Organization.equals("Firm") || type_Of_The_Organization.equals("Society") || type_Of_The_Organization.equals("Trust") || type_Of_The_Organization.equals("Limited Liability Partnership (LLP)")))
        {
            tprp.enterPANNumber(pan_Number);
            Thread.sleep(2000);
            tprp.clickBrowseButton1();
            Thread.sleep(2000);
            UploadFile.upload(upload_PAN);
            Thread.sleep(2000);
            tprp.clickUploadButton1();
            Thread.sleep(3000);
            tprp.enterAnnualTurnOver1(turnover1);
            Thread.sleep(2000);
            tprp.clickBrowseButton2();
            Thread.sleep(2000);
            UploadFile.upload(upload_turnover1);
            Thread.sleep(2000);
            tprp.clickUploadButton2();
            Thread.sleep(3000);
            tprp.clickSaveAndNextButton();
            Thread.sleep(2000);
            tprp.clickIAgreeCheckBox();
            Thread.sleep(2000);
            tprp.clickSaveAndContinueToPaymentButton();
            Thread.sleep(2000);
            tprp.clickPaymentOkButton();
            Thread.sleep(2000);
        }
        else if(year_Of_Establishment.equals("2017") && type_Of_The_Organization.equals("Proprietorship"))
        {
           	tprp.enterPANNumber(pan_Number);
            Thread.sleep(2000);
            tprp.clickBrowseButton1();
            Thread.sleep(2000);
            UploadFile.upload(upload_PAN);
            Thread.sleep(2000);
            tprp.clickUploadButton1();
            Thread.sleep(3000);
            tprp.enterAnnualTurnOver1(turnover1);
            Thread.sleep(2000);
            tprp.clickBrowseButton2();
            Thread.sleep(2000);
            UploadFile.upload(upload_turnover1);
            Thread.sleep(2000);
            tprp.clickUploadButton2();
            Thread.sleep(3000);
            tprp.clickSaveAndNextButton();
            Thread.sleep(2000);
            tprp.clickIAgreeCheckBox();
            Thread.sleep(2000);
            tprp.clickSaveAndContinueToPaymentButton();
            Thread.sleep(2000);
            tprp.clickPaymentOkButton();
            Thread.sleep(2000);
        }
        else if(year_Of_Establishment.equals("2016") && (type_Of_The_Organization.equals("Company") || type_Of_The_Organization.equals("Firm") || type_Of_The_Organization.equals("Society") || type_Of_The_Organization.equals("Trust") || type_Of_The_Organization.equals("Limited Liability Partnership (LLP)")))
        {
            tprp.enterPANNumber(pan_Number);
            Thread.sleep(2000);
            tprp.clickBrowseButton1();
            Thread.sleep(2000);
            UploadFile.upload(upload_PAN);
            Thread.sleep(2000);
            tprp.clickUploadButton1();
            Thread.sleep(3000);
            tprp.clickUploadButton2();
            Thread.sleep(3000);
            tprp.enterAnnualTurnOver1(turnover1);
            Thread.sleep(2000);
            tprp.clickBrowseButton2();
            Thread.sleep(2000);
            UploadFile.upload(upload_turnover1);
            Thread.sleep(2000);
            tprp.clickUploadButton2();
            Thread.sleep(3000);
            tprp.enterAnnualTurnOver2(turnover2);
            Thread.sleep(2000);
            tprp.clickBrowseButton3();
            Thread.sleep(2000);
            UploadFile.upload(upload_turnover2);
            Thread.sleep(2000);
            tprp.clickUploadButton3();
            Thread.sleep(3000);
            tprp.clickSaveAndNextButton();
            Thread.sleep(2000);
            tprp.clickIAgreeCheckBox();
            Thread.sleep(2000);
            tprp.clickSaveAndContinueToPaymentButton();
            Thread.sleep(2000);
            tprp.clickPaymentOkButton();
            Thread.sleep(2000);
        }
        else if(year_Of_Establishment.equals("2016") && type_Of_The_Organization.equals("Proprietorship"))
        {
        	tprp.enterPANNumber(pan_Number);
            Thread.sleep(2000);
            tprp.clickBrowseButton1();
            Thread.sleep(2000);
            UploadFile.upload(upload_PAN);
            Thread.sleep(2000);
            tprp.clickUploadButton1();
            Thread.sleep(3000);
            tprp.enterAnnualTurnOver1(turnover1);
            Thread.sleep(2000);
            tprp.clickBrowseButton2();
            Thread.sleep(2000);
            UploadFile.upload(upload_turnover1);
            Thread.sleep(2000);
            tprp.clickUploadButton2();
            Thread.sleep(3000);
            tprp.enterAnnualTurnOver2(turnover2);
            Thread.sleep(2000);
            tprp.clickBrowseButton3();
            Thread.sleep(2000);
            UploadFile.upload(upload_turnover2);
            Thread.sleep(2000);
            tprp.clickUploadButton3();
            Thread.sleep(3000);
            tprp.clickSaveAndNextButton();
            Thread.sleep(2000);
            tprp.clickIAgreeCheckBox();
            Thread.sleep(2000);
            tprp.clickSaveAndContinueToPaymentButton();
            Thread.sleep(2000);
            tprp.clickPaymentOkButton();
            Thread.sleep(2000);
        }
        else if((year < 2016) && (type_Of_The_Organization.equals("Company") || type_Of_The_Organization.equals("Firm") || type_Of_The_Organization.equals("Society") || type_Of_The_Organization.equals("Trust") || type_Of_The_Organization.equals("Limited Liability Partnership (LLP)")))
        {
            tprp.enterPANNumber(pan_Number);
            Thread.sleep(2000);
            tprp.clickBrowseButton1();
            Thread.sleep(2000);
            UploadFile.upload(upload_PAN);
            Thread.sleep(2000);
            tprp.clickUploadButton1();
            Thread.sleep(3000);
            tprp.enterAnnualTurnOver1(turnover1);
            Thread.sleep(2000);
            tprp.clickBrowseButton2();
            Thread.sleep(2000);
            UploadFile.upload(upload_turnover1);
            Thread.sleep(2000);
            tprp.clickUploadButton2();
            Thread.sleep(3000);
            tprp.enterAnnualTurnOver2(turnover2);
            Thread.sleep(2000);
            tprp.clickBrowseButton3();
            Thread.sleep(2000);
            UploadFile.upload(upload_turnover2);
            Thread.sleep(2000);
            tprp.clickUploadButton3();
            Thread.sleep(3000);
            tprp.enterAnnualTurnOver3(turnover3);
            Thread.sleep(2000);
            tprp.clickBrowseButton4();
            Thread.sleep(2000);
            UploadFile.upload(upload_turnover3);
            Thread.sleep(2000);
            tprp.clickUploadButton4();
            Thread.sleep(3000);
            tprp.clickSaveAndNextButton();
            Thread.sleep(2000);
            tprp.clickIAgreeCheckBox();
            Thread.sleep(2000);
            tprp.clickSaveAndContinueToPaymentButton();
            Thread.sleep(2000);
            tprp.clickPaymentOkButton();
            Thread.sleep(2000);
        }
        else if((year < 2016) && type_Of_The_Organization.equals("Proprietorship"))
        {
           	tprp.enterPANNumber(pan_Number);
            Thread.sleep(2000);
            tprp.clickBrowseButton1();
            Thread.sleep(2000);
            UploadFile.upload(upload_PAN);
            Thread.sleep(2000);
            tprp.clickUploadButton1();
            Thread.sleep(3000);
            tprp.enterAnnualTurnOver1(turnover1);
            Thread.sleep(2000);
            tprp.clickBrowseButton2();
            Thread.sleep(2000);
            UploadFile.upload(upload_turnover1);
            Thread.sleep(2000);
            tprp.clickUploadButton2();
            Thread.sleep(3000);
            tprp.enterAnnualTurnOver2(turnover2);
            Thread.sleep(2000);
            tprp.clickBrowseButton3();
            Thread.sleep(2000);
            UploadFile.upload(upload_turnover2);
            Thread.sleep(2000);
            tprp.clickUploadButton3();
            Thread.sleep(3000);
            tprp.enterAnnualTurnOver3(turnover3);
            Thread.sleep(2000);
            tprp.clickBrowseButton4();
            Thread.sleep(2000);
            UploadFile.upload(upload_turnover3);
            Thread.sleep(2000);
            tprp.clickUploadButton4();
            Thread.sleep(3000);
            tprp.clickSaveAndNextButton();
            Thread.sleep(2000);
            tprp.clickIAgreeCheckBox();
            Thread.sleep(2000);
            tprp.clickSaveAndContinueToPaymentButton();
            Thread.sleep(2000);
            tprp.clickPaymentOkButton();
            Thread.sleep(2000);
        }
        else if(type_Of_The_Organization.equals("Government Institute"))
        {
            Thread.sleep(2000);
            tprp.clickIAgreeCheckBox();
            Thread.sleep(2000);
            tprp.clickSaveAndContinueButton();
            Thread.sleep(2000);
        }
        tprp.clickDownloadButton();
        Thread.sleep(4000);
        tprp.clickLogOutButton();
        Thread.sleep(4000);
   }
}