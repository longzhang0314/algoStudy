package cn.zl.algo.week07.trie.exercise;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 212. 单词搜索 II（困难）
 *
 * @author: longzhang
 * @date: 2022/1/16
 */
public class Exercise03 {

    Set<String> set;
    int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
    public List<String> findWords(char[][] board, String[] words) {
        for (String word : words) {
            insert(word.toCharArray());
        }

        set = new HashSet<>();
        List<Character> path = new ArrayList<>();
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                path.add(board[i][j]);
                visited[i][j] = true;
                TrieNode p = root;
                dfs(board, i, j, visited, path, p);
                visited[i][j] = false;
                path.remove(path.size() - 1);
            }
        }
        List<String> res = new ArrayList<>();
        res.addAll(set);
        return res;
    }

    private void dfs(char[][] board, int i, int j, boolean[][] visited, List<Character> path, TrieNode p) {
        p = p.children[board[i][j] - 'a'];
        if (p == null) return;
        if (p.isEnd) {
            char[] chs = new char[path.size()];
            int k = 0;
            for (char c : path) {
                chs[k++] = c;
            }
            set.add(new String(chs));
        }

        for (int[] direction : directions) {
            int row = i + direction[0];
            int col = j + direction[1];
            if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) continue;
            if (visited[row][col]) continue;
            visited[row][col] = true;
            path.add(board[row][col]);
            dfs(board, row, col, visited, path, p);
            visited[row][col] = false;
            path.remove(path.size() - 1);
        }

    }

    public void insert(char[] chs) {
        TrieNode p = root;
        for (int i = 0; i < chs.length; i++) {
            char data = chs[i];
            int idx = data - 'a';
            if (p.children[idx] == null) {
                p.children[idx] = new TrieNode(data);
            }
            p = p.children[idx];
        }
        p.isEnd = true;
    }

    private TrieNode root = new TrieNode('/');

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

}
