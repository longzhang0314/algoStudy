package cn.zl.algo.week02.linked.common;

/**
 * @author liusha
 * @date 2021/12/8
 */
public class DeleteTest {

    public void deleteNextNode(Node p) {
        if (p == null || p.next == null) return;
        p.next = p.next.next;
    }


    public Node deleteThisNode(Node head, Node p) {
        if (head == null || p == null) return null;
        if (head == p) {
            head = head.next;
        } else {
            Node prev = head;
            while (prev.next != null) {
                if (prev.next == p) {
                    prev.next = prev.next.next;
                    break;
                } else {
                    prev = prev.next;
                }
            }
        }
        return head;
    }

    public Node deleteThisNode1(Node head, Node p) {
        if (head == null || p == null) return null;
        Node prev = null;
        Node q = head;
        while (q != null) {
            if (q == p) break;;
            prev = q;
            q = q.next;
        }
        if (q == null) return head;
        if (prev == null) {
            head = head.next;
        } else {
            prev.next = prev.next.next;
        }
        return head;
    }

    public Node deleteThisNode2(Node head, Node p) {
        Node newHead = new Node(0, null);
        newHead.next = head;
        Node q = newHead;
        while (q.next != null) {
            if (q.next == p) {
                q.next = q.next.next;
                break;
            } else {
                q = q.next;
            }
        }
        return newHead.next;
    }

    public Node deleteThisNode3(Node head, Node p) {
        Node newHead = new Node(0, null);
        newHead.next = head;
        Node prev = newHead;
        Node q = head;
        while (q != null) {
            if (q == p) {
                break;
            }
            prev = q;
            q = q.next;
        }
        if (q == null) return head;
        prev.next = prev.next.next;
        return head;
    }

    public DoubleNode deleteThisNode4(DoubleNode head, DoubleNode p) {
        if (head == null || p == null) return head;
        if (head == p) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
        } else {
            p.next.prev = p.prev;
            p.prev.next = p.next;
        }
        return head;
    }
}
