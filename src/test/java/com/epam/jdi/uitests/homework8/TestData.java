package com.epam.jdi.uitests.homework8;

import com.epam.jdi.uitests.enumObjects.Colors;
import com.epam.jdi.uitests.enumObjects.Metals;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TestData {
    private String[] summary;
    private String[] elements;
    private Colors color;
    private Metals metals;
    private String[] vegetables;

    @Override
    public String toString() {
        return "TestData{" +
                "summary='" + String.join(", ", summary) + '\'' +
                ", elements='" + String.join(", ", elements) + '\'' +
                ", color='" + color + '\'' +
                ", metals='" + metals + '\'' +
                ", vegetables=" + String.join(", ", vegetables) +
                '}';
    }
}
