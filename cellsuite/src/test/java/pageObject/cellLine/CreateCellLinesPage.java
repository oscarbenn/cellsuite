package pageObject.cellLine;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.Function;

public class CreateCellLinesPage {
    
    @FindBy(xpath = "//input[@data-testid=\"name\"]")
    WebElement txt_name;
    @FindBy(xpath = "//input[@id=\"basic_organismName\"]")
    WebElement txt_organism;
    @FindBy(xpath = "//input[@id=\"basic_tissueName\"]")
    WebElement txt_tissue;
    @FindBy(xpath = "//input[@id=\"basic_morphologyName\"]")
    WebElement txt_moprhology;
    @FindBy(xpath = "//input[@data-testid=\"disease\"]")
    WebElement txt_disease;
    @FindBy(xpath = "//textarea[@id=\"basic_notes\"]")
    WebElement txt_notes;
    @FindBy(xpath = "//div[@data-testid=\"passage-after\"]")
    WebElement radio_pasageAfter;
    @FindBy(xpath = "//input[@value=\"Confluency\"]")
    WebElement radio_confluency;
    @FindBy(xpath = "//input[@value=\"TimeInterval\"]")
    WebElement radio_timeInterval;
    @FindBy(xpath = "//input[@data-testid=\"passage-after-confluency-percentage\"]")
    WebElement txt_confluency;
    @FindBy(xpath = "//input[@data-testid=\"passage-after-time-interval-hour\"]")
    WebElement txt_time;

    @FindBy(xpath = "//input[@data-testid=\"media-culture-reagent-name\"]")
    WebElement click_mediaSelection;
    @FindBy(xpath = "//table/tbody/tr")
    List<WebElement> barisTable;
    @FindBy(xpath = "//div[contains(@class,'ant-table-body')]/child::table/child::tbody/child::tr/child::td[2]")
    List<WebElement> opsi_mediaSelection;
    @FindBy(xpath = "//input[@id=\"basic_mediaCultureReagentName\"]")
    WebElement inputselect_mediaSelection;
    
    @FindBy(xpath = "//input[@id=\"basic_mediaReplacementPercentage\"]")
    WebElement click_mediaReplacement;
    @FindBy(xpath = "//div[@title=\"100%\"]/parent::div/child::div")
    List<WebElement> opsi_mediaReplacement;
    @FindBy(xpath = "//input[@id=\"basic_mediaReplacementPercentage\"]/parent::span/parent::div/child::span[2]")
    WebElement inputselect_mediaReplacement;
    @FindBy(xpath = "//input[@data-testid=\"feeding-interval-hour\"]")
    WebElement txt_feedingInterval;

    @FindBy(xpath = "//input[@id=\"basic_enzymeCultureReagentName\"]")
    WebElement check_detachmentReagent;
    @FindBy(xpath = "//input[@data-testid=\"enzyme-culture-reagent-name\"]")
    WebElement click_detachmentReagent;
    @FindBy(xpath = "//input[@data-testid=\"enzyme-volume-micro-liter\"]")
    WebElement txt_detachmentReagentVolume;
    @FindBy(xpath = "//input[@data-testid=\"incubation-time-minute\"]")
    WebElement txt_incubationgTime;
    @FindBy(xpath = "//input[@data-testid=\"passage-ratio\"]")
    WebElement txt_pasageRatio;
    @FindBy(xpath = "//input[@data-testid=\"incubation-time-after-passage-hour\"]")
    WebElement txt_adheringTime;
    
    @FindBy(xpath = "//input[@data-testid=\"imaging-checkbox\"]")
    WebElement checkbox_imaging;
    @FindBy(xpath = "//input[@data-testid=\"imaging-interval-hour\"]")
    WebElement txt_imagingInterval;

    @FindBy(xpath = "//input[@data-testid=\"estimate-doubling-time-hour\"]")
    WebElement txt_estimateDoublingTime;
    @FindBy(xpath = "//input[@data-testid=\"cell-density-per-centimeter-square\"]")
    WebElement txt_cellDestiny;
    @FindBy(xpath = "//input[@data-testid=\"cell-dilution-ratio\"]")
    WebElement  txt_cellDulation;
    @FindBy(xpath = "//input[@data-testid=\"dye-dilution-ratio\"]")
    WebElement txt_dyeDilution;

    @FindBy(xpath = "//div[@class=\"ant-form-item-explain ant-form-item-explain-error\"]//div[@role=\"alert\"]")
    WebElement alert_req;
    @FindBy(xpath = "//div[@role=\"alert\"]")
    WebElement notif;
    @FindBy(xpath = "//div[@class=\"ant-notification ant-notification-bottomRight\"]")
    WebElement notif_alert;
    @FindBy(xpath = "//div[@class=\"ant-notification-notice-description\"]")
    WebElement desc_alert;

    protected WebDriver driver;
    protected WebDriverWait wait;

    public CreateCellLinesPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, CreateCellLinesPage.this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
    public void entersName(String inputFill) {
        txt_name.sendKeys(inputFill);
    }
    public String getName() {
        return txt_name.getAttribute("value");
    }

    public void entersOrganism(String inputFill) {
        txt_organism.sendKeys(inputFill);
    }
    public String getOrganism() {
        return txt_organism.getAttribute("value");
    }

    public void entersTissue(String inputFill) {
        txt_tissue.sendKeys(inputFill);
    }
    public String getTissue() {
        return txt_tissue.getAttribute("value");
    }

    public void entersMorphology(String inputFill) {
        txt_moprhology.sendKeys(inputFill);
    }
    public String getMorphology() {
        return txt_moprhology.getAttribute("value");
    }

    public void entersDisease(String inputFill) {
        txt_disease.sendKeys(inputFill);
    }
    public String getDisease() {
        return txt_disease.getAttribute("value");
    }

    public void entersNotes(String inputFill) {
        txt_notes.sendKeys(inputFill);
    } 
    public String getNotes() {
        return txt_notes.getText();
    }

    public void clickConfluency() {
        radio_confluency.click();
    }
    public void clickTimeInterval() {
        radio_timeInterval.click();
    }
    public void enterconfluency(String content) {
        txt_confluency.sendKeys(content);
    }
    public String getConfluencyValue() {
        return txt_confluency.getAttribute("value");
    }
    public void enterTime(String content) {
        txt_time.sendKeys(content);
    }
    public String getTimeValue() {
        return txt_time.getAttribute("value");
    }

    

    public void chooseType(String opsi) {
        click_mediaReplacement.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(opsi_mediaReplacement));
        WebElement choosen = Function.choose(opsi_mediaReplacement, opsi);
        choosen.click();
        wait.until(ExpectedConditions.attributeToBe(inputselect_mediaReplacement, "title", opsi));
    }
    public String getmediaReplacementValue() {
        return inputselect_mediaReplacement.getText();
    }

    public void enterconfeedingInterval(String content) {
        txt_feedingInterval.sendKeys(content);
    }
    public String getFeedingIntervalValue() {
        return txt_feedingInterval.getAttribute("value");
    }
    
    public void entercondetachmentReagentVolume(String content) {
        txt_detachmentReagentVolume.sendKeys(content);
    }
    public String getDetachmentReagentVolumeValue() {
        return txt_detachmentReagentVolume.getAttribute("value");
    }
    
    public void enterincubationTime(String content) {
        txt_incubationgTime.sendKeys(content);
    }
    public String getIncubationTimeValue() {
        return txt_incubationgTime.getAttribute("value");
    }
    
    public void enterpassageRatio(String content) {
        txt_pasageRatio.sendKeys(content);
    }
    public String getPassageRatioValue() {
        return txt_pasageRatio.getAttribute("value");
    }

    public void enteradheringTime(String content) {
        txt_adheringTime.sendKeys(content);
    }
    public String getAdheringTimeValue() {
        return txt_adheringTime.getAttribute("value");
    }

    public void entercellDensity(String content) {
        txt_cellDestiny.sendKeys(content);
    }
    public String getCellDensityValue() {
        return txt_cellDestiny.getAttribute("value");
    }

    public void enterestimatedDoublingTime(String content) {
        txt_estimateDoublingTime.sendKeys(content);
    }
    public String getEstimatedDoublingTimeValue() {
        return txt_estimateDoublingTime.getAttribute("value");
    }
    
    public void entercellDilutionRatio(String content) {
        txt_cellDulation.clear();
        txt_cellDulation.sendKeys(content);
    }
    public void enterdyedilutionratio(String content) {
        txt_dyeDilution.clear();
        txt_dyeDilution.sendKeys(content);
    }
    public String getCellDilutionRatioValue() {
        return txt_cellDulation.getAttribute("value");
    }
    public String getDyedilutionratioValue() {
        return txt_dyeDilution.getAttribute("value");
    }

    public void enterimagingInterval(String content) {
        txt_imagingInterval.sendKeys(content);
    }
    public String getImagingIntervalValue() {
        return txt_imagingInterval.getAttribute("value");
    }

    public String getmediaSelectionValue() {
        return inputselect_mediaSelection.getAttribute("value");
    }

    public void selectDetachmentReagent(String itemName1) {
        click_detachmentReagent.click();
        for (int i = 1; i <= barisTable.size(); i++) {
            WebElement name_row = driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[2]"));
            String label = name_row.getText();
            System.out.println(label);
            if (label.equals(itemName1)) {
                WebElement choosen = driver.findElement(By.xpath("//table/tbody/tr["+i+"]"));
                choosen.click();
                break;
            } 
        }
     
    }

    public String getdetachmentReagentValue() {
        return click_detachmentReagent.getAttribute("value");
    }

  
    public Boolean checkalert() {
        wait.until(ExpectedConditions.visibilityOf(alert_req));
        return alert_req.isDisplayed();
    }
    public String getalert() {
        return alert_req.getText();
    }
    public String getdesc() {
        return desc_alert.getText();
    }
    
    public boolean check_notif(){
            wait.until(ExpectedConditions.visibilityOf(notif_alert));
            return notif_alert.isDisplayed();
    }

    public void clickimagingInterval() {
        checkbox_imaging.click();
    }
}
