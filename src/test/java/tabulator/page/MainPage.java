package test.java.tabulator.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage {
    @FindBy (how = How.ID, using = "ajax-trigger")
    private WebElement loadDataViaAjaxButton;

    @FindBy(how = How.XPATH, using = "//div[@id='example-table-ajax']//div[text()='Brendon Philips']")
    private WebElement valueInTheTable;

    public WebElement getLoadDataViaAjaxButton() {
        return loadDataViaAjaxButton;
    }

    public WebElement getValueInTheTable() {
        return valueInTheTable;
    }
}
