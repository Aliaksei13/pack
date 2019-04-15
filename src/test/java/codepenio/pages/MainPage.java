package test.java.codepenio.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage {
    @FindBy(how = How.XPATH, using = "//iframe[@id=\"result\"]")
    private WebElement firstAnotherFrame;
    @FindBy(how = How.XPATH, using = "//iframe[@src=\"https://www.weather.gov/\"]")
    private WebElement secondAnotherFrame;
    @FindBy(how = How.XPATH, using = "//a[@href=\"http://weather.gov/forecastmaps\"]")
    private WebElement forecast;

    public WebElement getFirstAnotherFrame() {
        return firstAnotherFrame;
    }

    public WebElement getSecondAnotherFrame() {
        return secondAnotherFrame;
    }

    public WebElement getForecast() {
        return forecast;
    }
}
