package two.week05.hash;


import java.util.HashMap;
import java.util.Map;

/**
 * @author liusha
 * @date 2023/4/19
 */
public class Exercise15Test2 {

    // 测试用例:["LRUCache","put","put","get","put","get","put","get","get","get"]
    //			[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
    //	测试结果:[null,null,null,1,null,2,null,1,3,4]
    //	期望结果:[null,null,null,1,null,-1,null,-1,3,4]

    // for O(1) get and put, double list and hash map
    class LRUCache {

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

        private DoubleNode head;
        private DoubleNode tail;
        private Map<Integer, DoubleNode> map;
        private int size;
        private int n;

        public LRUCache(int capacity) {
            this.head = new DoubleNode(-1, -1);
            this.tail = new DoubleNode(-1, -1);
            head.next = tail;
            tail.prev = head;
            this.map = new HashMap<>();
            this.size = 0;
            this.n = capacity;
        }

        public int get(int key) {
            DoubleNode node = getNode(key);
            return node == null ? -1 : node.val;
        }

        public void put(int key, int value) {
            // getNode and if exist, transfer it in head
            DoubleNode node = getNode(key);
            if (node == null) {
                // if absent,delete tail and put new val
                // 1. if full, delete tail
                if (size == n) {
                    DoubleNode delete = tail.prev;
                    if (delete != head) {
                        delete.prev.next = delete.next;
                        delete.next.prev = delete.prev;
                        map.remove(delete.key);
                        size--;
                    }
                }
                // 2.put new val
                DoubleNode newNode = new DoubleNode(key, value);
                newNode.next = head.next;
                head.next.prev = newNode;
                head.next = newNode;
                newNode.prev = head;
                map.put(key, newNode);
                size++;
            } else {
                // if exist,transfer it in head and update value
                node.val = value;
            }
        }

        private DoubleNode getNode(int key) {
            // getNode
            DoubleNode node = map.get(key);
            if (node == null) return null;
            // if not null,transfer it in head:1.delete it int origin site;2.put it in first
            // 1
            node.next.prev = node.prev;
            node.prev.next = node.next;
            // 2
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
            node.prev = head;
            // return val
            return node;
        }
    }

}
