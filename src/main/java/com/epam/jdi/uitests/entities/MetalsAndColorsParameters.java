package com.epam.jdi.uitests.entities;

import com.epam.jdi.uitests.enumObjects.Colors;
import com.epam.jdi.uitests.enumObjects.Metals;
import com.epam.jdi.uitests.enumObjects.Nature;
import com.epam.jdi.uitests.enumObjects.Vegetables;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class MetalsAndColorsParameters {

    public static MetalsAndColorsParameters TEST1 = new MetalsAndColorsParameters(
            new Integer[]{3, 8},
            new String[]{
                    Nature.WATER.value,
                    Nature.WIND.value
            },
            Colors.RED.value,
            Metals.SELEN.value,
            new String[]{
                    Vegetables.CUCUMBER.value,
                    Vegetables.TOMATO.value
            },
            new String[]{Vegetables.VEGETABLES.value}
    );

    // TODO it will be better with List<...>
    public Integer[] summary;
    public String[] elements;
    public String color;
    public String metals;
    public String[] vegetables;

    // TODO this should not be here, couse you're described an entity regardless the element behaviour
    public String[] unselectVegetables = new String[]{Vegetables.VEGETABLES.value};


    public int evenValue() {
        if (summary.length != 2) {
            return 0;
        }
        return summary[1];
    }

    public int oddsValue() {
        return summary.length != 2 ? 0 : summary[0];
    }

    @Override
    public String toString() {
        return "TestData{" +
                "summary='" + evenValue() + " : " + oddsValue() + "'" +
                ", elements='" + String.join(", ", elements) + '\'' +
                ", color='" + color + '\'' +
                ", metals='" + metals + '\'' +
                ", vegetables=" + String.join(", ", vegetables) +
                '}';
    }
}
