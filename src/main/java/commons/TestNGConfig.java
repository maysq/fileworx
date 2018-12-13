package commons;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestNGConfig {

    public static WebDriver driver;
    public static String baseURL= "http://10.0.10.71/sedcowebserver";
@Parameters ("browser")
    @BeforeTest
    public void setUp(String browser){
switch (browser){
    case "ie":
    case "internetexplorer":
    case "internet": {
        // Driver Manager will handle IE executable driver and download from internet
        // This used to keep getting latest version of browsers drivers and no need to include drivers
        // inside your code (help reduce code size)
        InternetExplorerDriverManager.getInstance().arch32().setup();

        DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
        // Ignore Security and protected mode
        capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        // Clear Browser Cache
        capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);

        // Define driver from Internet Explorer driver type
        driver = new InternetExplorerDriver (capabilities);
        break;
    }
    case "chrome":
    case "google chrome":
    case "google": {
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
        default:
            Assert.fail("You provided non-configured browser, just Chrome or IE Please");
}
        driver.navigate ().to (baseURL);
        driver.manage ().window ().maximize ();
    }

    public static Map<String, String> getQueryMap(String query)
    {
        String[] params = query.split("&");
        Map<String, String> map = new HashMap<String, String> ();
        for (String param : params)
        {
            String name = param.split("=")[0];
            String value = param.split("=")[1];
            map.put(name, value);
        }
        return map;
    }

    @AfterMethod
    //take screenshot if method returned failure
    public void takeScreenshot(ITestResult result) {
        String screenshotName= result.getName ().toString ();

        // Take screenshot and store as a file format
        if(ITestResult.FAILURE==result.getStatus()){
            File src = ((TakesScreenshot) driver).getScreenshotAs (OutputType.FILE);
            try {
                // now copy the  screenshot to desired location using copyFile method

                FileUtils.copyFile (src, new File ("./Screenshots/" + screenshotName + System.currentTimeMillis ( ) + ".png"));
            } catch (IOException e)

            {

                System.out.println (e.getMessage ( ));

            }
        }
    }

    @AfterTest
    public void tearDown()
    {
    driver.close ();
    driver.quit ();
    }

}
