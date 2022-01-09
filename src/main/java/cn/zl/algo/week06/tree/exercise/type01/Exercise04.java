package cn.zl.algo.week06.tree.exercise.type01;

import cn.zl.algo.week06.tree.common.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * 589. N 叉树的前序遍历（简单）
 *
 * TODO do 迭代解法
 * @author: longzhang
 * @date: 2022/1/8
 */
public class Exercise04 {

    // 方法1
    public List<Integer> preorder1(Node root) {
        List<Integer> res = new ArrayList<>();
        pre(res, root);
        return res;
    }

    private void pre(List<Integer> res, Node root) {
        if (root == null) return;
        res.add(root.val);
        for (Node child : root.children) {
            pre(res, child);
        }
    }

    // 方法2
    public List<Integer> preorder(Node root) {
        if (root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        res.add(root.val);
        for (Node child : root.children) {
            res.addAll(preorder(child));
        }
        return res;
    }
}
