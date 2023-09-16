package steps;

import com.foodics.base.Base;
import com.foodics.pages.ProductDetailsPage;
import io.cucumber.java.en.And;

public class ProductDetailsPageSteps extends Base {
    ProductDetailsPage productDetailsPage = new ProductDetailsPage();
    @And("User clicks Add to Cart for products")
    public void userClicksAddToCartForProducts() {
        productDetailsPage.getFirstProductPrice();
        productDetailsPage.clickAddToCartBtn();
        productDetailsPage.verifyProductAddedToCart();
        productDetailsPage.proceedToCheckout();
    }
}
