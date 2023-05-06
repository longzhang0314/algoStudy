package two.week07.tree.type07;

import cn.zl.algo.week06.tree.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liusha
 * @date 2023/5/5
 */
public class Exercise01Test2 {

    Map<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) return null;
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int pL, int pR, int[] inorder, int iL, int iR) {
        if (pL > pR) return null;
        TreeNode root = new TreeNode(preorder[pL]);
        // find inorder idx by value:preorder[pL]
        int rootIdx = map.get(preorder[pL]);
        root.left = buildTree(preorder, pL + 1, pL + rootIdx - iL, inorder, iL, rootIdx - 1);
        root.right = buildTree(preorder, pL + rootIdx - iL + 1, pR, inorder, rootIdx + 1, iR);
        return root;
    }
}
