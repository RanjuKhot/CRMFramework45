package OraganizationModule;

import java.io.FileInputStream;

import java.time.Duration;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
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

public class CreateOrganizationWithIndustriesTest extends BaseClass {
 @Test
	public void CreateOraganization() throws Throwable {
  
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
 			 String  actIndusties=oip.getHeaderInduMsg().getText();
            if(actIndusties.contains(Industries))
 			{
 				System.out.println(Industries+ "information is verified==PASS");
 			}
 			else
 			{
 				System.out.println(Industries+ "information is not  verified==FAIL");
 			} 
			
            OrganizationInformationPage oip1=new OrganizationInformationPage(driver);
            String actType=oip1.getHeaderTypeMsg().getText();
				if(actType.equals(Type))
				{
					System.out.println(Type+ "information is verified==PASS");
				}
				else
				{
					System.out.println(Type+ "information is not verified==FAIL");
				}
	
	}

}
