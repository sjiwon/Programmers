package Level1.Level1_CollatzGuess;
// Level 1 : 콜라츠 추측

class Solution {
    public int solution(int num) {
        int count = 0;

        long num2 = (long)num;
        while(num2!=1){
            if(count > 500)
                return -1;

            if(num2%2 == 0)
                num2/=2;
            else
                num2 = num2*3 + 1;
            count++;
        }

        return count;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(6));
        System.out.println(s.solution(16));
        System.out.println(s.solution(626331));
    }
}
