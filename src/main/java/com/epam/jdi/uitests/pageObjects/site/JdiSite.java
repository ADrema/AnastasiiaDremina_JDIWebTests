package com.epam.jdi.uitests.pageObjects.site;

import com.epam.jdi.uitests.pageObjects.site.pages.HomePage;
import com.epam.jdi.uitests.pageObjects.site.pages.MetalsAndColorsPage;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;

import static com.epam.jdi.uitests.core.interfaces.complex.tables.interfaces.CheckPageTypes.CONTAINS;

public class JdiSite extends WebSite {
    @JPage(value = "/index.html", title = "Home Page", titleCheckType = CONTAINS)
    public static HomePage homePage;

    @JPage(value = "/metals-colors.html", title = "Metal and Colors", titleCheckType = CONTAINS)
    public static MetalsAndColorsPage metalsAndColorsPage;

}
