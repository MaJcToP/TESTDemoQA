package Pages.Elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Upload {
    WebDriver wd;

    @FindBy(id = "uploadFile")
    WebElement uploadButton;

    @FindBy(id = "uploadedFilePath")
    WebElement returnTextField;

    public Upload(WebDriver wd) {
        this.wd = wd;
        PageFactory.initElements(wd,this);
    }

    public WebElement getUploadButton() {
        return uploadButton;
    }

    public WebElement getReturnTextField() {
        return returnTextField;
    }
}
