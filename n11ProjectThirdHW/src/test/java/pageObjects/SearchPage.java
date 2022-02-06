package pageObjects;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

//class for the search page (/arama?q=telefon)
public class SearchPage extends BasePage {

    public List<String> productName = new ArrayList<>();
    public List<String> rating  = new ArrayList<>();
    public List<Integer> ratingNum = new ArrayList<>();
    public List<Boolean> shipment = new ArrayList<>();

    private final By SECONDBRAND_BUTTON = By.cssSelector(".filter:nth-child(6) > div:nth-child(3) > div:nth-child(2) > label > input");
    private final By SORT_DROPDOWN = By.id("sortingType");
    private final By FREESHIPMENT_BUTTON = By.id("freeShippingOption");
    private final By PRODUCTNAME_LIST = By.cssSelector(".plink");
    private final By RATING_LIST = By.cssSelector(".ratingCont > span.ratingText");
    private final By SHIPMENT_LIST = By.cssSelector(".textImg.freeShipping");

    //constructor
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    //method to sort products
    public void sort() {
        clickElement(SECONDBRAND_BUTTON);
        selectDropdown(SORT_DROPDOWN,"REVIEWS");
        clickElement(FREESHIPMENT_BUTTON);
    }

    //method to check brand name
    public String checkBrand(){
        return findElement(SECONDBRAND_BUTTON).getText();
    }

    //method to check product names
    public List<String> checkProductName(){
        for (WebElement element:findElements(PRODUCTNAME_LIST)) {
            productName.add(element.getAttribute("title"));
        }
        return productName;
    }

    //method to check if the comments sorted correctly
    public boolean checkDescendingCommentNum(){
        boolean checkRating=false;
        for(WebElement element:findElements(RATING_LIST)){
            rating.add(element.getText().replaceAll("[()]", ""));
        }
        for (String ratingStr:rating) {
            ratingNum.add(Integer.parseInt(ratingStr));
        }
        for (int i = 0; i < ratingNum.size()-1; i++) {
            if(ratingNum.get(i)>=ratingNum.get(i+1)){
                checkRating = true;
            }else{
                checkRating = false;
            }
        }
        return checkRating;
    }

    //method to check if the correct shipment option is selected
    public boolean checkFreeShipment(){
        boolean checkShipment = false;
        for (WebElement element:findElements(SHIPMENT_LIST)){
            shipment.add(element.isDisplayed());
        }
        for (Boolean ans:shipment) {
            if (ans.equals(true)){
                checkShipment = true;
            }else{
                checkShipment = false;
            }
        }
        return checkShipment;
    }
}
