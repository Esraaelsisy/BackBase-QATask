package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchResultsPage extends PageBase {
	/**
	 * Page Class for the Search Results page
	 * 
	 * @param driver
	 */

	public SearchResultsPage(WebDriver driver) {
		super(driver);
	}

	/*
	 * Finding all needed WebElements in the SEARCH RESULTS page by their Locators
	 */
	@FindBy(xpath = "//table[@class='computers zebra-striped']//tbody//tr[1]//a")
	private WebElement firstRowLink;

	@FindBy(xpath = "//table[@class='computers zebra-striped']//tbody//tr[1]//td[2]")
	private WebElement firstRowIntoducedDateLabel;

	@FindBy(xpath = "//table[@class='computers zebra-striped']//tbody//tr[1]//td[3]")
	private WebElement firstRowDiscontinuedDateLabel;

	@FindBy(xpath = "//table[@class='computers zebra-striped']//tbody//tr[1]//td[4]")
	private WebElement firstRowCompanyLabel;

	/*
	 * Clicking on the first results in the computers table
	 */
	public void selectingFirstRowinSearchResults() {
		System.out.println("User will click on the computer name link from the first row");

		wait.until(ExpectedConditions.visibilityOf(firstRowLink));
		clickBtn(firstRowLink);

		System.out.println("User clicked on computer name link from the first row successfully");
	}

	/*
	 * Retrieving Computer name from Computers Table
	 */
	public String getComputerName() {
		wait.until(ExpectedConditions.visibilityOf(firstRowLink));
		System.out.println("Computer Name found is :  " + firstRowLink.getText());

		return firstRowLink.getText();
	}

	/*
	 * Retrieving Computer Introduced Date from Computers Table
	 */
	public String getIntroducedDate() {
		wait.until(ExpectedConditions.visibilityOf(firstRowIntoducedDateLabel));
		System.out.println("Computer Introduced Date found is :  " + firstRowIntoducedDateLabel.getText());

		return firstRowIntoducedDateLabel.getText();
	}

	/*
	 * Retrieving Computer Discontinued Date from Computers Table
	 */
	public String getDiscontinuedDate() {
		wait.until(ExpectedConditions.visibilityOf(firstRowDiscontinuedDateLabel));
		System.out.println("Computer Discontinued Date found is :  " + firstRowDiscontinuedDateLabel.getText());

		return firstRowDiscontinuedDateLabel.getText();
	}

	/*
	 * Retrieving Computer Company from Computers Table
	 */
	public String getCompanyOption() {
		wait.until(ExpectedConditions.visibilityOf(firstRowCompanyLabel));
		System.out.println("Computer Company Selection found is :  " + firstRowCompanyLabel.getText());

		return firstRowCompanyLabel.getText();
	}

}
