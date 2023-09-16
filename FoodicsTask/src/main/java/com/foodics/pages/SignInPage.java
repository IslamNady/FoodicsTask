package com.foodics.pages;

import com.foodics.base.Base;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends Base {
    public SignInPage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//label[@for='ap_email']")
    WebElement signInLbl;
    @FindBy(id = "ap_email")
    WebElement emailTxt;
    @FindBy(id="continue")
    WebElement continueBtn;
    public void verifySignInPageIsOpened(){
        Assert.assertTrue(signInLbl.isDisplayed());
    }
    public SignInPage2 Login(String username){
        emailTxt.sendKeys(username);
        waitAndClick(continueBtn);
        return new SignInPage2();
    }
}
