package pageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
    
    @FindBy(xpath = "//div[@class=\"logout-button\"]")
    WebElement btn_logout;

    protected WebDriver driver;
    protected WebDriverWait wait;

    public DashboardPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, DashboardPage.this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(btn_logout));
    }

    public Boolean checkbtnlogout(){
        return btn_logout.isDisplayed();
    }
    
}
