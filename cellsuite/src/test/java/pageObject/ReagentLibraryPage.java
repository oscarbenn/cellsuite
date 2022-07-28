package pageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReagentLibraryPage {
    
    @FindBy(xpath = "//div[@class=\"dashboard-header-content\"]/child::span")
    WebElement app_title;
    @FindBy(xpath = "//button[@data-testid=\"create-button\"]")
    WebElement btn_create;
    @FindBy(xpath = "//span[@data-testid=\"delete-icon\"]")
    WebElement btn_delete;
    @FindBy(xpath = "//span[@data-testid=\"edit-icon\"]")
    WebElement btn_edit;
    
    protected WebDriver driver;
    protected WebDriverWait wait;

    public ReagentLibraryPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, ReagentLibraryPage.this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getTitleofPage() {
        return app_title.getText();
    }

    public void clickButtonCreate() {
        btn_create.click();
    }


}
