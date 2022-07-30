package pageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
    
    @FindBy(xpath = "//span[@class='app-title']")
    WebElement title_app;
    @FindBy(xpath = "//div[@class=\"logout-button\"]")
    WebElement btn_logout;
    @FindBy(xpath = "//ul[@role=\"menu\"]/li")
    List<WebElement> menu_elements;
    @FindBy(xpath = "//ul[@role=\"menu\"]/li/ul/li")
    List<WebElement> submenu_elements;

    protected WebDriver driver;
    protected WebDriverWait wait;

    public DashboardPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, DashboardPage.this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public Boolean checktitleapp(){
        wait.until(ExpectedConditions.visibilityOf(title_app));
        return title_app.isDisplayed();
    }

    public void clickbtnMenu(String menu) {
        WebElement choosen = choose(menu_elements, menu);
        choosen.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(submenu_elements));
    }

    private WebElement choose(List<WebElement> elements, String elementText) {
        WebElement choosenElement = null;
        for (int i = 0; i < elements.size(); i++) {
            WebElement element = elements.get(i);
            String label = element.getText();
            if (label.equals(elementText)) {
                choosenElement = element;
            }
        }
        return choosenElement;
    }

    public void clickbtnSubMenu(String submenu) {
        WebElement choosen = choose(submenu_elements, submenu);
        choosen.click();
    }
}
