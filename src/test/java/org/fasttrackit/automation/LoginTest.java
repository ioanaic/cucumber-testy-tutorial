package org.fasttrackit.automation;

import com.sdl.selenium.web.utils.Utils;
import org.fasttrackit.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LoginTest extends TestBase {

    @Test
    public void validLoginTest() {
        doLogin("eu@fast.com", "eu.pass");
        WebElement logout = driver.findElement(By.xpath("//a[@class='btn btn-default navbar-btn']"));
        logout.click();
        ;

    }

    @Test
    public void invalidUserAndPasswordTest() {
        driver.get("https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/login.html");

        WebElement invalidUser = driver.findElement(By.name("username"));
        invalidUser.sendKeys("eu.pasddskjghf");
        WebElement invalidPassword = driver.findElement(By.id("password"));
        invalidPassword.sendKeys("eu.paskjfh");
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();

        doLogin("eu.pasddskjghf", "");


        WebElement errorMsg = driver.findElement(By.className("error-msg"));
        String message = errorMsg.getText();
        System.out.println(message);

        assertThat(message, is("Invalid user or password!"));


    }


    @Test
    public void tryTochangePasswordWithInvalidCurrentPassword() {
        // doLogin("eu@fast.com","eu.pass");
        preferencesWindow();
        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"preferences-win\"]//input[@name=\"password\"]'"));
        WebElement newpasswordField = driver.findElement(By.xpath("//*[@id=\"preferences-win\"]//input[@name=\"newPassword\"]'"));
        WebElement confirmpasswordField = driver.findElement(By.xpath("//*[@id=\"preferences-win\"]//input[@name=\"newPasswordRepeat\"]'"));
        WebElement saveBtn = driver.findElement(By.xpath("//*[@id='preferences-win']//button[text()='Save']"));

        saveBtn.click();
        passwordField.sendKeys("wrong.pass");
        newpasswordField.sendKeys("new.pass");


        //  assertThat(message, is("Invalid user or password!"));

    }


    public void doLogin(String user, String password) {
        System.out.println("ready");
        driver.get("https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/login.html");
        driver.findElement(By.name("username")).sendKeys(user);

        WebElement passwordElement = driver.findElement(By.id("password"));
        passwordElement.sendKeys(password);
//    passwordElement.clear();
//    passwordElement.sendKeys("eu.pass1");

        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();
    }

}