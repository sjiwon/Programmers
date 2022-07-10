package Level1.Level1_GetAverage;
// Level 1 : 평균 구하기

class Solution {
    public double solution(int[] arr) {
        double sum = 0;

        for(int r : arr)
            sum += r;

        return sum/arr.length;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
