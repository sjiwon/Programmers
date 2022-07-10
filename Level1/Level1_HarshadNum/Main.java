package Level1.Level1_HarshadNum;
// Level 1 : 하샤드 수

class Solution {
    public boolean solution(int x) {
        int sum = 0;

        int n = x;
        while(n!=0){
            sum += (n%10);
            n/=10;
        }

        if(x%sum == 0)
            return true;
        else
            return false;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(10));
        System.out.println(s.solution(12));
        System.out.println(s.solution(11));
        System.out.println(s.solution(13));
    }
}
