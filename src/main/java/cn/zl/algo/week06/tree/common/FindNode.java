package cn.zl.algo.week06.tree.common;

/**
 * 二叉查找树查询节点
 *
 * @author: longzhang
 * @date: 2022/1/5
 */
public class FindNode {

    // 递归实现 O(logN) O(logN)
    public TreeNode find(TreeNode root, int data) {
        if (root == null) return null;
        if (root.val == data) {
            return root;
        } else if (root.val < data) {
            return find(root.right, data);
        } else {
            return find(root.left, data);
        }
    }

    // 非递归实现 O(logN) ,空间 O(1)
    public TreeNode find2(TreeNode root, int data) {
        TreeNode p = root;
        while (p != null) {
            if (p.val == data) {
                return p;
            } else if (p.val < data) {
                p = p.right;
            } else {
                p = p.left;
            }
        }
        return null;
    }
}
