package com.epam.jdi.uitests.homework8;

import com.epam.jdi.uitests.entities.MetalsAndColorsParameters;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class MetalsAndColorsDataProvider {
    @DataProvider(name = "readFromJson")
    public static Object[][] getData() throws FileNotFoundException {
        JsonElement jsonData = new JsonParser().parse(new FileReader("src/test/resources/sourceData/JDI_ex8_metalsColorsDataSet.json"));
        JsonObject dataSet = jsonData.getAsJsonObject();
        Set<String> keys = dataSet.keySet();

        JsonArray arr = new JsonArray();
        for (String k : keys) {
            arr.add(dataSet.get(k));
        }

        // TODO you can just use a different type token in according to data structure...
        // TODO Map<Str, Data>
        List<MetalsAndColorsParameters> testData = new Gson().fromJson(arr, new TypeToken<List<MetalsAndColorsParameters>>() {
        }.getType());

        Object[][] returnValue = new Object[testData.size()][1];

        int index = 0;
        for (Object[] each : returnValue) {
            each[0] = testData.get(index++);
        }
        return returnValue;
    }
}
