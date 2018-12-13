package pageObjects;

import commons.TestNGConfig;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Random;

public class ComposeNewsPage extends TestNGConfig {
    
    WebDriverWait webDriverWait= new WebDriverWait (driver, 10);
    
    //Locators
    By titleElement= By.id ("txtTitle");
    By firstClassificationElement = By.id ("Classifications_FirstLevel");
    By secondClassificationElement = By.id ("Classifications_SecondLevel");
    By thirdClassificationElement = By.id ("Classifications_ThirdLevel");
    By fourthClassificationElement = By.id ("Classifications_FourthLevel");
    By fifthClassificationElement = By.id ("Classifications_FifthLevel");
    By sixthClassificationElement = By.id ("Classifications_sixthLevel");
    By categoryElement= By.cssSelector("div.chosen-container.chosen-container-multi");
    By categoryOptionsElement= By.xpath("//*[@id=\"Category_chosen\"]/div/ul");
    By eventElement  =By.id("ddlEvent");
    By taskElement = By.id("ddlEventTask");
    By bodyElement= By.id("cke_1_contents");
    By attachmentBtnElement= By.id("btnAttachments");
    By attachmentZoneElement= By.id("dropzoneForm");
    By tasksBtn= By.id("btn-toggle-tasks-list");
    By noteBtn= By.id("btnNotes");
    By noteElement= By.id("Notes");
    By saveBtn= By.id("btnSaveHeader");
    By discardBtn= By.id("btnDiscardHeader");


    public ComposeNewsPage (WebDriver driver){
        this.driver= driver;
    }
    public void fill_Title (String title) {
        webDriverWait.until (ExpectedConditions.visibilityOfElementLocated (titleElement)).sendKeys(title);
    }
    
    public void select_Tag_1 () {
        Select tag1 = new Select (driver.findElement(firstClassificationElement));
        //We used List class to save all the options in the <Select> tag and find it length then select an option randomly
        List<WebElement> tag1Options = tag1.getOptions();
        Random rand = new Random();
        int r = rand.nextInt(tag1Options.size());
        ///////////////////
        tag1.selectByIndex(r);
    }
    
    public  void select_Tag_2 () {
        //The if statement to check if Tag 4 is available since not all tags contain multiple Tag levels
        if (driver.findElement(secondClassificationElement).isDisplayed()) {
            //We used List class to save all the options in the <Select> tag and find it length then select an option randomly
            Select tag2 = new Select (driver.findElement(secondClassificationElement));
            List <WebElement> tag2Options = tag2.getOptions();
            Random rand = new Random();
            int r = rand.nextInt(tag2Options.size());
            /////////////////////
            tag2.selectByIndex(r);
        }
    }
    
    public  void select_tag_3 () {
        //The if statement to check if Tag 4 is available since not all tags contain multiple Tag levels
        if (driver.findElement(thirdClassificationElement).isDisplayed()) {
            Select tag2 = new Select (driver.findElement(thirdClassificationElement));
            //We used List class to save all the options in the <Select> tag and find it length then select an option randomly
            List <WebElement> tag2Options = tag2.getOptions();
            Random rand = new Random();
            int r = rand.nextInt(tag2Options.size());
            /////////////////
            tag2.selectByIndex(r);
        }
    }
    
    public  void select_Tag_4 () {
        //The if statement to check if Tag 4 is available since not all tags contain multiple Tag levels
        if (driver.findElement(fourthClassificationElement).isDisplayed()) {
            Select tag2 = new Select (driver.findElement(fourthClassificationElement));
            //We used List class to save all the options in the <Select> tag and find it length then select an option randomly
            List <WebElement> tag2Options = tag2.getOptions();
            Random rand = new Random();
            int r = rand.nextInt(tag2Options.size());
            /////////////////////////
            tag2.selectByIndex(r);
        }
    }
    
    public  void select_Category () {
        driver.findElement(categoryElement).click();
        //We used List class to save all the options in the <Select> tag and find it length then select an option randomly
        List <WebElement> categoryOptions = driver.findElements(categoryOptionsElement);
        Random rand = new Random();
        int r = rand.nextInt(categoryOptions.size());
        ////////////////////
        categoryOptions.get(r).click();

    }
    
    public  void select_Event () {
        Select Event = new Select (driver.findElement(eventElement));
        //We used List class to save all the options in the <Select> tag and find it length then select an option randomly
        List <WebElement> eventOptions = Event.getOptions();
        Random rand = new Random();
        int r = rand.nextInt(eventOptions.size());
        /////////////////////
        Event.selectByIndex(r);
    }
    
    public  void select_Task () {
        Select Task = new Select (driver.findElement(taskElement));
        //We used List class to save all the options in the <Select> tag and find it length then select an option randomly
        List <WebElement> taskOptions = Task.getOptions();
        if (taskOptions.size()!= 0) {
            Random rand = new Random ();
            int r = rand.nextInt(taskOptions.size());
            /////////////////
            Task.selectByIndex(r);
        }
    }
    
    public  void fill_Body (String body) {
        //We used action class to focus on the Body since its not a normal textbox
        Actions action = new Actions (driver);
        action.moveToElement(driver.findElement(bodyElement));
        action.click();
        action.sendKeys(body);
        action.build().perform();
    }
    
    public  void upload_Attachment (String filePath) throws AWTException {
        //Click on attachment button to display attachment box.
        driver.findElement(attachmentBtnElement).click();
        //click on attachment box to open brows window.
        driver.findElement(attachmentZoneElement).click();;
        //put the path of you file in clipboard.
        StringSelection ss = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
        //Use Robot class to simulate keyboard actions
        Robot robot = new Robot();
        robot.delay(250);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
    }
    
    public  void send_News (String Task){
        //click on send button to open contacts list
        driver.findElement(tasksBtn).click();
        //select the contact by sending its name.
        driver.findElement(By.linkText(Task)).click();
    }
    
    public  void fill_Note(String note){
        //click on Note button to open note text box.
        driver.findElement(noteBtn).click();
        //fill the note by passing note parameter.
        driver.findElement(noteElement).sendKeys(note);
    }
    
    public  void save_News () {
        driver.findElement(saveBtn).click();
    }
    
    public  void discard_News () {
        driver.findElement(discardBtn).click();
    }
    
    public  void selectAll () {
        driver.findElement(By.cssSelector("span.cke_button_icon.cke_button__selectall_icon")).click();
    }
    
    public  void cut () {
        driver.findElement(By.cssSelector("span.cke_button_icon.cke_button__cut_icon")).click();
    }
    
    public  void copy() {
        driver.findElement(By.cssSelector("span.cke_button_icon.cke_button__copy_icon")).click();
    }
    
    public  void paste() throws AWTException{
        //Click on Paste button in Editing bar
        driver.findElement(By.cssSelector("span.cke_button_icon.cke_button__pastetext_icon")).click();

        //Use Robot class to simulate keyboard actions to paste the copied text (CTRL+V)
        Robot robot = new Robot();
        robot.delay(250);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        //Click on OK button
        driver.findElement(By.cssSelector("a.cke_dialog_ui_button.cke_dialog_ui_button_ok")).click();
    }
    
    public  void undo() {
        driver.findElement(By.className("span.cke_button_icon.cke_button__undo_icon")).click();
    }
    
    public  void redo() {
        driver.findElement(By.cssSelector("span.cke_button_icon.cke_button__redo_icon")).click();
    }
    
    public  void find(String findWhat) {
        //click on Find button in Editing bar
        driver.findElement(By.cssSelector("span.cke_button_icon.cke_button__find_icon")).click();
        //fill find textbox with required value
        driver.findElement(By.cssSelector("input.cke_dialog_ui_input_text")).sendKeys(findWhat);
        //click on Find button
        driver.findElement(By.cssSelector("a.cke_dialog_ui_button[title=Find]")).click();
        //Close Find window
        driver.findElement(By.cssSelector("a.cke_dialog_ui_button.cke_dialog_ui_button_cancel[title=Close]")).click();
    }
    
    public  void leftAlign () {
        driver.findElement(By.id("cke_25")).click();
    }
    
    public  void rightAlign () {
        driver.findElement(By.id("cke_26")).click();
    }
    
    public  void insertSeparator () {
        driver.findElement(By.id("cke_29")).click();
    }
    
    public  void replace (String find, String replace) {
        //click on replace button from Editing bar.
        driver.findElement(By.id("cke_21")).click();
        //fill find and replace text fields with required values
        driver.findElement(By.id("cke_76_textInput")).sendKeys(find);
        driver.findElement(By.id("cke_85_textInput")).sendKeys(replace);
        //click on replace all button
        driver.findElement(By.id("cke_91_label")).click();
        //wait until alert window is displayed then accept it
        WebDriverWait wait = new WebDriverWait (driver,10);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
        //close replace window
        driver.findElement(By.cssSelector("a.cke_dialog_ui_button.cke_dialog_ui_button_cancel[title=Close]")).click();
    }
   
    public  void publishToTwitter (String whatToShare) {
        //Click on the switch button to turn publishing on/off
        driver.findElement(By.cssSelector("label.onoffswitch-label[for=TwitterEnable]")).click();
        //Fill the required text to be published
        driver.findElement(By.id("TwitterSummary")).sendKeys(whatToShare);
    }
    
    public  void publishToFacebook (String whatToShare) {
        //Click on the switch button to turn publishing on/off
        driver.findElement(By.cssSelector("label.onoffswitch-label[for=FacebookEnable]")).click();
        //Fill the required text to be published
        driver.findElement(By.id("facebooksummary")).sendKeys(whatToShare);
    }
    
    public  void publishToYoutube (String whatToShare) {
        //Click on the switch button to turn publishing on/off
        driver.findElement(By.cssSelector("label.onoffswitch-label[for=YoutubeEnable")).click();
        //Fill the required text to be published
        driver.findElement(By.id("youtubeSummary")).sendKeys(whatToShare);
    }
    
    public  void publishToInstagram (String whatToShare) {
        //Click on the switch button to turn publishing on/off
        driver.findElement(By.cssSelector("label.onoffswitch-label[for=InstagramEnable")).click();
        //Fill the required text to be published
        driver.findElement(By.id("InstagramSummary")).sendKeys(whatToShare);
    }

}
