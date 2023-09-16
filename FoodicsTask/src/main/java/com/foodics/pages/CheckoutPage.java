package com.foodics.pages;

import com.foodics.base.Base;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends Base {
    public CheckoutPage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//h3[@class='a-color-state']")
    WebElement headerTxt;
    @FindBy(id = "address-ui-widgets-enterAddressFullName")
    WebElement fullNameTxtBox;
    @FindBy(id = "address-ui-widgets-enterAddressPhoneNumber")
    WebElement mobileTxtBox;
    @FindBy(id = "address-ui-widgets-enterAddressLine1")
    WebElement streetTxtBox;
    @FindBy(id = "address-ui-widgets-enter-building-name-or-number")
    WebElement buildingTxtBox;
    @FindBy(id = "address-ui-widgets-enterAddressCity")
    WebElement cityTxtBox;
    @FindBy(id = "address-ui-widgets-enterAddressDistrictOrCounty")
    WebElement districtTxtBox;
    @FindBy(id = "address-ui-widgets-addr-details-res-radio-input")
    WebElement addressTypeChkBox;
    @FindBy(xpath = "//input[@aria-labelledby='address-ui-widgets-form-submit-button-announce']")
    WebElement submitAddressButton;
    @FindBy(xpath = "//*[contains(text(), 'Choose a payment method')]")
    WebElement choosePaymentMethodLbl;
    @FindBy(xpath = "(//td[@class='a-color-price a-size-medium a-text-right a-align-bottom aok-nowrap grand-total-price a-text-bold'])[2]")
    WebElement totalAmount;
    public void verifyCheckoutPageIsDisplayed() {
        Assert.assertTrue(headerTxt.isDisplayed());
    }
    public void addAddress() {
        fillFullName("Test Test");
        fillMobileTxtBox("1023569874");
        fillStreetTxtBox("Test Street");
        fillBuildingTxtBox("Test Building");
        fillCityTxtBox("10th of Ramadan City");
        fillDistrictTxtBox("10th District");
        clickAddressTypeChkBox();
        clickSubmitAddressButton();
    }
    public void fillFullName(String fullName) {
        waitAndSendKeys(fullNameTxtBox, fullName);
    }

    public void fillMobileTxtBox(String mobile) {
        waitAndSendKeys(mobileTxtBox, mobile);
    }

    public void fillStreetTxtBox(String street) {
        waitAndSendKeys(streetTxtBox, street);
    }

    public void fillBuildingTxtBox(String building) {
        waitAndSendKeys(buildingTxtBox, building);
    }

    public void fillCityTxtBox(String city) {
        waitAndSendKeys(cityTxtBox, city);
        moveToElement(districtTxtBox);
    }
    public void fillDistrictTxtBox(String district) {
        waitAndSendKeys(districtTxtBox, district);
        districtTxtBox.sendKeys(Keys.ARROW_DOWN);
        districtTxtBox.sendKeys(Keys.ENTER);
    }
    public void clickAddressTypeChkBox() {
        waitAndClick(addressTypeChkBox);
    }
    public void clickSubmitAddressButton() {
        waitAndClick(submitAddressButton);
    }
    public void verifyAddressIsAdded(){Assert.assertTrue(choosePaymentMethodLbl.isDisplayed());}
    public void verifyTotalAmount() {
        verifyCheckoutPageIsDisplayed();
        Assert.assertEquals(ProductDetailsPage.productPrice,totalAmount.getText().substring(4,10));
    }
}
