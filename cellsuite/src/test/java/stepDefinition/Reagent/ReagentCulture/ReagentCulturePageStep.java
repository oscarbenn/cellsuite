package stepDefinition.Reagent.ReagentCulture;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import pageObject.reagent.CultureReagent.ReagentCulturePage;

public class ReagentCulturePageStep {
    
    private ReagentCulturePage reagentCulturePage = new ReagentCulturePage(DriverFactory.getDriver());

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
