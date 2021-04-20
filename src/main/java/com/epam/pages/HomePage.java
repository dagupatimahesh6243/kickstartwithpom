package com.epam.pages;

import com.epam.base.TestBase;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

    @FindBy(xpath = "//li[5]/a")
    WebElement challengingDom;

    @FindBy(xpath = "//li[2]/a")
    WebElement addRemoveElement;
    private static Logger logger= LogManager.getLogger(HomePage.class);

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        logger.info("Page objects Instantiated");
    }
    public boolean displayChallengeDom() {
        boolean display;
        display=challengingDom.isDisplayed();
        return display;
    }
    public boolean displayAddRemove() {
        boolean display;
        display=addRemoveElement.isDisplayed();
        return display;
    }
    public AddRemoveElementPage clickAddRemoveElement(WebDriver driver) {
        addRemoveElement.click();
        logger.info("AddRemoveElement button from Home Page has been clicked");
        return new AddRemoveElementPage(driver);
    }
}
