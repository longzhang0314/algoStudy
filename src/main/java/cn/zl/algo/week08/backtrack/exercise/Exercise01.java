package cn.zl.algo.week08.backtrack.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 08.12 八皇后（困难）
 *
 * 用Q和.表示
 *
 * TODO do 二维数组做
 * @author liusha
 * @date 2022/1/24
 */
public class Exercise01 {

    public List<List<String>> solveNQueens(int n) {
        if (n <= 0) return new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        // 因为每行只能有1个皇后，所有用1维数组表示二维数据
        int[] arr = new int[n];
        // 从第
        back(res, arr, 0, n);
        return res;
    }

    private void back(List<List<String>> res, int[] arr, int row, int n) {
        // 找到一种组合，返回，然后找别的可能性
        if (row == n) {
            List<String> list = arrToList(arr);
            res.add(list);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(arr, row, col)) {
                // 当前合理就放入
                arr[row] = col;
                // 探索下一行放的元素
                back(res, arr, row + 1, n);
            }
            // 全部不合理的话会弹栈，回到上一行重新选择，因为是数组赋值，所以不需要手动remove
        }
    }

    private boolean isValid(int[] arr, int row, int col) {
        int leftUp = col - 1, rightUp = col + 1;
        int rowUp = row - 1;
        while (rowUp >= 0) {
            // 正上方，左上，右上是否有值
            if (arr[rowUp] == col) return false;
            if (leftUp >= 0 && arr[rowUp] == leftUp) return false;
            if (rightUp < arr.length && arr[rowUp] == rightUp) return false;
            rowUp--;
            leftUp--;
            rightUp++;
        }
        return true;
    }

    private List<String> arrToList(int[] arr) {
        List<String> list =  new ArrayList<>(arr.length);
        for (int row = 0; row < arr.length; row++) {
            char[] chs = new char[arr.length];
            int i = 0;
            for(int col = 0; col < arr.length; col++) {
                if (arr[row] == col) {
                    chs[i++] = 'Q';
                } else {
                    chs[i++] = '.';
                }
            }
            list.add(new String(chs));
        }
        return list;
    }
}
