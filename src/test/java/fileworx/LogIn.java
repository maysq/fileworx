package fileworx;

import commons.TestNGConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogIn extends TestNGConfig{
    WebDriverWait webDriverWait= null;
    //Log in info
    String username= "root";
    String password = "root";
    @BeforeMethod
    public void setUpLogin(){
        webDriverWait= new WebDriverWait (driver, 10);
    }
    @Test
    public void logIn(){
        webDriverWait.until (ExpectedConditions.visibilityOfElementLocated (By.id("txtUserName"))).sendKeys(username);
        webDriverWait.until (ExpectedConditions.visibilityOfElementLocated (By.id("txtPassword"))).sendKeys(password);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated (By.cssSelector ("button.ladda-button.ladda-button-demo.btn.btn-primary[type=submit]"))).click ();

}
}
