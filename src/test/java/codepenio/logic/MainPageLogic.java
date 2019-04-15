package test.java.codepenio.logic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import test.java.codepenio.pages.MainPage;

public class MainPageLogic extends MainPage {
    private WebDriver driver;

    public MainPageLogic(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
