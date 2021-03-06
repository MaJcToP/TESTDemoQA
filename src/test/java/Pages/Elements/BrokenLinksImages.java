package Pages.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BrokenLinksImages {
    WebDriver wd;
    private WebElement brokenLink;
    private List<WebElement> listImages;

    public BrokenLinksImages(WebDriver wd) {
        this.wd = wd;
    }

    public WebElement getBrokenLink() {
        return wd.findElement(By.linkText("Click Here for Broken Link"));
    }

    public List<WebElement> getListImages() {
        return wd.findElements(By.tagName("img"));
    }

}
