package OraganizationModule;

 import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;



import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.generic.webutility.JavaUtility;
import com.comcast.crm.generic.webutility.WebdriverUtility;
import com.comcast.crm.genericbaseutility.BaseClass;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
import com.google.common.base.Throwables;

import crm.comcast.crm.generic.fileutility.ExcelUtility;
import crm.comcast.crm.generic.fileutility.FileUtility;

    import crm.comcast.crm.generic.fileutility.FileUtility;

       public class CreateOraganizationTest extends BaseClass {
    	    @Test(groups= {"smokeTest","regressionTest"})
	   public void CreateOrganization() throws  Throwable{
	    	
		
           FileInputStream fis1 = new FileInputStream("D:\\TekPyramid\\commondata1.xlsx");
		 String orgName=elib.getDataFromExcel("org", 1, 2) +jlib.getRandomNumber();
		
		 	HomePage hp=new HomePage(driver);
			hp.getOrgLink().click();
			
		   
			 //step3:click on create organization button
			  OrganizationsPage cnp=new OrganizationsPage(driver);
		                cnp.getCreateNewOrgBtn().click();
			
		   //step4:Enter all the details and create organization
		     CreatingNewOrganizationPage cnop=new CreatingNewOrganizationPage(driver);
				   cnop.createOrg(orgName);
				  
			
	
			  OrganizationInformationPage oip=new OrganizationInformationPage(driver);
			  String headerOrgName=oip.getHeaderMsg().getText();
			  
	          if(headerOrgName.contains(orgName)) {
				  System.out.println(orgName + "name is verified==PASS");
			  }else
			  {
				  System.out.println(orgName + "name is not verified==FAIL");  
				  Assert.assertTrue(headerOrgName.contains(orgName));
    	    }   
				  
			//Verify Headre orgname info Expected Result
			String actOrgName=driver.findElement(By.id("mouseArea_Organization Name")).getText();
			Assert.assertEquals(actOrgName.trim(), orgName);
    	    }
			  
		
	
 @Test(groups= {"smokeTest","regressionTest"})
 public void createOraganizationWithIndustriesTest() throws Throwable
 {
	 String orgName=elib.getDataFromExcel("org", 4, 2)+jlib.getRandomNumber();
	 String Industries=elib.getDataFromExcel("org", 4, 3);
	 String  Type=elib.getDataFromExcel("org", 4, 4);
	
	    HomePage hp=new HomePage(driver);
		hp.getOrgLink().click();
		
		  //step3:click on create organization button
		 OrganizationsPage cnp=new OrganizationsPage(driver);
         cnp.getCreateNewOrgBtn().click();
        
         //step4:Enter all the details and create organization
         CreatingNewOrganizationPage cnop=new CreatingNewOrganizationPage (driver);
        cnop.createOrg(orgName, Industries, Type);
         
          OrganizationInformationPage oip=new OrganizationInformationPage(driver);
			 String  headerIndusties=oip.getHeaderInduMsg().getText();
        if(headerIndusties.contains(Industries))
			{
				System.out.println(Industries+ "information is verified==PASS");
			}
			else
			{
				System.out.println(Industries+ "information is not  verified==FAIL");
				assertTrue(headerIndusties.trim().contains(Industries));
			} 
		
        OrganizationInformationPage oip1=new OrganizationInformationPage(driver);
        String headerType=oip1.getHeaderTypeMsg().getText();
			if(headerType.equals(Type))
			{
				System.out.println(Type+ "information is verified==PASS");
			}
			else
			{
				System.out.println(Type+ "information is not verified==FAIL");
				assertTrue(headerType.trim().equals(Type));
			}

}


 
 @Test(groups= {"smokeTest","regressionTest"})
 public void createOrgWithPhoneNumberTest() throws Throwable
 {
		
	 String orgName=elib.getDataFromExcel("org", 7, 2)+jlib.getRandomNumber();		
		 String phoneNumber=elib.getDataFromExcel("org", 7, 3);
		
			
			//step2:navigate to organization module
			 HomePage hp=new HomePage(driver);
			 hp.getOrgLink().click();
			 
		   //step3:click on create organization button
			 OrganizationsPage cnp=new OrganizationsPage(driver);
                cnp.getCreateNewOrgBtn().click();
	
		   //step4:Enter all the details and create organization
		   
                CreatingNewOrganizationPage cnop=new CreatingNewOrganizationPage(driver); 
               cnop.createOrgWithPhone(orgName, phoneNumber);
                   Thread.sleep(2000);
			//Verify Header msg Expected Result

  			  OrganizationInformationPage oip=new OrganizationInformationPage(driver);
  			  String actOrgName=oip.getHeaderMsg().getText();
  			  boolean status=actOrgName.contains(orgName);
  			  Assert.assertEquals(status, true);
  			
  				  
			//Verify  header phonenumber info Expected Result
  			  
  			 OrganizationInformationPage oip1=new OrganizationInformationPage(driver);
  			  String headerphoneNumber=oip1.getHearderphmsg().getText();
  			if(headerphoneNumber.equals(phoneNumber))
			{
				System.out.println( phoneNumber+ " information is created==PASS");
			}
			else
			{
				System.out.println( phoneNumber+ " inforamation is not created==FAIL");
				assertTrue(headerphoneNumber.trim().equals(phoneNumber));
			}
		
 }
}