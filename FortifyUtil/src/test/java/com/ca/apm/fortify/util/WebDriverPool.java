package com.ca.apm.fortify.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverPool
{
    public WebDriver driver;
    public WebDriver initializeDriver(String SELENIUM_BROWSER, String bitmode, String browserWebDriversPath) throws Exception
    {

                    
//initialize the driver based on the browser to be used. Default being firefox
        System.out.println(SELENIUM_BROWSER+browserWebDriversPath+"/webdrivers/chrome/chromedriver.exe");
        if("*iexplore".equalsIgnoreCase(SELENIUM_BROWSER.trim()))
                    {
                                    System.setProperty("webdriver.ie.driver", browserWebDriversPath+"/webdrivers/iexplore/"+bitmode+"/IEDriverServer.exe");
                                    driver = new InternetExplorerDriver();
                    }
        else if("*chrome".equalsIgnoreCase(SELENIUM_BROWSER.trim())){
                                    System.setProperty("webdriver.chrome.driver", browserWebDriversPath+"/webdrivers/chrome/chromedriver.exe");
                                    driver=new ChromeDriver();
                    }
                    else{
                                    driver = new FirefoxDriver();
                    }
                    driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);//timeout for get()/navigate().to methods
                    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //FindElement timeout-->how long it has to wait before it throws no such element exception
                    driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);//JavaScript Executor(Asynchronous) timeout - close to pageloadtimeout
                    
                    driver.manage().window().maximize();
    
                    return driver;
    }

}
