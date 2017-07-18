package ind.juan.learn.chapter.one.exercises;

import java.util.HashSet;

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
}
