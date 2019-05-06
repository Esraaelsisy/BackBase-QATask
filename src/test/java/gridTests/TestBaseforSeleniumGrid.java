package gridTests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
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

public class TestBaseforSeleniumGrid extends AbstractTestNGCucumberTests {
	/**
	 * @author Esraa.elsisy Initializing WebDriver and get instances from all Page
	 *         Classes to be used within all Test Scripts with @Test annotation
	 * 
	 * @param driver
	 **/
	// protected static WebDriver driver;
	protected static String BaseURL = "http://computer-database.herokuapp.com/computers";
	protected static ThreadLocal<RemoteWebDriver> driver = null;

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
	public void SetUpEnvironment(@Optional("chrome") String browserName) throws MalformedURLException {

		driver = new ThreadLocal<>();
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("browserName", browserName);
		driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps));
		getDriver().navigate().to(BaseURL);
	}

	public WebDriver getDriver() {
		return driver.get();
	}

	@BeforeClass(groups = { "Regression" })
	public void RetrievingDatafromJSON() throws FileNotFoundException, IOException, ParseException {
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
	 * This runs before each @Test method it initializes PageObjects and gets Data
	 */

	@BeforeMethod(groups = { "Regression" })
	public void initiatingPageObjects() {
		addComputerObj = new AddComputerPage(getDriver());
		mainComputerObj = new MainPage(getDriver());
		editComputerObj = new EditComputerPage(getDriver());
		searchResultsObj = new SearchResultsPage(getDriver());
	}

	/*
	 * This runs after @Test Method it takes screenshots for any failed test scripts
	 */
	@AfterMethod(groups = { "Regression" })
	public void screeshotOnFailure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			helper.captureScreenshot(getDriver(), result.getName());
		}
	}

	/*
	 * This runs after <Test> tag it closes all the opened drivers
	 */
	@AfterTest(groups = { "Regression" })
	public void StopDriver() {
		getDriver().quit();
		driver.remove();
	}
}
