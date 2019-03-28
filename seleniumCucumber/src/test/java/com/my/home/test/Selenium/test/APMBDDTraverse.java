package com.my.home.test.Selenium.test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.my.home.test.Selenium.pagefactory.LoginPage;
import com.my.home.test.Selenium.pagefactory.OnBoardingPage;
import com.my.home.test.util.BrowserFactory;
import com.my.home.test.util.TestUtils;
import com.my.home.test.util.UICommons;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class APMBDDTraverse {

	private LoginPage objLog;
	private OnBoardingPage objOnB;
	public static WebDriver driver;
	String testIdName;
	private static final Logger LOGGER = LoggerFactory.getLogger(APMBDDTraverse.class);
	public static final String browserName = TestUtils.LOGIN_MAP.get("browserName");
	String url =TestUtils.LOGIN_MAP.get("loginURL");
	String uid ;//=TestUtils.LOGIN_MAP.get("email");
	String pwd ;//=TestUtils.LOGIN_MAP.get("password");
	String tenant ;//=TestUtils.LOGIN_MAP.get("tenant");
	
	@Before("@Selenium")
	public void setup() {
		LOGGER.info("Before suite started");
		try {
			driver = getDriver();
			
			
			//objLog = PageFactory.initElements(driver,LoginPage.class);
			//objOnB = PageFactory.initElements(driver,OnBoardingPage.class);
			
		} catch (WebDriverException e) {
			LOGGER.error("Error:::" + e);
		} catch (RuntimeException e) {
			LOGGER.error("Runtime exception thrown: " + e);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	
	@After("@Selenium")
	public void tearDown() {
			
			driver.close();
		LOGGER.info("After method invoked");
		}
	
	@Given("I want to navigate to APM url$")
	public void navigateUrl() throws Throwable {
		
		driver.navigate().to(url);
		UICommons.harvestWait(20);
	}
	
	@Given("user provided with \"([^\"]*)\"$")
	public void getUID(String uid) throws Throwable {
		
		this.uid=uid;
	}
	
	@Given("pwd provided with \"([^\"]*)\"$")
	public void getpwd(String pwd) throws Throwable {
		
		this.pwd=pwd;
	}
	
	@Given("^tenant provided with \"([^\"]*)\"$")
	public void getTenant(String tenant) throws Throwable {
		
		this.tenant=tenant;
	}
	
	@When("^I click on submit button$")
	public void i_search() throws Throwable {
		
		try {
			objLog = PageFactory.initElements(driver,LoginPage.class);
			objOnB = PageFactory.initElements(driver,OnBoardingPage.class);
		objLog.login(uid, pwd,tenant);
	
		} catch (Exception e) {
			e.printStackTrace();
			assertFalse(true);
		} finally {
		}

	}
	
	
	@Then("^I validate the apm botton$")
	public void validateAPMButton() throws Throwable {
		
		//System.out.println(driver.getPageSource());
		assertTrue(objOnB.isApmButtonVisible());

	}
	
	@Then("^click on apm bottom$")
	public void clickOnAPMButton() throws Throwable {
		
		//System.out.println(driver.getPageSource());
		try {
		objOnB.clickApmButton();
		assertTrue(true);
		}
	 catch (Exception e) {
		e.printStackTrace();
		assertTrue(false);
	} finally {
	}
	}
	
	@Given("close the popup$")
	public void closePopup() throws Throwable {
		
		objLog.closePopup();
	}
	
	@When("^I click on security tab$")
	public void securityTabClick() throws Throwable {
		
		try {
			objOnB.navigatetoLink();
	
		} catch (Exception e) {
			e.printStackTrace();
			assertFalse(true);
		} finally {
		}

	}
	
	@Then("^security list page should display$")
	public void securityList() throws Throwable {
		
		//System.out.println(driver.getPageSource());
		assertTrue(true);

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
