package ind.juan.learn.chapter.one.datastructures;

/**
 * Created by juanamari on 7/13/17.
 */
public class KeyValuePair<K ,V> {
    private K key;
    private V value;

    public KeyValuePair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }

    public void setKey(K key) {
        if (key != null) {
            this.key = key;
        }
    }

    public void setValue(V value) {
        if (value != null) {
            this.value = value;
        }
    }
}
