package com.epam.jdi.uitests.homework8;

import com.epam.jdi.uitests.base.TestBase;
import com.epam.jdi.uitests.entities.MetalsAndColorsParameters;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.jdi.uitests.core.settings.JDISettings.logger;
import static com.epam.jdi.uitests.entities.User.PETER;
import static com.epam.jdi.uitests.enumObjects.Pages.METALSANDCOLORS;
import static com.epam.jdi.uitests.pageObjects.site.JdiSite.homePage;
import static com.epam.jdi.uitests.pageObjects.site.JdiSite.metalsAndColorsPage;

public class TestMetalsAndColorsPage extends TestBase {

    @BeforeClass(alwaysRun = true)
    public void beforeMEthod() {
        logger.info("Test-case has been started");
        homePage.open();
        homePage.checkOpened();
//        1. Login on JDI site as User
        homePage.login(PETER);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        metalsAndColorsPage.refresh();
    }

    @Test(dataProviderClass = DataProvider.class, dataProvider = "readFromJson")
    public void loginTest(MetalsAndColorsParameters parameters) {

//        2. Open Metals & Colors page by Header menu
        homePage.headerMenu.selects(METALSANDCOLORS);
        metalsAndColorsPage.checkOpened();

//        3. Fill form Metals & Colors by data below:
        metalsAndColorsPage.fillForm(parameters);

//        4. Submit form Metals & Colors
        metalsAndColorsPage.submitButton.click();

//        5. Result sections should contains data  below:
        metalsAndColorsPage.checkResultParameters(parameters);
    }
}
