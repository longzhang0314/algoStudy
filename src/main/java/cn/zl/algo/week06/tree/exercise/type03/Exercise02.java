package cn.zl.algo.week06.tree.exercise.type03;

import cn.zl.algo.week06.tree.common.Node;

/**
 * 559. N 叉树的最大深度
 *
 * @author: longzhang
 * @date: 2022/1/8
 */
public class Exercise02 {

    public int maxDepth(Node root) {
        if (root == null) return 0;
        int max = 0;
        for (Node child : root.children) {
            max = Math.max(max, maxDepth(child));
        }
        return max + 1;
    }
}
