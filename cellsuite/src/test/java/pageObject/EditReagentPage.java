package pageObject;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditReagentPage {
    @FindBy(xpath = "//*[@data-testid='close-icon']")
    WebElement btn_close;
    @FindBy(xpath = "//span[@class='ant-page-header-heading-title']")
    WebElement title_app;
    @FindBy(xpath = "//button[@data-testid='revert-button']")
    WebElement btn_revert;
    @FindBy(xpath = "//button[@data-testid='save-button']")
    WebElement btn_save;
    @FindBy(xpath = "//input[@data-testid=\"reagent-name\"]")
    WebElement txt_reagentname;
    @FindBy(xpath = "//textarea[@data-testid=\"reagent-notes\"]")
    WebElement text_notes;

    @FindBy(xpath = "//*[@class=\"ant-modal-content\"]/child::div[1]/child::div")
    WebElement modal_title;
    @FindBy(xpath = "//*[@class=\"ant-modal-content\"]/child::div[3]/child::button[1]")
    WebElement modal_close;
    @FindBy(xpath = "//*[@class=\"ant-modal-content\"]/child::div[3]/child::button[2]")
    WebElement modal_ok;

    @FindBy(xpath = "//*[@data-testid=\"next-icon\"]")
    WebElement btn_next;
    @FindBy(xpath = "//*[@data-testid=\"prev-icon\"]")
    WebElement btn_prev;
    
    protected WebDriver driver;
    protected WebDriverWait wait;

    public EditReagentPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, EditReagentPage.this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getTitleApp() {
        wait.until(ExpectedConditions.visibilityOf(txt_reagentname));
        return title_app.getText();
    }

    public void changeNameWith(String fill) {
        txt_reagentname.click();
        txt_reagentname.sendKeys(Keys.CONTROL+"A");
        txt_reagentname.sendKeys(Keys.BACK_SPACE);
        txt_reagentname.sendKeys(fill);
    }

    public void changeNoteWith(String fill) {
        text_notes.clear();
        text_notes.sendKeys(fill);
    }

    public void clickButtonOk() {
        modal_ok.click();
    }

    public boolean checkModal() {
        return modal_title.isDisplayed();
    }

    public void clickButtonSave() {
        btn_save.click();
        wait.until(ExpectedConditions.visibilityOf(modal_title));
    }

    public void clickButtonNext(){
        btn_next.click();
    }

    public void clickButtonPrev(){
        btn_prev.click();
    }

    public void clickButtonClose() {
        btn_close.click();
        wait.until(ExpectedConditions.invisibilityOf(btn_close));
    }
}
