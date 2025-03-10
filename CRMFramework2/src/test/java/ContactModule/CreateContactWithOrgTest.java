package ContactModule;

import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.comcast.crm.generic.webutility.JavaUtility;
import com.comcast.crm.generic.webutility.WebdriverUtility;
import com.comcast.crm.genericbaseutility.BaseClass;
import com.comcast.crm.objectrepositoryutility.ContactInformationPage;
import com.comcast.crm.objectrepositoryutility.ContactPage;

import com.comcast.crm.objectrepositoryutility.CreateNewContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

import crm.comcast.crm.generic.fileutility.ExcelUtility;
import crm.comcast.crm.generic.fileutility.FileUtility;

public class CreateContactWithOrgTest  extends BaseClass{
@Test
	public void CreateContact() throws Throwable {
		
		
		
	     FileInputStream fis1 = new FileInputStream("D:\\TekPyramid\\commondata1.xlsx");
	     String orgName=elib.getDataFromExcel("contact", 6, 2) +jlib.getRandomNumber();
	     String ContactLastName =elib.getDataFromExcel("contact", 6, 3) +jlib.getRandomNumber();
	
	
	 
	       HomePage hp=new HomePage(driver);
			hp.getOrgLink().click();
			
	      //step3:click on create organization button
			OrganizationsPage op=new OrganizationsPage(driver);
			op.getCreateNewOrgBtn().click();
			Thread.sleep(4000);
		 
			//step4:Enter all the details and create organization
			CreatingNewOrganizationPage cnop=new CreatingNewOrganizationPage(driver);
			cnop.createOrg(orgName);
			Thread.sleep(4000);
		   
			String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			if(headerInfo.contains(orgName))
			{
				System.out.println(orgName + "header is verified==PASS");
			}
			else
			{
				System.out.println(orgName+ "header is not verified==FAIL");
			}
		  
		  
	          HomePage hp1=new HomePage(driver);
		      hp1.getContactLink().click();
			
		      //click on "create contact"button
		      ContactPage ccp=new ContactPage(driver);
		       ccp.getContactlink().click();
		       
	        // enter all the details and create new contact
	          driver.findElement(By.name("lastname")).sendKeys(ContactLastName);
	          driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
	           
	        //switch to child window
	          wlib.switchNewBrowserTab(driver, "module=Accounts");
	         
	          driver.findElement(By.name("search_text")).sendKeys(orgName);
	          driver.findElement(By.name("search")).click();
	          driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
	          
	          Thread.sleep(3000);
	          
	             //switch to parent window
	          wlib.switchToTabOnTitle(driver, "Contacts&action");
	          CreateNewContactPage cip1=new CreateNewContactPage(driver);
	          cip1.getSaveBtn().click();
	   
			//Verify Header msg Expected Result
	          ContactInformationPage cip=new ContactInformationPage(driver);
	          String ContactLastName1=cip.getHeaderMsg().getText();
			if(ContactLastName1.contains(ContactLastName))
			{
				System.out.println( ContactLastName1+ "header is verified==PASS");
			}
			else
			{
				System.out.println(ContactLastName1+ "header is not verified==FAIL");
	} 
			
	
	        

	}
}


