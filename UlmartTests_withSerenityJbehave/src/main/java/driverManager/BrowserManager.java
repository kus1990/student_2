package driverManager;

import helpers.PropertyLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Мастер on 21.11.2016.
 */
public class BrowserManager {
    public enum Browsers {
        Chrome,
        Firefox
    }

    public static WebDriver getWebDriver(){
        WebDriver driver;
        String workingDir = System.getProperty("user.dir");
        String brow = PropertyLoader.loadProperty("browser");
        Browsers currentBrowser = Browsers.valueOf(brow);
        switch (currentBrowser){
            case Firefox:
                System.setProperty("webdriver.firefox.marionette", workingDir + "\\drivers\\geckodriver.exe");
                driver = new FirefoxDriver();
                return driver;
            case Chrome:
                System.setProperty("webdriver.chrome.driver", workingDir + "\\drivers\\chromedriver.exe");
                driver = new ChromeDriver();
                return driver;
            default:
                System.setProperty("webdriver.chrome.driver", workingDir + "\\drivers\\chromedriver.exe");
                driver = new ChromeDriver();
                return driver;
        }
    }
}
