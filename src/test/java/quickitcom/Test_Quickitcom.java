package test.java.quickitcom;

import org.testng.annotations.*;
import test.java.driver.PropertyManager;
import test.java.driver.SingletonWebDriver;
import test.java.quickitcom.logic.MainPageLogic;

import static org.testng.Assert.assertEquals;


public class Test_Quickitcom {
    private SingletonWebDriver singletonWebDriver = SingletonWebDriver.getInstance();
    private MainPageLogic mainPage;
    private PropertyManager propertyManager = new PropertyManager();

    @BeforeClass
    public void setUp(){
        singletonWebDriver.initilize(propertyManager.getPropertyValue("portURL"),
                propertyManager.getPropertyValue("environment"));
        singletonWebDriver.openurl(propertyManager.getPropertyValue("quackitcom"));
        mainPage = new MainPageLogic(singletonWebDriver.getDriver());
    }

    @AfterClass
    public void shutDown(){
        singletonWebDriver.quit();
    }

    @Test
    public void checkNumberOfFilesAfterClckOnButton(){
        singletonWebDriver.getDriver().switchTo().frame(mainPage.getFramePreview());
        int timesOfClick = 10 + (int) (Math.random() * 11);
        mainPage.clickOnFileButton(timesOfClick);
        assertEquals(mainPage.getFilesIntoFolder().size(), timesOfClick);
        System.out.println(timesOfClick);
        singletonWebDriver.getDriver().switchTo().defaultContent();
    }
}

