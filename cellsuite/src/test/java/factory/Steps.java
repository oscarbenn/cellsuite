package factory;

import static org.junit.Assert.*;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.DashboardPage;
import pageObject.LoginPage;
import pageObject.cellLine.CellLinePage;
import pageObject.cellLine.CreateCellLinesPage;
import pageObject.reagent.CreateReagentLibraryPage;
import pageObject.reagent.EditReagentLibraryPage;
import pageObject.reagent.ReagentCulturePage;
import pageObject.reagent.ReagentLibraryPage;

public class Steps {
    WebDriver driver = null;
    LoginPage loginPage;
    DashboardPage dashboardPage;
    ReagentLibraryPage reagentLibraryPage;
    CreateReagentLibraryPage createReagentPage;
    ReagentCulturePage reagentCulturePage;
    EditReagentLibraryPage editReagentPage;
    CellLinePage cellLinePage;
    CreateCellLinesPage createCellLinesPage;

    String new_reagent;
    String url = "http://localhost:5050";
    
    @Before
    public void browserSetup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        // ChromeOptions options = new ChromeOptions();
        // options.addArguments("--headless");
        // driver = new ChromeDriver(options);
        // Dimension window = new Dimension(1920, 1080);
        // driver.manage().window().setSize(window);

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(25));

        // loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        reagentLibraryPage = new ReagentLibraryPage(driver);
        createReagentPage = new CreateReagentLibraryPage(driver);
        reagentCulturePage = new ReagentCulturePage(driver);
        editReagentPage = new EditReagentLibraryPage(driver);
        cellLinePage = new CellLinePage(driver);
        createCellLinesPage = new CreateCellLinesPage(driver);
    }

    @After
    public void teardown(){
        driver.close();
        driver.quit();
    }

    @Given("user is navigated to website")
    public void user_is_navigated_to_website() {
        driver.get(url);
        //loginPage = new LoginPage(driver);
    }
    @When("user enters username as {string}")
    public void user_enters_username_as(String username) {
        loginPage.enterUsername(username);
    }
    @And("user enters password as {string}")
    public void user_enters_password_as(String password) {
        loginPage.enterPassword(password);
    }
    

    @When("user clicks on menu {string}")
    public void user_clicks_on_menu(String menu) {
        dashboardPage.clickbtnMenu(menu);
    }
    @When("user clicks on sub-menu {string}")
    public void user_clicks_on_sub_menu(String submenu) {
        if (submenu.equalsIgnoreCase("Library")) {
            dashboardPage.clickbtnSubMenu(submenu);
            //reagentLibraryPage = new ReagentLibraryPage(driver);
        } else{System.out.println("salah");}
    }
    @When("user type reagent {string} as {string}")
    public void user_type_reagent_as(String textbox, String fill) {
        if (textbox.equalsIgnoreCase("name")) {
            createReagentPage.entersName(fill);
            new_reagent = fill;
        } else if (textbox.equalsIgnoreCase("note")) {
            createReagentPage.entersNotes(fill);
        } else{System.out.println("salah");}
    }
    @Then("{string} is typed on {string} textbox")
    public void is_typed_on_textbox(String fill, String textbox) {
        if (textbox.equalsIgnoreCase("name")) {
            assertEquals(fill, createReagentPage.getNameValue()); 
        } else if (textbox.equalsIgnoreCase("note")) {
            assertEquals(fill, createReagentPage.getNotesValue());
        } else{System.out.println("salah");}
    }
    @When("user check {string} on checkbox")
    public void user_check_on_checkbox(String checkbox) {
        if (checkbox.equalsIgnoreCase("create culture reagent")) {
            createReagentPage.checkCreateCultureReagent();            
        }
    }
    @Then("checkbox {string} is checked")
    public void checkbox_is_checked(String checkbox) {
        if (checkbox.equalsIgnoreCase("create culture reagent")) {           
        }
    }
    @When("user select {string} on {string}")
    public void user_select_on(String opsi, String selectbox) {
        if (selectbox.equalsIgnoreCase("type")) {
            createReagentPage.chooseType(opsi);
        } else{System.out.println("salah");}
    }
    @Then("{string} is selected on {string}")
    public void is_selected_on(String opsi, String selectbox) {
        if (selectbox.equalsIgnoreCase("type")) {
            assertEquals(opsi, createReagentPage.getTypeValue());
        } else{System.out.println("salah");}
    }
   
    @Then("{string} items is already exist")
    public void items_is_already_exist(String itemTable) {
        if (itemTable.equalsIgnoreCase("Reagent")) {
            assertTrue(reagentLibraryPage.checkItemIsExist());
        }
    }
    @When("user select an {string} item {string} by check the checkbox")
    public void user_select_an_item_by_check_the_checkbox(String item, String itemName) {
        if (item.equalsIgnoreCase("reagent")) {
            reagentLibraryPage.selectItemByName(itemName);
        }
    }
    @Then("{string} checkbox {string} item is checked")
    public void checkbox_item_is_checked(String item, String itemName) {
        if (item.equalsIgnoreCase("reagent")) {
            assertTrue(reagentLibraryPage.checkItemIsSelected(itemName));
        }
    }
    
    @When("user change {string} with {string}")
    public void user_change_with(String textbox, String fill) {
        if (textbox.equalsIgnoreCase("name")) {
            editReagentPage.changeNameWith(fill);
        } else if (textbox.equalsIgnoreCase("note")) {
            editReagentPage.changeNoteWith(fill);
        }
    }
    
    @Then("reagent is updated and saved with name {string} and note {string}")
    public void reagent_is_updated_and_saved_with_name_and_note(String name, String notes) {
        
    }



    @When("user click {string} button on Cell Line page")
    public void user_click_button_on_cell_line_page(String button) {
        if (button.equalsIgnoreCase("Create")) {
            cellLinePage.clickButtonCreate();
        }
    }

    @When("user fill all the fields according to its data type on create cell lines page")
    public void user_fill_all_the_fields_according_to_its_data_type_on_create_cell_lines_page(DataTable dataTable) {
        List<String> data = dataTable.row(0);
        List<String> newdata = dataTable.row(1);
        for (int i = 0; i < data.size(); i++) {
            String inputName = data.get(i); 
            String inputFill = newdata.get(i);
            if (inputName.equalsIgnoreCase("Name")) {
                createCellLinesPage.entersName(inputFill);
            } else if (inputName.equalsIgnoreCase("Disease")) {
                createCellLinesPage.entersDisease(inputFill);
            } else if (inputName.equalsIgnoreCase("Notes")){
                createCellLinesPage.entersNotes(inputFill);
            } else if (inputName.equalsIgnoreCase("Organism")) {
                createCellLinesPage.entersOrganism(inputFill);
            } else if (inputName.equalsIgnoreCase("Tissue")) {
                createCellLinesPage.entersTissue(inputFill);
            } else if (inputName.equalsIgnoreCase("Morphology")) {
                createCellLinesPage.entersMorphology(inputFill);
            } else if (inputName.equalsIgnoreCase("Time")){
                createCellLinesPage.enterTime(inputFill);
            } else if(inputName.equalsIgnoreCase("FeedingInterval")){
                createCellLinesPage.enterconfeedingInterval(inputFill);
            } else if(inputName.equalsIgnoreCase("DetachmentReagentVolume")){
                createCellLinesPage.entercondetachmentReagentVolume(inputFill);
            } else if(inputName.equalsIgnoreCase("IncubationTime")){
                createCellLinesPage.enterincubationTime(inputFill);
            } else if(inputName.equalsIgnoreCase("passageRatio")){
                createCellLinesPage.enterpassageRatio(inputFill);
            } else if(inputName.equalsIgnoreCase("adheringTime")){
                createCellLinesPage.enteradheringTime(inputFill);
            } else if(inputName.equalsIgnoreCase("imagingInterval")){
                createCellLinesPage.enterimagingInterval(inputFill);
            } else if(inputName.equalsIgnoreCase("estimatedDoublingTime")){
                createCellLinesPage.enterestimatedDoublingTime(inputFill);
            } else if(inputName.equalsIgnoreCase("cellDensity")){
                createCellLinesPage.entercellDensity(inputFill);
            } else if(inputName.equalsIgnoreCase("cellDilutionRatio")){
                createCellLinesPage.entercellDilutionRatio(inputFill);
                assertEquals(inputFill, createCellLinesPage.getCellDilutionRatioValue());
            } else if(inputName.equalsIgnoreCase("dyedilutionratio")){
                createCellLinesPage.enterdyedilutionratio(inputFill);
                assertEquals(inputFill, createCellLinesPage.getDyedilutionratioValue());
            }
        }
    }

    @Then("all fields is filled with data which typed")
    public void all_fields_is_filled_with_data_which_typed(DataTable dataTable) {
        List<String> data = dataTable.row(0);
        List<String> newdata = dataTable.row(1);
        for (int i = 0; i < data.size(); i++) {
            String inputName = data.get(i); 
            String inputFill = newdata.get(i);
            if (inputName.equalsIgnoreCase("Name")) {
                assertEquals(inputFill, createCellLinesPage.getName());
            } else if (inputName.equalsIgnoreCase("Disease")) {
                assertEquals(inputFill, createCellLinesPage.getDisease());
            } else if (inputName.equalsIgnoreCase("Notes")){
                assertEquals(inputFill, createCellLinesPage.getNotes());
            } else if (inputName.equalsIgnoreCase("Organism")) {
                assertEquals(inputFill, createCellLinesPage.getOrganism());
            } else if (inputName.equalsIgnoreCase("Tissue")) {
                assertEquals(inputFill, createCellLinesPage.getTissue());
            } else if (inputName.equalsIgnoreCase("Morphology")) {
                assertEquals(inputFill, createCellLinesPage.getMorphology());
            }
        }
    }

}
