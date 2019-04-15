package test.java.quickitcom.logic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import test.java.quickitcom.pages.MainPage;

public class MainPageLogic extends MainPage {

    private WebDriver driver;

    public MainPageLogic(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnFileButton(int times) {
        for (int i = 0; i < times; i++) {
            getFileButton().click();
        }
    }
}
