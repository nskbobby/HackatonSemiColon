package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import baseClass.DriverSetup;
import baseClass.baseUi;
import util.ReadExcel;

public class InvalidTestCases extends baseUi {

	public static void invalidAge() throws Exception {
		try {
			reportInfo("Navigating to home page and then navigating to student travel details form tab");
			DriverSetup.navigateHome();
			TravelInsurance.NavigateTravelInsurance();

			TravelInsurance.selectFormStudentInsurance();
			reportPass("Navigated sucessfully to Student travel details form tab");
			reportInfo("Entering invalid age and error message should be displayed");
			TravelInsurance.fillTravelDetails(ReadExcel.findCell(0, 2, 2), ReadExcel.findCellNumeric(0, 3, 2),
					ReadExcel.findCellNumeric(0, 4, 2));
			Thread.sleep(2000);
			String error = DriverSetup.xpath(DriverSetup.prop.getProperty("invalidage")).getText();
			System.out.println("--------------------------invalid age-----------------------------------");
			System.out.println(error);
			
			reportPass(error + " is displayed for invalid age");
			
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	public static void NullDates() throws Exception {
		try {
			DriverSetup.navigateHome();
			reportInfo("Navigating to home page and then navigating to student travel details form tab");
			TravelInsurance.NavigateTravelInsurance();
			Thread.sleep(2000);

			TravelInsurance.selectFormStudentInsurance();
			reportPass("Navigated sucessfully to Student travel details form tab");
			reportInfo("Entering Null Dates and error message should be displayed");

			TravelInsurance.fillTravelDetails(ReadExcel.findCell(0, 2, 1), ReadExcel.findCellNumeric(0, 3, 1),
					ReadExcel.findCellNumeric(0, 4, 1));
			TravelInsurance.clickproceed();
			String calerror = DriverSetup.xpath(DriverSetup.prop.getProperty("CalendarError")).getText();
			System.out.println("--------------------------invalid Calendar Date-----------------------------------");
			System.out.println(calerror);
			// System.out.println("-------------------------------------------------------------------------------");
			reportPass(calerror + " is displayed for invalid or null dates");
		    
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	public static void AllNullValuesTravelform() throws Exception {
		try {

			createdriver();

			maximize();

			openURL();

			TravelInsurance.NavigateTravelInsurance();

			TravelInsurance.selectFormStudentInsurance();
			TravelInsurance.clickproceed();
			reportInfo("Entering all Null Values and verifying errors are displayed");

			String calerror1 = DriverSetup.xpath(DriverSetup.prop.getProperty("CalendarError")).getText();
			System.out.println("--------------------------invalid All Null Values-----------------------------------");
			System.out.println(calerror1);
			String Agerror = DriverSetup.xpath(DriverSetup.prop.getProperty("NullAgeError")).getText();

			System.out.println(Agerror);
			reportPass(Agerror);
			reportPass("All Errors are displayed below there respective textbox");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}
	// ------------------------------------------------PERSONAL
	// DETAILS----------------------------------------------------------

	public static void NullGender() throws Exception {
		System.out.println(
				"---------------------------------------PERSONAL DETAILS----------------------------------------");
		DriverSetup.navigateHome();
		try {
			reportInfo("Verifying Null Gender Error");
			TravelInsurance.NavigateTravelInsurance();

			TravelInsurance.selectFormStudentInsurance();
			TravelInsurance.fillTravelDetails(ReadExcel.findCell(0, 2, 1), ReadExcel.findCellNumeric(0, 3, 1),
					ReadExcel.findCellNumeric(0, 4, 1));
			TravelInsurance.selectDates();
			TravelInsurance.clickproceed();

			WebElement name = DriverSetup.wait(30).until(ExpectedConditions
					.elementToBeClickable(DriverSetup.getId(DriverSetup.prop.getProperty("nameTextbox"))));
			name.sendKeys(ReadExcel.findCell(0, 8, 1));
			DriverSetup.getId(DriverSetup.prop.getProperty("mobileTextbox"))
					.sendKeys(String.valueOf((long) ReadExcel.findCellNumeric(0, 9, 1)));
			DriverSetup.getId(DriverSetup.prop.getProperty("emailTextbox")).sendKeys(ReadExcel.findCell(0, 10, 1));
			TravelInsurance.getQuotes();
			String gendererror = DriverSetup.xpath(DriverSetup.prop.getProperty("SelectGenderError")).getText();
			System.out.println("---------------------------Null Gender----------------------------------------");
			System.out.println(gendererror);
			
			reportPass(gendererror + " error is displayed sucessfully");
			// System.out.println("-------------------------------------------------------------------------------");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	public static void NullName() throws Exception {
		DriverSetup.navigateHome();
		try {
			TravelInsurance.NavigateTravelInsurance();
			reportInfo("Veryfying Null Name Error");
			TravelInsurance.selectFormStudentInsurance();
			TravelInsurance.fillTravelDetails(ReadExcel.findCell(0, 2, 1), ReadExcel.findCellNumeric(0, 3, 1),
					ReadExcel.findCellNumeric(0, 4, 1));
			TravelInsurance.selectDates();
			TravelInsurance.clickproceed();

			WebElement gen = DriverSetup.wait(30).until(ExpectedConditions
					.elementToBeClickable(DriverSetup.getId(DriverSetup.prop.getProperty("genderDropdown"))));
			Select gender = new Select(gen);
			gender.selectByVisibleText(DriverSetup.prop.getProperty("genderText"));
			DriverSetup.getId(DriverSetup.prop.getProperty("mobileTextbox"))
					.sendKeys(String.valueOf((long) ReadExcel.findCellNumeric(0, 9, 1)));
			DriverSetup.getId(DriverSetup.prop.getProperty("emailTextbox")).sendKeys(ReadExcel.findCell(0, 10, 1));
			TravelInsurance.getQuotes();
			String Nameerror = DriverSetup.xpath(DriverSetup.prop.getProperty("SelectGenderError")).getText();
			System.out.println("---------------------------Null Name----------------------------------------");
			System.out.println(Nameerror);
			reportPass(Nameerror + " is displayed sucessfully");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	public static void AllNullValuesPersonalForm() throws Exception {
		DriverSetup.navigateHome();
		try {
			TravelInsurance.NavigateTravelInsurance();

			TravelInsurance.selectFormStudentInsurance();
			reportInfo("Veryfing all errors are displayed by entering all null values in personal form");
			TravelInsurance.fillTravelDetails(ReadExcel.findCell(0, 2, 1), ReadExcel.findCellNumeric(0, 3, 1),
					ReadExcel.findCellNumeric(0, 4, 1));
			TravelInsurance.selectDates();
			TravelInsurance.clickproceed();
			Thread.sleep(1000);
			TravelInsurance.getQuotes();
			System.out.println("-----------------------------------ALL NULL VALUES-----------------------------");
			List<WebElement> personalNullErrors = DriverSetup
					.Elementsxpath(DriverSetup.prop.getProperty("AllNullErrors"));
			int siz = personalNullErrors.size();
			for (int li = 0; li < siz; li++) {
				System.out.println(personalNullErrors.get(li).getText());
			}
			// System.out.println("-------------------------------------------------------------------------------");
			reportPass("All Errors are displayed sucessfully for null values");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	public static void InvalidMobileNo() throws Exception {
		try {
			DriverSetup.navigateHome();

			TravelInsurance.NavigateTravelInsurance();

			TravelInsurance.selectFormStudentInsurance();
			TravelInsurance.fillTravelDetails(ReadExcel.findCell(0, 2, 1), ReadExcel.findCellNumeric(0, 3, 1),
					ReadExcel.findCellNumeric(0, 4, 1));
			TravelInsurance.selectDates();
			TravelInsurance.clickproceed();

			WebElement gen2 = DriverSetup.wait(30).until(ExpectedConditions
					.elementToBeClickable(DriverSetup.getId(DriverSetup.prop.getProperty("genderDropdown"))));
			Select gender2 = new Select(gen2);// DriverSetup.getId(DriverSetup.prop.getProperty("genderDropdown")));
			gender2.selectByVisibleText(DriverSetup.prop.getProperty("genderText"));
			DriverSetup.getId(DriverSetup.prop.getProperty("nameTextbox")).sendKeys(ReadExcel.findCell(0, 8, 3));
			DriverSetup.getId(DriverSetup.prop.getProperty("mobileTextbox"))
					.sendKeys(String.valueOf((long) ReadExcel.findCellNumeric(0, 9, 3)));
			DriverSetup.getId(DriverSetup.prop.getProperty("emailTextbox")).sendKeys(ReadExcel.findCell(0, 10, 3));

			String InvaidMobileNoerror = DriverSetup.xpath(DriverSetup.prop.getProperty("InvalidMobileNo")).getText();
			System.out.println("---------------------------Invalid Mobile No----------------------------------------");
			System.out.println(InvaidMobileNoerror);
			// System.out.println("-------------------------------------------------------------------------------");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	public static void InvalidName() throws Exception {
		try {
			DriverSetup.navigateHome();

			TravelInsurance.NavigateTravelInsurance();

			TravelInsurance.selectFormStudentInsurance();
			TravelInsurance.fillTravelDetails(ReadExcel.findCell(0, 2, 1), ReadExcel.findCellNumeric(0, 3, 1),
					ReadExcel.findCellNumeric(0, 4, 1));
			TravelInsurance.selectDates();
			TravelInsurance.clickproceed();

			WebElement gen3 = DriverSetup.wait(30).until(ExpectedConditions
					.elementToBeClickable(DriverSetup.getId(DriverSetup.prop.getProperty("genderDropdown"))));
			Select gender3 = new Select(gen3);// DriverSetup.getId(DriverSetup.prop.getProperty("genderDropdown")));
			gender3.selectByVisibleText(DriverSetup.prop.getProperty("genderText"));
			DriverSetup.getId(DriverSetup.prop.getProperty("nameTextbox"))
					.sendKeys(String.valueOf((long) ReadExcel.findCellNumeric(0, 8, 4)));
			DriverSetup.getId(DriverSetup.prop.getProperty("mobileTextbox"))
					.sendKeys(String.valueOf((long) ReadExcel.findCellNumeric(0, 9, 4)));
			DriverSetup.getId(DriverSetup.prop.getProperty("emailTextbox")).sendKeys(ReadExcel.findCell(0, 10, 4));

			String InvalidNameerror = DriverSetup.xpath(DriverSetup.prop.getProperty("InvalidNameError")).getText();
			System.out.println("---------------------------Invalid name----------------------------------------");
			System.out.println(InvalidNameerror);
			// System.out.println("-------------------------------------------------------------------------------");
			reportPass(InvalidNameerror + " error is displayed for invalid name ");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	public static void InvalidGmail() throws Exception {
		try {
			DriverSetup.navigateHome();
			reportInfo("Verifying Error for invalid Gmail");
			TravelInsurance.NavigateTravelInsurance();

			TravelInsurance.selectFormStudentInsurance();
			TravelInsurance.fillTravelDetails(ReadExcel.findCell(0, 2, 1), ReadExcel.findCellNumeric(0, 3, 1),
					ReadExcel.findCellNumeric(0, 4, 1));
			TravelInsurance.selectDates();
			TravelInsurance.clickproceed();

			WebElement gen4 = DriverSetup.wait(30).until(ExpectedConditions
					.elementToBeClickable(DriverSetup.getId(DriverSetup.prop.getProperty("genderDropdown"))));
			Select gender4 = new Select(gen4);
			gender4.selectByVisibleText(DriverSetup.prop.getProperty("genderText"));
			DriverSetup.getId(DriverSetup.prop.getProperty("nameTextbox")).sendKeys(ReadExcel.findCell(0, 8, 5));
			DriverSetup.getId(DriverSetup.prop.getProperty("mobileTextbox"))
					.sendKeys(String.valueOf((long) ReadExcel.findCellNumeric(0, 9, 5)));
			DriverSetup.getId(DriverSetup.prop.getProperty("emailTextbox")).sendKeys(ReadExcel.findCell(0, 10, 5));
			TravelInsurance.getQuotes();
			String Invaidgmailerror = DriverSetup.xpath(DriverSetup.prop.getProperty("InvalidGmailError")).getText();
			System.out.println("---------------------------Invalid Gmail----------------------------------------");
			System.out.println(Invaidgmailerror);
			// System.out.println("-------------------------------------------------------------------------------");

		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}
	// ---------------------------------------CAR
	// INSURANCE------------------------------------------------------

	public static void invalidphoneCarInsurance() throws Exception {
try {
	reportInfo("Verifying error for invalid phone no in car insurance");
		DriverSetup.navigateHome();
		CarInsurance.ClickCarInsurance();
		CarInsurance.ProceedWithoutCarNumber();
		CarInsurance.selectCity();
		CarInsurance.selectRto();
		CarInsurance.selectCarBrand();
		CarInsurance.selectCarModel();
		CarInsurance.selectFuelType();
		CarInsurance.selectcarVarient();
		CarInsurance.selectCarYear();
		// ---------------------------------------------INVALID PHONE
		// NUMBER--------------------------------------------------------
		WebElement selectElement = DriverSetup.wait(300)
				.until(ExpectedConditions.visibilityOfElementLocated((By.id(DriverSetup.prop.getProperty("name")))));
		selectElement.sendKeys(ReadExcel.findCell(0, 17, 1));
		DriverSetup.getId(DriverSetup.prop.getProperty("email")).sendKeys(ReadExcel.findCell(0, 18, 1));
		DriverSetup.getId(DriverSetup.prop.getProperty("phonenum"))
				.sendKeys(String.valueOf((long) ReadExcel.findCellNumeric(0, 19, 1)));
		DriverSetup.getId(DriverSetup.prop.getProperty("btn")).click();
		String error = DriverSetup.xpath(DriverSetup.prop.getProperty("invalidphnoerr")).getText();

		System.out.println("---------------------------Invalid Phone Number----------------------------------------");
		System.out.println(error);
		// System.out.println("-------------------------------------------------------------------------------");
reportPass(error+" error is displayed for invalid phone no in car insurance");
	}catch(Exception e) {
		reportFail(e.getMessage());
	}
}
	
	
	public static void invalidnameCarInsurance() throws Exception {
try {
	reportInfo("Verifying error for invalid name in car insurane");
		DriverSetup.navigateHome();
		CarInsurance.ClickCarInsurance();
		CarInsurance.ProceedWithoutCarNumber();
		CarInsurance.selectCity();
		CarInsurance.selectRto();
		CarInsurance.selectCarBrand();
		CarInsurance.selectCarModel();
		CarInsurance.selectFuelType();
		CarInsurance.selectcarVarient();
		CarInsurance.selectCarYear();

		WebElement selectElement = DriverSetup.wait(300)
				.until(ExpectedConditions.visibilityOfElementLocated((By.id(DriverSetup.prop.getProperty("name")))));
		selectElement.sendKeys(String.valueOf(ReadExcel.findCellNumeric(0, 17, 2)));
		DriverSetup.getId(DriverSetup.prop.getProperty("email")).sendKeys(ReadExcel.findCell(0, 18, 2));
		DriverSetup.getId(DriverSetup.prop.getProperty("phonenum"))
				.sendKeys(String.valueOf((long) ReadExcel.findCellNumeric(0, 19, 2)));
		DriverSetup.getId(DriverSetup.prop.getProperty("btn")).click();
		Thread.sleep(1000);
		String error1 = DriverSetup.xpath(DriverSetup.prop.getProperty("Carnameerror")).getText();
		System.out.println("---------------------------Invalid Name----------------------------------------");

		System.out.println(error1);

		// System.out.println("-------------------------------------------------------------------------------");
reportPass(error1+" error is displayed for invalid name");
	}catch(Exception e) {
		reportFail(e.getMessage());
	}
	}

	public static void invalidMailCarInsurance() throws Exception {
reportInfo("Verifying Invalid Mail error in car insurance");
		try {
		DriverSetup.navigateHome();
		CarInsurance.ClickCarInsurance();
		CarInsurance.ProceedWithoutCarNumber();
		CarInsurance.selectCity();
		CarInsurance.selectRto();
		CarInsurance.selectCarBrand();
		CarInsurance.selectCarModel();
		CarInsurance.selectFuelType();
		CarInsurance.selectcarVarient();
		CarInsurance.selectCarYear();

		WebElement selectElement = DriverSetup.wait(300)
				.until(ExpectedConditions.visibilityOfElementLocated((By.id(DriverSetup.prop.getProperty("name")))));
		selectElement.sendKeys(String.valueOf(ReadExcel.findCell(0, 17, 3)));
		DriverSetup.getId(DriverSetup.prop.getProperty("email")).sendKeys(ReadExcel.findCell(0, 18, 3));
		DriverSetup.getId(DriverSetup.prop.getProperty("phonenum"))
				.sendKeys(String.valueOf((long) ReadExcel.findCellNumeric(0, 19, 3)));
		DriverSetup.getId(DriverSetup.prop.getProperty("btn")).click();
		String error1 = DriverSetup.xpath(DriverSetup.prop.getProperty("CarMailerror")).getText();
		System.out.println("---------------------------mail----------------------------------------");
		System.out.println(error1);
		// System.out.println("-------------------------------------------------------------------------------");
reportPass(error1+" error is displayed for invalid mail");
	}catch(Exception e) {
		reportFail(e.getMessage());
	}
    }
}