package two.week05.hash;

import java.util.LinkedList;

/**
 * @author liusha
 * @date 2023/4/18
 */
public class Exercise14Test2 {


    // hash key:int,value:int  最多104次put
    class MyHashMap {

        private class Entry {
            int key;
            int val;

            Entry(int key, int val) {
                this.key = key;
                this.val = val;
            }

            public int getKey() {
                return key;
            }

            public int getVal() {
                return val;
            }

            public void setVal(int val) {
                this.val = val;
            }

        }

        private LinkedList<Entry>[] arr;
        private int n;

        public MyHashMap() {
            this.n = 104;
            this.arr = new LinkedList[n];
        }

        void put(int key, int value) {
            int idx = getIdx(key);
            arr[idx] = arr[idx] == null ? new LinkedList<>() : arr[idx];
            for (Entry e : arr[idx]) {
                if (e.getKey() == key) {
                    e.setVal(value);
                    return;
                }
            }
            Entry entry = new Entry(key, value);
            arr[idx].addFirst(entry);
        }

        int get(int key) {
            int idx = getIdx(key);
            LinkedList<Entry> entries = arr[idx];
            if (entries == null) return -1;
            for (Entry e : entries) {
                if (e.getKey() == key) {
                    return e.getVal();
                }
            }
            return -1;
        }

        void remove(int key) {
            int idx = getIdx(key);
            LinkedList<Entry> entries = arr[idx];
            if (entries == null) return;
            for (Entry e : entries) {
                if (e.getKey() == key) {
                    entries.remove(e);
                    return;
                }
            }
        }

        private int getIdx(int key) {
            return key % n;
        }

    }


}
