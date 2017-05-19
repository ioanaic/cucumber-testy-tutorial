package org.fasttrackit.automation;

import org.fasttrackit.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LoginTest extends TestBase {

    private LoginPage page;

    public LoginTest() {
        page = PageFactory.initElements(driver, LoginPage.class);
    }

    @Test
    public void validLoginTest() {
        doLogin("eu@fast.com", "eu.pass");
        WebElement logout = driver.findElement(By.linkText("Logout"));
        logout.click();

    }

    @Test
    public void invalidUserAndPasswordTest() {
        doLogin("wrong.user", "wrong.pass");

        String message = page.getInvalidUserOrPassWarningMessage();
        System.out.println(message);
        assertThat(message, is("Invalid user or password!"));


    }


}