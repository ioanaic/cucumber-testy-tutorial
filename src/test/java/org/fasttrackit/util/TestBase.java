package org.fasttrackit.util;

import com.sdl.selenium.web.utils.PropertiesReader;
import com.sdl.selenium.web.utils.Utils;
import org.fasttrackit.automation.LoginView;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sdl.selenium.utils.config.WebDriverConfig;
import com.sdl.selenium.web.Browser;
import org.testng.ITestResult;

public abstract class TestBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestBase.class);

    public static WebDriver driver;
    public static String USER_NAME = "eu@fast.com";
    public static String PASSWORD = "eu.pass";


    protected LoginView loginPage = new LoginView();

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
       loginPage.login(user,password);
    }

    public void end(ITestResult result){
        if (!result.isSuccess()){
            LOGGER.warn("Test Failed: "+ result.getName());
            Utils.getScreenShot(result.getName(), PropertiesReader.RESOURCES_PATH+"\\results\\screens");
        }
    }
}
