package fileworx;

import commons.TestNGConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Home extends TestNGConfig{
    WebDriverWait webDriverWait= null;
    @BeforeMethod
    public void setUpNavigationBar(){
        webDriverWait= new WebDriverWait (driver, 10);
    }

    @Test
    public void click_Logout(){
        webDriverWait.until (ExpectedConditions.visibilityOfElementLocated (By.cssSelector("i.fa.fa-sign-out"))).click ();
    }
    @Test
    public void click_User () {
        webDriverWait.until (ExpectedConditions.visibilityOfElementLocated (By.cssSelector("span.block.m-t-xs"))).click ();

    }
    @Test
    public void click_Preferences () {
       webDriverWait.until (ExpectedConditions.visibilityOfElementLocated (By.xpath ("//*[@id=\"side-menu\"]/li[1]/div/a/span/span[2]/b"))).click ();
       webDriverWait.until (ExpectedConditions.visibilityOfElementLocated (By.xpath ("//*[@id=\"side-menu\"]/li[1]/div/ul/li[1]"))).click ();
    }

    public static void selectModule (String moduleName) {
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
        //Note that find by linkText is case sensitive
        driver.findElement(By.linkText(screenName)).click();
    }

    public static void selectWorkflowScreen (String workflowScreen) {
        driver.findElement(By.xpath("//label[@class='center-block m-t-xs' and contains(text(), '"+workflowScreen+"')]")).click();
    }

    public static void selectAgencyScreen (String agencyScreen) {
        driver.findElement(By.xpath("//label[@class='center-block' and contains(text(), '"+agencyScreen+"')]")).click();
    }


    }
