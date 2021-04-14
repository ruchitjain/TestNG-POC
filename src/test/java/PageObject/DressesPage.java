package PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Helpers.BrowserActions;

public class DressesPage {

	BrowserActions browserActions;
	WebDriver driver;

	public DressesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		browserActions = new BrowserActions(driver);
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "(//div[@id='center_column']/ul/li)[3]")
	private WebElement dressItem;

	@FindBy(how = How.XPATH, using = "(//div[@id='center_column']/ul/li)[3]//span[contains(text(),'Add to cart')]")
	private WebElement addToCartButton;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Proceed to checkout')]")
	private WebElement proceedToCheckoutButton;

	public void selectProductAndAddToCart() {
		browserActions.waitToPageLoad();
		browserActions.moveToElement(dressItem);
		browserActions.waitForElementVisibility(addToCartButton, driver);
		browserActions.click(addToCartButton);
	}

	public void proceedToCheckout() {
		browserActions.waitToPageLoad();
		browserActions.waitForElementVisibility(proceedToCheckoutButton, driver);
		browserActions.click(proceedToCheckoutButton);
	}

}
