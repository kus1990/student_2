package steps;

import net.thucydides.core.annotations.Step;
import pages.MainUlmartPage;
import pages.SkiMountPage;
import pages.SportAndTourismPage;
import pages.WinterSportPage;

/**
 * Created by Мастер on 24.11.2016.
 */
public class UlmartScenarioTest {
    MainUlmartPage mainUlmartPage;
    SkiMountPage skiMountPage;
    SportAndTourismPage sportAndTourismPage;
    WinterSportPage winterSportPage;

    @Step("Открыть основную страницу сайта")
    public boolean openMainUlmart(){
        return mainUlmartPage.verifySearchField();
    }

    @Step("Переход в раздел Спорт и Туризм")
    public String stepSportAndTourism(){
        mainUlmartPage.pressButtonSportAndTourism();
        return sportAndTourismPage.checkHeader();
    }

    @Step("Переход в раздел Зимний спорт")
    public boolean stepWinterSport(){
        sportAndTourismPage.pressButtonWinterSport();
        return winterSportPage.checkButtonSkiMount();
    }

    @Step("Переход в раздел Горнолыжный спорт ")
    public String stepSkiMount(){
        winterSportPage.pressButtonSkiMount();
        return skiMountPage.checkHeader();
    }

    @Step("Проверка наличия списка товаров")
    public boolean stepCheckListOfGoods(){
        return skiMountPage.checkListOfGoods();
    }

    @Step("Проверка названий товаров {0}")
    public boolean stepCheckNameOfGoods(String name){
        return skiMountPage.checkProductCard(name);
    }
}
