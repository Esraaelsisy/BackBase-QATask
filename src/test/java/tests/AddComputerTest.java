package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.helper;

public class AddComputerTest extends TestBase {

	@Test(dataProvider = "Computer Data", priority = 1)
	public void userCanAddNewComputer(String computerName, String newcomputerName, String introducedDate,
			String discontinuedDate, String companyOption) {
		try {
			System.out.println("========================================================");
			System.out.println("========================================================");
			System.out.println(
					new Throwable().getStackTrace()[0].getMethodName() + " Test will be executed now with data "
							+ computerName + " , " + introducedDate + " , " + discontinuedDate + " , " + companyOption);
			mainComputerObj.clickonAddComputerBtn();
			addComputerObj.addNewComputer(computerName, introducedDate, discontinuedDate, companyOption);
			mainComputerObj.getComputersNumber();
			Assert.assertTrue(mainComputerObj.getSuccessMsg().contains("has been created"),
					"No Assertion for 'has been created' success message");
			System.out.println("Success message of 'has been CREATED' is shown");

		} catch (Exception e) {
			System.out.println(
					"Exception in " + new Throwable().getStackTrace()[0].getMethodName() + " is :" + e.getMessage());
		}
	}

	@Test(dataProvider = "Computer Data", priority = 2)
	public void userCannotAddComputerWithoutName(String computerName, String newcomputerName, String introducedDate,
			String discontinuedDate, String companyOption) {
		try {
			
			System.out.println("========================================================");
			System.out.println(
					new Throwable().getStackTrace()[0].getMethodName() + " Test will be executed now with data "
							+ computerName + " , " + introducedDate + " , " + discontinuedDate + " , " + companyOption);
			mainComputerObj.clickonAddComputerBtn();
			addComputerObj.addNewComputer("", introducedDate, discontinuedDate, companyOption);
			String color = helper.colorFormatter(addComputerObj.getColorOfNameRequiredLabel());
			System.out.println("Name Field's Color formated in hex is " + color);
			Assert.assertTrue(color.contains("#9d261d"));
			helper.captureScreenshot(driver, "No  Name in Add Computer Page");
			addComputerObj.addNewComputer(computerName, introducedDate, discontinuedDate, companyOption);
			mainComputerObj.getComputersNumber();
			Assert.assertTrue(mainComputerObj.getSuccessMsg().contains("has been created"),
					"No Assertion for 'has been created' success message");
			System.out.println("Success message of 'has been CREATED' is shown");
		} catch (Exception e) {
			System.out.println(
					"Exception in " + new Throwable().getStackTrace()[0].getMethodName() + " is :" + e.getMessage());
		}

	}

	@Test(dataProvider = "Computer Data", priority = 3)
	public void userCannotAddComputerWithInvalidDates(String computerName, String newcomputerName,
			String introducedDate, String discontinuedDate, String companyOption) {
		try {
			System.out.println("========================================================");
			System.out.println("========================================================");
			System.out.println(
					new Throwable().getStackTrace()[0].getMethodName() + " Test will be executed now with data "
							+ computerName + " , " + introducedDate + " , " + discontinuedDate + " , " + companyOption);
			mainComputerObj.clickonAddComputerBtn();
			addComputerObj.addNewComputer(computerName, newcomputerName, discontinuedDate, companyOption);
			String color = helper.colorFormatter(addComputerObj.getColorofDateFormatLabel());
			System.out.println("Introduced Date  Field's Color formated in hex is " + color);
			Assert.assertTrue(color.contains("#9d261d"));
			helper.captureScreenshot(driver, "Invalid Dates in Add Computer Page");
			addComputerObj.addNewComputer(computerName, introducedDate, discontinuedDate, companyOption);
			mainComputerObj.getComputersNumber();
			Assert.assertTrue(mainComputerObj.getSuccessMsg().contains("has been created"),
					"No Assertion for 'has been created' success message");
			System.out.println("Success message of 'has been CREATED' is shown");
		} catch (Exception e) {
			System.out.println(
					"Exception in " + new Throwable().getStackTrace()[0].getMethodName() + " is :" + e.getMessage());
		}
	}

}
