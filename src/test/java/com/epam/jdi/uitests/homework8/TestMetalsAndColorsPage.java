package com.epam.jdi.uitests.homework8;

import com.epam.jdi.uitests.base.TestBase;
import com.epam.jdi.uitests.entities.MetalsAndColorsParameters;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.jdi.uitests.entities.User.PETER;
import static com.epam.jdi.uitests.enumObjects.Pages.METALSANDCOLORS;
import static com.epam.jdi.uitests.pageObjects.site.JdiSite.homePage;
import static com.epam.jdi.uitests.pageObjects.site.JdiSite.mAcPage;

public class TestMetalsAndColorsPage extends TestBase {

    @BeforeClass
    public void beforeMEthod() {
//        1. Login on JDI site as User
        homePage.open();
        homePage.checkOpened();
        homePage.login(PETER);
    }

    @AfterMethod
    public void afterMethod() {
        mAcPage.refresh();
    }

    @Test(dataProviderClass = DataProvider.class, dataProvider = "readFromJson")
    public void loginTest(MetalsAndColorsParameters parameters) {
//        2. Open Metals & Colors page by Header menu
        homePage.headerMenu.selects(METALSANDCOLORS);
        mAcPage.checkOpened();

//        3. Fill form Metals & Colors by data below:
        mAcPage.fillForm(parameters);
//        4. Submit form Metals & Colors
        mAcPage.submitButton.click();
//        5. Result sections should contains data  below:
        mAcPage.checkResultParameters(parameters);
    }
}
