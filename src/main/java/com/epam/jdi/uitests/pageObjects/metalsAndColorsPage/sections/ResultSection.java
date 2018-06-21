package com.epam.jdi.uitests.pageObjects.metalsAndColorsPage.sections;

import com.epam.jdi.uitests.entities.MetalsAndColorsParameters;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItem;

public class ResultSection extends Section {
    @FindBy(css = ".info-panel-body-result li")
    public List<WebElement> resultPanel;

    public void checkResult(MetalsAndColorsParameters parameters) {

        List<String> resultContent = new ArrayList<>();
        for (WebElement element : resultPanel) {
            resultContent.add(element.getText());
        }

        checkSummaryResult(parameters, resultContent);
        checkElementsResult(parameters, resultContent);
        checkColorsResult(parameters, resultContent);
        checkMetalsResult(parameters, resultContent);
        checkVegetablesResult(parameters, resultContent);
    }

    private String joinEnums(Enum[] enums) {
        StringBuffer elements = new StringBuffer();
        for (Enum element : enums) {
            if (elements.length() > 0) {
                elements.append(", ");
            }
            elements.append(element.toString());
        }
        return elements.toString();
    }

    private void checkSummaryResult(MetalsAndColorsParameters parameters, List<String> resultContent) {
        int even = 2;
        int odd = 1;
        if (parameters.hasEvenValue()) {
            even = parameters.evenValue();
        }
        if (parameters.hasOddsValue()) {
            odd = parameters.oddsValue();
        }
        assertThat(resultContent, hasItem("Summary: " + (even + odd)));
    }

    private void checkElementsResult(MetalsAndColorsParameters parameters, List<String> resultContent) {
        if (parameters.hasElementsValue()) {
            assertThat(resultContent, hasItem("Elements: " + String.join(", ", parameters.elements)));
        }
    }

    private void checkColorsResult(MetalsAndColorsParameters parameters, List<String> resultContent) {
        String color = "Colors";
        if (parameters.hasColorValue()) {
            color = parameters.color;
        }
        assertThat(resultContent, hasItem("Color: " + color));
    }

    private void checkMetalsResult(MetalsAndColorsParameters parameters, List<String> resultContent) {
        String metal = "Metals";
        if (parameters.hasMetalsValue()) {
            metal = parameters.metals;
        }
        assertThat(resultContent, hasItem("Metal: " + metal));
    }

    private void checkVegetablesResult(MetalsAndColorsParameters parameters, List<String> resultContent) {
        String vegetables = "Vegetables";
        if (parameters.hasVegetablesValue()) {
            vegetables = String.join(", ", parameters.vegetables);
        }
        assertThat(resultContent, hasItem("Vegetables: " + vegetables));
    }
}