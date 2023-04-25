package two.week06.tree.type02;

import cn.zl.algo.week06.tree.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author liusha
 * @date 2023/4/23
 */
public class Exercise02Test2 {

    // size，存层号，存null

    // method1:size
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                list.add(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            res.add(list);
        }
        return res;
    }


    // method2:save null
    public List<List<Integer>> levelOrder4(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);

        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            while (!queue.isEmpty() && queue.peek() != null) {
                TreeNode cur = queue.poll();
                list.add(cur.val);
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            res.add(list);
            if (!queue.isEmpty()) {
                queue.poll();
                if (!queue.isEmpty()) queue.offer(null);
            }
        }
        return res;
    }

    private class QueueNode {
        TreeNode root;
        int level;

        QueueNode(TreeNode root, int level) {
            this.root = root;
            this.level = level;
        }
    }

    // method3:save level number
    public List<List<Integer>> levelOrder3(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<QueueNode> queue = new LinkedList<>();
        int level = 0;
        queue.offer(new QueueNode(root, level));

        while (!queue.isEmpty()) {
            QueueNode curNode = queue.poll();
            TreeNode cur = curNode.root;
            int curLevel = curNode.level;
            if (res.size() == curLevel) {
                res.add(new ArrayList<>());
            }
            res.get(curLevel).add(cur.val);
            if (cur.left != null) queue.offer(new QueueNode(cur.left, curLevel + 1));
            if (cur.right != null) queue.offer(new QueueNode(cur.right, curLevel + 1));
        }
        return res;
    }
}
