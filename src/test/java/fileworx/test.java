package fileworx;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

@Test
public class test {
    public static WebDriver driver;
    public static String baseURL= "http://10.0.0.139/sedcowebserver";
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
}
