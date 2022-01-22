package cn.zl.algo.week07.tree.exercise.type07;

/**
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列（中等）
 * @author liusha
 * @date 2022/1/15
 */
public class Exercise04 {

    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length == 0) return true;
        return verifyPostorder(postorder, 0, postorder.length - 1);
    }

    private boolean verifyPostorder(int[] postorder, int i, int j) {
        if (i >= j) return true;
        int rightStart = j - 1;
        while (rightStart >= i && postorder[rightStart] > postorder[j]) {
            rightStart--;
        }
        rightStart++;
        // 右子树：[rightStart, j - 1]
        // 判断左边是否都小于根
        int leftEnd = rightStart - 1;
        while (leftEnd >= i) {
            if (postorder[leftEnd] > postorder[j]) return false;
            leftEnd--;
        }
        return verifyPostorder(postorder, i, rightStart - 1) && verifyPostorder(postorder, rightStart, j - 1);
    }
}
