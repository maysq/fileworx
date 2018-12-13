package fileworx;

import commons.TestNGConfig;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LogInPage;

@Test
public class test extends TestNGConfig{
   // public static WebDriver driver;
    public static String baseURL= "http://10.0.10.71/sedcowebserver";
    String username= "root";
    String password = "root";
    WebDriverWait webDriverWait= null;

    public void test(){
        for (int i = 0; i<5; i++){
        ChromeDriverManager.getInstance ().setup ();
        driver= new ChromeDriver ();
        driver.navigate ().to (baseURL);
        driver.manage ().window ().maximize ();
        webDriverWait= new WebDriverWait (driver, 10);
        webDriverWait.until (ExpectedConditions.visibilityOfElementLocated (By.id("txtUserName"))).sendKeys(username);
        webDriverWait.until (ExpectedConditions.visibilityOfElementLocated (By.id("txtPassword"))).sendKeys(password);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated (By.cssSelector ("button.ladda-button.ladda-button-demo.btn.btn-primary[type=submit]"))).click ();
    }
}

@Test
    public void testLogin(){

        LogInPage login = new LogInPage (driver);
    HomePage home = new HomePage (driver);
        login.enterUserName ("root");
        login.enterPassword ("root");
        login.clickLogin ();
       // home.click_User ();
       // home.click_Preferences ();
        home.selectWorkflowScreen ("Inbox");

}

}
