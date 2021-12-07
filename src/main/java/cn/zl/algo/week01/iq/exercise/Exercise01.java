package cn.zl.algo.week01.iq.exercise;

import java.util.*;

/**
 * 面试题 01.08. 零矩阵（简单）
 *
 * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 *
 * 【注意】多种解法和复杂度分析
 * 暴力法，记录：数组（去重），哈希，特殊哈希
 */
public class Exercise01 {

    // 最优解：特殊哈希  时间O(M*N) 空间O(M+N)
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        int m = matrix.length, n = matrix[0].length;
        // 默认值false表示不清除，true表示遇到0清除该行
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    // 暴力法：直接遍历的过程同行同列刷成0（问题：会影响后面值的判断）；所以暴力法需要增加一个tmp数组存储
    // 时间O((M+N)*M*N) 空间O(M*N)
    public void setZeroes1(int[][] matrix) {
        if (matrix == null) return;
        int m = matrix.length, n = matrix[0].length;
        int[][] tmp = new int[m][n];
        // copy to tmp
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                tmp[i][j] = matrix[i][j];
            }
        }
        // tmp as model and setZero in matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (tmp[i][j] == 0) {
                    for (int k = 0; k < m; k++) {
                        matrix[k][j] = 0;
                    }
                    for (int l = 0; l < n; l++) {
                        matrix[i][l] = 0;
                    }
                }
            }
        }
    }

    // 哈希 时间O(M*N) 空间O(M+N)
    public void setZeroes2(int[][] matrix) {
        if (matrix == null) return;
        int m = matrix.length, n = matrix[0].length;
        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row.contains(i) || col.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        // 测试用例:[[0,1,2,0],[3,4,5,2],[1,3,1,5]]
        // 测试结果:[[0,0,0,0],[3,4,5,0],[1,3,1,0]]
        // 期望结果:[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
        Exercise01 e = new Exercise01();
        int[][] matrix = {{0,1,2,0}, {3,4,5,2}, {1,3,1,5}};
        e.setZeroes3(matrix);
    }

    // 数组（需要去重）
    public void setZeroes3(int[][] matrix) {
        if (matrix == null) return;
        int m = matrix.length, n = matrix[0].length;
        List<Integer> row = new ArrayList<>();
        List<Integer> col = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }
        // list去重
        int rowN = removeDuplicates(row);
        int colN = removeDuplicates(col);

        for (int i = 0; i < rowN; i++) {
            int curRow = row.get(i);
            for (int j = 0; j < n; j++) {
                matrix[curRow][j] = 0;
            }
        }

        for (int j = 0; j < colN; j++) {
            int curCol = col.get(j);
            for (int i = 0; i < m; i++) {
                matrix[i][curCol] = 0;
            }
        }
    }
    private int removeDuplicates(List<Integer> list) {
        if (list.size() == 0) return 0;
        Collections.sort(list);
        int j = 0;
        for (int i = 1; i < list.size(); i++) {
            if (!list.get(i).equals(list.get(j))) {
                list.set(++j, list.get(i));
            }
        }
        return j + 1;
    }

}
