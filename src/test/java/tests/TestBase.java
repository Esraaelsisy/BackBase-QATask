package tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import data.JSONReader;
import pages.AddComputerPage;
import pages.EditComputerPage;
import pages.MainPage;
import pages.SearchResultsPage;
import utilities.helper;

public class TestBase extends AbstractTestNGCucumberTests {
	/**
	 * @author Esraa.elsisy Initializing WebDriver and get instances from all Page
	 *         Classes to be used within all Test Scripts with @Test annotation
	 * 
	 * @param driver
	 **/
	protected static WebDriver driver;
	protected static String BaseURL = "https://computer-database.herokuapp.com/computers";

	// Page Objects
	protected AddComputerPage addComputerObj;
	protected MainPage mainComputerObj;
	protected EditComputerPage editComputerObj;
	protected SearchResultsPage searchResultsObj;

	// JSON File Reader
	protected JSONReader jReader;

	// Data from JSON file
	// Data for adding new computer data
	protected String computerName;
	protected String introducedDate;
	protected String discontinuedDate;
	protected String companyOption;

	// Data for editing any computer data
	protected String editablecomputerName;
	protected String editableintroducedDate;
	protected String editablediscontinuedDate;
	protected String editablecompanyOption;

	// Data for negative scenarios
	protected String wrongcomputerName;
	protected String wrongintroducedDate;
	protected String wrongdiscontinuedDate;
	protected String uniqueComputerName;

	/*
	 * This runs before each <Test> tag , it initializes the webdriver and navigates
	 * it to the BaseURL
	 * 
	 * @param browserName
	 */
	@BeforeTest(groups = { "Regression" })
	@Parameters("browser")
	public void SetUpEnvironment(@Optional("chrome") String browserName) {

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
	/*
	 * This runs before each @Test method it initializes PageObjects and gets Data
	 */

	@BeforeMethod(groups = { "Regression" })
	public void initiatingPageObjectsAndData() throws FileNotFoundException, IOException, ParseException {
		addComputerObj = new AddComputerPage(driver);
		mainComputerObj = new MainPage(driver);
		editComputerObj = new EditComputerPage(driver);
		searchResultsObj = new SearchResultsPage(driver);

		jReader = new JSONReader();
		jReader.JSONDataReader();

		computerName = jReader.newComputerName;

		introducedDate = jReader.newIntrdoucedDate;
		discontinuedDate = jReader.newDiscontinuedDate;
		companyOption = jReader.newCompany;

		editablecomputerName = jReader.editableComputerName;
		editableintroducedDate = jReader.editableIntrdoucedDate;
		editablediscontinuedDate = jReader.editableDiscontinuedDate;
		editablecompanyOption = jReader.editableCompany;

		wrongcomputerName = jReader.wrongComputerName;
		wrongintroducedDate = jReader.wrongIntrdoucedDate;
		wrongdiscontinuedDate = jReader.wrongDiscontinuedDate;
		uniqueComputerName = jReader.uniqueComputerName;

	}

	/*
	 * This runs after @Test Method it takes screenshots for any failed test scripts
	 */
	@AfterMethod(groups = { "Regression" })
	public void screeshotOnFailure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			helper.captureScreenshot(driver, result.getName());
		}
	}

	/*
	 * This runs after <Test> tag it closes all the opened drivers
	 */
	@AfterTest(groups = { "Regression" })
	public void StopDriver() {
		driver.quit();
	}

	/*
	 * This is the common set of Computer Data can be used in all Test scripts
	 * Changing in it , will affect in the parameters sent to the whole Test
	 * Scripts!
	 * 
	 * @return Object [][]
	 * 
	 * @DataProvider(name = "Computer Data") public Object[][] CorrectComputerData()
	 * { return new Object[][] { { "HP ProBook", "HP ProBook 2019
	 * v1", "1960-05-01", "2002-05-02", "Hewlett-Packard" }, { "Lenovo Thinkpad",
	 * "Lenovo Thinkpad 2019 v1", "2000-07-05", "2015-08-01", "Lenovo Group" } }; }
	 */
}
