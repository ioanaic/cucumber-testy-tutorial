package org.fasttrackit.automation;

import com.sdl.selenium.bootstrap.form.CheckBox;
import com.sdl.selenium.web.WebLocator;

import com.sdl.selenium.web.table.Table;
import org.fasttrackit.util.TestBase;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 * Created by Ioana on 5/25/2017.
 */
public class ExamplesTest extends TestBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExamplesTest.class);
    Table table = new Table().setClasses("table-striped");

    WebLocator firstName = new WebLocator().setText("John");
    WebLocator lastName = new WebLocator().setText("Moore");
    WebLocator email = new WebLocator().setText("nickwhite@mail.com");
    WebLocator row = new WebLocator().setTag("tr").setChildNodes(email);
    CheckBox select = new CheckBox(row);

    @Test
    private void preferencesWindowShouldClose() {
        doLogin(USER_NAME, PASSWORD);

        //  WebLocator row = new WebLocator().setTag("tr").setPosition(5); OR
        WebLocator row = new WebLocator().setTag("tr");
        WebLocator email = new WebLocator().setText("nickwhite@mail.com");
        row.setChildNodes(email);

        CheckBox select = new CheckBox(row);
        select.click();
    }

}
