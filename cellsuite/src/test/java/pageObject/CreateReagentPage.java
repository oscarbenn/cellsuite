package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateReagentPage {
    
    @FindBy(xpath = "//div[@data-testid=\"reagents-editor-container\"]")
    WebElement container_app;
    @FindBy(xpath = "//svg[@data-testid=\"close-icon\"]/parent::div")
    WebElement btn_close;
    @FindBy(xpath = "//button[@data-testid=\"save-button\"]")
    WebElement btn_save;
    @FindBy(xpath = "//input[@data-testid=\"reagent-name\"]")
    WebElement txt_reagentname;

}
