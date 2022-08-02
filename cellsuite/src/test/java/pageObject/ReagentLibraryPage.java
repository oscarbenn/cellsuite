package pageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
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

    @FindBy(xpath = "//table/tbody/tr")
    List<WebElement> barisTable;
    @FindBy(xpath = "//table/tbody/tr[1]/td")
    List<WebElement> kolomTable;
    
    protected WebDriver driver;
    protected WebDriverWait wait;
    private By dataTable;
    private WebElement dataTableElement;

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
        WebElement choosen = choose(menu_elements, menu);
        choosen.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(submenu_elements));
    }

    private WebElement choose(List<WebElement> elements, String elementText) {
        WebElement choosenElement = null;
        for (int i = 0; i < elements.size(); i++) {
            WebElement element = elements.get(i);
            String label = element.getText();
            if (label.equals(elementText)) {
                choosenElement = element;
            }
        }
        return choosenElement;
    }

    public void clickbtnSubMenu(String submenu) {
        WebElement choosen = choose(submenu_elements, submenu);
        choosen.click();
    }

    // public WebElement getDataTable(String barisT, String kolomT){
    //     String i,j;
    //     for (int baris = 1; baris <= barisTable.size(); baris++) {
    //         for (int kolom = 1; kolom <= kolomTable.size(); kolom++) {
    //             dataTable = new By.ByXPath("//table/tbody/tr["+baris+"]/td["+kolom+"]");
    //             return dataTableElement.findElement(dataTable);
    //         }
    //     }
        
    // }


}
