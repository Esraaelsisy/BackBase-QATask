package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {
	protected WebDriver driver;

	public PageBase(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	protected void clickBtn(WebElement element) {

		element.click();
	}

	protected void typeInTxtBox(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	protected void selectFromSelectElement(WebElement element, String text) {
		Select elementSelect =  new Select(element);
		elementSelect.selectByVisibleText(text);

	}
}
