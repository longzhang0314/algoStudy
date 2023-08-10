package two.week07.trie;

import java.util.*;

/**
 * @author 流沙
 * @date 2023/8/10
 */
public class Exercise03Test2 {

    //输入：board = [["o","a","a","n"],
    //              ["e","t","a","e"],
    //              ["i","h","k","r"],
    //              ["i","f","l","v"]],
    //     words = ["oath","pea","eat","rain"]
    // 输出：["eat","oath"]
    // words无重复
    public List<String> findWords(char[][] board, String[] words) {
        if (board == null || board.length == 0 || board[0].length == 0
                || words == null || words.length == 0) return new ArrayList<>();
        int m = board.length, n = board[0].length;
        Set<String> res = new HashSet<>();
        // words build Trie
        Trie trie = new Trie(words);
        // backtrace board, if search add set
        List<Character> cl = new ArrayList<>();
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        process(board, words, visited, res, cl, 0, 0, m, n);
        return new ArrayList<>(res);
    }

    private void process(char[][] board, String[] words, boolean[][] visited, Set<String> res, List<Character> cl,
                         int i, int j, int m, int n) {

    }

    private class Trie {
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

        private TrieNode root;
        public Trie(String[] words) {
            this.root = new TrieNode('/');
            if (words == null || words.length == 0) return;
            for (String word : words) {
                insert(word);
            }
        }

        private void insert(String word) {
            if (word == null || word.length() == 0) return;
            TrieNode p = root;
            for (char c : word.toCharArray()) {
                TrieNode cur = p.child.get(c);
                if (cur == null) {
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
                TrieNode cur = p.child.get(c);
                if (cur == null) return false;
                p.child.put(c, new TrieNode(c));
                p = p.child.get(c);
            }
            return p.isEnd;
        }
    }
}
