package ind.juan.learn.chapter.one.exercises;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by juanamari on 7/18/17.
 */
public class ChapterOneExercisesTest extends TestCase {

    /*
     * The following are tests for Exercise 1.1
     */

    @Test
    public void testUniqueCharactersWithEmptyString() {
        String input = "";
        assertTrue(ChapterOneExercises.hasUniqueCharacters(input));
        assertTrue(ChapterOneExercises.hasUniqueCharactersNoAdditionalDataStructures(input));
    }

    @Test
    public void testUniqueCharactersWithRepeatedString() {
        String input ="aabcddfgerr";
        assertFalse(ChapterOneExercises.hasUniqueCharacters(input));
        assertFalse(ChapterOneExercises.hasUniqueCharactersNoAdditionalDataStructures(input));
    }

    @Test
    public void testUniqueCharactersWithNonRepeatedString() {
        String input = "abcdefgh";
        assertTrue(ChapterOneExercises.hasUniqueCharacters(input));
        assertTrue(ChapterOneExercises.hasUniqueCharactersNoAdditionalDataStructures(input));
    }

    /*
     * The following are tests for Exercise 1.2
     */

    @Test
    public void testPermutationsWithNullValuesReturnsFalse() {
        assertFalse(ChapterOneExercises.isPermutationWithMaps(null, null));
        assertFalse(ChapterOneExercises.isPermutationWithSorting(null, null));
        assertFalse(ChapterOneExercises.isPermutationWithCharacterCount(null, null));
        assertFalse(ChapterOneExercises.isPermutationWithMaps(null, "abc"));
        assertFalse(ChapterOneExercises.isPermutationWithSorting(null, "abc"));
        assertFalse(ChapterOneExercises.isPermutationWithCharacterCount(null, "abc"));
        assertFalse(ChapterOneExercises.isPermutationWithMaps("abc", null));
        assertFalse(ChapterOneExercises.isPermutationWithSorting("abc", null));
        assertFalse(ChapterOneExercises.isPermutationWithCharacterCount("abc", null));
    }

    @Test
    public void testPermutationsWithOneEmptyStringReturnsFalse() {
        assertFalse(ChapterOneExercises.isPermutationWithMaps("", "a"));
        assertFalse(ChapterOneExercises.isPermutationWithSorting("", "a"));
        assertFalse(ChapterOneExercises.isPermutationWithCharacterCount("", "a"));
    }

    @Test
    public void testPermutationsWithDifferentLengthStringsReturnsFalse() {
        assertFalse(ChapterOneExercises.isPermutationWithMaps("abc", "abcd"));
        assertFalse(ChapterOneExercises.isPermutationWithSorting("abc", "abcd"));
        assertFalse(ChapterOneExercises.isPermutationWithCharacterCount("abc", "abcd"));
    }

    @Test
    public void testPermutationsWithBothEmptyStringsReturnsTrue() {
        assertTrue(ChapterOneExercises.isPermutationWithMaps("", ""));
        assertTrue(ChapterOneExercises.isPermutationWithSorting("", ""));
        assertTrue(ChapterOneExercises.isPermutationWithCharacterCount("", ""));
    }

    @Test
    public void testIdenticalStringsReturnsTrue() {
        assertTrue(ChapterOneExercises.isPermutationWithMaps("abc", "abc"));
        assertTrue(ChapterOneExercises.isPermutationWithSorting("abc", "abc"));
        assertTrue(ChapterOneExercises.isPermutationWithCharacterCount("abc", "abc"));
    }

    @Test
    public void testAnagramsReturnTrue() {
        assertTrue(ChapterOneExercises.isPermutationWithMaps("olleh", "hello"));
        assertTrue(ChapterOneExercises.isPermutationWithSorting("olleh", "hello"));
        assertTrue(ChapterOneExercises.isPermutationWithCharacterCount("olleh", "hello"));
        assertTrue(ChapterOneExercises.isPermutationWithMaps("eybdoog", "goodbye"));
        assertTrue(ChapterOneExercises.isPermutationWithSorting("eybdoog", "goodbye"));
        assertTrue(ChapterOneExercises.isPermutationWithCharacterCount("eybdoog", "goodbye"));
    }

    @Test
    public void testNonAnagramsReturnFalse() {
        assertFalse(ChapterOneExercises.isPermutationWithMaps("hello", "abcde"));
        assertFalse(ChapterOneExercises.isPermutationWithSorting("hello", "abcde"));
        assertFalse(ChapterOneExercises.isPermutationWithCharacterCount("hello", "abcde"));
        assertFalse(ChapterOneExercises.isPermutationWithMaps("abcd", "abcz"));
        assertFalse(ChapterOneExercises.isPermutationWithSorting("abcd", "abcz"));
        assertFalse(ChapterOneExercises.isPermutationWithCharacterCount("abcd", "abcz"));

    }

    /*
     * Tests for Exercise 1.3
     */
    @Test
    public void testExampleStringIsCorrect() {
        String input = "Mr John Smith    ";
        char[] array = input.toCharArray();
        ChapterOneExercises.URLify(array, 13);
        assertEquals("Mr%20John%20Smith", new String(array));
    }

    @Test
    public void testEmptyStringDoesNothing() {
        String input = "";
        char[] array = input.toCharArray();
        ChapterOneExercises.URLify(array, 0);
        assertEquals("", new String(array));
    }

    @Test
    public void testMultipleSpacedStringIsCorrect() {
        String input = "Hello  and  goodbye        ";
        char[] array = input.toCharArray();
        ChapterOneExercises.URLify(array, 19);
        assertEquals("Hello%20%20and%20%20goodbye", new String(array));
    }
}
