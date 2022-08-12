package stepDefinition;

import java.util.Properties;
import org.openqa.selenium.WebDriver;

import factory.ConfigReader;
import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class ApplicationHooks {
    private DriverFactory driverFactory;
    private WebDriver driver;
    private ConfigReader configReader;
    Properties prop;
    
    String url = "http://localhost:5050";

    @Before(order = 0)
    public void getProperty(){
        configReader = new ConfigReader();
        prop = configReader.init_prop();
    }

    @Before(order = 1)
    public void launchBrowser(){
        String browserName = prop.getProperty("browser");
        driverFactory = new DriverFactory();
        driver = driverFactory.init_driver(browserName);
        driver.get(url);
    }

    @After(order = 0)
    public void quitBrowser(){
        driver.close();
        driver.quit();
    }

    // @After(order = 1)
    // public void tearDown(Scenario scenario){
    //     if (scenario.isFailed()) {
    //         String screenshotName = scenario.getName().replaceAll("", "_");
    //         byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    //         scenario.attach(sourcePath, "image/png", screenshotName);
    //     }
    // }
}
