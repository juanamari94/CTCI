package ind.juan.learn.chapter.one.datastructures;

/**
 * Created by juanamari on 7/12/17.
 */
public class ArrayList<T> {
    private Object[] array;
    private static final int DEFAULT_SIZE = 20;
    private int size = 0;

    public ArrayList() {
        this.array = new Object[DEFAULT_SIZE];
    }

    public ArrayList(int size) {
        this.array = new Object[size];
    }

    public int size() {
        return this.size;
    }

    public T get(int index) {
        return (T)array[index]; // Will throw an IndexOutOfBoundsException
    }

    public void add(T element) {
        if (element == null) throw new IllegalArgumentException();
        // If an index was removed we don't necessarily need to expand the array.
        ensureCapacity();
        this.array[size] = element;
        this.size += 1;
    }

    public T remove(int index) {
        if (index < size && index >= 0) {
            T value = (T)this.array[index];
            this.size -= 1;
            System.arraycopy(this.array, index + 1, this.array, index, size - index);
            this.array[this.size] = null;
            return value;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    private void ensureCapacity() {
        if (this.size >= this.array.length) {
            Object[] newArray = new Object[this.size * 2];
            System.arraycopy(this.array, 0, newArray, 0, this.size);
            this.array = newArray;
        }
    }
}
