package pageObjects;

import commons.TestNGConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HomePage extends TestNGConfig {

    WebDriverWait webDriverWait= new WebDriverWait (driver, 10);

    /* Define the element locators*/
    By logOutBtn= By.cssSelector ("i.fa.fa-sign-out");
    By userBtn= By.cssSelector ("span.text-muted.text-xs.block");
    //By userBtn= By.cssSelector ("span.block.m-t-xs");
    By workflowScreens= By.xpath ("//*[@id=\"page-wrapper\"]/div[3]/div/div/div[1]/div/div/div[1]/h5");
    By composeBtn= By.cssSelector ("i.fa.fa-pencil.fa-lg");

//Constructor
    public HomePage (WebDriver driver){
        this.driver= driver;
    }

    public void click_Logout(){
        webDriverWait.until (ExpectedConditions.visibilityOfElementLocated (logOutBtn)).click ();
    }
    public void click_User () {
        webDriverWait.until (ExpectedConditions.visibilityOfElementLocated (userBtn)).click ();
    }


    public void click_Preferences () {
        //The if statement here is to check the UI language by checking the caption of "My Workflow Screens" section since we used find by linkText which is case sensitive
        if (driver.findElement (workflowScreens).getText().contains("My Workflow Screens")){
            driver.findElement(By.partialLinkText("Preferences")).click();}

        else if (driver.findElement (workflowScreens).getText().contains("Mon flux de travail")) {
            driver.findElement(By.partialLinkText("Préférences")).click();
        }
        else {
            driver.findElement(By.partialLinkText("التفضيلات")).click();
        }
    }

    public static void selectModule (String moduleName) {
        //To use this function, call the function with one word that matches module name
        //Known issue: When the module name has space it will not be executed successfully so as a work around use one word from module name only
        //If you want to open a screen inside an already expanded module, first web driver will click the module
        //so it will be collapsed, Therefore web driver will not be able to locate the screen inside this module.
        //So we found that all Modules are in tag of type <li> and the expanded module will has
        //extra attribute called <class> with value "active" --> <li class="active">.
        //So we will check if Module element has a parent tag with <class="active"> we will pass clicking on it.

        //We locate the side menu element that has all the Modules.
        WebElement sideMenu = driver.findElement(By.id("side-menu"));
        //Then located the selected Module that you want to click inside the side menu element.
        WebElement module = sideMenu.findElement(By.xpath("//span[@class='nav-label' and contains(text(), '"+moduleName+"')]"));
        //Then located the parent of the module element which is tag of type <a>
        WebElement parent = module.findElement(By.xpath(".."));
        //Then locate the parent of <a> tag element which is <li> element
        WebElement parent2 = parent.findElement(By.xpath(".."));
        //check if <li> tag does not has an attribute <class> with the value "active" we will click on it.
        if (!parent2.getAttribute("class").equals("active")) {
            driver.findElement(By.xpath("//span[@class='nav-label' and contains(text(), '"+moduleName+"')]")).click();
        }
    }

    public static void selectScreen (String screenName){
        //To use this function, the screen name should be passed to the function. You have to pass the exact screen name in order to call it successfully.
        //Note that find by linkText is case sensitive
        driver.findElement(By.linkText(screenName)).click();
    }

    public static void selectWorkflowScreen (String workflowScreen) {
        driver.findElement(By.xpath("//label[@class='center-block m-t-xs' and contains(text(), '"+workflowScreen+"')]")).click();
    }

    public static void selectAgencyScreen (String agencyScreen) {
        driver.findElement(By.xpath("//label[@class='center-block' and contains(text(), '"+agencyScreen+"')]")).click();
    }

    @Test
    public void click_Compose () {
        webDriverWait.until (ExpectedConditions.visibilityOfElementLocated (composeBtn)).click();
    }

}
