package HappyPath;

import Pages.BasePage;
import Pages.SidebarPage;
import com.github.javafaker.Faker;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class TestCases extends BasePage {
    @BeforeClass
    public void setUpPage() {
        wd.navigate().to("https://demoqa.com/");
        wd.manage().window().maximize();
        startPage.clickElements();
    }

    @DataProvider(name = "data text")
    public Object[][] dataProvider(){
        Faker faker=new Faker();
        return new Object[][]
                {{faker.name().firstName()+" "+faker.name().lastName(),faker.internet().emailAddress(),faker.address().streetAddress(),faker.address().secondaryAddress()},
                {faker.name().firstName()+" "+faker.name().lastName(),faker.internet().emailAddress(),faker.address().streetAddress(),faker.address().secondaryAddress()},
                {faker.name().firstName()+" "+faker.name().lastName(),faker.internet().emailAddress(),faker.address().streetAddress(),faker.address().secondaryAddress()}};
    }

    @Test(dataProvider ="data text", priority = 70)
    public void testElementsTextBox(String fullName,String email, String currentAddress,String permanentAddress){
        wd.navigate().refresh();
        sidebarPage.clickTextBox();
        textBox.enterFullName(fullName);
        textBox.enterEmail(email);
        textBox.enterCurrentAddress(currentAddress);
        textBox.enterPermanentAddress(permanentAddress);
        textBox.clickSubmitButton();
        Assert.assertEquals(textBox.getOutputText(),"Name:"+fullName+"\n"+"Email:"+email+"\n"
                +"Current Address :"+currentAddress+"\n"+ "Permananet Address :"+permanentAddress);
    }

    @Test(priority = 60)
    public void testElementsCheckBox() {
        startPage.clickElements();
        sidebarPage.clickCheckBox();
        checkBox.clickOnHomeDropdownButton();
        checkBox.clickOnDownloadsDropdownButton();
        checkBox.clickOnExcelFileButton();
        Assert.assertEquals(checkBox.getResultText(),"You have selected :\n" +
                "excelFile");
    }

    @Test(priority = 50)
    public void testElementsRadioButton(){
        startPage.clickElements();
        sidebarPage.clickRadioButton();
        WebElement radioButton=wd.findElement(By.id("noRadio"));
        Actions action=new Actions(wd);
        action.moveToElement(radioButton).click().perform();
        boolean elementIsPresent=false;
        try {
            elementIsPresent=wd.findElement(By.className("mt-3")).isDisplayed();
        }catch (NoSuchElementException exception){}
        Assert.assertFalse(elementIsPresent);
    }

    @Test(priority = 40)
    public void testElementWebTables() throws IOException {
        int i=0;
        File file=new File("src/test/java/TableData.xlsx");
        FileInputStream fls=new FileInputStream(file);
        XSSFWorkbook wb=new XSSFWorkbook(fls);
        Sheet sheet=wb.getSheet("Sheet1");
        startPage.clickElements();
        sidebarPage.clickWebTables();
        webTables.clickAddButton();
        webTables.enterFirstName(sheet.getRow(i++).getCell(1).getStringCellValue());
        webTables.enterLastName(sheet.getRow(i++).getCell(1).getStringCellValue());
        webTables.enterEmail(sheet.getRow(i++).getCell(1).getStringCellValue());
        webTables.enterAge((int)sheet.getRow(i++).getCell(1).getNumericCellValue());
        webTables.enterSalary((int)sheet.getRow(i++).getCell(1).getNumericCellValue());
        webTables.enterDepartment(sheet.getRow(i++).getCell(1).getStringCellValue());
        webTables.clickSubmitButton();
        Assert.assertTrue(webTables.getTableRow(3).getText().contains("Petrovic"));
    }

    @Test(priority = 30)
    public void testElementButton(){
        startPage.clickElements();
        sidebarPage.clickButtons();
        buttons.doubleClickButton();
        buttons.rightClickButton();
        buttons.clickButton();
        waiter(buttons.doubleClickMessage);
        Assert.assertEquals(buttons.doubleClickMessage.getText(),"You have done a double click");
        waiter(buttons.rightClickMessage);
        Assert.assertEquals(buttons.rightClickMessage.getText(),"You have done a right click");
        waiter(buttons.dynamicClickMessage);
        Assert.assertEquals(buttons.dynamicClickMessage.getText(),"You have done a dynamic click");
    }

    @Test(priority = 20)
    public void testValidLinks() throws InterruptedException {
        sidebarPage.clickLinks();
        links.getHomeLink().click();
        List<String> listOfElements=new ArrayList<String>(wd.getWindowHandles());
        wd.switchTo().window(listOfElements.get(1));
        Assert.assertEquals(wd.getCurrentUrl(),"https://demoqa.com/");
    }

    @Test(priority = 10)
    public void testAPIcallLinks() throws InterruptedException {
        sidebarPage.clickLinks();
        links.getCreatedLink().click();
        Thread.sleep(1000);
        Assert.assertTrue(links.getResponseText().contains(links.getCreatedLink().getText()));
        links.getMovedLink().click();
        Thread.sleep(1000);
        Assert.assertTrue(links.getResponseText().contains(links.getMovedLink().getText()));
        links.getNotFoundLink().click();
        Thread.sleep(1000);
        Assert.assertTrue(links.getResponseText().contains(links.getNotFoundLink().getText()));
    }




}
