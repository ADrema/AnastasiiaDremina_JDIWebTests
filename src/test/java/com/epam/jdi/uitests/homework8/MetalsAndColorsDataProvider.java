package com.epam.jdi.uitests.homework8;

import com.epam.jdi.uitests.entities.MetalsAndColorsParameters;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

public class MetalsAndColorsDataProvider {
    //  TODO static import
    //  Done
    @DataProvider(name = "readFromJson")
    public static Object[][] getData() throws FileNotFoundException {
        JsonElement jsonData = new JsonParser().parse(new FileReader("src/test/resources/sourceData/JDI_ex8_metalsColorsDataSet.json"));
        JsonObject dataSet = jsonData.getAsJsonObject();

        // TODO you can just use a different type token in according to data structure...
        // Done
        HashMap<String, MetalsAndColorsParameters> testData = new Gson().fromJson(dataSet, new TypeToken<HashMap<String, MetalsAndColorsParameters>>() {
        }.getType());

        Object[][] returnValue = new Object[testData.size()][1];

        int index = 0;
        for (Object[] each : returnValue) {
            each[0] = testData.get("data_" + (++index));
        }
        return returnValue;
    }
}
