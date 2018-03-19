package fileworx;

import commons.TestNGConfig;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Random;

public class ComposeNews extends TestNGConfig{
    WebDriverWait webDriverWait= null;
    @BeforeMethod
    public void setUpComposeNews(){
        webDriverWait= new WebDriverWait (driver, 10);
    }
    @Test
    public void click_Compose () {
        webDriverWait.until (ExpectedConditions.visibilityOfElementLocated (By.cssSelector("i.fa.fa-pencil.fa-lg"))).click();
    }
    @Test
    public void fill_Title (String title) {
        webDriverWait.until (ExpectedConditions.visibilityOfElementLocated (By.id("txtTitle"))).sendKeys(title);
    }
    @Test
    public void select_Tag_1 () {
        Select tag1 = new Select (driver.findElement(By.id("Classifications_FirstLevel")));
        //We used List class to save all the options in the <Select> tag and find it length then select an option randomly
        List<WebElement> tag1Options = tag1.getOptions();
        Random rand = new Random();
        int r = rand.nextInt(tag1Options.size());
        ///////////////////
        tag1.selectByIndex(r);
    }
    @Test
    public static void select_Tag_2 () {
        //The if statement to check if Tag 4 is available since not all tags contain multiple Tag levels
        if (driver.findElement(By.id("Classifications_SecondLevel")).isDisplayed()) {
            //We used List class to save all the options in the <Select> tag and find it length then select an option randomly
            Select tag2 = new Select (driver.findElement(By.id("Classifications_SecondLevel")));
            List <WebElement> tag2Options = tag2.getOptions();
            Random rand = new Random();
            int r = rand.nextInt(tag2Options.size());
            /////////////////////
            tag2.selectByIndex(r);
        }
    }
    @Test
    public static void select_tag_3 () {
        //The if statement to check if Tag 4 is available since not all tags contain multiple Tag levels
        if (driver.findElement(By.id("Classifications_ThirdLevel")).isDisplayed()) {
            Select tag2 = new Select (driver.findElement(By.id("Classifications_ThirdLevel")));
            //We used List class to save all the options in the <Select> tag and find it length then select an option randomly
            List <WebElement> tag2Options = tag2.getOptions();
            Random rand = new Random();
            int r = rand.nextInt(tag2Options.size());
            /////////////////
            tag2.selectByIndex(r);
        }
    }
    @Test
    public static void select_Tag_4 () {
        //The if statement to check if Tag 4 is available since not all tags contain multiple Tag levels
        if (driver.findElement(By.id("Classifications_FourthLevel")).isDisplayed()) {
            Select tag2 = new Select (driver.findElement(By.id("Classifications_FourthLevel")));
            //We used List class to save all the options in the <Select> tag and find it length then select an option randomly
            List <WebElement> tag2Options = tag2.getOptions();
            Random rand = new Random();
            int r = rand.nextInt(tag2Options.size());
            /////////////////////////
            tag2.selectByIndex(r);
        }
    }
    @Test
    public static void select_Category () {
        driver.findElement(By.cssSelector("div.chosen-container.chosen-container-multi")).click();
        //We used List class to save all the options in the <Select> tag and find it length then select an option randomly
        List <WebElement> categoryOptions = driver.findElements(By.xpath("//*[@id=\"Category_chosen\"]/div/ul"));
        Random rand = new Random();
        int r = rand.nextInt(categoryOptions.size());
        ////////////////////
        categoryOptions.get(r).click();

    }
    @Test
    public static void select_Event () {
        Select Event = new Select (driver.findElement(By.id("ddlEvent")));
        //We used List class to save all the options in the <Select> tag and find it length then select an option randomly
        List <WebElement> eventOptions = Event.getOptions();
        Random rand = new Random();
        int r = rand.nextInt(eventOptions.size());
        /////////////////////
        Event.selectByIndex(r);
    }
    @Test
    public static void select_Task () {
        Select Task = new Select (driver.findElement(By.id("ddlEventTask")));
        //We used List class to save all the options in the <Select> tag and find it length then select an option randomly
        List <WebElement> taskOptions = Task.getOptions();
        if (taskOptions.size()!= 0) {
            Random rand = new Random ();
            int r = rand.nextInt(taskOptions.size());
            /////////////////
            Task.selectByIndex(r);
        }
    }
    @Test
    public static void fill_Body (String body) {
        //We used action class to focus on the Body since its not a normal textbox
        Actions action = new Actions (driver);
        action.moveToElement(driver.findElement(By.id("cke_1_contents")));
        action.click();
        action.sendKeys(body);
        action.build().perform();
    }
    @Test
    public static void upload_Attachment (String filePath) throws AWTException{
        //Click on attachment button to display attachment box.
        driver.findElement(By.id("btnAttachments")).click();
        //click on attachment box to open brows window.
        driver.findElement(By.id("dropzoneForm")).click();;

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
    @Test
    public static void send_News (String Contact){
        //click on send button to open contacts list
        driver.findElement(By.id("btn-toggle-tasks-list")).click();
        //select the contact by sending its name.
        driver.findElement(By.linkText(Contact)).click();
    }
    @Test
    public static void fill_Note(String note){
        //click on Note button to open note text box.
        driver.findElement(By.id("btnNotes")).click();
        //fill the note by passing note parameter.
        driver.findElement(By.id("Notes")).sendKeys(note);
    }
    @Test
    public static void save_News () {
        driver.findElement(By.id("btnSaveHeader")).click();
    }
    @Test
    public static void discard_News () {
        driver.findElement(By.id("btnDiscardHeader")).click();
    }
    @Test
    public static void selectAll () {
        driver.findElement(By.cssSelector("span.cke_button_icon.cke_button__selectall_icon")).click();
    }
    @Test
    public static void cut () {
        driver.findElement(By.cssSelector("span.cke_button_icon.cke_button__cut_icon")).click();
    }
    @Test
    public static void copy() {
        driver.findElement(By.cssSelector("span.cke_button_icon.cke_button__copy_icon")).click();
    }
    @Test
    public static void paste() throws AWTException{
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
    @Test
    public static void undo() {
        driver.findElement(By.className("span.cke_button_icon.cke_button__undo_icon")).click();
    }
    @Test
    public static void redo() {
        driver.findElement(By.cssSelector("span.cke_button_icon.cke_button__redo_icon")).click();
    }
    @Test
    public static void find(String findWhat) {
        //click on Find button in Editing bar
        driver.findElement(By.cssSelector("span.cke_button_icon.cke_button__find_icon")).click();
        //fill find textbox with required value
        driver.findElement(By.cssSelector("input.cke_dialog_ui_input_text")).sendKeys(findWhat);
        //click on Find button
        driver.findElement(By.cssSelector("a.cke_dialog_ui_button[title=Find]")).click();
        //Close Find window
        driver.findElement(By.cssSelector("a.cke_dialog_ui_button.cke_dialog_ui_button_cancel[title=Close]")).click();
    }
    @Test
    public static void leftAlign () {
        driver.findElement(By.id("cke_25")).click();
    }
    @Test
    public static void rightAlign () {
        driver.findElement(By.id("cke_26")).click();
    }
    @Test
    public static void insertSeparator () {
        driver.findElement(By.id("cke_29")).click();
    }
    @Test
    public static void replace (String find, String replace) {
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
    @Test
    public static void publishToTwitter (String whatToShare) {
        //Click on the switch button to turn publishing on/off
        driver.findElement(By.cssSelector("label.onoffswitch-label[for=TwitterEnable]")).click();
        //Fill the required text to be published
        driver.findElement(By.id("TwitterSummary")).sendKeys(whatToShare);
    }
    @Test
    public static void publishToFacebook (String whatToShare) {
        //Click on the switch button to turn publishing on/off
        driver.findElement(By.cssSelector("label.onoffswitch-label[for=FacebookEnable]")).click();
        //Fill the required text to be published
        driver.findElement(By.id("facebooksummary")).sendKeys(whatToShare);
    }
    @Test
    public static void publishToYoutube (String whatToShare) {
        //Click on the switch button to turn publishing on/off
        driver.findElement(By.cssSelector("label.onoffswitch-label[for=YoutubeEnable")).click();
        //Fill the required text to be published
        driver.findElement(By.id("youtubeSummary")).sendKeys(whatToShare);
    }
@Test
    public static void publishToInstagram (String whatToShare) {
        //Click on the switch button to turn publishing on/off
        driver.findElement(By.cssSelector("label.onoffswitch-label[for=InstagramEnable")).click();
        //Fill the required text to be published
        driver.findElement(By.id("InstagramSummary")).sendKeys(whatToShare);
    }

}
