package pageObjects;

import commons.TestNGConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogIn extends TestNGConfig {

    WebDriverWait webDriverWait= new WebDriverWait (driver, 10);;

    /* Define the element locators*/
    public static By usrnameTxt= By.id("txtUserName");
    public static By passwordTxt= By.id("txtPassword");
    public static By logInBtn= By.cssSelector ("button.ladda-button.ladda-button-demo.btn.btn-primary[type=submit]");
    //Log in info

    public LogIn(WebDriver driver){

        this.driver=driver;

    }


    public void enterUserName(String username){
        webDriverWait.until (ExpectedConditions.visibilityOfElementLocated (usrnameTxt)).sendKeys(username);
}
    public void enterPassword(String password) {
        webDriverWait.until (ExpectedConditions.visibilityOfElementLocated (passwordTxt)).sendKeys(password);
    }
    public void clickLogin(){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated (logInBtn)).click ();
    }

    public void loginOperation(){
        webDriverWait.until (ExpectedConditions.visibilityOfElementLocated (By.id("txtUserName"))).sendKeys("root");
        webDriverWait.until (ExpectedConditions.visibilityOfElementLocated (passwordTxt)).sendKeys("root");
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated (logInBtn)).click ();
    }

}
