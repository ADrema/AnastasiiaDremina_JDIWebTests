package com.epam.jdi.uitests.pageObjects.elements;

import com.epam.jdi.uitests.web.selenium.elements.complex.Menu;

public class HeaderMenu<T extends Enum> extends Menu<T> {

    @SafeVarargs
    public final void selects(T... items) {
        for (T t : items) {
            select(t);
        }
    }
}
