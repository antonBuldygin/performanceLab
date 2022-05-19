package org.example.task3;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Main {
    public List<Test> getTests() {
        return tests;
    }

    List<Test> tests = new ArrayList<>();

    public static void main(String[] args) {
        Map<Integer, String> arguments = new HashMap<>();
        for (int i = 0; i < args.length; i++) {
            arguments.put(i, args[i]);
        }

        String valuesFile = arguments.getOrDefault(0, "./src/main/java/org/example/task3/values.json");
        String testsFile = arguments.getOrDefault(1, "./src/main/java/org/example/task3/tests.json");

      Main testsConverter = new Main();
        List<Test> tests = testsConverter.getTests();
        JSONParsingTest jsonParsingTest = new JSONParsingTest();
        List<Values> values = jsonParsingTest.valuesFromJson(valuesFile);


        JsonElement root = null;

        {
            try {
                root = new JsonParser().parse(new FileReader(testsFile));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
//        System.out.println(root);
        JsonArray object = root.getAsJsonObject().get("tests").getAsJsonArray();
//        System.out.println(object);
        tests = extracted(testsConverter.getTests(), object, values);
//        System.out.println(tests);
        testsConverter.getTestResults(testsConverter);
    }

    private static String resultsFilling(Integer id, List<Values> values) {
        String value = "";
        for (int j = 0; j < values.size(); j++) {
            if (id.equals(values.get(j).getId())) {
                value = values.get(j).getValue();
            }
        }
        return value;
    }

    public static void getTestResults(Main testsConverter) {
        Map<String, List<Test>> jsonValues = new LinkedHashMap<>();
        jsonValues.put("tests", testsConverter.getTests());
        String json = new Gson().toJson(jsonValues);
        System.out.println(json);
    }


    private static List<Test> extracted(List<Test> tests, JsonArray object, List<Values> values) {
        for (int i = 0; i < object.size(); i++) {
            JsonElement element = object.get(i)
                    .getAsJsonObject()
                    .get("values");
            if (element == null) {
                String id = object.get(i)
                        .getAsJsonObject()
                        .get("id")
                        .getAsString();
                String value = object.get(i)
                        .getAsJsonObject()
                        .get("value")
                        .getAsString();
                String title = object.get(i)
                        .getAsJsonObject()
                        .get("title")
                        .getAsString();

                value = resultsFilling(Integer.parseInt(id), values);
                tests.add(new Test(Integer.parseInt(id), title, value));

            } else {
                String id = object.get(i)
                        .getAsJsonObject()
                        .get("id")
                        .getAsString();
                String value = object.get(i)
                        .getAsJsonObject()
                        .get("value")
                        .getAsString();
                String title = object.get(i)
                        .getAsJsonObject()
                        .get("title")
                        .getAsString();

                List<Test> valuesToGet = new ArrayList<>();
                JsonArray valuesJsonArray = object.get(i)
                        .getAsJsonObject()
                        .get("values")
                        .getAsJsonArray();

                value = resultsFilling(Integer.parseInt(id), values);
                tests.add(new Test(Integer.parseInt(id), title, value, extracted(valuesToGet, valuesJsonArray, values)));
            }
        }
        return tests;
    }
}
