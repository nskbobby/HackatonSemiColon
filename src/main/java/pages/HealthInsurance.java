package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import baseClass.DriverSetup;
import baseClass.baseUi;

public class HealthInsurance extends baseUi
{

	
	
public void invokeDriver() throws Exception {
	DriverSetup.createdriver();
	}

	
 
public static void HoverToDropdown() {
	try {
		baseUi.reportInfo("Hovering to Insurance Products dropdown");
	 WebElement dropmenu=DriverSetup.xpath(DriverSetup.prop.getProperty("dropmenu"));
	 DriverSetup.action().moveToElement(dropmenu).build().perform();
	 baseUi.reportPass("Hovered to dropdown sucessfully");
	 baseUi.SetCellPass(30, 2);
	}catch(Exception e) {
		baseUi.SetCellPass(30, 2);
		baseUi.reportFail(e.getMessage());
		baseUi.takeScreenShot();
		
	  }
}
	
 public static void FetchHealthInsuranceListItems() {
	 try {
		 baseUi.reportInfo("Fetching items under health insurance list");
	 
	 List<WebElement>items=DriverSetup.Elementsxpath(DriverSetup.prop.getProperty("HealthInsuranceListElements"));
		System.out.println("---------------------------------HEALTH INSURANCE ITEMS----------------------------------");
		for(int i=0;i<items.size();i++) {
			 System.out.println(items.get(i).getText());
			 baseUi.reportPass(items.get(i).getText());
			 hData[countInsur]=items.get(i).getText();
			 countInsur++;
		}
		baseUi.reportPass("Fetched health insurance list items sucessfully");
		System.out.println("------------------------------------------------------");
		baseUi.SetCellPass(31, 2);
}catch(Exception e) {
	baseUi.SetCellPass(31, 2);
	baseUi.reportFail(e.getMessage());
	baseUi.takeScreenShot();
}
 
}
}
