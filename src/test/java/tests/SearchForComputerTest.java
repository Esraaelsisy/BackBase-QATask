package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchForComputerTest extends TestBase {

	@Test(dataProvider = "Computer Data", priority = 1)
	public void userCanSearchForComputerName(String computerName, String newcomputerName, String introducedDate,
			String discontinuedDate, String companyOption) {
		try {
			System.out.println("========================================================");
			System.out.println("========================================================");
			System.out.println(
					new Throwable().getStackTrace()[0].getMethodName() + " Test will be executed now with data "
							+ computerName + " , " + introducedDate + " , " + discontinuedDate + " , " + companyOption);
			mainComputerObj.clickonAddComputerBtn();
			addComputerObj.addNewComputer(computerName, introducedDate, discontinuedDate, companyOption);
			int numberAfterAdding = mainComputerObj.getComputersNumber();
			System.out.println("Number of computers after adding is : " + numberAfterAdding);
			Assert.assertTrue(mainComputerObj.getSuccessMsg().contains("has been created"),
					"No Assertion for 'has been created' success message");
			System.out.println("Success message of 'has been added' is shown");
			mainComputerObj.searchForComputerName(computerName);

			Assert.assertTrue(searchResultsObj.getComputerName().contains(computerName),
					"No Assertion for the computer name matches the search text");
			System.out.println("Computer name of first row in results table is :  " + computerName);
			searchResultsObj.selectingFirstRowinSearchResults();
			editComputerObj.cancelediting();

		} catch (Exception e) {
			System.out.println(
					"Exception in " + new Throwable().getStackTrace()[0].getMethodName() + " is :" + e.getMessage());
		}
	}

	@Test(dataProvider = "Computer Data", priority = 2)
	public void usercannotFindDeletedUniqueComputerName(String computerName, String newcomputerName,
			String introducedDate, String discontinuedDate, String companyOption) {
		try {
			System.out.println("========================================================");
			System.out.println("========================================================");
			System.out.println(
					new Throwable().getStackTrace()[0].getMethodName() + " Test will be executed now with data "
							+ computerName + " , " + introducedDate + " , " + discontinuedDate + " , " + companyOption);
			mainComputerObj.clickonAddComputerBtn();
			computerName = computerName.concat("WrongNameforTesting");
			addComputerObj.addNewComputer(computerName, introducedDate, discontinuedDate, companyOption);
			int numberAfterAdding = mainComputerObj.getComputersNumber();
			System.out.println("Number of computers after adding is : " + numberAfterAdding);
			Assert.assertTrue(mainComputerObj.getSuccessMsg().contains("has been created"),
					"No Assertion for 'has been created' success message");
			System.out.println("Success message of 'has been added' is shown");

			mainComputerObj.searchForComputerName(computerName);
			System.out.println(searchResultsObj.getComputerName());
			Assert.assertTrue(searchResultsObj.getComputerName().contains(computerName));
			searchResultsObj.selectingFirstRowinSearchResults();
			editComputerObj.deleteSavedComputer();
			Assert.assertTrue(mainComputerObj.getSuccessMsg().contains("has been deleted"),
					"No Assertion for 'has been deleted' success message");
			System.out.println("Success message of 'has been deleted' is shown");
			mainComputerObj.searchForComputerName(computerName);

			Assert.assertTrue(mainComputerObj.getComputersNumbersText().contains("No computers found"));
		} catch (Exception e) {
			System.out.println(
					"Exception in " + new Throwable().getStackTrace()[0].getMethodName() + " is :" + e.getMessage());
		}
	}
}
