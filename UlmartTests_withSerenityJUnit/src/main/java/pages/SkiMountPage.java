package pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.logging.Logger;

import static org.junit.Assert.assertTrue;

public class SkiMountPage extends PageObject {
    //private static Logger log = Logger.getLogger(SkiMountPage.class.getName());

    @net.serenitybdd.core.annotations.findby.FindBy(xpath = "//div[@class = \"col-main-section b-products\"]")
    private WebElement listOfGoods;

    @net.serenitybdd.core.annotations.findby.FindBy(xpath = "//div[@class='b-product__descr']")
    private WebElement productCard;

    @net.serenitybdd.core.annotations.findby.FindBy(xpath = "//h1")
    private WebElement header;


    public String checkHeader(){
        return header.getText();
         /*   log.info("Текст заголовка совпадает с заданным");
        } else{
            log.info("Текст заголовка не совпадает с заданным");
        }*/
    }

    public boolean checkListOfGoods(){
        return listOfGoods.isEnabled();
        /*    log.info("Список товаров отображается на экране");
        } else{
            log.info("Список товаров не отображается на экране");
        }*/
    }

    public boolean checkProductCard(String name){
        return productCard.getText().contains(name);
        /*    log.info("Карточка товара содержит заданный текст");
        } else{
            log.info("Карточка товара не содержит заданный текст");
        }*/
    }
}
