package stepDefinition.Reagent.ReagentLibrary;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import pageObject.reagent.EditReagentLibraryPage;

public class EditReagentLibraryStep {
    private EditReagentLibraryPage editReagentLibraryPage = new EditReagentLibraryPage(DriverFactory.getDriver());

    @When("user change {string} with {string}")
    public void user_change_with(String textbox, String fill) {
        if (textbox.equalsIgnoreCase("name")) {
            editReagentLibraryPage.changeNameWith(fill);
        } else if (textbox.equalsIgnoreCase("note")) {
            editReagentLibraryPage.changeNoteWith(fill);
        }
    }
}
