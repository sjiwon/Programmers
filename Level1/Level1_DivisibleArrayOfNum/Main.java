package Level1.Level1_DivisibleArrayOfNum;
// Level 1 : 나누어 떨어지는 숫자 배열

import java.util.*;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> list = new ArrayList<>();

        for(int n : arr){
            if(n%divisor == 0)
                list.add(n);
        }

        if(list.size() == 0)
            return new int[]{-1};
        else{
            Collections.sort(list);
            int [] result = new int[list.size()];
            int i = 0;
            for(Integer n : list){
                result[i] = n;
                i++;
            }
            return result;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int [] arr1 = {5, 9, 7, 10};
        int [] arr2 = {2, 36, 1, 3};
        int [] arr3 = {3, 2, 6};

        System.out.println(Arrays.toString(s.solution(arr1, 5)));
        System.out.println(Arrays.toString(s.solution(arr2, 1)));
        System.out.println(Arrays.toString(s.solution(arr3, 10)));
    }
}
