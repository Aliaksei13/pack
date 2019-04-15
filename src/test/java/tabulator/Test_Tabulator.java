package test.java.tabulator;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import test.java.driver.PropertyManager;
import test.java.driver.SingletonWebDriver;
import test.java.tabulator.logic.MainPageLogic;

public class Test_Tabulator {
    private SingletonWebDriver singletonWebDriver = SingletonWebDriver.getInstance();
    private MainPageLogic mainPage;
    private PropertyManager propertyManager = new PropertyManager();

    @BeforeClass
    public void setUp(){
        singletonWebDriver.initilize(propertyManager.getPropertyValue("portURL"),
                propertyManager.getPropertyValue("environment"));
        singletonWebDriver.openurl(propertyManager.getPropertyValue("tabulator"));
        mainPage = new MainPageLogic(singletonWebDriver.getDriver());
    }

    @AfterClass
    public void shutDown(){
        singletonWebDriver.quit();
    }


    @Test
    public void checkValueInTheTable(){
        mainPage.getLoadDataViaAjaxButton().click();
        String name = "Brendon Philips";
        WebDriverWait wait = new WebDriverWait(singletonWebDriver.getDriver(), 30);
        wait.until(ExpectedConditions.visibilityOf(mainPage.getValueInTheTable()));
        Assert.assertEquals(mainPage.getValueInTheTable().getText(), name);
    }
}
