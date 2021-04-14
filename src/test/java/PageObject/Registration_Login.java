package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Helpers.BrowserActions;

public class Registration_Login {

	BrowserActions browserActions;

	public Registration_Login(WebDriver driver) {
		PageFactory.initElements(driver, this);
		browserActions = new BrowserActions(driver);
	}

	@FindBy(how = How.ID, using = "email_create")
	private WebElement createAccountEmail;

	@FindBy(how = How.ID, using = "SubmitCreate")
	private WebElement createAccountButton;
	
	public void enterEmailToCreateAccount(String email) throws Exception{
		browserActions.waitToPageLoad();
		Thread.sleep(2000l);
		browserActions.sendKeys(createAccountEmail, email);
		browserActions.click(createAccountButton);
	}
	
}
