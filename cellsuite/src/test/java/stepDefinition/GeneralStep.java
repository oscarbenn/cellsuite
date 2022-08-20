package stepDefinition;
import static org.junit.Assert.*;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.DriverFactory;
import factory.Function;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class GeneralStep {

    WebDriver driver = DriverFactory.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    @When("user refresh the browser page")
    public void user_refresh_the_browser_page() {
        driver.navigate().refresh();        
    }

    @Then("user is navigated to {string} page")
    public void user_is_navigated_to_page(String pageTitle) {
        WebElement element = driver.findElement(By.xpath("//div/div/div/span[contains(@class,'title')]")); //div[@class='ant-page-header-heading']/child::div/child::span
        wait.until(ExpectedConditions.visibilityOf(element));
        if (pageTitle.equalsIgnoreCase("Dashboard")) {
            assertEquals("Cellmatic Suite", element.getText());
        } else {
            assertEquals(pageTitle, element.getText());
        }
    }

    @When("user clicks on menu {string}")
    public void user_clicks_on_menu(String menu) {
        List<WebElement> menuElements = driver.findElements(By.xpath("//ul[@role=\"menu\"]/li"));
        WebElement elementChoosen = Function.choose(menuElements, menu);
        elementChoosen.click();
    }

    @When("user clicks on sub-menu {string}")
    public void user_clicks_on_sub_menu(String submenu) {
        List<WebElement> submenuElements = driver.findElements(By.xpath("//ul[@role=\"menu\"]/li/ul/li"));
        wait.until(ExpectedConditions.visibilityOfAllElements(submenuElements));
        WebElement elementChoosen = Function.choose(submenuElements, submenu);
        elementChoosen.click();
    }

    @When("user clicks on {string} button")
    public void user_clicks_on_button(String button) {
        WebElement buttonElement = driver.findElement(By.xpath("//button[@data-testid=\'"+button+"-button']")); //*[text()='"+button+"']
        buttonElement.click();
    }

    @When("user clicks to check on {string} checkbox")
    public void user_clicks_to_check_on_checkbox(String checkbox) {
        WebElement checkElement = driver.findElement(By.xpath("//*[.='"+checkbox+"']/preceding-sibling::span")); //span[text()='"+checkbox+"']/parent::span/preceding-sibling::span
        if (!(checkElement.getAttribute("class").contains("checked"))) {
            checkElement.click();
        }
    }
    @Then("checkbox {string} is checked")
    public void checkbox_is_checked(String checkbox) {
        WebElement checkElement = driver.findElement(By.xpath("//span[text()='"+checkbox+"']/preceding-sibling::span"));
        assertTrue(checkElement.getAttribute("class").contains("checked"));
    }
    @Then("modal {string} confirmation is displayed")
    public void modal_confirmation_is_displayed(String modal) {
        WebElement modalElement = driver.findElement(By.xpath("//*[@class='ant-modal-content']/child::div[1]/child::div"));
        wait.until(ExpectedConditions.visibilityOf(modalElement));
        assertEquals(modal, modalElement.getText()); 
    }

    @Then("icon {string} is enabled in page")
    public void icon_is_enabled_in_page(String icon) {
        WebElement iconElement = driver.findElement(By.xpath("//span[@data-testid=\'"+icon+"-icon\']"));
        assertFalse(iconElement.getAttribute("class").contains("disabled"));
    }

    @When("user clicks on {string} icon")
    public void user_clicks_on_icon(String icon) {
        WebElement iconElement = driver.findElement(By.xpath("//*[@data-testid=\'"+icon+"-icon\']"));
        iconElement.click();
    }

    @When("user clicks on {string} button in modal")
    public void user_clicks_on_button_in_modal(String button) {
        WebElement buttonElement = driver.findElement(By.xpath("//div[@class='ant-modal-footer']/button/span[text()='"+button+"']"));
        buttonElement.click();
    }

    @Then("notification {string} and {string} is displayed")
    public void notification_and_is_displayed(String notif, String desc) {
        WebElement notifElement = driver.findElement(By.xpath("//div[@class='ant-notification-notice-message']"));
        WebElement descElement = driver.findElement(By.xpath("//div[@class='ant-notification-notice-description']"));
        wait.until(ExpectedConditions.visibilityOfAllElements(notifElement));
        assertEquals(notif, notifElement.getText());
        assertEquals(desc, descElement.getText());
    }

    @Then("there is {string} item {string} created in table")
    public void there_is_item_created_in_table(String condition,String item) {
        WebElement itemNameElement = driver.findElement(By.xpath("(//div[@data-testid='info-button']/parent::td/preceding-sibling::td[3])[1]"));
        if (condition.equalsIgnoreCase("no new")) {
            assertNotEquals(item, itemNameElement.getText());
        } else {assertEquals(item, itemNameElement.getText());}
    }

    @When("user {string} {string} in {string} textbox")
    public void user_in_textbox(String action, String fill, String textbox){
        WebElement textboxElement = driver.findElement(By.xpath("//*[@id='basic_"+textbox+"']")); //*[@data-testid='"+textbox+"']    |    //*[text()='"+label+"']/parent::div/parent::div/child::div[2]/child::div/child::div/child::span/child::input
        switch (action) {
            case "type":
                textboxElement.sendKeys(fill);
                break;
            case "change":
                textboxElement.click();
                textboxElement.sendKeys(Keys.CONTROL+"A");
                textboxElement.sendKeys(Keys.BACK_SPACE);
                textboxElement.sendKeys(fill);
            default:
                break;
        }
    }

    @Then("textbox {string} will fill by {string}")
    public void textbox_will_fill_by(String textbox, String fill){
        WebElement textboxElement = driver.findElement(By.xpath("//*[@data-testid='"+textbox+"']")); //*[text()='"+label+"']/parent::div/parent::div/child::div[2]/child::div/child::div/child::span/child::input
        assertEquals(fill, textboxElement.getAttribute("value"));
    }

    @Then("{string} items is {string} exist")
    public void items_is_exist(String itemName, String condition) {
        boolean isExist=false;
        List<WebElement> itemElements = driver.findElements(By.xpath("//table/tbody/tr"));
        for (int i = 1; i < itemElements.size(); i++) {
            WebElement nameItems = driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[2]"));
            System.out.println(nameItems);
            if (nameItems.getText().equals(itemName)) {
                isExist = true;
                break; 
            }
        }
        switch (condition) {
            case "already":
                assertTrue(isExist);
                break;
            case "still":
                assertTrue(isExist);
                break;
            case "not":
                assertFalse(isExist);
                break;
            default:
                break;
        }
    }
    @When("user select an item {string} by check the checkbox")
    public void user_select_an_item_by_check_the_checkbox(String itemName) {
        List<WebElement> itemElements = driver.findElements(By.xpath("//table/tbody/tr"));
        for (int i = 1; i < itemElements.size(); i++) {
            WebElement nameItems = driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[2]"));
            if (nameItems.getText().equals(itemName)) {
                driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).click();

                break;
            }
        }
        
    }
    @Then("item {string} is checked")
    public void item_is_checked(String itemName) {
        List<WebElement> itemElements = driver.findElements(By.xpath("//table/tbody/tr"));
        for (int i = 1; i < itemElements.size(); i++) {
            WebElement nameItems = driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[2]"));
            if (nameItems.getText().equals(itemName)) {
                WebElement item = driver.findElement(By.xpath("//table/tbody/tr["+i+"]"));
                assertTrue(item.getAttribute("class").contains("selected"));
                break;
            }
        }
    }

    @Then("item {string} change to be {string}")
    public void item_change_to_be(String itemNameBefore, String itemNameAfter) {
        boolean isExist=false;
        List<WebElement> itemElements = driver.findElements(By.xpath("//table/tbody/tr"));
        for (int i = 1; i < itemElements.size(); i++) {
            WebElement nameItems = driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[2]"));
            if (nameItems.getText().equals(itemNameBefore)) {
                isExist = true;
                break; 
            }
        }
        assertFalse(isExist);
        for (int i = 1; i < itemElements.size(); i++) {
            WebElement nameItems = driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[2]"));
            if (nameItems.getText().equals(itemNameAfter)) {
                isExist = true;
                break; 
            }
        }
        assertTrue(isExist);
    }

    @When("user fill textbox {string} as {string}")
    public void user_fill_box_as(String textbox, String fill){
        WebElement textboxElement = driver.findElement(By.xpath("//input[@id='basic_"+textbox+"Name']"));
        textboxElement.click();
        List<WebElement> opsiElement = driver.findElements(By.xpath("//div[@id='basic_"+textbox+"Name_list']/div"));
        //wait.until(ExpectedConditions.visibilityOfAllElements(opsiElement));
        for (int i = 0; i < opsiElement.size(); i++) {
            String opsi = opsiElement.get(i).getText();
            if (opsi.equalsIgnoreCase(fill)) {
                opsiElement.get(i).click();
                break;
            }
        }
        if (textboxElement.getAttribute("value").equalsIgnoreCase("fill")) {
            
        } else {
            textboxElement.sendKeys(fill+Keys.ENTER);
        }
    } 

    @Then("textbox {string} filled by {string}")
    public void textbox_filled_by(String textbox, String content){
        WebElement textboxElement = driver.findElement(By.xpath("//input[@id='basic_"+textbox+"Name']"));
        assertEquals(content, textboxElement.getAttribute("value"));
    }

    @When("user select {string} radio")
    public void user_select_radio(String radio){
        List<WebElement> radioElement = driver.findElements(By.xpath("//input[@type='radio']/parent::span/parent::label"));
        for (int i = 0; i < radioElement.size(); i++) {
            String label = radioElement.get(i).getText();
            if (label.equalsIgnoreCase(radio)) {
                radioElement.get(i).click();
            }
        }
    }

    @Then("radio {string} is selected")
    public void radio_is_selected(String radio){
        Boolean isSelected = false;
        List<WebElement> radioElement = driver.findElements(By.xpath("//input[@type='radio']/parent::span/parent::label"));
        for (int i = 0; i < radioElement.size(); i++) {
            String label = radioElement.get(i).getText();
            if (label.equalsIgnoreCase(radio)) {
                isSelected = radioElement.get(i).getAttribute("class").contains("checked");
            }
        }
        assertTrue(isSelected);
    }

    @When("user choose item {string} in modal select")
    public void user_choose_item_in_modal_select(String itemName){
        List<WebElement> opsi = driver.findElements(By.xpath("//table/tbody/tr/td[2]"));
        wait.until(ExpectedConditions.visibilityOf(opsi.get(1)));
        for (int i = 0; i < opsi.size(); i++) {
            String label = opsi.get(i).getText();
            if (label.equalsIgnoreCase(itemName)) {
                opsi.get(i).click();
                break;
            }
        }
    }

    @When("user clicks on {string} select box")
    public void user_clicks_on_select_box(String box){
        WebElement boxElement = driver.findElement(By.xpath("//label[@title='"+box+"']/parent::div/parent::div/div[2]"));
        boxElement.click();
    }

    @Then("select box {string} filled by {string}")
    public void select_box_filled_by(String box, String content){
        WebElement boxElement = driver.findElement(By.xpath("//label[@title='"+box+"']/parent::div/parent::div/div[2]/div/div/span/input")); 
        assertEquals(content, boxElement.getAttribute("value"));
    }
    
    @Then("{string} item is selected in the modal")
    public void item_is_selected_in_the_modal(String itemName){
        WebElement selectedElement = driver.findElement(By.xpath("//span[text()='Currently Selected: ']/parent::div/parent::div"));
        assertTrue(selectedElement.getText().contains(itemName));
    }

    
    @When("user {string} on box {string} as {string}")
    public void user_on_box_as(String action, String box, String content){
        WebElement boxElement = driver.findElement(By.xpath("//label[contains(.,'"+box+"')]/parent::div/following-sibling::div/div/div/div/span/span/input"));
        switch (action) {
            case "type":
                boxElement.sendKeys(content);
                break;
            default:
                break;
        }
        
    }

    @Then("box {string} filled by {string}")
    public void box_filled_by(String box, String content){
        WebElement boxElement = driver.findElement(By.xpath("//label[contains(.,'"+box+"')]/parent::div/following-sibling::div/div/div/div/span/span/input"));
        assertEquals(content, boxElement.getAttribute("value"));
    }

    @Then("user validating data new cell line")
    public void user_validating_data_new_cell_line(DataTable datas) {
        List<String> type = datas.row(0);
        List<String> content = datas.row(1);
        for (int i = 0; i < type.size(); i++) {
            String dataType = type.get(i);
            String dataContent = content.get(i);
            WebElement detailElement = driver.findElement(By.xpath("//div[@class='detail-container']/div/div[contains(.,'"+dataType+"')]/following-sibling::div[2]"));
            assertEquals(dataContent, detailElement.getText());
        }
    }

    @When("user clicks detail button of item {string}")
    public void user_clicks_detail_button_of_item(String itemName){
        WebElement itemElement = driver.findElement(By.xpath("//table/tbody/tr/td[text()='"+itemName+"']/following-sibling::td/div[@data-testid='info-button']"));
        itemElement.click();
    }

    //label[contains(@class,'required')]/parent::div/following-sibling::div/div[2]
    @Then("alert Required is displayed on bottom of box")
    public void alert_required_is_displayed_on_bottom_of_box(DataTable boxTable){
        List<String> box = boxTable.row(0);
        for (int i = 0; i < box.size(); i++) {
            WebElement boxElement = driver.findElement(By.xpath("//label[contains(@class,'required')]/parent::div/following-sibling::div/div[2]"));
            assertEquals("Required", boxElement.getText());
        }
    }

    @When("user clicks to uncheck on {string} checkbox")
    public void user_clicks_to_uncheck_on_checkbox(String checkbox) {
        WebElement checkElement = driver.findElement(By.xpath("//span[text()='"+checkbox+"']/parent::span/preceding-sibling::span"));
        if (checkElement.getAttribute("class").contains("checked")) {
            checkElement.click();
        }
    }

    @When("user select all item")
    public void user_select_all_item(){
        WebElement selectAllElement = driver.findElement(By.xpath("//table/thead/tr/th[1]/div/label/span"));
        selectAllElement.click();
    }
}
