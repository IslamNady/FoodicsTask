package steps;

import com.foodics.base.Base;
import com.foodics.pages.HomePage;
import com.foodics.pages.VideoGamePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class HomeSteps extends Base {
    HomePage homePage;
    VideoGamePage videoGamePage;
    @Given("user open the Home page")
    public void userOpenTheHomePage() {
        homePage = new HomePage();
        homePage.verifyHomePageIsOpened();
    }

    @And("user Open All Menu and Select Video Games and page should be opened")
    public void userOpenAllMenuAndSelectVideoGames() {
        homePage.clickAllBtn();
        homePage.clickSeeAllBtn();
        videoGamePage = homePage.clickVideoGamesButton();
        videoGamePage.verifyVideoGamesPageIsOpened();
    }
}
