package com.epam.pages;

import com.epam.base.TestBase;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddRemoveElementPage extends TestBase {
    @FindBy(xpath = "//div[@class='example']/button")
    WebElement addElementBtn;
    @FindBy(xpath = "//div[@id='elements']/button[last()]")
    WebElement deleteBtn;
    private static Logger logger= LogManager.getLogger(AddRemoveElementPage.class);
    public AddRemoveElementPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        logger.info("Page objects Instantiated");
    }
    public boolean displayAddElement() {
        return addElementBtn.isDisplayed();
    }
    public boolean displayDeleteElement() {
        return deleteBtn.isDisplayed();
    }
    public void clickAddElement() {
        addElementBtn.click();
        logger.info("Add element button from Add Remove Element Page has been clicked");
    }
    public void clickDeleteElement() {
        deleteBtn.click();
        logger.info("Delete button from Add Remove Element Page has been clicked");
    }
}
