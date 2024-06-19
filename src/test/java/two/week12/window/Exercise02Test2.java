package two.week12.window;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * LCR 167. 招式拆解 I
 *
 * @author: longzhang
 * @date: 2024/6/19
 */
public class Exercise02Test2 {
    public static void main(String[] args) {
        Exercise02Test2 e = new Exercise02Test2();
        System.out.println(e.dismantlingAction("dbascDdad"));
    }

    public int dismantlingAction(String arr) {
        if (arr == null || arr.length() == 0) return 0;
        Set<Character> set = new HashSet<>();
        Deque<Character> deque = new ArrayDeque<>();
        int max = 0;
        for (char c : arr.toCharArray()) {
            if (!set.contains(c)) {
                deque.offerLast(c);
                set.add(c);
                max = Math.max(max, deque.size());
                continue;
            }
            while (!deque.isEmpty()) {
                char first = deque.pollFirst();
                if (first == c) break;
                set.remove(first);
            }
            deque.offerLast(c);
            max = Math.max(max, deque.size());
        }
        return max;
    }
}
