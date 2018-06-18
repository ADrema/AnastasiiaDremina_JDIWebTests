package com.epam.jdi.uitests.elements;

import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;

public class VegetablesDropList extends Dropdown {

    public void select(String... vegetables) {
        for (String element : vegetables) {
            System.out.println("TRYING TO CHECK ELEMENT " + element);
            select(element);
        }
    }

    public void unselect(String... vegetables) {
        select(vegetables);
    }
}
