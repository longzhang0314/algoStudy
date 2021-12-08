package cn.zl.algo.week02.linked.common;

/**
 * @author liusha
 * @date 2021/12/8
 */
public class TraverseAndFindTest {

    public void traverse(Node head) {
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
