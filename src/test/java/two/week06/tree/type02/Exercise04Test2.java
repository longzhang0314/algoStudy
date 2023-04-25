package two.week06.tree.type02;

import cn.zl.algo.week06.tree.common.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author liusha
 * @date 2023/4/24
 */
public class Exercise04Test2 {


    public List<List<Integer>> levelOrder1(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);

        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            while (!queue.isEmpty() && queue.peek() != null) {
                Node cur = queue.poll();
                list.add(cur.val);
                if (cur.children != null) {
                    for (Node child : cur.children) {
                        queue.offer(child);
                    }
                }
            }
            res.add(list);
            if (!queue.isEmpty()) {
                queue.poll();
                if (!queue.isEmpty()) queue.offer(null);
            }

        }
        return res;
    }
}
