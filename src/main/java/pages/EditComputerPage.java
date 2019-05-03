package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class EditComputerPage extends PageBase {

	public EditComputerPage(WebDriver driver) {
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

	@FindBy(xpath = "//input[@value='Save this computer' and @class='btn primary']")
	private WebElement saveComputerBtn;

	@FindBy(css = "a.btn")
	private WebElement cancelBtn;

	@FindBy(css = "input.btn.danger")
	private WebElement deleteComputerBtn;

	@FindBy(xpath = "//div[@class='input']//span[@class='help-inline' and text()='Required']")
	public WebElement nameRequiedLabel;

	@FindBy(xpath = "//div[@class='input']//span[@class='help-inline'and contains(text() , 'Date' )][1]")
	public WebElement introduceDateMissingLabel;

	/*
	 * Function for Editing a saved computer with all data
	 * 
	 * @param new computer name , introduced date , discontinued date and company
	 * selection
	 */
	public void editSavedComputer(String name, String introducedDate, String discontinuedDate, String companyoption) {
		typeInTxtBox(nameTxtBox, name);
		typeInTxtBox(introducedDateTxtBox, introducedDate);
		typeInTxtBox(discontinuedDateTxtBox, discontinuedDate);
		selectFromSelectElement(companyList, companyoption);
		clickBtn(saveComputerBtn);
		System.out.println(
				"New computer has been UPDATED with name :  " + name + " , Introduced Date :  " + introducedDate
						+ " , Discontinued Date :  " + discontinuedDate + " and Company Option :  " + companyoption);
	}

	/*
	 * Function for Editing a saved computer with its name
	 * 
	 * @param new computer name
	 */
	public void editComputerName(String name) {
		typeInTxtBox(nameTxtBox, name);
		clickBtn(saveComputerBtn);
		System.out.println("Computer Name is UPDATE with name :  " + name);
	}

	/*
	 * Function for Deleting a saved computer
	 */
	public void deleteSavedComputer() {
		clickBtn(deleteComputerBtn);
		System.out.println("Computer has been deleted");
	}

	public void cancelediting() {
		clickBtn(cancelBtn);
		System.out.println("Cancelling the editing of computer data");
	}

	public String getComputerName() {
		System.out.println("Computer name is :  " + nameTxtBox.getAttribute("value"));
		return nameTxtBox.getAttribute("value");
	}

	public String getIntroducedDate() {
		System.out.println("Introduced Date is :  " + introducedDateTxtBox.getAttribute("value"));
		return introducedDateTxtBox.getAttribute("value");
	}

	public String getDiscountinuedDate() {
		System.out.println("Discontinued Date is :  " + discontinuedDateTxtBox.getAttribute("value"));
		return discontinuedDateTxtBox.getAttribute("value");
	}

	public String getCompanySelection() {
		Select elementSelect = new Select(companyList);
		System.out.println("Company  Selection is :  " + elementSelect.getFirstSelectedOption().getText());
		return elementSelect.getFirstSelectedOption().getText();
	}

}
