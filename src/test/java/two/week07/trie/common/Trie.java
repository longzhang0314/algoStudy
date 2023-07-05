package two.week07.trie.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author: longzhang
 * @date: 2023/5/10
 */
public class Trie {

    private class TrieNode {
        private char data;
        private TrieNode[] children;
        private boolean isEnd;

        TrieNode(char data) {
            this.data = data;
            this.children = new TrieNode[26];
        }
    }

    private TrieNode root;

    public Trie() {
        this.root = new TrieNode('/');
    }

    public void insert(String word) {
        if (word == null || word.length() == 0) return;
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (p.children[c - 'a'] == null) {
                p.children[c - 'a'] = new TrieNode(c);
            }
            p = p.children[c - 'a'];
        }
        p.isEnd = true;
    }

    public boolean search(String word) {
        if (word == null || word.length() == 0) return false;
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (p.children == null || p.children[c - 'a'] == null) return false;
            p = p.children[c - 'a'];
        }
        return p.isEnd;
    }

    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0) return false;
        TrieNode p = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (p.children == null || p.children[c - 'a'] == null) return false;
            p = p.children[c - 'a'];
        }
        return true;
    }

    // 找到整棵trie树中前缀匹配prefix的字符串集合: 打印
    public void prefixMatch(char[] prefix) {
        if (prefix == null || prefix.length == 0) return;
        TrieNode p = root;
        for (char c : prefix) {
            if (p.children == null || p.children[c - 'a'] == null) return;
            p = p.children[c - 'a'];
        }
        // 此时p停留在前缀的下一个字符处
        List<List<Character>> res = new ArrayList<>();
        List<Character> list = new ArrayList<>();
        // add prefix to list。。。

        addRes(res, p, new ArrayList<>());
    }

    // TODO 2023 需要测一下对不对，细节
    private void addRes(List<List<Character>> res, TrieNode p, List<Character> list) {
        if (p == null) {
            if (list.size() != 0) {
                res.add(new ArrayList<>(list));
            }
            return;
        }
        if (p.isEnd) {
            if (list.size() != 0) {
                res.add(new ArrayList<>(list));
            }
            return;
        }
        list.add(p.data);
        for (TrieNode child : p.children) {
            addRes(res, child, list);
        }
        list.remove(list.size() - 1);
    }

}
