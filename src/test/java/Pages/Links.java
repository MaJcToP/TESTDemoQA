package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Links{
    WebDriver wd;
    private WebElement homeLink;
    private WebElement createdLink;
    private WebElement movedLink;
    private WebElement notFoundLink;
    private WebElement linkResponse;

    public Links(WebDriver wd) {
        this.wd = wd;
    }

    public WebElement getHomeLink() {
        return wd.findElement(By.id("simpleLink"));
    }

    public WebElement getCreatedLink() {
        return wd.findElement(By.id("created"));
    }

    public WebElement getMovedLink() {
        return wd.findElement(By.id("moved"));
    }

    public WebElement getNotFoundLink() {
        return wd.findElement(By.id("invalid-url"));
    }

    public WebElement getLinkResponse() {
        WebElement linkResponse = wd.findElement(By.id("linkResponse"));
        JavascriptExecutor jse=(JavascriptExecutor)wd;
        jse.executeScript("arguments[0].scrollIntoView(true);",linkResponse);
        return linkResponse;
    }

    public String getResponseText(){
        return getLinkResponse().getText();
    }
}
