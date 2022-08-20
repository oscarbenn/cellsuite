package pageObject.reagent.ReagentLibrary;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.Function;

public class CreateReagentLibraryPage {    
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

    public CreateReagentLibraryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, CreateReagentLibraryPage.this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void entersName(String fill) {
        txt_reagentname.sendKeys(fill);
    }

    public String getNameValue() {
        return txt_reagentname.getAttribute("value");
    }

    public void chooseType(String opsi) {
        select_reagenttype.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(opsi_reagenttype));
        WebElement choosen = Function.choose(opsi_reagenttype, opsi);
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
        return check_culture.getAttribute("class").equalsIgnoreCase("ant-checkbox ant-checkbox-checked");
    }

    public boolean isCreateCultureChecked() {
        return chkbox_createCultureReagent.getAttribute("class").contains("checked");
    }
}
