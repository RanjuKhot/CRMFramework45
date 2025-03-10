package com.comcast.crm.genericbaseutility;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.databaseutility.DatabaseUtility;
import com.comcast.crm.generic.webutility.JavaUtility;
import com.comcast.crm.generic.webutility.WebdriverUtility;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

import crm.comcast.crm.generic.fileutility.ExcelUtility;
import crm.comcast.crm.generic.fileutility.FileUtility;

public class BaseClass {
	public DatabaseUtility dblib=new DatabaseUtility();
	public FileUtility flib=new FileUtility ();
	public JavaUtility jlib=new JavaUtility();
	public  ExcelUtility elib=new ExcelUtility();
    public WebdriverUtility wlib=new WebdriverUtility();
    
	public WebDriver driver=null;
	public static WebDriver sdriver=null;
	
	@BeforeSuite(groups= {"smokeTest","regressionTest"})
	public void configBS()
	{
		System.out.println("=====connect to database,report config=========");
		dblib.getDbconnection();
	
		
}
	
	@Parameters("BROWSER")
	
	@BeforeClass(groups= {"smokeTest","regressionTest"})
	public void configBC() throws Throwable
	{
		System.out.println("=========Launch Browser=======");
		String BROWSER=flib.getDataFromPropertiesFile("browser");
	
		 if(BROWSER.equals("chrome"))
		 {
			 driver=new ChromeDriver();
		 }else if(BROWSER.equals("firefox")) {
			 
			 driver=new FirefoxDriver();
		 }else if(BROWSER.equals("edge"))
		 {
			 driver=new EdgeDriver();
		 }
		 else
		 {
			 driver=new ChromeDriver();
		 }
		 sdriver=driver;
	}
	
	@BeforeMethod(groups= {"smokeTest","regressionTest"})
	public void configBM() throws Throwable
	{
		System.out.println("=====Login To Application======");
		String URL=flib.getDataFromPropertiesFile("url");
		String USERNAME=flib.getDataFromPropertiesFile("username");
		String PASSWORD=flib.getDataFromPropertiesFile("password");
		LoginPage LP=new LoginPage(driver);
		LP.loginapp(URL, USERNAME, PASSWORD);
		
	}
	@AfterMethod(groups= {"smokeTest","regressionTest"})
	public void configAM()
	{ 
		System.out.println("===Logout===");
		HomePage Hp=new HomePage(driver);
		Hp.logout();
	}
	
	@AfterClass(groups= {"smokeTest","regressionTest"})
	public void configAC()
	{
		System.out.println("======Close The Browser=======");
		driver.quit();
	}
	
	@AfterSuite(groups= {"smokeTest","regressionTest"})
	public void configAS()
	{
		System.out.println("======Close The Database,report backup=======");
		dblib.closeDbconnection();
		
	}
	
	

}
