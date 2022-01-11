package cn.zl.algo.week06.tree.exercise.type04;

import cn.zl.algo.week06.tree.common.TreeNode;

/**
 * 面试题 04.06. 后继者（中等）
 *
 * 全局只记录一个res和boolean
 * @author: longzhang
 * @date: 2022/1/8
 */
public class Exercise03 {

    public static void main(String[] args) {
        Exercise03 e = new Exercise03();

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        TreeNode p = root.left.left.left;

        System.out.println(e.inorderSuccessor(root, p).val);
    }

    // 方法2：变量记录
    boolean coming = false;
    TreeNode res = null;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        inorder(root, p);
        return res;
    }

    private void inorder(TreeNode root, TreeNode p) {
        if (root == null || res != null) return;
        inorder(root.left, p);
        if (res != null) return;
        if (coming) {
            res = root;
            return;
        }
        if (root == p) {
            coming = true;
        }
        inorder(root.right, p);
    }




    // 方法1：父节点记录
    TreeNode prev = null;
    TreeNode res1 = null;
    public TreeNode inorderSuccessor1(TreeNode root, TreeNode p) {
        if (p == null) return null;
        inorder1(root, p);
        return res1;
    }

    private void inorder1(TreeNode root, TreeNode p) {
        if (root == null || res1 != null) return;
        inorder1(root.left, p);
        // 这里需要剪枝，防止值被修改
        if (res1 != null) return;
        if (prev == p) {
            res1 = root;
            return;
        }
        prev = root;
        inorder(root.right, p);
    }
}
