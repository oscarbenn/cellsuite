package pageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReagentLibraryPage {
    
    @FindBy(xpath = "//div[@class=\"ant-page-header-heading\"]/child::div")
    WebElement app_title;
    @FindBy(xpath = "//button[@data-testid=\"create-button\"]")
    WebElement btn_create;
    @FindBy(xpath = "//span[@data-testid=\"delete-icon\"]")
    WebElement btn_delete;
    @FindBy(xpath = "//span[@data-testid=\"edit-icon\"]")
    WebElement btn_edit;

    @FindBy(xpath = "//div[@role=\"alert\"]/child::div[1]")
    WebElement notif_alert;
    @FindBy(xpath = "//div[@role=\"alert\"]/child::div[2]")
    WebElement desc_alert;
    
    protected WebDriver driver;
    protected WebDriverWait wait;

    public ReagentLibraryPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, ReagentLibraryPage.this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getTitleofPage() {
        wait.until(ExpectedConditions.visibilityOf(app_title));
        return app_title.getText();
    }

    public void clickButtonCreate() {
        btn_create.click();
        wait.until(ExpectedConditions.invisibilityOf(app_title));
    }

    public Boolean checknotif() {
        wait.until(ExpectedConditions.visibilityOf(notif_alert));
        return notif_alert.isDisplayed();
    }

    public String getNotifMsg() {
        return notif_alert.getText();
    }

    public Object getDescNotif() {
        return null;
    }


}
