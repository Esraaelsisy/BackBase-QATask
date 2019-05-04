package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.helper;

public class EditComputerTest extends TestBase {

	@Test(dataProvider = "Computer Data", priority = 1)
	public void userCanEditComputerName(String computerName, String newcomputerName, String introducedDate,
			String discontinuedDate, String companyOption) {
		try {
			System.out.println("========================================================");
			System.out.println("========================================================");
			System.out.println(
					new Throwable().getStackTrace()[0].getMethodName() + " Test will be executed now with data "
							+ computerName + " , " + introducedDate + " , " + discontinuedDate + " , " + companyOption);

			int numberBeforeAdding = mainComputerObj.getComputersNumber();
			System.out.println("Number of computers before adding is : " + numberBeforeAdding);
			mainComputerObj.clickonAddComputerBtn();
			addComputerObj.addNewComputer(computerName, introducedDate, discontinuedDate, companyOption);
			int numberAfterAdding = mainComputerObj.getComputersNumber();
			System.out.println("Number of computers after adding is : " + numberAfterAdding);
			Assert.assertTrue(mainComputerObj.getSuccessMsg().contains("has been created"),
					"No Assertion for 'has been created' success message");
			System.out.println("Success message of 'has been added' is shown");
			Assert.assertTrue(numberAfterAdding == (numberBeforeAdding + 1),
					"Number of computers is not increased by 1");
			mainComputerObj.searchForComputerName(computerName);
			Assert.assertTrue(searchResultsObj.getComputerName().contains(computerName));
			searchResultsObj.selectingFirstRowinSearchResults();
			editComputerObj.editComputerName(newcomputerName);
			Assert.assertTrue(mainComputerObj.getSuccessMsg().contains("has been updated"),
					"No Assertion for 'has been updated' success message");
			System.out.println("Success message of 'has been updated' is shown");
		} catch (Exception e) {
			System.out.println(
					"Exception in " + new Throwable().getStackTrace()[0].getMethodName() + " is :" + e.getMessage());
		}
	}

	@Test(dataProvider = "Computer Data", priority = 2)
	public void userCanEditSavedComputerData(String computerName, String newcomputerName, String introducedDate,
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
			Assert.assertTrue(searchResultsObj.getComputerName().contains(computerName));
			searchResultsObj.selectingFirstRowinSearchResults();
			editComputerObj.editSavedComputer(newcomputerName, introducedDate, discontinuedDate, companyOption);
			Assert.assertTrue(mainComputerObj.getSuccessMsg().contains("has been updated"),
					"No Assertion for 'has been updated' success message");
			System.out.println("Success message of 'has been updated' is shown");
		} catch (Exception e) {
			System.out.println(
					"Exception in " + new Throwable().getStackTrace()[0].getMethodName() + " is :" + e.getMessage());
		}
	}

	@Test(dataProvider = "Computer Data", priority = 3)
	public void userCannotEditComputerWithoutName(String computerName, String newcomputerName, String introducedDate,
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
			Assert.assertTrue(searchResultsObj.getComputerName().contains(computerName));
			searchResultsObj.selectingFirstRowinSearchResults();
			editComputerObj.editSavedComputer("", introducedDate, discontinuedDate, companyOption);
			String color = helper.colorFormatter(editComputerObj.getColorOfNameRequiredLabel());
			System.out.println(color);
			Assert.assertTrue(color.contains("#9d261d"));
			helper.captureScreenshot(driver, "Missing Name in Edit Computer Page");
			editComputerObj.editComputerName(newcomputerName);
			Assert.assertTrue(mainComputerObj.getSuccessMsg().contains("has been updated"),
					"No Assertion for 'has been updated' success message");
			System.out.println("Success message of 'has been updated' is shown");
		} catch (Exception e) {
			System.out.println(
					"Exception in " + new Throwable().getStackTrace()[0].getMethodName() + " is :" + e.getMessage());
		}
	}
}