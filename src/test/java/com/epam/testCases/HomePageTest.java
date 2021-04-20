package com.epam.testCases;

import com.epam.base.TestBase;
import com.epam.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {
    HomePage homePage;
    public HomePageTest() {
        super();
    }
    @BeforeClass
    public void setUp() {
        driver=initialization();
        homePage=new HomePage(driver);
    }
    @Test
    public void checkChallengeDom() {
        boolean result;
        result=homePage.displayChallengeDom();
        Assert.assertTrue(result,"Challenge Dom Not Displayed");
    }
    @Test
    public void checkAddRemove() {
        boolean result;
        result=homePage.displayAddRemove();
        Assert.assertTrue(result,"Add Remove Element Not Displayed");
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
        driver=null;
    }
}
