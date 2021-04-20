package com.epam.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class MyIEWebDriver {
    private WebDriver driver;
    private static MyIEWebDriver ie_instance=null;
    private MyIEWebDriver() {
        System.setProperty("webdriver.ie.driver", "WebDrivers/IEDriverServer.exe");
    }
    public WebDriver openIE() {
        driver=new InternetExplorerDriver();
        return driver;
    }
    public static MyIEWebDriver getInstance() {
        if(ie_instance==null) {
            ie_instance=new MyIEWebDriver();
        }
        return ie_instance;
    }
}
