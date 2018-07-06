package com.nsdc.regressionTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nsdc.generic.ReadMultipleDataFromExcel;
import com.nsdc.generic.UploadFile;
import com.nsdc.pages.EnterLoginPage;
import com.nsdc.pages.LoginPage;
import com.nsdc.pages.NOS_GeneralDetailsPage;
import com.nsdc.pages.QP_GeneralDetailsPage;
import com.nsdc.pages.QP_NOS_Model_CurriculumPage;
import com.nsdc.pages.SSC_DashboardPage;
import com.nsdc.pages.SSC_ViewAllNOSsPage;
import com.nsdc.testConfig.TestConfiguration;

public class QP_NOS_WorkflowTestSC_07 extends TestConfiguration
{
	@DataProvider
	public Object[][] createNOS_QP_Data()
	{
	    return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/QP_NOS-Workflow.xls", "CreateNOS_QPSC07TC01");
	}
	 
	@Test(dataProvider="createNOS_QP_Data")
    public void createNOS_QP_TC_01(String SSC_username, String SSC_password, String NOS_sector, String NOS_subSector, String occupation, String credits, String NSQF_level, String NOS_name, String NOS_version, String NOS_description, String NOS_scope, String criteria1, String criteria2, String criteria3, String element1, String element2, String element3, String parameter1, String parameter2, String parameter3, String skill1, String skill2, String skill3, String date, String country, String QP_sector, String QP_subSector, String QP_occupation, String NCO_Code, String NSQF_Level, String justification, String QPname, String brief, String attributes, String job1, String job1_specialization, String job2, String job2_specialization, String job3, String job3_specialization, String training, String licence, String age, String experience1, String experienceSpecialization1, String experience2, String experienceSpecialization2, String experience3, String experienceSpecialization3, String remarks, String normsCategory, String bucket, String tech, String service, String org, String version, String file) throws Exception
    {
		LoginPage lp = new LoginPage(driver);
        EnterLoginPage elp = new EnterLoginPage(driver);
        lp.clickLogin();
        elp.performlogin(SSC_username, SSC_password);
        Thread.sleep(4000);
        
        SSC_DashboardPage dashboard = new SSC_DashboardPage(driver);
        dashboard.clickOn_QP_NOS_ModelCurriculum();
        QP_NOS_Model_CurriculumPage model = new QP_NOS_Model_CurriculumPage(driver);
        model.clickOn_CreateNOS();
        NOS_GeneralDetailsPage details = new NOS_GeneralDetailsPage(driver);
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
        
        details.enterKnowledgeParameter1(parameter1);
        details.clickOnAddAnotherKnowledgeParameter();
        details.enterKnowledgeParameter2(parameter2);
        details.clickOnAddAnotherKnowledgeParameter();
        details.enterKnowledgeParameter3(parameter3);
        details.clickOnSaveAndContinueToNextStep();
        Thread.sleep(2000);
     //   Assert.assertEquals(driver.findElement(By.cssSelector(".toast-message")).getText(), "NOS Updated Successfully");
        details.enterGenericSkillsParameter1(skill1);
        details.clickOnAddAnotherGenericSkillsParameter();
        details.enterGenericSkillsParameter2(skill2);
        details.clickOnAddAnotherGenericSkillsParameter();
        details.enterGenericSkillsParameter3(skill3);
        details.clickOnSaveAndContinueToNextStep();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.cssSelector(".toast-message")).getText(), "NOS Updated Successfully");
        
        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'Your National Occupational Standard is almost complete')]")).getText(), "Your National Occupational Standard is almost complete, kindly review the same before sending to the Standard Team who will provide there review comments and take final decision on your final submit of the NOS.");
        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'At any point of time you')]")).getText(), "At any point of time you can review the NOS which you have created under \" View all NOSs \"");
        
        details.enterNextReviewDate(date);
        details.clickOnCalendarLogo();
        details.clickOnSubmitForApproval();
        Assert.assertEquals(driver.findElement(By.cssSelector(".toast-message")).getText(), "NOS Updated Successfully");

        Assert.assertEquals(driver.findElement(By.xpath("//b[contains(text(),'"+nos_code+"')]")).getText(), nos_code);
        Assert.assertEquals(driver.findElement(By.xpath("//b[contains(text(),'"+NOS_sector+"')]")).getText(), NOS_sector);
        Assert.assertEquals(driver.findElement(By.xpath("//b[contains(text(),'"+date+"')]")).getText(), date);
        Assert.assertEquals(driver.findElement(By.xpath("//b[contains(text(),'"+NOS_version+"')]")).getText(), NOS_version);

        Assert.assertEquals(driver.findElement(By.xpath("//p[contains(text(),'Your National Occupational')]")).getText(), "Your National Occupational Standard is complete and is sent to the Standard Team who will provide their review comments and take final decision on your NOS creating request.");
        Assert.assertEquals(driver.findElement(By.xpath("//p[contains(text(),'At any point of')]")).getText(), "At any point of time you can review the NOS which you have created under \" View all NOSs\"");

        details.clickOnBackToDashboard();
        Thread.sleep(2000);
        model.clickOn_ViewAllNOSs();
        SSC_ViewAllNOSsPage viewNOS = new SSC_ViewAllNOSsPage(driver);
        viewNOS.enterNOS_codeInSearchBox(nos_code);
        viewNOS.clickOnSearch();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+NOS_name+"')]")).getText(), NOS_name);
        Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+nos_code+"')]")).getText(), nos_code);
        Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+NOS_version+"')]")).getText(), NOS_version);
        Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+NOS_sector+"')]")).getText(), NOS_sector);
        Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+NOS_subSector+"')]")).getText(), NOS_subSector);
        Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'"+NSQF_level+"')]")).getText(), NSQF_level);
        Assert.assertEquals(driver.findElement(By.xpath("(//td[contains(text(),'Awaiting Standards Approval')])[1]")).getText(), "Awaiting Standards Approval");
        
        dashboard.clickOn_QP_NOS_ModelCurriculum();
        Thread.sleep(2000);
        model.clickOn_CreateQP();
        Thread.sleep(2000);
        QP_GeneralDetailsPage QP = new QP_GeneralDetailsPage(driver);
        QP.selectCountryOfOrigin();
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
        
        Assert.assertEquals(driver.findElement(By.xpath("//input[@formcontrolname='ctgryDesc']")).getAttribute("value"), normsCategory);
        QP.selectBucket(bucket);
        QP.selectTechnicalOrNonTechnical(tech);
        QP.selectManufacturingOrServices(service);
        QP.selectOrganizedOrUnorganized(org);
        QP.enterQP_Version(version);
        QP.clickOnBrowseForQP_image();
        Thread.sleep(2000);
        UploadFile.upload(file);
        QP.clickOnuploadForQP_image();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.cssSelector(".toast-message")).getText(), "File uploaded successfully");
        Assert.assertTrue(driver.findElement(By.cssSelector(".fa.fa-check")).isDisplayed());
        QP.clickOnSaveAndContinue();
        
    }
	
	@Test
	public void QP_addAnotherQPsNOS_TC_02()
	{
		
	}
    

	@Test
	public void editNOS_TC_02()
	{
		
	}
}
