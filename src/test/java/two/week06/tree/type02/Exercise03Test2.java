package two.week06.tree.type02;

import cn.zl.algo.week06.tree.common.TreeNode;

import java.util.*;

/**
 * @author liusha
 * @date 2023/4/24
 */
public class Exercise03Test2 {

    // method1：放的时候正常放，取的时候按层正反取
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        int level = 0;
        while (!queue.isEmpty()) {
            LinkedList<Integer> list = new LinkedList<>();
            while (!queue.isEmpty() && queue.peek() != null) {
                TreeNode cur = queue.poll();
                if (level % 2 != 0) {
                    // 奇数从反着放
                    list.addFirst(cur.val);
                } else {
                    list.add(cur.val);
                }
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            level++;
            res.add(list);
            if (!queue.isEmpty()) {
                queue.poll();
                if (!queue.isEmpty()) queue.offer(null);
            }
        }
        return res;
    }


    // method2：双栈
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> evenStack = new Stack<>();
        Stack<TreeNode> oddStack = new Stack<>();
        evenStack.push(root);
        int level = 0;
        while (!evenStack.isEmpty() || !oddStack.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            if (level % 2 == 0) {
                // 当前是偶数行，从even取
                while (!evenStack.isEmpty()) {
                    TreeNode cur = evenStack.pop();
                    list.add(cur.val);
                    if (cur.left != null) oddStack.push(cur.left);
                    if (cur.right != null) oddStack.push(cur.right);
                }
            } else {
                // 当前是偶数行，从odd取
                while (!oddStack.isEmpty()) {
                    TreeNode cur = oddStack.pop();
                    list.add(cur.val);
                    if (cur.right != null) evenStack.push(cur.right);
                    if (cur.left != null) evenStack.push(cur.left);
                }
            }
            level++;
            res.add(list);
        }
        return res;
    }


    // method3：duble queue and size
    public List<List<Integer>> levelOrder3(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        // 偶数行用deque左半边，奇数行用deque右半边；左侧元素小于右侧元素
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offerFirst(root);
        int level = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> list = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                if (level % 2 == 0) {
                    // 偶数层:
                    TreeNode cur = deque.pollFirst();
                    list.add(cur.val);
                    if (cur.left != null) deque.offerLast(cur.left);
                    if (cur.right != null) deque.offerLast(cur.right);
                } else {
                    TreeNode cur = deque.pollLast();
                    list.add(cur.val);
                    if (cur.right != null) deque.offerFirst(cur.right);
                    if (cur.left != null) deque.offerFirst(cur.left);
                }
            }
            level++;
            res.add(list);
        }
        return res;
    }


}
