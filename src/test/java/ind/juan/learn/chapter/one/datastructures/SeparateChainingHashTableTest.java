package ind.juan.learn.chapter.one.datastructures;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by juanamari on 7/13/17.
 */
public class SeparateChainingHashTableTest extends TestCase {

    private SeparateChainingHashTable<String, String> hashTable;

    protected void setUp() {
        this.hashTable = new SeparateChainingHashTable<String, String>();
    }

    @Test
    public void testAddition() {
        this.hashTable.put("hello", "goodbye");
        this.hashTable.put("cat", "dog");
        assertEquals("goodbye", this.hashTable.get("cat"));
        assertEquals("dog", this.hashTable.get("hello"));
    }

    @Test
    public void testCollision() {
        for(int i = 0; i < 30; i++) {
            this.hashTable.put("key " + i, "value " + i);
        }
    }
}
