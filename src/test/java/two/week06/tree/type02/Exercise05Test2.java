package two.week06.tree.type02;

import cn.zl.algo.week06.tree.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liusha
 * @date 2023/4/25
 */
public class Exercise05Test2 {

    // method1: BFS
    public int findBottomLeftValue1(TreeNode root) {
        if (root == null) return -1;
        int res = -1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                res = cur.val;
                if (cur.right != null) queue.offer(cur.right);
                if (cur.left != null) queue.offer(cur.left);
            }
        }
        return res;
    }


    // method2: DFS
    int res = -1;
    // 行号
    int maxLevel = -1;
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) return -1;
        preorder(root, 0);
        return res;
    }

    private void preorder(TreeNode root, int level) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            if (level > maxLevel) {
                maxLevel = level;
                res = root.val;
            }
            return;
        }
        preorder(root.left, level + 1);
        preorder(root.right, level + 1);
    }
}
