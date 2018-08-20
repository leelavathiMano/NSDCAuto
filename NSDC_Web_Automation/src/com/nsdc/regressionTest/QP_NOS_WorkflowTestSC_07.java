package com.nsdc.regressionTest;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
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
import com.nsdc.pages.SSC_QP_SaveSuccessPage;
import com.nsdc.pages.SSC_QPNOS_Model_CurriculumPage;
import com.nsdc.pages.SSC_QP_AddNOSsPage;
import com.nsdc.pages.SSC_QP_AssessmentCriteriaPage;
import com.nsdc.pages.SSC_DashboardPage;
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
	public Object[][] createQP_Data()
	{
	    return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/QP_NOS-Workflow.xls", "CreateQPSC07TC02");
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
        details.enterNOS_description(NOS_description);
        details.enterNOS_scope(NOS_scope);
        details.clickOnSaveAndContinue();
        Thread.sleep(2000);

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
        Thread.sleep(2000);
       // Assert.assertEquals(driver.findElement(By.xpath("(//div[label[contains(text(),'Grouped Performance Criterias')]])[1]/div/label[1]/span")).getText(), );
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
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.cssSelector(".toast-message")).getText(), "NOS Created Successfully and Submitted for Approval!");

//        Assert.assertEquals(driver.findElement(By.xpath("//b[contains(text(),'"+nos_code+"')]")).getText(), nos_code);
//        Assert.assertEquals(driver.findElement(By.xpath("//b[contains(text(),'"+NOS_sector+"')]")).getText(), NOS_sector);
//        Assert.assertEquals(driver.findElement(By.xpath("//b[contains(text(),'"+date+"')]")).getText(), date);
//        Assert.assertEquals(driver.findElement(By.xpath("//b[contains(text(),'"+NOS_version+"')]")).getText(), NOS_version);

        Assert.assertEquals(driver.findElement(By.xpath("//p[contains(text(),'Your National Occupational')]")).getText(), "Your National Occupational Standard is complete and is sent to the Standard Team who will provide their review comments and take final decision on your NOS creating request.");
        Assert.assertEquals(driver.findElement(By.xpath("//p[contains(text(),'At any point of')]")).getText(), "At any point of time you can review the NOS which you have created under \" View all NOSs\"");
        
        Thread.sleep(2000);
        details.clickOnBackToDashboard();
        Thread.sleep(2000);
        model.clickOn_ViewAllNOSs();
        Thread.sleep(2000);
        SSC_ViewAllNOSsPage viewNOS = new SSC_ViewAllNOSsPage(driver);
        viewNOS.enterNOS_codeInSearchBox(nos_code);
        viewNOS.clickOnSearch();
    }
	
	@Test(dependsOnMethods="createNOS_TC_01", dataProvider="createQP_Data")
	public void createQP_TC_02(String SSC_username, String SSC_password, String country, String QP_sector, String QP_subSector, String QP_occupation, String NCO_Code, String NSQF_Level, String justification, String QPname, String brief, String attributes, String job1, String job1_specialization, String job2, String job2_specialization, String job3, String job3_specialization, String training, String licence, String age, String experience1, String experienceSpecialization1, String experience2, String experienceSpecialization2, String experience3, String experienceSpecialization3, String remarks, String normsCategory, String bucket, String tech, String service, String org, String version, String file, String elective, String electiveDescription, String option, String optionDescription, String guidelines, String thoeryMarks, String practicalMarks, String ojtMarks, String vivaMarks, String period, String attach, String qpCode) throws Exception
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
        
        String nos_code1 = ReadWriteData.getData("./TestData/Workflow/QP_NOS-Workflow.xls", "CreateNOSSC07TC01", 1, 25);
        addNOS.enterNOScodeInSearchBox(nos_code1);
        addNOS.clickOnSearch();
        Thread.sleep(2000);
        addNOS.clickOnAction();
        addNOS.clickOnLinkAsCompulsoryNOSs();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("(//div[@class='modal-header'])[1]")).getText(), "While adding this NOS to the QP, following Sectors(s) will be linked to it.");
        addNOS.clickOnLinkNos_linkAsCompulsoryNOSs();
        Thread.sleep(2000);
        
        String nos_code2 = ReadWriteData.getData("./TestData/Workflow/QP_NOS-Workflow.xls", "CreateNOSSC07TC01", 2, 25);
        addNOS.enterNOScodeInSearchBox(nos_code2);
        addNOS.clickOnSearch();
        Thread.sleep(2000);
        addNOS.clickOnAction();
        addNOS.clickOnLinkAsCompulsoryNOSs();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("(//div[@class='modal-header'])[1]")).getText(), "While adding this NOS to the QP, following Sectors(s) will be linked to it.");
        addNOS.clickOnLinkNos_linkAsCompulsoryNOSs();
        Thread.sleep(2000);
        
        String nos_code3 = ReadWriteData.getData("./TestData/Workflow/QP_NOS-Workflow.xls", "CreateNOSSC07TC01", 3, 25);
        addNOS.enterNOScodeInSearchBox(nos_code3);
        addNOS.clickOnSearch();
        Thread.sleep(2000);
        addNOS.clickOnAction();
        addNOS.clickOnLinkAsCompulsoryNOSs();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("(//div[@class='modal-header'])[1]")).getText(), "While adding this NOS to the QP, following Sectors(s) will be linked to it.");
        addNOS.clickOnLinkNos_linkAsCompulsoryNOSs();
        Thread.sleep(2000);
        /////////////////////////////////////////////////////
        String nos_code4 = ReadWriteData.getData("./TestData/Workflow/QP_NOS-Workflow.xls", "CreateNOSSC07TC01", 4, 25);
        addNOS.enterNOScodeInSearchBox(nos_code4);
        addNOS.clickOnSearch();
        Thread.sleep(2000);
        addNOS.clickOnAction();
        addNOS.clickOnLinkToElectives();
        Thread.sleep(2000);
        addNOS.enterNameOfTheElective(elective);
        addNOS.enterBriefDescriptionOfTheElective(electiveDescription);
        addNOS.clickOnLinkNOS_LinkToElectives();
        Thread.sleep(2000);
        
        ///////////////////////////////////////////
        String nos_code5 = ReadWriteData.getData("./TestData/Workflow/QP_NOS-Workflow.xls", "CreateNOSSC07TC01", 5, 25);
        addNOS.enterNOScodeInSearchBox(nos_code5);
        addNOS.clickOnSearch();
        Thread.sleep(2000);
        addNOS.clickOnAction();
        addNOS.clickOnLinkToOptions();
        Thread.sleep(2000);
        addNOS.enterNameOfTheOption(option);
        addNOS.enterBriefDescriptionOfTheOption(optionDescription);
        addNOS.clickOnLinkNOS_linkToOptions();
        Thread.sleep(2000);
        
        ////////////////////////////////////////////////////////////////
        addNOS.clickOnSaveAndContinueToAssessmentCriteria();
        Thread.sleep(2000);
        String QP_code = driver.findElement(By.xpath("//input[@formcontrolname='qpCode']")).getText();
        
        System.out.println(QP_code);
        ReadWriteData.setExcelData("./TestData/Workflow/QP_NOS-Workflow.xls", "CreateNOSSC07TC01", 46, 25, QP_code);
        SSC_QP_AssessmentCriteriaPage criteria = new SSC_QP_AssessmentCriteriaPage(driver);
        criteria.enterguidelinesForAssessment(guidelines);
        
        List<WebElement> theory = driver.findElements(By.xpath("//input[@formcontrolname='theory']"));
        List<WebElement> practical = driver.findElements(By.xpath("//input[@formcontrolname='practical']"));
        List<WebElement> ojt = driver.findElements(By.xpath("//input[@formcontrolname='ojt']"));
        List<WebElement> viva = driver.findElements(By.xpath("//input[@formcontrolname='viva']"));
        List<WebElement> total = driver.findElements(By.xpath("//input[@formcontrolname='total']"));

        for(int i=0; i<theory.size(); i++)
        {
        	WebElement th = theory.get(i);
        	th.sendKeys(thoeryMarks);
        	
        	WebElement p = practical.get(i);
        	p.sendKeys(practicalMarks);
        	
        	WebElement o = ojt.get(i);
        	o.sendKeys(ojtMarks);
        	
        	WebElement v = viva.get(i);
        	v.sendKeys(vivaMarks);
        }
        
        criteria.clickOnSubmitCriteria();
        Thread.sleep(2000);
        SSC_QP_SaveSuccessPage save = new SSC_QP_SaveSuccessPage(driver);
        save.enterReviewPeriod(period);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,-1000)");
        save.clickOnAttachDocuments();
        Thread.sleep(2000);
        save.clickOnAttachToCurrentQPOnly();
        Thread.sleep(2000);
        
        List<WebElement> browse = driver.findElements(By.id("customFile"));
        List<WebElement> upload = driver.findElements(By.xpath("//button[contains(text(),'Upload')]"));
        
        for(int i=0; i<browse.size(); i++)
        {
        	WebElement bro = browse.get(i);
        	WebElement up = upload.get(i);
        	bro.click();
        	Thread.sleep(2000);
        	UploadFile.upload(attach);
        	Thread.sleep(2000);
        	up.click();
        	Thread.sleep(5000);
        }

        save.clickOnSaveAndSubmitForApproval();
        Thread.sleep(2000);
        save.clickOnBackToDashboard();
	}
}
