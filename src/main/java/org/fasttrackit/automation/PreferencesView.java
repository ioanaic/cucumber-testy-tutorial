package org.fasttrackit.automation;

import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.button.Button;
import com.sdl.selenium.web.form.TextField;
import com.sdl.selenium.web.utils.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by ioana.crisan on 19-05-2017.
 */
public class PreferencesView extends WebLocator {

    private Button preferencesBtn = new Button().setText("Preferences");

    public PreferencesView() {
        setId("preferences-win");
    }

//  private WebLocator win = new WebLocator().setId("preferences-win");

    private WebLocator xBtn = new Button(this).setClasses("close");

    private TextField passwordField = new TextField(this).setName("password");
    private TextField newPasswordField = new TextField(this).setName("newPassword");
    private TextField confirmPasswordField = new TextField(this).setName("newPasswordRepeat");

    private Button saveBtn = new Button().setText("Save");

    private WebLocator statusMsg = new WebLocator(this).setClasses("status-msg");

    //or private Button closeBtn = new Button(win).setElCssSelector(".modal-footer button");

    private Button closeBtn = new Button(this).setText("Close");

    public void open() {
        preferencesBtn.click();
        Utils.sleep(400);
    }


    public void changePassword(String pass, String newPass, String repeatPass) {
        passwordField.setValue(pass);
        newPasswordField.setValue(newPass);
        confirmPasswordField.setValue(repeatPass);
        saveBtn.click();
    }

    public void close() {
        xBtn.click();
        Utils.sleep(400);
    }

    public String getStatusMsg() {
        return statusMsg.getText();
    }

    //test
//    public String getIncorrectMessage() {
//        String messageText = statusMsg.getText();
//        return messageText;
//    }


}
