package gridTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.helper;

public class AddComputerParallelTest extends TestBaseforSeleniumGrid {

	@Test(priority = 1, alwaysRun = true, groups = { "Regression" })
	public void userCanAddNewComputer() {

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

		} catch (Exception e) {
			System.out.println(
					"Exception in " + new Throwable().getStackTrace()[0].getMethodName() + " is :" + e.getMessage());

		}
	}

	@Test(priority = 2, groups = { "Regression" })
	public void userCannotAddComputerWithoutName() {
		try {

			System.out.println("========================================================");
			System.out.println(
					new Throwable().getStackTrace()[0].getMethodName() + " Test will be executed now with data "
							+ computerName + " , " + introducedDate + " , " + discontinuedDate + " , " + companyOption);

			// getting Number of computers before adding a new computer data
			mainComputerObj.getComputersNumber();

			// Requesting "Add a new computer" button from Main Page
			mainComputerObj.clickonAddComputerBtn();

			// Entering the computer data in Add computer Page
			addComputerObj.addNewComputer(wrongcomputerName, introducedDate, discontinuedDate, companyOption);

			// getting color of Required Name Label
			String color = helper.colorFormatter(addComputerObj.getColorOfNameRequiredLabel());
			System.out.println("Name Field's Color formated in hex is " + color);

			// Asserting the color of Required name label
			Assert.assertTrue(color.contains("#9d261d"));
			helper.captureScreenshot(getDriver(), "No  Name in Add Computer Page");

			// Entering the computer data in Add computer Page
			addComputerObj.addNewComputer(computerName, introducedDate, discontinuedDate, companyOption);

			// getting Number of computers after adding a new computer data
			mainComputerObj.getComputersNumber();

			// Asserting the creation success message is shown in Main Page
			Assert.assertTrue(mainComputerObj.getSuccessMsg().contains("has been created"),
					"No Assertion for 'has been created' success message");
			System.out.println("Success message of 'has been CREATED' is shown");

		} catch (Exception e) {
			System.out.println(
					"Exception in " + new Throwable().getStackTrace()[0].getMethodName() + " is :" + e.getMessage());

		}

	}

	@Test(priority = 3, groups = { "Not Regression" })
	public void userCannotAddComputerWithInvalidDates() {

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
			addComputerObj.addNewComputer(computerName, wrongintroducedDate, wrongdiscontinuedDate, companyOption);

			// getting color of Invalid Date format Label
			String color = helper.colorFormatter(addComputerObj.getColorofDateFormatLabel());
			System.out.println("Introduced Date  Field's Color formated in hex is " + color);

			// Asserting color of Invalid Date format Label
			Assert.assertTrue(color.contains("#9d261d"));
			helper.captureScreenshot(getDriver(), "Invalid Dates in Add Computer Page");

			// Entering the computer data in Add computer Page
			addComputerObj.addNewComputer(computerName, introducedDate, discontinuedDate, companyOption);

			// getting Number of computers after adding a new computer data
			mainComputerObj.getComputersNumber();

			// Asserting the creation success message is shown in Main Page
			Assert.assertTrue(mainComputerObj.getSuccessMsg().contains("has been created"),
					"No Assertion for 'has been created' success message");
			System.out.println("Success message of 'has been CREATED' is shown");

		} catch (Exception e) {
			System.out.println(
					"Exception in " + new Throwable().getStackTrace()[0].getMethodName() + " is :" + e.getMessage());

		}
	}

}
