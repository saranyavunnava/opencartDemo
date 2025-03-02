package Utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IRetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import TestBase.BaseClass;

public class ExtentReportManager implements ITestListener {
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extentReports;
	public ExtentTest extentTest;
	String ff, path;
	public TakesScreenshot ts;

	public ExtentReportManager() {
		super();
	}

	public void onStart(ITestContext context) {
		/*
		 * DateFormat date = new SimpleDateFormat("yyyy.MM.dd HH:MM:SS"); Date d = new
		 * Date(); String ff = date.format(d);
		 */
		ff = new SimpleDateFormat("DD.MM.YYYY_HH.m.ss").format(new Date());
		path = "Test_Automation_" + ff + ".html";
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/Reports/" + path);
		// ExtentSparkReporter("C:\\Users\\sures\\eclipse-workspace\\HybridFrameWorkEx\\Reports"+path);
		sparkReporter.config().setDocumentTitle("Open cart Hybrid Framework Execution...");
		sparkReporter.config().setReportName("Open cart automation suite..");
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setTimeStampFormat(ff);
		extentReports = new ExtentReports();
		extentReports.attachReporter(sparkReporter);
		extentReports.setSystemInfo("UserName", System.getProperty("user.name"));
		extentReports.setSystemInfo("Environment", "QA");

		extentReports.setSystemInfo("OS", context.getCurrentXmlTest().getParameter("os"));
		extentReports.setSystemInfo("Browser", context.getCurrentXmlTest().getParameter("browser"));
		List<String> groups = context.getCurrentXmlTest().getIncludedGroups();
		if (!groups.isEmpty()) {
			extentReports.setSystemInfo("Included Groups", groups.toString());
		}

	}

	public void onTestSuccess(ITestResult result) {
		extentTest = extentReports.createTest(result.getName());
		extentTest.log(Status.PASS, "Test case passed  " + result.getName());
		System.out.println("hello Im in On test success method...");
	}

	public void onTestFailure(ITestResult result) {
		extentTest = extentReports.createTest(result.getName());
		// extentTest.log(Status.FAIL, "Test case failed " + result.getName());
		extentTest.log(Status.INFO, result.getThrowable().getMessage());
		/*
		 * Calling screenshot method from Baseclass String path = new
		 * BaseClass().screenShot(result.getName());
		 * extentTest.addScreenCaptureFromPath(path);
		 */
		// Implemented screenshot feature in failure scenario
		ts = (TakesScreenshot) BaseClass.driver;
		try {
			File src = ts.getScreenshotAs(OutputType.FILE);
			String dest = System.getProperty("user.dir") + "\\Screenshots\\" + result.getName() + "\\Automation.jpg";
			FileUtils.copyFile(src, new File(dest));
			String dt = "C:\\Users\\sures\\eclipse-workspace\\HybridFrameWorkEx\\Screenshots\\clickMyAccountLink\\Automation.jpg";
			extentTest.log(Status.FAIL, "test failed").addScreenCaptureFromPath(dt);

			// extentTest.log(Status.INFO, result.getThrowable().getMessage()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		extentReports.createTest(result.getName());
		extentTest.log(Status.SKIP, "Test case skipped  " + result.getName());
	}

	public void onFinish(ITestContext context) {
		extentReports.flush();
	}
}
