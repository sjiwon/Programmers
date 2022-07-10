package Level1.Level1_RemoveSmallestNum;
// Level 1 : 제일 작은 수 제거하기

import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();

        for(int n : arr)
            list.add(n);

        list.remove(Collections.min(list));

        if(list.size() == 0)
            return new int[]{-1};
        else{
            int [] result = new int[list.size()];
            for(int i=0; i<result.length; i++)
                result[i] = list.get(i);
            return result;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int [] arr1 = {4, 3, 2, 1};
        int [] arr2 = {10};

        System.out.println(Arrays.toString(s.solution(arr1)));
        System.out.println(Arrays.toString(s.solution(arr2)));
    }
}
