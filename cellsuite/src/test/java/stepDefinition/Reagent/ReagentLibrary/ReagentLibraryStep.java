package stepDefinition.Reagent.ReagentLibrary;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import pageObject.reagent.ReagentLibraryPage;

public class ReagentLibraryStep {
    
    private ReagentLibraryPage reagentLibraryPage = new ReagentLibraryPage(DriverFactory.getDriver());
    
    // @Then("There is no new {string} item created")
    // public void there_is_no_new_item_created(String item) {
    //     if (item.equalsIgnoreCase("culture reagent")) {
    //         reagentLibraryPage.clickbtnMenu("Reagent");
    //         reagentLibraryPage.clickbtnSubMenu("Culture Reagent");
    //         //reagentCulturePage = new ReagentCulturePage(driver);
    //         //assertNotEquals(new_reagent, reagentCulturePage.getTopReagentCulture()); 
    //     }
    // }

    @Then("reagent items is already exist")
    public void reagent_items_is_already_exist() {
        assertTrue(reagentLibraryPage.checkItemIsExist());
    }
    @When("user select an reagent item {string} by check the checkbox")
    public void user_select_an_reagent_item_by_check_the_checkbox(String itemName) {
        reagentLibraryPage.selectItemByName(itemName);
    }
    @Then("reagent checkbox {string} item is checked")
    public void reagent_checkbox_item_is_checked(String itemName) {
        assertTrue(reagentLibraryPage.checkItemIsSelected(itemName));
    }
    
    @Then("reagent is updated and saved with name {string} and note {string}")
    public void reagent_is_updated_and_saved_with_name_and_note(String name, String string2) {
        
    }

    @Then("there is no item reagent {string}")
    public void there_is_no_item_reagent(String item) {
        assertNull(reagentLibraryPage.getItem(item));
    }
    @When("user refresh the browser page")
    public void user_refresh_the_browser_page() {
        DriverFactory.getDriver().navigate().refresh();        
    }
    

}
