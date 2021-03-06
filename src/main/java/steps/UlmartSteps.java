package steps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.apache.commons.lang.SystemUtils;
import org.jbehave.core.annotations.BeforeStories;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.After;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Мастер on 26.11.2016.
 */
//@RunWith(SerenityRunner.class)
public class UlmartSteps {
    @Managed(driver = "firefox")
    WebDriver driver;

    @Steps
    UlmartScenarioTest ulmartScenarioTest;

    @BeforeStories
    public void startBrowser(){

        if(SystemUtils.IS_OS_WINDOWS) {
            System.setProperty("webdriver.firefox.marionette", ".\\drivers\\geckodriver.exe");
        } else {
            System.setProperty("webdriver.firefox.marionette", "./drivers/geckodriverlinux");
        }

    }

    @Given("Открытие главной страницы")
    public void openMainUlmartPage(){
        try {
            String baseUrl = "https://www.ulmart.ru";
            ThucydidesWebDriverSupport.getDriver().get(baseUrl);
            ThucydidesWebDriverSupport.getDriver().navigate().refresh();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Then("Главная страница открыта")
    public void openUlmartMainPage(){
        boolean searchField = ulmartScenarioTest.openMainUlmart();
        Assert.assertTrue("Строка поиска на главной странице не отображается", searchField);
    }
    @When("Переход в раздел Спорт и Туризм")
    public void goToSportAndTourismPage() {
        ulmartScenarioTest.stepGoToSportAndTourism();
    }
    @Then("Страница Спорт и Туризм открыта")
    public void openSportAndTourismPage(){
        String SportAndTourism = ulmartScenarioTest.stepOpenSportAndTourismPage();
        Assert.assertEquals("Не удалось открыть страницу Спорт и Туризм", SportAndTourism, "Спорт и Туризм");
    }
    @When("Переход в раздел Зимний Спорт")
    public void goToWinterSportPage(){
        ulmartScenarioTest.stepGoToWinterSport();
    }

    @Then("Страница Зимний спорт открыта")
    public void openWinterSportPage(){
        boolean winterSport = ulmartScenarioTest.stepOpenWinterSportPage();
        Assert.assertTrue("Открыта страница Зимний спорт", winterSport);
    }
    @When("Переход в раздел Горнолыжный спорт")
    public void goToSkiMountPage(){
        ulmartScenarioTest.stepGoToSkiMountPage();
    }
    @Then("Открыта страница Горные лыжи")
    public void openSkiMountPage(){
        String skiMount = ulmartScenarioTest.stepOpenSkiMountPage();
        Assert.assertEquals("Не удалось перейти в раздел горные лыжи", skiMount, "Горные лыжи");
    }
    @Then("Отображается список карточек с товарами")
    public void checkListOgGoods(){
        boolean listOfGoods = ulmartScenarioTest.stepCheckListOfGoods();
        Assert.assertTrue("Показан список карточек с товарами не отображается", listOfGoods);
    }
    @Then("Название товара содержит \"$name\"")
    public void checkNameOfGoods(String name){
        boolean nameOfGoods = ulmartScenarioTest.stepCheckNameOfGoods("Горные лыжи");
        Assert.assertTrue("Имя товара не совпадает с заданным", nameOfGoods);
    }

    @After
    public void tearDown() throws Exception {
        ThucydidesWebDriverSupport.getDriver().quit();
    }


}
