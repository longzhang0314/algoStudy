package cn.zl.algo.week02.linked.common;

/**
 * 链表插入元素
 */
public class Insert {

    /**
     * 1.链表头部插入元素
     * @param value
     * @param head
     */
    public void insertAtHead(int value, Node head) {
        Node newNode = new Node(value, null);
        newNode.next = head;
        head = newNode;
    }

    /**
     * 2.链表尾部插入元素
     *
     * @param value
     * @param head
     */
    public void insertAtTail(int value, Node head) {
        Node newNode = new Node(value, null);
        if (head == null) {
            head = newNode;
        } else {
            Node p = head;
            while (p.next != null) {
                p = p.next;
            }
            p.next = newNode;
        }
    }

    /**
     * 2.链尾插入优化，引入tail指针
     *
     * @param value
     * @param head
     */
    public void insertAtTail2(int value, Node head, Node tail) {
        Node newNode = new Node(value, null);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = tail.next;
        }
    }

    /**
     * 2.链尾插入优化，引入虚拟头节点
     *
     * @param value
     * @param head
     * @param tail
     */
    Node head = new Node(0, null);
    Node tail = head;
    public void insertAtTail3(int value) {
        Node newNode = new Node(value, null);
        tail.next = newNode;
        tail = tail.next;
    }


    /**
     * 在给定节点之后插入
     *
     * @param value
     */
    public void insertAfter(int value, Node p) {
        if (p == null) return;
        Node newNode = new Node(value, null);
        newNode.next = p.next;
        p.next = newNode;
    }



}
