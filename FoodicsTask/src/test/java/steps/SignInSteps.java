package steps;

import com.foodics.base.Base;
import com.foodics.pages.HomePage;
import com.foodics.pages.SignInPage;
import com.foodics.pages.SignInPage2;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class SignInSteps extends Base {
    SignInPage signInPage;
    SignInPage2 signInPage2;
    HomePage homePage = new HomePage();

    @When("Clicks Sign In button")
    public void clicksSignInButton() {
        signInPage = homePage.clickSignInBtn();
        signInPage.verifySignInPageIsOpened();
    }
    @And("user fills {string} and click continue")
    public void userFillsEmailClickContinue(String email) {
        signInPage2 = signInPage.Login(email);
        signInPage2.verifySignInPage2IsOpened();
    }
}
