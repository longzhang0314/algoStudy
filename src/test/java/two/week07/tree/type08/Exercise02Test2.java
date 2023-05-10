package two.week07.tree.type08;

import cn.zl.algo.week06.tree.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liusha
 * @date 2023/5/8
 */
public class Exercise02Test2 {

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null) return res;
        List<Integer> list = new ArrayList<>();
        travel(root, target, list);
        return res;
    }

    private void travel(TreeNode root, int target, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        if (target - root.val == 0 && root.left == null && root.right == null) {
            res.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }
        travel(root.left, target - root.val, list);
        travel(root.right, target - root.val, list);
        list.remove(list.size() - 1);
    }
}
