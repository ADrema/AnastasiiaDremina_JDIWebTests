package com.epam.jdi.uitests.pageObjects.site.pages;

import com.epam.jdi.uitests.core.interfaces.common.IText;
import com.epam.jdi.uitests.entities.MetalsAndColorsParameters;
import com.epam.jdi.uitests.pageObjects.forms.MetalsAndColorsForm;
import com.epam.jdi.uitests.pageObjects.sections.ResultSection;
import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.Text;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class MetalsAndColorsPage extends WebPage {

    public MetalsAndColorsForm form;
    public ResultSection result;

    @FindBy(id = "calculate-button")
    public Button calculateButton;

    @FindBy(id = "submit-button")
    public Button submitButton;

    @FindBy(css = ".summ-res")
    public IText calculateText = new Text() {
        @Override
        protected String getTextAction() {
            return getDriver().findElement(By.cssSelector(".summ-res")).getText();
        }
    };

    public void fillForm(MetalsAndColorsParameters parameters) {
        form.fill(parameters);
    }

    public void checkResultParameters(MetalsAndColorsParameters parameters) {
        result.checkResult(parameters);
    }
}
