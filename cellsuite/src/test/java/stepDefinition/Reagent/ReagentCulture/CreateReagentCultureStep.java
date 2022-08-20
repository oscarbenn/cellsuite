package stepDefinition.Reagent.ReagentCulture;

import static org.junit.Assert.assertEquals;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import pageObject.reagent.CultureReagent.CreateReagentCulturePage;

public class CreateReagentCultureStep {
    
    CreateReagentCulturePage createReagentCulturePage = new CreateReagentCulturePage(DriverFactory.getDriver());

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
}
