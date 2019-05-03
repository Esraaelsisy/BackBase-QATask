package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.helper;

public class AddComputerTest extends TestBase {

	@Test(dataProvider = "Computer Data", priority = 1)
	public void userCanAddNewComputer(String computerName, String newcomputerName, String introducedDate,
			String discontinuedDate, String companyOption) throws InterruptedException {
		Thread.sleep(2000);
		mainComputerObj.clickonAddComputerBtn();
		addComputerObj.addNewComputer(computerName, introducedDate, discontinuedDate, companyOption);
		int numberAfterAdding = mainComputerObj.getComputersNumber();
		System.out.println("Number of computers after adding is : " + numberAfterAdding);
		Assert.assertTrue(mainComputerObj.actionSuccessMsg.getText().contains("has been created"),
				"No Assertion for 'has been created' success message");
		System.out.println("Success message of 'has been added' is shown");
	}

	@Test(dataProvider = "Computer Data", priority = 2)
	public void userCannotAddComputerWithoutName(String computerName, String newcomputerName, String introducedDate,
			String discontinuedDate, String companyOption) throws InterruptedException {
		Thread.sleep(2000);
		mainComputerObj.clickonAddComputerBtn();
		addComputerObj.addNewComputer("", introducedDate, discontinuedDate, companyOption);
		String color = helper.colorFormatter(addComputerObj.nameRequiedLabel.getCssValue("color"));
		System.out.println(color);
		Assert.assertTrue(color.contains("#9d261d"));
		addComputerObj.addNewComputer(computerName, introducedDate, discontinuedDate, companyOption);
		int numberAfterAdding = mainComputerObj.getComputersNumber();
		System.out.println("Number of computers after adding is : " + numberAfterAdding);
		Assert.assertTrue(mainComputerObj.actionSuccessMsg.getText().contains("has been created"),
				"No Assertion for 'has been created' success message");
		System.out.println("Success message of 'has been added' is shown");
	}

	@Test(dataProvider = "Computer Data", priority = 3)
	public void userCannotAddComputerWithInvalidDates(String computerName, String newcomputerName,
			String introducedDate, String discontinuedDate, String companyOption) throws InterruptedException {
		Thread.sleep(2000);
		mainComputerObj.clickonAddComputerBtn();
		addComputerObj.addNewComputer(computerName, newcomputerName, discontinuedDate, companyOption);
		String color = helper.colorFormatter(addComputerObj.introduceDateMissingLabel.getCssValue("color"));
		System.out.println(color);
		Assert.assertTrue(color.contains("#9d261d"));
		addComputerObj.addNewComputer(computerName, introducedDate, discontinuedDate, companyOption);
		int numberAfterAdding = mainComputerObj.getComputersNumber();
		System.out.println("Number of computers after adding is : " + numberAfterAdding);
		Assert.assertTrue(mainComputerObj.actionSuccessMsg.getText().contains("has been created"),
				"No Assertion for 'has been created' success message");
		System.out.println("Success message of 'has been added' is shown");
	}

}
