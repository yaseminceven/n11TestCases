package pageObjects;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

//class for the main page
public class N11MainPage extends BasePage {
    private final By LOCATION_BUTTON = By.cssSelector("#myLocation-close-info");
    private final By NOTIFICATION_TEXT = By.cssSelector("#dengage-push-perm-slide > div");
    private final By LATER_BUTTON = By.cssSelector("#dengage-push-perm-slide > div > div.dn-slide-body > div > button.dn-slide-deny-btn");
    private final By SEARCH_FIELD = By.id("searchData");

    //constructor
    public N11MainPage(WebDriver driver) {
        super(driver);
    }

    //method to close the location info pop-up
    public void closeInfo(){
        clickElement(LOCATION_BUTTON);
    }

    //search method
    public void searchForKeyword(String keyword){
        try {
            if(findElement(NOTIFICATION_TEXT).isDisplayed()){
                clickElement(LATER_BUTTON);                      //close the notification pop-up
            }
        }catch (NoSuchElementException e){
            System.out.println(e);
        }

        clickElement(SEARCH_FIELD);
        clearElement(SEARCH_FIELD);
        sendKeysElement(SEARCH_FIELD,keyword);
        sendKeysElement(SEARCH_FIELD, Keys.ENTER);
    }
}
