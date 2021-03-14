package CodeWars;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.maxBy;

public class Main {
    static int[] x = {1, 2, 2, 1, 3, 2, 4, 6, 5, 2, 7};
    static String word = "aabBcde1321";
    static String anagram = "aabBcde1132";
    static String notAnagram = "aabBcde1325";


    public static void main(String[] args) {
    //    System.out.println(mostFrequentItemCount(x));
    //    System.out.println(duplicateCount(word));
        System.out.println(isAnagram(word, anagram));
        System.out.println(isAnagram(word, notAnagram));

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

    /**
     * check if two strings are anagrams (aka, all letters are the same)
     * @param test
     * @param original
     * @return boolean true if they are anagram, and false if not
     */
    public static boolean isAnagram(String test, String original) {
        test = Arrays.stream(test.split("")).sorted(String::compareTo).collect(Collectors.joining(""));
        original = Arrays.stream(original.split("")).sorted(String::compareTo).collect(Collectors.joining(""));
        System.out.println(test+" "+ original);
        return (test.equals(original));
    }



    /**
     * given a string, remove all words that are duplicate
     */
    public static String removeDuplicateWords(String s){
        return new LinkedHashSet(Arrays.asList(s.split(" "))).toString().replaceAll(",", "").replaceAll("\\[\\]","");
    }


    /**
     * Given a text, count how many of the characters are present at least twice in the text
     * @param text the String obtained as source
     * @return int the value of the chars that are there more then once
     */

    static public int duplicateCount(String text) {
        Map<String, Long> myMap = Arrays.stream(text.toLowerCase().split("")).collect(Collectors.groupingBy(
                Function.identity(), Collectors.counting()));
        Set<String> mySet = myMap.keySet();
        for(String string : mySet){
            System.out.println(string);

        }
        return 0;
    }

    /**
     * Given a text, count the occurance of the most frequent character in the text
     * @param text the String obtained as source
     * @return int
     */
    static public int frequencyCount(String text) {
        return (int) Arrays.stream(text.split("")).collect(Collectors.groupingBy(
                Function.identity(), Collectors.counting())).values().stream().mapToLong(n->n).max().getAsLong();
    }

}