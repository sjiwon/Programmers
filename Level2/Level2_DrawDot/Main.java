package Level2.Level2_DrawDot;

import org.junit.Assert;
import org.junit.Test;

class Solution {
    public long solution(int k, int d) {
        long count = 0;
        for (int i = 0; i <= d / k; i++) {
            count += calculatePossibleYCount(i * k, k, d);
        }
        return count;
    }

    // x^2 + y^2 = d^2 -> y^2 = d^2 - x^2
    private int calculatePossibleYCount(int currentX, int k, int d) {
        int maxY = (int) (Math.sqrt(Math.pow(d, 2) - Math.pow(currentX, 2)));
        return (maxY / k) + 1;
    }
}

public class Main {
    static void start(int k, int d, long expect){
        long solution = new Solution().solution(k, d);

        StringBuilder result = new StringBuilder();
        result.append("## 테스트 케이스 ##").append("\n")
                .append("[Parameter -> int k]").append("\n")
                .append(k).append("\n\n")
                .append("[Parameter -> int d]").append("\n")
                .append(d).append("\n\n")
                .append("[Result]").append("\n")
                .append(solution).append("\n\n")
                .append("======================================\n")
                .append("예상 정답 = ").append(solution).append("\n")
                .append("실제 정답 = ").append(expect);

        System.out.println(result);
        Assert.assertEquals(solution, expect);
    }

    @Test
    public void 테스트케이스1(){
        start(2, 4, 6);
    }

    @Test
    public void 테스트케이스2(){
        start(1, 5, 26);
    }
}

/*
채점을 시작합니다.

정확성  테스트
테스트 1 〉	통과 (0.10ms, 78.1MB)
테스트 2 〉	통과 (0.07ms, 78.4MB)
테스트 3 〉	통과 (0.36ms, 84.4MB)
테스트 4 〉	통과 (0.32ms, 86.2MB)
테스트 5 〉	통과 (0.58ms, 73.3MB)
테스트 6 〉	통과 (0.41ms, 75.8MB)
테스트 7 〉	통과 (0.23ms, 72.2MB)
테스트 8 〉	통과 (1.90ms, 79.9MB)
테스트 9 〉	통과 (0.40ms, 75.4MB)
테스트 10 〉	통과 (0.63ms, 77.4MB)
테스트 11 〉	통과 (15.53ms, 83MB)
테스트 12 〉	통과 (0.10ms, 70.8MB)
테스트 13 〉	통과 (7.76ms, 82.7MB)
테스트 14 〉	통과 (6.64ms, 77.3MB)
테스트 15 〉	통과 (0.12ms, 77.1MB)
테스트 16 〉	통과 (0.10ms, 79.3MB)

채점 결과
정확성: 100.0
합계: 100.0 / 100.0
 */