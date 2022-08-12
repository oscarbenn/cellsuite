package factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.edge.EdgeDriver;
// import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
    
    public static WebDriver driver;
    // public static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>(); 

    public WebDriver init_driver(String browser){
        System.out.println("browser value is: " + browser);
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            // threadLocalDriver.set(new ChromeDriver());
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            // threadLocalDriver.set(new FirefoxDriver());
        } else if (browser.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            // threadLocalDriver.set(new EdgeDriver());
        } else {
			System.out.println("Please pass the correct browser value: " + browser);
		}
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        return driver;
        // getDriver().manage().deleteAllCookies();
        // getDriver().manage().window().maximize();
        // getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        // getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        // return getDriver();
    }

    public static WebDriver getDriver(){
        return driver;
    }

    // public static synchronized WebDriver getDriver(){
    //     System.out.println(threadLocalDriver.get());
    //     return threadLocalDriver.get();
    // }

    //apa itu synchronized
    //threadlocal?

}
