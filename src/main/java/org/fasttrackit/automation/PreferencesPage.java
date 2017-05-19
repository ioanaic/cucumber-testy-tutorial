package org.fasttrackit.automation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by ioana.crisan on 19-05-2017.
 */
public class PreferencesPage {
    @FindBy(css = ".navbar-header button")
    private WebElement preferencesBtn;
    @FindBy(css = "#preferences-win button.close")
    private WebElement xBtn;
    @FindBy(xpath = "//*[@id='preferences-win']//input[@name='password']")
    private WebElement passwordField;
    @FindBy(xpath = "//*[@id='preferences-win']//input[@name='newPassword']")
    private WebElement newPasswordField;
    @FindBy(xpath = "//*[@id='preferences-win']//input[@name='newPasswordRepeat']")
    private WebElement confirmPasswordField;
    @FindBy(xpath = "//*[@id='preferences-win']//button[text()='Save']")
    private WebElement saveBtn;
    @FindBy(xpath = "//*[@id='preferences-win']//*[@class='status-msg']")
    private WebElement statusMsg;
    @FindBy(css = "#preferences-win .modal-footer button")
    private WebElement closeBtn;


}
