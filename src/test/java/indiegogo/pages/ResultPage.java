package test.java.indiegogo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class ResultPage {
    @FindBy(how = How.XPATH, using = "//div[text()=\"EyeQue VisionCheck, World's 1st Automated Eye Test\"]")
    private WebElement resultNews;
    @FindBy(how = How.XPATH, using = "//a[@ga-event-action=\"Show More\"]")
    private WebElement showMoreButton;
    @FindAll(@FindBy (how = How.XPATH, using = "//div[@class=\"discoverableCard\"]"))
    private List<WebElement> cardNews;

    public WebElement getResultNews() {
        return resultNews;
    }

    public WebElement getShowMoreButton() {
        return showMoreButton;
    }

    public List<WebElement> getCardNews() {
        return cardNews;
    }
}
