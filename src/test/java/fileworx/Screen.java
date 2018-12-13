package fileworx;

import commons.TestNGConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.util.Strings;

import java.util.Map;

public class Screen extends TestNGConfig {
    WebDriverWait webDriverWait = null;

    public static String getObjID() throws Exception{
        // What this function does is the following
        //Get the current URL of the screen then use the obj from the URL to select items from the screen list in xpath expressions

        //To get the screen obj number. This is used to get the correct xpath of screen
        String url = driver.getCurrentUrl ( );
        Map mapURL = getQueryMap (url);
        String obj = mapURL.get ("obj").toString ( );
        return obj;
    }

    @Test
    public void selectItem ( ) throws Exception {
        // This function is to click on an item in a screen
//Define the order of the item you want to select in "itemNum"
        String itemNum = "1";
        WebElement test = driver.findElement (By.xpath ("//*[@id='grid_" + getObjID () + "']/div[3]/table/tbody/tr[" + itemNum + "]"));
        test.click ();
    }

    @Test
    @Parameters("pageNumber")
    //This function is to go to a page in a screen by selecting its number
    public void selectPage(String pageNumber){
        webDriverWait.until (ExpectedConditions.visibilityOfElementLocated (By.xpath ("//*[@id=\"GoToPage_"+pageNumber+"\"]"))).click ();
    }

    @Test
    //This function is to go to previous screen
    public void previousPage() throws Exception{
        webDriverWait.until (ExpectedConditions.visibilityOfElementLocated (By.xpath ("//*[@id=\"fwxList"+"_"+getObjID ()+"\"]/div[2]/div[3]/ul/li[1]"))).click ();
    }
    @Test
    //This function is to go to next screen
    public void nextPage() throws Exception{
        webDriverWait.until (ExpectedConditions.visibilityOfElementLocated (By.xpath ("//*[@id=\"fwxList_"+getObjID()+"\"]/div[2]/div[3]/ul/li[8]"))).click ();

    }

}
