package com.epam.jdi.uitests.elements;

import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;

import java.util.List;

import static com.epam.jdi.uitests.enumObjects.Vegetables.VEGETABLES;

public class VegetablesDropList extends Dropdown {

    public void select(List<String> vegetables) {

//        To unselect default value if it's not presented in the list
        if (!vegetables.contains(VEGETABLES.value)) {
            unselect(VEGETABLES.value);
        }

        for (String element : vegetables) {
            if (!element.equals(VEGETABLES.value)) {
                select(element);
            }
        }
    }

    public void unselect(String vegetables) {
        select(vegetables);
    }
}
