package com.epam.jdi.uitests.enumObjects;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Even {
    TWO(2),
    FOUR(4),
    SIX(6),
    EIGHT(8);

    public int value;

    public static Even valueOf(int val) {
        for (Even o : values()) {
            if (o.value == val) {
                return o;
            }
        }
        return null;
    }
}
