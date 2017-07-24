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
        assertFalse(ChapterOneExercises.isPermutationWithMaps(null, "abc"));
        assertFalse(ChapterOneExercises.isPermutationWithSorting(null, "abc"));
        assertFalse(ChapterOneExercises.isPermutationWithMaps("abc", null));
        assertFalse(ChapterOneExercises.isPermutationWithSorting("abc", null));
    }

    @Test
    public void testPermutationsWithOneEmptyStringReturnsFalse() {
        assertFalse(ChapterOneExercises.isPermutationWithMaps("", "a"));
        assertFalse(ChapterOneExercises.isPermutationWithSorting("", "a"));
    }

    @Test
    public void testPermutationsWithDifferentLengthStringsReturnsFalse() {
        assertFalse(ChapterOneExercises.isPermutationWithMaps("abc", "abcd"));
        assertFalse(ChapterOneExercises.isPermutationWithSorting("abc", "abcd"));
    }

    @Test
    public void testPermutationsWithBothEmptyStringsReturnsTrue() {
        assertTrue(ChapterOneExercises.isPermutationWithMaps("", ""));
        assertTrue(ChapterOneExercises.isPermutationWithSorting("", ""));
    }

    @Test
    public void testIdenticalStringsReturnsTrue() {
        assertTrue(ChapterOneExercises.isPermutationWithMaps("abc", "abc"));
        assertTrue(ChapterOneExercises.isPermutationWithSorting("abc", "abc"));
    }

    @Test
    public void testAnagramsReturnTrue() {
        assertTrue(ChapterOneExercises.isPermutationWithMaps("olleh", "hello"));
        assertTrue(ChapterOneExercises.isPermutationWithSorting("olleh", "hello"));
        assertTrue(ChapterOneExercises.isPermutationWithMaps("eybdoog", "goodbye"));
        assertTrue(ChapterOneExercises.isPermutationWithSorting("eybdoog", "goodbye"));
    }

    @Test
    public void testNonAnagramsReturnFalse() {
        assertFalse(ChapterOneExercises.isPermutationWithMaps("hello", "abcde"));
        assertFalse(ChapterOneExercises.isPermutationWithSorting("hello", "abcde"));
        assertFalse(ChapterOneExercises.isPermutationWithMaps("abcd", "abcz"));
        assertFalse(ChapterOneExercises.isPermutationWithSorting("abcd", "abcz"));

    }
}
