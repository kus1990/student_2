package pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.logging.Logger;

import static org.junit.Assert.assertTrue;

public class SportAndTourismPage extends PageObject {
   // private static Logger log = Logger.getLogger(SportAndTourismPage.class.getName());

    @net.serenitybdd.core.annotations.findby.FindBy(xpath = "//html/body/div[1]/div/div/div/div[2]/div/div/section[1]/div/div[1]/ul/li[15]/a") //span[text() = "Зимний спорт"]//parent::a[1]
    private WebElement buttonWinterSport;

    @net.serenitybdd.core.annotations.findby.FindBy(xpath = "//h1")
    private WebElement header;


    public String checkHeader(){
        return header.getText();
       /*     log.info("Текст заголовка совпадает с заданным");
        } else{
            log.info("Текст заголовка не совпадает с заданным");
        }*/
    }

    public void pressButtonWinterSport(){
        buttonWinterSport.click();
       // log.info("Нажали на кнопку Зимний спорт");
    }
}
