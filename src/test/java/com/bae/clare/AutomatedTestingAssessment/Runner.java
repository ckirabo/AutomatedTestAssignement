package com.bae.clare.AutomatedTestingAssessment;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:")
public class Runner {

	public static ExtentReports report;
	public static ExtentTest test;
	
	@BeforeClass
	public static void beforeClass() {
		report = new ExtentReports(Constants.reportFilePath + Constants.reportFileName, false);
	}
	
	@AfterClass
	public static void afterClass() {
		report.endTest(test);
		report.flush();
	}
}
