package test.java.indiegogo.logic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import test.java.indiegogo.pages.NewsPage;

public class NewsPageLogic extends NewsPage {

    private WebDriver driver;

    public NewsPageLogic(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
