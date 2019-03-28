package com.my.home.test.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UICommons {

	private static final Logger logger = LoggerFactory.getLogger(UICommons.class);

	WebDriver driver;
	WebDriverWait wait;
	Actions action;
	

	@FindBy(how = How.XPATH, using = "//div[@class='nav-popover-icon-container']/img")
	WebElement productGridIcon;
	
	@FindBy(how = How.XPATH, using ="//*[contains(@ng-click,'gridMenuOn')]")
	WebElement productGridAXAIcon;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Application Performance Management')]")
	WebElement appPerformanceManagement;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'App Experience Analytics')]")
	WebElement appExperienceAnalytics;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Application Performance Management')]")
	WebElement axaToAPM;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Infrastructure Management')]")
	WebElement infrastructureManagement;

	public UICommons(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 60);
		action = new Actions(driver);
		

	}
	
	public boolean clickAXAProductGrid()
	
	{
		
		try {
		logger.info("Clicking product icon grid to navigate to {}.");
		wait.until(ExpectedConditions.elementToBeClickable(productGridAXAIcon));
		productGridAXAIcon.click();
		wait.until(JSWaiter.angularHasFinishedProcessing());
		return true;
		} catch (StaleElementReferenceException e) {
			logger.error("Runtime exception thrown: " + e);
			throw e;
		} catch (NoSuchElementException e) {
			logger.error("Error occoured while Grab the UI instance");
			e.printStackTrace();
			throw e;
		} catch (WebDriverException e) {
			logger.error("Error:::" + e);
			throw e;
		}
	}
	
public boolean clickOnAPMFromAXAGrid()
	
	{
		
		try {
		logger.info("Clicking clickOnAPMFromAXAGrid icon grid to navigate to {}.");
		
		wait.until(ExpectedConditions.elementToBeClickable(axaToAPM));
		axaToAPM.click();
		wait.until(JSWaiter.angularHasFinishedProcessing());
		return true;
		} catch (StaleElementReferenceException e) {
			logger.error("Runtime exception thrown: " + e);
			throw e;
		} catch (NoSuchElementException e) {
			logger.error("Error occoured while Grab the UI instance");
			e.printStackTrace();
			throw e;
		} catch (WebDriverException e) {
			logger.error("Error:::" + e);
			throw e;
		}
	}

	
	//TODO need to move to 
	public  void actionsMoveToElement(WebElement element, WebDriver driver){
		Actions action = new Actions (driver);
		//wait.until(JSWaiter.angularHasFinishedProcessing());
		harvestWait(5);
		action.moveToElement(element).perform();
		logger.info("{} is clicked.",element);
		//utils.harvestWait(timeToWait);
	}
	
	/**
     * Waits for the specified number of seconds.
     *
     * @param seconds
     */
    public static void harvestWait(long seconds) {//TODO
        try {
        	logger.info("Harvesting crops for {} seconds", seconds);
            Thread.sleep(seconds * 1000);
            logger.info("Crops harvested.");
        } catch (Exception e) {
     	   e.printStackTrace();
           
        }
    }
	
	public static boolean waitForElementToAppear(WebDriver driver,
			WebElement element, long maxTimeInSec) {

		boolean webElementPresence = false;

		try {
			Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
					.pollingEvery(2, TimeUnit.SECONDS)
					.withTimeout(maxTimeInSec, TimeUnit.SECONDS)
					.ignoring(NoSuchElementException.class);

			fluentWait.until(ExpectedConditions.visibilityOf(element));

			if (element.isDisplayed()) {
				webElementPresence = true;

			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		return webElementPresence;
	}
	
	
}
