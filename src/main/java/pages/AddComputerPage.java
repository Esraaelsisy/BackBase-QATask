package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddComputerPage extends PageBase {

	public AddComputerPage(WebDriver driver) {
		super(driver);
	}

	/*
	 * Finding all needed WebElements in the ADD page by their Locators
	 */
	@FindBy(id = "name")
	private WebElement nameTxtBox;

	@FindBy(id = "introduced")
	private WebElement introducedDateTxtBox;

	@FindBy(id = "discontinued")
	private WebElement discontinuedDateTxtBox;

	@FindBy(id = "company")
	private WebElement companyList;

	@FindBy(css = "input.btn.primary")
	private WebElement createComputerBtn;

	@FindBy(id = "a.btn")
	private WebElement cancelBtn;

	@FindBy(xpath = "//div[@class='input']//span[@class='help-inline' and text()='Required']")
	private WebElement nameRequiedLabel;

	@FindBy(xpath = "//div[@class='input']//span[@class='help-inline'and contains(text() , 'Date' )][1]")
	private WebElement introduceDateMissingLabel;

	/*
	 * Function for Adding a new computer with all data needed
	 * 
	 * @param computer name , introduced date , discontinued date and company
	 * selection
	 */
	public void addNewComputer(String name, String introducedDate, String discontinuedDate, String companyoption) {
		System.out.println("User will add a new computer Data");

		wait.until(ExpectedConditions.visibilityOf(nameTxtBox));
		typeInTxtBox(nameTxtBox, name);
		System.out.println("Computer name " + name + " is added successfully");

		wait.until(ExpectedConditions.visibilityOf(introducedDateTxtBox));
		typeInTxtBox(introducedDateTxtBox, introducedDate);
		System.out.println("Computer Introduced Date " + introducedDate + " is added successfully");

		wait.until(ExpectedConditions.visibilityOf(discontinuedDateTxtBox));
		typeInTxtBox(discontinuedDateTxtBox, discontinuedDate);
		System.out.println("Computer Discontinued Date " + discontinuedDate + " is added successfully");

		wait.until(ExpectedConditions.visibilityOf(companyList));
		selectFromSelectElement(companyList, companyoption);
		System.out.println("Computer Company " + companyoption + " is added successfully");

		wait.until(ExpectedConditions.visibilityOf(createComputerBtn));
		clickBtn(createComputerBtn);

		System.out.println("New computer has been CREATED successfully with name :  " + name + " , Introduced Date :  "
				+ introducedDate + " , Discontinued Date :  " + discontinuedDate + " and Company Option :  "
				+ companyoption);
	}

	/*
	 * Function for canceling Adding a new computer data
	 */
	public void canceladding() {
		System.out.println("User will cancel the adding of computer data");

		wait.until(ExpectedConditions.visibilityOf(cancelBtn));
		clickBtn(cancelBtn);

		System.out.println("User canceled the adding of computer data successfully");
	}

	public String getColorOfNameRequiredLabel() {
		wait.until(ExpectedConditions.visibilityOf(nameRequiedLabel));
		String color = nameRequiedLabel.getCssValue("color");
		return color;
	}

	public String getColorofDateFormatLabel() {
		wait.until(ExpectedConditions.visibilityOf(introduceDateMissingLabel));
		String color = introduceDateMissingLabel.getCssValue("color");
		return color;

	}
}
