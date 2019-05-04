package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import pages.AddComputerPage;
import pages.EditComputerPage;
import pages.MainPage;
import pages.SearchResultsPage;
import utilities.helper;

public class TestBase {
	/**
	 * @author Esraa.elsisy Initializing WebDriver and get instances from all Page
	 *         Classes to be used within all Test Scripts with @Test annotation
	 * 
	 * @param driver
	 **/
	protected static WebDriver driver;
	protected AddComputerPage addComputerObj;
	protected MainPage mainComputerObj;
	protected EditComputerPage editComputerObj;
	protected SearchResultsPage searchResultsObj;
	protected static String BaseURL = "https://computer-database.herokuapp.com/computers";
	// protected static Logger logger;

	/**
	 * This is the common set of Computer Data will be used in all Test scripts
	 * Changing in it , will affect in the parameters sent to the whole Test
	 * Scripts!
	 * 
	 * @return Object [][]
	 */
	@DataProvider(name = "Computer Data")
	public Object[][] CorrectComputerData() {
		return new Object[][] { { "HP ProBook", "HP ProBook 2019 v1", "1960-05-01", "2002-05-02", "Hewlett-Packard" },
				{ "Lenovo Thinkpad", "Lenovo Thinkpad 2019 v1", "2000-07-05", "2015-08-01", "Lenovo Group" } };
	}

	/**
	 * 
	 * @param browserName
	 */
	@BeforeTest
	@Parameters("browser")
	public void SetUpEnvironment(@Optional("firefox") String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.navigate().to(BaseURL);
		System.out.println("Requesting :  " + BaseURL + "using browser :  " + browserName);
	}

	@BeforeMethod
	public void initiatingPageObjects() {
		
		addComputerObj = new AddComputerPage(driver);
		mainComputerObj = new MainPage(driver);
		editComputerObj = new EditComputerPage(driver);
		searchResultsObj = new SearchResultsPage(driver);
	}

	@AfterMethod
	public void screeshotOnFailure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			helper.captureScreenshot(driver, result.getName());
		}
	}

	@AfterTest
	public void StopDriver() {
		driver.quit();
	}

}
