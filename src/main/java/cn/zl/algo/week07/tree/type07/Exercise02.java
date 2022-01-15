package cn.zl.algo.week07.tree.type07;

import cn.zl.algo.week06.tree.common.TreeNode;

/**
 * 889. 根据前序和后序遍历构造二叉树
 * @author liusha
 * @date 2022/1/15
 */
public class Exercise02 {

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        if (preorder == null || preorder.length == 0) return null;
        return buildTree(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int i, int j, int[] postorder, int p, int q) {
        if (i > j) return null;
        // 前序 根左右   后序 左右根
        // 区分左右字数，后序倒数第二个节点是右字数根节点
        TreeNode root = new TreeNode(preorder[i]);
        if (i == j) return root;
        int rightRoot = postorder[q - 1];
        int rightIdxPre = 0;
        for (int k = i + 1; k <= j; k++) {
            if (preorder[k] == rightRoot) {
                rightIdxPre = k;
                break;
            }
        }
        int leftCnt = rightIdxPre - i - 1;
        root.left = buildTree(preorder, i + 1, rightIdxPre - 1, postorder, p, p + leftCnt - 1);
        root.right = buildTree(preorder, rightIdxPre, j, postorder, p + leftCnt, q - 1);
        return root;
    }
}
