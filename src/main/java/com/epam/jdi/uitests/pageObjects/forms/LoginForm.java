package com.epam.jdi.uitests.pageObjects.forms;

import com.epam.jdi.uitests.entities.User;
import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.TextField;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import org.openqa.selenium.support.FindBy;

public class LoginForm extends Form<User> {

    @FindBy(id = "Name")
    public TextField name;

    @FindBy(id = "Password")
    public TextField password;

    @FindBy(css = "form [type='submit']")
    public Button submit;
}
