package cn.zl.algo.week02.linked.common;

public class Delete {

    /**
     * 1. 删除给定节点之后的节点
     * @param p
     */
    public void deleteNextNode(Node p) {
        if (p == null || p.next == null) return;
        p.next = p.next.next;
    }

    /**
     * 删除给定节点
     *
     * @param head
     * @param p
     * @return 返回新链表
     */
    public Node deleteThisNode(Node head, Node p) {
        if (head == null || p == null) return head;
        Node prev = null;
        Node q = head;
        while (q != null) {
            if (q == p) break;
            prev = q;
            q = q.next;
        }
        // 没有找到
        if (q == null) return head;

        if (prev == null) {
            head = head.next;
        } else {
            prev.next = prev.next.next;
        }
        return head;
    }

    /**
     * 删除给定节点
     *
     * @param head
     * @param p
     * @return
     */
    public Node deleteThisNode1(Node head, Node p) {
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

    /**
     * 删除给定节点优化 - 虚拟头结点
     * （wangzheng版本）
     * @param head
     * @param p
     * @return
     */
    public Node deleteThisNode2(Node head, Node p) {
        if (head == null || p == null) return head;
        Node newHead = new Node(0, null);
        newHead.next = head;
        Node prev = newHead;
        Node q = head;
        while (q != null) {
            if (q == p) break;
            prev = q;
            q = q.next;
        }
        if (q == null) return head;
        prev.next = prev.next.next;
        return head;
    }

    /**
     * 删除给定节点优化 - 虚拟头结点
     * (自己写的)
     * @param head
     * @param p
     * @return
     */
    public Node deleteThisNode3(Node head, Node p) {
        Node newHead = new Node(0, null);
        newHead.next = head;
        Node q = newHead;
        while (q.next != null) {
            if (q.next == p) {
                q.next = q.next.next;
                break;
            }
            q = q.next;
        }
        return newHead.next;
    }


    /**
     * 双向链表删除给定节点
     *
     * @param head
     * @param p
     * @return
     */
    public DoubleNode deleteThisNode4(DoubleNode head, DoubleNode p) {
        if (head == null || p == null) return head;
        if (p == head) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            return head;
        }
        p.next.prev = p.prev;
        p.prev.next = p.next;
        return head;
    }




}
