package two.week05.hash;

import java.util.*;

/**
 * @author liusha
 * @date 2023/4/11
 */
public class Exercise02Test2 {

    // method1:three pivot
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        Arrays.asList(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int l = 0; l < nums.length - 2; l++) {
            if (l > 0 && nums[l] == nums[l - 1]) {
                continue;
            }
            int m = l + 1, r= nums.length - 1;
            while (m < r) {
                if (m > l + 1 && nums[m] == nums[m - 1]) {
                    m++;
                    continue;
                }
                if (r < nums.length - 1 && nums[r] == nums[r + 1]) {
                    r--;
                    continue;
                }
                int sum = nums[l] + nums[m] + nums[r];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[l], nums[m], nums[r]));
                    m++;
                    r--;
                } else if (sum < 0) {
                    m++;
                } else {
                    r--;
                }
            }
        }
        return res;
    }


    // method2:hash
    public List<List<Integer>> threeSum2(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        Arrays.asList(nums);
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int l = 0; l < nums.length - 2; l++) {
            if (l > 0 && nums[l] == nums[l - 1]) continue;
            for (int m = l + 1; m < nums.length - 1; m++) {
                if (m > l + 1 && nums[m] == nums[m - 1]) continue;
                int remain = -(nums[l] + nums[m]);
                if (map.containsKey(remain)) {
                    int r = map.get(remain);
                    if (r > m) {
                        res.add(Arrays.asList(nums[l], nums[m], remain));
                    }
                }
            }
        }
        return res;
    }
}
