package pageObjects;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//class for search reasult page (/arama?q=ayfon)
public class SearchIphonePage extends BasePage {

    private final By IPHONEIMAGE_TEXT= By.cssSelector("#p-475503022 > div:nth-child(1) > a:nth-child(1) > img");
    private final By IPHONE_LIST = By.cssSelector("ul.clearfix:nth-child(3) > li");
    private final By CARTSIZE_TEXT = By.cssSelector(".basketTotalNum");
    private final By IPHONECLICK_LIST = By.cssSelector("ul.clearfix:nth-child(3) > li > div.columnContent  > div.pro > a");
    private final By CART_LINK = By.cssSelector(".myBasket");

    //constructor
    public SearchIphonePage(WebDriver driver) {
        super(driver);
    }

    //method to check if correct products are shown (iphones)
    public String checkIphoneImageText(){
        return findElement(IPHONEIMAGE_TEXT).getAttribute("alt");
    }

    //method to go to the product page
    public void addItem(int itemIdx){
        clickElement(findElements(IPHONECLICK_LIST).get(itemIdx));    //click on the item from the list and go item page
    }

    //method to find the last product on the page
    public int getLastItemIdx(){
        int listSize = findElements(IPHONE_LIST).size();
        listSize -= 1;
        return listSize;
    }

    //method to check the cart size
    public String checkCartSize(){
        return findElement(CARTSIZE_TEXT).getText();
    }

    //method to go the cart page
    public void goToCart(){
        clickElement(CART_LINK);
    }       //forwards to CartPage
}
