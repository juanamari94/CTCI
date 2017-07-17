package ind.juan.learn.chapter.one.datastructures;

/**
 * Created by juanamarine on 17/07/17.
 */
public class ExpandingStringBuffer {
    private char[] buffer;
    private int size;
    private static final int DEFAULT_BUFFER_SIZE = 20;

    public ExpandingStringBuffer() {
        this.buffer = new char[DEFAULT_BUFFER_SIZE];
        this.size = 0;
    }

    public ExpandingStringBuffer(String input) {
        this.buffer = new char[input.length() * 2];
        this.size = 0;
        this.append(input);
    }

    public void append(String input) {
        if (input == null) throw new IllegalArgumentException("input can't be null");
        if (input.length() == 0) return;
        this.manageSpace(input);
        for (int i = 0; i < input.length(); i++) {
            this.buffer[this.size] = input.charAt(i);
            this.size += 1;
        }
    }

    public void clear() {
        ExpandingStringBuffer newBuffer = new ExpandingStringBuffer();
        this.buffer = newBuffer.buffer;
        this.size = 0;
    }

    private void manageSpace(String input) {
        int spaceRequired = this.size + input.length();
        if (spaceRequired > this.buffer.length)
            expand(spaceRequired);
    }

    private void expand(int minimumLength) {
        char[] newBuffer = new char[minimumLength * 2];
        System.arraycopy(newBuffer, 0, this.buffer, 0, this.size);
        this.buffer = newBuffer;
    }

    public String toString() {
        char[] returnedBuffer = new char[this.size];
        System.arraycopy(this.buffer, 0, returnedBuffer, 0, this.size);
        return new String(returnedBuffer);
    }
}
