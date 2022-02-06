package pageObjects;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//class to fill information for payment (/misafir-sepet)
public class PaymentInfoPage extends BasePage{

    private final By EMAIL_FIELD = By.id("guestEmail");
    private final By CONTINUE_BUTTON = By.id("js-guestEmailCheck");
    private final By NAME_FIELD = By.id("fullName");
    private final By CITY_DROPDOWN = By.id("cityId");
    private final By DISTRICT_DROPDOWN = By.id("districtId");
    private final By NEIGHBOURHOOD_DROPDOWN = By.id("neighbourhoodId");
    private final By ADDRESS_FIELD = By.id("addressDetail");
    private final By GSM_FIELD = By.id("gsm");
    private final By TCNO_FIELD = By.id("shippingAddresstcNO");
    private final By ADDRESSNAME_FIELD = By.id("addressName");
    private final By PAYMENT_BUTTON = By.id("js-goToPaymentBtn");

    //constructor
    public PaymentInfoPage(WebDriver driver) {
        super(driver);
    }

    //method to make payment
    public void infoPayment(String email, String name, String city, String district, String neighbourhood, String address, String gsm, String tc, String addressName){

        sendKeysElement(EMAIL_FIELD,email);
        clickElement(CONTINUE_BUTTON);

        clickElement(NAME_FIELD);
        sendKeysElement(NAME_FIELD,name);

        selectDropdown(CITY_DROPDOWN,city);
        selectDropdown(DISTRICT_DROPDOWN,district);
        selectDropdown(NEIGHBOURHOOD_DROPDOWN,neighbourhood);

        clickElement(ADDRESS_FIELD);
        clearElement(ADDRESS_FIELD);
        sendKeysElement(ADDRESS_FIELD,address);

        clickElement(GSM_FIELD);
        sendKeysElement(GSM_FIELD,gsm);

        clickElement(TCNO_FIELD);
        sendKeysElement(TCNO_FIELD,tc);

        clickElement(ADDRESSNAME_FIELD);
        clearElement(ADDRESSNAME_FIELD);
        sendKeysElement(ADDRESSNAME_FIELD,addressName);

        clickElement(PAYMENT_BUTTON);
    }
}
