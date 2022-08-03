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

    public String getDescNotif() {
        return desc_alert.getText();
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

    public boolean checkItemIsExist() {
        return (barisTable.size()>1);
    }

    public void selectItemByName(String itemName) {
        for (int i = 1; i < barisTable.size(); i++) {
            WebElement name_row = driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[2]"));
            String label = name_row.getText();
            System.out.println(label);
            if (label.equals(itemName)) {
                WebElement choosen = driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]"));
                choosen.click();
                break;
            } 
        }
    }

    public Boolean checkItemIsSelected(String itemName) {
        for (int i = 1; i < barisTable.size(); i++) {
            WebElement name_row = driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[2]"));
            String label = name_row.getText();
            System.out.println(label);
            if (label.equals(itemName)) {
                WebElement choosen = driver.findElement(By.xpath("//table/tbody/tr["+i+"]"));
                //choosen.getClass().equals(class="ant-table-row ant-table-row-level-0 ant-table-row-selected");
                String classs = choosen.getAttribute("class");
                System.out.println(classs);
                return classs.contains("selected");
            }
        }
        return null;
    }

    public Boolean checkEditButtonIsEnabled() {
        wait.until(ExpectedConditions.elementToBeClickable(btn_edit));
        return btn_edit.isEnabled();
    }

    public void clickButtonEdit() {
        btn_edit.click();
    }

    public void clickButtonSave() {
        
    }
}
