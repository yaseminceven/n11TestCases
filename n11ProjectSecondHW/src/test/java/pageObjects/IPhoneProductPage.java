package pageObjects;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//class for product page (/urun/)
public class IPhoneProductPage extends BasePage {

    private final By ADDHCART_BUTTON = By.cssSelector(".product-add-cart > a:nth-child(1)");

    //constructor
    public IPhoneProductPage(WebDriver driver) {
        super(driver);
    }

    //method to add product to cart
    public void addIphoneToCart(){
        clickElement(ADDHCART_BUTTON);
        goToUrl("https://www.n11.com/arama?q=ayfon");        //go back to search page
    }
}
