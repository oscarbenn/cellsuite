package pageObject.labware;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LabwareInventoryPage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(xpath = "//table/tbody/tr")
    List<WebElement> barisTable;
    @FindBy(xpath = "//table/tbody/tr[1]/td")
    List<WebElement> kolomTable;
    
    List<String> listofbarcode;

    public LabwareInventoryPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, LabwareInventoryPage.this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public List<String> getListBarcode(){
        for (int i = 1; i < barisTable.size(); i++) {
            WebElement barcode_row = driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]"));
            String label = barcode_row.getText();
            listofbarcode.add(label); 
        }
        return listofbarcode;
    }
    
}
