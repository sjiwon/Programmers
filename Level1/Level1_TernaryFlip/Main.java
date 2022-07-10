package Level1.Level1_TernaryFlip;
// Level 1 : 3진법 뒤집기

class Solution {
    public int solution(int n) {
        int sum = 0;
        StringBuilder sb = new StringBuilder();

        while(n!=0){
            int div = n%3;
            n/=3;
            sb.append(div);
        }

        return Integer.parseInt(sb.toString(), 3);
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(45));
        System.out.println(s.solution(125));
    }
}
