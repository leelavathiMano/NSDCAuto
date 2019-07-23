package com.nsdc.regressionTest;



import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nsdc.generic.ReadMultipleDataFromExcel;
import com.nsdc.generic.UploadFile;
import com.nsdc.pages.BetaVersionOfSmartPage;
import com.nsdc.pages.EnterLoginPage;
import com.nsdc.pages.LoginPage;
import com.nsdc.pages.PostLoginPage;
import com.nsdc.pages.QpCreateNationalOccupationalStandardpage;
import com.nsdc.pages.Qpnos_createpage;
import com.nsdc.pages.SSC_DashboardPage;
import com.nsdc.testConfig.TestConfiguration;

public class QpNosWorkflowTestSC_23  extends TestConfiguration
{
	@DataProvider
	public Object[][]createNosdata()
	{
		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/QualificationPack_Nos_Workflow.xls", "create_Nos_fields");
	}
	@Test(dataProvider="createNosdata")
	public void addCreateNosdata(String username , String password , String sector, String polutry,String occupation, 
	String credits, String nsqflevel, String nosname, String nosdescripation, String nosscope , 
	String nextreviewperiod, String elementname,String enterTheperformanceCriteria,String yes,
	String knowledgeAndUnderstaningTextbox,String genericskill,String assessment,String minimumScore,
	String theoryMarks,String practicalMarks,String projectMarks,String vivamarks,String acronmyskeyword,
	String acronmysDescription,String glossaryKeyword,String glossaryDescription,String governmentDoc,
	String rfpDoc,String aboutsector,String labourMarketCity,String stakeholder,String occupationalmapping,
	String functionalAnalysis,String approvalQNos,String qfileQcNs,String qrcPresenation,String qrcSummarySheet,
	String otherDocument) throws Exception
	{
		LoginPage lp = new LoginPage(driver);
		lp.clickLogin();
		Thread.sleep(3000);
		BetaVersionOfSmartPage bvsp=new BetaVersionOfSmartPage(driver);
		
		bvsp.clickToClose();
		
		EnterLoginPage ep=new EnterLoginPage(driver);
		ep.performlogin(username, password);
		
		SSC_DashboardPage sscDp=new SSC_DashboardPage(driver);
		sscDp.clickOn_QP_NOS_ModelCurriculum();
		
		Thread.sleep(3000);
	
	Qpnos_createpage qp=new Qpnos_createpage (driver);
	
	qp.createNosclick();
	QpCreateNationalOccupationalStandardpage qpNos=new QpCreateNationalOccupationalStandardpage(driver);
	Thread.sleep(3000);
	
	qpNos.clickSubSector();
	qpNos.clickSubSectorText(polutry);
	
	
	qpNos.selectOccupation(occupation);
	qpNos.selectCredits(credits);
	qpNos.selectNSQFlevel(nsqflevel);
//	qpNos.setNOsName(nosname);
	qpNos.setNOsName("suprafhaa");
	qpNos.enterNOsDescription(nosdescripation);
	qpNos.entersetNosScope(nosscope);
	qpNos.enterSetNextReviewPeriod(nextreviewperiod);
	qpNos.clickSaveAndContinouBtton();
	//
	//WebElement actual = driver.findElement(By.xpath("(//span[@class='color-info'])[2]"));
	
	//String expected="NoS'F'";
	//if(actual.equals(expected)) 
	//{
	//	System.out.println("Nos name should be displyed");
	//}
	Thread.sleep(3000);
	qpNos.enterTheFirstElement(elementname);
	qpNos.clickSaveButton();
	Thread.sleep(3000);
	qpNos.enterThePerformanceCriteria(enterTheperformanceCriteria);
	qpNos.clickOnAddPc();
	qpNos.clickSaveAndContinouBtton();
	Thread.sleep(3000);
	//KU
	qpNos.enterTheKnowledgeAndUnderstandingTextbox(knowledgeAndUnderstaningTextbox);
	qpNos.clickOnAddKU();
	qpNos.clickSaveAndContinouBtton();
	Thread.sleep(3000);
	//GS
	qpNos.enterTheGenericSkill(genericskill);
	Thread.sleep(3000);
	qpNos.clickOnAddGS();
	
	qpNos.clickSaveAndContinouBtton();
	Thread.sleep(3000);
	//Assessment
	qpNos.enterGuidelinesAssessment(assessment);
	qpNos.enterTheMinimumScore(minimumScore);
	qpNos.enterTheTheoryMarks(theoryMarks);
	qpNos.enterThePracticalMarks(practicalMarks);
	qpNos.enterTheProjectMarks(projectMarks);
	qpNos.enterTheVivaMarks(vivamarks);

	qpNos.clickSaveAndContinouBtton();
	//Acronyms
	Thread.sleep(3000);
	qpNos.enterAcronymsKeyword(acronmyskeyword);
	qpNos.enterAcronymsDescription(acronmysDescription);
	qpNos.enterGlossaryKeyword(glossaryKeyword);
	qpNos.enterGlossaryDescription(glossaryDescription);
	//
	Thread.sleep(2000);
	qpNos.clickGoveranceDocuments();
	Thread.sleep(2000);
	UploadFile.upload(governmentDoc);
	Thread.sleep(3000);
	qpNos.clickGoveranceDocumentsUploadButton();
	Thread.sleep(4000);
	////JavascriptExecutor js=(JavascriptExecutor)driver;
	
	//js.executeScript("arguments[0].click();", driver.findElement(By.xpath("(//label[@for='customFile'])[2]")));
//	JavascriptExecutor js=(JavascriptExecutor)driver;
//	js.executeScript("window.scrollBy(0,200)");
//	js.executeScript("arguments[0].click();", driver.findElement(By.xpath("(//input[@id='customFile'])[2]")));
//	Thread.sleep(1000);
//	WebDriverWait wait=new WebDriverWait(driver,10);
//	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='customFile'])[2]")));
	
	qpNos.clickRFPDocuments();
	Thread.sleep(5000);
	UploadFile.upload(rfpDoc);
	Thread.sleep(5000);
	qpNos.clickRFPDocumentsUploadButton();
	Thread.sleep(5000);
	//
	qpNos.clickAboutSector();
	Thread.sleep(2000);
	UploadFile.upload(aboutsector);
	Thread.sleep(3000);
	qpNos.clickAboutSectorUploadButton();
	Thread.sleep(5000);
	//
	qpNos.clickLabourMarketCity();
	Thread.sleep(2000);
	UploadFile.upload(labourMarketCity);
	Thread.sleep(3000);
	qpNos.clicklabourMarketCityUploadButton();
	Thread.sleep(5000);
	//
	qpNos.clickStakeHolderEnagged();
	Thread.sleep(1000);
	UploadFile.upload(stakeholder);
	Thread.sleep(3000);
	qpNos.clickStakeHolderEnaggeduploadButton();
	Thread.sleep(3000);
	//
	qpNos.clickOccupationalMapping();
	Thread.sleep(1000);
	UploadFile.upload(occupationalmapping);
	Thread.sleep(3000);
	qpNos.clickOccupationalMappinguploadButton();
	Thread.sleep(3000);
	//
	qpNos.clickFunctionalAnalysis();
	Thread.sleep(1000);
	UploadFile.upload(functionalAnalysis);
	Thread.sleep(3000);
	qpNos.clickFunctionalAnalysisuploadButton();
	Thread.sleep(3000);
	//
	qpNos.clickApprovalForQpNos();
	Thread.sleep(1000);
	UploadFile.upload(approvalQNos);
	Thread.sleep(3000);
	qpNos.clickApprovalForQpNosuploadButton();
	Thread.sleep(3000);
	//
	qpNos.clickQfilesNSQC();
	Thread.sleep(1000);
	UploadFile.upload(qfileQcNs);
	Thread.sleep(3000);
	qpNos.clickQfilesNSQCuploadButton();
	Thread.sleep(3000);
	//
	qpNos.clickQRCPresentationBrowser();
	Thread.sleep(1000);
	UploadFile.upload(qrcPresenation);
	Thread.sleep(3000);
	qpNos.clickQRCPresentationUploadButton();
	Thread.sleep(3000);
	//
	qpNos.clickQRCSummarySheetBrowseButton();
	Thread.sleep(1000);
	UploadFile.upload(qrcSummarySheet);
	Thread.sleep(3000);
	qpNos.clickQRCSummarySheetUploadButton();
	Thread.sleep(3000);
	//
	qpNos.clickotherDocumentsBrowseButton();
	Thread.sleep(1000);
	UploadFile.upload(otherDocument);
	Thread.sleep(3000);
	qpNos.clickotherDocumentsUploadButton();
	Thread.sleep(3000);
	//
	qpNos.clicksaveAndExitButton();
	Thread.sleep(1000);
	qpNos.clickOkButton();
	Thread.sleep(1000);
	qpNos.clickOkButton();
	PostLoginPage plp=new PostLoginPage(driver);
	Thread.sleep(3000);
	plp.clickOnProfileLogo();
	Thread.sleep(2000);
	plp.clickOnLogout();
	}
}