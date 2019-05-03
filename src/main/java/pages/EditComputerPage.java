package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class EditComputerPage extends PageBase {

	public EditComputerPage(WebDriver driver) {
		super(driver);
	}

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

	public void editSavedComputer(String name, String introducedDate, String discontinuedDate, String companyoption) {
		typeInTxtBox(nameTxtBox, name);
		typeInTxtBox(introducedDateTxtBox, introducedDate);
		typeInTxtBox(discontinuedDateTxtBox, discontinuedDate);
		selectFromSelectElement(companyList, companyoption);
		clickBtn(saveComputerBtn);
		System.out.println("All computer data has been updated");

	}

	public void editComputerName(String name) {
		typeInTxtBox(nameTxtBox, name);
		clickBtn(saveComputerBtn);
		System.out.println("Computer Name is updated");
	}

	public void deleteSavedComputer() {
		clickBtn(deleteComputerBtn);
		System.out.println("Computer has been deleted");
	}

	public void cancelediting() {
		clickBtn(cancelBtn);
		System.out.println("Cancelling the editing of computer data");
	}

	public String sendComputerName() {
		return nameTxtBox.getAttribute("value");
	}

	public String sendIntroducedDate() {
		return introducedDateTxtBox.getAttribute("value");
	}

	public String sendDiscountinuedDate() {
		return discontinuedDateTxtBox.getAttribute("value");
	}

	public String sendCompanySelection() {
		Select elementSelect = new Select(companyList);
		return elementSelect.getFirstSelectedOption().getText();
	}

}
