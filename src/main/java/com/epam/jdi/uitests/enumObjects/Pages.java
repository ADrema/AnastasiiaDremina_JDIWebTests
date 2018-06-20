package com.epam.jdi.uitests.enumObjects;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
// TODO code convention mismatch
public enum Pages {
    HOME("Home"),
    SERVICE("Service"),
    CONTACTFORM("Contact form"),
    METALSANDCOLORS("Metals & Colors");

    public String value;

    @Override
    public String toString() {
        return value;
    }
}
