package cn.zl.algo.week09.graph.exercise;

import java.util.*;

/**
 * 图选做题
 *
 * 面试题 17.07. 婴儿名字（困难）
 *
 *
 * //每年，政府都会公布一万个最常见的婴儿名字和它们出现的频率，也就是同名婴儿的数量。有些名字有多种拼法，例如，John 和 Jon 本质上是相同的名字，但被当成
 * //了两个名字公布出来。给定两个列表，一个是名字及对应的频率，另一个是本质相同的名字对。设计一个算法打印出每个真实名字的实际频率。注意，如果 John 和 Jon
 * //是相同的，并且 Jon 和 Johnny 相同，则 John 与 Johnny 也相同，即它们有传递和对称性。
 * //
 * // 在结果列表中，选择 字典序最小 的名字作为真实名字。
 * //
 * // 示例：
 * //
 * //输入：names = ["John(15)","Jon(12)","Chris(13)","Kris(4)","Christopher(19)"], syn
 * //onyms = ["(Jon,John)","(John,Johnny)","(Chris,Kris)","(Chris,Christopher)"]
 * //输出：["John(27)","Chris(36)"]
 *
 * @author: longzhang
 * @date: 2022/2/20
 */
public class Exercise11 {

    public static void main(String[] args) {
        Exercise11 e = new Exercise11();
        String[] names = {"John(15)","Jon(12)","Chris(13)","Kris(4)","Christopher(19)"};
        String[] synonyms = {"(Jon,John)","(John,Johnny)","(Chris,Kris)","(Chris,Christopher)"};
        String[] res = e.trulyMostPopular(names, synonyms);
        // 输出：["John(27)","Chris(36)"]
        for (String r : res) {
            System.out.println(r);
        }
    }


    String model = null;
    int count = 0;
    boolean found = false;
    public String[] trulyMostPopular(String[] names, String[] synonyms) {
        // name count map
        Map<String, Integer> nameCount = new HashMap<>();
        for (String name : names) {
            int idx1 = name.indexOf("(");
            int idx2 = name.indexOf(")");
            String str = name.substring(0, idx1);
            String c = name.substring(idx1 + 1, idx2);
            nameCount.put(str, Integer.parseInt(c));
        }

        // define graph
        Map<String, List<String>> graph = new HashMap<>();
        // add graph
        for (String sy : synonyms) {
            int idx1 = sy.indexOf("(");
            int idx2 = sy.indexOf(",");
            int idx3 = sy.indexOf(")");
            String s1 = sy.substring(idx1 + 1, idx2);
            String s2 = sy.substring(idx2 + 1, idx3);
            if (!graph.containsKey(s1)) {
                graph.put(s1, new ArrayList<>());
            }
            graph.get(s1).add(s2);
            if (!graph.containsKey(s2)) {
                graph.put(s2, new ArrayList<>());
            }
            graph.get(s2).add(s1);
        }

        Map<String, Integer> resMap = new HashMap<>();
        Set<String> visited = new HashSet<>();
        for (Map.Entry<String, List<String>> entry : graph.entrySet()) {
            dfs(entry.getKey(), visited, graph, nameCount);
            if (!found) continue;
            resMap.put(model, count);
            found = false;
            model = null;
            count = 0;
        }

        // 在names中，但是不在图中的单独放入
        for (Map.Entry<String, Integer> nameCountEntry : nameCount.entrySet()) {
            if (visited.contains(nameCountEntry.getKey())) continue;
            resMap.put(nameCountEntry.getKey(), nameCountEntry.getValue());
        }

        String[] res = new String[resMap.size()];
        int i = 0;
        for (Map.Entry<String, Integer> entry : resMap.entrySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(entry.getKey()).append("(");
            sb.append(entry.getValue()).append(")");
            res[i++] = sb.toString();
        }
        return res;
    }

    private void dfs(String name, Set<String> visited, Map<String, List<String>> graph, Map<String, Integer> nameCount) {
        if (visited.contains(name)) return;
        found = true;
        visited.add(name);
        if (isPrior(name, model)) {
            model = name;
        }
        count += nameCount.getOrDefault(name, 0);
        for (String next : graph.get(name)) {
            dfs(next, visited, graph, nameCount);
        }
    }

    private boolean isPrior(String name, String model) {
        return model == null || name.compareTo(model) < 0;
    }


}
