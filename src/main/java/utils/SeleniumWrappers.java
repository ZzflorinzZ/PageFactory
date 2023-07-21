package utils;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWrappers extends BaseTest {
	
	public SeleniumWrappers(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Wrapped method over selenium default click() method, enhanced with:</br>
	 * 1. Logging mechanism</br>
	 * 2. Retry mechanism</br>
	 * 3. waitForElementToBeClickable()</br>
	 * 
	 * @param locator (By locator)
	 */
	public void click(WebElement element) {
		try {
			waitForElementToBeClickable(element);
			element.click();
			System.out.println("Called method click");
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (StaleElementReferenceException e) {
			element = element;
			element.click(); 
		}
	}
	
	public void doubleClick(WebElement element) {
		try {
			waitForElementToBeClickable(element);
			Actions action = new Actions(driver);
			action.doubleClick(element).perform();			
			System.out.println("Called method doubleClick");
		} catch (StaleElementReferenceException e) {
			Actions action = new Actions(driver);
			action.doubleClick(element).perform();	
		}
	}

	public void waitForElementToBeClickable(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}

	public void waitForElementToBeVisible(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}
	
	public void waitForElementToBePresent(By locator) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}
	
	public void textToBePresentInElementLocated(By locator, String textToBePresent) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, textToBePresent));
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Custom sendKeys method. Wraps default Selenium sendKeys and enhance
	 * with:</br>
	 * 1. Clear() method before sending text</br>
	 * 2. waitForElementToBeVisible() before any action on webElement</br>
	 * 
	 * @param locator    (By locator) --> used inside method to create WebElement
	 * @param textToSend --> String value
	 */
	public void sendKeys(WebElement element, String textToSend) {
		try {
			waitForElementToBeVisible(element);
			element.clear();
			element.sendKeys(textToSend);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}

	public boolean checkElementIsDisplayed(WebElement element) {
		try {
			element.isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

/*	public void hooverOnElement(By locator) {
		Actions hoover = new Actions(driver);
		try {
			waitForElementToBeVisible(locator);
			WebElement element = driver.findElement(locator);
			hoover.moveToElement(element).perform();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}
*/
	public void hooverOnElementVisible(WebElement element) {
		Actions hoover = new Actions(driver);
			waitForElementToBeVisible(element);
			hoover.moveToElement(element).perform();
	}

/*	
	public void hooverOnElementPresent(WebElement element) {
		Actions hoover = new Actions(driver);
			waitForElementToBePresent(element);
			hoover.moveToElement(element).perform();
	}
*/	

	public void selectByIndex(WebElement element, int index) {
		try {
			Select select = new Select(element);
			select.selectByIndex(index);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}

	public void selectByValue(WebElement element, String value) {
		try {
			Select select = new Select(element);
			select.selectByValue(value);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}

	public String getSelectedOption(By locator) {
		try {
			Select select = new Select(returnElement(locator));
			return select.getFirstSelectedOption().getText();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void dragAndDropElementToElement(By locator1, By locator2) {
		try {
			WebElement e1 = driver.findElement(locator1);
			WebElement e2 = driver.findElement(locator2);
			Actions action = new Actions(driver);
			action.dragAndDrop(e1, e2).perform();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}

	public void dragAndDrop(By locator, int x, int y) {
		try {
			WebElement element = driver.findElement(locator);

			Actions action = new Actions(driver);
			/*
			 * action .moveToElement(element) .clickAndHold() .moveByOffset(x, y) .release()
			 * .perform();
			 */
			action.dragAndDropBy(element, x, y).perform();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}

	public WebElement returnElement(By locator) {
		try {
			return driver.findElement(locator);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return null;
	}
}
