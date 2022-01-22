package cn.zl.algo.week07.tree.exercise.type07;

import cn.zl.algo.week06.tree.common.TreeNode;

/**
 * 105. 从前序与中序遍历序列构造二叉树（中等）
 * @author liusha
 * @date 2022/1/15
 */
public class Exercise01 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) return null;
        TreeNode root = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        return root;
    }

    private TreeNode buildTree(int[] preorder, int i, int j, int[] inorder, int p, int q) {
        if (i > j) return null;
        int rootVal = preorder[i];
        // 可以用hashMap简化查找过程
        int rootIdxIn = 0;
        for (int k = p; k <= q; k++) {
            if (inorder[k] == rootVal) {
                rootIdxIn = k;
                break;
            }
        }
        // 左子树节点个数
        int leftCnt = rootIdxIn - p;

        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(preorder, i + 1, i + leftCnt, inorder, p, rootIdxIn - 1);
        root.right = buildTree(preorder, i + leftCnt + 1, j, inorder, rootIdxIn + 1, q);
        return root;
    }

}
