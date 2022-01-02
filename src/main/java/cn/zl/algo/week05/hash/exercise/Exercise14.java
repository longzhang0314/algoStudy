package cn.zl.algo.week05.hash.exercise;

import java.util.LinkedList;

/**
 * 706. 设计哈希映射(简单)
 * <p>
 * //不使用任何内建的哈希表库设计一个哈希映射（HashMap）。
 * //
 * // 实现 MyHashMap 类：
 * //
 * //
 * // MyHashMap() 用空映射初始化对象
 * // void put(int key, int value) 向 HashMap 插入一个键值对 (key, value) 。如果 key 已经存在于映射中，
 * //则更新其对应的值 value 。
 * // int get(int key) 返回特定的 key 所映射的 value ；如果映射中不包含 key 的映射，返回 -1 。
 * // void remove(key) 如果映射中存在 key 的映射，则移除 key 和它所对应的 value 。
 * //
 * // 示例：
 * //
 * //输入：
 * //["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
 * //[[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
 * //输出：
 * //[null, null, null, 1, -1, null, 1, null, -1]
 * <p>
 * // 0 <= key, value <= 106
 * // 最多调用 104 次 put、get 和 remove 方法
 *
 * @author liusha
 * @date 2021/12/31
 */
public class Exercise14 {

    class MyHashMap {

        private class Entry {
            int key;
            int value;

            Entry(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        private LinkedList<Entry>[] arr;
        private int n;

        public MyHashMap() {
            this.n = 104;
            this.arr = new LinkedList[n];
            for (int i = 0; i < n; i++) {
                arr[i] = new LinkedList<Entry>();
            }
        }

        public void put(int key, int value) {
            int idx = hash(key);
            boolean flag = false;
            for (Entry entry : arr[idx]) {
                if (entry.key == key) {
                    entry.value = value;
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                Entry entry = new Entry(key, value);
                arr[idx].addFirst(entry);
            }
        }

        public int get(int key) {
            int idx = hash(key);
            for (Entry entry : arr[idx]) {
                if (entry.key == key) {
                    return entry.value;
                }
            }
            return -1;
        }

        public void remove(int key) {
            int idx = hash(key);
            Entry remove = null;
            for (Entry entry : arr[idx]) {
                if (entry.key == key) {
                    remove = entry;
                    break;
                }
            }
            if (remove != null) {
                arr[idx].remove(remove);
            }
        }

        private int hash(int key) {
            return key % n;
        }

    }
}
