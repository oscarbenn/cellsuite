package stepDefinition.Reagent;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import pageObject.reagent.CultureReagent.CreateReagentCulturePage;
import pageObject.reagent.CultureReagent.ReagentCulturePage;

public class ReagentCulturePageStep {
    
    private ReagentCulturePage reagentCulturePage = new ReagentCulturePage(DriverFactory.getDriver());
    private CreateReagentCulturePage createReagentCulturePage = new CreateReagentCulturePage(DriverFactory.getDriver());

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

    @Then("There is new {string} item created with {string} composition named as {string}")
    public void there_is_new_item_created_with_composition(String item, String composition, String itemName) {
        if (item.equalsIgnoreCase("culture reagent")) {
            reagentCulturePage.clickbtnMenu("Reagent");
            reagentCulturePage.clickbtnSubMenu("Culture Reagent");
            assertEquals(itemName, reagentCulturePage.getTopReagentCulture());
            assertTrue(reagentCulturePage.getCompositionOfReagentCulture(composition)); 
        }
    }

}
