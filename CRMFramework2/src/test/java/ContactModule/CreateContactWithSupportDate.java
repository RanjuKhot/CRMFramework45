package ContactModule;

import java.io.FileInputStream;


import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
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

public class CreateContactWithSupportDate extends BaseClass {
	@Test
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
				String actstartDate = cip.getHeaderStartDateInfo().getText();
				if( actstartDate .equals(actstartDate))
				{
					System.out.println( actstartDate   + "inforamation is verified ==PASS");
				}
				else
				{
					System.out.println( actstartDate   + "inforamation is not verified ==FAIL");
				}
				String actEndDate = cip.getHeadrerEndDateInfo().getText();
				if(actEndDate .equals(endDate))
				{
					System.out.println( actEndDate + "inforamation is verified ==PASS");
				}
				else
				{
					System.out.println( actEndDate + "inforamation is not verified ==FAIL");
				}
				
		}
   

}
