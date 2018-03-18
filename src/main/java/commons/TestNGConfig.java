package commons;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestNGConfig {

    public static WebDriver driver;
    public static String baseURL= "http://10.0.0.139/sedcowebserver";

    @BeforeTest
    public void setUp(){

        ChromeDriverManager.getInstance ().setup ();
        driver= new ChromeDriver ();
        driver.navigate ().to (baseURL);
        driver.manage ().window ().maximize ();
    }


    @AfterTest
    public void tearDown(){
        driver.quit ();
    }

}
