package pageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.Function;

public class DashboardPage {
    
    @FindBy(xpath = "//span[@class='app-title']")
    WebElement title_app;
    @FindBy(xpath = "//div[@class=\"logout-button\"]")
    WebElement btn_logout;
    @FindBy(xpath = "//ul[@role=\"menu\"]/li")
    List<WebElement> menu_elements;
    @FindBy(xpath = "//ul[@role=\"menu\"]/li/ul/li")
    List<WebElement> submenu_elements;

    protected WebDriver driver;
    protected WebDriverWait wait;

    public DashboardPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, DashboardPage.this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickbtnMenu(String menu) {
        WebElement choosen = Function.choose(menu_elements, menu);
        choosen.click();
    }

    public void clickbtnSubMenu(String submenu) {
        wait.until(ExpectedConditions.visibilityOfAllElements(submenu_elements));
        WebElement choosen = Function.choose(submenu_elements, submenu);
        choosen.click();
    }

    public String getTitleApp() {
        wait.until(ExpectedConditions.visibilityOf(btn_logout));
        return title_app.getText();
    }
}
