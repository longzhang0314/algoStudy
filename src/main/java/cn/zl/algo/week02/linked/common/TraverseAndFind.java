package cn.zl.algo.week02.linked.common;


/**
 * 链表遍历 查找某个元素
 */
public class TraverseAndFind {

    /**
     * 1.链表遍历
     * @param head
     */
    public void traverse(Node head) {
        if (head == null) return;
        Node p = head;
        while (p != null) {
            System.out.println(p.data);
            p = p.next;
        }
    }

    public Node find(Node head, int value) {
        Node p = head;
        while (p != null) {
            if (p.data == value) return p;
            p = p.next;
        }
        return null;
    }
}
