package cn.zl.algo.week06.tree.common;

/**
 * 二叉查找树插入节点
 *
 * 插入，假设要插入的和所有元素都不相等
 * @author: longzhang
 * @date: 2022/1/5
 */
public class InsertNode {

    // 递归实现
    public void insert(TreeNode root, int data) {
        if (root == null) {
            root = new TreeNode(data);
            return;
        }
        doInsert(root, data);
    }
    private void doInsert(TreeNode root, int data) {
        if (data > root.val) {
            if (root.right == null) {
                root.right = new TreeNode(data);
            } else {
                doInsert(root.right, data);
            }
        } else {
            if (root.left == null) {
                root.left = new TreeNode(data);
            } else {
                doInsert(root.left, data);
            }
        }
    }

    // 非递归实现
    public void insert2(TreeNode root, int data) {
        if (root == null) {
            root = new TreeNode(data);
            return;
        }
        TreeNode p = root;
        while (true) {
            if (data > p.val) {
                if (p.right == null) {
                    p.right = new TreeNode(data);
                    break;
                } else {
                    p = p.right;
                }
            } else {
                if (p.left == null) {
                    p.left = new TreeNode(data);
                    break;
                } else {
                    p = p.left;
                }
            }
        }
    }


}
