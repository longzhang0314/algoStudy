package cn.zl.algo.week07.trie.exercise;

/**
 * 208. 实现 Trie (前缀树)（中等） 标准Trie树
 * @author: longzhang
 * @date: 2022/1/16
 */
public class Exercise01 {

    class Trie {

        private class TrieNode {
            public char data;
            public TrieNode[] children;
            public boolean isEnd;

            public TrieNode(char data) {
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
            TrieNode p = root;
            for (char c : word.toCharArray()) {
                if (p.children[c - 'a'] == null) {
                    p.children[c - 'a'] = new TrieNode(c);
                }
                p = p.children[c - 'a'];
            }
            p.isEnd = true;
        }

        public boolean search(String word) {
            TrieNode p = root;
            for (char c : word.toCharArray()) {
                if (p.children[c - 'a'] == null) return false;
                p = p.children[c - 'a'];
            }
            return p.isEnd;
        }

        public boolean startsWith(String prefix) {
            TrieNode p = root;
            for (char c : prefix.toCharArray()) {
                if (p.children[c - 'a'] == null) return false;
                p = p.children[c - 'a'];
            }
            return true;
        }
    }
}
