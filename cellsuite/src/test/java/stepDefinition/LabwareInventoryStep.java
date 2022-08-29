package stepDefinition;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.labware.LabwareInventoryPage;

public class LabwareInventoryStep {
    

    WebDriver driver = DriverFactory.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    SoftAssertions softAssertions = new SoftAssertions();
    LabwareInventoryPage labwareInventoryPage = new LabwareInventoryPage(DriverFactory.getDriver());
    Actions actions = new Actions(DriverFactory.getDriver());

    int items;

    @Then("there is new item {string} created in table with empty exp date")
    public void there_is_new_item_created_in_table_with_empty_exp_date(String item) {
        WebElement itemNameElement = driver.findElement(By.xpath("(//div[@data-testid='info-button']/parent::td/preceding-sibling::td[8])[1]"));
        WebElement itemExpDateElement = driver.findElement(By.xpath("(//div[@data-testid='info-button']/parent::td/preceding-sibling::td[3])[1]"));
        assertEquals(item, itemNameElement.getText());
        assertEquals("",itemExpDateElement.getText());
    }

    @When("user fill on {string} as {string}")
    public void user_fill_on_as(String box, String count){
        WebElement boxElement = driver.findElement(By.xpath("//label[contains(.,'"+box+"')]/parent::div/following-sibling::div/div/div/div/input"));
        boxElement.click();
        boxElement.sendKeys(Keys.CONTROL+"A");
        boxElement.sendKeys(Keys.BACK_SPACE);
        boxElement.sendKeys(count);
    }

    @Then("{string} is filled by {string}")
    public void is_filled_by(String box, String count){
        WebElement boxElement = driver.findElement(By.xpath("//label[contains(.,'"+box+"')]/parent::div/following-sibling::div/div/div/div/input"));
        assertEquals(count, boxElement.getAttribute("value"));
    }

    @When("user type {string} in notes textbox")
    public void user_type_in_notes_textbox(String content){
        WebElement textboxElement = driver.findElement(By.xpath("//*[@data-testid='"+"notes"+"']"));
        textboxElement.sendKeys(content);
    }

    @Then("textbox notes is filled by {string}")
    public void textbox_notes__is_filled_by(String fill){
        WebElement textboxElement = driver.findElement(By.xpath("//*[@data-testid='"+"notes"+"']"));
        assertEquals(fill, textboxElement.getText());
    }

    @When("user clicks button OK in modal Save Labware")
    public void user_clicks_button_ok_in_modal_save_labware(){
        WebElement element = driver.findElement(By.xpath("//div[@class='ant-modal-confirm-btns']/button"));
        element.click();
    }

    @Then("{string} menu is appear")
    public void menu_is_appear(String content) {
        WebElement menuElement = driver.findElement(By.xpath("//span[text()='"+content+"']/parent::button/parent::div"));
        assertTrue(menuElement.isDisplayed());
    }

    @When("user choose content {string} and fill volume {string} and clicks on well image")
    public void user_choose_content_and_fill_volume_and_clicks_well_image(String content, String volume){
        WebElement tableElement = driver.findElement(By.xpath("//tbody[@class='ant-table-tbody']/tr[2]"));
        wait.until(ExpectedConditions.visibilityOf(tableElement));
        List<WebElement> opsicontentElements = driver.findElements(By.xpath("//table/tbody/tr/td[2]"));
        for (int i = 1; i <= opsicontentElements.size(); i++) {
            String labelContent = opsicontentElements.get(i).getText();
            if (labelContent.equalsIgnoreCase(content)) {
                opsicontentElements.get(i).click();
                break;
            }
        }
        WebElement inputvolumeElement = driver.findElement(By.xpath("//label[text()='Volume']/parent::div/following-sibling::div/div/div/div/span/span/input"));
        inputvolumeElement.sendKeys(volume);
        driver.findElement(By.xpath("//div[@class='microplate-container ']/div/div")).click();
    }

    @Then("content selected as {string} and volume displayed as {string} and image well is colored")
    public void content_selected_as_and_volume_displayed_as_and_image_well_is_colored(String content, String volume){
        List<WebElement> opsicontentElements = driver.findElements(By.xpath("//table/tbody[@class='ant-table-tbody']/tr/td[2]"));
        for (int i = 1; i <= opsicontentElements.size(); i++) {
            String labelContent = opsicontentElements.get(i).getText();
            System.out.println(labelContent);
            if (labelContent.equalsIgnoreCase(content)) {
                WebElement item = driver.findElement(By.xpath("//table/tbody[@class='ant-table-tbody']/tr["+(i+1)+"]"));
                assertTrue(item.getAttribute("class").contains("selected"));
                break;
            }
        }
        //WebElement inputvolumeElement = driver.findElement(By.xpath("//label[text()='Volume']/parent::div/following-sibling::div/div/div/div/span/span/input"));
        //assertEquals(volume, inputvolumeElement.getAttribute("value"));
        WebElement wellImage = driver.findElement(By.xpath("//div[@class='well-col one-well']/child::div/child::div"));
        String expectedColor = driver.findElement(By.xpath("//div[text()='"+content+"']/parent::div/div[@class='with-content']")).getCssValue("background-color");
        String actualColor = wellImage.getCssValue("background-color");
        softAssertions.assertThat(expectedColor).isEqualTo(actualColor);
        // assertEquals(expectedColor, actual);
        assertEquals(volume+"µL", wellImage.getText()); 
        
    }  

    @Then("dialog for defining {string} is displayed")
    public void dialog_for_defining_is_displayed(String dialog){
        WebElement dialogTitle = driver.findElement(By.xpath("//*[@class='ant-modal-body']/form/div/h3"));
        wait.until(ExpectedConditions.visibilityOf(dialogTitle));
        assertTrue(dialogTitle.getText().contains(dialog));
    }

    @Then("box {string} is {string}")
    public void box_is_appear(String box, String condition) {
        switch (box) {
            case "Labware Count":
                if (condition.equalsIgnoreCase("appear")) {
                    assertTrue(labwareInventoryPage.labwareCountIsDisplayed()); 
                } else if (condition.equalsIgnoreCase("disabled")) {
                    assertFalse(labwareInventoryPage.labwareCountIsEnabled());
                }
                break;
        
            default:
                break;
        }
    }
    @When("user choose Storage Location colnum {string} rownum {string}")
    public void user_choose_storage_location_colnum_rownum(String column, String row) {
        WebElement storageLocation = driver.findElement(By.xpath("//div[@data-testid='C0"+column+"-0"+row+"']"));
        storageLocation.click();
    }
    @Then("Storage Location colnum {string} rownum {string} is filled with {string} color")
    public void storage_location_colnum_rownum_is_filled_with_color(String column, String row, String color) {
        WebElement storageLocation = driver.findElement(By.xpath("//div[@data-testid='C0"+column+"-0"+row+"']"));
        WebElement colorElement = driver.findElement(By.xpath("//small[contains(.,'"+color+"')]/preceding-sibling::div"));
        assertTrue(storageLocation.getAttribute("class").contains("selected"));
        // assertEquals(colorElement.getCssValue("background-color"), storageLocation.getCssValue("background-color"));
        softAssertions.assertThat(colorElement.getCssValue("background-color")).isEqualTo(storageLocation.getCssValue("background-color"));
        
    }
    @Then("There is new {string} data with this condition")
    public void there_is_new_data_with_this_condition(String number, DataTable data) {
        List<String> type = data.row(0);
        List<String> content = data.row(1);
        for (int i = 1; i <= Integer.valueOf(number); i++){
            System.out.println(i+1);
            WebElement item = driver.findElement(By.xpath("//table/tbody/tr["+(i+1)+"]/td[10]/div"));
            item.click();
            WebElement detailElement = driver.findElement(By.xpath("//div[@class='detail-container']"));
            wait.until(ExpectedConditions.visibilityOf(detailElement));
            for (int j = 0; j < type.size(); j++) {
                String dataType = type.get(j);
                String dataContent = content.get(j);
                detailElement = driver.findElement(By.xpath("//div[@class='detail-container']/div/div[contains(.,'"+dataType+"')]/following-sibling::div[2]"));
                assertEquals(dataContent, detailElement.getText());
                System.out.println(detailElement.getText());
            }
            driver.findElement(By.xpath("//header[normalize-space()='Detail']//*[name()='svg']")).click(); //*[@data-testid='detail-item-close']
            wait.until(ExpectedConditions.invisibilityOf(detailElement));
        }
    }

    @When("user enter Exp Date day {string} mounth {string} year {string}")
    public void user_enter_exp_date_day_mounth_year(String day, String month, String year) {
        labwareInventoryPage.selectDate(day, month, year);
    }
    @Then("Expiration date is set by {string}")
    public void expiration_date_is_set_by(String calendarValue) {
        assertEquals(calendarValue, labwareInventoryPage.getCalendarValue());
    }

    @Then("error required text on {string} is displayed")
    public void error_required_text_on_is_displayed(String box) {
        WebElement alertElement = driver.findElement(By.xpath("//label[@title='"+box+"']/parent::div/following-sibling::div/div[2]"));
        assertTrue(alertElement.isDisplayed());
    }

    @When("user clicks {string} labware with {string} of {string}")
    public void user_clicks_labware_with_status(String number, String content, String type) {
        List<WebElement> labwareElements = new ArrayList<>();
        switch (type) {
            case "status":
                labwareElements = driver.findElements(By.xpath("//td[text()='"+content+"']/parent::tr/td[1]/label/span"));
                for (int i = 0; i < Integer.valueOf(number); i++) {
                    labwareElements.get(i).click();
                }
                break;
            case "barcode":
                List<WebElement> labwareBarcodeElements = driver.findElements(By.xpath("//tbody[@class='ant-table-tbody']/tr/td[4]"));
                for (int i = 1; i < labwareBarcodeElements.size(); i++) {
                    if (!(labwareBarcodeElements.get(i).getText().contains(content))) {
                        WebElement e = driver.findElement(By.xpath("//tbody[@class='ant-table-tbody']/tr["+(i+1)+"]/td[1]/label/span"));
                        labwareElements.add(e);
                    } 
                }
                for (int i = 0; i < Integer.valueOf(number); i++) {
                    labwareElements.get(i).click();
                }
                break;
            default:
                break;
        }
    }

    @When("user click on more icon button and click {string} menu")
    public void user_click_on_more_icon_button_and_click_menu(String opsi) {
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='header-popover']"))).perform();
        WebElement target = driver.findElement(By.xpath("//li[@role='menuitem']/span[text()='"+opsi+"']"));
        wait.until(ExpectedConditions.visibilityOf(target));
        actions.moveToElement(target).click().release().build().perform();
    }

    @Then("modal confirmation is closed")
    public void modal_confirmation_is_closed() {
        
    }

    
        


    
}
