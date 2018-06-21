package com.epam.jdi.uitests.pageObjects.metalsAndColorsPage.forms;

import com.epam.jdi.uitests.core.interfaces.common.IButton;
import com.epam.jdi.uitests.core.interfaces.complex.ICheckList;
import com.epam.jdi.uitests.core.interfaces.complex.IComboBox;
import com.epam.jdi.uitests.core.interfaces.complex.IDropDown;
import com.epam.jdi.uitests.elements.VegetablesDropList;
import com.epam.jdi.uitests.entities.MetalsAndColorsParameters;
import com.epam.jdi.uitests.enumObjects.Metals;
import com.epam.jdi.uitests.enumObjects.Nature;
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
        // TODO it does not make scene to check all fields here, actually.
        // TODO if you want to do that, it will be better to check it in
        // TODO data preparation phase or somewhere else, but ONCE
        // Done?
        if (parameters.hasEvenValue()) {
            // TODO do you have a chance to read IDEA warning ? You might have NPE here...
            // TODO if you're really enjoin of enums for Integers, encapsulate it in MetalsAndColorsParameters.class
            // TODO but from my point, it's useless...
            // Done
            summaryBlock.even.select(String.valueOf(parameters.evenValue()));
        }
        if (parameters.hasOddsValue()) {
            summaryBlock.odds.select(String.valueOf(parameters.oddsValue()));
        }
        if (parameters.hasColorValue()) {
            colorsDropDownList.select(parameters.color);
        }
        // workaround for site feature. Vegetables option is selected by default
        // TODO you have to use "unselect" method for this purpose.
//            Done.
        // TODO Method "select" should not click on item in case if it selected already
//            Done
        vegetablesList.select(parameters.vegetables);
        if (parameters.hasMetalsValue()) {
            metalsComboBox.select(parameters.metals);
        }
        nature.select(parameters.elements.toArray(new String[parameters.elements.size()]));
//            java.lang.ClassCastException: [Ljava.lang.Object; cannot be cast to [Ljava.lang.String;
//            nature.select((String[]) parameters.elements.toArray());
    }
}
