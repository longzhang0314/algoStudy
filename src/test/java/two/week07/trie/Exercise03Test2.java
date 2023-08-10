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
        process(board, trie, visited, res, cl, 0, 0, m, n);
        return new ArrayList<>(res);
    }

    int[][] ops = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private void process(char[][] board, Trie trie, boolean[][] visited, Set<String> res, List<Character> cl,
                         int i, int j, int m, int n) {
        if (!inBoard(board, i, j, m, n) || visited[i][j]) {
            return;
        }
        if (trie.search(cl)) {
            StringBuilder sb = new StringBuilder();
            for (Character c : cl) {
                sb.append(c);
            }
            res.add(sb.toString());
            return;
        }

        visited[i][j] = true;
        cl.add(board[i][j]);
        for (int[] op : ops) {
            int newI = op[0];
            int newJ= op[1];
            process(board, trie, visited, res, cl, newI, newJ, m, n);
        }
        cl.remove(cl.size() - 1);

    }

    private boolean inBoard(char[][] board, int i, int j, int m, int n) {
        return i >= 0 && j >= 0 && i < m && j < n;
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

        public boolean search(List<Character> list) {
            if (list == null || list.size() == 0) return false;
            TrieNode p = root;
            for (char c : list) {
                TrieNode cur = p.child.get(c);
                if (cur == null) return false;
                p.child.put(c, new TrieNode(c));
                p = p.child.get(c);
            }
            return p.isEnd;
        }
    }
}
