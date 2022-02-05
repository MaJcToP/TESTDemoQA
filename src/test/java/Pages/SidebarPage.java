package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SidebarPage{
    WebDriver wd;

    @FindBy(xpath ="//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[1]/span/div")
    WebElement elements;

    @FindBy(xpath = "//*[@id=\"item-0\"]")
    WebElement textBox;

    @FindBy(xpath = "//*[@id=\"item-1\"]")
    WebElement checkBox;

    @FindBy(xpath = "//*[@id=\"item-2\"]")
    WebElement radioButton;

    @FindBy(xpath = "//*[@id=\"item-3\"]")
    WebElement webTables;

    @FindBy(xpath = "//*[@id=\"item-4\"]")
    WebElement buttons;

    @FindBy(xpath = "//*[@id=\"item-5\"]")
    WebElement links;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[2]/span/div")
    WebElement forms;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[3]/span/div")
    WebElement alerts;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[4]/span/div")
    WebElement widgets;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[5]/span/div")
    WebElement interactions;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[6]/span/div")
    WebElement bookStoreApplication;


    public SidebarPage(WebDriver wd) {
        this.wd = wd;
        PageFactory.initElements(wd,this);
    }

    public void clickElements(){
        elements.click();
    }
    public void clickTextBox(){
        JavascriptExecutor jse=(JavascriptExecutor)wd;
        jse.executeScript("arguments[0].scrollIntoView(true);",textBox);
        textBox.click();}
    public void clickCheckBox(){checkBox.click();}
    public void clickRadioButton(){radioButton.click();}
    public void clickWebTables(){webTables.click();}
    public void clickButtons(){
        JavascriptExecutor jse=(JavascriptExecutor)wd;
        jse.executeScript("arguments[0].scrollIntoView(true);",buttons);
        buttons.click();}
    public void clickLinks(){
        JavascriptExecutor jse=(JavascriptExecutor)wd;
        jse.executeScript("arguments[0].scrollIntoView(true);",links);
        links.click();}
}
