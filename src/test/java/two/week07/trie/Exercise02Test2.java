package two.week07.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 流沙
 * @date 2023/8/10
 */
public class Exercise02Test2 {

    public static void main(String[] args){
        Exercise02Test2 e = new Exercise02Test2();
        String big = "mississippi";
        String[] smalls = {"is","ppi","hi","sis","i","ssippi"};
        int[][] res = e.multiSearch(big, smalls);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }


    // 输入：
    //big = "mississippi"
    //smalls = ["is","ppi","hi","sis","i","ssippi"]
    //输出： [[1,4],[8],[],[3],[1,4,7,10],[5]]
    public int[][] multiSearch(String big, String[] smalls) {
        if (big == null || big.length() == 0 || smalls == null || smalls.length == 0) return new int[0][0];
        List<List<Integer>> list = new ArrayList<>(smalls.length);
        for (int i = 0; i < smalls.length; i++) {
            list.add(new ArrayList<>());
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < smalls.length; i++) {
            map.put(smalls[i], i);
        }
        Trie trie = new Trie(smalls);
        for (int i = 0; i < big.length(); i++) {
            for (int j = i; j < big.length(); j++) {
                String sub = big.substring(i, j + 1);
                if (trie.search(sub)) {
                    int idx = map.get(sub);
                    list.get(idx).add(i);
                }
            }
        }
        int[][] res = new int[list.size()][];
        for (int i = 0 ; i < list.size(); i++) {
            List<Integer> single = list.get(i);
            res[i] = new int[single.size()];
            for (int j = 0; j < single.size(); j++) {
                res[i][j] = single.get(j);
            }
        }
        return res;
    }

    private class Trie {

        private class TrieNode {
            char data;
            TrieNode[] child;
            boolean isEnd;

            TrieNode(char data) {
                this.data = data;
                this.child = new TrieNode[26];
                this.isEnd = false;
            }
        }

        private TrieNode root;
        public Trie(String[] words) {
            this.root = new TrieNode('/');
            buildTrie(words);
        }

        public boolean search(String word) {
            if (word == null || word.length() == 0) return false;
            TrieNode p = root;
            for (char c : word.toCharArray()) {
                if (p.child[c - 'a'] == null) return false;
                p = p.child[c - 'a'];
            }
            return p.isEnd;
        }


        private void buildTrie(String[] words) {
            if (words == null || words.length == 0) return;
            for (String word : words) {
                insert(word);
            }
        }

        private void insert(String word) {
            if (word == null || word.length() == 0) return;
            TrieNode p = root;
            for (char c : word.toCharArray()) {
                if (p.child[c - 'a'] == null) {
                    p.child[c - 'a'] = new TrieNode(c);
                }
                p = p.child[c - 'a'];
            }
            p.isEnd = true;
        }
    }
}
