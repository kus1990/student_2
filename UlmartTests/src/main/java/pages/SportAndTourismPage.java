package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.logging.Logger;

import static org.junit.Assert.assertTrue;

public class SportAndTourismPage extends AbstractPage{
    private static Logger log = Logger.getLogger(MainUlmartPage.class.getName());

    @FindBy(xpath = "//html/body/div[1]/div/div/div/div[2]/div/div/section[1]/div/div[1]/ul/li[15]/a") //span[text() = "Зимний спорт"]//parent::a[1]
    private WebElement buttonWinterSport;

    @FindBy(xpath = "//h1")
    private WebElement header;

    public SportAndTourismPage(WebDriver driver){
        assertTrue(driver.getCurrentUrl().contains("https://www.ulmart.ru/catalog/tourism_goods"));
        log.info("Адрес на странице Спорт и Туризм совпадает с заданным");
    }

    public void checkHeader(String head){
        if (header.getText().equals(head)){
            log.info("Текст заголовка совпадает с заданным");
        } else{
            log.info("Текст заголовка не совпадает с заданным");
        }
    }

    public String pressButtonWinterSport(){
        buttonWinterSport.click();
        log.info("Нажали на кнопку Зимний спорт");
        return "WinterSportPage";
    }
}
