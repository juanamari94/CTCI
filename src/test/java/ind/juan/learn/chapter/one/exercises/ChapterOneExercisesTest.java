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
}
