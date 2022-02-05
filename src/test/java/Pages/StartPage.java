package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StartPage {
    WebDriver wd;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div[1]/div")
    WebElement elements;

    public StartPage(WebDriver wd) {
        this.wd = wd;
        PageFactory.initElements(wd,this);
    }

    public void clickElements(){
        elements.click();
    }
}
