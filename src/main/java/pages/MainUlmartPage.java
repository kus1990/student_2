package pages;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Logger;

import static org.junit.Assert.assertTrue;

public class MainUlmartPage extends PageObject {

    //private static Logger log = Logger.getLogger(MainUlmartPage.class.getName());

    @net.serenitybdd.core.annotations.findby.FindBy(xpath = ".//*[@id='b-dropdown-catalog-menu']/div/div/div/div/ul/li[20]/a")////span[text() = "Спорт и Туризм"]//parent::a
    private WebElement buttonSportAndTourism;

    @net.serenitybdd.core.annotations.findby.FindBy(xpath = "//input[@name = 'string']")
    private WebElement searchField;

    public void pressButtonSportAndTourism(){
        buttonSportAndTourism.click();
        //log.info("Push button");
    }

    public boolean verifySearchField(){
        return searchField.isEnabled();
/*            log.info("Строка поиска отображается на странце");
        } else {
            log.info("Строка поиска не отображается на странце");
        }*/
    }
}
