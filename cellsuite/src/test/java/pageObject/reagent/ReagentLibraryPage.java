package pageObject.reagent;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReagentLibraryPage {

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

    public Object getItem(String item) {
        for (int i = 1; i < barisTable.size(); i++) {
            WebElement name_row = driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[2]"));
            String label = name_row.getText();
            System.out.println(label);
            if (label.equals(item)) {
                return name_row.getText();
            } 
        }
        return null;
    }
}
