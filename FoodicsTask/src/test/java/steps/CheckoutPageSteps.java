package steps;

import com.foodics.base.Base;
import com.foodics.pages.CheckoutPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
public class CheckoutPageSteps extends Base {
    CheckoutPage checkoutPage = new CheckoutPage();
    @And("User Added a new address")
    public void addAddressAndCheckout(){
        checkoutPage.verifyCheckoutPageIsDisplayed();
        checkoutPage.addAddress();
    }
    @Then("Address should be added and amount is verified")
    public void addressShouldBeAddedAndAmountIsVerified() {
        checkoutPage.verifyAddressIsAdded();
        checkoutPage.verifyTotalAmount();
    }
}
