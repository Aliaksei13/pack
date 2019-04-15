package test.java.quickitcom.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class MainPage {
    @FindBy (how = How.ID, using = "preview")
    private WebElement framePreview;
    @FindBy (how = How.XPATH, using = "//div[@class='file']")
    private WebElement fileButton;
    @FindAll(@FindBy(how = How.XPATH, using = "//div[@class='folder']//div[@class='file']"))
    private List<WebElement> filesIntoFolder;


    public WebElement getFramePreview() {
        return framePreview;
    }

    public WebElement getFileButton() {
        return fileButton;
    }

    public List<WebElement> getFilesIntoFolder() {
        return filesIntoFolder;
    }
}
