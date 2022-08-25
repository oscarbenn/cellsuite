package stepDefinition;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.ConfigReader;
import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {
    private DriverFactory driverFactory;
    private WebDriver driver;
    private ConfigReader configReader;
    Properties prop;
    
    String url = "http://localhost:5050";
    // String url = "http://cygnus.local:5050";

    @Before(order = 0)
    public void getProperty(){
        configReader = new ConfigReader();
        prop = configReader.init_prop();
    }

    @Before(order = 1)
    public void launchBrowser(){
        String browserName = prop.getProperty("browser");
        String optionBrowser = prop.getProperty("option");
        driverFactory = new DriverFactory();
        driver = driverFactory.init_driver(browserName,optionBrowser);
        driver.get(url);
    }

    @After(order = 0)
    public void quitBrowser(){
        driver.close();
        driver.quit();
    }

    @After(order = 1)
    public void tearDown(Scenario scenario) throws IOException{
        if (scenario.isFailed()) {
            String screenshotName = scenario.getName();
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("output/screenshot/"+screenshotName+".png"));
        }
    }
}
