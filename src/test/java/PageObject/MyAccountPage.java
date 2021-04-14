package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Helpers.BrowserActions;

public class MyAccountPage {

	BrowserActions browserActions;

	public MyAccountPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		browserActions = new BrowserActions(driver);
	}

	@FindBy(how = How.XPATH, using = "//div[@id='center_column']/h1")
	private WebElement myAccountText;

	@FindBy(how = How.XPATH, using = "//div[@id='center_column']/h1")
	private WebElement authenticationText;

	public boolean verifyMyAccountText() {
		if (browserActions.getText(myAccountText).equalsIgnoreCase("My Account")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyAuthenticationText() throws Exception{
		Thread.sleep(3000l);
		if (browserActions.getText(authenticationText).equalsIgnoreCase("Authentication")) {
			return true;
		} else {
			return false;
		}
	}

	
	
}
