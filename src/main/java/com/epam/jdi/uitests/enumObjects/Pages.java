package com.epam.jdi.uitests.enumObjects;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
// TODO code convention mismatch
// Done. Underscore was added
public enum Pages {
    HOME("Home"),
    SERVICE("Service"),
    CONTACT_FORM("Contact form"),
    METALS_AND_COLORS("Metals & Colors");

    public String value;

    @Override
    public String toString() {
        return value;
    }
}
