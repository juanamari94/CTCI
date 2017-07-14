package ind.juan.learn.chapter.one.datastructures;

import javafx.animation.KeyValue;

/**
 * Created by juanamari on 7/12/17.
 */
public class SeparateChainingHashTable<K, V> {
    private ArrayList<KeyValuePair<K, V>>[] table;
    private double loadFactor;
    private static final int DEFAULT_SIZE = 20;
    private int size;

    public SeparateChainingHashTable() {
        this.table = new ArrayList[DEFAULT_SIZE];
        this.loadFactor = 0 / this.table.length;
        this.size = 0;
    }

    public void put(K key, V value) {
        if (key == null || value == null) throw new IllegalArgumentException("Neither the key nor the value must be null.");
        if (this.isTooLoaded()) this.expand();
        int index = getIndex(key);
        if (this.table[index] == null) {
            this.table[index] = new ArrayList<KeyValuePair<K, V>>();
            this.size += 1;
        }
        this.table[index].add(new KeyValuePair(key, value));
    }

    public V get(K key) {
        int index = getIndex(key);
        if (this.table[index] != null) {
            for(int i = 0; i < this.table[index].size(); i++) {
                if (this.table[index].get(i).getKey().equals(key))
                    return this.table[index].get(i).getValue();
            }
            return null;
        } else {
            return null;
        }
    }

    private void expand() {
        ArrayList<KeyValuePair<K, V>>[] newTable = new ArrayList[this.table.length * 2];
        System.arraycopy(this.table, 0, newTable, 0, this.table.length);
        this.table = newTable;
    }

    private double getLoadFactor() {
        return this.size / table.length;
    }

    private boolean isTooLoaded() {
        return this.getLoadFactor() >= 0.75;
    }

    private int getIndex(K key) {
        int code = key.hashCode();
        return Math.abs(code % this.table.length);
    }
}
