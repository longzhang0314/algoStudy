package cn.zl.algo.week06.tree.type02.exercise;

import cn.zl.algo.week06.tree.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author liusha
 * @date 2022/1/22
 */
public class Exercise02Test {

    private class MyNode {
        public TreeNode node;
        public int level;
        public MyNode(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    // 存行号
    public List<List<Integer>> levelOrder4(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<MyNode> queue = new LinkedList<>();
        queue.offer(new MyNode(root, 0));

        while (!queue.isEmpty()) {
            MyNode cur = queue.poll();
            if (cur.level == res.size()) {
                res.add(new ArrayList<>());
            }
            res.get(cur.level).add(cur.node.val);
            if (cur.node.left != null) queue.offer(new MyNode(cur.node.left, cur.level + 1));
            if (cur.node.right != null) queue.offer(new MyNode(cur.node.right, cur.level + 1));
        }

        return res;
    }


    public List<List<Integer>> levelOrder5(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);

        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            while (true) {
                TreeNode cur = queue.poll();
                if (cur == null) break;
                list.add(cur.val);
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            res.add(list);
            // 用null把每一层隔开
            if (!queue.isEmpty()) {
                queue.offer(null);
            }
        }
        return res;
    }

}
