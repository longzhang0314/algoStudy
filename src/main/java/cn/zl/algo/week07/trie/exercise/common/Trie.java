package cn.zl.algo.week07.trie.exercise.common;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liusha
 * @date 2022/2/22
 */
public class Trie {

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
        // ...
    }

    public boolean search(String word) {
        // ...
        return false;
    }

    public boolean startsWith(String prefix) {
        // ...
        return false;
    }

    /**
     * 找到整棵trie树中前缀匹配prefix的字符串集合: 打印
     *
     * @param prefix 待检查数组
     */
    public void prefixMatch(char[] prefix) {
        TrieNode p = root;
        if (prefix == null) return;
        for (char c : prefix) {
            int idx = c - 'a';
            if (p.children[idx] == null) return;
            p = p.children[idx];
        }

        List<Character> path = new ArrayList<>();
        travel(p, prefix, path);
    }

    private void travel(TrieNode p, char[] prefix, List<Character> path) {
        if (p.isEnd) {
            StringBuilder sb = new StringBuilder();
            sb.append(prefix);
            sb.append(path);
            System.out.println(sb.toString());
        }
        path.add(p.data);
        for (int i = 0; i < p.children.length; i++) {
            if (p.children[i] != null) {
                travel(p.children[i], prefix, path);
            }
        }
        path.remove(path.size() - 1);
    }
}
