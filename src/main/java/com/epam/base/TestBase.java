package com.epam.base;

import com.epam.constants.MyConstants;
import com.epam.drivers.MyChromeWebDriver;
import com.epam.drivers.MyFireFoxWebDriver;
import com.epam.drivers.MyIEWebDriver;
import com.epam.exceptions.BrowserNotFoundException;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public WebDriver driver;
    public static Properties prop;
    public TestBase() {
        try {
            prop= new Properties();
            FileInputStream ip=new FileInputStream("src/main/java/com/epam/config/config.properties");
            prop.load(ip);
        } catch(IOException e) {
            e.printStackTrace();
        }

    }
    public WebDriver initialization() {
        String browserName= prop.getProperty("browser");
        try {
            switch (browserName) {
                case MyConstants.CHROME:
                    MyChromeWebDriver chrome_instance=MyChromeWebDriver.getInstance();
                    driver= chrome_instance.openChrome();
                    break;
                case MyConstants.FIREFOX:
                    MyFireFoxWebDriver firefox_instance=MyFireFoxWebDriver.getInstance();
                    driver= firefox_instance.openFireFox();
                    break;
                case MyConstants.IE:
                    MyIEWebDriver ie_instance=MyIEWebDriver.getInstance();
                    driver= ie_instance.openIE();
                    break;
                default: throw new BrowserNotFoundException();
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(MyConstants.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(MyConstants.IMPLICIT_WAIT,TimeUnit.SECONDS);
            driver.get(prop.getProperty("url"));
        } catch(BrowserNotFoundException e) {
            System.out.print("Web Browser Not Found");
        }
        return driver;
    }
}
