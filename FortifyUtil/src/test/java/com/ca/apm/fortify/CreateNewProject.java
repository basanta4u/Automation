package com.ca.apm.fortify;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.Key;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ca.apm.fortify.util.PropertiesRead;
import com.ca.apm.fortify.util.WebDriverPool;
import com.ca.apm.fortify.util.WebdriverWrapper;

public class CreateNewProject
{
    public WebDriver      driver;

    private static Logger logger               = Logger.getLogger(CreateNewProject.class);

    private String        path                 = "C:/apm-dev/workspace/FortifyUtil/src/test/resources/";

    private String        extension            = ".properties";

    public PropertiesRead environmentConstants = new PropertiesRead( path + "environmentConstants" + extension);

    public PropertiesRead orProperties         = new PropertiesRead(path + "ORProperties"+ extension);

//@Test  
public void createProjectTest() throws Exception
{
    String projectName= environmentConstants.getProperties("projectName");
    String ProductVersion=environmentConstants.getProperties("ProductVersion");
    
     Login();
     createProject(projectName,ProductVersion);
}
 
 @Test  
public void createProjectVersionTest() throws Exception
{
     String[] versionName= environmentConstants.getProperties("VersionName").split(",");
     String dropdownCounter= environmentConstants.getProperties("dropdownCounter");
     Login();
     for(int i=0;i<versionName.length;i++)
     {
         logger.info("Called verionName::"+versionName[i]+"::::dropdownCounter:::"+dropdownCounter);
         createVersion(Integer.parseInt(dropdownCounter),versionName[i]);
     }
     
     
}

    
 
    private void Login() throws Exception
    {
     logger.info("Inside afterTest");

        WebdriverWrapper.inputText(driver, orProperties.getProperties("login.username"),"dwiba01");
        WebdriverWrapper.inputText(driver,orProperties.getProperties("login.password"),"XXXXXXXXX");
        WebdriverWrapper.click(driver,orProperties.getProperties("login.submit"));
        harvestWait(40);
      

    }

    private void createProject(String ProjectName,String ProductVersion) throws Exception
    {
        Screen s = new Screen();

        s.wait("imgs/projects.png");
        s.find("imgs/projects.png").click();
        harvestWait(20);
        s.wait("imgs/add.png");
        s.find("imgs/add.png").click();
        harvestWait(10);
        s.wait("imgs/createNew.png");
        s.find("imgs/createNew.png").click();

        harvestWait(10);
        s.type(Key.TAB);
        s.type(ProjectName);
        s.type(Key.TAB);
        s.type(Key.TAB);
        s.type("Agent");
        s.wait("imgs/next.png");
        s.find("imgs/next.png").click();

        harvestWait(10);
        s.wait("imgs/dependanciesnext.png");
        s.find("imgs/dependanciesnext.png").click();

        s.wait("imgs/businessUnit.png");
        s.find("imgs/businessUnit.png").click();

        s.type("I");
        s.type("I");
        s.type("I");

        s.type(Key.TAB);

        s.type("H");

        s.type(Key.TAB);
        s.type(Key.TAB);
        s.type(Key.TAB);
        s.type(Key.TAB);

        s.type("CA Application Performance Mangement");

        s.type(Key.TAB);

        s.type(ProductVersion);

        s.wait("imgs/next.png");
        s.find("imgs/next.png").click();

        harvestWait(10);
        s.type(Key.TAB);
        s.type(Key.TAB);
        s.type(Key.TAB);
        s.type(Key.TAB);

        s.type("N");
        s.type(Key.TAB);
        s.type("I");
        s.type(Key.TAB);
        s.type("I");
        // s.type(Key.TAB);

        s.wait("imgs/next.png");
        s.find("imgs/next.png").click();

        s.wait("imgs/projectTemplate.png");
        s.find("imgs/projectTemplate.png").click();
        harvestWait(3);
        s.type("C");
        harvestWait(3);
        s.type("C");
        harvestWait(3);
        boolean flag=Boolean.parseBoolean(environmentConstants.getProperties("projectCreateFlag"));
        logger.info("project creation flag::"+flag);
        s.wait("imgs/finish.png");
        
                if(flag)
                {
        s.find("imgs/finish.png").click();
        harvestWait(5);
                }
                else
                {
                    s.find("imgs/finish.png"); 
                }
        logger.info("Finish Button Found -If need to create write click() event for this");

    }

    private void createVersion(int dropdowncounter, String versionName) throws Exception
    {
   
        Screen s = new Screen();

        s.wait("imgs/projects.png");
        s.find("imgs/projects.png").click();
        harvestWait(20);
        s.wait("imgs/add.png");
        s.find("imgs/add.png").click();
        harvestWait(10);

        s.type(Key.TAB);
        s.type(Key.TAB);
        s.type(Key.DOWN);

        for (int i = 0; i < dropdowncounter; i++)
        {
            harvestWait(2);
            s.type(Key.DOWN);
            logger.info("Drop down Counter:::" + i);
        }

        harvestWait(10);
        s.type(Key.TAB);
        s.type(versionName);

        harvestWait(3);
        s.find("imgs/excopyfromchk.png").click();

        harvestWait(5);
        s.type(Key.TAB);
        harvestWait(5);
        s.type(Key.DOWN);
        harvestWait(3);
        s.wait("imgs/bugtrackingSettings.png");
        s.find("imgs/bugtrackingSettings.png").click();
        harvestWait(3);
        s.wait("imgs/customTags.png");
        s.find("imgs/customTags.png").click();
        harvestWait(3);
        s.wait("imgs/analysisprocessingRule.png");
        s.find("imgs/analysisprocessingRule.png").click();
        harvestWait(3);
        s.wait("imgs/projectState.png");
        s.find("imgs/projectState.png").click();
        harvestWait(3);
        s.wait("imgs/exnext.png");
        s.find("imgs/exnext.png").click();

        harvestWait(10);

        s.wait("imgs/exnext.png");
        s.find("imgs/exnext.png").click();

        harvestWait(10);

        s.wait("imgs/exnext.png");
        s.find("imgs/exnext.png").click();

        harvestWait(10);

        s.wait("imgs/exnext.png");
        s.find("imgs/exnext.png").click();

        harvestWait(10);

        s.wait("imgs/projectTemplate.png");
        s.find("imgs/projectTemplate.png").click();

        harvestWait(3);
        s.type("C");
        harvestWait(3);
        s.type("C");
        harvestWait(3);

        s.wait("imgs/finish.png");
        harvestWait(3);
        boolean flag=Boolean.parseBoolean(environmentConstants.getProperties("projectversionCreateFlag"));
        logger.info("project version creation flag::"+flag);
        if(flag)
        {
s.find("imgs/finish.png").click();
harvestWait(10);
        }
        else
        {
            s.find("imgs/finish.png"); 
        }
        
        s.wait("imgs/report.png");
        harvestWait(3);
        s.find("imgs/report.png").click();
        harvestWait(3);
        logger.info("Finish Button Found -If need to create write click() event for this");

    }

    @BeforeClass
    public void beforeClass()
    {
        // logger.info("environmentConstants"+environmentConstants.getProperties("hello"));
        logger.info("Inside orProperties" + orProperties.getProperties("hello"));

        if (driver == null)
        {
            WebDriverPool wd = new WebDriverPool();
            try
            {
                driver = wd.initializeDriver(environmentConstants
                        .getProperties("browser"), environmentConstants
                        .getProperties("bitmode"), environmentConstants
                        .getProperties("WORKING_DIR"));

            } catch (Exception e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            WebdriverWrapper.navigateToUrl(driver, environmentConstants
                    .getProperties("LOGIN_URL"));
        }
    }

    @AfterClass
    public void afterClass()
    {
        logger.info("Inside afterClass");
        driver.quit();
    }

    @BeforeTest
    public void beforeTest()
    {
        logger.info("Inside beforeTest");
        
    }

    @AfterTest
    public void afterTest()
    {
        logger.info("Inside afterTest");
    }

    /**
     * Waits for the specified number of seconds.
     * 
     * @param seconds
     */
    public void harvestWait(int seconds)
    {
        try
        {
            logger.info("Harvesting crops for " + String.valueOf(seconds)
                        + " seconds");
            Thread.sleep(seconds * 1000);
            logger.info("Crops harvested.");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
