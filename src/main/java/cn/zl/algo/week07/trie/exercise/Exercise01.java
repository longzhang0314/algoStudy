package cn.zl.algo.week07.trie.exercise;

import java.util.HashMap;
import java.util.Map;

/**
 * 208. 实现 Trie (前缀树)（中等） 标准Trie树
 *
 * 【注意】用hash表代替一一映射数组
 *
 * @author: longzhang
 * @date: 2022/1/16
 */
public class Exercise01 {

    // 方法1：用hash表存储，更普适
    class Trie {

        private class TrieNode {
            public char data;
            public Map<Character, TrieNode> children;
            public boolean isEnd;

            public TrieNode(char data) {
                this.data = data;
                this.children = new HashMap<>();
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
                if (!p.children.containsKey(c)) {
                    p.children.put(c, new TrieNode(c));
                }
                p = p.children.get(c);
            }
            p.isEnd = true;
        }

        public boolean search(String word) {
            TrieNode p = root;
            for (char c : word.toCharArray()) {
                if (!p.children.containsKey(c)) return false;
                p = p.children.get(c);
            }
            return p.isEnd;
        }

        public boolean startsWith(String prefix) {
            TrieNode p = root;
            for (char c : prefix.toCharArray()) {
                if (!p.children.containsKey(c)) return false;
                p = p.children.get(c);
            }
            return true;
        }



    }



    // 方法2：用1:1映射的数组存储，针对字符只有小写字母的情况
    class Trie2 {

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

        public Trie2() {
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
