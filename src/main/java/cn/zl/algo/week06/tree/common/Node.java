package cn.zl.algo.week06.tree.common;

import java.util.List;

/**
 * N叉树节点
 *
 * @author: longzhang
 * @date: 2022/1/8
 */
public class Node {

    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
