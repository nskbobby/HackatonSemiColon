package testCases;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import baseClass.DriverSetup;
import baseClass.baseUi;
import baseClass.extenttest;
import pages.CarInsurance;
import pages.HealthInsurance;
import pages.InvalidTestCases;
import pages.TravelInsurance;
import util.ReadExcel;

@Listeners(extenttest.class)
public class TestcasesSemiColon extends baseUi {
	
	@BeforeSuite(groups = "smoke")
	public void invokeBrowser() throws Exception {
		logger=report.createTest("Invoke" +browser+" Browser");
		createdriver();
		property();
		maximize();
	}

	@BeforeSuite(groups = "smoke", dependsOnMethods = "invokeBrowser")
	public void openUrl() {
		reportTest("navigate to "+prop.getProperty("url"));
		DriverSetup.openURL();
		

	}

	// -----------------------------------------------STUDENT TRAVEL
	// INSURANCE-------------------------------------------
	@Test(groups = "smoke", priority = 1)
	public void navigatetoTravelInsurance() {
		
		reportTest("navigate to travel Insurance ");
		TravelInsurance.NavigateTravelInsurance();
		
	}

	@Test(groups = "smoke", priority = 2) 
	public void selectStudentFormTab() {
		reportTest("selecting Student Tab Form");
		TravelInsurance.selectFormStudentInsurance();
		
	}

	@Test(groups = "smoke", priority = 3)
	public void checkPlaceHolderText() {
		reportTest("Verifying TextBoxes placeholder text");
		
		TravelInsurance.checkplaceHolderText();
		
	}
	
	
	@Test(groups = "smoke", priority = 4) 
	public void travelDetails() throws Exception {
		reportTest("Entering Valid Travel Details");

		TravelInsurance.fillTravelDetails(ReadExcel.findCell(0, 2, 1), ReadExcel.findCellNumeric(0, 3, 1),
				ReadExcel.findCellNumeric(0, 4, 1));
		
	}

	@Test(groups = "smoke", priority = 5) 
	public void setTravelDates() {
		reportTest("selecting Valid Dates");
		TravelInsurance.selectDates();
		
	}

	@Test(groups = "smoke", priority = 6) 
	public void proceed() {
		reportTest("Clicking on proceed Button");
		TravelInsurance.clickproceed();
		
	}

	@Test(groups = "smoke", priority = 7) 
	public void PersonalTravelDetails() throws Exception {
		reportTest("Navigating to personal details form and entering valid data");
		TravelInsurance.fillpersonaldetails(ReadExcel.findCell(0, 8, 1), ReadExcel.findCellNumeric(0, 9, 1),
				ReadExcel.findCell(0, 10, 1));
		
	}

	@Test(groups = "smoke", priority = 8) 
	public void getQuotes() {
		reportTest("Clicking on Get Quotes Button");
		TravelInsurance.getQuotes();
		
	}

	@Test(groups = "smoke", priority = 9) 
	public void sortPriceLowtoHigh() {
		reportTest("select price:LowToHigh from sortBy Dropdown");
		TravelInsurance.SortLowtoHigh();
		
	}

	@Test(groups = "Regression", priority = 10) 
	public void verifystudentAge() throws Exception {
		reportTest("Verify Student age in Quotes page");
		TravelInsurance.CheckAge();
		
	}

	@Test(groups = "Regression", priority = 11) 
	public void verifyDestination() throws Exception {
		reportTest("Verify the destination of results shown");
		TravelInsurance.checkDestination(ReadExcel.findCell(0, 2, 1));
	
	}

	@Test(groups = "Regression", priority = 12) 
	public void verifyResultsForStudent() {
		reportTest("Verify results are shown for student");
		TravelInsurance.checkStudent();
		
	}

	@Test(groups = "smoke", priority = 13) 
	public void PrintHotelPriceDetails() {
		reportTest("Fetch Three Low Hotel Prices");
		TravelInsurance.printlowdetails();
		
	}

	// -------------------------------------------------CAR INSURANCE---------------------------------------------------
	@Test(groups = "smoke", priority = 14) 
	public void navigateToHome() {
		reportTest("Navigate back to home");
		DriverSetup.navigateHome();
		
	}

	@Test(groups = "smoke", priority = 15) 
	public void clickCarInsurance() {
		reportTest("Clicking on car Insurance ");
		CarInsurance.ClickCarInsurance();
	
	}

	@Test(groups = "Regression", priority = 16) 
	public void BrandNewCarLink() {
		reportTest("Verifying BrankNewCar Link is displayed and enabled");
		CarInsurance.checklinkenabledanddisplayed();
		
	}

	@Test(groups = "smoke", priority = 17) 
	public void ProceedWithoutCarNumber() {
		reportTest("Click on Proceed Without car number");
		CarInsurance.ProceedWithoutCarNumber();
		
	}

	@Test(groups = "Regression", priority = 18) 
	public void SearchBox() {
		reportTest("Verify search box is displayed and clickable");
		CarInsurance.searchBoxCity();
		
	}


	@Test(groups = "smoke", priority = 19) 
	public void selectCity() {
	 reportTest("Selecting valid city from the list");
		CarInsurance.selectCity();
		
	}

	@Test(groups = "smoke", priority = 20) 
	public void selectRto() {
		reportTest("Selecting valid RTO from the list");
		CarInsurance.selectRto();
		
	}

	@Test(groups = "smoke", priority = 21) 
	public void selectCarBrand() {
		reportTest("Selecting valid car brand from the list");
		CarInsurance.selectCarBrand();
		
	}

	@Test(groups = "smoke", priority = 22) 
	public void selectCarModel() {
		reportTest("Selecting valid car model from the list");
		CarInsurance.selectCarModel();
		
	}

	@Test(groups = "smoke", priority = 23) 
	public void selectFuelType() {
		reportTest("Selecting valid Fuel type from the list");
		CarInsurance.selectFuelType();
		
	}

	@Test(groups = "smoke", priority = 24) 
	public void selectCarVarient() {
		reportTest("Selecting valid car varient from the list");
		CarInsurance.selectcarVarient();
		
	}

	@Test(groups = "smoke", priority = 25) 
	public void selectCarYear() {
		reportTest("Selecting valid car make year from the list");
		CarInsurance.selectCarYear();
		
	}

	@Test(groups = "smoke", priority = 26) 
	public void fillFormCarInsurance() throws Exception {
		reportTest("Entering valid details and invalid email in textBoxes");
		CarInsurance.fillFormCarInsurance(ReadExcel.findCell(0, 17, 1), ReadExcel.findCell(0, 18, 1),
				ReadExcel.findCellNumeric(0, 19, 1));
		
	}

	@Test(groups = "smoke", priority = 27) 
	public void FetchError() {
		reportTest("Email error is displayed and fetch the error into the console");
		CarInsurance.fetchError();
			}

	// -----------------------------------------------HEALTH
	// INSURANCE--------------------------------------------------
	@Test(groups = "smoke", priority = 28)
	public void navigateToHomeFromCarInsurance() {
		reportTest("Navigating back to homepage");
		DriverSetup.navigateHome();
			}

	@Test(groups = "smoke", priority = 29) 
	public void HoverToDropDown() {
		reportTest("Hover Mouse on to dropdown");
		HealthInsurance.HoverToDropdown();
		
	}

	@Test(groups = "smoke", priority = 30) 
	public void FetchHealthInsuranceListItems() {
		reportTest("Read all Health Insurance list items and display in console");
		HealthInsurance.FetchHealthInsuranceListItems();
		
	}

	@Test(groups = "smoke", priority = 31) 
	public void Quit1() {
		
		endReport();
		quit();
		System.out.println("-------------------------------------------------------------------");
	}

//-------------------------------------------INVALID CASES-----------------------------------------------------------------	
//-------------------------------------STUDENT TRAVEL INSURANCE--------------------------------------------------------	
	@Test(groups = { "invalid" }, priority=32)
	public void NullvaluesTravelForm() throws Exception {
		reportTest("All Null Values in TravelForm");
		InvalidTestCases.AllNullValuesTravelform();

	}

	@Test(groups = { "invalid" }, dependsOnMethods = "NullvaluesTravelForm")
	public void InvalidAge() throws Exception {
		reportTest("Entering Invalid age and Error is displayed");
		InvalidTestCases.invalidAge();
	}

	@Test(groups = { "smoke", "invalid" }, dependsOnMethods = "InvalidAge")
	public void NullDates() throws Exception {
		reportTest("Null Dates in travel form and Error is displayed");
		InvalidTestCases.NullDates();
	}

	@Test(groups = { "smoke", "invalid" }, dependsOnMethods = "NullDates")
	public void NullGender() throws Exception {
		reportTest("Null Gender in Personal Details Travel Form and Error is displayed");
		InvalidTestCases.NullGender();
	}

	@Test(groups = { "smoke", "invalid" }, dependsOnMethods = "NullGender")
	public void NullName() throws Exception {
		reportTest("Null Name in Personal Details Travel Form and Error is displayed");
		InvalidTestCases.NullName();
		;
	}

	@Test(groups = { "smoke", "invalid" }, dependsOnMethods = "NullName")
	public void InvalidName() throws Exception {
		reportTest("Null Name in Personal Details Travel Form and Error is displayed");
		InvalidTestCases.InvalidName();
	}

	@Test(groups = { "smoke", "invalid" }, dependsOnMethods = "InvalidName")
	public void InvalidMobileNo() throws Exception {
		reportTest("Invalid Mobile and error is displayed");
		InvalidTestCases.InvalidMobileNo();
	}

	@Test(groups = { "smoke", "invalid" }, dependsOnMethods = "InvalidMobileNo")
	public void InvalidGmail() throws Exception {
		reportTest("Invalid Gmail and error is displayed");
		InvalidTestCases.InvalidGmail();
	}

	@Test(groups = { "smoke", "invalid" }, dependsOnMethods = "InvalidGmail")
	public void AllNullValuesPersonalForm() throws Exception {
		reportTest("All Null Values in personal form and error is displayed");
		InvalidTestCases.AllNullValuesPersonalForm();
	}

//----------------------------------------------CAR INSURANCE------------------------------------------------------------
	@Test(groups = { "smoke", "invalid" }, dependsOnMethods = "AllNullValuesPersonalForm")
	public void invalidphoneCarInsurance() throws Exception {
		reportTest("Invalid Phone no in Car Insurance and error is displayed");
		
		InvalidTestCases.invalidphoneCarInsurance();
	}

	@Test(groups = { "smoke", "invalid" }, dependsOnMethods = "invalidphoneCarInsurance")
	public void invalidMailCarInsurance() throws Exception {
		reportTest("Invalid Mail in Car Insurance and error is displayed");
		InvalidTestCases.invalidMailCarInsurance();
	}

	@Test(groups = { "smoke", "invalid" }, dependsOnMethods = "invalidMailCarInsurance")
	public void invalidnameCarInsurance() throws Exception {
		reportTest("Invalid Name in Car Insurance and error is displayed");
		InvalidTestCases.invalidnameCarInsurance();
	}

	@AfterSuite(groups = { "smoke", "invalid" }) // ,dependsOnMethods="AllNullValuesPersonalForm")
	public void Quit() {
		reportTest("Quit the browser");
		endReport();
		quit();
	}

}
