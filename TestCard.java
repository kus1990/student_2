import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class  TestCard{
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    DesiredCapabilities capabilities = DesiredCapabilities.firefox();
    FirefoxProfile profile = new FirefoxProfile();
    capabilities.setCapability(FirefoxDriver.PROFILE, profile);
    driver = new FirefoxDriver(capabilities);
    //System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
    //driver = new FirefoxDriver();
    //driver = new ChromeDriver();
    //System.setProperty("webdriver.ie.driver",".\\drivers\\iedriver.exe");
   // driver = new InternetExplorerDriver();
    baseUrl = "https://www.ulmart.ru/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void test() throws Exception {
    // шаг 1
    driver.get(baseUrl);
    // проверка наличия строки поиска
    assertTrue(isElementPresent(By.id("searchField")));
    // ОТВЕТ: Можно попробовать так (//ul[contains(@class,'catalog-menu')])[1]//li[contains(@class,'dropdown_catalog-menu')]
    //  или (//ul[contains(@class,'catalog-menu')])[1]//li[contains(@class,'dropdown_catalog-menu')]/a
    // шаг 2
    // переход в раздел "Спорт и Туримзм"
    driver.findElement(By.xpath("//span[text() = \"Спорт и Туризм\"]")).click();
    // проверка заголовка
    assertEquals("Спорт и Туризм", driver.findElement(By.xpath("//h1")).getText());
    // шаг 3
    // переход в подраздел "Зимний спорт"
    driver.findElement(By.xpath("//span[text() =\"Зимний спорт\"]")).click();
    // проверка наличия ссылки с текстом "Горнолыжный спорт"
    assertEquals("Горнолыжный спорт", driver.findElement(By.xpath("//span[text() = \"Горнолыжный спорт\"]")).getText());
    // шаг 4
    driver.findElement(By.xpath("//span[text() = \"Горнолыжный спорт\"]")).click();
    // проверка заголовка страницы - Горные лыжи
    assertEquals("Горные лыжи", driver.findElement(By.xpath("//h1[text() = \" Горные лыжи\"]")).getText());
    // проверка наличия списка карточек с товарами
    try {
      assertTrue(isElementPresent(By.xpath("//div[@class = \"col-main-section b-products\"]")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    // шаг 5
    // ВОПРОС-3 : как тут написать XPath, чтобы именно первая карточка была?
    //     ОТВЕТ: () для сбора элементов в одну коллекцию в IDE почему-то не работают
    //     Можно попробовать сделать так (//div[@class='b-product__center']/div[@class='b-product__title']//a)[1], но работать не будет
    // ВОПРОС-4 : почему даже по такой ссылке Selenium выдает ошибку?
    // Первое - локаторы  использующие id-ки это плохо, лучше использовать имена классов или name для тега
    // .//*[@id='linkText3633770'] - не очень удачный локатор, но тут проблема с тем куда ведет данный локатор.
    // Поэтому кликнуть можно с помощью Java Script, но далее окно все равно блокируется 
    // ERROR: Caught exception [ERROR: Unsupported command [getEval | window.document.getElementsByClassName('b-product__center')[0].getElementsByTagName("a")[0].click() | ]]
    // проверка наличия в наименовании товара "Горные лыжи"
    // ВОПРОС-5 : как проверить, что строка содержит текст?
    // ОТВЕТ: Вроде все ок, через assertText.
    // Однако, JUnit позволяет сделать более понятные проверки по части строки с указанием RegExp

    assertTrue(driver.findElement(By.xpath("//div[@class='b-product__descr']")).getText().matches("^Горные лыжи [\\s\\S]*$"));
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
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
