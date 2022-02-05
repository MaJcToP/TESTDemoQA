package Pages.Elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Buttons {
    WebDriver wd;
    Actions actions;

    @FindBy(className = "btn-primary")
    public List<WebElement> listOfButtons;

    @FindBy(id = "doubleClickMessage")
    public WebElement doubleClickMessage;

    @FindBy(id = "rightClickMessage")
    public WebElement rightClickMessage;

    @FindBy(id = "dynamicClickMessage")
    public WebElement dynamicClickMessage;

    public Buttons(WebDriver wd) {
        this.wd = wd;
        PageFactory.initElements(wd,this);
        actions=new Actions(wd);
    }

    public void doubleClickButton(){
        actions.doubleClick(listOfButtons.get(0)).perform();
    }

    public void rightClickButton(){
        actions.contextClick(listOfButtons.get(1)).perform();
    }

    public void clickButton(){
        actions.click(listOfButtons.get(2)).perform();
    }
}
