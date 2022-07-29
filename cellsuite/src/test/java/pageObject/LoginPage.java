package pageObject;

import java.time.Duration;

import org.bouncycastle.pqc.jcajce.provider.rainbow.SignatureSpi.withSha224;
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
    @FindBy(xpath = "//button[@data-testid=\"login-button\"]")
    WebElement btn_login;
    @FindBy(xpath = "//div[@role=\"alert\"]")
    WebElement err_massage;

    protected WebDriver driver;
    protected WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, LoginPage.this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterUsername(String username) {
        txt_username.sendKeys(username);
    }

    public void enterPassword(String password) {
        txt_password.sendKeys(password);
    }

    public void clickButtonLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(btn_login));
        btn_login.click();
    }

    public Boolean checkLoginButton(){
        return btn_login.isDisplayed();
    }

    public String getNotificationError() {
        wait.until(ExpectedConditions.visibilityOf(err_massage));
        return err_massage.getText();
    }

    public String getValidationError() {
        wait.until(ExpectedConditions.visibilityOf(err_massage));
        return err_massage.getText();
    }
}
