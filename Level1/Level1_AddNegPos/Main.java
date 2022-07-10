package Level1.Level1_AddNegPos;
// Level 1 : 음양 더하기

class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int sum = 0;
        for(int i=0; i<absolutes.length; i++){
            if(!signs[i])
                absolutes[i] *= -1;
        }
        for(int num : absolutes)
            sum += num;
        return sum;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int [] absolutes1 = {4, 7, 12};
        boolean [] signs1 = {true, false, true};
        int [] absolutes2 = {1, 2, 3};
        boolean [] signs2 = {false, false, true};
        System.out.println(s.solution(absolutes1, signs1));
        System.out.println(s.solution(absolutes2, signs2));
    }
}
