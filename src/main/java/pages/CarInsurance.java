package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import baseClass.DriverSetup;
import baseClass.baseUi;

public class CarInsurance extends baseUi {

	public static void ClickCarInsurance() {
		try {
			
			//DriverSetup.xpath("//a[@class='closebutton']").click();
			reportInfo("Clicking on the car insurance ");
			WebElement carInsur = DriverSetup.wait(300).until(ExpectedConditions
					.visibilityOfElementLocated((By.xpath(DriverSetup.prop.getProperty("carinsurance")))));
			//DriverSetup.xpath(DriverSetup.prop.getProperty("carinsurance")).click();
			carInsur.click();
			reportPass("Clicked on car insurance");
			SetCellPass(16, 2);
		} catch (Exception e) {
			reportFail(e.getMessage());
		SetCellFail(16, 2);
		}
	}

	public static void ProceedWithoutCarNumber() {
		try {
			reportInfo("click on proceed withour car number");
			WebElement selectElement = DriverSetup.wait(300).until(ExpectedConditions
					.visibilityOfElementLocated((By.xpath(DriverSetup.prop.getProperty("nocarnum")))));
			selectElement.click();
			reportPass("Clicked on proceed without car number sucessfully");
			SetCellPass(17, 2);
		} catch (Exception e) {
			SetCellFail(17, 2);
			reportFail(e.getMessage());
		}
	}

	public static void selectCity() {
		try {
			reportInfo("Clicking on valid city");
			DriverSetup.xpath(DriverSetup.prop.getProperty("city")).click();
			reportPass("Valid city is Clicked");
			SetCellPass(18, 2);
		} catch (Exception e) {
			SetCellFail(18, 2);
			reportFail(e.getMessage());
		}
	}

	public static void selectRto() {
		try {
			reportInfo("Clicking on valid Rto");
			DriverSetup.xpath(DriverSetup.prop.getProperty("rto")).click();
			reportPass("Valid Rto is Clicked sucessfully");
			SetCellPass(19, 2);
		} catch (Exception e) {
			SetCellFail(19, 2);
			reportFail(e.getMessage());
		}
	}

	public static void selectCarBrand() {
		try {
			reportInfo("Clicking On Valid carBrand");
			WebElement selectElement = DriverSetup.wait(300).until(ExpectedConditions
					.visibilityOfElementLocated((By.xpath(DriverSetup.prop.getProperty("carbrand")))));
			// DriverSetup.xpath(prop.getProperty("carbrand")).click();
			selectElement.click();
			reportPass("Clicked on valid car brand");
			SetCellPass(20, 2);
		} catch (Exception e) {
			SetCellFail(20, 2);
			reportFail(e.getMessage());
		}
	}

	public static void selectCarModel() {
		try {
			reportInfo("Clicking on car model");
			WebElement selectElement = DriverSetup.wait(300).until(ExpectedConditions
					.visibilityOfElementLocated((By.xpath(DriverSetup.prop.getProperty("carmodel")))));
			// DriverSetup.xpath(prop.getProperty("carmodel")).click();
			selectElement.click();
			reportPass("Clicked on car number");
			SetCellPass(21, 2);
		} catch (Exception e) {
			SetCellFail(21, 2);
			reportFail(e.getMessage());
		}
	}

	public static void selectFuelType() {
		try {
			reportInfo("CLick on valid Fuel Type");
			// DriverSetup.getId(prop.getProperty("fueltype")).click();
			WebElement selectElement = DriverSetup.wait(300).until(
					ExpectedConditions.visibilityOfElementLocated((By.id(DriverSetup.prop.getProperty("fueltype")))));
			selectElement.click();
			reportPass("Clicked on valid Fuel Type successfully");
			SetCellPass(22, 2);
		} catch (Exception e) {
			SetCellFail(22, 2);
			reportFail(e.getMessage());
		}
	}

	public static void selectcarVarient() {
		try {
			reportInfo("Click on valid car varient");
			WebElement selectElement = DriverSetup.wait(300).until(ExpectedConditions
					.visibilityOfElementLocated((By.xpath(DriverSetup.prop.getProperty("carvarient")))));
			// DriverSetup.xpath(prop.getProperty("carvarient")).click();
			selectElement.click();
			reportPass("Clicked on valid car varient");
			SetCellPass(23, 2);
		} catch (Exception e) {
			SetCellFail(23, 2);
			reportFail(e.getMessage());
		}
	}

	public static void selectCarYear() {
		try {
			reportInfo("CLick on valild car year");
			WebElement selectElement = DriverSetup.wait(300).until(
					ExpectedConditions.visibilityOfElementLocated((By.xpath(DriverSetup.prop.getProperty("caryear")))));
			// DriverSetup.xpath(prop.getProperty("caryear")).click();
			selectElement.click();
			reportPass("Clicked on valid car year sucessfully");
			SetCellPass(24, 2);
		} catch (Exception e) {
			SetCellFail(24, 2);
			reportFail(e.getMessage());
		}
	}

	public static void fillFormCarInsurance(String name, String mail, double phone) {
		try {
			reportInfo("Fill the form with invalid Email id and submit");
			WebElement selectElement = DriverSetup.wait(300).until(
					ExpectedConditions.visibilityOfElementLocated((By.id(DriverSetup.prop.getProperty("name")))));
			selectElement.sendKeys(name);
			DriverSetup.getId(DriverSetup.prop.getProperty("email")).sendKeys(mail);
			DriverSetup.getId(DriverSetup.prop.getProperty("phonenum")).sendKeys(String.valueOf(phone));
			DriverSetup.getId(DriverSetup.prop.getProperty("btn")).click();
			reportPass("Form filled sucessfully and clicked on proceed button");
			SetCellPass(25, 2);
		} catch (Exception e) {
			SetCellFail(25, 2);
			reportFail(e.getMessage());
		}
	}

	public static void fetchError() {
		try {
			reportInfo("Fetching error displayed at email textbox");
			baseUi.takeScreenShot();
			System.out.println(
					"--------------------------------CAR INSURANCE-------------------------------------------------------");
			List<WebElement> errormsgs = DriverSetup.Elementsxpath(DriverSetup.prop.getProperty("errors"));
			int size = errormsgs.size();

			for (int i = 0; i < size; i++) {
				System.out.println(errormsgs.get(i).getText());
				reportPass(errormsgs.get(i).getText());
				carErrTxt=errormsgs.get(i).getText();
			}
			reportPass("Fetched error sucessfully and error is displayed");
			SetCellPass(26, 2);
		} catch (Exception e) {
			SetCellFail(26, 2);
			reportFail(e.getMessage());
		}
	}

	public static void checklinkenabledanddisplayed() {
		try {
			reportInfo("Checking Brand New Car link enabled and displayed");
			WebElement newCarbtn = DriverSetup.wait(20).until(ExpectedConditions
					.visibilityOfElementLocated((By.xpath(DriverSetup.prop.getProperty("newCarlink")))));
			// WebElement
			// newCarbtn=DriverSetup.xpath(DriverSetup.prop.getProperty("newCarlink"));
			Assert.assertTrue(newCarbtn.isDisplayed(), "NewCarBtn is not displayed");
			Assert.assertTrue(newCarbtn.isEnabled(), "NewCarBtn is not Enabled");
			reportPass("Brand New Car link is enabled and displayed sucessfully");
			SetCellPass(27, 2);
		} catch (Exception e) {
			SetCellFail(27, 2);
			reportFail(e.getMessage());
		}
	}

	public static void searchBoxCity() {
		try {
			reportInfo("verify search box is displayed and others button is displayed and enabled");
			WebElement SearchBox = DriverSetup.xpath(DriverSetup.prop.getProperty("SearchBoxCar"));
			WebElement OthersBtn = DriverSetup.xpath(DriverSetup.prop.getProperty("OthersCityBtn"));
			Assert.assertTrue(SearchBox.isDisplayed(), "SearchBox is not displayed");
			Assert.assertTrue(OthersBtn.isDisplayed(), "Others is not displayed");
			Assert.assertTrue(OthersBtn.isEnabled(), "Others is not Enabled");
			reportPass("Search box is displayed and Others button is displayed and enabled");
			SetCellPass(28, 2);
		} catch (Exception e) {
			SetCellFail(28, 2);
			reportFail(e.getMessage());
		}

	}
}
