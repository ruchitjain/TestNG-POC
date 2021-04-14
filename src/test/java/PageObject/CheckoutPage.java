package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Helpers.BrowserActions;

public class CheckoutPage {

	BrowserActions browserActions;
	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		browserActions = new BrowserActions(driver);
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "(//span[contains(text(),'Proceed to checkout')])[2]")
	private WebElement proceedToCheckoutButton;

	@FindBy(how = How.ID, using = "cgv")
	private WebElement termsConditionsCheckbox;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Pay by bank wire')]")
	private WebElement payByBankWireButton;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'I confirm my order')]")
	private WebElement confirmOrderButton;
	
	@FindBy(how = How.XPATH, using = "//div[@id='center_column']/div/p/strong")
	private WebElement orderCompletionMessage;

	public void proceedToCheckout() {
		browserActions.waitToPageLoad();
		browserActions.waitForElementVisibility(proceedToCheckoutButton, driver);
		browserActions.click(proceedToCheckoutButton);
	}

	public void acceprTermsAndConditions() {
		browserActions.waitToPageLoad();
		browserActions.click(termsConditionsCheckbox);
	}

	public void clickPayByBankWireButton() {
		browserActions.waitToPageLoad();
		browserActions.waitForElementVisibility(payByBankWireButton, driver);
		browserActions.click(payByBankWireButton);
	}

	public void clickConfirmOrderButton() {
		browserActions.waitToPageLoad();
		browserActions.waitForElementVisibility(confirmOrderButton, driver);
		browserActions.click(confirmOrderButton);
	}
	
	public boolean verifyOrderCompletion() {
		String orderMessage = browserActions.getText(orderCompletionMessage);
		if("Your order on My Store is complete.".equalsIgnoreCase(orderMessage)) {
			return true;
		}else {
			return false;
		}
	}

}
