package com.epam.jdi.uitests.utils;

import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public final class JavaPropertyLoader {

    private static final String MY_PROPERTIES = "my.properties";
    private static Properties properties;

    private static void load() throws IOException {
        properties = new Properties();
        properties.load(JavaPropertyLoader.class.getClassLoader().getResourceAsStream(MY_PROPERTIES));
    }

    public static String getProperty(String propertyName) {
        if (Objects.isNull(properties)) {
            try {
                load();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return (String) properties.get(propertyName);
    }
}
