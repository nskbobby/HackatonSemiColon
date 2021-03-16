package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import baseClass.DriverSetup;
import baseClass.baseUi;
import util.ReadExcel;

public class TravelInsurance extends baseUi {
	

	public void invokeDriver() throws Exception {
		DriverSetup.createdriver();
	}

	public static void NavigateTravelInsurance() {
		try {
			
			//DriverSetup.xpath("//a[@class='closebutton']").click();
			WebElement dropmenu = DriverSetup.xpath(DriverSetup.prop.getProperty("dropmenu"));
			DriverSetup.action().moveToElement(dropmenu).build().perform();
			reportPass("The mouse is hovered over Insuranace DropDown Menu");
			WebElement ele = DriverSetup.xpath(DriverSetup.prop.getProperty("TravelInsuranceElement"));
			DriverSetup.wait(10).until(ExpectedConditions.elementToBeClickable(ele));
			DriverSetup.xpath(DriverSetup.prop.getProperty("TravelInsuranceElement")).click();
			reportPass("TravelInsurance Element is clicked from the list");
			// reportPass("The Travel Insurance option is choose");
			reportInfo("Navigating to Travel Insurance page");
			Assert.assertEquals(DriverSetup.currentUrl(), "https://www.policybazaar.com/travel-insurance/");
			reportPass("Navigated to TravelInsurance page");
			SetCellPass(2, 2);
		} catch (Exception e) {
			SetCellFail(2, 2);
			reportFail(e.getMessage());
			takeScreenShot();
		}
	}

	public static void selectFormStudentInsurance() {
		try {
			WebElement studTab = DriverSetup.xpath(DriverSetup.prop.getProperty("FormStudent"));
			reportInfo("Selecting student form tab");
			studTab.click();
			reportPass("Student formTab is selected");
			Assert.assertEquals(studTab.getAttribute("class"), "active");
			reportPass("Student formTab is selected and Active");
			SetCellPass(3, 2);
		} catch (Exception e) {
			SetCellFail(3, 2);
			reportFail(e.getMessage());
			takeScreenShot();
		}
	}
	public static void checkplaceHolderText() {
		try {
			reportInfo("Checking Destination textbox placeHolder text");
			String destinationPlaceHolder=DriverSetup.getId(DriverSetup.prop.getProperty("destinationTextBox")).getAttribute("placeholder");
		     Assert.assertEquals(destinationPlaceHolder, "Please input all countries.");
		     reportPass("Destination PlaceHolder text is verified and sucessfull");
		     
		     
		     reportInfo("Checking textbox1 placeHolder text");
		     String textbox1=DriverSetup.getId(DriverSetup.prop.getProperty("ageTextBox1")).getAttribute("placeholder");
		     Assert.assertEquals(textbox1, "Student 1");
		     reportPass("textBox1 placeholder is correct");
		     
		     
		     reportInfo("Checking textbox2 placeHolder text");
		     String textbox2=DriverSetup.getId(DriverSetup.prop.getProperty("ageTextBox2")).getAttribute("placeholder");
		     Assert.assertEquals(textbox2, "Student 2");
		     reportPass("textBox2 placeholder is correct");
		     
		     
		     reportInfo("Checking Trip start date textbox placeHolder text");
		     String Tripstartdatetextbox=DriverSetup.xpath(DriverSetup.prop.getProperty("StartDateTextbox")).getAttribute("placeholder");
		     Assert.assertEquals(Tripstartdatetextbox, "Trip Start Date");
		     reportPass("Trip start date placeholder is correct");
		     
		     
		     reportInfo("Checking Trip End date textbox placeHolder text");
		     String TripEnddatetextbox=DriverSetup.xpath(DriverSetup.prop.getProperty("EndDateTextbox")).getAttribute("placeholder");
		     Assert.assertEquals(TripEnddatetextbox, "Trip End Date");
		     reportPass("Trip End date placeholder is correct");
		     SetCellPass(4, 2); 
		}catch(Exception e) {
			SetCellFail(4, 2);
			reportFail(e.getMessage());
		}
	}

	public static void fillTravelDetails(String name, double age1, double age2) throws Exception {
		try {
			DriverSetup.getId(DriverSetup.prop.getProperty("destinationTextBox")).sendKeys(name);
			DriverSetup.xpath(DriverSetup.prop.getProperty("optionItaly")).click();
			reportPass("Entered valid Destination");
			DriverSetup.getId(DriverSetup.prop.getProperty("ageTextBox1"))
					.sendKeys(String.valueOf(age1).replace(".0", ""));
			DriverSetup.getId(DriverSetup.prop.getProperty("ageTextBox2"))
					.sendKeys(String.valueOf(age2).replace(".0", ""));
			reportPass("Entered valid ages" + age1 + "for student1," + age2 + "for student2");
			SetCellPass(5, 2);
			} catch (Exception e) {
				SetCellFail(5, 2);
			reportFail(e.getMessage());
			takeScreenShot();
		}
	}

	public static void selectDates() {
		try {
			reportInfo("Valid Dates are being selected");
			DriverSetup.getId(DriverSetup.prop.getProperty("CalendarStartDate")).click();
			Select startmonth = new Select(DriverSetup.className(DriverSetup.prop.getProperty("monthselection")));
			startmonth.selectByVisibleText("Jun");
			DriverSetup.xpath(DriverSetup.prop.getProperty("StartDate")).click();

			Thread.sleep(1000);

			DriverSetup.xpath(DriverSetup.prop.getProperty("EndDate")).click();
			Assert.assertEquals(
					DriverSetup.getId(DriverSetup.prop.getProperty("StartDatecontainer")).getAttribute("value"),
					"02-06-2021");
			Assert.assertEquals(
					DriverSetup.getId(DriverSetup.prop.getProperty("EndDatecontainer")).getAttribute("value"),
					"03-06-2021");
			reportPass("Valid Start Date and End Date are selected");
			SetCellPass(6, 2);
		} catch (InterruptedException e) {
			SetCellFail(6, 2);
			reportFail(e.getMessage());

		}
	}

	public static void clickproceed() {
		try {
			reportInfo("clicking on proceed button");
			WebElement proceedButton = DriverSetup.getId(DriverSetup.prop.getProperty("proceedButton"));
			reportInfo("Checking proceed button is enabled");
			Assert.assertTrue(proceedButton.isEnabled(), "proceed button is not enabled");

			reportPass("proceed button is enabled");
			proceedButton.click();
			reportPass("proceed button is clicked");
			SetCellPass(7, 2);
		} catch (Exception e) {
			reportFail(e.getMessage());
			SetCellFail(7, 2);
		}
	}

	public static void fillpersonaldetails(String name, double d, String email) {
		try {
			reportInfo("Selecting gender");
			WebElement gen = DriverSetup.wait(30).until(ExpectedConditions
					.elementToBeClickable(DriverSetup.getId(DriverSetup.prop.getProperty("genderDropdown"))));
			Select gender = new Select(gen);// DriverSetup.getId(DriverSetup.prop.getProperty("genderDropdown")));
			gender.selectByVisibleText(DriverSetup.prop.getProperty("genderText"));
			reportPass("gender is selected");
			reportInfo("Entering Name");
			DriverSetup.getId(DriverSetup.prop.getProperty("nameTextbox")).sendKeys(name);
			reportPass("Name entered sucessfully");
			reportInfo("Entering Mobile Number");
			DriverSetup.getId(DriverSetup.prop.getProperty("mobileTextbox")).sendKeys(String.valueOf((long) d));
			reportPass("Mobile entered sucessfully");
			reportInfo("Entering Email");
			DriverSetup.getId(DriverSetup.prop.getProperty("emailTextbox")).sendKeys(email);
			reportPass("Email entered sucessfully");
			reportInfo("Checking Get Quotes button enabled");
			Assert.assertTrue(DriverSetup.xpath(DriverSetup.prop.getProperty("Quotesbutton")).isEnabled());
			reportPass("Quotes Button is enabled");
			SetCellPass(8, 2);
		} catch (Exception e) {
			SetCellFail(8, 2);
			reportFail(e.getMessage());
		}
	}

	public static void getQuotes() {
		reportInfo("Click Get Quotes Button");
		try {
			DriverSetup.xpath(DriverSetup.prop.getProperty("Buttongetfreequotes")).click();
			reportPass("Get Quotes Button clicked sucessfully");
			reportInfo("Navigating to Quotes page");
			SetCellPass(9, 2);
		} catch (Exception e) {
			SetCellFail(9, 2);
			reportFail(e.getMessage());
		}
	}

	public static void SortLowtoHigh() {

		try {
			reportPass("navigated to quotes page sucessfully");
			reportInfo("Select price:LowToHigh From sortBy dropdown");
			WebElement selectElement = DriverSetup.wait(300).until(ExpectedConditions
					.visibilityOfElementLocated((By.className(DriverSetup.prop.getProperty("sortDropDown")))));
			Select select = new Select(selectElement);
			select.selectByVisibleText("Price: Low to High");
			reportPass("price:LowtoHigh is selected");
			Assert.assertTrue(DriverSetup.currentUrl().contains("https://travel.policybazaar.com/v2/quotes/"));
			SetCellPass(10, 2);
		} catch (Exception e) {
			SetCellFail(10, 2);
			reportFail(e.getMessage());
		}
	}

	public static void printlowdetails() {

		reportInfo("Fetching three low priced insurance provider name and price displaying in the console");
		try {
			List<WebElement> quotes = DriverSetup.Elementsxpath(DriverSetup.prop.getProperty("Insuranceprices"));
			List<WebElement> names = DriverSetup.Elementsxpath(DriverSetup.prop.getProperty("InsuranceProviders"));
			//int size = quotes.size();
			System.out.println(
					"-------------------------------HOTEL DETAILS--------------------------------------------------");
			for (int i = 0; i < 3; i++) {

				// System.out.println(+i+")"+"INSURANCE PROVIDER:");
				String log = names.get(i).getAttribute("class");
				
				System.out.println(+i + 1 + ")" + "INSURANCE PROVIDER:" + log.replace("Logo", ""));
				cData[count]=+i + 1 + ")" + "INSURANCE PROVIDER:" + log.replace("Logo", "");
				count++;
				// System.out.println(+i+1+")"+log.replace("Logo",""));
				reportPass(+i + 1 + ")" + "INSURANCE PROVIDER:" + log.replace("Logo", ""));
				String pric = quotes.get(i).getText();
				System.out.println("Price" + ":" + pric.replace("Product Details", "").replace("₹",""));
				cData[count]="Price" + ":" + pric.replace("Product Details", "").replace("₹","");
				count++;
				reportPass("Price" + ":" + pric.replace("Product Details", "").replace("₹",""));
		//WriteExcel.passval(log.replace("Logo", ""), pric.replace("Product Details", "").replace("₹",""));		
		}
			
		
			reportPass("Low priced Insurance provider name and price per insurance is displayed");
			SetCellPass(11, 2);
		}catch (Exception e) {
			
		
			reportFail(e.getMessage());
		SetCellFail(11, 2);
		}

	}

	public static void CheckAge() throws Exception {
		reportInfo("Verifying the students age in the Quotes page");
		try {
			String tr1 = String.valueOf(ReadExcel.findCellNumeric(0, 3, 1)).replace(".0", " yrs");
			String tr2 = String.valueOf(ReadExcel.findCellNumeric(0, 4, 1)).replace(".0", " yrs");
			reportInfo("Checking the results are displayed for given travellers age");
			Assert.assertEquals(DriverSetup.xpath(DriverSetup.prop.getProperty("traveller1age")).getText(), tr1);
			Assert.assertEquals(DriverSetup.xpath(DriverSetup.prop.getProperty("traveller2age")).getText(), tr2);
			reportPass("Displayed results and age are correct");
			SetCellPass(12, 2);
		
		} catch (Exception e) {
		SetCellFail(12, 2);
			reportFail(e.getMessage());
		}
	}

	public static void checkStudent() {
		reportInfo("Verifying the Quotes displayed for student and student is shown in the page");
		try {
			Assert.assertEquals(DriverSetup.xpath(DriverSetup.prop.getProperty("studentTitleInQuotepage")).getText(),
					"Student");
			reportPass("Verify the Quotes displayed for student and student is shown in the page is SUCESSFULL");
			SetCellPass(13, 2);
		} catch (Exception e) {
			SetCellFail(13, 2);
			reportFail(e.getMessage());
		}
	}

	public static void checkDestination(String place) {
		reportInfo("Verifying the Destination in the Quotes page");
		try {
			Assert.assertEquals(DriverSetup.xpath(DriverSetup.prop.getProperty("DestinationCheck")).getText(), place);
			reportPass("Verify the Destination in the Quotes page is sucessfull");
			SetCellPass(14, 2);
		} catch (Exception e) {
			reportFail(e.getMessage());
			SetCellFail(14, 2);
		}
	}
}
