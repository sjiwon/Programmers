package Level1.Level1_Phoneketmon;
// Level 1 : 폰켓몬

import java.util.*;
class Solution {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums)
            set.add(num);

        return Math.min(set.size(), nums.length/2);
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int [] nums = {3, 1, 2, 3};
        int [] nums2 = {3, 3, 3, 2, 2, 4};
        int [] num3 = {3, 3, 3, 2, 2, 2};

        System.out.println(s.solution(nums));
        System.out.println(s.solution(nums2));
        System.out.println(s.solution(num3));
    }
}
