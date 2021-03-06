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
    @DataProvider(name = "readFromJson")
    public static Object[] getData() throws FileNotFoundException {
        JsonElement jsonData = new JsonParser().parse(new FileReader("src/test/resources/sourceData/JDI_ex8_metalsColorsDataSet.json"));
        JsonObject dataSet = jsonData.getAsJsonObject();

        HashMap<String, MetalsAndColorsParameters> testData = new Gson().fromJson(dataSet, new TypeToken<HashMap<String, MetalsAndColorsParameters>>() {
        }.getType());

        return testData.values().toArray();
        // TODO what is this ? Take a look on HashMap::values method...
        // Done
    }
}
