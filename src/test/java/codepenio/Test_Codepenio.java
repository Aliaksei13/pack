package test.java.codepenio;

import org.testng.Assert;
import org.testng.annotations.*;
import test.java.codepenio.logic.MainPageLogic;
import test.java.driver.PropertyManager;
import test.java.driver.SingletonWebDriver;

public class Test_Codepenio {
    private SingletonWebDriver singletonWebDriver = SingletonWebDriver.getInstance();
    private MainPageLogic mainPage;
    private PropertyManager propertyManager = new PropertyManager();

    @BeforeClass
    public void setUp(){
        singletonWebDriver.initilize(propertyManager.getPropertyValue("portURL"),
                propertyManager.getPropertyValue("environment"));
        singletonWebDriver.openurl(propertyManager.getPropertyValue("codepenio"));
        mainPage = new MainPageLogic(singletonWebDriver.getDriver());
    }

    @AfterClass
    public void shutDown(){
        singletonWebDriver.quit();
    }

    @Test
    public void checkForecastLink(){
        singletonWebDriver.getDriver().switchTo().frame(mainPage.getFirstAnotherFrame());
        singletonWebDriver.getDriver().switchTo().frame(mainPage.getSecondAnotherFrame());
        Assert.assertEquals(mainPage.getForecast().getText().toLowerCase(), "forecast");
    }
}
