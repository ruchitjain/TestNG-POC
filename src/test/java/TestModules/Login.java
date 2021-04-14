package TestModules;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageObject.CheckoutPage;
import PageObject.CreateAccountPage;
import PageObject.DressesPage;
import PageObject.HomePage;
import PageObject.MyAccountPage;
import PageObject.Registration_Login;
import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(listeners.MyListener.class)
public class Login {
	public WebDriver driver;
	public Registration_Login registration_login;
	public HomePage homepage;
	public CreateAccountPage createaccountpage;
	public MyAccountPage myaccountpage;
	public DressesPage dressespage;
	public CheckoutPage checkoutpage;
	SoftAssert softAssert;

	@DataProvider(name = "registrationFormData", parallel = true)
	public Object[][] getRegistrationFormData(Method m) {
		m.getName();
		return new Object[][] {
//				{ "Ruchit", "Jain", "Test@123", "7", "June", "1996", "Sopra Steria", "36, Suraj nagar Azadpur",
//						"New Delhi", "Delhi", "110033", "India", "8010334243", "Home AZ" },
				{ "Anchit", "Jain", "Test@123", "23", "August", "1994", "PayU", "M31 Model Town 3", "New Delhi",
						"Delhi", "11009", "India", "9717820110", "Home MT" } };
	}

	@BeforeSuite
	public void beforeSuite() {
		// System.setProperty("", null);
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
	}

	@BeforeTest
	public void beforeTest() {
		//WebDriverManager.chromedriver().setup();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		registration_login = new Registration_Login(driver);
		homepage = new HomePage(driver);
		createaccountpage = new CreateAccountPage(driver);
		myaccountpage = new MyAccountPage(driver);
		dressespage = new DressesPage(driver);
		checkoutpage = new CheckoutPage(driver);
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

	@BeforeMethod
	public void BeforeMethod() {
		softAssert = new SoftAssert();
	}

	@Test(dataProvider = "registrationFormData", retryAnalyzer = Helpers.RetryManager.class)

	public void createNewAccount(String[] testData) throws Exception {
		driver.get("http://automationpractice.com/index.php");
		String email = "ruchit" + System.currentTimeMillis() + Thread.currentThread().getId() + "@gmail.com";
		homepage.clickSignIn();
		registration_login.enterEmailToCreateAccount(email);
		softAssert.assertEquals(createaccountpage.verifyEmailOnRegistrationForm(email), true);
		softAssert.assertAll();
		createaccountpage.fillAndSubmitRegistrationForm(testData);
		Assert.assertEquals(myaccountpage.verifyMyAccountText(), true);
	}

	@Test(dependsOnMethods = { "createNewAccount",
			"performDressCheckout" }, priority = 2, retryAnalyzer = Helpers.RetryManager.class)
	@Parameters({"logoutMessage"})
	public void logout( @Optional("Optional Parameter Used") String logoutMessage) throws Exception {
		System.out.println(logoutMessage);
		homepage.clickSignOut();
		Assert.assertEquals(myaccountpage.verifyAuthenticationText(), true);
	}

	@Test(dependsOnMethods = "createNewAccount", priority = 1, retryAnalyzer = Helpers.RetryManager.class)
	public void performDressCheckout() throws Exception {
		homepage.clickdressesButton();
		dressespage.selectProductAndAddToCart();
		dressespage.proceedToCheckout();
		checkoutpage.proceedToCheckout();
		checkoutpage.proceedToCheckout();
		checkoutpage.acceprTermsAndConditions();
		checkoutpage.proceedToCheckout();
		checkoutpage.clickPayByBankWireButton();
		checkoutpage.clickConfirmOrderButton();
		Assert.assertEquals(checkoutpage.verifyOrderCompletion(), true);
	}

}
