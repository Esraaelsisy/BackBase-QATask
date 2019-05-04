package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {
	public WebDriver driver;
	public WebDriverWait wait;

	/**
	 * @author Esraa.elsisy Initializing Elements will be used in all Page Classes
	 *         by using PageFactory in PageBase Constructor and WebDriverWait to use
	 *         explicit wait before using any element
	 * 
	 * @param driver
	 **/
	public PageBase(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 2);
	}

	/*** Generic Methods for Elements Handling ***/

	/*
	 * Generic Method for clicking on Buttons or Links
	 */
	protected void clickBtn(WebElement element) {

		element.click();
	}

	/*
	 * Generic Method for typing in any TextBox
	 */
	protected void typeInTxtBox(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	/*
	 * Generic Method for selecting any Visible Text from DropDownList
	 */
	protected void selectFromSelectElement(WebElement element, String text) {
		Select elementSelect = new Select(element);
		elementSelect.selectByVisibleText(text);

	}
}
