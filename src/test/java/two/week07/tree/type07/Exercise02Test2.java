package two.week07.tree.type07;

import cn.zl.algo.week06.tree.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liusha
 * @date 2023/5/5
 */
public class Exercise02Test2 {

    // 根左右  左右根：后序倒数第二个是右子数根
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        if (preorder == null || preorder.length == 0) return null;
        for (int i = 0 ; i < preorder.length; i++) {
            map.put(preorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] preorder, int preL, int preR, int[] postorder, int postL, int postR) {
        if (preL > preR) return null;
        TreeNode root = new TreeNode(preorder[preL]);
        if (postR == postL) return root;
        int rightRootVal = postorder[postR - 1];
        int rightRootIdxInPre = map.get(rightRootVal);
        int leftCnt = rightRootIdxInPre - 1 - preL;
        root.left = build(preorder, preL + 1, rightRootIdxInPre - 1, postorder, postL, postL + leftCnt - 1);
        root.right = build(preorder, rightRootIdxInPre, preR, postorder, postL + leftCnt, postR - 1);
        return root;
    }
}
