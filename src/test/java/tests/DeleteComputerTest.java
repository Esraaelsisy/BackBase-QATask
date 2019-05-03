package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteComputerTest extends TestBase {

	@Test(dataProvider = "Computer Data")
	public void uuserCanDeleteComputer(String computerName, String newcomputerName, String introducedDate,
			String discontinuedDate, String companyOption) throws InterruptedException {

		Thread.sleep(2000);
		int numberBeforeAdding = mainComputerObj.getComputersNumber();
		System.out.println("Number of computers before adding is : " + numberBeforeAdding);
		mainComputerObj.clickonAddComputerBtn();
		addComputerObj.addNewComputer(computerName, introducedDate, discontinuedDate, companyOption);
		int numberAfterAdding = mainComputerObj.getComputersNumber();
		System.out.println("Number of computers after adding is : " + numberAfterAdding);
		Assert.assertTrue(mainComputerObj.actionSuccessMsg.getText().contains("has been created"),
				"No Assertion for 'has been created' success message");
		System.out.println("Success message of 'has been added' is shown");
		Assert.assertTrue(numberAfterAdding == (numberBeforeAdding + 1), "Number of computers is not increased by 1");
		Thread.sleep(2000);
		mainComputerObj.searchForComputerName(computerName);
		System.out.println(searchResultsObj.firstRowLink.getText());
		Assert.assertTrue(searchResultsObj.firstRowLink.getText().contains(computerName));
		searchResultsObj.selectingFirstRowinSearchResults();
		editComputerObj.deleteSavedComputer();
		Assert.assertTrue(mainComputerObj.actionSuccessMsg.getText().contains("has been deleted"),
				"No Assertion for 'has been deleted' success message");
		System.out.println("Success message of 'has been deleted' is shown");
	}


}
