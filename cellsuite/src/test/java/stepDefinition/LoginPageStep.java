package stepDefinition;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pageObject.LoginPage;

public class LoginPageStep {

	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	
	@Then("user is on Login page")
    public void user_is_on_Login_page() {
        assertTrue(loginPage.checkLoginButton());
	}
    @When("user enters username as {string}")
	public void user_enters_username(String username) {
		loginPage.enterUsername(username);
	}
	@When("user enters password as {string}")
	public void user_enters_password(String password) {
		loginPage.enterPassword(password);
	}
	@When("user clicks on {string} button in Login Page")
	public void user_clicks_on_button_in_Login_Page(String button) {
		switch (button) {
			case "SignIn":
				loginPage.clickButtonLogin();
				break;
			default:
				break;
		}
	}
	@Given("user has already logged in to application with this credentials")
    public void user_has_already_logged_in_to_application_with_this_credentials(DataTable credTable) {
        List<Map<String, String>> credList = credTable.asMaps();
        String username = credList.get(0).get("username");
        String password = credList.get(0).get("password");
        loginPage.doLogin(username, password);
    }
	@Then("error notification {string} is displayed in Login page")
    public void error_notification_is_displayed_in_Login_page(String errorExpected) {
        assertEquals(errorExpected, loginPage.getNotificationError()); 
    }
    @Then("error validation {string} is displayed in Login page")
    public void error_validation_is_displayed_in_Login_page(String errorExpected) {
        assertEquals(errorExpected, loginPage.getValidationError()); 
    }	
}
