package com.foodics.pages;

import com.foodics.base.Base;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class ProductDetailsPage extends Base {
    public ProductDetailsPage() {
        PageFactory.initElements(driver, this);
    }
    public static String productPrice;
    @FindBy(xpath = "//span[@class='a-price aok-align-center reinventPricePriceToPayMargin priceToPay']//span[@class='a-price-whole']")
    static
    WebElement productPriceLbl;
    @FindBy(id = "add-to-cart-button")
    WebElement addToCartBtn;
    @FindBy(name = "proceedToRetailCheckout")
    WebElement checkoutBtn;
    @FindBy(xpath = "//div[@class='a-box a-alert-inline a-alert-inline-success sw-atc-message']")
    WebElement addedToCartSuccess;
    public void verifyProductDetailsPageIsOpened() {
        Assert.assertTrue(addToCartBtn.isDisplayed());
    }
    public void clickAddToCartBtn() {
        waitAndClick(addToCartBtn);
    }
    public void verifyProductAddedToCart() {
        Assert.assertTrue(addedToCartSuccess.isDisplayed());
    }
    public static void getFirstProductPrice(){
        productPrice = productPriceLbl.getText();
        System.out.println("The price is: "+ productPrice);
    }
    public void proceedToCheckout(){
        waitAndClick(checkoutBtn);
    }
}
