

package com.my.home.test.util;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




/**
 * @author (Basanta Kumar Dwibedy)
 *
 */

public class BrowserFactory {

	// instance of singleton class
	private static BrowserFactory instanceOfBrowserFactory=null;

	private static WebDriver driver;
	private static final Logger LOGGER = LoggerFactory.getLogger(BrowserFactory.class); 
	
	public static String downloadFilepath = "/Users/dwiba01/sw/"+"downloads";

	// Constructor
	private BrowserFactory(String browserName){
		
		//String downloadFilepath = TasBuilder.WIN_SOFTWARE_LOC+"downloads";

		if (browserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/dwiba01/sw/"+"chromedriver");
			DesiredCapabilities cap = DesiredCapabilities.chrome();	    	
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.default_directory", downloadFilepath);
			//chromePrefs.put("safebrowsing.enabled", "false");
			ChromeOptions options = new ChromeOptions();
			HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();
			options.setExperimentalOption("prefs", chromePrefs);
			//options.addArguments("--test-type");
			options.addArguments("--safebrowsing-disable-download-protection");

			cap.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			cap.setCapability(ChromeOptions.CAPABILITY, options);	

			LOGGER.info("Chrome Driver Capabilities added...");

			driver = new ChromeDriver(cap);              			
		}
		else if(browserName.equalsIgnoreCase("Firefox")){
		/*	LOGGER.info("Desired Capabilities : FIREFOX");
			final DesiredCapabilities cap = DesiredCapabilities.firefox();
			// Use old Firefox extension based driver instead of new Marionette driver.
			cap.setCapability("marionette", false);
			FirefoxProfile prof = new FirefoxProfile();
			prof.setPreference("browser.helperApps.neverAsk.openFile", "application/zip;application/x-gzip");
			prof.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/zip;application/x-gzip");
			prof.setPreference("browser.download.folderList", 2);
			prof.setPreference("browser.download.dir", downloadFilepath);
			prof.setPreference("browser.download.manager.showWhenStarting", false);
			cap.setCapability("firefox_profile", prof);
			LoggingPreferences logs = new LoggingPreferences();
			logs.enable(LogType.DRIVER, Level.INFO);
			logs.enable(LogType.BROWSER, Level.INFO);
			cap.setCapability(CapabilityType.LOGGING_PREFS, logs);
			cap.setJavascriptEnabled(true);

			LOGGER.info("Firefox Driver Capabilities added...");

			driver = new RemoteWebDriver(cap);*/
		}

		else if(browserName.equalsIgnoreCase("InternetExplorer")||browserName.equalsIgnoreCase("IE")||browserName.equalsIgnoreCase("Internet_Explorer")){
		/*	LOGGER.info("Desired Capabilities : INTERNET_EXPLORER");
			DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
			cap.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
			cap.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true);
			cap.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
			cap.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR,UnexpectedAlertBehaviour.DISMISS);
			cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			cap.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, true);
			cap.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");
			cap.setCapability(InternetExplorerDriver.LOG_FILE, "iewebdriver.log");
			cap.setCapability(InternetExplorerDriver.LOG_LEVEL, InternetExplorerDriverLogLevel.TRACE);
			LoggingPreferences logs = new LoggingPreferences();
			logs.enable(LogType.DRIVER, Level.INFO);
			logs.enable(LogType.BROWSER, Level.INFO);
			cap.setCapability(CapabilityType.LOGGING_PREFS, logs);
			cap.setJavascriptEnabled(true);

			LOGGER.info("INTERNET_EXPLORER Driver Capabilities added...");

			driver = new RemoteWebDriver(cap);*/
		}
		
		else if (browserName.equalsIgnoreCase("ChromeHeadless")) {
			
			LOGGER.info("Desired Capabilities : HREADLESS BROWSER");
			System.setProperty("webdriver.chrome.driver", "/Users/dwiba01/sw/"+"chromedriver");			
			DesiredCapabilities cap = DesiredCapabilities.chrome();	    	
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			ChromeOptions options = new ChromeOptions();
			HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();
			options.setExperimentalOption("prefs", chromePrefs);
			options.addArguments("--test-type");
			options.addArguments("headless");
			options.addArguments("window-size=1200x600");

			cap.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			cap.setCapability(ChromeOptions.CAPABILITY, options);
			
			
			driver = new RemoteWebDriver(cap);
			
		}
		
	}

	// To get driver
	public WebDriver getDriver(){
		LOGGER.info("Initializing Remote Driver...");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);//timeout for get()/navigate().to methods
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //FindElement timeout-->how long it has to wait before it throws no such element exception
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);//JavaScript Executor(Asynchronous) timeout - close to pageloadtimeout
		return driver;
	}

	// TO create instance of class
	public static BrowserFactory getInstanceOfBrowserFactory(String browser){
		//if(instanceOfBrowserFactory==null){
		instanceOfBrowserFactory = new BrowserFactory(browser);
		//}
		return instanceOfBrowserFactory;
	}


	/*
	 public static WebDriver initDriver (String browserName, String url) {	

		return driver;
	} */

	/*
	 * sample invocaton
	 * SingletonBrowserClass sbc1= SingletonBrowserClass.getInstanceOfSingletonBrowserClass();
		WebDriver driver1 = sbc1.getDriver();
	 * 
	 */

}
