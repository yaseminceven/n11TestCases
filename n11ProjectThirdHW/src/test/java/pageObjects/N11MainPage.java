package pageObjects;


import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

//class for the main page
public class N11MainPage extends BasePage {

    private final By LOCATION_BUTTON = By.cssSelector("#myLocation-close-info");
    private final By SEARCH_FIELD = By.id("searchData");

    //constructor
    public N11MainPage(WebDriver driver) {
        super(driver);
    }

    //method to close the location info pop-up
    public void closeInfo(){
        clickElement(LOCATION_BUTTON);
    }

    public void search(String text) {
        clearField(SEARCH_FIELD);
        sendKey(SEARCH_FIELD,text);
        sendKey(SEARCH_FIELD,Keys.ENTER);
    }

}
