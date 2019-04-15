package test.java.indiegogo.logic;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import test.java.indiegogo.pages.MainPage;

import static org.testng.Assert.assertEquals;

public class MainPageLogic extends MainPage {
    private WebDriver driver;

    public MainPageLogic(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void checkCommercialContext() {
        getNextButton().click();
        assertEquals(getMessage().getText(),
                "The MoGo Pro is the award-winning portable projector by XGIMI",
                "Not Found");
        getNextButton().click();
        assertEquals(getMessage().getText(),
                "Microdrone 4.0 is a palm sized drone that captures smooth aerial video",
                "Not Found");
        getNextButton().click();
        assertEquals(getMessage().getText(),
                "SDREAM has GPS and the most streamlined design",
                "Not Found");
    }

    public ResultPageLogic search(String text) {
        getSearchButton().click();
        getSearchField().sendKeys(text);
        getSearchField().sendKeys(Keys.ENTER);
        return new ResultPageLogic(driver);
    }
}
