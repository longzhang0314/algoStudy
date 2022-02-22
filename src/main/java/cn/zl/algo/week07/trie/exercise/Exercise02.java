package cn.zl.algo.week07.trie.exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 面试题 17.17. 多次搜索（中等） 标准AC自动机，不过写AC自动机太复杂，Trie树搞定
 *
 * @author: longzhang
 * @date: 2022/1/16
 */
public class Exercise02 {


    public static void main(String[] args) {
        String big = "mississippi";
        String[] smalls = {"is","ppi","hi","sis","i","ssippi"};
        Exercise02 e = new Exercise02();
        int[][] ints = e.multiSearch(big, smalls);
        for (int[] i : ints) {
            for (int j : i) {
                System.out.print(j + ", ");
            }
            System.out.println();
        }
    }


    public int[][] multiSearch(String big, String[] smalls) {
        List<List<Integer>> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < smalls.length; i++) {
            map.put(smalls[i], i);
            insert(smalls[i].toCharArray());
            res.add(new ArrayList<>());
        }
        char[] bigChs = big.toCharArray();
        for (int i = 0; i < big.length(); i++) {
            for (int j = i; j < big.length(); j++) {
                boolean find = find(bigChs, i, j);
                if (find) {
                    String sub = big.substring(i, j + 1);
                    int idx = map.get(sub);
                    res.get(idx).add(i);
                }
            }
        }
        int[][] arr = new int[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = new int[res.get(i).size()];
            for (int j = 0; j < res.get(i).size(); j++) {
                arr[i][j] = res.get(i).get(j);
            }
        }
        return arr;
    }

    public boolean find(char[] chs, int i, int j) {
        TrieNode p = root;
        for (int k = i; k <= j; k++) {
            char data = chs[k];
            int idx = data - 'a';
            if (p.children[idx] == null) return false;
            p = p.children[idx];
        }
        return p.isEnd;
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
