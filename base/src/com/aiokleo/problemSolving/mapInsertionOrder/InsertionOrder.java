public class InsertionOrder {
    public static void main(String[] args) {
        MyMap map = new MyMap();

        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);

        MyMap.Entry[] entries = map.entrySet();
        for (int i = 0; i < entries.length; i++) {
            if (entries[i] != null) {
                System.out.println(entries[i]);
            }
        }
    }
}

class MyMap {
    private Entry[] entries;
    private int size;

    public MyMap() {
        entries = new Entry[10]; // initial capacity
        size = 0;
    }

    public void put(String key, int value) {
        // Check if the key already exists and update the value
        for (int i = 0; i < size; i++) {
            if (entries[i].key.equals(key)) {
                entries[i].value = value;
                return;
            }
        }
        // If the key does not exist, add a new entry
        if (size == entries.length) {
            resize();
        }
        entries[size++] = new Entry(key, value);
    }

    public Entry[] entrySet() {
        return entries;
    }

    private void resize() {
        Entry[] newEntries = new Entry[entries.length * 2];
        for (int i = 0; i < entries.length; i++) {
            newEntries[i] = entries[i];
        }
        entries = newEntries;
    }

    static class Entry {
        String key;
        int value;

        Entry(String key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }
    }
}

