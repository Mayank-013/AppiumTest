package com.nitara.Report;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class TestReport {

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;

	@BeforeSuite
	public void reportSetup() {

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date date = new Date();
		String fileDate = dateFormat.format(date);
		htmlReporter = new ExtentHtmlReporter("Test_Report"+fileDate+".html");
		// create ExtentReports and attach reporter(s)
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

	}

	@AfterSuite
	public void endSetup()
	{
		extent.flush();

	}

}
