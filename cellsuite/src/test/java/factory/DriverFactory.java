package factory;

import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
    
    public WebDriver driver;
    public static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>(); 

    public WebDriver init_driver(String browser, String option){
        System.out.println("browser value is: " + browser + option);
        if (option.equals("headless")) {
            if (browser.equals("chrome")) {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");
                options.addArguments("--disable-gpu");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--window-size=1920,1080");
                threadLocalDriver.set(new ChromeDriver(options));
            } else if (browser.equals("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                threadLocalDriver.set(new FirefoxDriver());
            } else if (browser.equals("edge")) {
                WebDriverManager.edgedriver().setup();
                threadLocalDriver.set(new EdgeDriver());
            } else {
                System.out.println("Please pass the correct browser value: " + browser);
            }

            // Dimension window = new Dimension(1920, 1080);
            // getDriver().manage().window().setSize(window);

        } else {
            if (browser.equals("chrome")) {
                WebDriverManager.chromedriver().setup();
                threadLocalDriver.set(new ChromeDriver());
            } else if (browser.equals("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                threadLocalDriver.set(new FirefoxDriver());
            } else if (browser.equals("edge")) {
                WebDriverManager.edgedriver().setup();
                threadLocalDriver.set(new EdgeDriver());
            } else {
                System.out.println("Please pass the correct browser value: " + browser);
            }
            getDriver().manage().window().maximize();
        }
        
        getDriver().manage().deleteAllCookies();
        getDriver().manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        return getDriver();

    }

    public static synchronized WebDriver getDriver(){
        return threadLocalDriver.get();
    }
}