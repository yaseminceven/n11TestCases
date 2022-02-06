package pageObjects;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//class for cart page (/sepetim)
public class CartPage extends BasePage {
    public String quantity;
    int price1;
    int price2;

    private final By INFORMATIONCLOSE_BUTTON = By.cssSelector("#userKvkkModal > div > div.btnHolder > span");
    private final By PRODUCTPRICE_LIST = By.cssSelector(".productGroup >tbody >tr >td.prodPrice> div.priceTag> div.priceArea >span");
    private final By ADDBUTTON_LIST = By.cssSelector(".productGroup >tbody >tr >td.prodPrice>div.spinnerField>div.spinnerFieldContainer> span.spinnerUp.spinnerArrow");
    private final By QUANTITY_LIST = By.cssSelector(".quantity");
    private final By PAYMENT_BUTTON = By.id("js-buyBtn");

    //constructor
    public CartPage(WebDriver driver) {
        super(driver);
    }

    //method to close the kvkk modal
    public void closeInformation(){
        if(findElement(INFORMATIONCLOSE_BUTTON).isDisplayed()){
            clickElement(INFORMATIONCLOSE_BUTTON);
        }
    }

    //method to add one more of the cheapest item
    public void addCheapestItem() {
        String[] priceText1 = findElements(PRODUCTPRICE_LIST).get(0).getText().split("\\s");     //get the price text of first item
        String[] priceText2  = findElements(PRODUCTPRICE_LIST).get(1).getText().split("\\s");     //get the prica text of second item

        price1 = convertToInt(priceText1[0]);
        price2 = convertToInt(priceText2[0]);

        if(price1 < price2){                                                                 //compare prices for each item
            clickElement(findElements(ADDBUTTON_LIST).get(0));                               //add one more of the cheapest item
            quantity = findElements(QUANTITY_LIST).get(0).getAttribute("value");       //check the quantity of the item
        }else{
            clickElement(findElements(ADDBUTTON_LIST).get(1));                                //add one more of the cheapest item
            quantity = findElements(QUANTITY_LIST).get(1).getAttribute("value");        //check the quantity of the item
        }
    }

    //get only the price number from the string
    public int convertToInt(String str){
        str = str.replaceAll(",","").replaceAll("\\.","");     //remove special chars
        return Integer.parseInt(str);
    }

    //method to go to login page for payment
    public void clickPayment(){
        clickElement(PAYMENT_BUTTON);     //click to "SATIN AL" button
    }
}
