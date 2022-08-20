package stepDefinition.Reagent.ReagentLibrary;

import static org.junit.Assert.assertEquals;

import java.util.List;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pageObject.reagent.ReagentLibrary.CreateReagentLibraryPage;

public class CreateReagentLibraryStep {
    
    private CreateReagentLibraryPage createReagentPage = new CreateReagentLibraryPage(DriverFactory.getDriver());

    @When("user fill the form in Create Reagent page with this data")
    public void user_fill_the_form_in_create_reagent_page_with_this_data(DataTable dataTable) {
        List<String> data = dataTable.row(0);
        List<String> newdata = dataTable.row(1);
        for (int i = 0; i < data.size(); i++) {
            String inputName = data.get(i);
            String inputFill = newdata.get(i);
            if (inputName.equalsIgnoreCase("nama")) {
                createReagentPage.entersName(inputFill);
            } else if (inputName.equalsIgnoreCase("type")) {
                createReagentPage.chooseType(inputFill);
            } else if (inputName.equalsIgnoreCase("note")) {
                createReagentPage.entersNotes(inputFill);
            }
        }
    }
    @Then("all fields in Create Reagent page is filled with this data")
    public void all_fields_in_create_reagent_page_is_filled_with_this_data(DataTable dataTable) {
        List<String> data = dataTable.row(0);
        List<String> newdata = dataTable.row(1);
        for (int i = 0; i < data.size(); i++) {
            String inputName = data.get(i);
            String inputFill = newdata.get(i);
            if (inputName.equalsIgnoreCase("nama")) {
                assertEquals(inputFill, createReagentPage.getNameValue());
            } else if (inputName.equalsIgnoreCase("type")) {
                assertEquals(inputFill, createReagentPage.getTypeValue());
            } else if (inputName.equalsIgnoreCase("note")) {
                assertEquals(inputFill, createReagentPage.getNotesValue());
            }
        }
    }
}
