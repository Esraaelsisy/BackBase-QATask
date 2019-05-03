package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchForComputerTest extends TestBase {

	@Test(dataProvider = "Computer Data", priority = 1)
	public void userCanSearchForComputerName(String computerName, String newcomputerName, String introducedDate,
			String discontinuedDate, String companyOption) throws InterruptedException {
		mainComputerObj.clickonAddComputerBtn();
		addComputerObj.addNewComputer(computerName, introducedDate, discontinuedDate, companyOption);
		int numberAfterAdding = mainComputerObj.getComputersNumber();
		System.out.println("Number of computers after adding is : " + numberAfterAdding);
		Assert.assertTrue(mainComputerObj.actionSuccessMsg.getText().contains("has been created"),
				"No Assertion for 'has been created' success message");
		System.out.println("Success message of 'has been added' is shown");
		mainComputerObj.searchForComputerName(computerName);
		Thread.sleep(2000);
		Assert.assertTrue(searchResultsObj.getComputerName().contains(computerName),
				"No Assertion for the computer name matches the search text");
		System.out.println("Computer name of first row in results table is :  " + computerName);
		searchResultsObj.selectingFirstRowinSearchResults();
		editComputerObj.cancelediting();

	}

	@Test(dataProvider = "Computer Data", priority = 2)
	public void usercannotFindDeletedUniqueComputerName(String computerName, String newcomputerName,
			String introducedDate, String discontinuedDate, String companyOption) throws InterruptedException {
		mainComputerObj.clickonAddComputerBtn();
		computerName = computerName.concat("WrongNameforTesting");
		addComputerObj.addNewComputer(computerName, introducedDate, discontinuedDate, companyOption);
		int numberAfterAdding = mainComputerObj.getComputersNumber();
		System.out.println("Number of computers after adding is : " + numberAfterAdding);
		Assert.assertTrue(mainComputerObj.actionSuccessMsg.getText().contains("has been created"),
				"No Assertion for 'has been created' success message");
		System.out.println("Success message of 'has been added' is shown");
		Thread.sleep(2000);
		mainComputerObj.searchForComputerName(computerName);
		System.out.println(searchResultsObj.getComputerName());
		Assert.assertTrue(searchResultsObj.getComputerName().contains(computerName));
		searchResultsObj.selectingFirstRowinSearchResults();
		editComputerObj.deleteSavedComputer();
		Assert.assertTrue(mainComputerObj.actionSuccessMsg.getText().contains("has been deleted"),
				"No Assertion for 'has been deleted' success message");
		System.out.println("Success message of 'has been deleted' is shown");
		mainComputerObj.searchForComputerName(computerName);
		Thread.sleep(2000);
		Assert.assertTrue(mainComputerObj.computersNumberLabel.getText().contains("No computers found"));
	}
}
