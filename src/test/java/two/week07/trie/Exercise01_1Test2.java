package two.week07.trie;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 流沙
 * @date 2023/8/10
 */
public class Exercise01_1Test2 {

    class Trie {

        private class TrieNode {
            char data;
            Map<Character, TrieNode> child;
            boolean isEnd;

            TrieNode(char data) {
                this.data = data;
                this.child = new HashMap<>();
                this.isEnd = false;
            }
        }

        private TrieNode root = new TrieNode('/');


        public void insert(String word) {
            if (word == null || word.length() == 0) return;
            TrieNode p = root;
            for (char c : word.toCharArray()) {
                if (!p.child.containsKey(c)) {
                    p.child.put(c, new TrieNode(c));
                }
                p = p.child.get(c);
            }
            p.isEnd = true;
        }

        public boolean search(String word) {
            if (word == null || word.length() == 0) return false;
            TrieNode p = root;
            for (char c : word.toCharArray()) {
                if (!p.child.containsKey(c)) return false;
                p = p.child.get(c);
            }
            return p.isEnd;
        }

        public boolean startsWith(String prefix) {
            if (prefix == null || prefix.length() == 0) return false;
            TrieNode p = root;
            for (char c : prefix.toCharArray()) {
                if (!p.child.containsKey(c)) return false;
                p = p.child.get(c);
            }
            return true;
        }
    }
}
