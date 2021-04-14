package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Helpers.BrowserActions;

public class HomePage {

	BrowserActions browserActions;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		browserActions = new BrowserActions(driver);
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Sign in')]")
	private WebElement signInButton;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Sign out')]")
	private WebElement signOutButton;

	@FindBy(how = How.XPATH, using = "(//a[contains(text(),'Dresses')])[5]")
	private WebElement dressesButton;

	/*
	 * Methods
	 */
	public void clickSignIn() throws Exception {
		browserActions.waitToPageLoad();
		Thread.sleep(2000l);
		browserActions.click(signInButton);
	}

	public void clickSignOut() throws Exception {
		browserActions.waitToPageLoad();
		Thread.sleep(2000l);
		browserActions.click(signOutButton);
	}

	public void clickdressesButton() throws Exception {
		browserActions.waitToPageLoad();
		Thread.sleep(2000l);
		browserActions.click(dressesButton);
	}
}
