package two.week07.tree.type07;

/**
 * @author liusha
 * @date 2023/5/5
 */
public class Exercise04Test2 {

    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length == 0) return true;
        return verify(postorder, 0, postorder.length - 1);
    }

    private boolean verify(int[] postorder, int i, int j) {
        if (i >= j) return true;
        int root = postorder[j];
        int leftIdx = i;
        while (leftIdx < j && postorder[leftIdx] < root) {
            leftIdx++;
        }
        for (int k = leftIdx; k < j; k++) {
            if (postorder[k] < root) return false;
        }
        return verify(postorder, i, leftIdx - 1) && verify(postorder, leftIdx, j - 1);
    }
}
