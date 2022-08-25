package stepDefinition;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LabwareInventoryStep {
    

    WebDriver driver = DriverFactory.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    @Then("there is new item {string} created in table with empty exp date")
    public void there_is_new_item_created_in_table_with_empty_exp_date(String item) {
        WebElement itemNameElement = driver.findElement(By.xpath("(//div[@data-testid='info-button']/parent::td/preceding-sibling::td[8])[1]"));
        WebElement itemExpDateElement = driver.findElement(By.xpath("(//div[@data-testid='info-button']/parent::td/preceding-sibling::td[3])[1]"));
        assertEquals(item, itemNameElement.getText());
        assertEquals("",itemExpDateElement.getText());
    }

    @When("user fill on Labware Count as {string}")
    public void user_fill_on_labware_count_as(String count){
        WebElement boxElement = driver.findElement(By.xpath("//label[contains(.,'Labware Count')]/parent::div/following-sibling::div/div/div/div/input"));
        boxElement.click();
        boxElement.sendKeys(Keys.CONTROL+"A");
        boxElement.sendKeys(Keys.BACK_SPACE);
        boxElement.sendKeys(count);
    }

    @Then("Labware Count is filled by {string}")
    public void labware_count_is_filled_by(String count){
        WebElement boxElement = driver.findElement(By.xpath("//label[contains(.,'Labware Count')]/parent::div/following-sibling::div/div/div/div/input"));
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

    @When("user choose content {string} and fill volume {string}")
    public void user_choose_content_and_fill_volume(String content, String volume){
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
    }

    @Then("content selected as {string} and volume displayed as {string}")
    public void content_selected_as_and_volume_displayed_as(String content, String volume){
        List<WebElement> opsicontentElements = driver.findElements(By.xpath("//table/tbody/tr/td[2]"));
        for (int i = 1; i <= opsicontentElements.size(); i++) {
            String labelContent = opsicontentElements.get(i).getText();
            System.out.println(labelContent);
            if (labelContent.equalsIgnoreCase(content)) {
                WebElement item = driver.findElement(By.xpath("//table/tbody/tr["+(i+1)+"]"));
                assertTrue(item.getAttribute("class").contains("selected"));
                break;
            }
        }
        WebElement inputvolumeElement = driver.findElement(By.xpath("//label[text()='Volume']/parent::div/following-sibling::div/div/div/div/span/span/input"));
        assertEquals(volume, inputvolumeElement.getAttribute("value"));
    }  

    @Then("dialog for defining {string} is displayed")
    public void dialog_for_defining_is_displayed(String dialog){
        WebElement dialogTitle = driver.findElement(By.xpath("//*[@class='ant-modal-body']/form/div/h3"));
        wait.until(ExpectedConditions.visibilityOf(dialogTitle));
        assertTrue(dialogTitle.getText().contains(dialog));
    }


    
        


    
}
