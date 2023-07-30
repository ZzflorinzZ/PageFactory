package utils;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.NoAlertPresentException;
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
 * SeleniumWrappers class containing methods based on <WebElement element> usage
 */
public class SeleniumWrappers extends BaseTest {
	
	public SeleniumWrappers(WebDriver driver) {
		this.driver = driver;
	}

	//================================================================================================================================		
	// JS ALERT METHODS
	//============================================
	/**
	 * Wrapped method over Selenium default Alert accept() method, enhanced
	 * with:</br>
	 * 1. catch NoAlertPresentException</br>
	 * 2. catch General exception</br>
	 */
	public void jsAlertAccept() {
		Log.info(runningBrowser.get() + " Called method <jsAlertAccept()>");
		try {
			driver.switchTo().alert().accept();
		} catch (NoAlertPresentException e) {
			Log.error(runningBrowser.get() + " Catch NoAlertPresentException in method <jsAlertAccept()>");
			Log.error(runningBrowser.get() + " " + e.getMessage());
			throw new TestException(runningBrowser.get() + " NoAlertPresentException in method <jsAlertAccept()>");
		} catch (Exception e) {
			Log.error(runningBrowser.get() + " Exception error in method <jsAlertAccept()>");
			Log.error(runningBrowser.get() + " " + e.getMessage());
			throw new TestException(runningBrowser.get() + " Exception error in method <jsAlertAccept()>");
		}
	}

	//============================================
	/**
	 * Wrapped method over Selenium default Alert dismiss() method, enhanced
	 * with:</br>
	 * 1. catch NoAlertPresentException</br>
	 * 2. catch General exception</br>
	 */
	public void jsAlertDismiss() {
		Log.info(runningBrowser.get() + " Called method <jsAlertDismiss()>");
		try {
			driver.switchTo().alert().dismiss();
		} catch (NoAlertPresentException e) {
			Log.error(runningBrowser.get() + " Catch NoAlertPresentException in method <jsAlertDismiss()>");
			Log.error(runningBrowser.get() + " " + e.getMessage());
			throw new TestException(runningBrowser.get() + " NoAlertPresentException in method <jsAlertDismiss()>");
		} catch (Exception e) {
			Log.error(runningBrowser.get() + " Exception error in method <jsAlertDismiss()>");
			Log.error(runningBrowser.get() + " " + e.getMessage());
			throw new TestException(runningBrowser.get() + " Exception error in method <jsAlertDismiss()>");
		}
	}

	//============================================
	/**
	 * Wrapped method over Selenium default Alert getText() method, enhanced
	 * with:</br>
	 * 1. catch NoAlertPresentException</br>
	 * 2. catch General exception</br>
	 */
	public String jsAlertGetText() {
		Log.info(runningBrowser.get() + " Called method <jsAlertGetText()>");
		try {
			if (driver.switchTo().alert().getText() == null) {
				return null;
			} else {
				return driver.switchTo().alert().getText();
			}
		} catch (NoAlertPresentException e) {
			Log.error(runningBrowser.get() + " Catch NoAlertPresentException in method <jsAlertGetText()>");
			Log.error(runningBrowser.get() + " " + e.getMessage());
			return e.getMessage(); 
		} catch (Exception e) {
			Log.error(runningBrowser.get() + " Exception error in method <jsAlertGetText()>");
			Log.error(runningBrowser.get() + " " + e.getMessage());
			return e.getMessage(); 
		}
	}

	//============================================
	/**
	 * Wrapped method over Selenium default Alert sendKeys() method, enhanced
	 * with:</br>
	 * 1. catch NoAlertPresentException</br>
	 * 2. catch General exception</br>
	 */
	public void jsAlertSendKeys(String textToSend) {
		Log.info(runningBrowser.get() + " Called method <jsAlertSendKeys()>");
		try {
			driver.switchTo().alert().sendKeys(textToSend);
		} catch (NoAlertPresentException e) {
			Log.error(runningBrowser.get() + " Catch NoAlertPresentException in method <jsAlertSendKeys()>");
			Log.error(runningBrowser.get() + " " + e.getMessage());
			throw new TestException(runningBrowser.get() + " NoAlertPresentException in method <jsAlertSendKeys()>");
		} catch (Exception e) {
			Log.error(runningBrowser.get() + " Exception error in method <jsAlertSendKeys()>");
			Log.error(runningBrowser.get() + " " + e.getMessage());
			throw new TestException(runningBrowser.get() + " Exception error in method <jsAlertSendKeys()>");
		}
	}

	//================================================================================================================================	
	//CLICK METHODS	
	//============================================
	/**
	 * Wrapped method over Selenium default click() method, enhanced with:</br>
	 * 1. Logging mechanism</br>
	 * 2. waitForElementToBeClickable() method, before any action to be performed on webElement</br>
	 * 3. catch NoSuchElementException</br>
	 * 4. catch StaleElementReferenceException</br>
	 * 5. Retry mechanism</br>
	 * 6. catch General exception</br>
	 * 
	 * @param element (WebElement)
	 */
	public void click(WebElement element) {
		Log.info(runningBrowser.get() + " Called method <click()> on element " + element.getAttribute("outerHTML"));
		try {
			waitForElementToBeClickable(element);
			element.click();
		} catch (NoSuchElementException e) {
			Log.error(runningBrowser.get() + " Element not found in method <click()>");
			Log.error(runningBrowser.get() + " " + e.getMessage());
			throw new TestException(runningBrowser.get() + " Element not found in method <click()>");
		} catch (StaleElementReferenceException e) {
			Log.warn(runningBrowser.get() + " Catch StaleElementReferenceException in method <click()> on: " + element.getAttribute("outerHTML"));
			Log.warn(runningBrowser.get() + " " + e.getMessage());
			element.click(); 
		} catch (Exception e) {
			Log.error(runningBrowser.get() + " Exception error in method <click()>");
			Log.error(runningBrowser.get() + " " + e.getMessage());
			throw new TestException(runningBrowser.get() + " Exception error in method <click()>");
		}
	}
	
	//============================================
	/**
	 * Wrapped method over Selenium Actions default doubleClick() method, enhanced with:</br>
	 * 1. Logging mechanism</br>
	 * 2. waitForElementToBeClickable() method, before any action to be performed on webElement</br>
	 * 3. catch NoSuchElementException</br>
	 * 4. catch StaleElementReferenceException</br>
	 * 5. Retry mechanism</br>
	 * 6. catch General exception</br>
	 * 
	 * @param element (WebElement)
	 */
	public void doubleClick(WebElement element) {
		Log.info(runningBrowser.get() + " Called method <doubleClick()> on element " + element.getAttribute("outerHTML"));
		try {
			waitForElementToBeClickable(element);
			Actions action = new Actions(driver);
			action.doubleClick(element).perform();			
		} catch (NoSuchElementException e) {
			Log.error(runningBrowser.get() + " Element not found in method <doubleClick()>");
			Log.error(runningBrowser.get() + " " + e.getMessage());
			throw new TestException(runningBrowser.get() + " Element not found in method <doubleClick()>");
		} catch (StaleElementReferenceException e) {
			Log.warn(runningBrowser.get() + " Catch StaleElementReferenceException in method <doubleClick()> on: " + element.getAttribute("outerHTML"));
			Log.warn(runningBrowser.get() + " " + e.getMessage());
			Actions action = new Actions(driver);
			action.doubleClick(element).perform();	
		} catch (Exception e) {
			Log.error(runningBrowser.get() + " Exception error in method <doubleClick()>");
			Log.error(runningBrowser.get() + " " + e.getMessage());
			throw new TestException(runningBrowser.get() + " Exception error in method <doubleClick()>");
		}
	}

	//================================================================================================================================		
	//WAIT METHODS
	//============================================
	/**
	 * Wrapped method over Selenium default elementToBeClickable() condition, enhanced with:</br>
	 * 1. Logging mechanism</br>
	 * 2. Explicit wait</br>
	 * 3. catch NoSuchElementException</br>
	 * 4. catch General exception</br>
	 * 
	 * @param element (WebElement)
	 */
	public void waitForElementToBeClickable(WebElement element) {
		Log.info(runningBrowser.get() + " Called method <waitForElementToBeClickable()> on element " + element.getAttribute("outerHTML"));
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (NoSuchElementException e) {
			Log.error(runningBrowser.get() + " Element not found in method <waitForElementToBeClickable()>");
			Log.error(runningBrowser.get() + " " + e.getMessage());
			throw new TestException(runningBrowser.get() + " Element not found in method <waitForElementToBeClickable()>");
		} catch (Exception e) {
			Log.error(runningBrowser.get() + " Exception error in method <waitForElementToBeClickable()>");
			Log.error(runningBrowser.get() + " " + e.getMessage());
			throw new TestException(runningBrowser.get() + " Exception error in method <waitForElementToBeClickable()>");
		}
	}

	//============================================
	/**
	 * Wrapped method over Selenium default visibilityOf() condition, enhanced with:</br>
	 * 1. Logging mechanism</br>
	 * 2. Explicit wait</br>
	 * 3. catch NoSuchElementException</br>
	 * 4. catch General exception</br>
	 * 
	 * @param element (WebElement)
	 */
	public void waitForElementToBeVisible(WebElement element) {
		Log.info(runningBrowser.get() + " Called method <waitForElementToBeVisible()> on element " + element.getAttribute("outerHTML"));
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (NoSuchElementException e) {
			Log.error(runningBrowser.get() + " Element not found in method <waitForElementToBeVisible()>");
			Log.error(runningBrowser.get() + " " + e.getMessage());
			throw new TestException(runningBrowser.get() + " Element not found in method <waitForElementToBeVisible()>");
		} catch (Exception e) {
			Log.error(runningBrowser.get() + " Exception error in method <waitForElementToBeVisible()>");
			Log.error(runningBrowser.get() + " " + e.getMessage());
			throw new TestException(runningBrowser.get() + " Exception error in method <waitForElementToBeVisible()>");
		}
	}
		
	//============================================
	/**
	 * Wrapped method over Selenium default textToBePresentInElement() condition, enhanced with:</br>
	 * 1. Logging mechanism</br>
	 * 2. Explicit wait</br>
	 * 3. catch NoSuchElementException</br>
	 * 4. catch General exception</br>
	 * 
	 * @param element (WebElement)
	 * @param textToBePresent (String value)
	 */
	public void waitForTextToBePresentInElement(WebElement element, String textToBePresent) {
		Log.info(runningBrowser.get() + " Called method <waitForTextToBePresentInElement()> on element " + element.getAttribute("outerHTML"));
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.textToBePresentInElement(element, textToBePresent));
		} catch (NoSuchElementException e) {
			Log.error(runningBrowser.get() + " Element not found in method <waitForTextToBePresentInElement()>");
			Log.error(runningBrowser.get() + " "+ e.getMessage());
			throw new TestException(runningBrowser.get() + " Element not found in method <waitForTextToBePresentInElement()>");
		} catch (Exception e) {
			Log.error(runningBrowser.get() + " Exception error in method <waitForTextToBePresentInElement()>");
			Log.error(runningBrowser.get() + " " + e.getMessage());
			throw new TestException(runningBrowser.get() + " Exception error in method <waitForTextToBePresentInElement()>");
		}
	}

	//================================================================================================================================	
	//SEND KEYS METHOD
	//============================================
	/**
	 * Wrapped method over Selenium default sendKeys() method, enhanced with:</br>
	 * 1. Logging mechanism</br>
	 * 2. waitForElementToBeVisible() method, before any action to be performed on webElement</br>
	 * 3. Clear() method before sending text</br>
	 * 4. catch NoSuchElementException</br>
	 * 5. catch General exception</br>
	 * 
	 * @param element (WebElement)
	 * @param textToSend (String value)
	 */
	public void sendKeys(WebElement element, String textToSend) {
		Log.info(runningBrowser.get() + " Called method <sendKeys()> on element " + element.getAttribute("outerHTML"));
		try {
			waitForElementToBeVisible(element);
			element.clear();
			element.sendKeys(textToSend);
		} catch (NoSuchElementException e) {
			Log.error(runningBrowser.get() + " Element not found in method <sendKeys()>");
			Log.error(runningBrowser.get() + " " + e.getMessage());
			throw new TestException(runningBrowser.get() + " Element not found in method <sendKeys()>");
		} catch (Exception e) {
			Log.error(runningBrowser.get() + " Exception error in method <sendKeys()>");
			Log.error(runningBrowser.get() + " " + e.getMessage());
			throw new TestException(runningBrowser.get() + " Exception error in method <sendKeys()>");
		}
	}

	//================================================================================================================================		
	//IS DISPLAYED METHOD
	//============================================
	/**
	 * Wrapped method over Selenium default isDisplayed() method, enhanced with:</br>
	 * 1. Logging mechanism</br>
	 * 2. catch NoSuchElementException</br>
	 * 3. catch General exception</br>
	 * 
	 * @param element (WebElement)
	 * @return boolean
	 */
	public boolean checkElementIsDisplayed(WebElement element) {
		Log.info(runningBrowser.get() + " Called method <checkElementIsDisplayed()> on element " + element.getAttribute("outerHTML"));
		try {
			element.isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			Log.error(runningBrowser.get() + " Element not found in method <checkElementIsDisplayed()>");
			Log.error(runningBrowser.get() + " " + e.getMessage());
			return false;					
		} catch (Exception e) {
			Log.error(runningBrowser.get() + " Exception error in method <checkElementIsDisplayed()>");
			Log.error(runningBrowser.get() + " " + e.getMessage());
			return false;
		}
	}

	//================================================================================================================================	
	//HOOVER METHODS
	//============================================
	/**
	 * Wrapped method over Selenium Actions default moveToElement() method, enhanced with:</br>
	 * 1. Logging mechanism</br>
	 * 2. waitForElementToBeVisible() method, before any action to be performed on webElement</br>
	 * 3. catch NoSuchElementException</br>
	 * 4. catch General exception</br>
	 * 
	 * @param element (WebElement)
	 */
	public void hooverOnElementVisible(WebElement element) {
		Log.info(runningBrowser.get() + " Called method <hooverOnElementVisible()> on element " + element.getAttribute("outerHTML"));
		Actions hoover = new Actions(driver);
		try {
			waitForElementToBeVisible(element);
			hoover.moveToElement(element).perform();
		} catch (NoSuchElementException e) {
			Log.error(runningBrowser.get() + " Element not found in method <hooverOnElementVisible()>");
			Log.error(runningBrowser.get() + " " + e.getMessage());
			throw new TestException(runningBrowser.get() + " Element not found in method <hooverOnElementVisible()>");
		} catch (Exception e) {
			Log.error(runningBrowser.get() + " Exception error in method <hooverOnElementVisible()>");
			Log.error(runningBrowser.get() + " " + e.getMessage());
			throw new TestException(runningBrowser.get() + " Exception error in method <hooverOnElementVisible()>");
		}	
	}	

	//================================================================================================================================		
	//DROPDOWN LISTS METHODS
	//============================================
	/**
	 * Wrapped method over Selenium Select default selectByIndex() method, enhanced with:</br>
	 * 1. Logging mechanism</br>
	 * 2. catch NoSuchElementException</br>
	 * 3. catch General exception</br>
	 * 
	 * @param element (WebElement)
	 * @param index (Integer value)
	 */
	public void selectByIndex(WebElement element, int index) {
		Log.info(runningBrowser.get() + " Called method <selectByIndex()> on element " + element.getAttribute("outerHTML"));
		try {
			Select select = new Select(element);
			select.selectByIndex(index);
		} catch (NoSuchElementException e) {
			Log.error(runningBrowser.get() + " Element not found in method <selectByIndex()>");
			Log.error(runningBrowser.get() + " " + e.getMessage());
			throw new TestException(runningBrowser.get() + " Element not found in method <selectByIndex()>");
		} catch (Exception e) {
			Log.error(runningBrowser.get() + " Exception error in method <selectByIndex()>");
			Log.error(runningBrowser.get() + " " + e.getMessage());
			throw new TestException(runningBrowser.get() + " Exception error in method <selectByIndex()>");
		}
	}

	//============================================
	/**
	 * Wrapped method over Selenium Select default selectByValue() method, enhanced with:</br>
	 * 1. Logging mechanism</br>
	 * 2. catch NoSuchElementException</br>
	 * 3. catch General exception</br>
	 * 
	 * @param element (WebElement)
	 * @param value (String value)
	 */
	public void selectByValue(WebElement element, String value) {
		Log.info(runningBrowser.get() + " Called method <selectByValue()> on element " + element.getAttribute("outerHTML"));
		try {
			Select select = new Select(element);
			select.selectByValue(value);
		} catch (NoSuchElementException e) {
			Log.error(runningBrowser.get() + " Element not found in method <selectByValue()>");
			Log.error(runningBrowser.get() + " " + e.getMessage());
			throw new TestException(runningBrowser.get() + " Element not found in method <selectByValue()>");
		} catch (Exception e) {
			Log.error(runningBrowser.get() + " Exception error in method <selectByValue()>");
			Log.error(runningBrowser.get() + " " + e.getMessage());
			throw new TestException(runningBrowser.get() + " Exception error in method <selectByValue()>");
		}
	}
	
	//============================================
	/**
	 * Wrapped method over Selenium Select default selectByVisibleText() method, enhanced with:</br>
	 * 1. Logging mechanism</br>
	 * 2. catch NoSuchElementException</br>
	 * 3. catch General exception</br>
	 * 
	 * @param element (WebElement)
	 * @param text (String value)
	 */
	public void selectByVisibleText(WebElement element, String text) {
		Log.info(runningBrowser.get() + " Called method <selectByVisibleText()> on element " + element.getAttribute("outerHTML"));
		try {
			Select select = new Select(element);
			select.selectByVisibleText(text);
		} catch (NoSuchElementException e) {
			Log.error(runningBrowser.get() + " Element not found in method <selectByVisibleText()>");
			Log.error(runningBrowser.get() + " " + e.getMessage());
			throw new TestException(runningBrowser.get() + " Element not found in method <selectByVisibleText()>");
		} catch (Exception e) {
			Log.error(runningBrowser.get() + " Exception error in method <selectByVisibleText()>");
			Log.error(runningBrowser.get() + " " + e.getMessage());
			throw new TestException(runningBrowser.get() + " Exception error in method <selectByVisibleText()>");
		}
	}
	
	//============================================
	/**
	 * Wrapped method over Selenium Select default getFirstSelectedOption() method, enhanced with:</br>
	 * 1. Logging mechanism</br>
	 * 2. catch NoSuchElementException</br>
	 * 3. catch General exception</br>
	 * 
	 * @param element (WebElement)
	 * @return String (String value) --> value of the selected option
	 */
	public String getSelectedOption(WebElement element) {
		Log.info(runningBrowser.get() + " Called method <getSelectedOption()> on element " + element.getAttribute("outerHTML"));
		try {
			Select select = new Select(element);
			return select.getFirstSelectedOption().getText();
		} catch (NoSuchElementException e) {
			Log.error(runningBrowser.get() + " Element not found in method <getSelectedOption()>");
			Log.error(runningBrowser.get() + " " + e.getMessage());
			return null;
		} catch (Exception e) {
			Log.error(runningBrowser.get() + " Exception error in method <getSelectedOption()>");
			Log.error(runningBrowser.get() + " " + e.getMessage());
			return null;
		}
	}

	//================================================================================================================================	
	//DRAG & DROP METHODS
	//============================================
	/**
	 * Wrapped method over Selenium Actions default dragAndDrop() method, enhanced with:</br>
	 * 1. Logging mechanism</br>
	 * 2. catch NoSuchElementException</br>
	 * 3. catch General exception</br>
	 * 
	 * @param element1 (WebElement) --> element to be moved
	 * @param element2 (WebElement) --> element on which the first element is moved over
	 */
	public void dragAndDropElementToElement(WebElement element1, WebElement element2) {
		Log.info(runningBrowser.get() + " Called method <dragAndDropElementToElement()> on element " + element1.getAttribute("outerHTML") + " and " + element2.getAttribute("outerHTML"));
		try {
			Actions action = new Actions(driver);
			action.dragAndDrop(element1, element2).perform();
		} catch (NoSuchElementException e) {
			Log.error(runningBrowser.get() + " Element not found in method <dragAndDropElementToElement()>");			//ar trebui sa diferentiez NoSuchElementException pe element1 si element2 ?? ma gandesc sa folosesc un if, dar nu-mi dai seama cum ar trebui sa pun conditia
			Log.error(runningBrowser.get() + " " + e.getMessage());
			throw new TestException(runningBrowser.get() + " Element not found in method <dragAndDropElementToElement()>");
		} catch (Exception e) {
			Log.error(runningBrowser.get() + " Exception error in method <dragAndDropElementToElement()>");
			Log.error(runningBrowser.get() + " " + e.getMessage());
			throw new TestException(runningBrowser.get() + " Exception error in method <dragAndDropElementToElement()>");
		}
	}

	//============================================	
	/**
	 * Wrapped method over Selenium Actions default dragAndDropBy() method, enhanced with:</br>
	 * 1. Logging mechanism</br>
	 * 2. catch NoSuchElementException</br>
	 * 3. catch General exception</br>
	 * 
	 * @param element (WebElement) --> element to be moved
	 * @param x (Integer value) --> horizontal move
	 * @param y (Integer value) --> vertical move
	 */
	public void dragAndDrop(WebElement element, int x, int y) {
		Log.info(runningBrowser.get() + " Called method <dragAndDrop()> on element " + element.getAttribute("outerHTML"));
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
			Log.error(runningBrowser.get() + " Element not found in method <dragAndDrop()>");
			Log.error(runningBrowser.get() + " " + e.getMessage());
			throw new TestException(runningBrowser.get() + " Element not found in method <dragAndDrop()>");
		} catch (Exception e) {
			Log.error(runningBrowser.get() + " Exception error in method <dragAndDrop()>");
			Log.error(runningBrowser.get() + " " + e.getMessage());
			throw new TestException(runningBrowser.get() + " Exception error in method <dragAndDrop()>");
		}
	}

	//================================================================================================================================	
	//REDIRECTED URL METHOD	
	//============================================	
	/**
	 * Wrapped method over Selenium default driver.switchTo().window() functionality, enhanced with:</br>
	 * 1. Logging mechanism</br>
	 * 2. click() custom method</br>
	 * 3. driver.close() functionality</br>
	 * 4. catch General exception</br>
	 * 
	 * @param element (WebElement)
	 * @return String (String value of current URL)
	 */
	public String checkRedirectedUrlAndReturnToInitialPage(WebElement element) {
		Log.info(runningBrowser.get() + " Called method <checkRedirectedUrlAndReturnToInitialPage()> on element " + element.getAttribute("outerHTML"));
		try {
			click(element);
			List<String> browserTabs = new ArrayList<>(driver.getWindowHandles());
			driver.switchTo().window(browserTabs.get(1));
			String currentURL = driver.getCurrentUrl();		
			driver.close();
			driver.switchTo().window(browserTabs.get(0));
			return currentURL;
		} catch (NoSuchElementException e) {
			Log.error(runningBrowser.get() + " Element not found in method <checkRedirectedUrlAndReturnToInitialPage()>");
			Log.error(runningBrowser.get() + " " + e.getMessage());
			return e.getMessage();
		} catch (Exception e) {
			Log.error(runningBrowser.get() + " Element not found in method <checkRedirectedUrlAndReturnToInitialPage()>");
			Log.error(runningBrowser.get() + " " + e.getMessage());
			return e.getMessage(); 
		}
	}
}
