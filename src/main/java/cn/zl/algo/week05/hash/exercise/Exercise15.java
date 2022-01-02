package cn.zl.algo.week05.hash.exercise;

import cn.zl.algo.week02.linked.common.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 146. LRU 缓存机制（中等）标准的LRU
 *
 * @author liusha
 * @date 2021/12/31
 */
public class Exercise15 {

    public static void main(String[] args) {
        Exercise15 e = new Exercise15();
        LRUCache l = new LRUCache(2);
        l.put(1, 1);
        l.put(2, 2);
        System.out.println(l.get(1));
        l.put(3, 3);
        System.out.println(l.get(2));
        l.put(4, 4);
        System.out.println(l.get(1));
        System.out.println(l.get(3));
        System.out.println(l.get(4));
    }

    static class LRUCache {

        private class DoubleNode {
            int key;
            int val;
            DoubleNode prev;
            DoubleNode next;

            DoubleNode(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        private Map<Integer, DoubleNode> map;
        private DoubleNode head;
        private DoubleNode tail;
        private int n;
        private int size;

        public LRUCache(int capacity) {
            this.map = new HashMap<>();
            this.n = capacity;
            this.size = 0;
            this.head = new DoubleNode(0, 0);
            this.tail = new DoubleNode(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            DoubleNode node = map.get(key);
            if (node == null) return -1;
            // put at first
            putAtFirstIfExist(node);
            return node.val;
        }

        public void put(int key, int value) {
            DoubleNode cur = map.get(key);
            if (cur == null) {

                if (size == n) {
                    DoubleNode removeNode = removeLast();
                    map.remove(removeNode.key);
                    size--;
                }

                DoubleNode node = new DoubleNode(key, value);
                node.next = head.next;
                head.next.prev = node;
                node.prev = head;
                head.next = node;

                map.put(key, node);
                size++;
            } else {
                cur.val = value;
                putAtFirstIfExist(cur);
            }
        }

        private DoubleNode removeLast() {
            DoubleNode node = tail.prev;
            tail.prev.prev.next = tail;
            tail.prev = tail.prev.prev;
            return node;
        }

        private void putAtFirstIfExist(DoubleNode node) {
            // remove
            node.next.prev = node.prev;
            node.prev.next = node.next;
            // add at first
            node.next = head.next;
            head.next.prev = node;
            node.prev = head;
            head.next = node;
        }
    }

}
