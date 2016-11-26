package pages;


import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.logging.Logger;

import static org.junit.Assert.assertTrue;

public class WinterSportPage extends PageObject {
   // private static Logger log = Logger.getLogger(WinterSportPage.class.getName());

    @net.serenitybdd.core.annotations.findby.FindBy(xpath = "html/body/div[1]/div/div/div/div[2]/div/div/section[1]/div/div[1]/ul/li[3]/a")////span[text() = "Горнолыжный спорт"]//parent::a
    private WebElement buttonSkiMount;


    public boolean checkButtonSkiMount(){
        return buttonSkiMount.isEnabled();
       /*     log.info("На странице Зимний спорт есть ссылка с текстом Горнолыжный спорт");
        } else{
            log.info("На странице Зимний спорт нет ссылки с текстом Горнолыжный спорт");
        }*/
    }

    public void pressButtonSkiMount(){
        buttonSkiMount.click();
       // log.info("Нажали на кнопку Горнолыжный спорт");
    }
}
