package two.week06.tree.type03;

import cn.zl.algo.week06.tree.common.TreeNode;

/**
 * @author liusha
 * @date 2023/4/28
 */
public class Exercise07Test2 {

    // method1: preorder and judge cur more than pre
    boolean isBST = true;
    Integer pre = null;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        preorder(root);
        return isBST;
    }
    private void preorder(TreeNode root) {
        if (root == null || !isBST) return;
        preorder(root.left);
        if (pre != null && pre >= root.val) {
            isBST = false;
            return;
        }
        pre = root.val;
        preorder(root.right);
    }


    // method2: recursion
    // left is BST, right is BST, and root is BST
    boolean isBst = true;
    public boolean isValidBST2(TreeNode root) {
        if (root == null) return true;
        travel(root);
        return isBST;
    }

    // 返回当前树的最大[1]最小值[0]
    private int[] travel(TreeNode root) {
        if (root == null || !isBst) return null;
        int[] curArr = new int[2];
        curArr[0] = root.val;
        curArr[1] = root.val;

        int[] leftArr = travel(root.left);
        int[] rightArr = travel(root.right);

        if (leftArr != null) {
            if (leftArr[1] >= root.val) {
                isBst = false;
                return curArr;
            }
            curArr[0] = Math.min(curArr[0], leftArr[0]);
        }

        if (rightArr != null) {
            if (rightArr[0] <= root.val) {
                isBST = false;
                return curArr;
            }
            curArr[1] = Math.max(curArr[1], rightArr[1]);
        }
        return curArr;
    }


}
