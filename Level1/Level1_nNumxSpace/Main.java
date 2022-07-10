package Level1.Level1_nNumxSpace;
// Level 1 : x만큼 간격이 있는 n개의 숫자

class Solution {
    public long[] solution(int x, int n) {
        long [] result = new long[n];
        result[0] = x;
        for(int i=1; i<n; i++){
            result[i] = result[i-1] + x;
        }
        return result;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
