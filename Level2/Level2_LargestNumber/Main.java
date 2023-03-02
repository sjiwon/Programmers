package Level2.Level2_LargestNumber;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        String[] str = new String[numbers.length];
        for(int i=0; i<numbers.length; i++) {
            str[i] = String.valueOf(numbers[i]);
        }

        // 연속적으로 이어졌을 때 가장 큰 문자열이 되도록 정렬 (앞뒤 덧셈을 통한 정렬)
        Arrays.sort(str, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        if(str[0].equals("0")) {
            return "0";
        } else {
            StringBuilder sb = new StringBuilder();
            for(String value : str) {
                sb.append(value);
            }
            return sb.toString();
        }
    }
}

public class Main {
    static void start(int[] numbers, String expect){
        String solution = new Solution().solution(numbers);

        StringBuilder result = new StringBuilder();
        result.append("## 테스트 케이스 ##").append("\n")
                .append("[Parameter -> int[] numbers]").append("\n")
                .append("-> ").append(Arrays.toString(numbers)).append("\n\n")
                .append("[Result]").append("\n")
                .append("-> ").append(solution).append("\n\n")
                .append("======================================\n")
                .append("예상 정답 = ").append(solution).append("\n")
                .append("실제 정답 = ").append(expect);

        System.out.println(result);
        Assertions.assertEquals(solution, expect);
    }

    @Test
    public void 테스트케이스1(){
        start(new int[] {6, 10, 2}, "6210");
    }

    @Test
    public void 테스트케이스2(){
        start(new int[] {3, 30, 34, 5, 9}, "9534330");
    }

    @Test
    public void 테스트케이스3(){
        start(new int[] {1, 10, 100, 1000, 818, 81, 898, 89, 0, 0}, "8989881881110100100000");
    }

    @Test
    public void 테스트케이스4(){
        start(new int[] {12, 1213}, "121312");
    }
}
