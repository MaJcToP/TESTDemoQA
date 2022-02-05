package Pages.Elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckBox {
    WebDriver wd;

    @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/span/button")
    WebElement homeDropdownButton;

    @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[3]/span/button")
    WebElement downloadsDropdownButton;

    @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[3]/ol/li[2]/span/label/span[1]")
    WebElement excelFileButton;

    @FindBy(id = "result")
    WebElement resultTextField;

    public CheckBox(WebDriver wd) {
        this.wd = wd;
        PageFactory.initElements(wd,this);
    }

    public void clickOnHomeDropdownButton(){
        homeDropdownButton.click();
    }

    public void clickOnDownloadsDropdownButton(){
        downloadsDropdownButton.click();
    }

    public void clickOnExcelFileButton(){
        excelFileButton.click();
    }

    public String getResultText(){
        return resultTextField.getText();
    }

}
