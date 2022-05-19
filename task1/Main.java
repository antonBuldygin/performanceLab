package org.example.task1;

import java.util.*;

/**
 * Hello world!
 */
public class Main {

       public static void main(String[] args) {
        Map<Integer, String> argsMap = new HashMap<>();
        for (int i = 0; i < args.length; i ++) {
            argsMap.put(i, args[i]);
        }
        int n = Integer.parseInt(argsMap.getOrDefault(0, "5" ));
        int m = Integer.parseInt(argsMap.getOrDefault(1, "4" ));

        Integer[] roundArray = new Integer[n];
        boolean flag = true;
        Map<Integer, List<Integer>> map = new TreeMap<>();
        int id = 0;
        int i = 0;
        int first = 1;
        int count = 0;
        int inter = 0;
        Integer[] aplitArray = new Integer[m];

        while (flag) {
            if (i == (m - 1)) {
                aplitArray[i] = first;
                i++;
                inter = first;
            }
            if (i < (m - 1) && first > n) {
                first = 1;
            }
            if (i < (m - 1) && first < n) {
                aplitArray[i] = first;
                i++;
                first++;
            }


            if (i < (m - 1) && first == n) {
                aplitArray[i] = first;
                i++;
                first = 1;
            }


            if (i == m) {
                map.put(id, Arrays.asList(aplitArray));
                if(aplitArray[i-1]==1 ){
                    extracted(m, map);
                    flag =false;
                }
                aplitArray = new Integer[m];
                i = 0;
                first = inter;
                aplitArray[i] = first;
                first++;
                if (first - 1 == n) {
                    first = 1;
                }

                i++;
                count++;
                id++;
            }


        }


    }

    private static void extracted(int m, Map<Integer, List<Integer>> map) {
        List<Integer> firstDigit = new ArrayList<>();
        List<Integer> last = new ArrayList<>();

        for (Map.Entry<Integer, List<Integer>> v : map.entrySet()) {

           firstDigit.add(v.getValue().get(0));
           last.add(v.getValue().get(m - 1));



       }
        StringBuilder res=new StringBuilder();
        for (int j = 0; j < firstDigit.size(); j++) {
            if(firstDigit.get(0)==last.get(j)){
             res.append(firstDigit.get(j)); break;
            }
            else res.append(firstDigit.get(j));
        }
        System.out.println(res);
    }
}
// System.out.println(v.getValue());
//         System.out.println(v.getValue().get(0) +" "+v.getValue().get(m - 1));