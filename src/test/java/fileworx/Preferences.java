package fileworx;

import commons.TestNGConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class Preferences extends TestNGConfig{
    @Test
    public static void changeLanguage (String language) {
        Select languageList = new Select(driver.findElement(By.id("LanguageID")));
        switch (language) {
            case "English":
            case "english":
                languageList.selectByIndex(0);
                break;
            case "Arabic" :
            case "arabic":
            case"عربي":
                languageList.selectByIndex(1);
                break;

            case "French":
            case "french":
            case "Français":
                languageList.selectByIndex(2);
                break;

        }
    }
@Test
    public static void changeDefaultHomePage () {
        Select HomePage = new Select(driver.findElement(By.id("DefaultHomePage")));
        WebElement options = HomePage.getFirstSelectedOption();
        if(options.getAttribute("value").equals("0")) {
            HomePage.selectByIndex(1);
        }
        else {
            HomePage.selectByIndex(0);
        }
    }
    @Test
    public static void changeEditorialHomeScreen () {
        Select screens = new Select (driver.findElement(By.id("WebPreferredScreenID")));
        List<WebElement> screensOptions = screens.getOptions();
        Random rand = new Random();
        int r = rand.nextInt(screensOptions.size());
        screens.selectByIndex(r);
    }
    @Test
    public static void changeMobileHomeScreen () {
        Select screens = new Select (driver.findElement(By.id("PreferredScreenID")));
        List<WebElement> screensOptions = screens.getOptions();
        Random rand = new Random();
        int r = rand.nextInt(screensOptions.size());
        screens.selectByIndex(r);
    }
    @Test
    public static void changeListFontSize () {
        Select screens = new Select (driver.findElement(By.id("lsListFontSize")));
        List<WebElement> screensOptions = screens.getOptions();
        Random rand = new Random();
        int r = rand.nextInt(screensOptions.size());
        screens.selectByIndex(r);
    }
    @Test
    public static void changeEditorFontSize () {
        Select screens = new Select (driver.findElement(By.id("lsNewsFontSize")));
        List<WebElement> screensOptions = screens.getOptions();
        Random rand = new Random();
        int r = rand.nextInt(screensOptions.size());
        screens.selectByIndex(r);
    }
    @Test
    public static void changeDateFormat (String format, String customDate) {
        Select dateFormat = new Select (driver.findElement(By.id("lsDateTimeFormat")));
        switch (format) {
            case "Long Date" :
            case "long date":
            case "تاريخ طويل":
                dateFormat.selectByIndex(0);
                break;
            case "Short Date" :
            case "short date":
            case "تاريخ قصير":
                dateFormat.selectByIndex(1);
                break;

            case "Time":
            case "time":
            case "وقت":
                dateFormat.selectByIndex(2);
                break;

            case"Custom":
            case"custom":
            case "تخصيص":
                dateFormat.selectByIndex(3);
                driver.findElement(By.id("txtCustomDateTime")).clear();
                driver.findElement(By.id("txtCustomDateTime")).sendKeys(customDate);
                break;
        }
    }
    @Test
    public static void changeCalendarType (String calendar) {
        Select calendarTypes = new Select(driver.findElement(By.id("lsCalendarType")));
        switch (calendar) {
            case "Hijri":
            case "hijri":
            case "هجري":
                calendarTypes.selectByIndex(0);
                break;
            case "Gregorian":
            case "gregorian":
            case "ميلادي":
                calendarTypes.selectByIndex(1);
                break;

            case "SystemDefault":
            case "System Default":
            case "system default":
            case "systemdefault":
            case "حسب النظام":
                calendarTypes.selectByIndex(2);
                break;

        }
    }
    @Test
    public static void changeUsername (String newUsername) {
        driver.findElement(By.id("UserName")).clear();
        driver.findElement(By.id("UserName")).sendKeys(newUsername);
    }
    @Test
    public static void changeEmail (String email) {
        driver.findElement(By.id("Email")).clear();
        driver.findElement(By.id("Email")).sendKeys(email);
    }
    @Test
    public static void changeMobile (String mobileNumber) {
        driver.findElement(By.id("Mobile")).clear();
        driver.findElement(By.id("Mobile")).sendKeys(mobileNumber);
    }
    @Test
    public static void changePassword (String currentPassword, String newPassword, String confirmNewPassword) {
        driver.findElement(By.id("Password")).sendKeys(currentPassword);
        driver.findElement(By.id("NewPassword")).sendKeys(newPassword);
        driver.findElement(By.id("ConfirmingPassword")).sendKeys(confirmNewPassword);
    }
    @Test
    public static void cancelPreferences () {
        driver.findElement(By.cssSelector("button.btn.btn-white")).click();
    }
    @Test
    public static void savePreferences () {
        driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
    }

}
