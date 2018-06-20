package com.epam.jdi.uitests.pageObjects.site.pages;

import com.epam.jdi.uitests.entities.User;
import com.epam.jdi.uitests.enumObjects.Pages;
import com.epam.jdi.uitests.pageObjects.common.elements.HeaderMenu;
import com.epam.jdi.uitests.pageObjects.common.forms.LoginForm;
import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import org.openqa.selenium.support.FindBy;

public class HomePage extends WebPage {
    public LoginForm loginForm;

    @FindBy(css = ".nav")
    public HeaderMenu<Pages> headerMenu;

    @FindBy(css = ".profile-photo")
    private Button profileIcon;

    public void login(User user) {
        profileIcon.click();
        loginForm.login(user);
    }
}
