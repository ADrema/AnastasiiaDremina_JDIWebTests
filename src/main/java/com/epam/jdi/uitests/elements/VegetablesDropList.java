package com.epam.jdi.uitests.elements;

import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;

import java.util.List;

public class VegetablesDropList extends Dropdown {

    public void select(List<String> vegetables) {
        for (String element : vegetables) {
            select(element);
        }
    }

    public void unselect(List<String> vegetables) {
        select(vegetables);
    }
}
