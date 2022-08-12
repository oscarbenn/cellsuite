package stepDefinition;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import pageObject.reagent.CreateReagentCulturePage;
import pageObject.reagent.ReagentCulturePage;

public class ReagentCulturePageStep {
    
    private ReagentCulturePage reagentCulturePage = new ReagentCulturePage(DriverFactory.getDriver());
    private CreateReagentCulturePage createReagentCulturePage = new CreateReagentCulturePage(DriverFactory.getDriver());

    @Then("user is navigated to Culture Reagent page")
    public void user_is_navigated_to_Culture_Reagent_page() {
        assertEquals("Culture Reagent", reagentCulturePage.getTitleofPage());
    }

    @Then("There is new {string} item created with {string} composition named as {string}")
    public void there_is_new_item_created_with_composition(String item, String composition, String itemName) {
        if (item.equalsIgnoreCase("culture reagent")) {
            reagentCulturePage.clickbtnMenu("Reagent");
            reagentCulturePage.clickbtnSubMenu("Culture Reagent");
            assertEquals(itemName, reagentCulturePage.getTopReagentCulture());
            assertTrue(reagentCulturePage.getCompositionOfReagentCulture(composition)); 
        }
    }

    @When("user clicks on {string} button in Culture Reagent page")
    public void user_clicks_on_button_in_culture_reagent_page(String button) {
        switch (button) {
            case "Create":
                createReagentCulturePage = reagentCulturePage.clickButtonCreate();
                break;
            case "edit":
                //editReagentCulturePage = reagentCulturePage.clickButtonEdit();
                break;
            case "delete":
                reagentCulturePage.clickButtonDelete();
            default:
                System.out.println("salah");
        }
    }
   
    @When("user type on {string} textbox Culture Reagent as {string}")
    public void user_type_on_textbox_culture_reagent_as(String textbox, String fill) {
        switch (textbox) {
            case "name":
                createReagentCulturePage.entersName(fill);
                break;
            case "notes":
                createReagentCulturePage.entersNotes(fill);
                break;
            default:
                break;
        }
    }
    @Then("{string} textbox in page Create Culture Reagent filled by {string}")
    public void textbox_in_page_create_culture_reagent_filled_by(String textbox, String fill) {
        switch (textbox) {
            case "name":
                assertEquals(fill, createReagentCulturePage.getNameValue());
                break;
            case "notes":
                assertEquals(fill, createReagentCulturePage.getNotesValue());
                break;
            default:
                break;
        }
    }
    @When("user select reagent compotition {string} and type {string} in persentage")
    public void user_select_reagent_compotition_and_type_in_persentage(String composition, String persen) {
        createReagentCulturePage.chooseComposition(composition, persen);
    }
    @Then("composition reagent selected is {string}")
    public void composition_reagent_selected_is(String composition) {
        assertEquals(composition, createReagentCulturePage.getCompositionValue());
    }
    @Then("accepted total volume of reagent is {string}")
    public void accepted_total_volume_of_reagent_is(String persen) {
        assertEquals(persen, createReagentCulturePage.getPersenValue());
    }
    @Then("new Culture Reagent item is created with named is {string}")
    public void new_culture_reagent_item_is_created_with_named_is(String string) {
        
    }

}
