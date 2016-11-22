import java.util.concurrent.TimeUnit;

import driverManager.BrowserManager;
import helpers.PropertyLoader;
import org.junit.*;
import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import pages.*;

public class LoginTest {
  private WebDriver browser;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    browser = BrowserManager.getWebDriver();
    baseUrl = PropertyLoader.loadProperty("stageURL");
    browser.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
  }

  @Test
  public void testLogin() throws Exception {
    browser.get(baseUrl);
    MainUlmartPage mainUlmartPage = PageFactory.initElements(browser,MainUlmartPage.class);
    mainUlmartPage.verifySearchField();
    String page = mainUlmartPage.pressButtonSportAndTourism();
    SportAndTourismPage sportAndTourismPage = PageFactory.initElements(browser,SportAndTourismPage.class);
    sportAndTourismPage.checkHeader("Спорт и Туризм");
    page = sportAndTourismPage.pressButtonWinterSport();
    WinterSportPage winterSportPage = PageFactory.initElements(browser,WinterSportPage.class);
    winterSportPage.checkButtonSkiMount();
    page = winterSportPage.pressButtonSkiMount();
    SkiMountPage skiMountPage = PageFactory.initElements(browser,SkiMountPage.class);
    skiMountPage.checkHeader("Горные лыжи");
    skiMountPage.checkListOfGoods();
    skiMountPage.checkProductCard("Горные лыжи");
  }

  @After
  public void tearDown() throws Exception {
    browser.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      browser.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      browser.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = browser.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
