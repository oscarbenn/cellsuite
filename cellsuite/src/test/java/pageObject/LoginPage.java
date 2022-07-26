package pageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    @FindBy(id = "userName")
    WebElement txt_username;
    @FindBy(id = "password")
    WebElement txt_password;
    @FindBy(xpath = "//button[@type=\"submit\"]")
    WebElement btn_login;

    protected WebDriver driver;
    protected WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, LoginPage.this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }

    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOf(txt_username));
        txt_username.sendKeys(username);
    }

    public void enterPassword(String password) {
        txt_password.sendKeys(password);
    }

    public void clickButtonLogin() {
        btn_login.click();
        wait.until(ExpectedConditions.invisibilityOf(btn_login));
    }

    public Boolean checkLoginButton(){
        return btn_login.isDisplayed();
    }
}
