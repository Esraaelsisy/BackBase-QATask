package gridTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.helper;

public class ViewComputerDataParallelTest extends TestBaseforSeleniumGrid {

	@Test(alwaysRun = true, priority = 1, groups = { "Regression" })
	public void userCanViewComputerDataInSearchResults() {

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

			// Converting the format of Dates in Search Results Table
			String IntroducedDateTxt = helper.formatDates(searchResultsObj.getIntroducedDate());
			System.out.println("Introduced Date After Formatting is " + IntroducedDateTxt);

			// Converting the format of Dates in Search Results Table
			String DiscontinuedDateTxt = helper.formatDates(searchResultsObj.getDiscontinuedDate());
			System.out.println("Discontinued Date After Formatting is " + DiscontinuedDateTxt);

			// Asserting the Introduced Date
			Assert.assertTrue(IntroducedDateTxt.contains(introducedDate),
					"No Assertion for the introduced date matches the search text");
			// Asserting the Discontinued Date
			Assert.assertTrue(DiscontinuedDateTxt.contains(discontinuedDate),
					"No Assertion for the disconyinued date matches the search text");
			// Asserting the Company Option
			Assert.assertTrue(searchResultsObj.getCompanyOption().contains(companyOption),
					"No Assertion for the company matches the search text");
			System.out.println("Computer name of first row in results table matches the search criteria");

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
	public void userCanViewComputerDataInEditPage() {
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

			// Asserting the computer data shown in Edit computer Page
			Assert.assertTrue(editComputerObj.getComputerName().contains(computerName),
					"No Assertion for the computer name matches the search text");
			Assert.assertTrue(editComputerObj.getIntroducedDate().contains(introducedDate),
					"No Assertion for the introduced date matches the search text");
			Assert.assertTrue(editComputerObj.getDiscountinuedDate().contains(discontinuedDate),
					"No Assertion for the discontinued date matches the search text");
			Assert.assertTrue(editComputerObj.getCompanySelection().contains(companyOption),
					"No Assertion for the company matches the search text");
			System.out.println("Computer name of first row in results table matches the search criteria");

			// Canceling editing the computer in Edit Page
			editComputerObj.cancelediting();

		} catch (Exception e) {
			System.out.println(
					"Exception in " + new Throwable().getStackTrace()[0].getMethodName() + " is :" + e.getMessage());

		}
	}

}
