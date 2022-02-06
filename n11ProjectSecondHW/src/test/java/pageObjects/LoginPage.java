package pageObjects;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//class for login page (/giris-yap?gcht=1&donusurl=/sepetim)
public class LoginPage extends BasePage {

    private final By WITHOUTMEMBERSHIP_BUTTON = By.cssSelector(".btn-continue");

    //constructor
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //method to continue without login
    public void continueWithoutLogin(){
        clickElement(WITHOUTMEMBERSHIP_BUTTON);         //click to "Üye Olmadan Devam Et"
    }

}
