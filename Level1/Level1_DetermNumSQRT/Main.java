package Level1.Level1_DetermNumSQRT;
// Level 1 : 정수 제곱근 판별

class Solution {
    public long solution(long n) {
        double num = Math.sqrt(n);

        if(num == (int)num)
            return (long) Math.pow(num+1, 2);
        else
            return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.solution(121));
        System.out.println(s.solution(3));
    }
}
