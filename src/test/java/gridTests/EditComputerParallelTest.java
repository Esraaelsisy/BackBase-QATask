package gridTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.helper;

public class EditComputerParallelTest extends TestBaseforSeleniumGrid {

	@Test(alwaysRun = true, priority = 1, groups = { "Regression" })
	public void userCanEditComputerName() {
		try {
			System.out.println("========================================================");
			System.out.println("========================================================");
			System.out.println(
					new Throwable().getStackTrace()[0].getMethodName() + " Test will be executed now with data "
							+ computerName + " , " + introducedDate + " , " + discontinuedDate + " , " + companyOption);

			// getting Number of computers before adding a new computer data
			mainComputerObj.getComputersNumber();

			// Requesting "Add a new computer" button from Main Page
			mainComputerObj.clickonAddComputerBtn();

			// Entering the computer data in Add computer Page
			addComputerObj.addNewComputer(computerName, introducedDate, discontinuedDate, companyOption);

			// getting Number of computers after adding a new computer data
			mainComputerObj.getComputersNumber();

			// Asserting the creation success message is shown in Main Page
			Assert.assertTrue(mainComputerObj.getSuccessMsg().contains("has been created"),
					"No Assertion for 'has been created' success message");
			System.out.println("Success message of 'has been CREATED' is shown");

			// searching for the computer name
			mainComputerObj.searchForComputerName(computerName);

			// Asserting that the first result computer name contains the same search
			// criteria
			Assert.assertTrue(searchResultsObj.getComputerName().contains(computerName),
					"No Assertion for the computer name matches the search text");
			System.out.println("Computer name of first row in results table is :  " + computerName);

			// Clicking on the first result computer name
			searchResultsObj.selectingFirstRowinSearchResults();

			// Editing computer name
			editComputerObj.editComputerName(editablecomputerName);

			// Asserting the Editing success message in Home Page
			Assert.assertTrue(mainComputerObj.getSuccessMsg().contains("has been updated"),
					"No Assertion for 'has been updated' success message");

			System.out.println("Success message of 'has been updated' is shown");

		} catch (Exception e) {
			System.out.println(
					"Exception in " + new Throwable().getStackTrace()[0].getMethodName() + " is :" + e.getMessage());

		}
	}

	@Test(priority = 2, groups = { "Regression" })
	public void userCanEditSavedComputerData() {
		try {
			System.out.println("========================================================");
			System.out.println("========================================================");
			System.out.println(
					new Throwable().getStackTrace()[0].getMethodName() + " Test will be executed now with data "
							+ computerName + " , " + introducedDate + " , " + discontinuedDate + " , " + companyOption);

			// getting Number of computers before adding a new computer data
			mainComputerObj.getComputersNumber();

			// Requesting "Add a new computer" button from Main Page
			mainComputerObj.clickonAddComputerBtn();

			// Entering the computer data in Add computer Page
			addComputerObj.addNewComputer(computerName, introducedDate, discontinuedDate, companyOption);

			// getting Number of computers after adding a new computer data
			mainComputerObj.getComputersNumber();

			// Asserting the creation success message is shown in Main Page
			Assert.assertTrue(mainComputerObj.getSuccessMsg().contains("has been created"),
					"No Assertion for 'has been created' success message");
			System.out.println("Success message of 'has been CREATED' is shown");

			// searching for the computer name
			mainComputerObj.searchForComputerName(computerName);

			// Asserting that the first result computer name contains the same search
			// criteria
			Assert.assertTrue(searchResultsObj.getComputerName().contains(computerName),
					"No Assertion for the computer name matches the search text");
			System.out.println("Computer name of first row in results table is :  " + computerName);

			// Clicking on the first result computer name
			searchResultsObj.selectingFirstRowinSearchResults();

			// Editing all computer data
			editComputerObj.editSavedComputer(editablecomputerName, editableintroducedDate, editablediscontinuedDate,
					editablecompanyOption);

			// Asserting the editing success message in the Main Page
			Assert.assertTrue(mainComputerObj.getSuccessMsg().contains("has been updated"),
					"No Assertion for 'has been updated' success message");
			System.out.println("Success message of 'has been updated' is shown");

		} catch (Exception e) {
			System.out.println(
					"Exception in " + new Throwable().getStackTrace()[0].getMethodName() + " is :" + e.getMessage());

		}
	}

	@Test(priority = 3, groups = { "Regression" })
	public void userCannotEditComputerWithoutName() {
		try {
			System.out.println("========================================================");
			System.out.println("========================================================");
			System.out.println(
					new Throwable().getStackTrace()[0].getMethodName() + " Test will be executed now with data "
							+ computerName + " , " + introducedDate + " , " + discontinuedDate + " , " + companyOption);

			// getting Number of computers before adding a new computer data
			mainComputerObj.getComputersNumber();

			// Requesting "Add a new computer" button from Main Page
			mainComputerObj.clickonAddComputerBtn();

			// Entering the computer data in Add computer Page
			addComputerObj.addNewComputer(computerName, introducedDate, discontinuedDate, companyOption);

			// getting Number of computers after adding a new computer data
			mainComputerObj.getComputersNumber();

			// Asserting the creation success message is shown in Main Page
			Assert.assertTrue(mainComputerObj.getSuccessMsg().contains("has been created"),
					"No Assertion for 'has been created' success message");
			System.out.println("Success message of 'has been CREATED' is shown");

			// searching for the computer name
			mainComputerObj.searchForComputerName(computerName);

			// Asserting that the first result computer name contains the same search
			// criteria
			Assert.assertTrue(searchResultsObj.getComputerName().contains(computerName),
					"No Assertion for the computer name matches the search text");
			System.out.println("Computer name of first row in results table is :  " + computerName);

			// Clicking on the first result computer name
			searchResultsObj.selectingFirstRowinSearchResults();

			// Editing the computer Data
			editComputerObj.editSavedComputer(wrongcomputerName, introducedDate, discontinuedDate, companyOption);

			// getting color of Required Name Label
			String color = helper.colorFormatter(addComputerObj.getColorOfNameRequiredLabel());
			System.out.println("Name Field's Color formated in hex is " + color);

			// Asserting the color of Required name label
			Assert.assertTrue(color.contains("#9d261d"));
			helper.captureScreenshot(getDriver(), "No  Name in Add Computer Page");

			// Editing computer name
			editComputerObj.editComputerName(editablecomputerName);

			// Asserting the Editing success message in Home Page
			Assert.assertTrue(mainComputerObj.getSuccessMsg().contains("has been updated"),
					"No Assertion for 'has been updated' success message");

			System.out.println("Success message of 'has been updated' is shown");

		} catch (Exception e) {
			System.out.println(
					"Exception in " + new Throwable().getStackTrace()[0].getMethodName() + " is :" + e.getMessage());

		}
	}
}