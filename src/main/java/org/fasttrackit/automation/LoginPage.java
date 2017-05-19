package org.fasttrackit.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Ioana on 5/18/2017.
 */
public class LoginPage {
    @FindBy(name = "username")
    private WebElement userNameElement;
    @FindBy(id = "password")
    private WebElement passwordElement;
    @FindBy(id = "loginButton")
    private WebElement loginBtn;
    @FindBy(className = "error-msg")
    private WebElement errorMessage;

    private LoginPage page;
    private WebDriver driver;



    public void login(String user,String pass){
        userNameElement.sendKeys(user);
        passwordElement.sendKeys(pass);
        loginBtn.click();
    }

    public String getInvalidUserOrPassWarningMessage(){
        String message = errorMessage.getText();
        return message;
    }

}
