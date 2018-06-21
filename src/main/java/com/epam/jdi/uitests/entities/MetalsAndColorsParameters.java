package com.epam.jdi.uitests.entities;

import com.epam.jdi.uitests.enumObjects.Colors;
import com.epam.jdi.uitests.enumObjects.Metals;
import com.epam.jdi.uitests.enumObjects.Nature;
import com.epam.jdi.uitests.enumObjects.Vegetables;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class MetalsAndColorsParameters {

    public static MetalsAndColorsParameters TEST1 = new MetalsAndColorsParameters(
            new ArrayList<Integer>() {{
                add(3);
                add(8);
            }},
            new ArrayList<String>() {{
                add(Nature.WATER.value);
                add(Nature.WIND.value);
            }},
            Colors.RED.value,
            Metals.SELEN.value,
            new ArrayList<String>() {{
                add(Vegetables.CUCUMBER.value);
                add(Vegetables.TOMATO.value);
            }}
    );

    public List<Integer> summary;
    public List<String> elements;
    public String color;
    public String metals;
    public List<String> vegetables;

    public int evenValue() {
        return summary.size() == 2 ? summary.get(1) : 0;
    }

    public int oddsValue() {
        return summary.size() == 2 ? summary.get(0) : 0;
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
