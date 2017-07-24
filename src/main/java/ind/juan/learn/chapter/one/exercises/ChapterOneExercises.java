package ind.juan.learn.chapter.one.exercises;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by juanamari on 7/18/17.
 */
public class ChapterOneExercises {

    /**
     * Exercise 1.1
     * Implement an algorithm to check if a string has all unique characters.
     * @param input The string to check.
     * @return Whether the string has all unique characters (true) or not (false).
     */
    public static boolean hasUniqueCharacters(String input) {
        if (input.length() == 0) return true;
        HashSet<Character> wordSet = new HashSet<Character>();
        for (Character c: input.toCharArray()) {
            if (wordSet.contains(c))
                return false;
            else
                wordSet.add(c);
        }
        return true;
    }

    /**
     * Exercise 1.1
     * Implement an algorithm to check if a string has all unique characters without using additional data structures.
     * I'm assuming the character encoding is ascii extended.
     * @param input The string to check.
     * @return Whether the string has all unique characters (true) or not (false).
     */
    public static boolean hasUniqueCharactersNoAdditionalDataStructures(String input) {
        if (input.length() == 0) return true;
        // Array already starts initialized to 0.
        int[] wordCount = new int[256];
        for (char c : input.toCharArray()) {
            int index = (int)c;
            if (wordCount[index] > 0)
                return false;
            else
                wordCount[index] += 1;
        }
        return true;
    }

    /**
     * Exercise 1.2
     * Implement an algorithm to check if a string is a permutation of another string.
     * permutation = anagram
     * @param input The string to check.
     * @param target The target string.
     * @return true if it is a permutation, false if it isn't.
     */
    public static boolean isPermutationWithSorting(String input, String target) {
        if (input == null || target == null || input.length() != target.length()) return false;
        if (input.length() == 0 && target.length() == 0) return true;
        if (input.equals(target)) return true;

        // Let's get some character arrays.
        char[] inputArray = input.toCharArray();
        char[] targetArray = target.toCharArray();
        Arrays.sort(inputArray);
        Arrays.sort(targetArray);
        return (new String(inputArray)).equals((new String(targetArray)));
    }

    /**
     * Exercise 1.2
     * Implement an algorithm to check if a string is a permutation of another string.
     * permutation = anagram
     * HashMap implementation. Longer, but O(n).
     * @param input The string to check.
     * @param target The target string.
     * @return true if it is a permutation, false if it isn't.
     */
    public static boolean isPermutationWithMaps(String input, String target) {
        if (input == null || target == null || input.length() != target.length()) return false;
        if (input.length() == 0 && target.length() == 0) return true;
        if (input.equals(target)) return true;

        HashMap<Character, Integer> inputMap = new HashMap<Character, Integer>();
        HashMap<Character, Integer> targetMap = new HashMap<Character, Integer>();

        for (Character c : input.toCharArray()) {
            if (inputMap.containsKey(c))
                inputMap.put(c, inputMap.get(c) + 1);
            else
                inputMap.put(c, 0);
        }

        for (Character c : target.toCharArray()) {
            if (targetMap.containsKey(c))
                targetMap.put(c, targetMap.get(c) + 1);
            else
                targetMap.put(c, 0);
        }

        for (Map.Entry<Character, Integer> entry : targetMap.entrySet()) {
            if (!inputMap.containsKey(entry.getKey())
                    || inputMap.get(entry.getKey()).intValue() != targetMap.get(entry.getKey()).intValue())
                return false;
        }
        return true;
    }
}
