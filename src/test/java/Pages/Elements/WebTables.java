package Pages.Elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WebTables {
    WebDriver wd;

    @FindBy(className = "rt-tr-group")
    List<WebElement> tableElementList;

    @FindBy(id = "addNewRecordButton")
    WebElement addButton;

    @FindBy(id = "firstName")
    WebElement firstNameTextField;

    @FindBy(id = "lastName")
    WebElement lastNameTextField;

    @FindBy(id = "userEmail")
    WebElement emailTextField;

    @FindBy(id = "age")
    WebElement ageTextField;

    @FindBy(id = "salary")
    WebElement salaryTextField;

    @FindBy(id = "department")
    WebElement departmentTextField;

    @FindBy(id = "submit")
    WebElement submitButton;

    public WebTables(WebDriver wd) {
        this.wd = wd;
        PageFactory.initElements(wd,this);
    }

    public WebElement getTableRow(int rowNumber){
        return tableElementList.get(rowNumber);
    }

    public void clickAddButton(){
        addButton.click();
    }
    public void enterFirstName(String firstName){
        firstNameTextField.clear();
        firstNameTextField.sendKeys(firstName);
    }

    public void enterLastName(String lastName){
        lastNameTextField.clear();
        lastNameTextField.sendKeys(lastName);
    }

    public void enterEmail (String email){
        emailTextField.clear();
        emailTextField.sendKeys(email);
    }

    public void enterAge(int age){
        ageTextField.clear();
        ageTextField.sendKeys(String.valueOf(age));
    }

    public void enterSalary(int salary){
        salaryTextField.clear();
        salaryTextField.sendKeys(String.valueOf(salary));
    }

    public void enterDepartment(String department){
        departmentTextField.clear();
        departmentTextField.sendKeys(department);
    }

    public void clickSubmitButton(){
        submitButton.click();
    }


}
