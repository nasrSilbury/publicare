package com.silbury.selenium.factories;

 

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.silbury.selenium.common.Constants;
import com.silbury.selenium.common.Constants.DriverType;
import com.silbury.selenium.common.Constants.SystemType;
import com.silbury.selenium.configuration.DriverConfiguration;
 

public class DriverFactory {

    private static final Logger logger = LoggerFactory.getLogger(DriverFactory.class);

    // TODO: get access from browserstack for publicare
    private static final String username = "nasrullahsyed1";
    private static final String accesskey = "PybExVW91ZGMpP8U4wco";
    private static final String browserStackUrl = "http://"+username+":"+accesskey+"@hub.browserstack.com/wd/hub";
    //private static final String url = "http://nasrullahsyed1.browserstack.com";
    private static WebDriver driver = null;
    private static Constants.DriverName driverName;
    private static Constants.SystemType systemType;
    private static Constants.DriverType driverType;

    public static Constants.DriverName getDriverName()
    {
        return driverName;
    }

    public static Constants.SystemType getSystemType()
    {
        return systemType;
    }

    public static Constants.DriverType getDriverType()
    {
        return driverType;
    }
 

    public static WebDriver getLocalDriverByName(String webDriverName)
    {
        driverName = Constants.DriverName.valueOf(webDriverName.toUpperCase());
        
        driverType = DriverType.LOCAL;
        switch(driverName)
        {
            /*
             * TODO:
             * case FIREFOX:
                setFirefoxDriver();
                break;*/
            case CHROME:
                setChromeDriver();
                break;
             
            default:
                return driver;
        }
        return driver;
    }

     public static WebDriver getRemoteDriverByName(String webDriverName)
    {
    	 
        DriverConfiguration configuration = new DriverConfiguration("drivers"+ File.separator + webDriverName);
        driverType = DriverType.REMOTE;
        String name = configuration.getString("browser").toUpperCase(); 
        driverName = Constants.DriverName.valueOf(name);
        DesiredCapabilities caps = getDesiredCapabilities(configuration);
        try
        {
             driver = new RemoteWebDriver(new URL(browserStackUrl), caps);
        }
        catch(MalformedURLException e)
        {
            logger.error("Failed to create RemoteWebDriver. Check BrowserStack Url.", e.getMessage());
        }
        return driver;
    } 
     
     private static DesiredCapabilities getDesiredCapabilities(DriverConfiguration configuration)
     {
         DesiredCapabilities caps = new DesiredCapabilities();

         caps.setCapability("project", "Public Care");

         String sourceBranch = System.getProperty("sourceBranch");
         
   
         if(StringUtils.isNotEmpty(sourceBranch))
         {
             caps.setCapability("name", sourceBranch);
         }

         String buildNumber = System.getProperty("BUILD_NUMBER");
 
         if(StringUtils.isNotEmpty(buildNumber))
         {
             caps.setCapability("build", buildNumber);
         }

         String browser = configuration.getString("browser");

         caps.setCapability("browser", browser);
         caps.setCapability("acceptSslCerts", "true");
         caps.setCapability("browserstack.debug", "true");

         caps.setCapability("browser_version", configuration.get("browser_version"));
         caps.setCapability("os", configuration.get("os"));
         caps.setCapability("os_version", configuration.get("os_version"));
         caps.setCapability("resolution", configuration.get("resolution"));
        
      
         driverName = Constants.DriverName.WEBDRIVER;
        
         systemType = SystemType.DESKTOP;
        

         return caps;
     }
 

    private static void setChromeDriver()
    {
        checkDriver("webdriver.chrome.driver");
        driver = new ChromeDriver();
        systemType = SystemType.DESKTOP;
    }
  
    private static void checkDriver(String propertyName)
    {
        String driverPath = System.getProperty(propertyName);
        
        if(driverPath == null)
        {
            logger.error(
                    "For Driver " + driverName + " System Property " + propertyName +
                    " is not set");
            return;
        }
        File file = new File(driverPath);
        if(!file.exists())
        {
            logger.error(
                    "For Driver " + driverName +
                    " System Property set for webdriver.chrome.driver is " +
                    file.getAbsolutePath() + " which does not exist");
        }
    }
}
