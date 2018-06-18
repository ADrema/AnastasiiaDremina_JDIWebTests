package com.epam.jdi.uitests.homework7;

import com.epam.jdi.uitests.base.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.jdi.uitests.entities.MetalsAndColorsParameters.TEST1;
import static com.epam.jdi.uitests.entities.User.PETER;
import static com.epam.jdi.uitests.enumObjects.Pages.METALSANDCOLORS;
import static com.epam.jdi.uitests.pageObjects.site.JdiSite.homePage;
import static com.epam.jdi.uitests.pageObjects.site.JdiSite.mAcPage;

public class TestMetalsAndColoraPage extends TestBase {

    @BeforeClass()
    public static void beforeClass() {
        homePage.open();
        homePage.checkOpened();
    }

    @Test
    public void loginTest() {
//        1. Login on JDI site as User
        homePage.login(PETER);
//        2. Open Metals & Colors page by Header menu
        homePage.headerMenu.selects(METALSANDCOLORS);
        mAcPage.checkOpened();
//        3. Fill form Metals & Colors by data below:
        mAcPage.fillForm(TEST1);
//        4. Submit form Metals & Colors
        mAcPage.submitButton.click();
//        5. Result sections should contains data  below:
        mAcPage.checkResultParameters(TEST1);
    }
}
