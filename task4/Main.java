package org.example.task4;

import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Map<Integer, String> arguments = new HashMap<>();
        String pointsCoordinates;
        String circleCoordinates;
        List<String> resultArray = new ArrayList<>();
        for (int i = 0; i < args.length; i++) {
            arguments.put(i, args[i]);
        }

       String enterData = arguments.getOrDefault(0, "./src/main/java/org/example/task4/file1.txt");
        try {
          resultArray = ImportExportOperations.toImport(enterData);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        List<Integer> stepscount = new ArrayList<>(0);
            for (int i = 0; i < resultArray.size(); i++) {
                int sum =0;
                for (int j = 0; j < resultArray.size(); j++) {
                    sum += Math.abs(Integer.parseInt(resultArray.get(i))-Integer.parseInt(resultArray.get(j)));


                } stepscount.add(sum);


            }
        System.out.println(Collections.min(stepscount));
        }

        }


