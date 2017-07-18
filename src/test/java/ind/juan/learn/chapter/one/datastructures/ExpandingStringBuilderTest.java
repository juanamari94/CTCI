package ind.juan.learn.chapter.one.datastructures;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by juanamarine on 17/07/17.
 */
public class ExpandingStringBuilderTest extends TestCase {

    private ExpandingStringBuilder stringBuilder;

    protected void setUp(){
        this.stringBuilder = new ExpandingStringBuilder();
    }

    @Test
    public void testAppend() {
        String expected = "hello";
        this.stringBuilder.append(expected);
        assertEquals(expected, this.stringBuilder.toString());
    }

    @Test
    public void testExpansion() {
        String expected = "123456789123456789123456789";
        this.stringBuilder.append(expected);
        assertEquals(expected, this.stringBuilder.toString());
    }

    @Test
    public void testConstructorWithParams() {
        String expected = "123456789123456789123456789";
        ExpandingStringBuilder newBuffer = new ExpandingStringBuilder(expected);
        assertEquals(expected, newBuffer.toString());
    }

    @Test
    public void testClear() {
        this.stringBuilder.clear();
        assertEquals("", this.stringBuilder.toString());
    }
}
