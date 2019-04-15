package test.java.indiegogo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class NewsPage {

    @FindBy (how = How.XPATH, using = "//strong[text()=\"WE ARE SHIPPING NOW!\"]")
    private WebElement textIntoNews;

    public WebElement getTextIntoNews() {
        return textIntoNews;
    }
}
