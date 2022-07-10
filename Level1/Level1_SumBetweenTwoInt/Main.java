package Level1.Level1_SumBetweenTwoInt;
// Level 1 : 두 정수 사이의 합

class Solution {
    public long solution(int a, int b) {
        long sum = 0;
        for(int i = Math.min(a, b); i<=Math.max(a, b); i++)
            sum += i;
        return sum;
    }
}