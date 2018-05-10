package fileworx;

import commons.ReadFile;
import commons.TestNGConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Random;

public class Events extends TestNGConfig {
    String propertiesFile;
    WebDriverWait webDriverWait= null;
    @Parameters ("propFile")
    @BeforeMethod
    public void setUpEvents(String propFile){
        webDriverWait= new WebDriverWait (driver, 10);
        propertiesFile= propFile;
    }

    @Test
    public void createNewEvent(){
        webDriverWait.until (ExpectedConditions.visibilityOfElementLocated (By.xpath ("//*[@id=\"side-menu\"]/li[7]/a/span[1]" ))).click ();
        webDriverWait.until (ExpectedConditions.visibilityOfElementLocated (By.xpath ("//*[@id=\"side-menu\"]/li[7]/ul/li[3]/a" ))).click ();
        webDriverWait.until (ExpectedConditions.visibilityOfElementLocated (By.xpath ("//*[@id=\"page-wrapper\"]/div[3]/div/div/div/div/div[1]/div/div/button" ))).click ();
        webDriverWait.until (ExpectedConditions.visibilityOfElementLocated (By.xpath ("//*[@id=\"page-wrapper\"]/div[3]/div/div/div/div/div[1]/div/div/ul/li/a" ))).click ();

    }
    
    @Test
        public void fillName(){
        String englishName= ReadFile.readProperty (propertiesFile,"eventEnglishName");
        String arabicName= ReadFile.readProperty (propertiesFile,"eventArabicName");
        String frenchName= ReadFile.readProperty (propertiesFile,"eventFrenchName");

        webDriverWait.until (ExpectedConditions.visibilityOfElementLocated (By.id ("MLNamesList_0__LangugeName" ))).sendKeys (englishName);
        webDriverWait.until (ExpectedConditions.visibilityOfElementLocated (By.id ("MLNamesList_1__LangugeName" ))).sendKeys (arabicName);
        webDriverWait.until (ExpectedConditions.visibilityOfElementLocated (By.id ("MLNamesList_2__LangugeName" ))).sendKeys (frenchName);

}
@Test
public void clickCreateEvent(){
    webDriverWait.until (ExpectedConditions.visibilityOfElementLocated (By.id("Create"))).click ();
}
@Test
    public void fillDescription(){
        String description = ReadFile.readProperty (propertiesFile, "description");
        webDriverWait.until (ExpectedConditions.visibilityOfElementLocated (By.id ("Description"))).sendKeys (description);
}

@Test
    public void fillSubject(){
        String subject = ReadFile.readProperty (propertiesFile, "subject");
    webDriverWait.until (ExpectedConditions.visibilityOfElementLocated (By.id ("Subject"))).sendKeys (subject);
}

@Test
    public void fillKeywords(){
        String keywords = ReadFile.readProperty (propertiesFile, "keywords");
    webDriverWait.until (ExpectedConditions.visibilityOfElementLocated (By.id ("Keywords"))).sendKeys (keywords);
}
@Test
public void selectPriority(){
    Random random= new Random ();
    Select priorityLevel = new Select (driver.findElement (By.id ("ddlPriority")));
    //Select a priority level randomly
     priorityLevel.selectByIndex (random.nextInt (4));

     //String priority= ReadFile.readProperty (propertiesFile, "priority");
   // priorityLevel.selectByValue (priority);
   /* switch (priority){
        case "Top Urgent":
            break;
        case "Urgent":
            break;
        case "Normal":
            break;
        case "Low Priority":
            break;
        case "Least Priority":
            break;
            default:

    }*/


}

@Test
    public void selectOccurStatus(){
    Random random= new Random ();
    Select occurLevel = new Select (driver.findElement (By.id ("ddlOccurStatus")));
    //Select occur status randomly
   occurLevel.selectByIndex (random.nextInt (5));
   /*String occur= ReadFile.readProperty (propertiesFile, "occurStatus");
    occurLevel.selectByValue(occur);*/
}
@Test
    public void selectStatus(){
    Random random= new Random ();
    Select statusLevel = new Select (driver.findElement (By.id ("ddlOccurStatus")));
    //Select a status randomly
    statusLevel.selectByIndex (random.nextInt (3));
   /* String status= ReadFile.readProperty (propertiesFile, "status");
    statusLevel.selectByValue (status);*/
}
@Test
    public void fillNotes(){
    String notes = ReadFile.readProperty (propertiesFile, "notes");
    webDriverWait.until (ExpectedConditions.visibilityOfElementLocated (By.id ("Keywords"))).sendKeys (notes);
}
@Test
    public void selectMemberCountries(){
    Random random= new Random ();
    Select hostCountry = new Select (driver.findElement (By.id ("MemberCountries")));
    //Select a member country randomly
    hostCountry.selectByIndex (random.nextInt (100));
}

@Test
    public void selectHostCountry(){
    Random random= new Random ();
    Select hostCountry = new Select (driver.findElement (By.id ("ddlHostCountry")));
    //Select a host country randomly
    hostCountry.selectByIndex (random.nextInt (100));

}

@Test
    public void fillCity(){
    String city = ReadFile.readProperty (propertiesFile, "city");
    webDriverWait.until (ExpectedConditions.visibilityOfElementLocated (By.id ("City"))).sendKeys (city);
}
@Test
    public void fillPostalCode(){
    String postal = ReadFile.readProperty (propertiesFile, "postalCode");
    webDriverWait.until (ExpectedConditions.visibilityOfElementLocated (By.id ("PostalCode"))).sendKeys (postal);
}
@Test
    public void fillRegion(){
    String region = ReadFile.readProperty (propertiesFile, "region");
    webDriverWait.until (ExpectedConditions.visibilityOfElementLocated (By.id ("Region"))).sendKeys (region);
}
@Test
    public void fillAddress1(){
    String address1 = ReadFile.readProperty (propertiesFile, "address1");
    webDriverWait.until (ExpectedConditions.visibilityOfElementLocated (By.id ("Adress1"))).sendKeys (address1);
}

    @Test
    public void fillAddress2(){
        String address2 = ReadFile.readProperty (propertiesFile, "address2");
        webDriverWait.until (ExpectedConditions.visibilityOfElementLocated (By.id ("Adress2"))).sendKeys (address2);
    }
}
