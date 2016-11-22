package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.logging.Logger;

import static org.junit.Assert.assertTrue;

public class SkiMountPage extends AbstractPage {
    private static Logger log = Logger.getLogger(MainUlmartPage.class.getName());

    @FindBy(xpath = "//div[@class = \"col-main-section b-products\"]")
    private WebElement listOfGoods;

    @FindBy(xpath = "//div[@class='b-product__descr']")
    private WebElement productCard;

    @FindBy(xpath = "//h1")
    private WebElement header;

    public SkiMountPage(WebDriver driver){
        assertTrue(driver.getCurrentUrl().contains("www.ulmart.ru/catalog/97420"));
    }

    public void checkHeader(String head){
        if (header.getText().equals(head)){
            log.info("Текст заголовка совпадает с заданным");
        } else{
            log.info("Текст заголовка не совпадает с заданным");
        }
    }

    public void checkListOfGoods(){
        if (listOfGoods.isEnabled()){
            log.info("Список товаров отображается на экране");
        } else{
            log.info("Список товаров не отображается на экране");
        }
    }

    public void checkProductCard(String text){
        if (productCard.getText().contains(text)){
            log.info("Карточка товара содержит заданный текст");
        } else{
            log.info("Карточка товара не содержит заданный текст");
        }
    }
}
