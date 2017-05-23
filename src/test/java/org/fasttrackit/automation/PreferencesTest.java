package org.fasttrackit.automation;

import org.fasttrackit.util.TestBase;
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
        page.changePassword("wrong.pass", "new.pass", "new.pass");
        String message = page.getIncorrectMessage();
        assertThat(message, is("Your preview password is incorrect!"));

    }

    @Test
    public void tryToChangePasswordWithInvalidConfirmPasswordTest() {
        page.changePassword("eu.pass","new.pass","new.pass.wrong");
        String message = page.getIncorrectMessage();
        assertThat(message,is("Password does not match the confirm password!"));
    }
    @Test
    public void successChangePassTest(){
        page.changePassword("eu.pass","new.pass","new.pass");
        String message = page.getIncorrectMessage();
        assertThat(message,is("Your password has been successfully changed."));



    }

}
