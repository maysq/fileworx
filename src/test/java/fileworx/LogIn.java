package fileworx;

import commons.TestNGConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.LogInPage;

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
        LogInPage loginpage= new LogInPage (driver);
        loginpage.enterUserName ("mays");
        loginpage.enterPassword ("123");
        loginpage.clickLogin ();
        loginpage.verifySuccessfulLogin ("mays");
}
}
