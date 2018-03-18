package commons;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class TestNGConfig {

    public static WebDriver driver;
    public static String baseURL= "http://10.0.0.139/sedcowebserver";
@Parameters ("browser")
    @BeforeTest
    public void setUp(String browser){
switch (browser){
    case "chrome":{
        ChromeDriverManager.getInstance ().setup ();
        driver= new ChromeDriver ();
        break;
    }
    case "firefox":
    {
        FirefoxDriverManager.getInstance ().setup ();
        driver= new FirefoxDriver ();
        break;
    }
    default:{
        ChromeDriverManager.getInstance ().setup ();
        driver= new ChromeDriver ();
    }
}
        driver.navigate ().to (baseURL);
        driver.manage ().window ().maximize ();
    }


    @AfterTest
    public void tearDown(){
        driver.quit ();
    }

}
