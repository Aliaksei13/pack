package test.java.indiegogo.logic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import test.java.indiegogo.pages.ResultPage;

public class ResultPageLogic extends ResultPage {
    private WebDriver driver;

    public ResultPageLogic(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public NewsPageLogic clickOnTheNews() {
        getResultNews().click();
        return new NewsPageLogic(driver);
    }

    public void clickShowMoreButton(){
        getShowMoreButton().click();
    }
}
