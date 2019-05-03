package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends PageBase {

	public SearchResultsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//table[@class='computers zebra-striped']//tbody//tr[1]//a")
	public WebElement firstRowLink;
	@FindBy(xpath = "//table[@class='computers zebra-striped']//tbody//tr[1]//td[2]")
	public WebElement firstRowIntoducedDateLabel;
	@FindBy(xpath = "//table[@class='computers zebra-striped']//tbody//tr[1]//td[3]")
	public WebElement firstRowDiscontinuedDateLabel;
	@FindBy(xpath = "//table[@class='computers zebra-striped']//tbody//tr[1]//td[4]")
	public WebElement firstRowCompanyLabel;

	public void selectingFirstRowinSearchResults() {
		clickBtn(firstRowLink);
		System.out.println("Clicking on the computer name link from the first row");
	}

}
