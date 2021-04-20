package com.epam.drivers;

import org.openqa.selenium.WebDriver;;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyFireFoxWebDriver {
    private WebDriver driver;
    private static MyFireFoxWebDriver firefox_instance=null;
    private MyFireFoxWebDriver() {
        System.setProperty("webdriver.gecko.driver","WebDrivers/geckodriver.exe");
    }
    public WebDriver openFireFox() {
        driver=new FirefoxDriver();
        return driver;
    }
    public static MyFireFoxWebDriver getInstance() {
        if(firefox_instance==null) {
            firefox_instance=new MyFireFoxWebDriver();
        }
        return firefox_instance;
    }
}