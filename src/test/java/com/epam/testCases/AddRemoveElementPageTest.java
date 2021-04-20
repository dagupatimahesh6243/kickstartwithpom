package com.epam.testCases;

import com.epam.base.TestBase;
import com.epam.pages.AddRemoveElementPage;
import com.epam.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddRemoveElementPageTest extends TestBase {
    AddRemoveElementPage addRemoveElementPage;
    HomePage homePage;
    public AddRemoveElementPageTest() {
        super();
    }
    @BeforeClass
    public void setUp() {
        driver=initialization();
        addRemoveElementPage=new AddRemoveElementPage(driver);
        homePage=new HomePage(driver);
        addRemoveElementPage=homePage.clickAddRemoveElement(driver);
    }
    @Test(priority = 1)
    public void displayAddElementTest() {
        boolean display;
        display=addRemoveElementPage.displayAddElement();
        Assert.assertTrue(display,"Add Element Not Displayed");
    }
    @Test(priority = 2)
    public void clickAddElementTest() {
        addRemoveElementPage.clickAddElement();
    }
    @Test(priority = 3)
    public void displayDeleteElement() {
        boolean display;
        display=addRemoveElementPage.displayDeleteElement();
        Assert.assertTrue(display,"Delete Element Not Displayed");
    }
    @Test(priority = 4)
    public void clickDeleteElementTest() {
        addRemoveElementPage.clickDeleteElement();
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
        driver=null;
    }
}
