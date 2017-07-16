package ind.juan.learn.chapter.one.datastructures;

/**
 * Created by juanamari on 7/12/17.
 */
public class SeparateChainingHashTable<K, V> {
    private ArrayList<KeyValuePair<K, V>>[] table;
    private static final int DEFAULT_SIZE = 20;
    private int size;

    public SeparateChainingHashTable() {
        this.table = new ArrayList[DEFAULT_SIZE];
        this.size = 0;
    }

    public SeparateChainingHashTable(int size) {
        this.table = new ArrayList[size];
        this.size = 0;
    }

    /**
     * Adds a new Key, Value pair to the Hash Table.
     * @param key The key of the pair.
     * @param value The value of the pair.
     */
    public void put(K key, V value) {
        if (key == null || value == null) throw new IllegalArgumentException("Neither the key nor the value must be null.");
        if (this.isTooLoaded()) this.expand();
        int index = this.getIndex(key);
        if (this.table[index] == null) {
            this.table[index] = new ArrayList<KeyValuePair<K, V>>();
            this.size += 1;
        }
        this.table[index].add(new KeyValuePair(key, value));
    }

    /**
     * Removes an element from the Hash Table. If it exists, it gets removed and returns true, if it doesn't, returns
     * false.
     * @param key The key whose pair will be deleted.
     * @return True if successfully deleted, false if not.
     */
    public boolean remove(K key) {
        if (key == null) throw new IllegalArgumentException("The key cannot be null.");
        int index = this.getIndex(key);
        if (this.table[index] != null) {
            for (int i = 0; i < this.table[index].size(); i++) {
                if (this.table[index].get(i).getKey().equals(key)) {
                    this.table[index].remove(i);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Retrieves the value of a key-value pair given a key.
     * @param key The key of the pair to be retrieved.
     * @return The value if found, null if not.
     */
    public V get(K key) {
        int index = this.getIndex(key);
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

    /**
     * Expands the hash table if the load factor goes above 0.75, the expansion rate is twice the current length of the
     * table.
     */
    private void expand() {
        SeparateChainingHashTable<K, V> newTable = new SeparateChainingHashTable<K, V>(this.table.length * 2);
        for (int i = 0; i < this.table.length; i++) {
            if (this.table[i] != null) {
                for (int j = 0; j < this.table[i].size(); j++) {
                    KeyValuePair<K,V> pair = new KeyValuePair<K, V>(this.table[i].get(j).getKey(),
                                                                    this.table[i].get(j).getValue());
                    newTable.put(pair.getKey(), pair.getValue());
                }
            }
        }
        this.table = newTable.table;
        this.size = newTable.size;
    }

    private double getLoadFactor() {
        return (double)this.size / (double)table.length;
    }

    private boolean isTooLoaded() {
        return this.getLoadFactor() >= 0.75;
    }

    private int getIndex(K key) {
        int code = key.hashCode();
        return Math.abs(code % this.table.length);
    }
}
