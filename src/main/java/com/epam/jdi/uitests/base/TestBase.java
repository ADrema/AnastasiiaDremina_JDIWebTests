package com.epam.jdi.uitests.base;

import com.epam.jdi.uitests.pageObjects.site.JdiSite;
import com.epam.jdi.uitests.utils.MyConfig;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public abstract class TestBase extends TestNGBase {
    MyConfig config;
    private long initTime;

    @BeforeSuite
    @SuppressWarnings("unchecked")
    public void beforeSuite() {

        initTime = System.currentTimeMillis();
        config = ConfigFactory.create(MyConfig.class);
        WebSite.init(JdiSite.class);
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("Test-case execution time " + (System.currentTimeMillis() - initTime));
    }
}





