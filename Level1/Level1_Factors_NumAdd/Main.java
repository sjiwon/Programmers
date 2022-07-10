package Level1.Level1_Factors_NumAdd;
// Level 1 : 약수의 개수와 덧셈

class Solution {
    public int solution(int left, int right) {
        int result = 0;

        for(int i=left; i<=right; i++){
            /*
            sqrt(i) : int >> odd
            sqrt(i) : double >> even
             */
            if(Math.sqrt(i) == Math.round(Math.sqrt(i))){
                result -= i;
            }
            else{
                result += i;
            }
        }

        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(13, 17));
        System.out.println(s.solution(24, 27));

    }
}
