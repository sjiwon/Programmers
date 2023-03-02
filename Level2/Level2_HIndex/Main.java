package Level2.Level2_HIndex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int n = citations.length;
        Arrays.sort(citations);

        int result = 0;
        for(int i=0; i<n; i++) {
            int h = n - i; // 현재 논문 ~> 남은 논문까지 개수
            if(citations[i] >= h) { // h편 이상 인용된 논문 index 찾았으면
                result = h;
                break;
            }
        }
        return result;
    }
}

public class Main {
    static void start(int[] citations, int expect){
        int solution = new Solution().solution(citations);

        StringBuilder result = new StringBuilder();
        result.append("## 테스트 케이스 ##").append("\n")
                .append("[Parameter -> int[] citations]").append("\n")
                .append("-> ").append(Arrays.toString(citations)).append("\n\n")
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
        start(new int[] {3, 0, 6, 1, 5}, 3);
    }
}
