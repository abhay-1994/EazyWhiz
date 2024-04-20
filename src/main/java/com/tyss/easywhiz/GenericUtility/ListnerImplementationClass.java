package com.tyss.easywhiz.GenericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerImplementationClass implements ITestListener {
	ExtentReports report;
	ExtentTest test;

	

	@Override
	public void onTestStart(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test = report.createTest(MethodName);
		Reporter.log("Execution starts from here ", true);
		

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.PASS, MethodName );
		Reporter.log("Executed successfully ", true);
		
	}

	@Override
	public void onTestFailure(ITestResult result) {

		String MethodName = result.getMethod().getMethodName();
		try {
			String screenshotPath = WebDriverUtility.getScreenShot(BaseClass.sdriver, MethodName);
			
			test.log(Status.FAIL, MethodName );
			test.log(Status.FAIL, result.getThrowable() );
			Reporter.log("Execution failed " , true);
			test.addScreenCaptureFromPath(screenshotPath);
			
			Reporter.log("Execution failed " , true);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
	@Override
	public void onTestSkipped(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, MethodName );
		Reporter.log("TC Skipped ", true);
	}
	

	
	@Override
	public void onStart(ITestContext context) {
		ExtentSparkReporter htmlReport = new ExtentSparkReporter("./ExtentReport/demo.html");
		htmlReport.config().setDocumentTitle("DEMO");
		htmlReport.config().setTheme(Theme.STANDARD);
		
		report = new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base-Platform", "Windows");
		report.setSystemInfo("Base-Browser", "Chrome");
		report.setSystemInfo("Base-URL", "http://rmgtestingserver/");
		report.setSystemInfo("Reporter-Name", null);
		
		

	}

	@Override
	public void onFinish(ITestContext context) {
      report.flush();
	}

}
