package com.epam.jdi.uitests.pageObjects.metalsAndColorsPage.forms;

import com.epam.jdi.uitests.core.interfaces.common.IButton;
import com.epam.jdi.uitests.core.interfaces.complex.ICheckList;
import com.epam.jdi.uitests.core.interfaces.complex.IComboBox;
import com.epam.jdi.uitests.core.interfaces.complex.IDropDown;
import com.epam.jdi.uitests.elements.VegetablesDropList;
import com.epam.jdi.uitests.entities.MetalsAndColorsParameters;
import com.epam.jdi.uitests.enumObjects.*;
import com.epam.jdi.uitests.pageObjects.metalsAndColorsPage.sections.Summary;
import com.epam.jdi.uitests.web.selenium.elements.common.Text;
import com.epam.jdi.uitests.web.selenium.elements.complex.CheckList;
import com.epam.jdi.uitests.web.selenium.elements.complex.ComboBox;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JDropdown;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class MetalsAndColorsForm extends Form {

    @FindBy(id = "summary-block")
    public Summary summaryBlock;

    @JDropdown(
            jroot = @JFindBy(css = ".colors"),
            jexpand = @JFindBy(css = ".caret"),
            jlist = @JFindBy(tagName = "li")
    )
    public IDropDown colorsDropDownList;

    @JDropdown(
            jroot = @JFindBy(css = "#salad-dropdown"),
            jlist = @JFindBy(css = "li"),
            jvalue = @JFindBy(tagName = "button")
    )
    public VegetablesDropList vegetablesList;

    @JFindBy(id = "salad-dropdown")
    public IButton saladButton;

    @FindBy(css = "#elements-checklist p")
    public ICheckList<Nature> nature = new CheckList<Nature>() {
        @Override
        protected boolean isSelectedAction(WebElement el) {
            return el.findElement(By.tagName("input")).getAttribute("checked") != null;
        }
    };

    public IComboBox<Metals> metalsComboBox =
            new ComboBox<Metals>(By.cssSelector(".metals .caret"), By.cssSelector(".metals li span"), By.cssSelector(".metals input")) {
                @Override
                protected String getTextAction() {
                    return new Text(By.cssSelector(".metals .filter-option")).getText();
                }
            };

    public void fill(MetalsAndColorsParameters parameters) {
        if (parameters.evenValue() > 0) {
            summaryBlock.even.select(Even.valueOf(parameters.evenValue()));
        }
        if (parameters.oddsValue() > 0) {
            summaryBlock.odds.select(Odds.valueOf(parameters.oddsValue()));
        }
        if (parameters.color.length() > 0) {
            colorsDropDownList.select(parameters.color);
        }
        if (parameters.vegetables.size() > 0) {
// workaround for site feature. Vegetables option is selected by default
            vegetablesList.select(Vegetables.VEGETABLES.value);
            vegetablesList.select(parameters.vegetables);
        }
        if (parameters.metals.length() > 0) {
            metalsComboBox.select(parameters.metals);
        }
        if (parameters.elements.size() > 0) {
            nature.select(parameters.elements.toArray(new String[parameters.elements.size()]));
        }
    }
}
