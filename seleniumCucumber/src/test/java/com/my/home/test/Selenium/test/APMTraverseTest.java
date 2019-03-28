package com.my.home.test.Selenium.test;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;

import com.my.home.test.Selenium.pagefactory.LoginPage;
import com.my.home.test.Selenium.pagefactory.OnBoardingPage;
import com.my.home.test.util.BrowserFactory;
import com.my.home.test.util.TestUtils;

public class APMTraverseTest {
	
	private LoginPage objLog;
	private OnBoardingPage objOnB;
	public static WebDriver driver;
	String testIdName;
	private static final Logger LOGGER = LoggerFactory.getLogger(APMTraverseTest.class);
	public static final String browserName = TestUtils.LOGIN_MAP.get("browserName");
	String url=TestUtils.LOGIN_MAP.get("loginURL");
	String uid=TestUtils.LOGIN_MAP.get("email");
	String pwd=TestUtils.LOGIN_MAP.get("password");
	String tenant=TestUtils.LOGIN_MAP.get("tenant");
	
	@BeforeMethod(alwaysRun = true)
	public void setup() {
		LOGGER.info("Before suite started");
		try {
			driver = getDriver();
			
			
			objLog = PageFactory.initElements(driver,LoginPage.class);
			objOnB = PageFactory.initElements(driver,OnBoardingPage.class);
			
		} catch (WebDriverException e) {
			LOGGER.error("Error:::" + e);
		} catch (RuntimeException e) {
			LOGGER.error("Runtime exception thrown: " + e);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	
	protected WebDriver getDriver() {
		LOGGER.info("Driver Object Initation start");
		try {
			BrowserFactory bf= BrowserFactory.getInstanceOfBrowserFactory(browserName);
			driver=bf.getDriver();
			/*if(driver==null)
			{
			
			driver=BrowserFactory.initDriver(browserName, url);
			}*/
		} catch (WebDriverException e) {
			LOGGER.error("Error:::" + e);
		} catch (RuntimeException e) {
			LOGGER.error("Runtime exception thrown: " + e);
		} catch (Exception e) {
			e.printStackTrace();
		}
		LOGGER.info("Driver Object Initation process End ");
		return driver;
	}
	
	// Test No. 1
	/*	@Test(groups = { "MyHomeTest" }, enabled = true, priority = 1)
		public void verify_APM_Login() {

			testIdName = "verify_APM_Login";
			
			
			LOGGER.info("Test Execution started for test case ::_" + testIdName);
			try {
				driver.navigate().to(url);
				
					objLog.login(uid, pwd,tenant);
					objOnB.clickApmButton();
					objLog.closePopup();
					objOnB.navigatetoLink();
					
				

			} catch (Exception e) {
				e.printStackTrace();
				Assert.assertTrue("Got some exceptions.. ", false);
			} finally {
			}

			LOGGER.info(testIdName + " Test Execution ended");
		}*/
}
