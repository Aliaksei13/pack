package test.java.indiegogo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage {
    @FindBy(how = How.XPATH, using = "//div[@ng-click=\"nextImage($event)\"]")
    private WebElement nextButton;
    @FindBy(how = How.XPATH, using = "//div[@ng-bind=\"heroContent('message')\"]")
    private WebElement message;
    @FindBy(how = How.XPATH, using = "//a[@aria-label=\"Search button\"]")
    private WebElement searchButton;
    @FindBy(how = How.XPATH, using = "//input[@placeholder=\"Search\"]")
    private WebElement searchField;

    public WebElement getNextButton() {
        return nextButton;
    }

    public WebElement getMessage() {
        return message;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public WebElement getSearchField() {
        return searchField;
    }
}
