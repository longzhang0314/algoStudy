package two.week05.hash;

import java.util.*;

/**
 * @author liusha
 * @date 2023/4/11
 */
public class Exercise12Test2 {


    // hashset
    public int[] intersection1(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return new int[0];
        List<Integer> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int n1 : nums1) {
            set.add(n1);
        }
        for (int n2 : nums2) {
            if (set.contains(n2)) {
                set.remove(n2);
                res.add(n2);
            }
        }
        int[] arr = new int[res.size()];
        int idx = 0;
        for (int i : res) {
            arr[idx++] = i;
        }
        return arr;
    }


    public int[] intersection2(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return new int[0];
        Map<Integer, Boolean> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int n1 : nums1) {
            map.put(n1, true);
        }
        for (int n2 : nums2) {
            boolean b = map.getOrDefault(n2, false);
            if (b) {
                list.add(n2);
                map.put(n2, false);
            }
        }
        int[] arr = new int[list.size()];
        int idx = 0;
        for (int i : list) {
            arr[idx++] = i;
        }
        return arr;
    }

}
