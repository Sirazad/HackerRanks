package CodeWars;

import java.util.*;

public class Main {
    static int[] x = {1, 2, 2, 1, 3, 2, 4, 6, 5, 2, 7};


    public static void main(String[] args) {
        System.out.println(mostFrequentItemCount(x));
    }

    /**
     * Given an array of integers, return the count of the most used
     * int in the array.
     *
     * @param collection which despite the name is actually an array of primitive int
     * @return int being the count of the frequency
     */
    public static int mostFrequentItemCount(int[] collection) {
        if (collection.length ==0) return 0;
        TreeMap<Integer, Integer> map = new TreeMap();
        for (int i = 0; i < collection.length; i++) {
            int key = collection[i];
            if(map.containsKey(key)) {
                map.replace(key, (map.get(key))+1);
            }else {
                map.put(key, 1);
            }
        }
        return map.values().stream().max(Integer::compare).get();
    }
}