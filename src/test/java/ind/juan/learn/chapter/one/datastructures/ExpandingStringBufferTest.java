package ind.juan.learn.chapter.one.datastructures;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by juanamarine on 17/07/17.
 */
public class ExpandingStringBufferTest extends TestCase {

    private ExpandingStringBuffer stringBuffer;

    protected void setUp(){
        this.stringBuffer= new ExpandingStringBuffer();
    }

    @Test
    public void testAppend() {
        String expected = "hello";
        this.stringBuffer.append(expected);
        assertEquals(expected, this.stringBuffer.toString());
    }

    @Test
    public void testExpansion() {
        String expected = "123456789123456789123456789";
        this.stringBuffer.append(expected);
        assertEquals(expected, this.stringBuffer.toString());
    }

    @Test
    public void testConstructorWithParams() {
        String expected = "123456789123456789123456789";
        ExpandingStringBuffer newBuffer = new ExpandingStringBuffer(expected);
        assertEquals(expected, newBuffer.toString());
    }

    @Test
    public void testClear() {
        this.stringBuffer.clear();
        assertEquals("", this.stringBuffer.toString());
    }
}
