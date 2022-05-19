package org.example.task4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class ImportExportOperations {

    public static List<String> toImport(String name) throws FileNotFoundException {
        String path = name;

        File file = new File(path);

        List<String> input = new ArrayList<>();
        BufferedReader br = null;
        try {

            br = new BufferedReader(new FileReader(file));
            String line = null;

            while ((line = br.readLine()) != null) {

                String[] parts = line.split(" ");

                String x = parts[0].trim();

                {
                    input.add(x);

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
        return input;
    }
}
