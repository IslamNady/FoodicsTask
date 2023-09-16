package com.foodics.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Base {
    public static WebDriver driver;
    public static Properties props;
    public static WebDriverWait wait;
    Actions actions;
    public Base() {
        try {
            props = new Properties();
            File file = new File("src/main/java/com/foodics/properties/config.properties");
            FileInputStream fis = new FileInputStream(file);
            props.load(fis);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void launchBrowser() {
        String browser = props.getProperty("browser");
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            throw new Error("Browser Not Supported");
        }
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get(props.getProperty("url"));
        driver.manage().window().maximize();
    }
    protected void moveToElement(WebElement element) {
        actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }
    protected void waitAndClick(WebElement element) {
        actions = new Actions(driver);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        actions.moveToElement(element).click(element).perform();
    }
    protected void waitAndSendKeys(WebElement element,String text) {
        actions = new Actions(driver);
        wait.until(ExpectedConditions.visibilityOf(element));
        actions.moveToElement(element).perform();
        element.sendKeys(text);
    }
}