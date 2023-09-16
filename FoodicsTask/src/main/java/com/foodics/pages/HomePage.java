package com.foodics.pages;

import com.foodics.base.Base;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Base {
    public HomePage() {
        PageFactory.initElements(driver, this);
    }
    JavascriptExecutor js = (JavascriptExecutor) driver;
    @FindBy(id = "nav-link-accountList-nav-line-1")
    WebElement signInMenu;
    @FindBy(xpath = "//a[@class='nav-action-signin-button']")
    WebElement signInBtn;
    @FindBy(id = "nav-logo-sprites")
    WebElement amazonLogo;
    @FindBy(id = "nav-hamburger-menu")
    WebElement allBtn;
    @FindBy(xpath = "//a[@class='hmenu-item hmenu-compressed-btn']//div[text()='see all']")
    WebElement seeAllBtn;
    @FindBy(xpath = "//a[@class='hmenu-item']//div[text()='Video Games']")
    WebElement videoGamesBtn;
    @FindBy(xpath = "//a[text()='All Video Games']")
    WebElement AllVideoGamesBtn;
    public void verifyHomePageIsOpened() {
        Assert.assertTrue(amazonLogo.isDisplayed());
    }
    public SignInPage clickSignInBtn(){
        moveToElement(signInMenu);
        waitAndClick(signInBtn);
        return new SignInPage();
    }
    public void clickAllBtn(){
        waitAndClick(allBtn);
    }
    public void clickSeeAllBtn() {
        waitAndClick(seeAllBtn);
    }
    public VideoGamePage clickVideoGamesButton() {
        js.executeScript("arguments[0].scrollIntoViewIfNeeded()",videoGamesBtn);
        waitAndClick(videoGamesBtn);
        waitAndClick(AllVideoGamesBtn);
        return new VideoGamePage();
    }
}
