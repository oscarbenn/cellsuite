package stepDefinition;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.DashboardPage;
import pageObject.LoginPage;

public class Steps {
    WebDriver driver = null;
    
    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Before
    public void browserSetup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
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
    @Then("user is on login page")
    public void user_is_on_login_page() {
        assertTrue(loginPage.checkLoginButton()); 
    }
    @When("user enters username as {string} and password as {string}")
    public void user_enters_username_as_and_password_as(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }
    @When("user clicks on signIn button")
    public void user_clicks_on_sign_in_button() {
        loginPage.clickButtonLogin();
        dashboardPage = new DashboardPage(driver);
    }
    @Then("user is navigated to home page")
    public void user_is_navigated_to_home_page() {
        assertTrue(dashboardPage.checkbtnlogout());
    }
}
