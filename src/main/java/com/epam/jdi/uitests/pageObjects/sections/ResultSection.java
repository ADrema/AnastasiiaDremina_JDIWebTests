package com.epam.jdi.uitests.pageObjects.sections;

import com.epam.jdi.uitests.entities.MetalsAndColorsParameters;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import com.epam.web.matcher.testng.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

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
        if (parameters.evenValue() > 0) {
            even = parameters.evenValue();
        }
        if (parameters.oddsValue() > 0) {
            odd = parameters.oddsValue();
        }
        Assert.assertTrue(resultContent.contains("Summary: " + (even + odd)));
    }

    private void checkElementsResult(MetalsAndColorsParameters parameters, List<String> resultContent) {
        if (parameters.metals.length() > 0) {
            Assert.assertTrue(resultContent.contains("Elements: " + String.join(", ", parameters.elements)));
        }
    }

    private void checkColorsResult(MetalsAndColorsParameters parameters, List<String> resultContent) {
        String color = "Colors";
        if (parameters.color.length() > 0) {
            color = parameters.color;
        }
        Assert.assertTrue(resultContent.contains("Color: " + color));
    }

    private void checkMetalsResult(MetalsAndColorsParameters parameters, List<String> resultContent) {
        String metal = "Metals";
        if (parameters.metals.length() > 0) {
            metal = parameters.metals;
        }
        Assert.assertTrue(resultContent.contains("Metal: " + metal));
    }

    private void checkVegetablesResult(MetalsAndColorsParameters parameters, List<String> resultContent) {
        String vegetables = "Vegetables";
        if (parameters.vegetables.length > 0) {
            vegetables = String.join(", ", parameters.vegetables);
        }
        Assert.assertTrue(resultContent.contains("Vegetables: " + vegetables));
    }
}