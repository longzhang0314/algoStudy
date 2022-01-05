package cn.zl.algo.week06.tree.common;

/**
 * 二叉查找树删除节点
 *
 * 【注意】这个写法很好，值得再看看
 * @author: longzhang
 * @date: 2022/1/5
 */
public class DeleteNode {

    /**
     * 三种情况：
     * 1.要删除的节点没有子节点：要删除节点的父节点指向null
     * 2.要删除的节点只有一个子节点：要删除节点的父节点指向要删除节点的子节点
     * 3.要删除的节点有两个子节点：找到要删除节点右子树的"最小节点"，替换到要删除节点的位置，然后删除这个"最小节点"
     *  （删除"最小节点"时可以运用上面两条规则）
     * @param root
     * @param data
     */
    public void delete(TreeNode root, int data) {
        if (root == null) return;
        // 找到待删除节点
        TreeNode pp = null;
        TreeNode p = root;
        while (p != null && p.val != data) {
            pp = p;
            if (data > p.val) {
                p = p.right;
            } else {
                p = p.left;
            }
        }
        if (p == null) return;

        // 如果待删除节点有两个子节点，与"最小节点"进行替换
        if (p.left != null && p.right != null) {
            TreeNode minPP = p;
            TreeNode minP = p.right;
            while (minP != null) {
                minPP = minP;
                if (minP.left != null) {
                    minP = minP.left;
                } else {
                    minP = minP.right;
                }
            }
            p.val = minP.val;
            pp = minPP;
            p = minP;
        }

        // 统一处理前两种情况（包括替换后堆"最小节点"的删除）
        TreeNode child = null;
        if (p.left != null) {
            child = p.left;
        } else {
            child = p.right;
        }

        if (pp == null) { // 要删除的是根节点
            root = child;
        } else if (pp.right == p) {
            pp.right = child;
        } else {
            pp.left = child;
        }
    }
}
