package PracticeProduct;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleRoportTest {
	ExtentReports report;
	ExtentTest test;
	@BeforeSuite
	public void configBS()
	{
		//spark report config
				ExtentSparkReporter spark=new ExtentSparkReporter("./advanceReport/report.html");
				spark.config().setDocumentTitle("crm test suite result");
				spark.config().setReportName("crm report");
				spark.config().setTheme(Theme.DARK);
				
				//add env information and create test
			 report=new ExtentReports();
				report.attachReporter(spark);
				report.setSystemInfo("os", "windows-10");
				report.setSystemInfo("BROWSER", "CHROME-100");
	}
	@AfterSuite
	public void configAS()
	{
		report.flush();
	}
	@Test

		public void createContactTest() {
		WebDriver driver=new ChromeDriver();
	driver.get("http://localhost:8888");
		//take screenshot
		 TakesScreenshot eDriver=(TakesScreenshot)driver;
		  String filePath=eDriver.getScreenshotAs(OutputType.BASE64);
		  
		  
		  
		ExtentTest test=report.createTest("createcontactTest");
		
			test.log( Status.INFO,"login to app");
			test.log(Status.INFO,"navigate to contact page");
			test.log(Status.INFO,"create contact");
			
			if("HDFC".equals("HDFC")){
			test.log(Status.PASS,"contact is created ");
        	}
			else {
				test.addScreenCaptureFromBase64String(filePath,"ErrorFile");
		
	}
			driver.close();
		}
			@Test

			public void createContactwithOrg()
			
			{
			
			ExtentTest test=report.createTest("createContactwithOrg");
			
				test.log( Status.INFO,"login to app");
				test.log(Status.INFO,"navigate to contact page");
				test.log(Status.INFO,"create contact");
				
				if("HDFsd".equals("HDFC")){
				test.log(Status.PASS,"contact is created ");
	        	}
				else {
					test.log(Status.FAIL,"contact is not created");
			
		}
			




}
			@Test

			public void createContactwithPhoneNum()
			
			{
			
			ExtentTest test=report.createTest("createContactwithPhoneNum");
			
				test.log( Status.INFO,"login to app");
				test.log(Status.INFO,"navigate to contact page");
				test.log(Status.INFO,"create contact");
				
				if("HDFC".equals("HDFC")){
				test.log(Status.PASS,"contact is created ");
	        	}
				else {
					test.log(Status.FAIL,"contact is not created");
				
		}
				report.flush();




}
}