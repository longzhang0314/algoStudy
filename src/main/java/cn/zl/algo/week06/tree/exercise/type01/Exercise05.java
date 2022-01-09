package cn.zl.algo.week06.tree.exercise.type01;

import cn.zl.algo.week06.tree.common.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * 590. N 叉树的后序遍历（简单）
 *
 * TODO do 迭代解法
 *
 * @author: longzhang
 * @date: 2022/1/8
 */
public class Exercise05 {

    // 方法1
    public List<Integer> postorder1(Node root) {
        List<Integer> res = new ArrayList<>();
        post(res, root);
        return res;
    }

    private void post(List<Integer> res, Node root) {
        if (root == null) return;
        for (Node child : root.children) {
            post(res, child);
        }
        res.add(root.val);
    }

    // 方法2
    public List<Integer> postorder(Node root) {
        if (root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        for (Node child : root.children) {
            res.addAll(postorder(child));
        }
        res.add(root.val);
        return res;
    }
}
