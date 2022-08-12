package pageObject.reagent;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditReagentCulturePage {
    @FindBy(xpath = "//input[@data-testid=\"name\"]")
    WebElement txt_reagentname;
    @FindBy(xpath = "//input[@data-testid=\"reagent-name-0\"]")
    WebElement select_composition;
    @FindBy(xpath = "//input[@data-testid=\"percentage-0\"]")
    WebElement txt_persentage;
    @FindBy(xpath = "//textarea[@data-testid=\"notes\"]")
    WebElement text_notes;
    
    protected WebDriver driver;
    protected WebDriverWait wait;

    public EditReagentCulturePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, EditReagentCulturePage.this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
}
