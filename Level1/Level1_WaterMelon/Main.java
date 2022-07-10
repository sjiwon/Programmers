package Level1.Level1_WaterMelon;
// Level 1 : 수박수박수박수박수박수?

class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();

        int index = 0;
        while(index < n){
            if(index%2 == 0)
                sb.append("수");
            else
                sb.append("박");
            index++;
        }

        return sb.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(3));
        System.out.println(s.solution(4));
        System.out.println(s.solution(19));
    }
}
