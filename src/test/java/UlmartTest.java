import java.util.concurrent.TimeUnit;

import driverManager.BrowserManager;
import helpers.PropertyLoader;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Title;
import org.junit.*;
import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;

@RunWith(SerenityRunner.class)
public class UlmartTest extends BaseTest {

  @Test
  @Title("Проверка карточек товаров")
  public void testLogin() throws Exception {
    boolean searchField = ulmartScenarioTest.openMainUlmart();
    Assert.assertTrue("Строка поиска показана", searchField);
    String SportAndTourism = ulmartScenarioTest.stepSportAndTourism();
    Assert.assertEquals("Не удалось открыть страницу Спорт и Туризм", SportAndTourism, "Спорт и Туризм");
    boolean winterSport = ulmartScenarioTest.stepWinterSport();
    Assert.assertTrue("Открыта страница Зимний спорт", winterSport);
    String skiMount = ulmartScenarioTest.stepSkiMount();
    Assert.assertEquals("Не удалось перейти в раздел горные лыжи", skiMount, "Горные лыжи");
    boolean listOfGoods = ulmartScenarioTest.stepCheckListOfGoods();
    Assert.assertTrue("Показан список товаров", listOfGoods);
    boolean nameOfGoods = ulmartScenarioTest.stepCheckNameOfGoods("Горные лыжи");
    Assert.assertTrue("Имя товара не совпадает с заданным", nameOfGoods);
  }


}
