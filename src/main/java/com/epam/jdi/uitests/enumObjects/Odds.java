package com.epam.jdi.uitests.enumObjects;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Odds {
    ONE(1),
    THREE(3),
    FIVE(5),
    SEVEN(7);

    public int value;
}
