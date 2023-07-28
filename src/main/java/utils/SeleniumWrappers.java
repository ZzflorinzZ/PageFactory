package utils;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestException;


/**
 * orice
 */
public class SeleniumWrappers extends BaseTest {
	
	public SeleniumWrappers(WebDriver driver) {
		this.driver = driver;
	}

//CLICK METHODS	
	/**
	 * Wrapped method over Selenium default click() method, enhanced with:</br>
	 * 1. Logging mechanism</br>
	 * 2. waitForElementToBeClickable() method, before any action to be performed on webElement</br>
	 * 3. catch NoSuchElementException</br>
	 * 4. catch StaleElementReferenceException</br>
	 * 5. Retry mechanism</br>
	 * 
	 * @param element (WebElement)
	 */
	public void click(WebElement element) {
		Log.info(runningBrowser.get() + "Called method <click> on element" + element.getAttribute("outerHTML"));
		try {
			waitForElementToBeClickable(element);
			element.click();
		} catch (NoSuchElementException e) {
			Log.error("Element not found in method <click()>");
			Log.error(e.getMessage());
			throw new TestException("Element not found in method <click()>");
		} catch (StaleElementReferenceException e) {
			Log.error("Catch StaleElementReferenceException in method <click> on: " + element.getAttribute("outerHTML"));
			element = element;
			element.click(); 
		}
	}
	
	/**
	 * Wrapped method over Selenium Actions default doubleClick() method, enhanced with:</br>
	 * 1. Logging mechanism</br>
	 * 2. waitForElementToBeClickable() method, before any action to be performed on webElement</br>
	 * 3. catch NoSuchElementException</br>
	 * 4. catch StaleElementReferenceException</br>
	 * 5. Retry mechanism</br>
	 * 
	 * @param element (WebElement)
	 */
	public void doubleClick(WebElement element) {
		Log.info("Called method <doubleClick> on element" + element.getAttribute("outerHTML"));
		try {
			waitForElementToBeClickable(element);
			Actions action = new Actions(driver);
			action.doubleClick(element).perform();			
		} catch (NoSuchElementException e) {
			Log.error("Element not found in method <doubleClick()>");
			Log.error(e.getMessage());
			throw new TestException("Element not found in method <doubleClick()>");
		} catch (StaleElementReferenceException e) {
			Log.error("Catch StaleElementReferenceException in method <doubleClick> on: " + element.getAttribute("outerHTML"));
			element = element;
			Actions action = new Actions(driver);
			action.doubleClick(element).perform();	
		}
	}

//	Log.info("call <waitForElementToBeClickable> on " + locator.toString());	--pt By locator
	
//WAIT METHODS
	/**
	 * Wrapped method over Selenium default elementToBeClickable() condition, enhanced with:</br>
	 * 1. Logging mechanism</br>
	 * 2. Explicit wait</br>
	 * 3. catch NoSuchElementException</br>
	 * 
	 * @param element (WebElement)
	 */
	public void waitForElementToBeClickable(WebElement element) {
		Log.info("Called method <waitForElementToBeClickable> on element" + element.getAttribute("outerHTML"));
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (NoSuchElementException e) {
			Log.error("Element not found in method <waitForElementToBeClickable()>");
			Log.error(e.getMessage());
			throw new TestException("Element not found in method <waitForElementToBeClickable()>");
		}
	}

	/**
	 * Wrapped method over Selenium default visibilityOf() condition, enhanced with:</br>
	 * 1. Logging mechanism</br>
	 * 2. Explicit wait</br>
	 * 3. catch NoSuchElementException</br>
	 * 
	 * @param element (WebElement)
	 */
	public void waitForElementToBeVisible(WebElement element) {
		Log.info("Called method <waitForElementToBeVisible> on element" + element.getAttribute("outerHTML"));
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (NoSuchElementException e) {
			Log.error("Element not found in method <waitForElementToBeVisible()>");
			Log.error(e.getMessage());
			throw new TestException("Element not found in method <waitForElementToBeVisible()>");
		}
	}
	
	/**
	 * Wrapped method over Selenium default ...............() condition, enhanced with:</br>
	 * 1. Logging mechanism</br>
	 * 2. Explicit wait</br>
	 * 3. catch NoSuchElementException</br>
	 * 
	 * @param element (WebElement)
	 */
/*	public void waitForElementToBePresent(WebElement element) {
  		Log.info("Called method <waitForElementToBePresent> on element " + element.getAttribute("outerHTML"));
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.presenceOfElementLocated(element));			//cu ce se poate inlocui pt WebElement metoda <<presenceOfElementLocated>> folosita pt By ??
		} catch (NoSuchElementException e) {
			Log.error("Element not found in method <waitForElementToBePresent()>");
			Log.error(e.getMessage());
			throw new TestException("Element not found!");
		}
	}
*/	
	/**
	 * Wrapped method over Selenium default textToBePresentInElement() condition, enhanced with:</br>
	 * 1. Logging mechanism</br>
	 * 2. Explicit wait</br>
	 * 3. catch NoSuchElementException</br>
	 * 
	 * @param element (WebElement)
	 * @param textToBePresent (String value)
	 */
	public void waitForTextToBePresentInElement(WebElement element, String textToBePresent) {
		Log.info("Called method <waitForTextToBePresentInElement> on element " + element.getAttribute("outerHTML"));
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.textToBePresentInElement(element, textToBePresent));
		} catch (NoSuchElementException e) {
			Log.error("Element not found in method <waitForTextToBePresentInElement()>");
			Log.error(e.getMessage());
			throw new TestException("Element not found in method <waitForTextToBePresentInElement()>");
		}
	}

//SEND KEYS METHOD		
	/**
	 * Wrapped method over Selenium default sendKeys() method, enhanced with:</br>
	 * 1. Logging mechanism</br>
	 * 2. waitForElementToBeVisible() method, before any action to be performed on webElement</br>
	 * 3. Clear() method before sending text</br>
	 * 4. catch NoSuchElementException</br>
	 * 
	 * @param element (WebElement)
	 * @param textToSend (String value)
	 */
	public void sendKeys(WebElement element, String textToSend) {
		Log.info("Called method <sendKeys()> on element " + element.getAttribute("outerHTML"));
		try {
			waitForElementToBeVisible(element);
			element.clear();
			element.sendKeys(textToSend);
		} catch (NoSuchElementException e) {
			Log.error("Element not found in method <sendKeys()>");
			Log.error(e.getMessage());
			throw new TestException("Element not found in method <sendKeys()>");
		}
	}

//IS DISPLAYED METHOD	
	/**
	 * Wrapped method over Selenium default isDisplayed() method, enhanced with:</br>
	 * 1. Logging mechanism</br>
	 * 2. catch NoSuchElementException</br>
	 * 
	 * @param element (WebElement)
	 * @return boolean
	 */
	public boolean checkElementIsDisplayed(WebElement element) {
		Log.info("Called method <checkElementIsDisplayed()> on element " + element.getAttribute("outerHTML"));
		try {
			element.isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			Log.error("Element not found in method <checkElementIsDisplayed()>");
			Log.error(e.getMessage());
			return false;					
		}
	}

//HOOVER METHODS
	/**
	 * Wrapped method over Selenium Actions default moveToElement() method, enhanced with:</br>
	 * 1. Logging mechanism</br>
	 * 2. waitForElementToBeVisible() method, before any action to be performed on webElement</br>
	 * 3. catch NoSuchElementException</br>
	 * 
	 * @param element (WebElement)
	 */
	public void hooverOnElementVisible(WebElement element) {
		Log.info("Called method <hooverOnElementVisible()> on element " + element.getAttribute("outerHTML"));
		Actions hoover = new Actions(driver);
		try {
			waitForElementToBeVisible(element);
			hoover.moveToElement(element).perform();
		} catch (NoSuchElementException e) {
			Log.error("Element not found in method <hooverOnElementVisible()>");
			Log.error(e.getMessage());
			throw new TestException("Element not found in method <hooverOnElementVisible()>");
		}	
	}

	/**
	 * Wrapped method over Selenium Actions default moveToElement() method, enhanced with:</br>
	 * 1. Logging mechanism</br>
	 * 2. ...................() method, before any action to be performed on webElement</br>
	 * 3. catch NoSuchElementException</br>
	 * 
	 * @param element (WebElement)
	 */
/*	public void hooverOnElementPresent(WebElement element) {
		Log.info("Called method <hooverOnElementPresent()> on element " + element.getAttribute("outerHTML"));
		Actions hoover = new Actions(driver);
		try {
			waitForElementToBePresent(element);
			hoover.moveToElement(element).perform();
		} catch (NoSuchElementException e) {
			Log.error("Element not found in method <hooverOnElementPresent()>");
			Log.error(e.getMessage());
			throw new TestException("Element not found in method <hooverOnElementPresent()>");
		}	
	}
*/	

//DROPDOWN LISTS METHODS
	/**
	 * Wrapped method over Selenium Select default selectByIndex() method, enhanced with:</br>
	 * 1. Logging mechanism</br>
	 * 2. catch NoSuchElementException</br>
	 * 
	 * @param element (WebElement)
	 * @param index (Integer value)
	 */
	public void selectByIndex(WebElement element, int index) {
		Log.info("Called method <selectByIndex()> on element " + element.getAttribute("outerHTML"));
		try {
			Select select = new Select(element);
			select.selectByIndex(index);
		} catch (NoSuchElementException e) {
			Log.error("Element not found in method <selectByIndex()>");
			Log.error(e.getMessage());
			throw new TestException("Element not found in method <selectByIndex()>");
		}
	}

	/**
	 * Wrapped method over Selenium Select default selectByValue() method, enhanced with:</br>
	 * 1. Logging mechanism</br>
	 * 2. catch NoSuchElementException</br>
	 * 
	 * @param element (WebElement)
	 * @param value (String value)
	 */
	public void selectByValue(WebElement element, String value) {
		Log.info("Called method <selectByValue()> on element " + element.getAttribute("outerHTML"));
		try {
			Select select = new Select(element);
			select.selectByValue(value);
		} catch (NoSuchElementException e) {
			Log.error("Element not found in method <selectByValue()>");
			Log.error(e.getMessage());
			throw new TestException("Element not found in method <selectByValue()>");
		}
	}
	
	/**
	 * Wrapped method over Selenium Select default selectByVisibleText() method, enhanced with:</br>
	 * 1. Logging mechanism</br>
	 * 2. catch NoSuchElementException</br>
	 * 
	 * @param element (WebElement)
	 * @param text (String value)
	 */
	public void selectByVisibleText(WebElement element, String text) {
		Log.info("Called method <selectByVisibleText()> on element " + element.getAttribute("outerHTML"));
		try {
			Select select = new Select(element);
			select.selectByVisibleText(text);
		} catch (NoSuchElementException e) {
			Log.error("Element not found in method <selectByVisibleText()>");
			Log.error(e.getMessage());
			throw new TestException("Element not found in method <selectByVisibleText()>");
		}
	}
	
	/**
	 * Wrapped method over Selenium Select default getFirstSelectedOption() method, enhanced with:</br>
	 * 1. Logging mechanism</br>
	 * 2. catch NoSuchElementException</br>
	 * 
	 * @param element (WebElement)
	 * @return String (String value) --> value of the selected option
	 */
	public String getSelectedOption(WebElement element) {
		Log.info("Called method <getSelectedOption()> on element " + element.getAttribute("outerHTML"));
		try {
			Select select = new Select(element);
			return select.getFirstSelectedOption().getText();
		} catch (NoSuchElementException e) {
			Log.error("Element not found in method <getSelectedOption()>");
			Log.error(e.getMessage());
			return null;
		}
	}

//DRAG & DROP METHODS
	/**
	 * Wrapped method over Selenium Actions default dragAndDrop() method, enhanced with:</br>
	 * 1. Logging mechanism</br>
	 * 2. catch NoSuchElementException</br>
	 * 
	 * @param element1 (WebElement) --> element to be moved
	 * @param element2 (WebElement) --> element on which the first element is moved over
	 */
	public void dragAndDropElementToElement(WebElement element1, WebElement element2) {
		Log.info("Called method <dragAndDropElementToElement()> on element " + element1.getAttribute("outerHTML") + " and " + element2.getAttribute("outerHTML"));
		try {
			Actions action = new Actions(driver);
			action.dragAndDrop(element1, element2).perform();
		} catch (NoSuchElementException e) {
			Log.error("Element not found in method <dragAndDropElementToElement()>");			//ar trebui sa diferentiez NoSuchElementException pe element1 si element2; ma gandesc sa folosesc un if, dar nu-mi dai seama cum ar trebui sa pun conditia
			Log.error(e.getMessage());
			throw new TestException("Element not found in method <dragAndDropElementToElement()>");
		}
	}

	/**
	 * Wrapped method over Selenium Actions default dragAndDropBy() method, enhanced with:</br>
	 * 1. Logging mechanism</br>
	 * 2. catch NoSuchElementException</br>
	 * 
	 * @param element (WebElement) --> element to be moved
	 * @param x (Integer value) --> horizontal move
	 * @param y (Integer value) --> vertical move
	 */
	public void dragAndDrop(WebElement element, int x, int y) {
		Log.info("Called method <dragAndDrop()> on element " + element.getAttribute("outerHTML"));
		try {
			Actions action = new Actions(driver);
/*			action 
					.moveToElement(element)
			  		.clickAndHold()
			  		.moveByOffset(x, y)
			  		.release()
			  		.perform();
*/			action.dragAndDropBy(element, x, y).perform();
		} catch (NoSuchElementException e) {
			Log.error("Element not found in method <dragAndDrop()>");
			Log.error(e.getMessage());
			throw new TestException("Element not found in method <dragAndDrop()>");
		}
	}

	/**
	 * Wrapped method over Selenium default driver.switchTo().window() functionality, enhanced with:</br>
	 * 1. Logging mechanism</br>
	 * 2. click() custom method</br>
	 * 3. driver.close() functionality</br>
	 * 4. catch Exception</br>
	 * 
	 * @param element (WebElement)
	 * @return String (String value of current URL)
	 */
	public String checkRedirectedUrlAndReturnToInitialPage(WebElement element) {
		Log.info("Called method <checkRedirectedUrlAndReturnToInitialPage()> on element " + element.getAttribute("outerHTML"));
		try {
			click(element);
			List<String> browserTabs = new ArrayList<>(driver.getWindowHandles());
			driver.switchTo().window(browserTabs.get(1));
			String currentURL = driver.getCurrentUrl();		
			driver.close();
			driver.switchTo().window(browserTabs.get(0));
			return currentURL;
		} catch (Exception e) {
			Log.error("Element not found in method <checkRedirectedUrlAndReturnToInitialPage()>");
			Log.error(e.getMessage());
			return e.getMessage(); 
		}
	}
}
