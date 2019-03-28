/*
 * Copyright (c) 2018 CA. All rights reserved.
 *
 * This software and all information contained therein is confidential and
 * proprietary and shall not be duplicated, used, disclosed or disseminated in
 * any way except as authorized by the applicable license agreement, without
 * the express written permission of CA. All authorized reproductions must be
 * marked with this language.
 *
 * EXCEPT AS SET FORTH IN THE APPLICABLE LICENSE AGREEMENT, TO THE EXTENT
 * PERMITTED BY APPLICABLE LAW, CA PROVIDES THIS SOFTWARE WITHOUT WARRANTY OF
 * ANY KIND, INCLUDING WITHOUT LIMITATION, ANY IMPLIED WARRANTIES OF
 * MERCHANTABILITY OR FITNESS FOR A PARTICULAR PURPOSE. IN NO EVENT WILL CA BE
 * LIABLE TO THE END USER OR ANY THIRD PARTY FOR ANY LOSS OR DAMAGE, DIRECT OR
 * INDIRECT, FROM THE USE OF THIS SOFTWARE, INCLUDING WITHOUT LIMITATION, LOST
 * PROFITS, BUSINESS INTERRUPTION, GOODWILL, OR LOST DATA, EVEN IF CA IS
 * EXPRESSLY ADVISED OF SUCH LOSS OR DAMAGE.
 */

package com.my.home.test.util;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Common Selenium Methods to reuse.
 * 
 * @author behdu01
 */

public class SeleniumUtility{

	private static final Logger LOGGER = LoggerFactory.getLogger(SeleniumUtility.class); 
	WebDriver driver;
	JavascriptExecutor js;
	int timeToWait = 3;

	/*
	public SeleniumUtility(WebDriver driver){
		this.driver = driver;
	}
	 */

	/**
	 * Method to clear the textbox and send the value.
	 * 
	 * @param WebElement element
	 * @param String value
	 */
	public void clearAndSendKeys(WebElement element, String value){
		element.clear();
		element.sendKeys(value);
		LOGGER.info("{} cleared and {} keys typed.",element,value);
		harvestWait(timeToWait);
	}

	/**
	 * Method to send the value.
	 * 
	 * @param WebElement element
	 * @param String value
	 */
	public void sendKeys(WebElement element, String value){
		element.sendKeys(value);
		LOGGER.info("{} keys typed for element {}.",value,element);
		harvestWait(timeToWait);
	}

	/**
	 * Method to select the value from the dropdown by value.
	 * 
	 * @param WebElement element
	 * @param String value
	 */
	public void selectFromDropDown(WebElement element, String value){
		Select options =new Select(element);
		options.selectByValue(value);
		LOGGER.info("{} value selected from the {} drop down by value.",value,element);
		harvestWait(timeToWait);
	}

	/**
	 * Method to select the value from the dropdown by visible text.
	 * 
	 * @param WebElement element
	 * @param String value
	 */
	public void selectFromDropDownByVisibleText(WebElement element, String value){
		Select options =new Select(element);
		options.selectByVisibleText(value);
		LOGGER.info("{} value selected from the {} drop down by visible text.",value,element);
		harvestWait(timeToWait);
	}

	/**
	 * Method to select the value from the dropdown by Index.
	 * 
	 * @param WebElement element
	 * @param int value
	 */
	public void selectFromDropDownByIndex(WebElement element, int value){
		Select options =new Select(element);
		options.selectByIndex(value);
		LOGGER.info("{} value selected from the {} drop down by index.",value,element);
		harvestWait(timeToWait);
	}

	/**
	 * Method to select the value from the dropdown with the given tag.
	 * 
	 * @param WebElement element
	 * @param String tag Example : div, li, span etc.
	 * @param String value
	 */
	public boolean selectFromDropDownWithTagName(WebElement element, String tag, String value){
		List<WebElement> options = element.findElements(By.tagName(tag));
		for (WebElement option : options){
			if (option.getText().equals(value)){
				option.click();
				LOGGER.info("{} value selected from the {} drop down.",value,element);
				harvestWait(timeToWait);
				return true;
			}
		}
		Assert.assertFalse(value+" not present for the element: "+element,false);
		return false;
	}

	/**
	 * Method to click the WebElement.
	 * 
	 * @param WebElement element
	 */
	public void click(WebElement element){
		element.click();
		LOGGER.info("{} is clicked.",element);
		harvestWait(timeToWait);
	}

	/**
	 * Method to click the WebElement n no of times.
	 * 
	 * @param WebElement element
	 * @param int n
	 */
	public void clickTimes(WebElement element, int n){
		for(int i=0;i<n;i++){
			element.click();
			LOGGER.info("{} is clicked {} times.",element,n);
			harvestWait(timeToWait);
		}

		LOGGER.info("Successfully completed clicking {} element {} no. of times.",element,n);
		harvestWait(timeToWait);
	}

	/**
	 * Method to click the WebElement with Actions Class.
	 * 
	 * @param WebElement element
	 * @param WebDriver driver
	 */
	public void actionsClick(WebElement element, WebDriver driver){
		Actions action = new Actions (driver);
		action.moveToElement(element).click().perform();
		LOGGER.info("{} is clicked.",element);
		harvestWait(timeToWait);
	}

	/**
	 * Method to scroll to the element with JavascriptExecutor Class and click the element.
	 * 
	 * @param WebElement element
	 * @param WebDriver driver
	 */
	public void jsScrollAndClick(WebElement element, WebDriver driver){
		jsScrollToElement(element,driver);
		harvestWait(timeToWait*5);
		click(element);
		LOGGER.info("{} scrolled and clicked.",element);
		harvestWait(timeToWait);
	}

	/**
	 * Method to type or send keys to the WebElement with Actions Class.
	 * 
	 * @param Keys keys
	 * @param WebDriver driver
	 */
	public void actionsSendKeys(Keys keys, WebDriver driver){
		Actions action = new Actions (driver);
		action.sendKeys(keys).build().perform();
		LOGGER.info("{} is typed.",keys);
		harvestWait(timeToWait);
	}

	/**
	 * Method to scroll to the element with JavascriptExecutor Class.
	 * 
	 * @param WebElement element
	 * @param WebDriver driver
	 */
	public void jsScrollToElement(WebElement element, WebDriver driver){
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		LOGGER.info("Java Script scrolled to view {}.",element);
		harvestWait(timeToWait);
	}
	
	/**
	 * Method to scroll up with JavascriptExecutor Class.
	 * 
	 * @param WebElement element
	 * @param WebDriver driver
	 */
	public void jsScrollUp(WebDriver driver){
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
		LOGGER.info("Java Script scrolled up of the page.");
		harvestWait(timeToWait);
	}

	/**
	 * Method of Assertion if displayed.
	 * 
	 * @param WebElement element
	 */
	public void assertIfDisplayed(WebElement element){
		LOGGER.info("Validating if {} is displayed.",element);
		boolean val= element.isDisplayed();
		Assert.assertTrue("Element is Displayed :"+val,val);
		LOGGER.info("{} is displayed: {}",element,val);
		harvestWait(timeToWait);
	}

	/**
	 * Method to return true or false if the WebElement contains the message.
	 * 
	 * @param WebElement element
	 * @param String message
	 * @return boolean
	 */
	public boolean checkMessage(WebElement element, String message){
		LOGGER.info("Checking if {} contains {}",element,message);
		return element.getText().contains(message);
	}

	/**
	 * Method returns List of WebElement with Xpath.
	 * 
	 * @param String xpathExpression
	 * @param WebDriver driver
	 * @return List<WebElement>
	 */
	public List<WebElement> getElementsByXpath(String xpathExpression, WebDriver driver){
		List<WebElement> elements = driver.findElements(By.xpath(xpathExpression));
		elements.forEach(i-> LOGGER.info("{} is present in the List.",i));
		harvestWait(timeToWait);
		return elements;
	}

	/**
	 * Method returns List of WebElement with ID.
	 * 
	 * @param String id
	 * @param WebDriver driver
	 * @return List<WebElement>
	 */
	public List<WebElement> getElementsByID(String id, WebDriver driver){
		List<WebElement> elements = driver.findElements(By.id(id));
		elements.forEach(i-> LOGGER.info("{} is present in the List.",i));
		harvestWait(timeToWait);
		return elements;
	}

	/**
	 * Method returns List of WebElement with tagName.
	 * 
	 * @param String tagName
	 * @param WebDriver driver
	 * @return List<WebElement>
	 */
	public List<WebElement> getElementsByTagName(String tagName, WebDriver driver){
		List<WebElement> elements = driver.findElements(By.tagName(tagName));
		elements.forEach(i-> LOGGER.info("{} is present in the List.",i));
		harvestWait(timeToWait);
		return elements;
	}

	/**
	 * Method returns List of WebElement with cssSelector.
	 * 
	 * @param String cssSelector
	 * @param WebDriver driver
	 * @return List<WebElement>
	 */
	public List<WebElement> getElementsByCssSelector(String cssSelector, WebDriver driver){
		List<WebElement> elements = driver.findElements(By.cssSelector(cssSelector));
		elements.forEach(i-> LOGGER.info("{} is present in the List.",i));
		harvestWait(timeToWait);
		return elements;
	}

	/**
	 * Method to maximize the window.
	 * 
	 * @param WebDriver driver
	 */
	public void windowMaximize(WebDriver driver){
		driver.manage().window().maximize();
		LOGGER.info("Window is maximized.");
		harvestWait(timeToWait);
	}

	/**
	 * Method returns true or false if element is displayed.
	 * 
	 * @param WebElement element
	 * @param WebDriver driver
	 * @return boolean
	 */
	public boolean isElementDisplayed(WebElement element, WebDriver driver){
		boolean val= element.isDisplayed();
		LOGGER.info("{} is displayed.",element);
		harvestWait(timeToWait);
		return val;
	}
	
	/**
	 * Method returns true or false if element is enabled.
	 * 
	 * @param WebElement element
	 * @param WebDriver driver
	 * @return boolean
	 */
	public boolean isElementEnabled(WebElement element, WebDriver driver){
		boolean val= element.isEnabled();
		LOGGER.info("{} is enabled.",element);
		return val;
	}

	/**
	 * Method returns true or false based on the element is present on DOM or not.
	 * 
	 * @param WebElement element
	 * @param WebDriver driver
	 * @return boolean
	 */
	public boolean isElementPresent(WebElement element, WebDriver driver){
		try{
			element.isDisplayed();
			LOGGER.info("{} is present on the DOM.",element);
			return true;
		}catch(NoSuchElementException e){
			LOGGER.error("{} is not present on the DOM.",element);
			return false;
		}catch(Exception e){
			LOGGER.error("{} is not present on the DOM.",element);
			return false;
		}
	}

	/**
	 * Method returns true or false based on the element is present on DOM or not by find elements method.
	 * 
	 * @param String xpathExpression
	 * @param WebDriver driver
	 * @return boolean
	 */
	public boolean isElementPresentWithFindElementsByXpath(String xpathExpression, WebDriver driver){
		try{
			List<WebElement> elements= getElementsByXpath(xpathExpression,driver);
			if(elements.size()>0){
				LOGGER.info("{} is present on the DOM.",xpathExpression);
				return true; 
			} else {
				LOGGER.info("{} is not present on the DOM.",xpathExpression);
				return false;
			}
		}catch(NoSuchElementException e){
			LOGGER.error("{} is not present on the DOM.",xpathExpression);
			return false;
		}catch(Exception e){
			LOGGER.error("{} is not present on the DOM.",xpathExpression);
			return false;
		}
	}
	
	/**
	 * Method returns true or false based on the element is present on DOM or not by find elements method.
	 * 
	 * @param String xpathExpression
	 * @param WebDriver driver
	 * @return boolean
	 */
	public boolean isElementPresentWithFindElementsByID(String id, WebDriver driver){
		try{
			List<WebElement> elements= getElementsByID(id,driver);
			if(elements.size()>0){
				LOGGER.info("{} is present on the DOM.",id);
				return true; 
			} else {
				LOGGER.info("{} is not present on the DOM.",id);
				return false;
			}
		}catch(NoSuchElementException e){
			LOGGER.error("{} is not present on the DOM.",id);
			return false;
		}catch(Exception e){
			LOGGER.error("{} is not present on the DOM.",id);
			return false;
		}
	}

	/**
	 * Method returns count of the element where the value matched with the list of WebElement.
	 * 
	 * @param List<WebElement> webElements
	 * @param String value
	 * @param WebDriver driver
	 * @return int
	 */
	public int getCountFromListWithTextMatched(List<WebElement> webElements,String value, WebDriver driver){
		try{
			for(int i=0;i< webElements.size();i++){
				if(webElements.get(i).getText().equals(value)){
					LOGGER.info("WebElement: {} and Value: {}",webElements.get(i),webElements.get(i).getText());
					return i;
				}
			}
			return -1;
		}catch(Exception e){
			LOGGER.error("Exception Occured while getting the count.");
			return -1;
		}
	}
	
	/**
	 * Method returns count of the element where the value partially matched with the list of WebElement.
	 * 
	 * @param List<WebElement> webElements
	 * @param String value
	 * @param WebDriver driver
	 * @return int
	 */
	public int getCountFromListWithPartiallyTextMatched(List<WebElement> webElements,String value, WebDriver driver){
		try{
			for(int i=0;i< webElements.size();i++){
				if(webElements.get(i).getText().contains(value)){
					LOGGER.info("WebElement: {} and Value: {}",webElements.get(i),webElements.get(i).getText());
					return i;
				}
			}
			return -1;
		}catch(Exception e){
			LOGGER.error("Exception Occured while getting the count.");
			return -1;
		}
	}

	/**
	 * Method gets text from the given WebElement.
	 * 
	 * @param WebElement element
	 * @param WebDriver driver
	 * @return String
	 */
	public String getTextAsString(WebElement element, WebDriver driver){
		String val= element.getText();
		LOGGER.info("{} has text {}.",element,val);
		harvestWait(timeToWait);
		return val;
	}
	
	/**
	 * Method gets value for the given attribute from the given WebElement.
	 * 
	 * @param WebElement element
	 * @param WebDriver driver
	 * @param String attribute
	 * @return String
	 */
	public String getAttribute(WebElement element, WebDriver driver, String attribute){
		String val= element.getAttribute(attribute);
		LOGGER.info("{} has {} in attribute {}.",element,val,attribute);
		harvestWait(timeToWait);
		return val;
	}

	/**
	 * Method to navigate to the url.
	 * 
	 * @param String url
	 * @param WebDriver driver
	 */
	public void navigateTo(String url, WebDriver driver){
		driver.navigate().to(url);
		LOGGER.info("Navigated to {} successfully.",url);
		harvestWait(timeToWait);
	}

	/**
	 * Method returns WebElement.
	 * 
	 * @param String identifier Example: xpath,id,name etc
	 * @param String expression Example: //*[@class='text']
	 * @param WebDriver driver
	 * @return WebElement
	 */
	public WebElement getElement(String identifier, String expression, WebDriver driver){
		switch (identifier.toLowerCase()) {
		case "xpath":
			return driver.findElement(By.xpath(expression));
		case "id":
			return driver.findElement(By.id(expression));
		case "name":
			return driver.findElement(By.name(expression));
		case "classname":
			return driver.findElement(By.className(expression));
		case "cssselector":
			return driver.findElement(By.cssSelector(expression));
		case "linktext":
			return driver.findElement(By.linkText(expression));
		case "partiallinktext":
			return driver.findElement(By.partialLinkText(expression));
		case "tagname":
			return driver.findElement(By.tagName(expression));
		default:
			throw new RuntimeException("Invalid identifier passed: " + identifier);
		}
	}

	/**
	 * Method returns WebElement by Xpath.
	 * 
	 * @param String xpathExpression
	 * @param WebDriver driver
	 * @return WebElement
	 */
	public WebElement getElementByXpath(String xpathExpression, WebDriver driver){
		return driver.findElement(By.xpath(xpathExpression));
	}

	/**
	 * Method returns WebElement by ID.
	 * 
	 * @param String id
	 * @param WebDriver driver
	 * @return WebElement
	 */
	public WebElement getElementByID(String id, WebDriver driver){
		return driver.findElement(By.id(id));
	}

	/**
	 * Method returns WebElement by ClassName.
	 * 
	 * @param String className
	 * @param WebDriver driver
	 * @return WebElement
	 */
	public WebElement getElementByClassName(String className, WebDriver driver){
		return driver.findElement(By.className(className));
	}

	/**
	 * Method returns WebElement by CSS Selector.
	 * 
	 * @param String selector
	 * @param WebDriver driver
	 * @return WebElement
	 */
	public WebElement getElementByCssSelector(String selector, WebDriver driver){
		return driver.findElement(By.cssSelector(selector));
	}

	/**
	 * Method returns WebElement by LinkText.
	 * 
	 * @param String linkText
	 * @param WebDriver driver
	 * @return WebElement
	 */
	public WebElement getElementByLinkText(String linkText, WebDriver driver){
		return driver.findElement(By.linkText(linkText));
	}

	/**
	 * Method returns WebElement by Name.
	 * 
	 * @param String name
	 * @param WebDriver driver
	 * @return WebElement
	 */
	public WebElement getElementByName(String name, WebDriver driver){
		return driver.findElement(By.name(name));
	}

	/**
	 * Method returns WebElement by Partial Link Text.
	 * 
	 * @param String partialLinkText
	 * @param WebDriver driver
	 * @return WebElement
	 */
	public WebElement getElementByPartialLinkText(String partialLinkText, WebDriver driver){
		return driver.findElement(By.partialLinkText(partialLinkText));
	}

	/**
	 * Method returns WebElement by tagName.
	 * 
	 * @param String tagName
	 * @param WebDriver driver
	 * @return WebElement
	 */
	public WebElement getElementByTagName(String tagName, WebDriver driver){
		return driver.findElement(By.tagName(tagName));
	}
	
	/**
	 * Method returns WebElement by All.
	 * 
	 * @param By... var args By
	 * @param WebDriver driver
	 * @return WebElement
	 */
	public WebElement getElementByAll(WebDriver driver,By... bys){
		return driver.findElement(new ByAll(bys));
	}

	/**
	 * Method to get to the url.
	 * 
	 * @param String url
	 * @param WebDriver driver
	 */
	public void getUrl(String url, WebDriver driver){
		driver.get(url);
		LOGGER.info("Navigated to {} successfully.",url);
		harvestWait(timeToWait);
	}

	/**
	 * Waits for the specified number of seconds.
	 * 
	 * @param seconds
	 */
	public void harvestWait(long seconds) {
		try {
			LOGGER.info("Harvesting crops for {} seconds", seconds);
			Thread.sleep(seconds * 1000);
			LOGGER.info("Crops harvested.");
		} catch (Exception e) {
		 e.printStackTrace();
		}
	}
}
