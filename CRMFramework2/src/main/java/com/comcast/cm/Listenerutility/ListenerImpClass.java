package com.comcast.cm.Listenerutility;

import java.util.Date;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.genericbaseutility.BaseClass;

public class ListenerImpClass implements ITestListener, ISuiteListener {
	public static ExtentTest test;
	public ExtentReports report;

	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("Report confifguration");
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		// spark report config
		ExtentSparkReporter spark = new ExtentSparkReporter("./advanceReport/report_" + time + ".html");
		spark.config().setDocumentTitle("crm test suite result");
		spark.config().setReportName("crm report");
		spark.config().setTheme(Theme.DARK);

		// add env information and create test
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("os", "windows-10");
		report.setSystemInfo("BROWSER", "CHROME-100");

	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("Report backup");
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(test);
		System.out.println("===>" + result.getMethod().getMethodName() + "====start====");
		test=report.createTest(result.getMethod().getMethodName());
		test.log(Status.INFO, result.getMethod().getMethodName() + "===>STARTED<===");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("===>" + result.getMethod().getMethodName() + "====end====");
		test.log(Status.PASS, result.getMethod().getMethodName() + "===>COMPLETED<===");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testname = result.getMethod().getMethodName();
		TakesScreenshot eDriver = (TakesScreenshot) BaseClass.sdriver;
		String filePath = eDriver.getScreenshotAs(OutputType.BASE64);

		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		test.addScreenCaptureFromBase64String(filePath, testname + "_" + time);
		test.log(Status.FAIL, result.getMethod().getMethodName() + "===>FAILED<===");

	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		// report.flush();
	}

}
