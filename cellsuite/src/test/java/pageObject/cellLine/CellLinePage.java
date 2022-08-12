package pageObject.cellLine;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.Function;

public class CellLinePage {
    @FindBy(xpath = "//div[@class=\"ant-page-header-heading\"]/child::div")
    WebElement app_title;
    @FindBy(xpath = "//button[@data-testid=\"create-button\"]")
    WebElement btn_create;
    @FindBy(xpath = "//span[@data-testid=\"delete-icon\"]")
    WebElement btn_delete;
    @FindBy(xpath = "//span[@data-testid=\"edit-icon\"]")
    WebElement btn_edit;

    @FindBy(xpath = "//div[@role=\"alert\"]")
    WebElement notif;
    @FindBy(xpath = "//div[@role=\"alert\"]/child::div[1]")
    WebElement notif_alert;
    @FindBy(xpath = "//div[@role=\"alert\"]/child::div[2]")
    WebElement desc_alert;

    @FindBy(xpath = "//ul[@role=\"menu\"]/li")
    List<WebElement> menu_elements;
    @FindBy(xpath = "//ul[@role=\"menu\"]/li/ul/li")
    List<WebElement> submenu_elements;


    protected WebDriver driver;
    protected WebDriverWait wait;

    public CellLinePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, CellLinePage.this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getTitleApp() {
        return app_title.getText();
    }

    public Boolean checkcreatebuton() {
        wait.until(ExpectedConditions.visibilityOf(btn_create));
        return btn_create.isDisplayed();
    }

    public void clickButtonCreate() {
        btn_create.click();
    }

    public Boolean checknotif() {
        wait.until(ExpectedConditions.visibilityOf(notif));
        return notif.isDisplayed();
    }

    public String getNotifMsg() {
        return notif_alert.getText();
    }

    public Object getDescNotif() {
        return desc_alert.getText();
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
    
}
