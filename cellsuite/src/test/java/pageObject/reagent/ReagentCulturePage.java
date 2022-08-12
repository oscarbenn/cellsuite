package pageObject.reagent;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.Function;

public class ReagentCulturePage {
    
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
    @FindBy(xpath = "(//div[@data-testid=\"info-button\"]/parent::td/preceding-sibling::td[3])[1]")
    WebElement new_reagentculturename;
    @FindBy(xpath = "(//div[@data-testid=\"info-button\"]/parent::td/preceding-sibling::td[2])[1]")
    WebElement new_reagentculturecomposition;
    
    
    protected WebDriver driver;
    protected WebDriverWait wait;

    public ReagentCulturePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, ReagentCulturePage.this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getTopReagentCulture(){
        return new_reagentculturename.getText();
    }

    public Boolean getCompositionOfReagentCulture(String composition) {
        return new_reagentculturecomposition.getText().contains(composition);
    }

    public String getTitleofPage() {
        wait.until(ExpectedConditions.visibilityOf(app_title));
        return app_title.getText();
    }

    public CreateReagentCulturePage clickButtonCreate() {
        btn_create.click();
        return new CreateReagentCulturePage(driver);
    }

    public Boolean checknotif() {
        wait.until(ExpectedConditions.visibilityOf(notif));
        return notif.isDisplayed();
    }

    public String getNotifMsg() {
        return notif.getText();
    }

    public Object getDescNotif() {
        return null;
    }

    public void clickbtnMenu(String menu) {
        WebElement choosen = Function.choose(menu_elements, menu);
        choosen.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(submenu_elements));
    }

    public void clickbtnSubMenu(String submenu) {
        WebElement choosen = Function.choose(submenu_elements, submenu);
        choosen.click();
    }

    public EditReagentCulturePage clickButtonEdit() {
        return null;
    }

    public void clickButtonDelete() {
    }
    
}
