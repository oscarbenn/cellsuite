package pageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateReagentPage {    
    @FindBy(xpath = "//div[@data-testid=\"reagents-editor-container\"]")
    WebElement container_app;
    @FindBy(xpath = "//div[@class='ant-page-header-heading']/child::div/child::span")
    WebElement title_app;
    @FindBy(xpath = "//div[@class='ant-page-header-heading']/child::div/child::div")
    WebElement btn_close;
    @FindBy(xpath = "//button[@data-testid=\"save-button\"]")
    WebElement btn_save;
    @FindBy(xpath = "//input[@data-testid=\"reagent-name\"]")
    WebElement txt_reagentname;
    @FindBy(xpath = "//div[@data-testid=\"reagent-type\"]")
    WebElement select_reagenttype;
    @FindBy(xpath = "//div[@label=\"Other\"]/parent::div/child::div")
    List<WebElement> opsi_reagenttype;
    @FindBy(xpath = "//input[@data-testid=\"create-culture-reagent\"]")
    WebElement check_culture;
    @FindBy(xpath = "//textarea[@data-testid=\"reagent-notes\"]")
    WebElement text_notes;

    protected WebDriver driver;
    protected WebDriverWait wait;

    public CreateReagentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, CreateReagentPage.this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(btn_save));
    }

    public void clickbtnsave() {
        btn_save.click();
    }

    public String gettitleapp() {
        return title_app.getText();
    }

    public void entersName(String fill) {
        txt_reagentname.sendKeys(fill);
    }

    public Object getNameValue() {
        return txt_reagentname.getAttribute("value");
    }

    public void chooseType(String opsi) {
        
    }

    public Object getTypeValue() {
        return null;
    }

}
