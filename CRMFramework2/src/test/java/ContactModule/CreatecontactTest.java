package ContactModule;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

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
import com.comcast.crm.objectrepositoryutility.ContactInformationPage;
import com.comcast.crm.objectrepositoryutility.ContactPage;

import com.comcast.crm.objectrepositoryutility.CreateNewContactPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

import crm.comcast.crm.generic.fileutility.ExcelUtility;
import crm.comcast.crm.generic.fileutility.FileUtility;


public class CreatecontactTest  extends BaseClass{

	@Test(groups= {"smokeTest","regressionTest"})
	public void CreateContact() throws Throwable {
		

	     FileInputStream fis1 = new FileInputStream("D:\\TekPyramid\\commondata1.xlsx");
		 String LastName=elib.getDataFromExcel("contact", 1, 2) +jlib.getRandomNumber();
				

           //step2:navigate to contact module
		      HomePage hp=new HomePage(driver);
		      hp.getContactLink().click();
			
		    //step3:click on "create contact"button
		    ContactPage ccp=new ContactPage(driver);
		       ccp.getContactlink().click();
			
		       //step4: enter all the details and create new contact
		       CreateNewContactPage cip=new  CreateNewContactPage(driver);
		       cip.createlastname(LastName);
			
			//Verify Header msg Expected Result
		      ContactInformationPage cip1= new ContactInformationPage(driver);
		     String lastName = cip1.getHeaderMsg().getText();
		
		   if(lastName.contains(LastName))
			{
				System.out.println( lastName + "inforamation is verified ==PASS");
			}
			else
			{
				System.out.println( lastName + "inforamation is not verified ==FAIL");
				assertTrue(lastName.trim().contains(LastName));
			}  
	  	
			String actLastName1 = driver.findElement(By.id("dtlview_Last Name")).getText();
			assertEquals(actLastName1.trim(), LastName);
			

	}


@Test(groups= {"smokeTest","regressionTest"})
public  void CreateContactWithSupportdate() throws Throwable {
	
	
     FileInputStream fis1 = new FileInputStream("D:\\TekPyramid\\commondata1.xlsx");
	 String LastName=elib.getDataFromExcel("contact", 1, 2) +jlib.getRandomNumber();
   
            //step2:navigate to contact module
	         HomePage hp=new HomePage(driver);
		      hp.getContactLink().click();
			
		      //step3:click on "create contact"button
		      ContactPage ccp=new ContactPage(driver);
		       ccp.getContactlink().click();
		       
		       String startDate=jlib.getSystemDateYYYYMM();
		       String endDate=jlib.getRequiredDateYYYYDDMM(30);
		   
	         //step4: enter all the details and create new contact
	          CreateNewContactPage cnp=new  CreateNewContactPage(driver);
	          cnp.Createcontact(LastName, startDate, endDate);
	          Thread.sleep(3000);
	       
	   
	       	//Verify Header msg Expected Result
	       ContactInformationPage cip=new  ContactInformationPage(driver);
			String headerstartDate = cip.getHeaderStartDateInfo().getText();
			
			if(headerstartDate.equals(startDate))
			{
				System.out.println( headerstartDate   + "inforamation is verified ==PASS");
			}
			else
			{
				System.out.println( headerstartDate   + "inforamation is not verified ==FAIL");
				assertTrue(headerstartDate.trim().equals(startDate));
			}  
			String headerEndDate = cip.getHeadrerEndDateInfo().getText();
			if(headerEndDate .equals(endDate))
			{
				System.out.println(headerEndDate + "inforamation is verified ==PASS");
			}
			else
			{
				System.out.println(headerEndDate + "inforamation is not verified ==FAIL");
				assertTrue(headerEndDate.trim().equals(endDate));
			}
			
	}


}
