package cn.zl.algo.week03.find;

import java.util.Stack;

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
//        System.out.println(f.simplifyPath(s1));
//        System.out.println(f.simplifyPath(s2));
//        System.out.println(f.simplifyPath(s3));
//        System.out.println(f.simplifyPath(s4));
//        System.out.println(f.simplifyPath(s5));
//        System.out.println(f.simplifyPath(s6));
//        System.out.println(f.simplifyPath(s7));
        System.out.println(f.simplifyPath(s8));
    }


    // TODO 解法错误，看题解
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) return path;
        int n = path.length();
        int i = 0;
        Stack<Character> stack = new Stack<>();
        while (i < n) {
            char c = path.charAt(i);
            if (isNormal(c) || c == '.') {
                stack.push(c);
                i++;
                continue;
            }
            // 入栈
            // /    遇到普通字符，入栈；遇到栈顶 / ，消掉；  遇到 . ，消掉.和/；遇到两个 ., 消掉两个 . ，并消掉前一个 / 和前一个元素
            // .    直接入栈
            if (c == '/') {
                if (stack.isEmpty() || isNormal(stack.peek())) {
                    i++;
                    stack.push(c);
                    continue;
                }
                if (stack.peek() == '/') {
                    i++;
                    continue;
                }
                if (stack.peek() == '.') {
                    // 连续有几个.
                    int point = 0;
                    while (!stack.isEmpty() && stack.peek() == '.') {
                        point++;
                        stack.pop();
                    }
                    if (point > 2 || (!stack.isEmpty() && isNormal(stack.peek()))) {
                        for (int j = 0; j < point; j++) {
                            stack.push('.');
                        }
                        stack.push(c);
                        i++;
                        continue;
                    }
                    if (point == 1) {
                        i++;
                        continue;
                    }
                    while (!stack.isEmpty()) {
                        stack.pop();
                    }
                    while (!stack.isEmpty() && (isNormal(stack.peek()) || stack.peek() == '.')) {
                        stack.pop();
                    }
                    i++;
                    continue;
                }
            }
        }

        // 处理末尾是.的情况
        int point = 0;
        while (!stack.isEmpty() && stack.peek() == '.') {
            stack.pop();
            point++;
        }

        if (point == 1) {
            if (!stack.isEmpty() && stack.peek() == '/') {
                stack.pop();
            }
        } else if (point == 2) {
            if (!stack.isEmpty() && stack.peek() == '/') {
                stack.pop();
                while (!stack.isEmpty() && stack.peek() != '/') {
                    stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() == '/') {
                    stack.pop();
                }
            }
        } else if (point > 2) {
            for (int j = 0; j < point; j++) {
                stack.push('.');
            }
        }

        // 出栈
        // 栈顶如果是 / ,直接丢弃
        // 栈最后一个元素不是 /，补一个 /
        if (!stack.isEmpty() && stack.peek() == '/') {
            stack.pop();
        }

        // 处理空的情况
        if (stack.isEmpty()) {
            return "/";
        }

        char[] res = new char[stack.size() + 1];
        int idx = res.length - 1;
        while (!stack.isEmpty()) {
            res[idx--] = stack.pop();
        }
        if (res[1] != '/') {
            res[0] = '/';
            return new String(res);
        } else {
            return new String(res, 1, res.length - 1);
        }
    }

    private boolean isNormal(char c) {
        return (c >= '0' && c <='9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == '_';
    }


}
