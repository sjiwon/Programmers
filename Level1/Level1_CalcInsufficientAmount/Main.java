package Level1.Level1_CalcInsufficientAmount;
// Level 1 : 부족한 금액 계산하기

class Solution {
    public long solution(int price, int money, int count) {
        long sum = 0; // count번 타는데 드는 총 비용

        for(int i=1; i<=count; i++){
            sum += (long)price*i;
        }

        if(money < sum)
            return Math.abs(money - sum);
        else // 돈이 모자라지 않으면 0 리턴
            return 0;
    }
}