package Pages.Elements;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TextBox {
    WebDriver wd;

    @FindBy(id = "userName")
    WebElement fullNameTextField;

    @FindBy(id = "userEmail")
    WebElement emailTextField;

    @FindBy(id="currentAddress")
    WebElement currentAddressTextField;

    @FindBy(id = "permanentAddress")
    WebElement permanentAddressTextField;

    @FindBy(id ="submit")
    WebElement submitButton;

    @FindBy(xpath = "//*[@id=\"output\"]/div")
    WebElement outputText;


    public TextBox(WebDriver wd) {
        this.wd = wd;
        PageFactory.initElements(wd,this);
    }

    public void enterFullName(String fullName){
        fullNameTextField.clear();
        fullNameTextField.sendKeys(fullName);
    }

    public void enterEmail(String email){
        emailTextField.clear();
        emailTextField.sendKeys(email);
    }

    public void enterCurrentAddress(String currentAdress){
        currentAddressTextField.clear();
        currentAddressTextField.sendKeys(currentAdress);
    }

    public void enterPermanentAddress(String permanentAdress){
        permanentAddressTextField.clear();
        permanentAddressTextField.sendKeys(permanentAdress);
    }

    public void clickSubmitButton(){
        JavascriptExecutor jse=(JavascriptExecutor)wd;
        jse.executeScript("arguments[0].scrollIntoView(true);",submitButton);
        submitButton.click();
    }

    public String getOutputText(){
        return outputText.getText();
    }





}
