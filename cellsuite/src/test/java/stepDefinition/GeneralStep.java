package stepDefinition;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.DriverFactory;
import factory.Function;
import io.cucumber.java.en.*;

public class GeneralStep {

    WebDriver driver = DriverFactory.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @Then("user is navigated to {string} page")
    public void user_is_navigated_to_page(String pageTitle) {
        WebElement element = driver.findElement(By.xpath("//div/div/div/span[contains(@class,'title')]"));
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

    @When("user clicks on {string} button in page")
    public void user_clicks_on_button_in_page(String button) {
        WebElement buttonElement = driver.findElement(By.xpath("//button[@data-testid=\'"+button+"-button']"));
        buttonElement.click();
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

    @When("user clicks on {string} icon in page")
    public void user_clicks_on_icon_in_page(String icon) {
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
}
