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
        System.arraycopy(input.toCharArray(), 0, this.buffer, 0, input.toCharArray().length);
        this.size = input.length();
    }

    public void append(String input) {
        if (input == null) throw new IllegalArgumentException("input can't be null");
        if (input.length() == 0) return;
        this.manageSpace(input);
        for (int i = 0; i < input.length(); i++) {
            this.buffer[this.size + i] = input.charAt(i);
        }
    }

    private void manageSpace(String input) {
        int spaceRequired = this.size + input.length();
        if (spaceRequired > this.buffer.length)
            expand(spaceRequired);
    }

    private void expand(int minimumLength) {
        char[] newBuffer = new char[minimumLength * 2];
        System.arraycopy(newBuffer, 0, this.buffer, 0, minimumLength);
        this.buffer = newBuffer;
    }
}
