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
public class Exercise01Test2 {


    public int[] levelOrder(TreeNode root) {
        if (root == null) return null;
        List<Integer> res= new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            res.add(cur.val);
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
        //。。。。list to arr
        return null;
    }
}
