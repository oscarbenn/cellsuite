package pageObject.labware;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LabwareInventoryPage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    private By calendar = By.id("expirationDate");
    private By calendarContent = By.xpath("//div[@class='ant-picker-date-panel']");
    private By calendarMonth = By.xpath("//button[@class='ant-picker-month-btn']");
    private By calendarYear = By.xpath("//button[@class='ant-picker-year-btn']");
    private By calendarNext = By.xpath("//button[@class='ant-picker-header-next-btn']");
    private By calendarPrev = By.xpath("//button[@class='ant-picker-header-prev-btn']");

    @FindBy(xpath = "//table/tbody/tr")
    List<WebElement> barisTable;
    @FindBy(xpath = "//table/tbody/tr[1]/td")
    List<WebElement> kolomTable;

    @FindBy(xpath = "//input[@data-testid='quantity']")
    WebElement box_LabwareCount;
    
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

    public Boolean labwareCountIsDisplayed(){
        wait.until(ExpectedConditions.visibilityOf(box_LabwareCount));
        return box_LabwareCount.isDisplayed();
    }

    public Boolean labwareCountIsEnabled(){
        return box_LabwareCount.isEnabled();
    }
    
    public void selectDate(String day, String month, String year){
        driver.findElement(calendar).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(calendarContent));
        String mm = driver.findElement(calendarMonth).getText();
        String yy = driver.findElement(calendarYear).getText();
        int monthval = monthValue(month);
        int yearval = Integer.parseInt(year);
        int nowmonthval = monthValue(mm);
        int nowyearval = Integer.parseInt(yy);

        if (yearval>nowyearval) {
            while (!(mm.equals(month) && yy.equals(year))) {
                driver.findElement(calendarNext).click();
                mm = driver.findElement(calendarMonth).getText();
                yy = driver.findElement(calendarYear).getText();
            }
        }
        else if (yearval == nowyearval) {
            if (monthval>nowmonthval) {
                while (!(mm.equals(month) && yy.equals(year))) {
                    driver.findElement(calendarNext).click();
                    mm = driver.findElement(calendarMonth).getText();
                    yy = driver.findElement(calendarYear).getText();
                }
            } else if (monthval<nowmonthval) {
                while (!(mm.equals(month) && yy.equals(year))) {
                    driver.findElement(calendarPrev).click();
                    mm = driver.findElement(calendarMonth).getText();
                    yy = driver.findElement(calendarYear).getText();
                }
            }
        } else {
            while (!(mm.equals(month) && yy.equals(year))) {
                driver.findElement(calendarPrev).click();
                mm = driver.findElement(calendarMonth).getText();
                yy = driver.findElement(calendarYear).getText();
            }
        }

        WebElement dayElement = driver.findElement(By.xpath("//td[contains(@class,'ant-picker-cell-in-view')]/div[text()='"+day+"']"));
        dayElement.click();
    }
    
    public int monthValue(String m){
        switch (m) {
            case "Jan":
                return 1;
            case "Feb":
                return 2;
            case "Mar":
                return 3;
            case "Apr":
                return 4;
            case "May":
                return 5;
            case "Jun":
                return 6;
            case "Jul":
                return 7;
            case "Aug":
                return 8;
            case "Sep":
                return 9;
            case "Oct":
                return 10;
            case "Nov":
                return 11;
            case "Dec":
                return 12;
            default:
                return 0;
        }
    }

    public String getCalendarValue() {
        return driver.findElement(calendar).getAttribute("value");
    }
}
