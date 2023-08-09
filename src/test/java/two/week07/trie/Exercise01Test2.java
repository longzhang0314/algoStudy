package two.week07.trie;

/**
 * @author: longzhang
 * @date: 2023/5/10
 */
public class Exercise01Test2 {

    class Trie {


        // 假设只有小写字母，可以使用1:1映射的数组构建Trie树
        private class TrieNode {
            char data;
            TrieNode[] children;
            boolean isEnd;

            TrieNode(char data) {
                this.data = data;
                this.children = new TrieNode[26];
                this.isEnd = false;
            }
        }

        private TrieNode root;

        public Trie() {
            this.root = new TrieNode('/');
        }

        public void insert(String word) {
            if (word == null || word.length() == 0) return;
            TrieNode p = root;
            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                if (p.children[idx] == null) {
                    p.children[idx] = new TrieNode(c);
                }
                p = p.children[idx];
            }
            p.isEnd = true;
        }

        public boolean search(String word) {
            if (word == null || word.length() == 0) return false;
            TrieNode p = root;
            for (char c : word.toCharArray()) {
                if (p.children[c - 'a'] == null) return false;
                p = p.children[c - 'a'];
            }
            return p.isEnd;
        }

        public boolean startsWith(String prefix) {
            if (prefix == null || prefix.length() == 0) return false;
            TrieNode p = root;
            for (char c : prefix.toCharArray()) {
                if (p.children[c - 'a'] == null) return false;
                p = p.children[c - 'a'];
            }
            return p.isEnd;
        }
    }
}
