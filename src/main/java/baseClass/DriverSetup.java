package baseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class DriverSetup extends baseUi {
	public static WebDriver getChromeDriver() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "./drivers\\chromedriver.exe");
		// Assign Chromedriver class to driver webDriver
		return driver = new ChromeDriver(options);
	}

	public static WebDriver getEdgeDriver() {
		EdgeOptions options = new EdgeOptions();

		System.setProperty("webdriver.edge.driver", "./drivers\\msedgedriver.exe");
		// Assign Edgedriver class to driver webDriver
		return driver = new EdgeDriver(options);
	}
}
