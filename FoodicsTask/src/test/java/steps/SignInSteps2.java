package steps;

import com.foodics.base.Base;
import com.foodics.pages.HomePage;
import com.foodics.pages.SignInPage2;
import io.cucumber.java.en.And;
public class SignInSteps2 extends Base {
    SignInPage2 signInPage2 = new SignInPage2();
    HomePage homePage;
    @And("user fills {string} and click submit")
    public void userFillsPasswordAndClickSubmit(String password) {
        signInPage2.verifySignInPage2IsOpened();
        homePage = signInPage2.Login(password);
        homePage.verifyHomePageIsOpened();
    }
}
