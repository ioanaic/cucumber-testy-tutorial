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





}