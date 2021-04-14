package PageObject;

import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import Helpers.BrowserActions;

public class CreateAccountPage {

	BrowserActions browserActions;
	WebDriver driver;

	public CreateAccountPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		browserActions = new BrowserActions(driver);
		this.driver = driver; 
	}

	@FindBy(how = How.ID, using = "uniform-id_gender1")
	private WebElement title_mr;

	@FindBy(how = How.ID, using = "customer_firstname")
	private WebElement firstName;

	@FindBy(how = How.ID, using = "customer_lastname")
	private WebElement lastName;

	@FindBy(how = How.ID, using = "email")
	private WebElement email;

	@FindBy(how = How.ID, using = "passwd")
	private WebElement password;

	@FindBy(how = How.ID, using = "days")
	private WebElement day_DOB_Select;

	@FindBy(how = How.ID, using = "months")
	private WebElement month_DOB_Select;

	@FindBy(how = How.ID, using = "years")
	private WebElement year_DOB_Select;

	@FindBy(how = How.ID, using = "firstname")
	private WebElement addressFirstName;

	@FindBy(how = How.ID, using = "lastname")
	private WebElement addressLastName;

	@FindBy(how = How.ID, using = "company")
	private WebElement company;

	@FindBy(how = How.ID, using = "address1")
	private WebElement addressLine1;

	@FindBy(how = How.ID, using = "city")
	private WebElement city;

	@FindBy(how = How.ID, using = "id_state")
	private WebElement state_Select;

	@FindBy(how = How.ID, using = "postcode")
	private WebElement postcode;

	@FindBy(how = How.ID, using = "id_country")
	private WebElement country_Select;

	@FindBy(how = How.ID, using = "phone_mobile")
	private WebElement mobileNumber;

	@FindBy(how = How.ID, using = "alias")
	private WebElement addressAlias;

	@FindBy(how = How.ID, using = "submitAccount")
	private WebElement registerButton;

	public void fillAndSubmitRegistrationForm(String data[]) throws Exception {
		browserActions.waitToPageLoad();
		Thread.sleep(3000l);
//		String data[][] = new String[obj.length][];
//
//		int counter = 0;
//		for (Object[] s : obj) {
//			data[counter++] = Arrays.copyOf(s, s.length, String[].class);
//		}

		browserActions.click(title_mr);

		browserActions.sendKeys(firstName, data[0]);

		browserActions.sendKeys(lastName, data[1]);

		browserActions.sendKeys(password, data[2]);

		browserActions.sendKeys(day_DOB_Select, data[3]);

		browserActions.sendKeys(month_DOB_Select, data[4]);

		browserActions.sendKeys(year_DOB_Select, data[5]);

		browserActions.sendKeys(company, data[6]);

		browserActions.sendKeys(addressLine1, data[7]);

		browserActions.sendKeys(city, data[8]);

		browserActions.sendKeys(state_Select, data[9]);

		browserActions.sendKeys(postcode, data[10]);

		browserActions.sendKeys(country_Select, data[11]);

		browserActions.sendKeys(mobileNumber, data[12]);

		browserActions.sendKeys(addressAlias, data[13]);

		browserActions.click(registerButton);

	}

	public boolean verifyEmailOnRegistrationForm(String email) throws Exception {
		Thread.sleep(3000l);
		browserActions.waitForElementVisibility(this.email, driver);
		String actualEmail = browserActions.getValue(this.email, "value");
		//System.out.println("Current thread" + Thread.currentThread().getId() + "  " + email + "   " + actualEmail);
		if (actualEmail.equalsIgnoreCase(email)) {
			return true;
		} else {
			return false;
		}
	}

}
