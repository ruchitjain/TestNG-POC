package Helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserActions {

	public WebDriver driver;

	public BrowserActions(WebDriver driver) {
		this.driver = driver;
	}

	public void click(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void moveToElement(WebElement element) {
		try {
			Actions action = new Actions(driver);
			action.moveToElement(element).perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void waitToPageLoad() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 180);
			wait.until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver wdriver) {
					return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sendKeys(WebElement element, String data) {
		try {
			element.sendKeys(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void waitForElementVisibility(WebElement element, WebDriver driver) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void waitForElementClickability(WebElement element, WebDriver driver) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getText(WebElement element) {
		try {
			return element.getText();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getValue(WebElement element, String attribute) {
		try {
			return element.getAttribute(attribute);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
