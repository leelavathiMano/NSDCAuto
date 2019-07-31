package com.nsdc.regressionTest;



import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import com.nsdc.generic.ReadMultipleDataFromExcel;
import com.nsdc.generic.ReadWriteData;
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
 		return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/QualificationPack_Nos_Workflow.xls", "create_Nos");
 	}
 	@Test(dataProvider="createNosdata")
 	public void addCreateNosdata(String username , String password , String sector, String polutry,String occupation, 
 	String credits, String nsqflevel, String nosname, String nosdescripation, String nosscope , 
 	String nextreviewperiod,
 	String acronmyskeyword,
	String acronmysDescription,String glossaryKeyword,String glossaryDescription,String governmentDoc,
	String rfpDoc,String aboutsector,String labourMarketCity,String stakeholder,String occupationalmapping,
	String functionalAnalysis,String approvalQNos,String qfileQcNs,String qrcPresenation,String qrcSummarySheet,
	String otherDocument)throws Exception
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
 	Thread.sleep(3000);
 	
 	qp.createNosclick();
 	QpCreateNationalOccupationalStandardpage qpNos=new QpCreateNationalOccupationalStandardpage(driver);
 	Thread.sleep(3000);
 	
 	qpNos.clickSubSector();
 	qpNos.clickSubSectorText(polutry);
 	
 	
 	qpNos.selectOccupation(occupation);
 	qpNos.selectCredits(credits);
 	qpNos.selectNSQFlevel(nsqflevel);
// 	qpNos.setNOsName(nosname);
 	qpNos.setNOsName("NosQpCreateA");
 	qpNos.enterNOsDescription(nosdescripation);
 	qpNos.entersetNosScope(nosscope);
 	qpNos.enterSetNextReviewPeriod(nextreviewperiod);
 	qpNos.clickSaveAndContinouBtton();
 	//
 	
 	String total_element=ReadWriteData.getData("./TestData/Workflow/QualificationPack_Nos_Workflow.xls", "element_PC", 1, 0);
 	int totalelements=Integer.parseInt(total_element);
	
 	for(int i=1;i<=totalelements;i++)	
	{    
		String element=ReadWriteData.getData("./TestData/Workflow/QualificationPack_Nos_Workflow.xls", "element_PC", i, 1);
	driver.findElement( By.xpath("//input[@formcontrolname='element']")).sendKeys(element);
	Thread.sleep(2000);
	driver.findElement(By.xpath("//a[i[@class='la la-save green']]")).click();
	
	
	
	
	String numberofpc=ReadWriteData.getData("./TestData/Workflow/QualificationPack_Nos_Workflow.xls", "element_PC", 1, 2);
	int totalpc=Integer.parseInt(numberofpc);
	
	
	for(int j=1;j<=totalpc;j++)
	{      
        String pcName=ReadWriteData.getData("./TestData/Workflow/QualificationPack_Nos_Workflow.xls", "element_PC", j, 3);
        driver.findElement(By.xpath("(//textarea[@name='addText'])["+i+"]")).sendKeys(pcName);
	   driver.findElement(By.xpath("(//button[text()='+ Add PC'])["+i+"]")).click();
	   
       
        }
	 if(i<=totalelements-1)
		{
		qpNos.clickAddAnotherElement();
		
		}
	}
	Thread.sleep(3000);
	qpNos.clickSaveAndContinouBtton();
	Thread.sleep(3000);
	qpNos.clickOnAddKU();
	Thread.sleep(3000);
	
	qpNos.clickSaveAndContinouBtton();
	Thread.sleep(3000);
	qpNos.clickOnAddGS();
	qpNos.clickSaveAndContinouBtton();
	Thread.sleep(3000);

	//assessment
	 String assessement=ReadWriteData.getData("./TestData/Workflow/QualificationPack_Nos_Workflow.xls", "element_PC", 1, 4);
	 String minimumScore=ReadWriteData.getData("./TestData/Workflow/QualificationPack_Nos_Workflow.xls", "element_PC", 1, 5);
      
      
	qpNos.enterGuidelinesAssessment(assessement);
	qpNos.enterTheMinimumScore(minimumScore);
	Thread.sleep(2000);
	 String numberOfbox=ReadWriteData.getData("./TestData/Workflow/QualificationPack_Nos_Workflow.xls", "element_PC", 1, 6);
	 int n=Integer.parseInt(numberOfbox);
	 
	 
	 
	
	for(int i=1;i<=n;i++)
	{
		 String theoryMarks=ReadWriteData.getData("./TestData/Workflow/QualificationPack_Nos_Workflow.xls", "element_PC", i, 7);
		 String practicalMarks=ReadWriteData.getData("./TestData/Workflow/QualificationPack_Nos_Workflow.xls", "element_PC", i, 8);
		 String projectMarks=ReadWriteData.getData("./TestData/Workflow/QualificationPack_Nos_Workflow.xls", "element_PC", i, 9);
		 String vivamarks =ReadWriteData.getData("./TestData/Workflow/QualificationPack_Nos_Workflow.xls", "element_PC", i, 10);
		
	  driver.findElement(By.xpath("(//input[@formcontrolname='theory'])["+i+"]")).sendKeys(theoryMarks);
	  
	 
	
	 driver.findElement(By.xpath("(//input[@formcontrolname='practical'])["+i+"]")).sendKeys(practicalMarks);
	 
	 driver.findElement(By.xpath("(//input[@formcontrolname='ojt'])["+i+"]")).sendKeys(projectMarks);
	 
	
	 driver.findElement(By.xpath("(//input[@formcontrolname='viva'])["+i+"]")).sendKeys(vivamarks);	
	}
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