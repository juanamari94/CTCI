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
        assertEquals("goodbye", this.hashTable.get("hello"));
        assertEquals("dog", this.hashTable.get("cat"));
    }

    /**
     * Tests both collision management as well as the expansion of the hash table.
     */
    @Test
    public void testCollisionAndExpansion() {
        for (int i = 0; i < 30; i++) {
            this.hashTable.put("key " + i, "value " + i);
        }
        for (int i = 0; i < 30; i ++) {
            assertEquals("value " + i, this.hashTable.get("key " + i));
        }
    }

    /**
     * Tests removal of an element in the hash table.
     */
    @Test
    public void testRemoval() {
        this.hashTable.put("hello", "goodbye");
        this.hashTable.put("cat", "dog");
        this.hashTable.put("fox", "xof");
        this.hashTable.put("foo", "bar");
        this.hashTable.remove("hello");
        this.hashTable.remove("foo");
        assertEquals("dog", this.hashTable.get("cat"));
        assertEquals("xof", this.hashTable.get("fox"));
        assertNull(this.hashTable.get("hello"));
        assertNull(this.hashTable.get("foo"));
    }
}
