package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends PageBase {

	public SearchResultsPage(WebDriver driver) {
		super(driver);
	}

	/*
	 * Function for clicking on "Add a new Computer" Button
	 */
	@FindBy(xpath = "//table[@class='computers zebra-striped']//tbody//tr[1]//a")
	private WebElement firstRowLink;
	@FindBy(xpath = "//table[@class='computers zebra-striped']//tbody//tr[1]//td[2]")
	private WebElement firstRowIntoducedDateLabel;
	@FindBy(xpath = "//table[@class='computers zebra-striped']//tbody//tr[1]//td[3]")
	private WebElement firstRowDiscontinuedDateLabel;
	@FindBy(xpath = "//table[@class='computers zebra-striped']//tbody//tr[1]//td[4]")
	private WebElement firstRowCompanyLabel;

	public void selectingFirstRowinSearchResults() {
		clickBtn(firstRowLink);
		System.out.println("Clicking on the computer name link from the first row");
	}

	public String getComputerName() {
		System.out.println("Computer Name found is :  " + firstRowLink.getText());
		return firstRowLink.getText();
	}

	public String getIntroducedDate() {
		System.out.println("Computer Introduced Date found is :  " + firstRowIntoducedDateLabel.getText());
		return firstRowIntoducedDateLabel.getText();
	}

	public String getDiscontinuedDate() {
		System.out.println("Computer Discontinued Date found is :  " + firstRowDiscontinuedDateLabel.getText());
		return firstRowDiscontinuedDateLabel.getText();
	}

	public String getCompanyOption() {
		System.out.println("Computer Company Selection found is :  " + firstRowCompanyLabel.getText());
		return firstRowCompanyLabel.getText();
	}

}
