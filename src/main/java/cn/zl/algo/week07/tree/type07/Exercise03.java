package cn.zl.algo.week07.tree.type07;

import cn.zl.algo.week06.tree.common.TreeNode;

/**
 * 106. 从中序与后序遍历序列构造二叉树（中等）
 * @author liusha
 * @date 2022/1/15
 */
public class Exercise03 {
    public static void main(String[] args) {
        Exercise03 e = new Exercise03();
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        TreeNode treeNode = e.buildTree(inorder, postorder);
        System.out.println(treeNode.val);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0) return null;
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int i, int j, int[] postorder, int p, int q) {
        if (i > j) return null;
        // 中序 左根右   后序  左右根
        int rootVal = postorder[q];
        int rootIdxIn = 0;
        for (int k = i; k <= j; k++) {
            if (inorder[k] == rootVal) {
                rootIdxIn = k;
                break;
            }
        }
        int leftCnt = rootIdxIn - i;
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(inorder, i, rootIdxIn - 1, postorder, p, p + leftCnt - 1);
        root.right = buildTree(inorder, rootIdxIn + 1, j, postorder, p + leftCnt, q - 1);
        return root;
    }

}
