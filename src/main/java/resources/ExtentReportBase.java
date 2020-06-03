package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportBase {
	static ExtentReports report;

	public static ExtentReports getReport() {

		String path = System.getProperty("user.dir") + "//reports//index.html";

		ExtentSparkReporter reporter = new ExtentSparkReporter(path);

		reporter.config().setDocumentTitle("Booking WebSites Test");
		reporter.config().setReportName("Automation Result");

		report = new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("Tester Name", "Abhay Goyal");

		return report;

	}

}
