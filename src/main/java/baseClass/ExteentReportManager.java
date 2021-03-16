package baseClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;

public class ExteentReportManager {
	public static ExtentReports report;

	public static ExtentReports getReportInstance() {
		if (report == null) {
			String reportName = dateUtils.getTimeStamp() + ".html";
			ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(
					System.getProperty("user.dir") + "\\src\\test\\resources\\HTML_Reports\\" + reportName);
			report = new ExtentReports();
			report.attachReporter(htmlReporter);

			report.setSystemInfo("OS", "Windows 10 Home");
			report.setSystemInfo("Environment", "Automation Testing");

			htmlReporter.config().setDocumentTitle("SemiColon Hackathon Project");
			htmlReporter.config().setReportName("Policy Bazar");
			htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
			htmlReporter.config().setTimeStampFormat("MMM dd,yyyy HH:mm:ss");
		}
		return report;
	}

}
