package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class SearchForComputerTest extends TestBase {

	@Test(priority = 1, alwaysRun = true, groups = { "Regression" })
	public void userCanSearchForComputerName() {
		try {
			System.out.println("========================================================");
			System.out.println("========================================================");
			System.out.println(
					new Throwable().getStackTrace()[0].getMethodName() + " Test will be executed now with data "
							+ computerName + " , " + introducedDate + " , " + discontinuedDate + " , " + companyOption);
			// getting Number of computers before adding a new computer data
			int numberBeforeAdding = mainComputerObj.getComputersNumber();

			// Requesting "Add a new computer" button from Main Page
			mainComputerObj.clickonAddComputerBtn();

			// Entering the computer data in Add computer Page
			addComputerObj.addNewComputer(computerName, introducedDate, discontinuedDate, companyOption);

			// getting Number of computers after adding a new computer data
			int numberAfterAdding = mainComputerObj.getComputersNumber();

			// Asserting the creation success message is shown in Main Page
			Assert.assertTrue(mainComputerObj.getSuccessMsg().contains("has been created"),
					"No Assertion for 'has been created' success message");
			System.out.println("Success message of 'has been CREATED' is shown");

			// Asserting the number of computers is increased by 1
			Assert.assertTrue(numberAfterAdding == numberBeforeAdding + 1,
					"Number of computers are not increased by 1!!");
			System.out.println("Number of computers is increased by 1");

			// searching for the computer name
			mainComputerObj.searchForComputerName(computerName);

			// Asserting that the first result computer name contains the same search
			// criteria
			Assert.assertTrue(searchResultsObj.getComputerName().contains(computerName),
					"No Assertion for the computer name matches the search text");
			System.out.println("Computer name of first row in results table is :  " + computerName);

			// Clicking on the first result computer name
			searchResultsObj.selectingFirstRowinSearchResults();

			// Canceling editing the computer data in Editing page
			editComputerObj.cancelediting();

		} catch (Exception e) {
			System.out.println(
					"Exception in " + new Throwable().getStackTrace()[0].getMethodName() + " is :" + e.getMessage());

		}
	}

	@Test(priority = 2, groups = { "Regression" })
	public void usercannotFindDeletedUniqueComputerName() {
		try {
			Faker fakename = new Faker();
			uniqueComputerName = fakename.name().toString();
			System.out.println("========================================================");
			System.out.println("========================================================");
			System.out.println(
					new Throwable().getStackTrace()[0].getMethodName() + " Test will be executed now with data "
							+ uniqueComputerName + " , " + introducedDate + " , " + discontinuedDate + " , " + companyOption);
			// getting Number of computers before adding a new computer data
			int numberBeforeAdding = mainComputerObj.getComputersNumber();

			// Requesting "Add a new computer" button from Main Page
			mainComputerObj.clickonAddComputerBtn();

			// Entering the computer data in Add computer Page
			addComputerObj.addNewComputer(uniqueComputerName, introducedDate, discontinuedDate, companyOption);

			// getting Number of computers after adding a new computer data
			int numberAfterAdding = mainComputerObj.getComputersNumber();

			// Asserting the creation success message is shown in Main Page
			Assert.assertTrue(mainComputerObj.getSuccessMsg().contains("has been created"),
					"No Assertion for 'has been created' success message");
			System.out.println("Success message of 'has been CREATED' is shown");

			// Asserting the number of computers is increased by 1
			Assert.assertTrue(numberAfterAdding == numberBeforeAdding + 1,
					"Number of computers are not increased by 1!!");
			System.out.println("Number of computers is increased by 1");

			// searching for the computer name
			mainComputerObj.searchForComputerName(uniqueComputerName);

			// Asserting that the first result computer name contains the same search
			// criteria
			Assert.assertTrue(searchResultsObj.getComputerName().contains(uniqueComputerName),
					"No Assertion for the computer name matches the search text");
			System.out.println("Computer name of first row in results table is :  " + computerName);

			// Clicking on the first result computer name
			searchResultsObj.selectingFirstRowinSearchResults();

			// Deleting this computer
			editComputerObj.deleteSavedComputer();

			// Asserting the Deletion message
			Assert.assertTrue(mainComputerObj.getSuccessMsg().contains("has been deleted"),
					"No Assertion for 'has been deleted' success message");
			System.out.println("Success message of 'has been deleted' is shown");

			// searching for the computer name
			mainComputerObj.searchForComputerName(uniqueComputerName);

			// Asserting that "No computers found" is shown in the header
			Assert.assertTrue(mainComputerObj.getComputersNumbersText().contains("No computers found"));

			// Navigating to the BaseURL
			driver.navigate().to(BaseURL);
		} catch (Exception e) {
			System.out.println(
					"Exception in " + new Throwable().getStackTrace()[0].getMethodName() + " is :" + e.getMessage());

		}
	}
}
