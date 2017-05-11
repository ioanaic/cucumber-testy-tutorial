package org.fasttrackit.automation;

import com.sdl.selenium.web.utils.Utils;
import org.fasttrackit.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;

/**
 * Created by Ioana on 5/11/2017.
 */
public class PreferencesTest extends TestBase {
    @Test
    public void preferencesWindowShouldClose() {
        LoginTest login = new LoginTest();
        login.doLogin("eu@fast.com", "eu.pass");

        WebElement preferencesButton = driver.findElement(By.cssSelector(".navbar-header button"));
        preferencesButton.click();
        WebElement closeXBtn = driver.findElement(By.cssSelector("#preferences-win button.close"));
        Utils.sleep(400);
        //WebElement closeBtn = driver.findElement(By.cssSelector("#preferences-win .modal-footer button"));
        closeXBtn.click();


    }

    @Test
    public void preferencesWindow() {
        doLogin("eu@fast.com", "eu.pass");

        WebElement preferencesButton = driver.findElement(By.cssSelector(".navbar-header button"));
        preferencesButton.click();
        WebElement closeXBtn = driver.findElement(By.cssSelector("#preferences-win button.close"));
        Utils.sleep(400);
        //WebElement closeBtn = driver.findElement(By.cssSelector("#preferences-win .modal-footer button"));
        //   closeXBtn.click();


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

        WebElement statusMsg = driver.findElement(By.xpath("//'[*id='preferences-win']//*class=status-msg"));

        assertThat(message, is("Invalid user or password!"));

    }


}
