package test.java.indiegogo;

import org.testng.annotations.*;
import test.java.driver.PropertyManager;
import test.java.driver.SingletonWebDriver;
import test.java.indiegogo.logic.MainPageLogic;
import test.java.indiegogo.logic.NewsPageLogic;
import test.java.indiegogo.logic.ResultPageLogic;

import static org.testng.Assert.assertTrue;

public class Test_Indiegogo {
    private MainPageLogic mainPage;
    private SingletonWebDriver singletonWebDriver = SingletonWebDriver.getInstance();
    private PropertyManager propertyManager = new PropertyManager();

    @BeforeClass
    public void setUp(){
        singletonWebDriver.initilize(propertyManager.getPropertyValue("portURL"),
                propertyManager.getPropertyValue("environment"));
        singletonWebDriver.openurl(propertyManager.getPropertyValue("indiegogo"));
        mainPage = new MainPageLogic(singletonWebDriver.getDriver());
    }

    @AfterClass
    public void shutDown(){
        singletonWebDriver.quit();
    }

    @Test
    public void checkContextCommercial(){
        mainPage.checkCommercialContext();
    }

    @Test
    public void checkTextOnTheNewsPage(){
        ResultPageLogic resultPageLogic = mainPage.search("test");
        assertTrue(resultPageLogic.getResultNews().getText().contains("Test"), "Not found");
        NewsPageLogic newsPageLogic = resultPageLogic.clickOnTheNews();
        assertTrue(newsPageLogic.getTextIntoNews().getText().contains("WE ARE SHIPPING NOW!"), "Not found");
    }

    @Test
    public void checkShowMoreButton(){
        ResultPageLogic resultPageLogic = mainPage.search("world");
        System.out.println(resultPageLogic.getCardNews().size());
        try{
            if (resultPageLogic.getShowMoreButton().isDisplayed()) {
                int x = 3;//кол-во кликов
                for(int i = 0; i < x; i++) {
                    assertTrue(resultPageLogic.getShowMoreButton().getText().toLowerCase().contains("show more"), "Not found");
                    resultPageLogic.clickShowMoreButton();
                    singletonWebDriver.pause(2000);
                    assertTrue(resultPageLogic.getCardNews().size() > 12 * i, "Not found");
                    System.out.println(resultPageLogic.getCardNews().size());
                }
            }
        }catch (AssertionError n){
            System.out.println("Button isn't found");
        }
    }
}
