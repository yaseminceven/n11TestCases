package stepDefinitions;

import base.BaseData;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.*;
import runners.RunCucumberTest;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;


public class AddIphoneSteps extends RunCucumberTest {
    String keyword = "ayfon";
    
    N11MainPage mainpage;
    SearchIphonePage searchiphonepage;
    IPhoneProductPage iphonepage;
    CartPage cartpage;
    LoginPage loginpage;
    PaymentInfoPage paymentinfopage;
    PaymentPage paymentpage;


    @Given("User opens the n11 main page")
    public void userOpensTheNMainPage() {
        getThreadDriver().navigate().to(url);
        mainpage = new N11MainPage(getThreadDriver());
        mainpage.closeInfo();                            //close the location info pop-up
    }

    @When("User searches for the ayfon user sees the iphones")
    public void userSearchesForTheAyfonUserSeesTheIphones() {
        mainpage.searchForKeyword(keyword);                       //search for ayfon
        searchiphonepage = new SearchIphonePage(getThreadDriver());
        assertThat(searchiphonepage.checkIphoneImageText(),containsString("Apple iPhone"));   //check if the search shows iPhone
    }

    @And("User adds the first and last iphone to cart from the first page")
    public void userAddsTheFirstAndLastIphoneToCartFromTheFirstPage() {
        searchiphonepage.addItem(0);            //go to first iphone product page from list
        iphonepage = new IPhoneProductPage(getThreadDriver());
        iphonepage.addIphoneToCart();                 //add the first iphone to cart
        searchiphonepage.addItem(searchiphonepage.getLastItemIdx());   //go to last iphone product page from list
        iphonepage.addIphoneToCart();                 //add the last iphone to cart
        assertThat(searchiphonepage.checkCartSize(),is("2"));
    }

    @And("User adds one more of the cheapest iphone")
    public void userAddsOneMoreOfTheCheapestIphone() {
        searchiphonepage.goToCart();                     //go to cart page
        cartpage = new CartPage(getThreadDriver());
        cartpage.closeInformation();                     //close the kvkk information
        cartpage.addCheapestItem();                      //add one more of the cheapest product
        assertEquals(cartpage.quantity,"2");       //check if the product has added
        cartpage.clickPayment();                          //go to the payment login info page
    }

    @And("User tries to buy them with wrong credentials")
    public void userTriesToBuyThemWithWrongCredentials() {
        loginpage = new LoginPage(getThreadDriver());
        loginpage.continueWithoutLogin();                     //continue payment without login
        paymentinfopage = new PaymentInfoPage(getThreadDriver());
        BaseData data = new BaseData();                       //get the user data and fill the information
        paymentinfopage.infoPayment(data.getPaymentInfo(0),data.getPaymentInfo(1),data.getPaymentInfo(2),data.getPaymentInfo(3),data.getPaymentInfo(4),data.getPaymentInfo(5),data.getPaymentInfo(6),data.getPaymentInfo(7),data.getPaymentInfo(8));
        paymentpage = new PaymentPage(getThreadDriver());
        paymentpage.makePayment(data.getCartNum(),data.getCartInfo(0),data.getCartInfo(1),data.getCartInfo(2),data.getCartInfo(3));
    }

    @Then("User sees the credentials are invalid")
    public void userSeesTheCredentialsAreInvalid() {
        assertEquals(paymentpage.checkPaymentText(),"Geçersiz kredi kartı numarası.");   //check if the credentials are wrong
        getThreadDriver().quit();
    }
}
