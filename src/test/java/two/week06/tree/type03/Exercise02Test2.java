package two.week06.tree.type03;

import cn.zl.algo.week06.tree.common.Node;

/**
 * @author liusha
 * @date 2023/4/25
 */
public class Exercise02Test2 {

    public int maxDepth(Node root) {
        if (root == null) return 0;
        int childDepth = 0;
        for (Node child : root.children) {
            childDepth = Math.max(childDepth, maxDepth(child));
        }
        return childDepth + 1;
    }
}
