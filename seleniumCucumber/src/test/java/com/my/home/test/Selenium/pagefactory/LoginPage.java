package com.my.home.test.Selenium.pagefactory;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.my.home.test.util.JSWaiter;
import com.my.home.test.util.UICommons;

public class LoginPage {

	private static final Logger logger = LoggerFactory.getLogger(LoginPage.class);

	WebDriver driver;
	WebDriverWait wait;
	long maxTimeWaitInSec = 20;
	@FindBy(how = How.ID, using = "username")
	WebElement userName;

	@FindBy(how = How.ID, using = "password")
	WebElement passWord;

	@FindBy(how = How.ID, using = "tenant_id")
	WebElement tenantId;

	@FindBy(how = How.ID, using = "sppSignInBtn")
	WebElement signIn;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'wm-shoutout')]/div[contains(@class,'wm-close-button')]")
	WebElement popUp1;

	@FindBy(how = How.XPATH, using = "//div[@class='walkme-custom-balloon-content-wrapper']/div[contains(@class,'walkme-click-and-hover')]")
	WebElement popUp2;

	 //TODO pop-up window change xpath
	@FindBy(how = How.XPATH, using = "//div[@class='walkme-click-and-hover walkme-custom-balloon-close-button walkme-action-close walkme-inspect-ignore']")
    WebElement axaPopUp;
    
	@FindBy(how = How.XPATH, using = "//*[@id='walkme-balloon-undefined']//span[text()='OK']")
	WebElement popUp3;

	@FindBy(how = How.ID, using = "user-logout")
	WebElement logout;

	@FindBy(how = How.XPATH, using = "//span[text()='Logout']")
	WebElement logoutLink;
	
	@FindBy(how = How.XPATH, using = "//a[contains(@ng-click, 'Logout') or contains(@ng-click,'logout') ]")
	WebElement logoutNgClick;
	
	@FindBy(how = How.XPATH, using = "//a[contains(@ng-click,'logout')]")
	WebElement logoutAXA;
	
	@FindBy(how = How.XPATH, using = "//header[text()='Trial Expired']")
	WebElement trialExpiredMsg;
	
	
	
	

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 60);
	}

	public void closePopup() throws Exception {
		logger.info("Clicked on the APM popup ::" + System.currentTimeMillis());
		
		try {

			if (UICommons.waitForElementToAppear(driver, popUp1, maxTimeWaitInSec)) {

				popUp1.click();
				logger.info("Pop up1 Closed successful...");

				if (UICommons.waitForElementToAppear(driver, popUp2, maxTimeWaitInSec)) {

					popUp2.click();
					logger.info("Pop up2 Closed successful...");
				}
			} else if (UICommons.waitForElementToAppear(driver, popUp2, maxTimeWaitInSec)) {

				popUp2.click();
				logger.info("Pop up2 Closed successful...");
			}
			if (UICommons.waitForElementToAppear(driver, popUp3, maxTimeWaitInSec)) {
				popUp3.click();
				logger.info("Pop up3 Closed successful...");
			}

			wait.until(ExpectedConditions.elementToBeClickable(logout));
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
		logger.info("APM popup process completed ::"+ System.currentTimeMillis());
	}
	
	public void closeAxAPopup() throws Exception {
		logger.info("Clicked on the AAX popup ::" + System.currentTimeMillis());
		
		try {

			if (UICommons.waitForElementToAppear(driver, axaPopUp,
					maxTimeWaitInSec)) {

				axaPopUp.click();
				wait.until(JSWaiter.angularHasFinishedProcessing());
				logger.info("Pop up1 Closed successful...");

			}
			if (UICommons.waitForElementToAppear(driver, popUp3,
					maxTimeWaitInSec)) {
				popUp3.click();
				logger.info("Pop up3 Closed successful...");
			}

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
		logger.info("AXA popup process completed ::"
				+ System.currentTimeMillis());
	}
	
	public void logoutAXA() throws Exception {
		logger.info("Click on to singout from AXA ::"
				+ System.currentTimeMillis());
		try {
			
			
				wait.until(ExpectedConditions.visibilityOf(logoutAXA));
				wait.until(ExpectedConditions.elementToBeClickable(logoutAXA));
				logoutAXA.click();
			
			wait.until(ExpectedConditions.visibilityOf(userName));
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
		logger.info("SignOut process from AXA completed ::"+ System.currentTimeMillis());
	}

	public void logoutID() throws Exception {
		logger.info("Click on to singout from APM ::"+ System.currentTimeMillis());
		try {
			
			
				wait.until(ExpectedConditions.visibilityOf(logout));
				wait.until(ExpectedConditions.elementToBeClickable(logout));
				logout.click();
			
			wait.until(ExpectedConditions.visibilityOf(userName));
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
		logger.info("SignOut process from APM completed ::"+ System.currentTimeMillis());
	}
	
	public void logoutNG() throws Exception {
		logger.info("Click on to singout from APM ::"+ System.currentTimeMillis());
		try {
			
			
				wait.until(ExpectedConditions.visibilityOf(logoutNgClick));
				wait.until(ExpectedConditions.elementToBeClickable(logoutNgClick));
				logoutNgClick.click();
			
			wait.until(ExpectedConditions.visibilityOf(userName));
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
		logger.info("SignOut process from APM completed ::"+ System.currentTimeMillis());
	}
	
	public void logoutLink() throws Exception {
		logger.info("Click on to singout from APM ::"+ System.currentTimeMillis());
		try {
			
			
				wait.until(ExpectedConditions.visibilityOf(logoutLink));
				wait.until(ExpectedConditions.elementToBeClickable(logoutLink));
				logoutLink.click();
			
			wait.until(ExpectedConditions.visibilityOf(userName));
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
		logger.info("SignOut process from APM completed ::"+ System.currentTimeMillis());
	}

	
	public void login(String usrName, String pwd) throws Exception {
		logger.info("Click on to login from APM ::"
				+ System.currentTimeMillis());
		try {
			wait.until(ExpectedConditions.visibilityOf(userName));
			userName.sendKeys(usrName);
			passWord.sendKeys(pwd);
			signIn.click();
			wait.until(ExpectedConditions.visibilityOf(logoutLink));
			//wait.until(JSWaiter.angularHasFinishedProcessing());
			
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
		logger.info("login process from APM completed ::"+ System.currentTimeMillis());
	}

	public void login(String usrName, String pwd, String tid) throws Exception {
		logger.info("Click on to login from APM ::"+ System.currentTimeMillis());
		try {
			
			wait.until(ExpectedConditions.visibilityOf(userName));
			userName.sendKeys(usrName);
			passWord.sendKeys(pwd);
			if(tenantId.isDisplayed())	tenantId.sendKeys(tid);
			signIn.click();
			logger.info("Click on SignIn button");
			wait.until(ExpectedConditions.visibilityOf(logoutLink));
			//wait.until(JSWaiter.angularHasFinishedProcessing());
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
		logger.info("login process from APM completed ::"+ System.currentTimeMillis());
	}
	
	public void loginAfterTrialExpired(String usrName, String pwd, String tid) throws Exception {
		logger.info("Click on to login from APM ::"+ System.currentTimeMillis());
		try {
			
			wait.until(ExpectedConditions.visibilityOf(userName));
			userName.sendKeys(usrName);
			passWord.sendKeys(pwd);
			if(tenantId.isDisplayed())	tenantId.sendKeys(tid);
			signIn.click();
			logger.info("Click on SignIn button");
			wait.until(ExpectedConditions.visibilityOf(trialExpiredMsg));
			//wait.until(JSWaiter.angularHasFinishedProcessing());
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
		logger.info("login process from APM completed ::"+ System.currentTimeMillis());
	}

	
}
