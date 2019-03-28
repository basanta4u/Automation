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
import com.my.home.test.util.SeleniumUtility;

public class OnBoardingPage {

	protected final Logger logger = LoggerFactory.getLogger(getClass());
	WebDriverWait wait;
	WebDriver driver;
	SeleniumUtility seleniumUtils = new SeleniumUtility();
	

	// 'Application Monitoring' Open Button on Onboarding page
	@FindBy(how = How.ID, using = "APM_openbtn")
	WebElement apmOpenBtn;

	@FindBy(how = How.ID, using = "AXA_openbtn")
	WebElement axaOpenBtn;
	
	@FindBy(how = How.ID, using = "settings-security-link")
	WebElement security;
	
	

	public OnBoardingPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 60);
	}

	

	public void clickApmButton() throws InterruptedException {
		logger.info("started clickApmButton method from process start ::"+ System.currentTimeMillis());

		try{
			wait.until(ExpectedConditions.elementToBeClickable(apmOpenBtn));
			apmOpenBtn.click();
			wait.until(JSWaiter.angularHasFinishedProcessing());

			logger.info("completed  clickApmButton method");
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
		logger.info("clickApmButton process completed ::"+ System.currentTimeMillis());
	}
	
	public boolean isApmButtonVisible() throws InterruptedException {
		logger.info("started clickApmButton method from process start ::"+ System.currentTimeMillis());

		boolean flag=false;
		try{
			wait.until(ExpectedConditions.elementToBeClickable(apmOpenBtn));
			apmOpenBtn.isDisplayed();
			flag= true;
			

			
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
		return flag;
	}

	public String getSaaSEMHost() throws NoSuchElementException {

		String saaSEMHost = null;
		logger.info("started getSaaSEMHost method from Exprience view Home page from APM ::"+ System.currentTimeMillis());
		try {
			wait.until(ExpectedConditions.elementToBeClickable(apmOpenBtn));
			apmOpenBtn.click();
			wait.until(JSWaiter.angularHasFinishedProcessing());

			String emURL = driver.getCurrentUrl();
			logger.info("SaaS EM url is: " + emURL);
			String hosts[] = emURL.split("/");
			saaSEMHost = hosts[2];
			logger.info("Host Name is: " + saaSEMHost);

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
		logger.info("getSaaSEMHost process completed ::"+ System.currentTimeMillis());

		return saaSEMHost;

	}
	
	public void navigatetoLink() throws InterruptedException {
		logger.info("started security method from process start ::"+ System.currentTimeMillis());

		try{
			wait.until(ExpectedConditions.elementToBeClickable(security));
			security.click();
			wait.until(JSWaiter.angularHasFinishedProcessing());

			logger.info("completed  security method");
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
		logger.info("clickApmButton process completed ::"+ System.currentTimeMillis());
	}

	
	
	
}
