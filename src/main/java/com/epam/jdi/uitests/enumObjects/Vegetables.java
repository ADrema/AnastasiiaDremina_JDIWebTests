package com.epam.jdi.uitests.enumObjects;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public enum Vegetables {
    CUCUMBER("Cucumber"),
    TOMATO("Tomato"),
    VEGETABLES("Vegetables"),
    ONION("Onion");

    public String value;

    public String toString() {
        return value;
    }
}
