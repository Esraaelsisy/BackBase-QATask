package tests;

import java.text.ParseException;

import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.helper;

public class ViewComputerDataTest extends TestBase {

	@Test(dataProvider = "Computer Data", priority = 1)
	public void userCanViewComputerDataInSearchResults(String computerName, String newcomputerName,
			String introducedDate, String discontinuedDate, String companyOption)
			throws InterruptedException, ParseException {
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

		String IntroducedDateTxt = helper.formatDates(searchResultsObj.getIntroducedDate());
		System.out.println("Introduced Date After Formatting is " + IntroducedDateTxt);

		String DiscontinuedDateTxt = helper.formatDates(searchResultsObj.getDiscontinuedDate());
		System.out.println("Discontinued Date After Formatting is " + DiscontinuedDateTxt);

		Assert.assertTrue(IntroducedDateTxt.contains(introducedDate),
				"No Assertion for the computer name matches the search text");
		Assert.assertTrue(DiscontinuedDateTxt.contains(discontinuedDate),
				"No Assertion for the computer name matches the search text");
		Assert.assertTrue(searchResultsObj.getCompanyOption().contains(companyOption),
				"No Assertion for the computer name matches the search text");
		System.out.println("Computer name of first row in results table is :  " + computerName);

		searchResultsObj.selectingFirstRowinSearchResults();
		editComputerObj.cancelediting();
	}

	@Test(dataProvider = "Computer Data", priority = 2)
	public void userCanViewComputerDataInEditPage(String computerName, String newcomputerName, String introducedDate,
			String discontinuedDate, String companyOption) throws InterruptedException, ParseException {
		mainComputerObj.clickonAddComputerBtn();
		addComputerObj.addNewComputer(computerName, introducedDate, discontinuedDate, companyOption);
		int numberAfterAdding = mainComputerObj.getComputersNumber();
		System.out.println("Number of computers after adding is : " + numberAfterAdding);
		Assert.assertTrue(mainComputerObj.actionSuccessMsg.getText().contains("has been created"),
				"No Assertion for 'has been created' success message");
		System.out.println("Success message of 'has been added' is shown");
		mainComputerObj.searchForComputerName(computerName);
		Assert.assertTrue(searchResultsObj.getComputerName().contains(computerName));
		searchResultsObj.selectingFirstRowinSearchResults();

		Thread.sleep(2000);
		Assert.assertTrue(editComputerObj.getComputerName().contains(computerName));
		Assert.assertTrue(editComputerObj.getIntroducedDate().contains(introducedDate));
		Assert.assertTrue(editComputerObj.getDiscountinuedDate().contains(discontinuedDate));
		Assert.assertTrue(editComputerObj.getCompanySelection().contains(companyOption));
		editComputerObj.editComputerName(newcomputerName);
		Assert.assertTrue(mainComputerObj.actionSuccessMsg.getText().contains("has been updated"),
				"No Assertion for 'has been updated' success message");
		System.out.println("Success message of 'has been updated' is shown");
	}
}
