package Level1.Level1_AddDigits;
// Level 1 : 자릿수 더하기

class Solution {
    public int solution(int n) {
        int sum = 0;

        while(n!=0){
            sum += (n%10);
            n/=10;
        }

        return sum;
    }
}
