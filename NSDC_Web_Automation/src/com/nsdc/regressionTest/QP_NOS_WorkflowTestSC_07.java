package com.nsdc.regressionTest;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nsdc.generic.ReadMultipleDataFromExcel;
import com.nsdc.generic.ReadWriteData;
import com.nsdc.generic.UploadFile;
import com.nsdc.pages.EnterLoginPage;
import com.nsdc.pages.LoginPage;
import com.nsdc.pages.SSC_NOS_GeneralDetailsPage;
import com.nsdc.pages.SSC_QP_GeneralDetailsPage;
import com.nsdc.pages.SSC_QPNOS_Model_CurriculumPage;
import com.nsdc.pages.SSC_QP_AddCompulsoryNOSsPage;
import com.nsdc.pages.SSC_QP_AddNOSsPage;
import com.nsdc.pages.SSC_DashboardPage;
import com.nsdc.pages.SSC_EditNOSPage;
import com.nsdc.pages.SSC_ViewAllNOSsPage;
import com.nsdc.testConfig.TestConfiguration;

public class QP_NOS_WorkflowTestSC_07 extends TestConfiguration
{
	@DataProvider
	public Object[][] createNOS_Data()
	{
	    return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/QP_NOS-Workflow.xls", "CreateNOSSC07TC01");
	}
	
	@DataProvider
	public Object[][] editNOS_Data()
	{
	    return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/QP_NOS-Workflow.xls", "EditNOS_SC07TC02");
	}
	 
	@Test(dataProvider="createNOS_Data")
    public void createNOS_TC_01(String sNumber, String SSC_username, String SSC_password, String NOS_sector, String NOS_subSector, String occupation, String credits, String NSQF_level, String NOS_name, String NOS_version, String NOS_description, String NOS_scope, String criteria1, String criteria2, String criteria3, String element1, String element2, String element3, String parameter1, String parameter2, String parameter3, String skill1, String skill2, String skill3, String date, String noscode) throws Exception
    {
		LoginPage lp = new LoginPage(driver);
        EnterLoginPage elp = new EnterLoginPage(driver);
        lp.clickLogin();
        elp.performlogin(SSC_username, SSC_password);
        Thread.sleep(4000);
        
        SSC_DashboardPage dashboard = new SSC_DashboardPage(driver);
        dashboard.clickOn_QP_NOS_ModelCurriculum();
        Thread.sleep(2000);
        SSC_QPNOS_Model_CurriculumPage model = new SSC_QPNOS_Model_CurriculumPage(driver);
        model.clickOn_CreateNOS();
        Thread.sleep(2000);

        SSC_NOS_GeneralDetailsPage details = new SSC_NOS_GeneralDetailsPage(driver);
        Assert.assertEquals(driver.findElement(By.name("sectorName")).getAttribute("value"), NOS_sector);
        details.selectSubSector(NOS_subSector);
        details.selectOccupation(occupation);
        details.enterCreditsOrNSQF(credits);
        details.selectNSQF_Level(NSQF_level);
        details.enterNOS_Name(NOS_name);
        Assert.assertEquals(driver.findElement(By.name("version")).getAttribute("value"), NOS_version);
        //details.enterNOS_version(NOS_version);
        details.enterNOS_description(NOS_description);
        details.enterNOS_scope(NOS_scope);
        details.clickOnSaveAndContinue();
        Thread.sleep(2000);
       // Assert.assertEquals(driver.findElement(By.cssSelector(".toast-message")).getText(), "NOS Created Successfully");

        String nos_code = driver.findElement(By.name("nosCode")).getAttribute("value");
        System.out.println(nos_code);
        int row = Integer.parseInt(sNumber);
        ReadWriteData.setExcelData("./TestData/Workflow/QP_NOS-Workflow.xls", "CreateNOSSC07TC01", row, 25, nos_code);
        
        Assert.assertEquals(driver.findElement(By.xpath("//h3[contains(text(),'Elements are optional')]")).getText(), "Elements are optional. Please mention wherever applicable. Performance Criteria should be outcome oriented and assessable");
        Assert.assertEquals(driver.findElement(By.xpath("//h3[contains(text(),'To be competent')]")).getText(), "To be competent, the user/individual on the job must be able to:");
        details.enterPerformanceCriteria1(criteria1);
        details.clickOnAddAnotherPerformanceCriteria();
        details.enterPerformanceCriteria2(criteria2);
        details.clickOnAddAnotherPerformanceCriteria();
        details.enterPerformanceCriteria3(criteria3);
        details.clickOnCategoriseUnderElements();
        Thread.sleep(2000);
        details.enterNameOfTheElement1(element1);
       // Assert.assertEquals(driver.findElement(By.xpath("(//div[label[contains(text(),'Grouped Performance Criterias')]])[1]/div/label[1]/span")), true);
       // Assert.assertTrue(driver.findElement(By.xpath("(//div[label[contains(text(),'Grouped Performance Criterias')]])[1]/div/label[2]/span")).isSelected());
        details.clickOn_GroupedPerformanceCriteria3ForElement1();
        details.clickOn_addAnotherElement();
        details.enterNameOfTheElement2(element2);
      //  Assert.assertTrue(driver.findElement(By.xpath("(//div[label[contains(text(),'Grouped Performance Criterias')]])[2]/div/label[1]/span")).isSelected());
        details.clickOn_GroupedPerformanceCriteria2ForElement2();
        //Assert.assertTrue(driver.findElement(By.xpath("(//div[label[contains(text(),'Grouped Performance Criterias')]])[2]/div/label[3]/span")).isSelected());
        details.clickOn_addAnotherElement();
        details.enterNameOfTheElement3(element3);
        details.clickOn_GroupedPerformanceCriteria1ForElement3();
      //  Assert.assertTrue(driver.findElement(By.xpath("(//div[label[contains(text(),'Grouped Performance Criterias')]])[3]/div/label[2]/span")).isSelected());
       // Assert.assertTrue(driver.findElement(By.xpath("(//div[label[contains(text(),'Grouped Performance Criterias')]])[3]/div/label[3]/span")).isSelected());
        details.clickOnSaveAndContinueToNextStep();
        Thread.sleep(2000);
       // Assert.assertEquals(driver.findElement(By.cssSelector(".toast-message")).getText(), "NOS Updated Successfully");
        Assert.assertEquals(driver.findElement(By.xpath("//h3[contains(text(),'Please ensure you have')]")).getText(), "Please ensure you have included points for Theoretical and Technical Knowledge, and Organizational Context");
        Assert.assertEquals(driver.findElement(By.xpath("//h3[contains(text(),'The user/individual')]")).getText(), "The user/individual on the job needs to know and understand:");
        details.enterKnowledgeAndUnderstanding1(parameter1);
        details.clickOnAddAnotherKnowledgeAndUnderstanding();
        details.enterKnowledgeAndUnderstanding2(parameter2);
        details.clickOnAddAnotherKnowledgeAndUnderstanding();
        details.enterKnowledgeAndUnderstanding3(parameter3);
        details.clickOnSaveAndContinueToNextStep();
        Thread.sleep(2000);
     //   Assert.assertEquals(driver.findElement(By.cssSelector(".toast-message")).getText(), "NOS Updated Successfully");
        Assert.assertEquals(driver.findElement(By.xpath("//h3[contains(text(),'Please ensure you have')]")).getText(), "Please ensure you have included points for Literacy and Oral Communication. You may also include points for Soft/Professional Skills viz. Descision Making, Plan and Organize, Customer Centricity, Problem Solving, Analytical Thinking, Critical Thinking, etc.");
        Assert.assertEquals(driver.findElement(By.xpath("//h3[contains(text(),'The user/individual')]")).getText(), "The user/individual on the job needs to know and understand how to:");

        details.enterGenericSkill1(skill1);
        details.clickOnAddAnotherGenericSkill();
        details.enterGenericSkill2(skill2);
        details.clickOnAddAnotherGenericSkill();
        details.enterGenericSkill3(skill3);
        details.clickOnSaveAndContinueToNextStep();
        Thread.sleep(2000);
       // Assert.assertEquals(driver.findElement(By.cssSelector(".toast-message")).getText(), "NOS Updated Successfully");
        
        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'Your National Occupational Standard is almost complete')]")).getText(), "Your National Occupational Standard is almost complete, kindly review the same before sending to the Standard Team who will provide there review comments and take final decision on your final submit of the NOS.");
        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'At any point of time you')]")).getText(), "At any point of time you can review the NOS which you have created under \" View all NOSs \"");
        
        details.enterNextReviewDate(date);
        details.clickOnCalendarLogo();
        details.clickOnSubmitForApproval();
        Assert.assertEquals(driver.findElement(By.cssSelector(".toast-message")).getText(), "NOS Created Successfully and Submitted for Approval!");

        Assert.assertEquals(driver.findElement(By.xpath("//b[contains(text(),'"+nos_code+"')]")).getText(), nos_code);
        Assert.assertEquals(driver.findElement(By.xpath("//b[contains(text(),'"+NOS_sector+"')]")).getText(), NOS_sector);
        Assert.assertEquals(driver.findElement(By.xpath("//b[contains(text(),'"+date+"')]")).getText(), date);
        Assert.assertEquals(driver.findElement(By.xpath("//b[contains(text(),'"+NOS_version+"')]")).getText(), NOS_version);

        Assert.assertEquals(driver.findElement(By.xpath("//p[contains(text(),'Your National Occupational')]")).getText(), "Your National Occupational Standard is complete and is sent to the Standard Team who will provide their review comments and take final decision on your NOS creating request.");
        Assert.assertEquals(driver.findElement(By.xpath("//p[contains(text(),'At any point of')]")).getText(), "At any point of time you can review the NOS which you have created under \" View all NOSs\"");

        details.clickOnBackToDashboard();
        Thread.sleep(2000);
        model.clickOn_ViewAllNOSs();
        Thread.sleep(2000);
        SSC_ViewAllNOSsPage viewNOS = new SSC_ViewAllNOSsPage(driver);
        viewNOS.enterNOS_codeInSearchBox(nos_code);
        viewNOS.clickOnSearch();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+NOS_name+"')]")).getText(), NOS_name);
        Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+nos_code+"')]")).getText(), nos_code);
        Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+NOS_version+"')]")).getText(), NOS_version);
        Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+NOS_sector+"')]")).getText(), NOS_sector);
        Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+NOS_subSector+"')]")).getText(), NOS_subSector);
     //   Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+NSQF_level+"')]")).getText(), NSQF_level);
        Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'Awaiting Standards Approval')])[1]")).getText(), "Awaiting Standards Approval");
        
        

    }
	
	@Test
	public void createQP_TC_02(String SSC_username, String SSC_password, String country, String QP_sector, String QP_subSector, String QP_occupation, String NCO_Code, String NSQF_Level, String justification, String QPname, String brief, String attributes, String job1, String job1_specialization, String job2, String job2_specialization, String job3, String job3_specialization, String training, String licence, String age, String experience1, String experienceSpecialization1, String experience2, String experienceSpecialization2, String experience3, String experienceSpecialization3, String remarks, String normsCategory, String bucket, String tech, String service, String org, String version, String file, String elective, String electiveDescription, String option, String optionDescription) throws Exception
	{
		LoginPage lp = new LoginPage(driver);
        EnterLoginPage elp = new EnterLoginPage(driver);
        lp.clickLogin();
        elp.performlogin(SSC_username, SSC_password);
        Thread.sleep(4000);
        
        SSC_DashboardPage dashboard = new SSC_DashboardPage(driver);
        dashboard.clickOn_QP_NOS_ModelCurriculum();
        SSC_QPNOS_Model_CurriculumPage model = new SSC_QPNOS_Model_CurriculumPage(driver);
        Thread.sleep(2000);
        model.clickOn_CreateQP();
        Thread.sleep(2000);
        SSC_QP_GeneralDetailsPage QP = new SSC_QP_GeneralDetailsPage(driver);
        QP.selectCountryOfOrigin(country);
        Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='sectorName']")).getAttribute("value"), QP_sector);
        QP.selectSubSector(QP_subSector);
        QP.selectOccupation(QP_occupation);
        QP.enterAlignedToNCO_Code(NCO_Code);
        QP.selectNSQF_Level(NSQF_Level);
        QP.enterJustificationOfNSQF_Level(justification);
        QP.enterQP_Name(QPname);
        QP.enterBriefDescription(brief);
        QP.enterPersonalAttributes(attributes);
        QP.selectMinimumEducationQualification1ForJob(job1);
        QP.enterQualificationSpecialization1ForJob(job1_specialization);
        
        QP.selectMinimumEducationQualification2ForJob(job2);
        QP.enterQualificationSpecialization2ForJob(job2_specialization);
        
        QP.selectMinimumEducationQualification3ForJob(job3);
        QP.enterQualificationSpecialization3ForJob(job3_specialization);
        
        
        
        QP.selectMinimumEducationQualificationForTrainingInSchool(training);
        QP.enterPreRequisiteLicenceOrTraining(licence);
        QP.enterMinimumJobEntryAge(age);
        QP.selectExperience1(experience1);
        QP.enterExperienceSpecialization1(experienceSpecialization1);
        
        QP.selectExperience2(experience2);
        QP.enterExperienceSpecialization2(experienceSpecialization2);
        
        QP.selectExperience3(experience3);
        QP.enterExperienceSpecialization3(experienceSpecialization3);
        
        QP.enterRemarks(remarks);
        QP.selectCostCommonNormsCategory(normsCategory);
        QP.selectBucket(bucket);
        QP.selectTechnicalOrNonTechnical(tech);
        QP.selectManufacturingOrServices(service);
        QP.selectOrganizedOrUnorganized(org);
        Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='version']")).getAttribute("value"), version);
        QP.clickOnBrowseForQP_image();
        Thread.sleep(2000);
        UploadFile.upload(file);
        QP.clickOnuploadForQP_image();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.cssSelector(".toast-message")).getText(), "File uploaded successfully");
        Assert.assertTrue(driver.findElement(By.cssSelector(".fa.fa-check")).isDisplayed());
        QP.clickOnSaveAndContinue();
        Thread.sleep(2000);
        SSC_QP_AddNOSsPage addNOS = new SSC_QP_AddNOSsPage(driver);
        addNOS.enterNOScodeInSearchBox(nos_code);
        addNOS.clickOnSearch();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+NOS_name+"')]")).getText(), NOS_name);
        Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+nos_code+"')]")).getText(), nos_code);
        Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+NOS_sector+"')]")).getText(), NOS_sector);
        Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+NOS_subSector+"')]")).getText(), NOS_subSector);
        Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+credits+"')]")).getText(), credits);
   //     Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+NSQF_level+"')]")).getText(), NSQF_level);
        Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+version+"')]")).getText(), version); 
        Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'Awaiting Standards Approval')]")).getText(), "Awaiting Standards Approval");
        
        addNOS.clickOnAction();
        addNOS.clickOnLinkAsCompulsoryNOSs();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("(//div[@class='modal-header'])[1]")).getText(), "While adding this NOS to the QP, following Sectors(s) will be linked to it.");
 //       Assert.assertEquals(driver.findElement(By.xpath("(//label[@class='m-checkbox m-checkbox--bold'])[1]")).getText(), NOS_sector);
        addNOS.clickOnLinkNos_linkAsCompulsoryNOSs();
        Thread.sleep(2000);
        addNOS.clickOnAction();
        addNOS.clickOnLinkToElectives();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("(//div[@class='m-form__group form-group'])[2]")).getText(), "While adding this NOS to the QP, following Sectors(s) will be linked to it.");
    //    Assert.assertEquals(driver.findElement(By.xpath("//label[contains(text(),'"+NOS_sector+"')]")).getText(), NOS_sector);
        addNOS.enterNameOfTheElective(elective);
        addNOS.enterBriefDescriptionOfTheElective(electiveDescription);
        addNOS.clickOnLinkNOS_LinkToElectives();
        
        addNOS.clickOnAction();
        addNOS.clickOnLinkToOptions();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("(//div[@class='m-form__group form-group'])[4]")).getText(), "While adding this NOS to the QP, following Sectors(s) will be linked to it.");
     //   Assert.assertEquals(driver.findElement(By.xpath("//label[contains(text(),'"+NOS_sector+"')]")).getText(), NOS_sector);
        addNOS.enterNameOfTheOption(option);
        addNOS.enterBriefDescriptionOfTheOption(optionDescription);
        addNOS.clickOnLinkNOS_linkToOptions();
        
        
        
        Assert.assertEquals(driver.findElement(By.xpath("//div[div/span[text()='Compulsory NOSs']]/span")).getText(), 1);
        SSC_QP_AddCompulsoryNOSsPage add = new SSC_QP_AddCompulsoryNOSsPage(driver);
        Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+NOS_name+"')]")).getText(), NOS_name);
        Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+nos_code+"')]")).getText(), nos_code);
        Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+NOS_sector+"')]")).getText(), NOS_sector);
        Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+NOS_subSector+"')]")).getText(), NOS_subSector);
        Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+credits+"')]")).getText(), credits);
        Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+NSQF_level+"')]")).getText(), NSQF_level);
        Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+version+"')]")).getText(), version); 
        Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'Awaiting Standards Approval')]")).getText(), "Awaiting Standards Approval");



	}
	
	@Test
	public void QP_addAnotherQPsNOS_TC_02()
	{
		
	}
    

	@Test(dataProvider="editNOS_Data")
	public void editNOS_TC_02(String SSC_username, String SSC_password, String NOS_sector, String NOS_subSector, String occupation, String credits, String NSQF_level, String NOS_name, String NOS_version, String NOS_description, String NOS_scope, String criteria1, String criteria2, String criteria3, String element1, String element2, String element3, String parameter1, String parameter2, String parameter3, String skill1, String skill2, String skill3, String date, String editSubSector, String editOccupation, String editCredits, String editNSQF_level, String editNOS_name, String editNOS_description, String editNOS_scope, String editCriteria1, String editCriteria2, String editCriteria3, String editCriteria4, String editElement1, String editElement2, String editElement3, String editElement4, String editParameter1, String editParameter2, String editParameter3, String editParameter4, String editSkill1, String editSkill2, String editSkill3, String editSkill4, String editDate) throws Exception
	{
		LoginPage lp = new LoginPage(driver);
        EnterLoginPage elp = new EnterLoginPage(driver);
        lp.clickLogin();
        elp.performlogin(SSC_username, SSC_password);
        Thread.sleep(4000);
        
        SSC_DashboardPage dashboard = new SSC_DashboardPage(driver);
        dashboard.clickOn_QP_NOS_ModelCurriculum();
        SSC_QPNOS_Model_CurriculumPage model = new SSC_QPNOS_Model_CurriculumPage(driver);
//        model.clickOn_CreateNOS();
//        SSC_NOS_GeneralDetailsPage details = new SSC_NOS_GeneralDetailsPage(driver);
//        Assert.assertEquals(driver.findElement(By.name("sectorName")).getAttribute("value"), NOS_sector);
//        details.selectSubSector(NOS_subSector);
//        details.selectOccupation(occupation);
//        details.enterCreditsOrNSQF(credits);
//        details.selectNSQF_Level(NSQF_level);
//        details.enterNOS_Name(NOS_name);
//        Assert.assertEquals(driver.findElement(By.name("version")).getAttribute("value"), NOS_version);
//        details.enterNOS_description(NOS_description);
//        details.enterNOS_scope(NOS_scope); 
//        details.clickOnSaveAndContinue();
//        Thread.sleep(2000);
//
//        String nos_code = driver.findElement(By.name("nosCode")).getAttribute("value");
//        System.out.println(nos_code);
//        
//        Assert.assertEquals(driver.findElement(By.xpath("//h3[contains(text(),'Elements are optional')]")).getText(), "Elements are optional. Please mention wherever applicable. Performance Criteria should be outcome oriented and assessable");
//        Assert.assertEquals(driver.findElement(By.xpath("//h3[contains(text(),'To be competent')]")).getText(), "To be competent, the user/individual on the job must be able to:");
//        details.enterPerformanceCriteria1(criteria1);
//        details.clickOnAddAnotherPerformanceCriteria();
//        details.enterPerformanceCriteria2(criteria2);
//        details.clickOnAddAnotherPerformanceCriteria();
//        details.enterPerformanceCriteria3(criteria3);
//        details.clickOnCategoriseUnderElements();
//        Thread.sleep(2000);
//        details.enterNameOfTheElement1(element1);
//        details.clickOn_GroupedPerformanceCriteria3ForElement1();
//        details.clickOn_addAnotherElement();
//        details.enterNameOfTheElement2(element2);
//        details.clickOn_GroupedPerformanceCriteria2ForElement2();
//        details.clickOn_addAnotherElement();
//        details.enterNameOfTheElement3(element3);
//        details.clickOn_GroupedPerformanceCriteria1ForElement3();
//        details.clickOnSaveAndContinueToNextStep();
//        Thread.sleep(2000);
//        Assert.assertEquals(driver.findElement(By.xpath("//h3[contains(text(),'Please ensure you have')]")).getText(), "Please ensure you have included points for Theoretical and Technical Knowledge, and Organizational Context");
//        Assert.assertEquals(driver.findElement(By.xpath("//h3[contains(text(),'The user/individual')]")).getText(), "The user/individual on the job needs to know and understand:");
//        details.enterKnowledgeAndUnderstanding1(parameter1);
//        details.clickOnAddAnotherKnowledgeAndUnderstanding();
//        details.enterKnowledgeAndUnderstanding2(parameter2);
//        details.clickOnAddAnotherKnowledgeAndUnderstanding();
//        details.enterKnowledgeAndUnderstanding3(parameter3);
//        details.clickOnSaveAndContinueToNextStep();
//        Thread.sleep(2000);
//        Assert.assertEquals(driver.findElement(By.xpath("//h3[contains(text(),'Please ensure you have')]")).getText(), "Please ensure you have included points for Literacy and Oral Communication. You may also include points for Soft/Professional Skills viz. Descision Making, Plan and Organize, Customer Centricity, Problem Solving, Analytical Thinking, Critical Thinking, etc.");
//        Assert.assertEquals(driver.findElement(By.xpath("//h3[contains(text(),'The user/individual')]")).getText(), "The user/individual on the job needs to know and understand how to:");
//
//        details.enterGenericSkill1(skill1);
//        details.clickOnAddAnotherGenericSkill();
//        details.enterGenericSkill2(skill2);
//        details.clickOnAddAnotherGenericSkill();
//        details.enterGenericSkill3(skill3);
//        details.clickOnSaveAndContinueToNextStep();
//        Thread.sleep(2000);
//        details.enterNextReviewDate(date);
//        details.clickOnCalendarLogo();
//       // details.clickOnSubmitForApproval();
//    //    details.clickOnBackToDashboard();
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("scroll(0, -250);");
//        dashboard.clickOn_QP_NOS_ModelCurriculum();
        Thread.sleep(2000);
        model.clickOn_ViewAllNOSs();
        Thread.sleep(2000);
        SSC_ViewAllNOSsPage viewNOS = new SSC_ViewAllNOSsPage(driver);
        viewNOS.enterNOS_codeInSearchBox("AGR/N0422");
        viewNOS.clickOnSearch();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+NOS_name+"')]")).getText(), NOS_name);
       // Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+nos_code+"')]")).getText(), nos_code);
        Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+NOS_version+"')]")).getText(), NOS_version);
        Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+NOS_sector+"')]")).getText(), NOS_sector);
        Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+NOS_subSector+"')]")).getText(), NOS_subSector);
        Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+NSQF_level+"')]")).getText(), NSQF_level);
        Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'Draft')])[1]")).getText(), "Draft");
      ////////////////////////////  
        viewNOS.clickOnAction();
        viewNOS.clickOnEditNOS();
        Thread.sleep(2000);
        
        SSC_EditNOSPage edit = new SSC_EditNOSPage(driver);
        Assert.assertEquals(driver.findElement(By.name("sectorName")).getAttribute("value"), NOS_sector);
  //      Assert.assertEquals(driver.findElement(By.xpath("//select[@formcontrolname='subSectorName']")).getText(), NOS_subSector);
        edit.reselectSubSector(editSubSector);
    //    Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='occupationDesc']/option[@class='placeholder'])[1]")).getText(), occupation);
        edit.reselectOccupation(editOccupation);
        Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='credits']")).getAttribute("value"), credits);
        edit.editCreditsOrNSQF(editCredits);
      //  Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='nsqf']/option[@class='placeholder'])[1]")).getText(), NSQF_level);
        edit.reselectNSQF_Level(editNSQF_level);
        Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='unitTitle']")).getAttribute("value"), NOS_name);
        edit.editNOS_Name(editNOS_name);
        Assert.assertEquals(driver.findElement(By.name("version")).getAttribute("value"), NOS_version);

        Assert.assertEquals(driver.findElement(By.xpath("//textarea[@formcontrolname='description']")).getAttribute("value"), NOS_description);
        edit.editNOS_description(editNOS_description);
        Assert.assertEquals(driver.findElement(By.xpath("//textarea[@formcontrolname='scopeDescription']")).getAttribute("value"), NOS_scope);
        edit.editNOS_scope(editNOS_scope);
        edit.clickOnCancel();
        model.clickOn_ViewAllNOSs();
        viewNOS.enterNOS_codeInSearchBox("AGR/N0422");
        viewNOS.clickOnSearch();
        Thread.sleep(2000);
        viewNOS.clickOnAction();
        viewNOS.clickOnEditNOS();
        Thread.sleep(2000);
        edit.reselectSubSector(editSubSector);
        edit.reselectOccupation(editOccupation);
        edit.editCreditsOrNSQF(editCredits);
        edit.reselectNSQF_Level(editNSQF_level);
        edit.editNOS_Name(editNOS_name);

        edit.editNOS_description(editNOS_description);
        edit.editNOS_scope(editNOS_scope);
        edit.clickOnSaveAndContinue();
        Thread.sleep(2000);
   //yaaaaaaaaaaaaaaaaaaaaaaahaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa se     
        edit.clickOnPrevious();
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.xpath("//label[contains(text(),'NOS Scope')]")).isDisplayed());
        edit.clickOnSaveAndContinue();
        Thread.sleep(2000);
        edit.clickOnSaveAndContinueToNextStep();
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Knowledge and Understanding (KU)')]")).isDisplayed());
        edit.clickOnPrevious();
        Thread.sleep(2000);
        
       // Assert.assertEquals(driver.findElement(By.name("nosCode")).getAttribute("value"), nos_code);
        Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'1. Performance Criteria')]]/div/input[@formcontrolname='pcDescription']")).getText(), criteria1);
        
        edit.editPerformanceCriteria1(editCriteria1);
        
        
        Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'2. Performance Criteria')]]/div/input[@formcontrolname='pcDescription']")).getText(), criteria2);
        edit.editPerformanceCriteria2(editCriteria2);
        Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'3. Performance Criteria')]]/div/input[@formcontrolname='pcDescription']")).getText(), criteria3);
        edit.editPerformanceCriteria3(editCriteria3);
        edit.clickOnAddAnotherPerformanceCriteria();
        edit.editPerformanceCriteria4(editCriteria4);
        edit.clickOnCategoriseUnderElements();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'1. Enter the Name of the Element')]]/div/div/input[@formcontrolname='element']")).getText(), element1);
        
        edit.editNameOfTheElement1(editElement1);
        //assert criteria
        edit.clickOn_GroupedPerformanceCriteria4ForElement1();
        
        Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'2. Enter the Name of the Element')]]/div/div/input[@formcontrolname='element']")).getText(), element2);
        edit.editNameOfTheElement2(editElement2);
        //assert criteria
        edit.clickOn_GroupedPerformanceCriteria4ForElement2();
        
        Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'3. Enter the Name of the Element')]]/div/div/input[@formcontrolname='element']")).getText(), element2);
        edit.editNameOfTheElement3(editElement3);
        //assert criteria
        edit.clickOn_GroupedPerformanceCriteria4ForElement3();
        edit.clickOn_addAnotherElement();
        edit.editNameOfTheElement4(editElement4);
        edit.clickOn_GroupedPerformanceCriteria1ForElement4();
        edit.clickOn_GroupedPerformanceCriteria2ForElement4();
        edit.clickOn_GroupedPerformanceCriteria3ForElement4();
        edit.clickOn_GroupedPerformanceCriteria4ForElement4();
        edit.clickOnSaveAndContinueToNextStep();

        Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'1. Knowledge and Understanding (KU)')]]/div/input[@formcontrolname='knowledgeParam']")).getText(), parameter1);
        Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'2. Knowledge and Understanding (KU)')]]/div/input[@formcontrolname='knowledgeParam']")).getText(), parameter2);
        Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'3. Knowledge and Understanding (KU)')]]/div/input[@formcontrolname='knowledgeParam']")).getText(), parameter3);
        edit.clickOnSkip();
        
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Generic Skills (GS)')]")).isDisplayed());
        edit.clickOnPrevious();
        Thread.sleep(2000);
        
        edit.editKnowledgeAndUnderstanding1(editParameter1);
        edit.editKnowledgeAndUnderstanding2(editParameter2);
        edit.editKnowledgeAndUnderstanding3(editParameter3);
        edit.clickOnAddAnotherKnowledgeAndUnderstanding();
        edit.editKnowledgeAndUnderstanding4(editParameter4);
        
        edit.clickOnSaveAndContinueToNextStep();
        Thread.sleep(2000);
        
        Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'1. Generic Skill (GS)')]]/div/input[@formcontrolname='skillCrt']")).getText(), skill1);
        Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'2. Generic Skill (GS)')]]/div/input[@formcontrolname='skillCrt']")).getText(), skill1);
        Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'3. Generic Skill (GS)')]]/div/input[@formcontrolname='skillCrt']")).getText(), skill1);
        
        edit.clickOnSkip();
        
        edit.clickOnEditDetails();
        edit.clickOnSaveAndContinue();
        edit.clickOnSaveAndContinueToNextStep();
        edit.clickOnSaveAndContinueToNextStep();
        
        edit.editGenericSkill1(editSkill1);
        edit.editGenericSkill2(editSkill2);
        edit.editGenericSkill3(editSkill3);
        edit.clickOnAddAnotherGenericSkill();
        edit.editGenericSkill4(editSkill4);
        
        edit.clickOnSaveAndContinueToNextStep();
        Thread.sleep(2000);
        edit.editNextReviewDate(editDate);
        
        edit.clickOnEditDetails();
        
        Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='subSectorName']/option[@class='placeholder'])[1]")).getText(), editSubSector);
        Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='occupationDesc']/option[@class='placeholder'])[1]")).getText(), editOccupation);
        Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='credits']")).getText(), editCredits);
        Assert.assertEquals(driver.findElement(By.xpath("(//select[@formcontrolname='nsqf']/option[@class='placeholder'])[1]")).getText(), editNSQF_level);
        Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='unitTitle']")).getText(), editNOS_name);

        Assert.assertEquals(driver.findElement(By.xpath("//textarea[@formcontrolname='description']")).getText(), editNOS_description);
        Assert.assertEquals(driver.findElement(By.xpath("//textarea[@formcontrolname='scopeDescription']")).getText(), editNOS_scope);
        
        edit.clickOnSaveAndContinue();
        Thread.sleep(2000);
        
        Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'1. Performance Criteria')]]/div/input[@formcontrolname='pcDescription']")).getText(), editCriteria1);
        Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'2. Performance Criteria')]]/div/input[@formcontrolname='pcDescription']")).getText(), editCriteria2);
        Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'3. Performance Criteria')]]/div/input[@formcontrolname='pcDescription']")).getText(), editCriteria3);
        Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'4. Performance Criteria')]]/div/input[@formcontrolname='pcDescription']")).getText(), editCriteria4);
        
        edit.clickOnCategoriseUnderElements();
        Thread.sleep(2000);
       
        Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'1. Enter the Name of the Element')]]/div/div/input[@formcontrolname='element']")).getText(), editElement1);
        //checkbox assert
        
        Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'2. Enter the Name of the Element')]]/div/div/input[@formcontrolname='element']")).getText(), editElement2);
        //checkbox assert
        
        Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'3. Enter the Name of the Element')]]/div/div/input[@formcontrolname='element']")).getText(), editElement3);
        //checkbox assert
        
        Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'4. Enter the Name of the Element')]]/div/div/input[@formcontrolname='element']")).getText(), editElement4);
        //checkbox assert
        
        edit.clickOnSaveAndContinueToNextStep();
        Thread.sleep(2000);
        
        Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'1. Knowledge and Understanding (KU)')]]/div/input[@formcontrolname='knowledgeParam']")).getText(), editParameter1);
        Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'2. Knowledge and Understanding (KU)')]]/div/input[@formcontrolname='knowledgeParam']")).getText(), editParameter2);
        Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'3. Knowledge and Understanding (KU)')]]/div/input[@formcontrolname='knowledgeParam']")).getText(), editParameter3);
        Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'4. Knowledge and Understanding (KU)')]]/div/input[@formcontrolname='knowledgeParam']")).getText(), editParameter4);
        
        edit.clickOnSaveAndContinueToNextStep();
        Thread.sleep(2000);
        
        Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'1. Generic Skill (GS)')]]/div/input[@formcontrolname='skillCrt']")).getText(), editSkill1);
        Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'2. Generic Skill (GS)')]]/div/input[@formcontrolname='skillCrt']")).getText(), editSkill2);
        Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'3. Generic Skill (GS)')]]/div/input[@formcontrolname='skillCrt']")).getText(), editSkill3);
        Assert.assertEquals(driver.findElement(By.xpath("//div[label[contains(text(),'4. Generic Skill (GS)')]]/div/input[@formcontrolname='skillCrt']")).getText(), editSkill4);
        edit.clickOnSaveAndContinueToNextStep();
        Thread.sleep(2000);
        edit.clickOnViewAllNOSs();
        Thread.sleep(2000);
        Set <String> windows1 = driver.getWindowHandles();
        Iterator <String> it1 = windows1.iterator();
        String window1 = it1.next();
        String window2 = it1.next();
        driver.switchTo().window(window2);
        Thread.sleep(2000);
         
        Assert.assertTrue(driver.findElement(By.xpath("//h3[contains(text(),'View All National Occupational Standards')]")).isDisplayed());
        driver.switchTo().window(window1);
        Thread.sleep(2000);
        
        Assert.assertEquals(driver.findElement(By.id("date")).getText(), editDate);
        //edit.clickOnSubmitForApproval();
        

        
	}
}
