package org.fasttrackit.automation;

import org.fasttrackit.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Ioana on 5/11/2017.
 */
public class PreferencesTest extends TestBase {

    PreferencesPage page;

    public PreferencesTest() {
        page = PageFactory.initElements(driver, PreferencesPage.class);
    }

    @Test
    public void preferencesWindowShouldCloseTest() {
        doLogin(USER_NAME, PASSWORD);
        page.open();
        page.close();
    }

    @Test
    public void tryTochangePasswordWithInvalidCurrentPasswordTest() {
        changePassword("wrong.pass", "new.pass", "new.pass");
        String message = page.getIncorrectMessage();
        assertThat(message, is("Your preview password is incorrect!"));

    }

    @Test
    public void tryToChangePasswordWithInvalidConfirmPasswordTest() {
        changePassword("eu.pass","new.pass","new.pass.wrong");
        String message = page.getIncorrectMessage();
        assertThat(message,is("Password does not match the confirm password!"));
    }
    @Test
    public void successChangePassTest(){
        changePassword("eu.pass","new.pass","new.pass");
        String message = page.getIncorrectMessage();
        assertThat(message,is("Your password has been successfully changed."));

        page.close();
        WebElement logoutBtn = driver.findElement(By.linkText("Logout"));
        logoutBtn.click();

        PASSWORD = "new.pass";
        doLogin(USER_NAME,PASSWORD);
        logoutBtn = driver.findElement(By.linkText("Logout"));
        logoutBtn.click();

        changePassword("new.pass","eu.pass","eu.pass");
        assertThat(message,is("Your password has been successfully changed."));
        PASSWORD = "eu.pass";


    }

    private void changePassword(String pass, String newPass, String repeatPass){
        doLogin(USER_NAME,PASSWORD);
        page.open();
        page.changePassword(pass,newPass,repeatPass);
    }

}
