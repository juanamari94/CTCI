package ind.juan.learn.chapter.one.datastructures;
import junit.framework.*;
import org.junit.Test;

/**
 * Created by juanamari on 7/12/17.
 */
public class ArrayListTest extends TestCase {

    private ArrayList<Integer> list;

    protected void setUp(){
        this.list = new ArrayList<Integer>();
    }

    @Test
    public void testCreation() {
        assertNotNull(this.list);
    }

    @Test
    public void testAdd() {
        this.list.add(1);
        assert(this.list.get(0) == 1);
    }

    @Test
    public void testAddMany() {
        this.list.add(1);
        this.list.add(2);
        this.list.add(3);
        assert(this.list.get(0) == 1 && this.list.get(1) == 2 && this.list.get(2) == 3);
    }

    @Test
    public void testCompressionOnRemove() {
        this.list.add(1);
        this.list.add(2);
        this.list.add(3);
        this.list.add(4);
        Integer removed = this.list.remove(1);
        assert(removed == 2);
        assert(this.list.get(0) == 1);
        assert(this.list.size() == 3);
    }

    @Test
    public void testRemove() {
        this.list.add(1);
        Integer removedValue = this.list.remove(0);
        assert(removedValue == 1);
    }
}
