package two.week09.graph.exercise;

import java.util.*;

/**
 * @author 流沙
 * @date 2023/12/5
 */
public class Exercise11Test2 {


    // String[] names = {"John(15)","Jon(12)","Chris(13)","Kris(4)","Christopher(19)"};
    // String[] synonyms = {"(Jon,John)","(John,Johnny)","(Chris,Kris)","(Chris,Christopher)"};
    // return ["John(27)","Chris(36)"]
    public String[] trulyMostPopular(String[] names, String[] synonyms) {
        if (names == null || names.length == 0 || synonyms == null || synonyms.length == 0) return names;
        // build full cntMap
        Map<String, Integer> cntMap = new HashMap<>();
        for (String name : names) {
            int left = name.indexOf("(");
            cntMap.put(name.substring(0, left), Integer.parseInt(name.substring(left + 1, name.length() - 1)));
        }
        // build name graph
        Map<String, List<String>> nameGraph = new HashMap<>();
        for (String sy : synonyms) {
            int i1 = sy.indexOf("(");
            int i2 = sy.indexOf(")");
            String[] split = sy.substring(i1 + 1, i2).split(",");
            // a -> b
            if (!nameGraph.containsKey(split[0])) {
                nameGraph.put(split[0], new ArrayList<>());
            }
            nameGraph.get(split[0]).add(split[1]);
            // b -> a
            if (!nameGraph.containsKey(split[1])) {
                nameGraph.put(split[1], new ArrayList<>());
            }
            nameGraph.get(split[1]).add(split[0]);
        }
        // travel graph and calculate total, and calculate first name
        List<String> list = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        for (Map.Entry<String, List<String>> entry : nameGraph.entrySet()) {
            String key = entry.getKey();
            cnt = 0;
            prior = null;
            rec(nameGraph, visited, key, cntMap);
            if (cnt == 0) continue;
            list.add(prior + "(" + cnt + ")");
        }
        // in names, and not in graph
        for (Map.Entry<String, Integer> entry : cntMap.entrySet()) {
            if (nameGraph.containsKey(entry.getKey())) continue;
            list.add(entry.getKey() + "(" + entry.getValue() + ")");
        }

        String[] res = new String[list.size()];
        int idx = 0;
        for (String s : list) {
            res[idx++] = s;
        }
        return res;
    }

    int cnt = 0;
    String prior = null;
    private void rec(Map<String, List<String>> nameGraph, Set<String> visited, String key, Map<String, Integer> cntMap) {
        if (visited.contains(key)) return;
        visited.add(key);
        prior = (prior == null || isPrior(key, prior)) ? key : prior;
        cnt += cntMap.getOrDefault(key, 0);
        for (String child : nameGraph.get(key)) {
            rec(nameGraph, visited, child, cntMap);
        }
    }

    // a是否字典序优先于b：相等时返回什么都行
    private boolean isPrior(String a, String b) {
        if (a == null || b == null) return false;
        int i = 0;
        while (i < a.length() && i < b.length()) {
            if (a.charAt(i) < b.charAt(i)) return true;
            if (a.charAt(i) > b.charAt(i)) return false;
            i++;
        }
        if (i == a.length()) return true;
        return false;
    }
}
