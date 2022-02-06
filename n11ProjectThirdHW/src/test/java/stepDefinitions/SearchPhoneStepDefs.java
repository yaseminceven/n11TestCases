package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.N11MainPage;
import pageObjects.SearchPage;
import runners.Runner;
import java.util.List;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;


public class SearchPhoneStepDefs extends Runner {

    N11MainPage mainpage;
    SearchPage searchpage;

    @Given("User opens the n11 main page")
    public void userOpensTheNMainPage(){
        getThreadDriver().navigate().to(url);
        mainpage = new N11MainPage(getThreadDriver());
        mainpage.closeInfo();                                   //closes the location information pop-up
    }

    @When("User search for telefon and selects the filter for second brand")
    public void userSearchForTelefonAndSelectsTheFilterForSecondBrand() {             //search for the keyword
        mainpage.search("telefon");
    }

    @And("User sorts the results according to comment count and selects free shipping option")
    public void userSortsTheResultsAccordingToCommentCountAndSelectsFreeShippingOption() {
        searchpage = new SearchPage(getThreadDriver());
        searchpage.sort();                                                             //sort the results by second brand, comment count and free shipment option
    }

    @Then("User sees the relevant results")
    public void userSeesTheRelevantResults() {
        boolean checkResult;
        List<String> checkProductName = searchpage.checkProductName();

        for (String product: checkProductName) {                                               //check if the brand name is correct
            assertThat(product.toLowerCase(),containsString(searchpage.checkBrand()));
        }

        checkResult = searchpage.checkDescendingCommentNum() && searchpage.checkFreeShipment();          //check if comment count is in descending order and shipment is free
        assertTrue(checkResult);
    }
}
