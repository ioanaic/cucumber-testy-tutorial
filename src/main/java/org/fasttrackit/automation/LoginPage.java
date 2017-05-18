package org.fasttrackit.automation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Ioana on 5/18/2017.
 */
public class LoginPage {
    @FindBy(name = "username")
    public WebElement userNameElement;
    @FindBy(id = "password")
    public WebElement passwordElement;
    @FindBy(id = "loginButton")
    public WebElement loginBtn;

    public static void main(String[] args) {
        LoginPage loginPage = new LoginPage();
    }

}
