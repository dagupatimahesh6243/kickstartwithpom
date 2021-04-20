package com.epam.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyChromeWebDriver {
    private WebDriver driver;
    private static MyChromeWebDriver chrome_instance=null;
    private MyChromeWebDriver() {
        try {
            System.setProperty("webdriver.chrome.driver", "WebDrivers/chromedriver.exe");
        } catch(IllegalStateException e) {
            System.out.println("Web Driver Not found in given path");
        }
    }
    public WebDriver openChrome() {
        driver=new ChromeDriver();
        return driver;
    }
    public static MyChromeWebDriver getInstance() {
        if(chrome_instance==null) {
            chrome_instance=new MyChromeWebDriver();
        }
        return chrome_instance;

    }
}
