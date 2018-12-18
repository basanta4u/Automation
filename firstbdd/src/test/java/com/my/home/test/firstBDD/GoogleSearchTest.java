package com.my.home.test.firstBDD;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.my.home.test.firstBDD.util.BrowserFactory;

public class GoogleSearchTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(GoogleSearchTest.class);
	private WebDriver driver;
	private String baseUrl;
	/**
	 * protected method to get Driver object from browser factory
	 * @return WebDriver object
	 */
@BeforeClass
	protected WebDriver getDriver() {
		LOGGER.info("Driver Object Initation start");
		try {
			BrowserFactory bf= BrowserFactory.getInstanceOfBrowserFactory("chrome");
			driver=bf.getDriver();

		} catch (WebDriverException e) {
			LOGGER.error("Error:::" + e);
		} catch (RuntimeException e) {
			LOGGER.error("Runtime exception thrown: " + e);
		} catch (Exception e) {
			e.printStackTrace();
		}
		baseUrl = "https://www.google.com/";
		LOGGER.info("Driver Object Initation process End ");
		return driver;
	}
@AfterClass	
public void tearDown() {
		
	//	driver.quit();
	}
@Test
public void get_google_search_page() throws Throwable {
	driver.get(baseUrl);
}

}
