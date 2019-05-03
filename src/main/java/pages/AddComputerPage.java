package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddComputerPage extends PageBase {

	public AddComputerPage(WebDriver driver) {
		super(driver);
	}

	/*
	 * Finding all needed WebElements in the page by their Locators
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
	public WebElement nameRequiedLabel;

	@FindBy(xpath = "//div[@class='input']//span[@class='help-inline'and contains(text() , 'Date' )][1]")
	public WebElement introduceDateMissingLabel;

	/*
	 * Function for Adding a new computer with all data needed
	 * 
	 * @param computer name , introduced date , discontinued date and company
	 * selection
	 */
	public void addNewComputer(String name, String introducedDate, String discontinuedDate, String companyoption) {
		typeInTxtBox(nameTxtBox, name);
		typeInTxtBox(introducedDateTxtBox, introducedDate);
		typeInTxtBox(discontinuedDateTxtBox, discontinuedDate);
		selectFromSelectElement(companyList, companyoption);
		clickBtn(createComputerBtn);
		System.out.println(
				"New computer has been CREATED with name :  " + name + " , Introduced Date :  " + introducedDate
						+ " , Discontinued Date :  " + discontinuedDate + " and Company Option :  " + companyoption);
	}

	/*
	 * Function for canceling Adding a new computer data
	 */
	public void canceladding() {
		clickBtn(cancelBtn);
		System.out.println("Cancelling the adding of computer data");
	}
}
