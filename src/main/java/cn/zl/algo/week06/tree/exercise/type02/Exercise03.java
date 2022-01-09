package cn.zl.algo.week06.tree.exercise.type02;

import cn.zl.algo.week06.tree.common.TreeNode;

import java.util.*;

/**
 * 剑指 Offer 32 - III. 从上到下打印二叉树 III（中等）
 *
 * 双栈法、双端队列法、每层头插尾插存入法
 *
 * @author: longzhang
 * @date: 2022/1/8
 */
public class Exercise03 {

    // 方法3：BFS+双端队列；奇数偶数层放入方式不同
    public List<List<Integer>> levelOrder3(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        // 偶数层从右往左存，offerLast
        // 奇数层从左往右存，offerFirst
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offerLast(root);
        int level = 1;
        while (!deque.isEmpty()) {
            if (level % 2 == 1) {
                // 当前是奇数层，上一次是偶数层，上一次pollLast，当前offerFirst
                int size = deque.size();
                List<Integer> list = new ArrayList<>(size);
                for (int i = 0; i < size; i++) {
                    TreeNode cur = deque.pollLast();
                    list.add(cur.val);
                    if (cur.left != null) deque.offerFirst(cur.left);
                    if (cur.right != null) deque.offerFirst(cur.right);
                }
                res.add(list);
            } else {
                int size = deque.size();
                List<Integer> list = new ArrayList<>(size);
                for (int i = 0; i < size; i++) {
                    TreeNode cur = deque.pollFirst();
                    list.add(cur.val);
                    if (cur.right != null) deque.offerLast(cur.right);
                    if (cur.left != null) deque.offerLast(cur.left);
                }
                res.add(list);
            }
            level++;
        }
        return res;
    }

    // 方法2：BFS+双栈法，一个栈从左往右存，一个栈从右往左存
    public List<List<Integer>> levelOrder2(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        // a 存 偶数层，从右往左存
        Stack<TreeNode> a = new Stack<>();
        a.push(root);
        // b 存 奇数层，从左往右存
        Stack<TreeNode> b = new Stack<>();
        int level = 1;
        while (!a.isEmpty() || !b.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            // 奇数层取a，偶数层取b（取的是上一层存的）
            if (level % 2 == 1) {
                while (!a.isEmpty()) {
                    TreeNode cur = a.pop();
                    list.add(cur.val);
                    if (cur.left != null) b.push(cur.left);
                    if (cur.right != null) b.push(cur.right);
                }
            } else {
                while (!b.isEmpty()) {
                    TreeNode cur = b.pop();
                    list.add(cur.val);
                    if (cur.right != null) a.push(cur.right);
                    if (cur.left != null) a.push(cur.left);
                }
            }
            res.add(list);
            level++;
        }
        return res;
    }

    // 方法1：BFS，放的时候都是从左往右放，取的时候按层反转
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> curList = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                if ((level % 2) == 0) {
                    curList.add(curNode.val);
                } else {
                    curList.addFirst(curNode.val);
                }
                if (curNode.left != null) queue.offer(curNode.left);
                if (curNode.right != null) queue.offer(curNode.right);
            }
            res.add(curList);
            level++;
        }
        return res;
    }
}
