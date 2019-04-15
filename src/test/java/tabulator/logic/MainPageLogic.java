package test.java.tabulator.logic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import test.java.tabulator.page.MainPage;

public class MainPageLogic extends MainPage {
    private WebDriver driver;

    public MainPageLogic(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
