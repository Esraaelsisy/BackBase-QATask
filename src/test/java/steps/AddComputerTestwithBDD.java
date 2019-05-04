package steps;

import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.AddComputerPage;
import pages.MainPage;
import tests.TestBase;

public class AddComputerTestwithBDD extends TestBase {

	MainPage mainComputerObj;
	AddComputerPage addComputerObj;

	@Given("^User Clicks on Add a new compute button from Main Page$")
	public void i_click_on_Add_a_new_computer_button() throws Throwable {
		mainComputerObj = new MainPage(driver);
		mainComputerObj.clickonAddComputerBtn();
	}

	@When("^I entered \"([^\"]*)\", \"([^\"]*)\" , \"([^\"]*)\" ,\"([^\"]*)\"$")
	public void i_entered(String computerName, String introducedDate, String discontinuedDate, String companyOption) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		addComputerObj = new AddComputerPage(driver);
		addComputerObj.addNewComputer(computerName, introducedDate, discontinuedDate, companyOption);
	}



	@Then("^Adding success message is shwon in the Main Page$")
	public void adding_success_message_is_shwon_in_the_Main_Page() throws Throwable {
		Assert.assertTrue(mainComputerObj.getSuccessMsg().contains("has been created"),
				"No Assertion for 'has been created' success message");

	}

}
