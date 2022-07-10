package Level1.Level1_GymSuit;
// Level 1 : 체육복

import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int count = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();

        Arrays.sort(lost);
        Arrays.sort(reserve);
        for(int i=1; i<=n; i++){
            if(contain(i, reserve) && !contain(i, lost))
                hm.put(i, 2);
            else if(!contain(i, reserve) && !contain(i, lost))
                hm.put(i, 1);
            else if(contain(i, reserve) && contain(i, lost))
                hm.put(i, 1);
            else
                hm.put(i, 0);
        }

        for(int i=0; i<lost.length; i++){
            if((contain(lost[i]-1, reserve) && !contain(lost[i]-1, lost) && !contain(lost[i], reserve)) && hm.get(lost[i]-1) == 2){
                hm.put(lost[i]-1, hm.get(lost[i]-1)-1);
                hm.put(lost[i], hm.get(lost[i])+1);
            }
            else if((contain(lost[i]+1, reserve) && !contain(lost[i]+1, lost) && !contain(lost[i], reserve)) && hm.get(lost[i]+1) == 2){
                hm.put(lost[i]+1, hm.get(lost[i]+1)-1);
                hm.put(lost[i], hm.get(lost[i])+1);
            }
        }

        Set<Integer> set = hm.keySet();
        for (int person : set) {
            if (hm.get(person) >= 1)
                count++;
        }
        return count;
    }

    static boolean contain(int num, int [] arr){
        for (int j : arr) {
            if (num == j)
                return true;
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int [] lost1 = {2, 4};
        int [] lost2 = {2, 4};
        int [] lost3 = {3};
        int [] reserve1 = {1, 3, 5};
        int [] reserve2 = {3};
        int [] reserve3 = {1};

        System.out.println(s.solution(5, lost1, reserve1));
        System.out.println(s.solution(5, lost2, reserve2));
        System.out.println(s.solution(3, lost3, reserve3));
    }
}
