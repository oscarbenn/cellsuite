package stepDefinition;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.CreateReagentPage;
import pageObject.DashboardPage;
import pageObject.LoginPage;
import pageObject.ReagentLibraryPage;

public class Steps {
    WebDriver driver = null;
    LoginPage loginPage;
    DashboardPage dashboardPage;
    ReagentLibraryPage reagentLibraryPage;
    CreateReagentPage createReagentPage;

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
    }

    @After
    public void teardown(){
        driver.close();
        driver.quit();
    }

    @Given("user is navigated to website {string}")
    public void user_is_navigated_to_website(String url) {
        driver.get(url);
        loginPage = new LoginPage(driver);
    }
    @When("user enters username as {string}")
    public void user_enters_username_as(String username) {
        loginPage.enterUsername(username);
    }
    @And("user enters password as {string}")
    public void user_enters_password_as(String password) {
        loginPage.enterPassword(password);
    }
    @And("user clicks on {string} button")
    public void user_clicks_on_button(String button) {
        if (button.equalsIgnoreCase("SignIn")) {
            loginPage.clickButtonLogin();
            dashboardPage = new DashboardPage(driver);
        } else if (button.equalsIgnoreCase("Create Reagent")) {
            reagentLibraryPage.clickButtonCreate();
            createReagentPage = new CreateReagentPage(driver);
        } else if (button.equalsIgnoreCase("Save")) {
            createReagentPage.clickbtnsave();
            reagentLibraryPage = null;
            reagentLibraryPage = new ReagentLibraryPage(driver);
        } else{System.out.println("salah");}
    }
    @Then("user is navigated to {string} page")
    public void user_is_navigated_to_page(String page) {
        if (page.equalsIgnoreCase("Login")) {
            assertTrue(loginPage.checkLoginButton());
        }else if (page.equalsIgnoreCase("Dashboard")) {
            assertTrue(dashboardPage.checkbtnlogout());
        } else if (page.equalsIgnoreCase("Reagent Library")){
            assertEquals(page, reagentLibraryPage.getTitleofPage());
        } else if (page.equalsIgnoreCase("Create Reagent")) {
            assertEquals(page, createReagentPage.gettitleapp());
        } else{System.out.println("salah");}
    }
    @Then("error notification {string} is displayed")
    public void error_notification_is_display(String errorExpected) {
        assertEquals(errorExpected, loginPage.getNotificationError()); 
    }
    @Then("error validation {string} is display")
    public void error_validation_is_display(String errorExpected) {
        assertEquals(errorExpected, loginPage.getValidationError()); 
    }

    @When("user clicks on menu {string}")
    public void user_clicks_on_menu(String menu) {
        dashboardPage.clickbtnMenu(menu);
    }
    @When("user clicks on sub-menu {string}")
    public void user_clicks_on_sub_menu(String submenu) {
        if (submenu.equalsIgnoreCase("Library")) {
            dashboardPage.clickbtnSubMenu(submenu);
            reagentLibraryPage = new ReagentLibraryPage(driver);
        } else{System.out.println("salah");}
    }
    @When("user type reagent {string} as {string}")
    public void user_type_reagent_as(String textbox, String fill) {
        if (textbox.equalsIgnoreCase("name")) {
            createReagentPage.entersName(fill);
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
    @Then("new {string} item is created with notification {string} and {string}")
    public void new_item_is_created_with_notification_and(String item, String notif, String desc) {
        if (item.equalsIgnoreCase("reagent")) {
            assertTrue(reagentLibraryPage.checknotif());
            assertEquals(notif, reagentLibraryPage.getNotifMsg());
            assertEquals(desc, reagentLibraryPage.getDescNotif());
        } else{System.out.println("salah");}
    }
    @Then("There is no new {string} item created")
    public void there_is_no_new_item_created(String item) {
        
    }


}
