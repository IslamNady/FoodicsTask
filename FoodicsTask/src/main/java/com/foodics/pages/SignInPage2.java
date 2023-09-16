package com.foodics.pages;

import com.foodics.base.Base;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class SignInPage2 extends Base {
    public SignInPage2(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "ap_password")
    WebElement passwordTxt;
    @FindBy(id="signInSubmit")
    WebElement signInBtn;
    public void verifySignInPage2IsOpened(){
        Assert.assertTrue(passwordTxt.isDisplayed());
    }
    public HomePage Login(String password){
        passwordTxt.sendKeys(password);
        waitAndClick(signInBtn);
        return new HomePage();
    }
}
