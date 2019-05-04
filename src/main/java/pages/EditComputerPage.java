package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class EditComputerPage extends PageBase {

	public EditComputerPage(WebDriver driver) {
		super(driver);
	}

	/*
	 * Finding all needed WebElements in the EDIT page by their Locators
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
		System.out.println("User will edit All saved computer Data ");

		wait.until(ExpectedConditions.visibilityOf(nameTxtBox));
		typeInTxtBox(nameTxtBox, name);
		System.out.println("Computer Name " + name + " is updated successfully");

		wait.until(ExpectedConditions.visibilityOf(introducedDateTxtBox));
		typeInTxtBox(introducedDateTxtBox, introducedDate);
		System.out.println("Computer Introduced Date " + introducedDate + " is updated successfully");

		wait.until(ExpectedConditions.visibilityOf(discontinuedDateTxtBox));
		typeInTxtBox(discontinuedDateTxtBox, discontinuedDate);
		System.out.println("Computer Discontinued Date " + discontinuedDate + " is updated successfully");

		wait.until(ExpectedConditions.visibilityOf(companyList));
		selectFromSelectElement(companyList, companyoption);
		System.out.println("Computer Company List " + companyoption + " is updated successfully");

		wait.until(ExpectedConditions.visibilityOf(saveComputerBtn));
		clickBtn(saveComputerBtn);

		System.out.println("New computer has been UPDATED successfully with name :  " + name + " , Introduced Date :  "
				+ introducedDate + " , Discontinued Date :  " + discontinuedDate + " and Company Option :  "
				+ companyoption);
	}

	/*
	 * Function for Editing a saved computer with its name
	 * 
	 * @param new computer name
	 */
	public void editComputerName(String name) {
		System.out.println("User will edit a saved computer Name ");

		wait.until(ExpectedConditions.visibilityOf(nameTxtBox));
		typeInTxtBox(nameTxtBox, name);
		System.out.println("Computer Name " + name + " is updated successfully");

		wait.until(ExpectedConditions.visibilityOf(saveComputerBtn));
		clickBtn(saveComputerBtn);
		System.out.println("Computer Name is UPDATED successfully with name :  " + name);
	}

	/*
	 * Function for Deleting a saved computer Data
	 */
	public void deleteSavedComputer() {
		System.out.println("User will delete this computer");

		wait.until(ExpectedConditions.visibilityOf(deleteComputerBtn));
		clickBtn(deleteComputerBtn);

		System.out.println("Computer has been deleted successfully");
	}

	public void cancelediting() {
		System.out.println("User will cancel the editing of computer data");

		wait.until(ExpectedConditions.visibilityOf(cancelBtn));
		clickBtn(cancelBtn);

		System.out.println("User canceled the editing of computer data successfully");
	}

	public String getComputerName() {
		wait.until(ExpectedConditions.visibilityOf(nameTxtBox));
		System.out.println("Computer name shown is :  " + nameTxtBox.getAttribute("value"));

		return nameTxtBox.getAttribute("value");
	}

	public String getIntroducedDate() {
		wait.until(ExpectedConditions.visibilityOf(introducedDateTxtBox));
		System.out.println("Introduced Date shown is :  " + introducedDateTxtBox.getAttribute("value"));

		return introducedDateTxtBox.getAttribute("value");
	}

	public String getDiscountinuedDate() {
		wait.until(ExpectedConditions.visibilityOf(discontinuedDateTxtBox));
		System.out.println("Discontinued Date shown is :  " + discontinuedDateTxtBox.getAttribute("value"));

		return discontinuedDateTxtBox.getAttribute("value");
	}

	public String getCompanySelection() {
		Select elementSelect = new Select(companyList);
		wait.until(ExpectedConditions.visibilityOf(companyList));
		System.out.println("Company  Selection shown is :  " + elementSelect.getFirstSelectedOption().getText());

		return elementSelect.getFirstSelectedOption().getText();
	}

}
