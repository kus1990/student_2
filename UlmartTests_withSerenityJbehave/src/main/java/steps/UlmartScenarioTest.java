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
    public void stepGoToSportAndTourism(){
        mainUlmartPage.pressButtonSportAndTourism();
    }
    @Step("Страница Спорт и Туризм открыта")
    public String stepOpenSportAndTourismPage(){
        return sportAndTourismPage.checkHeader();
    }

    @Step("Переход в раздел Зимний спорт")
    public void stepGoToWinterSport(){
        sportAndTourismPage.pressButtonWinterSport();
    }
    @Step("Страница Зимний спорт открыта")
    public boolean stepOpenWinterSportPage(){
        return winterSportPage.checkButtonSkiMount();
    }

    @Step("Переход в раздел Горнолыжный спорт ")
    public void stepGoToSkiMountPage(){
        winterSportPage.pressButtonSkiMount();
    }
    @Step("Страница Горнолыжный спорт открыта")
    public String stepOpenSkiMountPage(){
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
