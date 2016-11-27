package pages;

import driverManager.BrowserManager;
import helpers.PropertyLoader;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import steps.UlmartScenarioTest;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

/**
 * Created by Мастер on 26.11.2016.
 */
public class BaseTest {


    @Steps
    protected UlmartScenarioTest ulmartScenarioTest;

    @Managed(driver = "firefox")
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        //driver = BrowserManager.getWebDriver();
        //String workingDir = System.getProperty("user.dir");
        //System.setProperty("webdriver.firefox.marionette", workingDir + "\\drivers\\geckodriver.exe");
        String baseUrl = PropertyLoader.loadProperty("stageURL");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }


}
