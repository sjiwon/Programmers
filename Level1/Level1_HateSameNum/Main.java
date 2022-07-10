package Level1.Level1_HateSameNum;
// Level 1 : 같은 숫자는 싫어

import java.util.*;

class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> list = new ArrayList<>();

        int check_n = -1; // 저장해놓고 다음 수도 같은지 check

        for(int n : arr){
            if(check_n != n)
                list.add(n);
            check_n = n;
        }

        int [] result = new int[list.size()];

        for(int i=0; i<list.size(); i++)
            result[i] = list.get(i);

        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int [] arr1 = {1, 1, 3, 3, 0, 1, 1};
        int [] arr2 = {4, 4, 4, 3, 3};

        int [] result1 = s.solution(arr1);
        int [] result2 = s.solution(arr2);

        System.out.println(Arrays.toString(result1));
        System.out.println(Arrays.toString(result2));
    }
}