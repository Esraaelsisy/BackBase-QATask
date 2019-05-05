package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends PageBase {
	/**
	 * Page Class for the Home page
	 * 
	 * @param driver
	 */

	public MainPage(WebDriver driver) {
		super(driver);
	}

	/*
	 * Finding all needed WebElements in the MAIN page by their Locators
	 */
	@FindBy(id = "add")
	private WebElement addComputerBtn;

	@FindBy(id = "searchbox")
	private WebElement searchTxtBox;

	@FindBy(id = "searchsubmit")
	private WebElement searchSubmitBtn;

	@FindBy(id = "//header//a")
	private WebElement mainPageDirectionLink;

	@FindBy(css = "div.alert-message.warning")
	private WebElement actionSuccessMsg;

	@FindBy(xpath = "//section[@id='main']//h1")
	private WebElement computersNumberLabel;

	/*
	 * Function for clicking on "Add a new Computer" Button
	 */
	public void clickonAddComputerBtn() {
		System.out.println("User will click on 'Add a new Computer Button'");

		wait.until(ExpectedConditions.visibilityOf(addComputerBtn));
		clickBtn(addComputerBtn);

		System.out.println("User clicked on 'Add a new Computer Button' successfully");
	}

	/*
	 * Function for Searching for a computer by its name
	 * 
	 * @param computer name
	 */

	public void searchForComputerName(String searchValue) {
		System.out.println("User will search for computer name :  " + searchValue);
		// Typing $searchValue in search text box
		wait.until(ExpectedConditions.visibilityOf(searchTxtBox));
		typeInTxtBox(searchTxtBox, searchValue);
		// Clicking on Filter by name button
		wait.until(ExpectedConditions.visibilityOf(searchSubmitBtn));
		clickBtn(searchSubmitBtn);

		System.out.println("User searched for computer name :  " + searchValue + " successfully");
	}

	/*
	 * Function for getting Total number of added computers till now From the header
	 * label in Main Page
	 * 
	 */
	public int getComputersNumber() {
		wait.until(ExpectedConditions.visibilityOf(computersNumberLabel));
		System.out.println("Header Text is  " + computersNumberLabel.getText());
		String[] computersNum = computersNumberLabel.getText().split(" ");
		int number = new Integer(computersNum[0]);
		System.out.println("Number of computers Found now is :  " + number);
		return number;

	}

	/*
	 * Function for getting Text From the header label in Main Page
	 * 
	 */
	public String getComputersNumbersText() {
		wait.until(ExpectedConditions.visibilityOf(computersNumberLabel));
		String text = computersNumberLabel.getText();
		System.out.println("Header Text is  " + text);
		return text;

	}
	/*
	 * Function for getting the Action Success Message shown in Main Page
	 */

	public String getSuccessMsg() {
		wait.until(ExpectedConditions.visibilityOf(actionSuccessMsg));
		String text = actionSuccessMsg.getText();
		System.out.println("Header Text is  " + text);
		return text;

	}

	public void mainPageDirection() {
		wait.until(ExpectedConditions.visibilityOf(mainPageDirectionLink));
		clickBtn(mainPageDirectionLink);
		System.out.println("Clicking on Main Page Link from the header");
	}
}
