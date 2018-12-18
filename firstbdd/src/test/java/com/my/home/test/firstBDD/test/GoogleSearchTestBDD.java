package com.my.home.test.firstBDD.test;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.my.home.test.firstBDD.util.BrowserFactory;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GoogleSearchTestBDD {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(GoogleSearchTestBDD.class);
	private WebDriver driver;
	private String baseUrl;
	/**
	 * protected method to get Driver object from browser factory
	 * @return WebDriver object
	 */
	@Before("@Selenium")
	public WebDriver getDriver() {
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
@After("@Selenium")
public void tearDown() {
		
		//driver.quit();
	}
@Given("^the google search page$")
public void get_google_search_page() throws Throwable {
	//getDriver();
	driver.get(baseUrl);
}

@When("^I search \"([^\"]*)\"$")
public void i_search(String searchedItem) throws Throwable {
	driver.findElement(By.xpath("//input[@type='text']")).clear();
	driver.findElement(By.xpath("//input[@type='text']")).sendKeys(searchedItem);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@type='submit']")).submit();
	Thread.sleep(3000);

}

@Then("I should find a list results of \"([^\"]*)\"$")
public void i_should_find_a_list_results_of(String searchedItem) throws Throwable {
	
	//System.out.println(driver.getPageSource());
	assertTrue(driver.getTitle().contains(searchedItem));

}


}
