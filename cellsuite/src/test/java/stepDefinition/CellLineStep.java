package stepDefinition;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.cellLine.CellLinePage;
import pageObject.cellLine.CreateCellLinesPage;

public class CellLineStep {
    
    CreateCellLinesPage createCellLinesPage = new CreateCellLinesPage(DriverFactory.getDriver());
    CellLinePage cellLinePage = new CellLinePage(DriverFactory.getDriver());

    List<String> cellItemUsedInInventory;

    @When("user type cell line confluency as {string}")
    public void user_type_cell_line_confluency_as(String content){
        createCellLinesPage.enterconfluency(content);
    }

    @Then("cell line confluency is filled by {string}")
    public void cell_line_confluency_is_filled_by(String content){
        createCellLinesPage.getConfluencyValue();
    }

    @When("user select {string} on Media Replacement persentage")
    public void user_select_on_media_replacement_persentage(String persen){
        createCellLinesPage.selectMediaReplacement(persen);
    }

    @Then("Media Replacement persentage filled by {string}")
    public void media_replacement_persentage_filled_by(String persen){
        assertEquals(persen, createCellLinesPage.getMediaReplacementValue());
    }

    @And("checkbox {string} is disable")
    public void checkbox_is_disable(String checkbox){
        assertFalse(createCellLinesPage.checkboxImagingIsEnabled());
    }

    @When("user type on box Imaging Interval as {string}")
    public void user_type_on_box_imaging_interval_as(String content){
        createCellLinesPage.enterImagingInterval(content);
    }

    @Then("box Imaging Interval filled by {string}")
    public void box_Imaging_interval_filled_by(String content){
        assertEquals(content, createCellLinesPage.getImagingIntervalValue());
    }

    @When("user {string} on box Cell Dye Ratio as {string} to {string}")
    public void user_on_box_cell_dye_ratio_as_to(String action, String n, String m){
        createCellLinesPage.entercellDilutionRatio(n);
        createCellLinesPage.enterdyedilutionratio(m);
    }

    @Then("box Cell Dye Ratio filled by {string} to {string}")
    public void box_cell_dye_ratio_filled_by_to(String n, String m){
        assertEquals(n, createCellLinesPage.getCellDilutionRatioValue());
        assertEquals(m, createCellLinesPage.getDyedilutionratioValue());
    }

    @And("alert Required is displayed on bottom of {string}")
    public void alert_required_is_displayed_on_bottom_of_box(String box){
        switch (box) {
            case "Passage After":
                assertTrue(createCellLinesPage.alertPassageAfterIsDisplayed());
                break;
            case "Imaging Interval":
                assertTrue(createCellLinesPage.alertImagingIntervalIsDisplayed());
                break;
            default:
                break;
        }
    }

    @When("user type cell line time interval as {string}")
    public void user_type_cell_line_time_interval_as(String content){
        createCellLinesPage.enterTime(content);
    }

    @Then("cell line time interval is filled by {string}")
    public void cell_line_time_interval_is_filled_by(String content){
        assertEquals(content, createCellLinesPage.getTimeValue());
    }

    @And("checkbox {string} is enable")
    public void checkbox_is_enable(String checkbox){
        assertTrue(createCellLinesPage.checkboxImagingIsEnabled());
    }

    @Then("box Imaging Interval is disabled")
    public void box_imaging_interval_is_disabled(){
        assertFalse(createCellLinesPage.imagingIntervalIsEnabled());
    }

    @When("user select cell line item which already used in inventory")
    public void user_select_cell_line_item_which_already_used_in_inventory(){
        
    }

    @Then("the item which already used in inventory is checked")
    public void the_item_which_already_used_in_inventory_is_checked(){

    }
}

