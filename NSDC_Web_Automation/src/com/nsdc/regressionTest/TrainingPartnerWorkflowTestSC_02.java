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
        Thread.sleep(3000);
        rp.clickConfirmationOkMessage();
        
        elp.performlogin(username, confirmPassword);
        Thread.sleep(4000);
        
        TrainingPartnerRegistrationPage tprp = new TrainingPartnerRegistrationPage(driver);
        tprp.enterNameOfOrganizationTextBox(name_Of_Organization);
        tprp.selectTypeOfTheOrganization(type_Of_The_Organization);
        if(type_Of_The_Organization.equals("Government Institute"))
        {
        	Thread.sleep(2000);
            tprp.clickBrowseFile();
            Thread.sleep(2000);
            UploadFile.upload(uploadFilePath);
            Thread.sleep(2000);
            tprp.clickUploadFile();
            Thread.sleep(5000);
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
        
        Thread.sleep(3000);
        Assert.assertEquals(driver.findElement(By.xpath("//textarea[@formcontrolname='address1']")).getAttribute("value"), addresss_Of_Organization);
        Assert.assertEquals(driver.findElement(By.xpath("(//input[@formcontrolname='landmark'])[2]")).getAttribute("value"), near_By_Landmark);
        Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='pinCode']")).getAttribute("value"), pin_Code);
        Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='state'])[2]")).getAttribute("value").substring(3).replace(" ", ""), state.replace(" ", ""));
        Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='district'])[2]")).getAttribute("value").substring(3).replace(" ", ""), district.replace(" ", ""));
        Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='subDistrict'])[2]")).getAttribute("value").substring(3).replace(" ", ""), tehsil.replace(" ", ""));
        Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='village'])[2]")).getAttribute("value").substring(3).replace(" ", ""), city.replace(" ", ""));
        Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='parliamentaryConstituency'])[2]")).getAttribute("value").substring(3).replace(" ", ""), parliamentary_constituency.replace(" ", ""));
        Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='addressProof'])[2]")).getAttribute("value"), address_proof);
       
        Thread.sleep(4000);
        tprp.clickOn_Second_BrowseFile();
        Thread.sleep(3000);
        UploadFile.upload(uploadFile);
        Thread.sleep(3000);
        tprp.clickOn_Second_UploadFile();
        
        Thread.sleep(4000);
        tprp.clickSaveAndNextButton();
        
        if(((year_Of_Establishment.equals("2019")) ||(year_Of_Establishment.equals("2018"))) && (type_Of_The_Organization.equals("Firm") || type_Of_The_Organization.equals("Society") || type_Of_The_Organization.equals("Trust") || type_Of_The_Organization.equals("Limited Liability Partnership (LLP)")))
        {
        	Thread.sleep(3000);
            tprp.enterPANNumber(pan_Number);
            Thread.sleep(3000);
            tprp.clickOnPANVerify();
            Thread.sleep(3000);
            tprp.clickOnOkButton();
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
//            Thread.sleep(3000);
//            tprp.clickBrowseButton2();
//            Thread.sleep(3000);
//            
//            UploadFile.upload(upload_provisional);
//            Thread.sleep(3000);
//            tprp.clickUploadButton2();
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
        
        else if(((year_Of_Establishment.equals("2019")) || (year_Of_Establishment.equals("2018"))) && (type_Of_The_Organization.equals("Company")))
        {
        	Thread.sleep(3000);
            tprp.enterPANNumber(pan_Number);
            Thread.sleep(3000);
            tprp.clickOnPANVerify();
            Thread.sleep(3000);
            tprp.clickOnOkButton();
            Thread.sleep(3000);
            tprp.clickBrowseButton1();
            Thread.sleep(3000);
            UploadFile.upload(upload_PAN);
            Thread.sleep(3000);
            tprp.clickUploadButton1();
            Thread.sleep(3000);
            tprp.enterGSTAccountNumber(gst_Number);
            Thread.sleep(3000);
            tprp.clickOnGST_Verify();
            Thread.sleep(3000);
            tprp.clickOnOkButton();
            Thread.sleep(3000);
            tprp.clickBrowseButton2();
            Thread.sleep(3000);
            UploadFile.upload(upload_GST);
            Thread.sleep(3000);
            tprp.clickUploadButton2();
//            Thread.sleep(3000);
//            tprp.clickBrowseButton3();
//            Thread.sleep(3000);
//            
//            UploadFile.upload(upload_provisional);
//            Thread.sleep(3000);
//            tprp.clickUploadButton3();
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
        
        else if(((year_Of_Establishment.equals("2019") || (year_Of_Establishment.equals("2018"))) && type_Of_The_Organization.equals("Proprietorship")))
        {
        	Thread.sleep(3000);
            //tprp.enterAadharNumber(aadhar_Number);
            //tprp.clickToVerifyAadharNumber();
        	tprp.enterPANNumber(pan_Number);
            Thread.sleep(5000);
            tprp.clickOnPANVerify();
            Thread.sleep(3000);
            tprp.clickOnOkButton();
            Thread.sleep(5000);
            tprp.clickBrowseButton1();
            Thread.sleep(4000);
            UploadFile.upload(upload_PAN);
            Thread.sleep(3000);
            tprp.clickUploadButton1();
            
//            Thread.sleep(4000);
//            tprp.clickBrowseButton2();
//            Thread.sleep(3000);
//            UploadFile.upload(upload_provisional);
//            Thread.sleep(3000);
//            tprp.clickUploadButton2();
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
            tprp.clickOnPANVerify();
            Thread.sleep(3000);
            tprp.clickOnOkButton();
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
            tprp.clickOnPANVerify();
            Thread.sleep(3000);
            tprp.clickOnOkButton();
            Thread.sleep(3000);
            tprp.clickBrowseButton1();
            Thread.sleep(3000);
            UploadFile.upload(upload_PAN);
            Thread.sleep(3000);
            tprp.clickUploadButton1();
            Thread.sleep(3000);
            tprp.enterGSTAccountNumber(gst_Number);
            Thread.sleep(3000);
            tprp.clickOnGST_Verify();
            Thread.sleep(3000);
            tprp.clickOnOkButton();
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
            tprp.clickOnPANVerify();
            Thread.sleep(3000);
            tprp.clickOnOkButton();
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
            tprp.clickOnPANVerify();
            Thread.sleep(3000);
            tprp.clickOnOkButton();
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
            tprp.clickOnPANVerify();
            Thread.sleep(3000);
            tprp.clickOnOkButton();
            Thread.sleep(3000);
            tprp.clickBrowseButton1();
            Thread.sleep(3000);
            UploadFile.upload(upload_PAN);
            Thread.sleep(3000);
            tprp.clickUploadButton1();
            Thread.sleep(3000);
            tprp.enterGSTAccountNumber(gst_Number);
            Thread.sleep(3000);
            tprp.clickOnGST_Verify();
            Thread.sleep(3000);
            tprp.clickOnOkButton();
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
            tprp.clickOnPANVerify();
            Thread.sleep(3000);
            tprp.clickOnOkButton();
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
        
        else if((year <= 2015) && (type_Of_The_Organization.equals("Firm") || type_Of_The_Organization.equals("Society") || type_Of_The_Organization.equals("Trust") || type_Of_The_Organization.equals("Limited Liability Partnership (LLP)")))
        {
        	Thread.sleep(3000);
            tprp.enterPANNumber(pan_Number);
            Thread.sleep(3000);
            tprp.clickOnPANVerify();
            Thread.sleep(3000);
            tprp.clickOnOkButton();
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
        
        else if((year <= 2015) && (type_Of_The_Organization.equals("Company")))
        {
        	Thread.sleep(3000);
            tprp.enterPANNumber(pan_Number);
            Thread.sleep(3000);
            tprp.clickOnPANVerify();
            Thread.sleep(3000);
            tprp.clickOnOkButton();
            Thread.sleep(3000);
            tprp.clickBrowseButton1();
            Thread.sleep(3000);
            UploadFile.upload(upload_PAN);
            Thread.sleep(3000);
            tprp.clickUploadButton1();
            Thread.sleep(3000);
            tprp.enterGSTAccountNumber(gst_Number);
            Thread.sleep(3000);
            tprp.clickOnGST_Verify();
            Thread.sleep(3000);
            tprp.clickOnOkButton();
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
        
        else if((year <= 2015) && type_Of_The_Organization.equals("Proprietorship"))
        {
        	Thread.sleep(3000);
            //tprp.enterAadharNumber(aadhar_Number);
            //tprp.clickToVerifyAadharNumber();
        	tprp.enterPANNumber(pan_Number);
        	Thread.sleep(5000);
        	tprp.clickOnPANVerify();
        	Thread.sleep(3000);
            tprp.clickOnOkButton();
        	Thread.sleep(5000);
        	tprp.clickBrowseButton1();
            Thread.sleep(5000);
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
        Thread.sleep(10000);
        tprp.clcikOnGoToDashboard();
        //tprp.clickLogOutButton();
        Thread.sleep(3000);
        Assert.assertEquals(driver.findElement(By.xpath("//p[text()='Action DA Comments']")).getText(), "Action DA Comments");
        
        PostLoginPage plp = new PostLoginPage(driver);
        plp.clickOnProfileLogo();
        plp.clickOnLogout();
        Thread.sleep(3000);
        Assert.assertEquals(driver.findElement(By.xpath("//li[contains(text(),'LOGIN')]")).getText(), "LOGIN");
    }
    
    @DataProvider
    public Object[][] tpApproval()
    {
        return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/TrainingPartner-Workflow.xls", "TPApprovalSC02TC02");
    }
    
    @Test(dataProvider="tpApproval", dependsOnMethods="tpRegistrationsTC_01")
    public void trainingPartnerApprovalTC_02(String srno, String iausername, String password, String tpID, String establishment_Year, String assignTo, String statusForRequest, String dausername, String Password, String nameReview, String typeReview, String addressReview,String adharReview,  String panReview, String gstReview, String establishmentReview, String provisionalReview, String firstFinancialYearReview, String secondFinancialYearReview, String thirdFinancialYearReview, String finalStatusFile, String tpPassword) throws Exception
    {
    	LoginPage lp = new LoginPage(driver);
    	lp.clickLogin();
    	EnterLoginPage elp = new EnterLoginPage(driver);
    	elp.performlogin(iausername, password);
    	Thread.sleep(4000);
    	
    	InspectionAgency_DashboardPage ia = new InspectionAgency_DashboardPage(driver);
    	Thread.sleep(8000);
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
    	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[text()='"+tpID+"']]]//span[text()='DA In Process']")).getText(), "DA In Process");
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
    	Thread.sleep(5000);
    	da_tpr.clickForSaveAndContinue();
    	int yearOfEstablishment = Integer.parseInt(establishment_Year);
    	Thread.sleep(2000);
    	
    	if(((establishment_Year.equals("2019")) || (establishment_Year.equals("2018"))) && (type_Organization.equals("Firm") || type_Organization.equals("Society") || type_Organization.equals("Trust") || type_Organization.equals("Limited Liability Partnership (LLP)")))
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
    	
    	else if(((establishment_Year.equals("2019")) || (establishment_Year.equals("2018"))) && (type_Organization.equals("Company")))
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
    	
        else if((yearOfEstablishment <= 2015) && (type_Organization.equals("Firm") || type_Organization.equals("Society") || type_Organization.equals("Trust") || type_Organization.equals("Limited Liability Partnership (LLP)")))
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
    	
        else if((yearOfEstablishment <= 2015) && (type_Organization.equals("Company")))
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
    	
        else if(((establishment_Year.equals("2019")) || (establishment_Year.equals("2018"))) && type_Organization.equals("Proprietorship"))
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
    	
        else if((yearOfEstablishment <= 2015) && type_Organization.equals("Proprietorship"))
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


    	Thread.sleep(5000);
    	da_tpr.clickForSaveAndContinue();
    	Thread.sleep(3000);
    	da_tpr.clickForFinalStatusBrowseFile();
    	Thread.sleep(5000);
    	UploadFile.upload(finalStatusFile);
    	Thread.sleep(3000);
    	da_tpr.clickForFinalStatusUploadFile();
    	Thread.sleep(8000);
    	da_tpr.clickForSaveAndContinue();
    	Thread.sleep(5000);
    	da_tpr.clickForOK();
    	Thread.sleep(3000);
    	da_tpr.clickOnSecond_OK();
    	Thread.sleep(5000);
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
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
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
            Thread.sleep(6000);
        }
        else
        {
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
        if(year_Of_Establishment.equals("2018") && (type_Of_The_Organization.equals("Proprietorship") || type_Of_The_Organization.equals("Firm") || type_Of_The_Organization.equals("Society") || type_Of_The_Organization.equals("Trust") || type_Of_The_Organization.equals("Limited Liability Partnership (LLP)")))
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
        }
        else if(year_Of_Establishment.equals("2018") && type_Of_The_Organization.equals("Company"))
        {
        	tprp.enterPANNumber(pan_Number);
          	Thread.sleep(2000);
          	tprp.clickBrowseButton1();
          	Thread.sleep(2000);
          	UploadFile.upload(upload_PAN);
          	Thread.sleep(2000);
          	tprp.clickUploadButton1();
          	Thread.sleep(3000);
          	tprp.enterGSTAccountNumber(gst_Number);
          	Thread.sleep(2000);
          	tprp.clickBrowseButton2();
            Thread.sleep(2000);
            UploadFile.upload(upload_GST);
            Thread.sleep(2000);
            tprp.clickUploadButton2();
            Thread.sleep(3000);
          	tprp.clickBrowseButton3();
            Thread.sleep(2000);
            UploadFile.upload(upload_provisional);
            Thread.sleep(2000);
            tprp.clickUploadButton3();
            Thread.sleep(3000);
            tprp.clickSaveAndNextButton();
            Thread.sleep(2000);
            tprp.clickIAgreeCheckBox();
            Thread.sleep(2000);
            tprp.clickSaveAndContinueToPaymentButton();
            Thread.sleep(2000);
        }
        else if(year_Of_Establishment.equals("2017") && (type_Of_The_Organization.equals("Proprietorship") || type_Of_The_Organization.equals("Firm") || type_Of_The_Organization.equals("Society") || type_Of_The_Organization.equals("Trust") || type_Of_The_Organization.equals("Limited Liability Partnership (LLP)")))
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
        }
        else if(year_Of_Establishment.equals("2017") && type_Of_The_Organization.equals("Company"))
        {
           	tprp.enterPANNumber(pan_Number);
            Thread.sleep(2000);
            tprp.clickBrowseButton1();
            Thread.sleep(2000);
            UploadFile.upload(upload_PAN);
            Thread.sleep(2000);
            tprp.clickUploadButton1();
            Thread.sleep(3000);
            tprp.enterGSTAccountNumber(gst_Number);
          	Thread.sleep(2000);
          	tprp.clickBrowseButton2();
            Thread.sleep(2000);
            UploadFile.upload(upload_GST);
            Thread.sleep(2000);
            tprp.clickUploadButton2();
            Thread.sleep(3000);
            tprp.enterAnnualTurnOver1(turnover1);
            Thread.sleep(2000);
            tprp.clickBrowseButton3();
            Thread.sleep(2000);
            UploadFile.upload(upload_turnover1);
            Thread.sleep(2000);
            tprp.clickUploadButton3();
            Thread.sleep(3000);
            tprp.clickSaveAndNextButton();
            Thread.sleep(2000);
            tprp.clickIAgreeCheckBox();
            Thread.sleep(2000);
            tprp.clickSaveAndContinueToPaymentButton();
            Thread.sleep(2000);
        }
        else if(year_Of_Establishment.equals("2016") && (type_Of_The_Organization.equals("Proprietorship") || type_Of_The_Organization.equals("Firm") || type_Of_The_Organization.equals("Society") || type_Of_The_Organization.equals("Trust") || type_Of_The_Organization.equals("Limited Liability Partnership (LLP)")))
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
        }
        else if(year_Of_Establishment.equals("2016") && type_Of_The_Organization.equals("Company"))
        {
        	tprp.enterPANNumber(pan_Number);
            Thread.sleep(2000);
            tprp.clickBrowseButton1();
            Thread.sleep(2000);
            UploadFile.upload(upload_PAN);
            Thread.sleep(2000);
            tprp.clickUploadButton1();
            Thread.sleep(3000);
            tprp.enterGSTAccountNumber(gst_Number);
          	Thread.sleep(2000);
          	tprp.clickBrowseButton2();
            Thread.sleep(2000);
            UploadFile.upload(upload_GST);
            Thread.sleep(2000);
            tprp.clickUploadButton2();
            Thread.sleep(3000);
            tprp.enterAnnualTurnOver1(turnover1);
            Thread.sleep(2000);
            tprp.clickBrowseButton3();
            Thread.sleep(2000);
            UploadFile.upload(upload_turnover1);
            Thread.sleep(2000);
            tprp.clickUploadButton3();
            Thread.sleep(3000);
            tprp.enterAnnualTurnOver2(turnover2);
            Thread.sleep(2000);
            tprp.clickBrowseButton4();
            Thread.sleep(2000);
            UploadFile.upload(upload_turnover2);
            Thread.sleep(2000);
            tprp.clickUploadButton4();
            Thread.sleep(3000);
            tprp.clickSaveAndNextButton();
            Thread.sleep(2000);
            tprp.clickIAgreeCheckBox();
            Thread.sleep(2000);
            tprp.clickSaveAndContinueToPaymentButton();
            Thread.sleep(2000);
        }
        else if((year < 2016) && (type_Of_The_Organization.equals("Proprietorship") || type_Of_The_Organization.equals("Firm") || type_Of_The_Organization.equals("Society") || type_Of_The_Organization.equals("Trust") || type_Of_The_Organization.equals("Limited Liability Partnership (LLP)")))
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
        }
        else if((year < 2016) && type_Of_The_Organization.equals("Company"))
        {
           	tprp.enterPANNumber(pan_Number);
            Thread.sleep(2000);
            tprp.clickBrowseButton1();
            Thread.sleep(2000);
            UploadFile.upload(upload_PAN);
            Thread.sleep(2000);
            tprp.clickUploadButton1();
            Thread.sleep(3000);
            tprp.enterGSTAccountNumber(gst_Number);
          	Thread.sleep(2000);
          	tprp.clickBrowseButton2();
            Thread.sleep(2000);
            UploadFile.upload(upload_GST);
            Thread.sleep(2000);
            tprp.clickUploadButton2();
            Thread.sleep(3000);
            tprp.enterAnnualTurnOver1(turnover1);
            Thread.sleep(2000);
            tprp.clickBrowseButton3();
            Thread.sleep(2000);
            UploadFile.upload(upload_turnover1);
            Thread.sleep(2000);
            tprp.clickUploadButton3();
            Thread.sleep(3000);
            tprp.enterAnnualTurnOver2(turnover2);
            Thread.sleep(2000);
            tprp.clickBrowseButton4();
            Thread.sleep(2000);
            UploadFile.upload(upload_turnover2);
            Thread.sleep(2000);
            tprp.clickUploadButton4();
            Thread.sleep(3000);
            tprp.enterAnnualTurnOver3(turnover3);
            Thread.sleep(2000);
            tprp.clickBrowseButton5();
            Thread.sleep(2000);
            UploadFile.upload(upload_turnover3);
            Thread.sleep(2000);
            tprp.clickUploadButton5();
            Thread.sleep(3000);
            tprp.clickSaveAndNextButton();
            Thread.sleep(2000);
            tprp.clickIAgreeCheckBox();
            Thread.sleep(2000);
            tprp.clickSaveAndContinueToPaymentButton();
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
        Thread.sleep(10000);
     }
    
    @DataProvider
    public Object[][] tpRejectionData()
    {
         return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/TrainingPartner-Workflow.xls", "TP_Rejection");
    }
     
    @Test(dataProvider="tpRejectionData",dependsOnMethods="rejectionTPCreationTC_03")
    public void tpRejectionTC_04(String serialNum, String tpID, String iaUsername, String password, String tpEmail, String tpMobile, String daName, String statusOption, String daUserName, String daPassword, String searchKeywords, String nameOfOrganization, String nameOfOrganizationReviewComments, String nameOfOrganizationComments, String typeOfOrganization, String typeOfOrganizationReviewComments, String typeOfOrganizationComments, String addressOfOrganization, String nearByLandmark, String pincode, String sateOrUnionTerritory, String district, String tehsilMandalBlock, String townVillage, String parlimentaryConsistuency, String addressProofOfOrganization, String addressOfTheOrganizationReviewComments, String addressOfTheOrganizationComments, String yearOfEstablishment, String panCardNumber, String panCardReviewComments, String panCardComments, String gstNumber, String gstNumberReviewComments, String gstNumberComments,String aadharNumber, String aadharNumReviewComments, String aadharNumComments, String yearOfEstablishmentReviewcomments, String yearOfEstablishmentComments, String prvisionalCertificateReviewComments, String prvisionalCertificateComment, String turnOver1, String financialYear1ReviewComments, String financialYear1Comments, String turnOver2, String financialYear2ReviewComments, String financialYear2Comments, String turnOver3, String financialYear3ReviewComments, String financialYear3Comments, String reviewStatus, String finalReviewstatusComments, String finalReviewStatusFile, String tpDaAssert, String updateOrganizationType, String updateYearOfEstablishment, String uploadYearOfEstablishment, String updatePAN, String uploadPAN, String updateGSTNumber, String uploadGST, String updateFinancialYear1TurnOver, String uploadFinancialYear1, String updateFinancialYear2TurnOver, String uploadFinancialYear2, String updateFinancialYear3TurnOver, String uploadFinancialYear3, String updateAadharNum, String uploadProvisional) throws Exception
    {
 	   	//Rejecting TP 3 Times - Nope updated->>>>>>>Multiple Times, No restriction for TP-Form Submit
     	for(int i=1;i<4;i++)
       	{
    		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("SDMS - Skill Development & Management System"),"Sorry!! Application URL Launch Unsuccessfull!!! ");
     		LoginPage lp = new LoginPage(driver);
          	lp.clickLogin();
     	   	EnterLoginPage elp = new EnterLoginPage(driver);
    	  	elp.performlogin(iaUsername, password);
     	   	//viewing all TP requests waiting for IA to assign respected DA
   	   		InspectionAgency_DashboardPage ia = new InspectionAgency_DashboardPage(driver);
    	   	Thread.sleep(4000);
     	   	JavascriptExecutor js=(JavascriptExecutor)driver;
     	   	js.executeScript("window.scrollBy(0,200)", "");
     		Thread.sleep(2000);
     		ia.clickOnViewAllAssessmentRequest();
    	   	Thread.sleep(2000);
    	   	InspectionAgency_ViewInspectionPage iv=new InspectionAgency_ViewInspectionPage(driver);
     	   	iv.enterTPIDForSearch(tpID);
    	   	Thread.sleep(2000);
    	   	iv.clickOnApply();
    	   	Thread.sleep(4000);
    	   	Assert.assertTrue(driver.findElements(By.xpath("//tr[td[span[contains(text(),'"+tpID+"')]]]")).size()!=0,"OMG!!! No show of rejection profile TP - "+tpID+" for IA - "+iaUsername+" ( iteration - "+i+" )");
     	   	iv.clickOnAction();
     	   	Thread.sleep(2000);
     	   	iv.clickOnTakeAction();
     	   	Thread.sleep(2000);
     	   	String spocName=ReadWriteData.getData("./TestData/Workflow/TrainingPartner-Workflow.xls", "RejectionTP_Creation", Integer.parseInt(serialNum), 3);
     	   	Assert.assertEquals(driver.findElement(By.name("SPOC_Name")).getAttribute("value").trim(), spocName);
     	   	Assert.assertEquals(driver.findElement(By.name("SPOC_Email")).getAttribute("value").trim(), tpEmail);
     	   	Assert.assertEquals(driver.findElement(By.name("SPOC-mobile")).getAttribute("value").trim(), tpMobile);
     	   	iv.selectForAssignTo_Second(daName);
     	   	Thread.sleep(2000);
     	   	iv.clickForAssign();
     	   	Thread.sleep(2000);
    	   	PostLoginPage plp=new PostLoginPage(driver);
     	   	plp.clickOnProfileLogo();
     	   	plp.clickOnLogout();
        	Thread.sleep(6000);
     	   	//DA Rejecting TP
    	   	lp.clickLogin();
     	   	elp.performlogin(daUserName, daPassword);
     	   	Thread.sleep(6000);
     	   	DA_DashboardPage da=new DA_DashboardPage(driver);
     	   	Thread.sleep(4000);
     	   	js.executeScript("window.scrollBy(0,200)", "");
     	   	Thread.sleep(2000);
     	   	da.clickOnViewAllAssessmentRequest();
     	   	Thread.sleep(2000);
     	   	DesktopAssessor_ViewInspectionPage dv=new DesktopAssessor_ViewInspectionPage(driver);
     	   	dv.enterKeywordForTPID(tpID);
     	   	Thread.sleep(2000);
     	   	dv.clickOnApply();
     		Thread.sleep(2000);
     	   	Assert.assertTrue(driver.findElements(By.xpath("//tr[td[span[contains(text(),'"+tpID+"')]]]")).size()!=0,"OMG!!! No show of created rejection profile TP"+tpID+" for DA - "+daUserName);
     	   	dv.clickOnAction();
     	   	Thread.sleep(2000);
     	   	dv.clickOnTakeAction();
     	   	Thread.sleep(2000);
     	   	DA_Assign_TPRegistrationFormPage da_tpr = new DA_Assign_TPRegistrationFormPage(driver);
     	   	//Asserting every field information against TP registered data
     	   	//Organization Name verification
     	   	Assert.assertEquals(driver.findElement(By.name("organization-name")).getAttribute("value").trim(), nameOfOrganization);
     	   	//Organization Type verification
     	   	Assert.assertEquals( driver.findElement(By.xpath("(//div[div[label[contains(text(),'Type of the Organization:')]]]//input)[2]")).getAttribute("value").trim(), typeOfOrganization);
     	   	//Organization Address verification
     	   	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'Address of the Organization:')]]]//input)[3]")).getAttribute("value").trim(), addressOfOrganization);
     	   	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'Nearby Landmark')]]]//label//input)[3]")).getAttribute("value").trim(), nearByLandmark);
     	   	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'Pincode')]]]//label//input)[4]")).getAttribute("value").trim(), pincode);
     	   	Assert.assertEquals(driver.findElement(By.xpath("(//div[div[label[contains(text(),'State')]]]//label//input)[7]")).getAttribute("value").trim(), sateOrUnionTerritory);
     	   	Assert.assertEquals(driver.findElement(By.xpath("(//input)[7]")).getAttribute("value").trim(), district);
     	   	Assert.assertEquals(driver.findElement(By.xpath("(//input)[10]")).getAttribute("value").trim(), tehsilMandalBlock);
     	  	Assert.assertEquals(driver.findElement(By.xpath("(//input)[8]")).getAttribute("value").trim(), parlimentaryConsistuency);
     	   	Assert.assertEquals(driver.findElement(By.xpath("(//input)[11]")).getAttribute("value").trim(), townVillage);
     	   	Assert.assertEquals(driver.findElement(By.xpath("(//div[label[label[contains(text(),'Address Proof of the Organization')]]]//input)[2]")).getAttribute("value").trim(), addressProofOfOrganization);
     	   	Thread.sleep(2000);
     	   	da_tpr.selectReviewCommentsForAddress(addressOfTheOrganizationReviewComments);
     	   	Thread.sleep(2000);
     	   	da_tpr.enterAdditionalCommentForAddressOfOrganization(addressOfTheOrganizationComments);
     	   	da_tpr.clickForSaveAndContinue();
     	   	Thread.sleep(2000);
     	   	//checking year of establishment and checking loaded fields depending on the type of organization and year of establishment
     	   	if(typeOfOrganization.equalsIgnoreCase("Government Institute"))
     	   	{
     	   		da_tpr.clickForSaveAndContinue();
          	   	Thread.sleep(2000);
     	   	}
     	   	else if(typeOfOrganization.equals("Proprietorship")||typeOfOrganization.equals("Firm")||typeOfOrganization.equals("Society")||typeOfOrganization.equals("Trust")||typeOfOrganization.equals("Limited Liability Partnership (LLP)"))
     	   	{
     	   		Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Account Number']")).getAttribute("value").trim(), panCardNumber);
     	   	 	Thread.sleep(2000);
     		 	da_tpr.selectReviewCommentForPAN(panCardReviewComments);
     		 	Thread.sleep(2000);
     		 	da_tpr.enterAdditionalCommentForPAN(panCardComments);
     		 	Thread.sleep(2000);
     	   	}
     	   	else if(typeOfOrganization.equals("Company") || updateOrganizationType.equals("Company"))
    	   	{
     	   		Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Account Number']")).getAttribute("value").trim(), panCardNumber);
     	   		da_tpr.selectReviewCommentForPAN(panCardReviewComments);
		 		Thread.sleep(2000);
		 		da_tpr.enterAdditionalCommentForPAN(panCardComments);
		 		Thread.sleep(2000);
		 		da_tpr.selectReviewCommentsForGST(gstNumberReviewComments);
	        	Thread.sleep(2000);
	        	da_tpr.enterAdditionalCommentForGST(gstNumberComments);
	        	Thread.sleep(2000);
		 	}
     		//government
    		if(!typeOfOrganization.equals("Government Institute"))
     	   	{
    			da_tpr.clickForSaveAndContinue();
        		Thread.sleep(4000);
     	   	}
    		//Final Review things
    		if(serialNum.equals("1"))
    		{
    			Select finalreviewStatius=new Select(driver.findElement(By.xpath("//select[@placeholder='Deemed Not Ready']")));
     	   		Assert.assertEquals(finalreviewStatius.getFirstSelectedOption().getText().trim(),"Deemed Not Ready");
     	   		da_tpr.enterAdditionalCommentForFinalStatus(finalReviewstatusComments);
     	   		Thread.sleep(4000);
     	   		da_tpr.clickForFinalStatusBrowseFile();
     	   		Thread.sleep(4000);
     	   		UploadFile.upload(finalReviewStatusFile);
     	   		Thread.sleep(5000);
     	   		da_tpr.clickForFinalStatusUploadFile();
     	   		Thread.sleep(5000);
    		}
      	   	da_tpr.clickForSaveAndContinue();
      	   	Thread.sleep(6000);
      	   	da_tpr.clickForOK();
	     	Assert.assertTrue(driver.findElements(By.id("swal2-title")).size()!=0,"OMG!!! something went wrong after clicking Final Review Save and Continue button! ");
	    	Thread.sleep(4000);
	     	da_tpr.clickForOK();
      	   	Thread.sleep(4000);
      	   	//Verifying Awaiting TP Reply status
      	   	da.clickOnViewAllAssessmentRequest();
      	   	Thread.sleep(4000);
   	   		dv.enterKeywordForTPID(tpID);
   	   		Thread.sleep(2000);
   	   		dv.clickOnApply();
   	   		Thread.sleep(6000);
      	   	Assert.assertEquals(driver.findElement(By.xpath("//tr[td[span[contains(text(),'"+tpID+"')]]]/td[8]")).getText().trim(), "Deemed Not Ready");
      	   	plp.clickOnProfileLogo();
      	   	Thread.sleep(2000);
      	   	plp.clickOnLogout();
      	   	Thread.sleep(6000);
    	  	//TP Login to check DA Action Comments
      	   	lp.clickLogin();
      	   	Thread.sleep(2000);
      	   	elp.performlogin(tpID, "Qwerty@123");
      	   	Thread.sleep(10000);
      	   	TrainingPartnerReEditRegistrationPage tpREp=new TrainingPartnerReEditRegistrationPage(driver);
     	   	Assert.assertEquals(driver.findElement(By.xpath("//p[contains(text(),'Action DA Comments')]")).getText(), tpDaAssert);
     	   	js.executeScript("window.scrollBy(0,200)", "");
     		Thread.sleep(2000);
     		tpREp.clickDaComments();
     	   	Thread.sleep(6000);
     	   	if(i==3)
     	   	{
//     	   		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='status-message']/p")).getText().trim(),"You are blocked for 2 months as your application is rejected 3 times by Desktop Assessor.");
//     	   		Assert.assertEquals(driver.findElement(By.xpath("//p[contains(text(),'My Application Status:')]/span")).getText().trim(),"Application Blocked");
     	   		tpREp.clickSubmitForReview();
		    	Thread.sleep(2000);
     	   		tpREp.clickOk();
		    	Thread.sleep(2000);
	    		tpREp.clickSentforApprovalPopup();
	    		Thread.sleep(2000);
	    		Assert.assertEquals(driver.findElement(By.xpath("//p[contains(text(),'My Application Status')]/span")).getText().trim(), "Awaiting Assessment","OMG!!! After 3rd Time Rejection from DA, TP is unable to resubmit application");
	    		plp.clickOnProfileLogo();
	    		Thread.sleep(2000);
	    		plp.clickOnLogout();
     	   	}
 	    	else
 	    	{
 	    		//Verifying submitted Data and DA_Comments
 	    		Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='nameOfOrganisation']")).getAttribute("value"), nameOfOrganization);
 	    		Select selectedOrganizationType=new Select(driver.findElement(By.xpath("//select[@formcontrolname='typeOfOrganisation']")));
 		    	Assert.assertEquals(selectedOrganizationType.getFirstSelectedOption().getText().trim(), typeOfOrganization);
 		    	if(!typeOfOrganization.equalsIgnoreCase("Government Institute"))
 	    		{
 	    			Select selectedYearOfEstablishment=new Select(driver.findElement(By.xpath("//select[@formcontrolname='yearOfEstablishment']")));
 		    		Assert.assertEquals(selectedYearOfEstablishment.getFirstSelectedOption().getText().trim(), yearOfEstablishment);
 		    		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'"+yearOfEstablishmentComments+"')]")).isDisplayed(), " OMG!!! No show of DA Rejection Comments for Year Of Establishment ");
 	    		}
 	    		Assert.assertEquals(driver.findElement(By.xpath("//textarea[@formcontrolname='addressLine1']")).getAttribute("value").trim(), addressOfOrganization);
 	    		Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='landmark']")).getAttribute("value").trim(), nearByLandmark);
	    		Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='pincode']")).getAttribute("value").trim(), pincode);
	    		Select selectedState=new Select(driver.findElement(By.xpath("//select[@formcontrolname='state']")));
	    		Assert.assertEquals(selectedState.getFirstSelectedOption().getText().trim(), sateOrUnionTerritory);
	    		Select selectedDistrict=new Select(driver.findElement(By.xpath("//select[@formcontrolname='district']")));
	    		Assert.assertEquals(selectedDistrict.getFirstSelectedOption().getText().trim(), district);
	    		if(serialNum.equalsIgnoreCase("1"))
	    		{
	    			Select selectedSubDistrict=new Select(driver.findElement(By.xpath("//select[@formcontrolname='subDistrict']")));
		    		Assert.assertEquals(selectedSubDistrict.getFirstSelectedOption().getText().trim(), tehsilMandalBlock);
		    		Select selectedVillage=new Select(driver.findElement(By.xpath("//select[@formcontrolname='village']")));
		    		Assert.assertEquals(selectedVillage.getFirstSelectedOption().getText().trim(), townVillage);
	    		}
	    		Select selectedParlimentary=new Select(driver.findElement(By.xpath("//select[@formcontrolname='parliamentaryConstituency']")));
	    		Assert.assertEquals(selectedParlimentary.getFirstSelectedOption().getText().trim(), parlimentaryConsistuency);
	    		Select selectedaddressProof=new Select(driver.findElement(By.xpath("//select[@formcontrolname='addressProof']")));
	    		Assert.assertEquals(selectedaddressProof.getFirstSelectedOption().getText().trim(), addressProofOfOrganization);
	    		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'"+addressOfTheOrganizationComments+"')]")).isDisplayed());
	    		if(typeOfOrganization.equalsIgnoreCase("Company")) 
	    		{
	    			Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='GST']")).getAttribute("value").trim(), gstNumber);
	    			Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'"+gstNumberComments+"')]")).isDisplayed(), " OMG!!! No show of DA rejection Comments for GST ");
	    		}
	    		if(!typeOfOrganization.equalsIgnoreCase("Government Institute")) 
	    		{
	    			Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='PAN']")).getAttribute("value").trim(), panCardNumber);
	    			Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'"+panCardComments+"')]")).isDisplayed(), " OMG!!! No show of DA rejection Comments for PAN ");
	    			if(yearOfEstablishment.equals("2018"))
	    			{
	    				
	    			}
	    			else if(yearOfEstablishment.equals("2017"))
	    			{
	    				Assert.assertEquals(driver.findElement(By.xpath("(//input[@formcontrolname='annualTurnover'])[1]")).getAttribute("value").trim(), turnOver1);
		    			Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'"+financialYear1Comments+"')]")).isDisplayed(), " OMG!!! No show of DA rejection Comments for First Financial Year");
	    			}
	    			else if(yearOfEstablishment.equals("2016"))
	    			{
	    				Assert.assertEquals(driver.findElement(By.xpath("(//input[@formcontrolname='annualTurnover'])[1]")).getAttribute("value").trim(), turnOver1);
		    			Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'"+financialYear1Comments+"')]")).isDisplayed(), " OMG!!! No show of DA rejection Comments for First Financial Year");
		    			Assert.assertEquals(driver.findElement(By.xpath("(//input[@formcontrolname='annualTurnover'])[2]")).getAttribute("value").trim(), turnOver2);
		    			Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'"+financialYear2Comments+"')]")).isDisplayed(), " OMG!!! No show of DA rejection Comments for Second Financial Year");
	    			}
	    			else if(Integer.parseInt(yearOfEstablishment)<2016)
	    			{
	    				Assert.assertEquals(driver.findElement(By.xpath("(//input[@formcontrolname='annualTurnover'])[1]")).getAttribute("value").trim(), turnOver1);
		    			Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'"+financialYear1Comments+"')]")).isDisplayed(), " OMG!!! No show of DA rejection Comments for First Financial Year");
		    			Assert.assertEquals(driver.findElement(By.xpath("(//input[@formcontrolname='annualTurnover'])[2]")).getAttribute("value").trim(), turnOver2);
		    			Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'"+financialYear2Comments+"')]")).isDisplayed(), " OMG!!! No show of DA rejection Comments for Second Financial Year");
	    				Assert.assertEquals(driver.findElement(By.xpath("(//input[@formcontrolname='annualTurnover'])[3]")).getAttribute("value").trim(), turnOver3);
		    			Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'"+financialYear3Comments+"')]")).isDisplayed(), " OMG!!! No show of DA rejection Comments for Third Financial Year ");
	    			}
	    		}
	    		//Updating Rejected Form - Re-Edit
 	    		tpREp.clicknameOfOrganizationSave();
 	    		Thread.sleep(2000);
 	    		Assert.assertTrue(driver.findElement(By.xpath("//button[contains(text(),'Save & Submit for Review')]")).isEnabled(),"OMG!!! Save and Submit for review button is Disabled OR Something went wrong! ");
 		    	tpREp.clickSubmitForReview();
 		    	Thread.sleep(2000);
 		    	tpREp.clickOk();
 		    	Thread.sleep(2000);
 	    		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='swal2-contentwrapper']")).getText(), "Your Application has been submitted for review, Kindly wait for approval");
 	    		tpREp.clickSentforApprovalPopup();
 	    		Thread.sleep(2000);
 	    		Assert.assertEquals(driver.findElement(By.xpath("//p[contains(text(),'My Application Status')]/span")).getText().trim(), "Awaiting Assessment");
 	    		plp.clickOnProfileLogo();
 	    		Thread.sleep(2000);
 	    		plp.clickOnLogout();
 	    		Thread.sleep(6000);
 	    	}			
     	} 	    				
    }
}