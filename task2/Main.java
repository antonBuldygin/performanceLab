package org.example.task2;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


public class Main {

    public static void main(String[] args) {
        Map<Integer, String> arguments = new HashMap<>();
        String pointsCoordinates;
        String circleCoordinates;
        Map<Integer, Coordinates> circleData = new TreeMap<>();
        Map<Integer, Coordinates> points = new TreeMap<>();
        for (int i = 0; i < args.length; i++) {
            arguments.put(i, args[i]);
        }

        pointsCoordinates = arguments.getOrDefault(1, "./src/main/java/org/example/task2/file2.txt");
        try {
            points = ImportExportOperations.toImport(pointsCoordinates);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        circleCoordinates = arguments.getOrDefault(0, "./src/main/java/org/example/task2/file1.txt");

        try {
            circleData = ImportExportOperations.toImport(circleCoordinates);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String circleX = circleData.get(0).getX();
        String circleY = circleData.get(0).getY();
        String circleRadius = circleData.get(1).getX();

//        System.out.println(circleX+" "+circleY+" "+ circleRadius);

        for (Map.Entry<Integer, Coordinates> res : points.entrySet()
        ) {

            double r = Math.sqrt(Math.pow((Float.valueOf(res.getValue().getX()) - Float.valueOf(circleX)), 2) + Math.pow((Float.valueOf(res.getValue().getY()) - Float.valueOf(circleY)), 2));
            int out = Float.valueOf(circleRadius) == r ? 0 : (Float.valueOf(circleRadius) > r ? 1 : 2);

            System.out.println(out);
//             System.out.println(res.getValue().getX() + "     " + res.getValue().getY() + " "+r+" "+circleRadius);
        }
    }
}
