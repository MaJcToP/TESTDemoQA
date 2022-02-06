package Pages;

import Pages.Elements.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

public class BasePage {
    public WebDriver wd;
    public WebDriverWait wdw;
    public JavascriptExecutor jse;
    public StartPage startPage;
    public SidebarPage sidebarPage;
    public TextBox textBox;
    public CheckBox checkBox;
    public WebTables webTables;
    public Buttons buttons;
    public Links links;
    public BrokenLinksImages brokenLinksImages;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        wd=new ChromeDriver();
        wdw=new WebDriverWait(wd, Duration.ofSeconds(10));
        jse=(JavascriptExecutor)wd;
        startPage=new StartPage(wd);
        sidebarPage=new SidebarPage(wd);
        textBox=new TextBox(wd);
        checkBox=new CheckBox(wd);
        webTables=new WebTables(wd);
        buttons=new Buttons(wd);
        links=new Links(wd);
        brokenLinksImages=new BrokenLinksImages(wd);

    }
    @AfterClass
    public void tearDown(){
        wd.manage().deleteAllCookies();
        wd.close();
        wd.quit();
    }

    @AfterSuite
    public void taskKill() throws IOException {
        Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
    }

    public void waiter(WebElement element){wdw.until(ExpectedConditions.visibilityOf(element));}

    public void scrollIntoView(WebElement element){jse.executeScript("arguments[0].scrollIntoView(true);",element);}

}
