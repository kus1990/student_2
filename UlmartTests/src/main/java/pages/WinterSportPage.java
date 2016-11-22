package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.logging.Logger;

import static org.junit.Assert.assertTrue;

public class WinterSportPage extends AbstractPage{
    private static Logger log = Logger.getLogger(MainUlmartPage.class.getName());

    @FindBy(xpath = "//span[text() = \"Горнолыжный спорт\"]//parent::a")
    private WebElement buttonSkiMount;

    public WinterSportPage(WebDriver driver){
        assertTrue(driver.getCurrentUrl().contains("www.ulmart.ru/catalog/"));
        log.info("Адрес страницы содержит заданный фрагмент");
    }

    public void checkButtonSkiMount(){
        if (buttonSkiMount.isEnabled()){
            log.info("На странице Зимний спорт есть ссылка с текстом Горнолыжный спорт");
        } else{
            log.info("На странице Зимний спорт нет ссылки с текстом Горнолыжный спорт");
        }
    }

    public String pressButtonSkiMount(){
        buttonSkiMount.click();
        log.info("Нажали на кнопку Горнолыжный спорт");
        return "SkiMountPage";
    }
}
