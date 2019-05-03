package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddComputerPage extends PageBase {

	public AddComputerPage(WebDriver driver) {
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

	@FindBy(css = "input.btn.primary")
	private WebElement createComputerBtn;

	@FindBy(id = "a.btn")
	private WebElement cancelBtn;

	@FindBy(xpath = "//div[@class='input']//span[@class='help-inline' and text()='Required']")
	public WebElement nameRequiedLabel;

	@FindBy(xpath = "//div[@class='input']//span[@class='help-inline'and contains(text() , 'Date' )][1]")
	public WebElement introduceDateMissingLabel;

	public void addNewComputer(String name, String introducedDate, String discontinuedDate, String companyoption) {
		typeInTxtBox(nameTxtBox, name);
		typeInTxtBox(introducedDateTxtBox, introducedDate);
		typeInTxtBox(discontinuedDateTxtBox, discontinuedDate);
		selectFromSelectElement(companyList, companyoption);
		clickBtn(createComputerBtn);
		System.out.println("New computer has been added");
	}

	public void cancelediting() {
		clickBtn(cancelBtn);
		System.out.println("Cancelling the adding of computer data");
	}
}
