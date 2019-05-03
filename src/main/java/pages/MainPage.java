package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends PageBase {

	public MainPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "add")
	private WebElement addComputerBtn;

	@FindBy(id = "searchbox")
	private WebElement searchTxtBox;

	@FindBy(id = "searchsubmit")
	private WebElement searchSubmitBtn;

	@FindBy(css = "div.alert-message.warning")
	public WebElement actionSuccessMsg;

	@FindBy(xpath = "//section[@id='main']//h1")
	public WebElement computersNumberLabel;

	

	public void clickonAddComputerBtn() {
		clickBtn(addComputerBtn);
		System.out.println("Clicking on 'Add a new Computer Button'");
	}

	public void searchForComputerName(String searchValue) {
		typeInTxtBox(searchTxtBox, searchValue);
		clickBtn(searchSubmitBtn);
		System.out.println("Searching for computer name :  " + searchValue);
	}

	public int getComputersNumber() {
		System.out.println(computersNumberLabel.getText());
		String[] computersNum = computersNumberLabel.getText().split(" ");
		int number = new Integer(computersNum[0]);
		return number;

	}

}
