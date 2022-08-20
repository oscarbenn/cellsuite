package pageObject.reagent.CultureReagent;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateReagentCulturePage {
    @FindBy(xpath = "//input[@data-testid=\"reagent-name-0\"]")
    WebElement select_composition;
    @FindBy(xpath = "//input[@data-testid=\"percentage-0\"]")
    WebElement txt_persentage;
    @FindBy(xpath = "//table/tbody/tr")
    List<WebElement> barisTable;
    @FindBy(xpath = "//table/tbody/tr[1]/td")
    List<WebElement> kolomTable;
    //table/tbody/tr[1]/td[2]

    protected WebDriver driver;
    protected WebDriverWait wait;

    public CreateReagentCulturePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, CreateReagentCulturePage.this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void chooseComposition(String composition, String persen) {
        select_composition.click();
        List<WebElement> opsi = driver.findElements(By.xpath("//table/tbody/tr/td[2]"));
        for (int i = 0; i < opsi.size(); i++) {
            WebElement o  = opsi.get(i);
            String label = o.getText();
            System.out.println(label);
            if (label.equalsIgnoreCase(composition)) {
                o.click();
                break;
            }
        }
        WebElement btn_ok = driver.findElement(By.xpath("//div[text()='Select Reagent']/parent::div/parent::div/div[3]/button/span[text()='OK']"));
        wait.until(ExpectedConditions.elementToBeClickable(btn_ok));
        btn_ok.click();
        txt_persentage.click();
        txt_persentage.sendKeys(Keys.CONTROL+"A");
        txt_persentage.sendKeys(Keys.BACK_SPACE);
        txt_persentage.sendKeys(persen);
    }

    public String getCompositionValue() {
        return select_composition.getAttribute("value");
    }

    public Object getPersenValue() {
        return txt_persentage.getAttribute("value");
    }
}
