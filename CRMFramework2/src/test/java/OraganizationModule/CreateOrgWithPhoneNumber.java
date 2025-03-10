package OraganizationModule;

import java.io.FileInputStream;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.comcast.crm.generic.webutility.JavaUtility;
import com.comcast.crm.generic.webutility.WebdriverUtility;
import com.comcast.crm.genericbaseutility.BaseClass;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

import crm.comcast.crm.generic.fileutility.ExcelUtility;
import crm.comcast.crm.generic.fileutility.FileUtility;

public class CreateOrgWithPhoneNumber  extends BaseClass{
	@Test

	public void CreateOraganization() throws Throwable {
		
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
	  			  if(actOrgName.contains(orgName)) {
	  				  System.out.println(orgName + "name is verified==PASS");
	  			  }else
	  			  {
	  				  System.out.println(orgName + "name is not verified==FAIL");
	  			  }
	  				  
				//Verify Headre orgname info Expected Result
	  			  
	  			 OrganizationInformationPage oip1=new OrganizationInformationPage(driver);
	  			  String actphoneNumber=oip1.getHearderphmsg().getText();
	  			if( actphoneNumber.equals(actphoneNumber))
				{
					System.out.println( actphoneNumber+ " information is created==PASS");
				}
				else
				{
					System.out.println( actphoneNumber+ " inforamation is not created==FAIL");
				}
			
    hp.logout();
	}

}
