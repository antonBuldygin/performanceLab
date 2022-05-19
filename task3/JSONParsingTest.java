package org.example.task3;


import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class JSONParsingTest {
    public List<Values> getValues() {
        return values;
    }

    public JSONParsingTest() {
    }

    public void setValues(List<Values> values) {
        this.values = values;
    }

    List<Values> values = new ArrayList<>();

    public static List<Values> valuesFromJson(String path) {
        List<Values> values = new ArrayList<>();
        JsonElement root = null;

        {
            try {
                root = new JsonParser().parse(new FileReader(path));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
//        System.out.println(root);
        JsonArray object = root.getAsJsonObject().get("values").getAsJsonArray();
//        System.out.println(object);

        for (int i = 0; i < object.size(); i++) {

            String id = object.get(i)
                    .getAsJsonObject()
                    .get("id")
                    .getAsString();

            String value = object.get(i)
                    .getAsJsonObject()
                    .get("value")
                    .getAsString();
            values.add(new Values(Integer.parseInt(id), value));
        }
        return values;
    }

}

//    public static void main(String[] args) {
//        JSONParsingTest jsonParsingTest = new JSONParsingTest();
//        List<Values> values = valuesFromJson();
//
//        for (Values val : values
//        ) {
//            System.out.println(val.getId() + ":" + val.getValue());
//            values.contains(val.getId());
//        }
//
//        Map<String, List<Values>> jsonValues = new LinkedHashMap<>();
//        jsonValues.put("values", values);
//        String json = new Gson().toJson(jsonValues);
//        System.out.println(json);
//    }