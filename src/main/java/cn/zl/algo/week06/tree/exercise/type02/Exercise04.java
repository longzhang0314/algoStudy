package cn.zl.algo.week06.tree.exercise.type02;

import cn.zl.algo.week06.tree.common.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 429. N 叉树的层序遍历
 *
 * @author: longzhang
 * @date: 2022/1/8
 */
public class Exercise04 {

    // 方法1：BFS
    public List<List<Integer>> levelOrder1(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> curList = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                Node curNode = queue.poll();
                curList.add(curNode.val);
                for (Node child : curNode.children) {
                    if (child != null) {
                        queue.offer(child);
                    }
                }
            }
            res.add(curList);
        }

        return res;
    }

    // 方法2：DFS
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        levelOrder(res, root, 0);
        return res;
    }

    private void levelOrder(List<List<Integer>> res, Node root, int level) {
        if (root == null) return;
        if (res.size() == level) {
            res.add(new ArrayList<>());
        }
        List<Integer> curList = res.get(level);
        curList.add(root.val);
        for (Node child : root.children) {
            levelOrder(res, child, level + 1);
        }
    }
}
