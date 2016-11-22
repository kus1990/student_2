package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Logger;

import static org.junit.Assert.assertTrue;

public class MainUlmartPage extends AbstractPage {

    private static Logger log = Logger.getLogger(MainUlmartPage.class.getName());

    @FindBy(xpath = ".//*[@id='b-dropdown-catalog-menu']/div/div/div/div/ul/li[20]/a")////span[text() = "Спорт и Туризм"]//parent::a
    private WebElement buttonSportAndTourism;

    @FindBy(xpath = "//input[@name = 'string']")
    private WebElement searchField;

    public MainUlmartPage(WebDriver driver){
        assertTrue(driver.getCurrentUrl().contains("www.ulmart.ru"));
    }

    public String pressButtonSportAndTourism(){
        buttonSportAndTourism.click();
        log.info("Push button");
        return "SportAndTourismPage"; //Page Sport and Tourism
    }

    public void verifySearchField(){
        if (searchField.isEnabled()){
            log.info("Строка поиска отображается на странце");
        } else {
            log.info("Строка поиска не отображается на странце");
        }
    }
}
