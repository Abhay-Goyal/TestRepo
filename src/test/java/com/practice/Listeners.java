package com.practice;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.DriverInitialization;
import resources.ExtentReportBase;

public class Listeners extends DriverInitialization implements ITestListener {

	ThreadLocal<ExtentTest> throwable = new ThreadLocal<ExtentTest>();
	ExtentReports report = ExtentReportBase.getReport();
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

		test = report.createTest(result.getMethod().getMethodName());

		throwable.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

		throwable.get().log(Status.PASS, "Test is a success");
		WebDriver driver = null;
		String methodname = result.getMethod().getMethodName();

		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			String imagePath = takeScreenShot(driver, methodname);
			throwable.get().addScreenCaptureFromPath(imagePath, methodname);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub

		WebDriver driver = null;
		throwable.get().fail(result.getThrowable());
		String methodname = result.getMethod().getMethodName();

		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			String imagePath = takeScreenShot(driver, methodname);
			throwable.get().addScreenCaptureFromPath(imagePath, methodname);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

		report.flush();

	}

}
