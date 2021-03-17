package CodeWars;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    static int[] x = {1, 2, 2, 1, 3, 2, 4, 6, 5, 2, 7};
    static String word = "aabBcde1321";
    static String anagram = "aabBcde1132";
    static String notAnagram = "aabBcde1325";



    public static void main(String[] args) {
    //    System.out.println(mostFrequentItemCount(x));
    //    System.out.println(duplicateCount(word));
    //    System.out.println(isAnagram(word, anagram));
    //    System.out.println(isAnagram(word, notAnagram));
    //    System.out.println(countShifterWords("who is who")); // expected two, since duplicate words don't count
        System.out.println(reverseWords("Három egész napon át"));

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
     * Given a text, count the occurrence of the most frequent character in the text
     * @param text the String obtained as source
     * @return int
     */
    static public int frequencyCount(String text) {
        return (int) Arrays.stream(text.split("")).collect(Collectors.groupingBy(
                Function.identity(), Collectors.counting())).values().stream().mapToLong(n->n).max().getAsLong();
    }

    /**
     * for any given string check how many words of them are shifter words
     * a word if shifter if it contains only these letters: hinosxzmw
     * a word is counted only once
     */
    public static int countShifterWords(String st){
        if (st.length()==0) return 0;
        String[] words = st.trim().split(" ");
        Set res = new HashSet();
        for (String word:words){
            if(word.replaceAll("(?i)[hinosxzmw]", "").length()==0) res.add(word);
        }
        return res.size();
    }

    /**
     * given a string, reverse the order of the words based on insertion
     */
    public static String reverseWords(String str){
        StringJoiner res = new StringJoiner(" ");
        String[] words = str.split(" ");
        for(int i = (words.length-1) ; i>=0; i--) {
            res.add(words[i]);
        }
        return res.toString();
    }

}