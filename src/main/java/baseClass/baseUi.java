package baseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import util.WriteExcel;


public class baseUi {

	public static WebDriver driver;
	public static Properties prop;
	public ExtentReports report = ExteentReportManager.getReportInstance();
	public static ExtentTest logger;
	public static String browser = "Edge";
	public static String[] cData = new String[40];
	public static int count=0;
	public static int countInsur=0;
	public static String carErrTxt;
	public static String[] Data = new String[40];
	public static String[] hData = new String[40];
	public static Properties property() {
		prop = new Properties();
		try {
			FileInputStream input = new FileInputStream("config.properties");
			try {
				reportInfo("The poperties file is about to load");
				prop.load(input);
				reportPass("The properties file is successfully loaded");
			} catch (IOException e) {
				reportFail(e.getMessage());
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			reportFail(e.getMessage());
		}
		return prop;
	}


	public static WebDriver createdriver() throws Exception {
	
		reportInfo("Opening"+browser+" browser");
		if (browser.equalsIgnoreCase("edge")) {
			driver = DriverSetup.getEdgeDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			driver = DriverSetup.getChromeDriver();
		} else if (browser.equalsIgnoreCase("Opera")) {
			System.setProperty("webdriver.opera.driver", "./drivers\\operadriver.exe");
			// Assign Operadriver class to driver webDriver
			driver = new OperaDriver();
		} else {
			throw new Exception("Browser is not correct");
		}
      reportPass("Creating driver sucessful"); 
		return driver;
	
	}
	public static void click(WebElement celement) {
		try {
			reportPass(celement + " - Element clicked Successfully ");
			celement.click();
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	public static WebElement className(String classname) {
		return driver.findElement(By.className(classname));
	}

	public static List<WebElement> ElementsClass(String multieleclass) {

		return driver.findElements(By.className(multieleclass));
	}

	public static WebElement xpath(String xpath) {

		return driver.findElement(By.xpath(xpath));
	}

	public static List<WebElement> Elementsxpath(String multixpath) {

		return driver.findElements(By.xpath(multixpath));
	}

	public static WebElement getId(String id) {
		return driver.findElement(By.id(id));
	}

	public static List<WebElement> ElementsId(String multiID) {

		return driver.findElements(By.xpath(multiID));
	}

	public static void openURL() {
		try {
			logger.log(Status.INFO, "The url -" + prop.getProperty("url") + " is about to navigate");
			driver.get(prop.getProperty("url"));
			reportPass(" The url -" + prop.getProperty("url") + " is navigated");
			
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	public static void maximize() {
	try {
		reportInfo("Maximizing browser Window");
		driver.manage().window().maximize();
		reportPass("Browser window maximized sucessfully");
	}catch(Exception e) {
		reportFail(e.getMessage());
	}
	}

	public static void quit() {
		try {
			WriteExcel.consoledata("./src\\test\\resources\\ExcelData\\OutputData.xlsx", cData);
			WriteExcel.carInsurance("./src\\test\\resources\\ExcelData\\OutputData.xlsx", carErrTxt);
			WriteExcel.Healthinsurdata("./src\\test\\resources\\ExcelData\\OutputData.xlsx", hData);
		}catch (Exception e) {
			System.out.println("Error in locating the excel file");
		}
		driver.quit();
	}

	public static Actions action() {
		Actions action = new Actions(driver);
		return action;

	}

	public static String currentUrl() {
		return driver.getCurrentUrl();
	}

	public static WebDriverWait wait(int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		return wait;

	}

	public static void navigateHome() {
	try {
		reportInfo("Navigating to home");
		driver.navigate().to(prop.getProperty("url"));
	reportPass("Navigating to home sucessfull");
	}catch(Exception e) {
		reportFail(e.getMessage());
	}
	}
	public static void navigateTo(String url) {
		driver.navigate().to(url);
	}
	public void reportTest(String testname) {
		report.createTest(testname);
	}

	@AfterTest
	public void endReport() {
		report.flush();
	}

	/**
	 * Reporting Functions
	 */
	public static void reportFail(String reportString) {
		logger.log(Status.FAIL, reportString);
		takeScreenShot();
		Assert.fail();
	}

	public static void reportPass(String reportString) {
		logger.log(Status.PASS, reportString);
	}
	
	public static void reportInfo(String reportString) {
		logger.log(Status.INFO, reportString);
	}

	/**
	 * Capturing ScreenShots
	 */
	public static void takeScreenShot() {
		TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
		File source = takeScreenShot.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\ScreenShot\\ScreenShots"
				+ dateUtils.getTimeStamp() + ".png");

		try {
			FileUtils.copyFile(source, dest);
			logger.addScreenCaptureFromPath(System.getProperty("user.dir")
					+ "\\src\\test\\resources\\ScreenShot\\ScreenShots" + dateUtils.getTimeStamp() + ".png");
		} catch (Exception e) {
			e.getMessage();
		}

	}
	
	public static void SetCellPass(int row,int col) {
		try {
			WriteExcel.passtest("PASS", row, col);
	reportPass("Writing into the excel");
		}catch(Exception e) {
		reportFail(e.getMessage());
	}
	}
	
	public static void SetCellFail(int row,int col) {
	try {
		WriteExcel.passtest("FAIL", row, col);
		reportPass("Writing into the excel");
	}catch(Exception e) {
		reportFail(e.getMessage());
	}
	}

	public static void SetCellValue(String Value,int row,int col) {
		try {
			WriteExcel.passtest(Value, row, col);
			reportPass("Writing into the excel");
		}catch(Exception e) {
			reportFail(e.getMessage());
		}
		}
	
	
}
