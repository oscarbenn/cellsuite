package pageObject.cellLine;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CellLinePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(xpath = "//table/tbody/tr")
    List<WebElement> barisTable;
    @FindBy(xpath = "//table/tbody/tr[1]/td")
    List<WebElement> kolomTable;

    public CellLinePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, CellLinePage.this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
}
