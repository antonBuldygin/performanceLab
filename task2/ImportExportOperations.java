package org.example.task2;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class ImportExportOperations {

    public static Map<Integer, Coordinates> toImport(String name) throws FileNotFoundException {
        String path = name;

        File file = new File(path);

        Map<Integer, Coordinates> map
                = new TreeMap<>();
        int id = 0;
        BufferedReader br = null;
        try {

            br = new BufferedReader(new FileReader(file));
            String line = null;

            while ((line = br.readLine()) != null) {

                String[] parts = line.split(" ");

                String x = parts[0].trim();
                String y = null;
                if (x.equals("") && parts.length == 1) {
                    y = parts[1].trim();
                }

                if (parts.length > 1) {
                    y = parts[1].trim();
                }


                {
                    map.put(id, new Coordinates(x, y));
                    id++;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                }


            }

        }
        return map;
    }
}
