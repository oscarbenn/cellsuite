package pageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Keys;
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
    @FindBy(xpath = "//div[@data-testid=\"reagent-type\"]/child::div/child::span[2]")
    WebElement inputselect_reagenttype;
    @FindBy(xpath = "//input[@data-testid=\"create-culture-reagent\"]/parent::span")
    WebElement chkbox_createCultureReagent;

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
    }

    public void clickbtnsave() {
        btn_save.click();
    }

    public String gettitleapp() {
        wait.until(ExpectedConditions.elementToBeClickable(btn_save));
        return title_app.getText();
    }

    public void entersName(String fill) {
        txt_reagentname.sendKeys(fill);
        txt_reagentname.sendKeys(Keys.ESCAPE);
    }

    public String getNameValue() {
        return txt_reagentname.getAttribute("value");
    }

    public void chooseType(String opsi) {
        select_reagenttype.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(opsi_reagenttype));
        WebElement choosen = choose(opsi_reagenttype, opsi);
        choosen.click();
        wait.until(ExpectedConditions.attributeToBe(inputselect_reagenttype, "title", opsi));
    }

    public String getTypeValue() {
        return inputselect_reagenttype.getText();
    }

    public void entersNotes(String fill) {
        text_notes.sendKeys(fill);
    }

    public String getNotesValue() {
        return text_notes.getText();
    }

    public void checkCreateCultureReagent(){
        check_culture.click();
    }

    public Boolean createCultureReagentisChecked(){
        //return check_culture.getAttribute("class");
        return check_culture.getAttribute("class").equalsIgnoreCase("ant-checkbox ant-checkbox-checked");
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

}
