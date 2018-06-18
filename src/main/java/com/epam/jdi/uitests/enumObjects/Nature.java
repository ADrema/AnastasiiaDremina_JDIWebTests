package com.epam.jdi.uitests.enumObjects;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Nature {
    WATER("Water"),
    EARTH("Earth"),
    WIND("Wind"),
    FIRE("Fire");

    public String value;

    public String toString() {
        return value;
    }
}
