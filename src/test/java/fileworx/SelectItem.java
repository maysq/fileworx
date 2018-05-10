package fileworx;

import com.sun.jndi.toolkit.url.Uri;
import commons.TestNGConfig;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.util.Strings;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.util.*;
import java.util.stream.Collectors;

public class SelectItem extends TestNGConfig {
    WebDriverWait webDriverWait = null;

    @Test
    public void selectItem ( ) throws Exception {
        String itemNum = "1";
        //To get the screen obj number. This is used to get the correct xpath of screen
        String url = driver.getCurrentUrl ( );
        Map mapURL = getQueryMap (url);
        String obj = mapURL.get ("obj").toString ( );
        Thread.sleep (2000);
        WebElement test = driver.findElement (By.xpath ("//*[@id='grid_" + obj + "']/div[3]/table/tbody/tr[" + itemNum + "]"));
        test.click ();
    }
}
