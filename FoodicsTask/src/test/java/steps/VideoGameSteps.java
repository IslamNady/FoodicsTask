package steps;

import com.foodics.base.Base;
import com.foodics.pages.ProductDetailsPage;
import com.foodics.pages.VideoGamePage;
import io.cucumber.java.en.And;

public class VideoGameSteps extends Base {
    VideoGamePage videoGamePage = new VideoGamePage();
    ProductDetailsPage productDetailsPage = new ProductDetailsPage();
    @And("User filters the products and sort and select all products less than 15000")
    public void userFiltersTheProductsAndSort()  {
        videoGamePage.clickFreeShippingChkBox();
        videoGamePage.clickNewConditionLink();
        videoGamePage.clickSortMenu();
        videoGamePage.clickSortHighToLow();
        videoGamePage.clickFirstProduct();
        productDetailsPage.verifyProductDetailsPageIsOpened();
    }
}
