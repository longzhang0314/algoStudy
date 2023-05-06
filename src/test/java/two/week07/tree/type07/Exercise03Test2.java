package two.week07.tree.type07;

import cn.zl.algo.week06.tree.common.TreeNode;

/**
 * @author liusha
 * @date 2023/5/5
 */
public class Exercise03Test2 {


    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0) return null;
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] inorder, int iL, int iR, int[] postorder, int pL, int pR) {
        if (iL > iR) return null;
        int rootVal = postorder[pR];
        int rootIdxforIn = 0;
        for (int i = iL; i <= iR; i++) {
            if (inorder[i] == rootVal) {
                rootIdxforIn = i;
                break;
            }
        }
        int leftCnt = rootIdxforIn - iL;
        TreeNode root = new TreeNode(rootVal);
        root.left = build(inorder, iL, rootIdxforIn - 1, postorder, pL, pL + leftCnt - 1);
        root.right = build(inorder, rootIdxforIn + 1, iR, postorder, pL + leftCnt, pR - 1);
        return root;
    }
}
