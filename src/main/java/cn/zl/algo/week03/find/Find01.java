package cn.zl.algo.week03.find;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 71.简化路径（中等）
 * 给你一个字符串 path ，表示指向某一文件或目录的 Unix 风格 绝对路径 （以 '/' 开头），请你将其转化为更加简洁的规范路径。
 *
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；
 * 两者都可以是复杂相对路径的组成部分。任意多个连续的斜杠（即，'//'）都被视为单个斜杠 '/' 。
 * 对于此问题，任何其他格式的点（例如，'...'）均被视为文件/目录名称。
 *
 * 请注意，返回的 规范路径 必须遵循下述格式：
 *
 * 始终以斜杠 '/' 开头。
 * 两个目录名之间必须只有一个斜杠 '/' 。
 * 最后一个目录名（如果存在）不能 以 '/' 结尾。
 * 此外，路径仅包含从根目录到目标文件或目录的路径上的目录（即，不含 '.' 或 '..'）。
 * 返回简化后得到的 规范路径 。
 *
 * 输入：path = "/home/"
 * 输出："/home"
 * 解释：注意，最后一个目录名后面没有斜杠。
 *
 * 输入：path = "/home//foo/"
 * 输出："/home/foo"
 * 解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。
 *
 * 输入：path = "/a/./b/../../c/"
 * /a/b/../../c/
 * 输出："/c"
 *
 * 提示：
 *
 * 1 <= path.length <= 3000
 * path 由英文字母，数字，'.'，'/' 或 '_' 组成。
 * path 是一个有效的 Unix 风格绝对路径。
 *
 * @author liusha
 * @date 2021/12/16
 */
public class Find01 {
    public static void main(String[] args) {
        Find01 f = new Find01();
        String s1 = "/home/";
        String s2 = "/home//foo/";
        String s3 = "/a/./b/../../c/"; // "/c"
        String s4 = "/../";
        String s5 = "/a/b/c/..";
        String s6 = "/hello../world";
        String s7 = "/home/foo/.ssh/../.ssh2/authorized_keys/";
        String s8 = "/.././em/jl///../.././../E/";
        String s9 = "/home/";
//        System.out.println(f.simplifyPath(s1));
//        System.out.println(f.simplifyPath(s2));
//        System.out.println(f.simplifyPath(s3));
//        System.out.println(f.simplifyPath(s4));
//        System.out.println(f.simplifyPath(s5));
//        System.out.println(f.simplifyPath(s6));
//        System.out.println(f.simplifyPath(s7));
//        System.out.println(f.simplifyPath(s8));
        System.out.println(f.simplifyPath(s9));
    }


    // 方法1：【利用split函数】先拆分，放入栈中，遇到..就回退
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) return path;
        String[] strs = path.split("/");
        Deque<String> deque = new ArrayDeque<>();
        for (String str : strs) {
            if ("".equals(str) || ".".equals(str)) {
                continue;
            }
            if ("..".equals(str)) {
                if (!deque.isEmpty()) deque.pop();
            } else {
                deque.push(str);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("/");
        while (!deque.isEmpty()) {
            // 因为栈是firstInFirstOut
            sb.append(deque.pollLast());
            sb.append("/");
        }
        return sb.length() == 1 ? sb.toString() : sb.substring(0, sb.length() - 1);
    }


    // 方法2：不需要用到split函数，从头遍历，遇到 / 跳走，否则记录到下一个 / 之前的元素，. 忽略， .. 回退，其余放入栈中
    public String simplifyPath2(String path) {
        if (path == null || path.length() == 0) return path;
        Deque<String> deque = new ArrayDeque<>();
        int i = 0, n = path.length();
        while (i < n) {
            char c = path.charAt(i);
            if (c == '/') {
                i++;
                continue;
            }
            StringBuilder builder = new StringBuilder();
            while (i < n && path.charAt(i) != '/') {
                builder.append(path.charAt(i));
                i++;
            }
            if (builder.length() > 0) {
                String tmp = builder.toString();
                if ("..".equals(tmp)) {
                    if (!deque.isEmpty()) {
                        deque.pollFirst();
                    }
                } else if (!".".equals(tmp)) {
                    deque.offerFirst(tmp);
                    i++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append("/");
            sb.append(deque.pollLast());
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }




}
