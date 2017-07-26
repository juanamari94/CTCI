package ind.juan.learn.chapter.one.exercises;

import ind.juan.learn.chapter.one.datastructures.ExpandingStringBuilder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by juanamari on 7/18/17.
 */
class ChapterOneExercises {

    /**
     * Exercise 1.1
     * Implement an algorithm to check if a string has all unique characters.
     * @param input The string to check.
     * @return Whether the string has all unique characters (true) or not (false).
     */
    static boolean hasUniqueCharacters(String input) {
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
    static boolean hasUniqueCharactersNoAdditionalDataStructures(String input) {
        if (input.length() == 0) return true;
        if (input.length() > 256) return false;
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
    static boolean isPermutationWithSorting(String input, String target) {
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
     * Another way of defining permutations is: A String is a premutation of another String if the count of their characters
     * are equal, meaning that the sum of the word count of the target string should be equal to the word count of the input,
     * and so their difference should be 0 for all characters in the String.
     * We assume the encoding is ascii-extended.
     * @param input The string to check.
     * @param target The target string.
     * @return true if it is a permutation, false if it isn't.
     */
    static boolean isPermutationWithCharacterCount(String input, String target) {
        if (input == null || target == null || input.length() != target.length()) return false;
        if (input.length() == 0 && target.length() == 0) return true;
        if (input.equals(target)) return true;

        int[] wordCount = new int[256];

        for (int i = 0; i < input.length(); i++) {
            wordCount[input.charAt(i)] -= 1;
            wordCount[target.charAt(i)] += 1;
        }

        for (int i = 0; i < 256; i++) {
            if (wordCount[i] != 0)
                return false;
        }
        return true;
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
    static boolean isPermutationWithMaps(String input, String target) {
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

    /**
     * Exercise 1.3
     * Replace all spaces in a given string with %20. Remove trailing spaces, use a char array. Assume that the true
     * length is part of the function's input. Perform in-place.
     * This is the solution in the book, it's actually extremely clever.
     * Some conclusions I got from this specific exercise:
     * - Be very careful with the specification and understand the white spacing. At first I thought it was just something I had to remove.
     *   It ended being critical to the optimal solution.
     * - The "trueLength" parameter represents the length of the string without the added whitespace.
     * - This example will not work if the "buffer whitespace" is not at the end.
     * @param str The character array containing the string.
     * @param trueLength The true length of the final value.
     */
    static void URLify(char[] str, int trueLength) {
        int spaceCount = 0;
        for (int i = 0; i < trueLength; i++) {
            if (str[i] == ' ')
                spaceCount += 1;
        }
        int index = trueLength + 2 * spaceCount;
        if (trueLength < str.length) str[trueLength] = '\0';
        for (int i = trueLength - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index -= 3;
            } else {
                str[index - 1] = str[i];
                index -= 1;
            }
        }
    }
}
