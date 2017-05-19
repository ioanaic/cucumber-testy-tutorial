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
    public void tryTochangePasswordWithInvalidCurrentPassword() {
        // doLogin("eu@fast.com","eu.pass");
        changePassword();

        WebElement statusMsg = driver.findElement(By.xpath("//'[*id='preferences-win']//*[@class=status-msg]"));
        String message = statusMsg.getText();
        System.out.println(message);

        assertThat(message, is("Your preview password is incorrect!"));

    }

    private void changePassword() {

        WebElement passwordField = driver.findElement(By.xpath("//*[@id='preferences-win']//input[@name='password']"));
        WebElement newpasswordField = driver.findElement(By.xpath("//*[@id='preferences-win']//input[@name='newPassword']"));
        WebElement confirmpasswordField = driver.findElement(By.xpath("//*[@id='preferences-win']//input[@name='newPasswordRepeat']"));
        WebElement saveBtn = driver.findElement(By.xpath("//*[@id='preferences-win']//button[text()='Save']"));

        saveBtn.click();
        passwordField.sendKeys("wrong.pass");
        newpasswordField.sendKeys("new.pass");
        confirmpasswordField.sendKeys("new.pass");
    }

    @Test
    public void tryToChangePassWithInvalidConfimPass() {

    }
}
