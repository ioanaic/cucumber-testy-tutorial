package org.fasttrackit.automation;

import org.fasttrackit.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LoginTest extends TestBase {

    private LoginPage page;

    @Test
    public void validLoginTest() {
        doLogin(USER_NAME, PASSWORD);
        WebElement logout = driver.findElement(By.linkText("Logout"));
        logout.click();

    }

    @Test(dataProvider = "invalidUsers")
    public void invalidLoginText(String user, String pass, String expectedMessage) {
        doLogin(user, pass);

        WebElement errorMsg = driver.findElement(By.className("error-msg"));
        String message = errorMsg.getText();
        System.out.println(message);

        assertThat(message, is(expectedMessage));
    }
    @DataProvider
    public Object[][] invalidUsers() {
        return new Object[][]{
                {"wrong@user", "wrong.pass", "Invalid user or password!"},
                {"empty.pass@user", "", "Please enter your password!"},
                {"", "empty.user", "Please enter your email!"},
                {"", "", "Please enter your email!"}
        };
    }


}