package cn.zl.algo.week02.linked.common;

/**
 * @author liusha
 * @date 2021/12/8
 */
public class InsertTest {

    public void insertAtHead(int value, Node head) {
        Node node = new Node(value, null);
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    public void insertAtTail(int value, Node head) {
        Node node = new Node(value, null);
        if (head == null) {
            head = node;
        } else {
            Node p = head;
            while (p.next != null) {
                p = p.next;
            }
            p.next = node;
        }
    }

    public void insertAtTail2(int value, Node head, Node tail) {
        Node node = new Node(value, null);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = tail.next;
        }
    }


    Node head = new Node(0, null);
    Node tail = head;
    public void insertAtTail3(int value) {
        tail.next = new Node(value, null);
        tail = tail.next;
    }


    public void insertAfter(int value, Node p) {
        Node node = new Node(value, null);
        if (p == null) return;
        node.next = p.next;
        p.next = node;
    }
}
