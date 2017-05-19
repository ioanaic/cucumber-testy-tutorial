package org.fasttrackit.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sdl.selenium.utils.config.WebDriverConfig;
import com.sdl.selenium.web.Browser;

public abstract class TestBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestBase.class);

    public static WebDriver driver;
    public static String USER_NAME = "eu@fast.com";
    public static String PASSWORD = "eu.pass";

    static {
        startSuite();
    }

    private static void startSuite() {
        try {
            driver = WebDriverConfig.getWebDriver(Browser.CHROME);
        } catch (Exception e) {
            LOGGER.error("Exception when start suite", e);
        }
    }

    public void doLogin(String user, String password) {
        System.out.println("ready");
        driver.get("https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/login.html");
        driver.findElement(By.name("username")).sendKeys(user);

        WebElement passwordElement = driver.findElement(By.id("password"));
        passwordElement.sendKeys(password);

        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();
    }
}
