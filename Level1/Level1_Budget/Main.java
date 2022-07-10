package Level1.Level1_Budget;
// Level 1 : 예산

import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        int result = d.length;
        int sum = 0;

        Arrays.sort(d);

        for(int n : d)
            sum += n;

        for(int i=d.length-1; i>=0; i--){
            if(sum<=budget)
                break;
            sum -= d[i];
            result--;
        }

        return result;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
