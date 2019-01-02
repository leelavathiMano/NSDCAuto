package com.nsdc.regressionTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nsdc.generic.ReadMultipleDataFromExcel;
import com.nsdc.generic.ReadWriteData;
import com.nsdc.pages.BusinessOwner_AddASchemeOwnerPage;
import com.nsdc.pages.BusinessOwner_AssignSchemePage;
import com.nsdc.pages.BusinessOwner_AssignToSchemeOwnerPage;
import com.nsdc.pages.BusinessOwner_Dashboardpage;
import com.nsdc.pages.EnterLoginPage;
import com.nsdc.pages.LoginPage;
import com.nsdc.pages.NSDCAdmin_AddBusinessOwnerPage;
import com.nsdc.pages.NSDCAdmin_CreateSchemePage;
import com.nsdc.pages.NSDCAdmin_DashboardPage;
import com.nsdc.pages.NSDCAdmin_ManageBusinessOwnersPage;
import com.nsdc.pages.NSDCAdmin_ManageUsersPage;
import com.nsdc.pages.NSDCAdmin_UserManagementPage;
import com.nsdc.pages.RegistrationPage;
import com.nsdc.pages.SchemeOwner_AddASchemeAdminPage;
import com.nsdc.pages.SchemeOwner_AssignSchemePage;
import com.nsdc.pages.SchemeOwner_AssignToSchemeAdminPage;
import com.nsdc.pages.SchemeOwner_Dashboardpage;
import com.nsdc.testConfig.TestConfiguration;

@Test
public class SchemeAdminWorkflowTestSC_21 extends TestConfiguration
{
   public String created_Bo_Username;
   public String created_So_Username;
   public String created_Sa_Username;
	
   public void login(WebDriver driver)
   {
	   LoginPage lp = new LoginPage(driver);
	   lp.clickLogin();
   }
   
   @DataProvider
   public Object[][] AddBusinessOwnerData()
   {
	   return ReadMultipleDataFromExcel.getExcelData("./TestData/Workflow/SchemeAdmin-Workflow.xls", "AddingBusinessOwner");
   }
	
   
   public static  void nsdcAdminLogin(WebDriver driver) throws Exception
   {
	   LoginPage lp = new LoginPage(driver);
	   lp.clickLogin();
	   EnterLoginPage elp = new EnterLoginPage(driver);
	   elp.performlogin("NSDCADMIN1", "Password@123");
	   Thread.sleep(10000);
   }
   
   @Test(dataProvider="AddBusinessOwnerData")
   public void addBusinessOwnerTC_01(String serialNum, String created_BO_Username, String nsdcAdmin_Username, String nsdcAdmin_Password, String name_Of_User, String mobile_Number, String email_Id, String address, String near_By_Landmark, String pincode, String state_Or_UnionTerritory, String district, String tehsil_Or_Mandal_Or_Block, String	city_Or_Village_Or_Town, String parliamentary_Constituency, String select_Scheme, String select_A_Scheme_Type, String select_A_Training_Type,  String enter_Scheme_Name, String enter_Scheme_Department_Or_Ministry, String select_Payout_Advice, String assign_To_Business_Owner,String created_So_Username, String bo_Old_Password, String bo_New_Password, String bo_Confirm_Password, String so_Full_Name, String so_Email_Address, String so_Mobile_Number,String select_Scheme_Owner,String so_Old_Password, String so_New_Password, String so_Confirm_Password, String sa_Full_Name, String sa_Email_Address, String sa_Mobile_Number, String created_Sa_Username ) throws Exception
   {
	  SchemeAdminWorkflowTestSC_21.nsdcAdminLogin(driver);
	   NSDCAdmin_DashboardPage dp = new NSDCAdmin_DashboardPage(driver); 
	   dp.clickOnUserManagement();
	   Thread.sleep(10000);
	   NSDCAdmin_UserManagementPage userManagement = new NSDCAdmin_UserManagementPage(driver);
	   userManagement.clickOnManageUsers();
	   Thread.sleep(10000);
	   NSDCAdmin_ManageUsersPage manageUsers = new NSDCAdmin_ManageUsersPage(driver);
	   manageUsers.clickOnManageBusinessOwners();
	   Thread.sleep(10000);
	   NSDCAdmin_ManageBusinessOwnersPage manageBusinessOwner = new NSDCAdmin_ManageBusinessOwnersPage(driver);
	   manageBusinessOwner.clickOnAddBusinessOwner();
	   NSDCAdmin_AddBusinessOwnerPage addBusinessOwner = new NSDCAdmin_AddBusinessOwnerPage(driver);
	   addBusinessOwner.enterNameOfTheUser(name_Of_User);
	   addBusinessOwner.enterMobileNumber(mobile_Number);
	   addBusinessOwner.enterEmailId(email_Id);
	   addBusinessOwner.enterAddress(address);
	   addBusinessOwner.enterNearByLandmark(near_By_Landmark);
	   addBusinessOwner.enterPincode(pincode);
	   JavascriptExecutor js=(JavascriptExecutor)driver;
	   js.executeScript("window.scrollBy(0,200)", "");
	   addBusinessOwner.selectStateOrUnionTerritory(state_Or_UnionTerritory);
	   addBusinessOwner.selectDistrict(district);
	   Thread.sleep(4000);
	   addBusinessOwner.selectTehsilOrMandalOrBlock(tehsil_Or_Mandal_Or_Block);
	   addBusinessOwner.selectCityOrVillageOrTown(city_Or_Village_Or_Town);
	   addBusinessOwner.selectParliamentaryConstituency(parliamentary_Constituency);
	   Thread.sleep(3000);
	   addBusinessOwner.clickOnSubmit();
	   Thread.sleep(10000);
	   Assert.assertEquals(driver.findElement(By.xpath("//h2[contains(text(),'Business Owner created successfully')]")).getText().trim(), "Business Owner created successfully");
	   String createdBusiness_Owner=driver.findElement(By.xpath("//div[contains(text(),'Business Owner ID')]")).getText();
	   created_Bo_Username = createdBusiness_Owner.replace("Business Owner ID - ", "");
	   System.out.println(created_Bo_Username);
	   addBusinessOwner.clickOnOk();
	   Thread.sleep(3000);
       ReadWriteData.setExcelData("./TestData/Workflow/SchemeAdmin-Workflow.xls", "AddingBusinessOwner", Integer.parseInt(serialNum), 1, created_Bo_Username);
       ReadWriteData.setExcelData("./TestData/Workflow/SchemeAdmin-Workflow.xls", "AddingBusinessOwner", Integer.parseInt(serialNum), 21, created_Bo_Username);
       ReadWriteData.setExcelData("./TestData/Workflow/SchemeAdmin-Workflow.xls", "AddingSchemeOwner", Integer.parseInt(serialNum), 2, created_Bo_Username);
       manageBusinessOwner.clickOnNsdcAdminDashboard();
       Thread.sleep(3000);
	   dp.clickOnCreateScheme();
	   Thread.sleep(10000);
	   NSDCAdmin_CreateSchemePage createScheme = new NSDCAdmin_CreateSchemePage(driver);
	   if(select_Scheme.equals("PMKVY")) 
	   {
		   
		   Thread.sleep(3000);
		   createScheme.selectScheme(select_Scheme);
		   createScheme.selectASchemeType(select_A_Scheme_Type);
		   Thread.sleep(4000);
		     if(select_A_Training_Type.equals("RPL")||select_A_Training_Type.equals("STT")||select_A_Training_Type.equals("India Internal")||select_A_Training_Type.equals("Special Project")||select_A_Training_Type.equals("Others"))
			 {
			   Thread.sleep(6000);
			   createScheme.selectATrainingType(select_A_Training_Type);
			   createScheme.selectPayoutAdvice(select_Payout_Advice);
			   createScheme.selectAssignToBusinessOwner(created_Bo_Username);
			 }
	   }
	   
	   else if(select_Scheme.equals("NON-PMKVY"))
	   {
		   Thread.sleep(3000);
		   createScheme.selectScheme(select_Scheme);
		   createScheme.enterSchemeName(enter_Scheme_Name);
		   createScheme.enterSchemeDepartmentOrMinistry(enter_Scheme_Department_Or_Ministry);
		   Thread.sleep(6000);
		   createScheme.selectPayoutAdvice(select_Payout_Advice);
		   createScheme.selectAssignToBusinessOwner(created_Bo_Username);   
	   }
	   
	   else if(select_Scheme.equals("Integration"))
	   {
		   Thread.sleep(3000);
		   createScheme.selectScheme(select_Scheme);
		   createScheme.enterSchemeName(enter_Scheme_Name);
		   createScheme.enterSchemeDepartmentOrMinistry(enter_Scheme_Department_Or_Ministry);
		   Thread.sleep(6000);
		   createScheme.selectPayoutAdvice(select_Payout_Advice);
		   createScheme.selectAssignToBusinessOwner(created_Bo_Username);
	   }
	   
	   Thread.sleep(3000);
	   createScheme.clickOnSubmitAndAssignToBusinessAdmin();
	   Thread.sleep(3000);
	   Assert.assertEquals(driver.findElement(By.xpath("//h2[contains(text(),'scheme created and assigned successfully')]")).getText(), "scheme created and assigned successfully");
	   createScheme.clickOnOk();
	   Thread.sleep(3000);
	   dp.clickOnNSDCProfile();
       Thread.sleep(4000);
       dp.clickOnNSDCLogOut();
       Thread.sleep(4000);
	   LoginPage lp = new LoginPage(driver);
	   lp.clickLogin();
	   EnterLoginPage elp = new EnterLoginPage(driver);
       elp.performlogin(created_Bo_Username, "ekaushal");
       Thread.sleep(2000);
       RegistrationPage rp = new RegistrationPage(driver);
       rp.enterOldPassword(bo_Old_Password);
       rp.enterNewPassword(bo_New_Password);
       rp.enterConfirmPassword(bo_Confirm_Password);
       rp.clickResetResubmit();
       Thread.sleep(2000);
       rp.clickConfirmationOkMessage();
       elp.performlogin(created_Bo_Username, bo_Confirm_Password);
       Thread.sleep(10000);
	   BusinessOwner_Dashboardpage bo_Dashboard = new BusinessOwner_Dashboardpage(driver);
	   bo_Dashboard.clickOnAddASchemeOwner();
	   BusinessOwner_AddASchemeOwnerPage addSchemeOwner = new BusinessOwner_AddASchemeOwnerPage(driver);
	   addSchemeOwner.enterFullName(so_Full_Name);
	   addSchemeOwner.enterEmailAddress(so_Email_Address);
	   addSchemeOwner.enterMobileNumber(so_Mobile_Number);	   
	   addSchemeOwner.clickOnSubmit();
	   String createdScheme_Owner=driver.findElement(By.xpath("//h2[contains(text(),'Scheme Admin created. Please save the username: ')]")).getText();
	   created_So_Username = createdScheme_Owner.replace("Scheme Admin created. Please save the username: ", "");
	   System.out.println(created_So_Username);
       ReadWriteData.setExcelData("./TestData/Workflow/SchemeAdmin-Workflow.xls", "AddingBusinessOwner", Integer.parseInt(serialNum), 22, created_So_Username);
       ReadWriteData.setExcelData("./TestData/Workflow/SchemeAdmin-Workflow.xls", "AddingBusinessOwner", Integer.parseInt(serialNum), 29, created_So_Username);
       String soConfirmationMsg = "Scheme Admin created. Please save the username: "+created_So_Username;
       System.out.println(soConfirmationMsg);
	   Assert.assertEquals(driver.findElement(By.xpath("//div[h2[contains(text(),'Scheme Admin created.')]]")).getText().trim(), soConfirmationMsg);
	   Thread.sleep(4000);
	   addSchemeOwner.clickOnOk();
	   Thread.sleep(4000);
	   bo_Dashboard.clickOnAssignToSchemeOwner();
	   BusinessOwner_AssignToSchemeOwnerPage assignSchemeOwner = new BusinessOwner_AssignToSchemeOwnerPage(driver);
	   if(select_A_Training_Type.equals("RPL"))
	   {
		   Thread.sleep(4000);
	       assignSchemeOwner.clickOnRplAction();
	       Thread.sleep(5000);
		   assignSchemeOwner.clickOnRplAssignScheme();
	   }
	   else if(select_A_Training_Type.equals("STT"))
	   {
		   Thread.sleep(4000);
		   assignSchemeOwner.clickOnSTTAction();
		   Thread.sleep(5000);
		   assignSchemeOwner.clickOnSTTAssignScheme();
	   }
	   else if(select_A_Training_Type.equals("India Internal"))
	   {
		   Thread.sleep(4000);
		   assignSchemeOwner.clickOnIndiaInternalAction();
		   Thread.sleep(5000);
		   assignSchemeOwner.clickOnIndiaInternalAssignScheme();
	   }
	   else if(select_A_Training_Type.equals("Special Project"))
	   {
		   Thread.sleep(4000);
		   assignSchemeOwner.clickOnSpecialProjectAction();
		   Thread.sleep(5000);
		   assignSchemeOwner.clickOnSpecialProjectAssignScheme();
	   }
	   else if(select_A_Training_Type.equals("Others"))
	   {
		   Thread.sleep(4000);
		   assignSchemeOwner.clickOnOthersAction();
		   Thread.sleep(5000);
		   assignSchemeOwner.clickOnOthersAssignScheme();
	   }
	   else if(select_Scheme.equals("NON-PMKVY"))
	   {
		   Thread.sleep(4000);
		   assignSchemeOwner.clickOnNonPMKVYAction();
		   Thread.sleep(5000);
		   assignSchemeOwner.clickOnNonPMKVYAssignScheme();
	   }
	   else if(select_Scheme.equals("Integration"))
	   {
		   Thread.sleep(4000);
		   assignSchemeOwner.clickOnIntegrationAction();
		   Thread.sleep(5000);
		   assignSchemeOwner.clickOnIntegrationAssignScheme();
	   }
	   
	   Thread.sleep(3000);
	   BusinessOwner_AssignSchemePage assignScheme = new BusinessOwner_AssignSchemePage(driver);
	   assignScheme.selectSchemeOwner(created_So_Username);
	   Thread.sleep(3000);
	   assignScheme.clickOnSubmitAndAssignScheme();
	   Assert.assertEquals(driver.findElement(By.xpath("//div[h2[contains(text(),'scheme assigned successfully')]]")).getText().trim(), "scheme assigned successfully");
	   assignScheme.clickOnOk();
	   Thread.sleep(5000);
	   bo_Dashboard.clickOnBOProfile();
	   Thread.sleep(5000);
	   bo_Dashboard.clickOnBOLogOut();
	   LoginPage lp1 = new LoginPage(driver);
	   lp.clickLogin();
	   EnterLoginPage elp1 = new EnterLoginPage(driver);
       elp.performlogin(created_So_Username, "ekaushal");
       Thread.sleep(3000);
       RegistrationPage rp1 = new RegistrationPage(driver);
       rp.enterOldPassword(so_Old_Password);
       rp.enterNewPassword(so_New_Password);
       rp.enterConfirmPassword(so_Confirm_Password);
       rp.clickResetResubmit();
       Thread.sleep(2000);
       rp.clickConfirmationOkMessage();
       elp.performlogin(created_So_Username, so_Confirm_Password);
       Thread.sleep(10000);
       SchemeOwner_Dashboardpage so_Dashboard = new SchemeOwner_Dashboardpage(driver);
       so_Dashboard.clickOnAddASchemeAdmin();
       SchemeOwner_AddASchemeAdminPage addSchemeAdmin = new SchemeOwner_AddASchemeAdminPage(driver);
       addSchemeAdmin.enterFullName(sa_Full_Name);
       addSchemeAdmin.enterEmailAddress(sa_Email_Address);
       addSchemeAdmin.enterMobileNumber(sa_Mobile_Number);
       Thread.sleep(3000);
       addSchemeAdmin.clickOnSubmit();
       String createdScheme_Admin=driver.findElement(By.xpath("//h2[contains(text(),'Scheme Admin created. Please save the username: ')]")).getText();
	   created_Sa_Username = createdScheme_Admin.replace("Scheme Admin created. Please save the username: ", "");
	   System.out.println(created_Sa_Username);
       ReadWriteData.setExcelData("./TestData/Workflow/SchemeAdmin-Workflow.xls", "AddingBusinessOwner", Integer.parseInt(serialNum), 36, created_Sa_Username);;
       String saConfirmationMsg = "Scheme Admin created. Please save the username: "+created_Sa_Username;
       System.out.println(saConfirmationMsg);
	   Assert.assertEquals(driver.findElement(By.xpath("//div[h2[contains(text(),'Scheme Admin created.')]]")).getText().trim(), saConfirmationMsg);
	   Thread.sleep(4000);
	   addSchemeOwner.clickOnOk();
	   Thread.sleep(4000);
	   so_Dashboard.clickOnAssignToSchemeAdmin();
	  SchemeOwner_AssignToSchemeAdminPage assignSchemeAdmin = new SchemeOwner_AssignToSchemeAdminPage(driver);
	   if(select_A_Training_Type.equals("RPL"))
	   {
		   Thread.sleep(4000);
		   assignSchemeAdmin.clickOnRplAction();
	       Thread.sleep(5000);
	       assignSchemeAdmin.clickOnRplAssignScheme();
	   }
	   else if(select_A_Training_Type.equals("STT"))
	   {
		   Thread.sleep(4000);
		   assignSchemeAdmin.clickOnSTTAction();
		   Thread.sleep(5000);
		   assignSchemeAdmin.clickOnSTTAssignScheme();
	   }
	   else if(select_A_Training_Type.equals("India Internal"))
	   {
		   Thread.sleep(4000);
		   assignSchemeAdmin.clickOnIndiaInternalAction();
		   Thread.sleep(5000);
		   assignSchemeAdmin.clickOnIndiaInternalAssignScheme();
	   }
	   else if(select_A_Training_Type.equals("Special Project"))
	   {
		   Thread.sleep(4000);
		   assignSchemeAdmin.clickOnSpecialProjectAction();
		   Thread.sleep(5000);
		   assignSchemeAdmin.clickOnSpecialProjectAssignScheme();
	   }
	   else if(select_A_Training_Type.equals("Others"))
	   {
		   Thread.sleep(4000);
		   assignSchemeAdmin.clickOnOthersAction();
		   Thread.sleep(5000);
		   assignSchemeAdmin.clickOnOthersAssignScheme();
	   }
	   else if(select_Scheme.equals("NON-PMKVY"))
	   {
		   Thread.sleep(4000);
		   assignSchemeAdmin.clickOnNonPMKVYAction();
		   Thread.sleep(5000);
		   assignSchemeAdmin.clickOnNonPMKVYAssignScheme();
	   }
	   else if(select_Scheme.equals("Integration"))
	   {
		   Thread.sleep(4000);
		   assignSchemeAdmin.clickOnIntegrationAction();
		   Thread.sleep(5000);
		   assignSchemeAdmin.clickOnIntegrationAssignScheme();
	   }
	  
	   SchemeOwner_AssignSchemePage assignSchemeToSA = new SchemeOwner_AssignSchemePage(driver);
	   assignSchemeToSA.selectSchemeOwner(created_Sa_Username);
	   Thread.sleep(3000);
	   assignSchemeToSA.clickOnSubmitAndAssignScheme();
	   Assert.assertEquals(driver.findElement(By.xpath("//div[h2[contains(text(),'scheme assigned successfully')]]")).getText().trim(), "scheme assigned successfully");
	   assignSchemeToSA.clickOnOk();
	   Thread.sleep(4000);
	   so_Dashboard.clickOnSOProfile();
	   Thread.sleep(4000);
	   so_Dashboard.clickOnSOLogOut();
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	     
   }
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
  
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
	
   
}
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   

