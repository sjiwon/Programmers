package Level2.Level2_TableHashFunction;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        Arrays.sort(data, (o1, o2) -> {
            if (o1[col - 1] < o2[col - 1]) {
                return -1;
            } else if (o1[col - 1] > o2[col - 1]) {
                return 1;
            } else {
                return Integer.compare(o2[0], o1[0]);
            }
        });

        int answer = 0;
        for (int index = row_begin; index <= row_end; index++) {
            int[] subData = data[index - 1];
            int sum = 0;
            for (int value : subData) {
                sum += value % index;
            }

            answer = answer ^ sum;
        }

        return answer;
    }
}

public class Main {
    static void start(int[][] data, int col, int row_begin, int row_end, int expect){
        int solution = new Solution().solution(data, col, row_begin, row_end);

        StringBuilder result = new StringBuilder();
        result.append("## 테스트 케이스 ##").append("\n")
                .append("[Parameter -> int[][] data]").append("\n")
                .append("-> ").append(Arrays.deepToString(data)).append("\n\n")
                .append("[Parameter -> int col]").append("\n")
                .append("-> ").append(col).append("\n\n")
                .append("[Parameter -> int row_begin]").append("\n")
                .append("-> ").append(row_begin).append("\n\n")
                .append("[Parameter -> int row_end]").append("\n")
                .append("-> ").append(row_end).append("\n\n")
                .append("[Result]").append("\n")
                .append("-> ").append(solution).append("\n\n")
                .append("======================================\n")
                .append("예상 정답 = ").append(solution).append("\n")
                .append("실제 정답 = ").append(expect);

        System.out.println(result);
        Assert.assertEquals(solution, expect);
    }

    @Test
    public void 테스트케이스1(){
        start(
                new int[][]{
                        {2, 2, 6},
                        {1, 5, 10},
                        {4, 2, 9},
                        {3, 8, 3}
                },
                2, 2, 3, 4
        );
    }
}

/*
정확성  테스트
테스트 1 〉	통과 (0.87ms, 79.1MB)
테스트 2 〉	통과 (0.92ms, 77.9MB)
테스트 3 〉	통과 (1.14ms, 74.3MB)
테스트 4 〉	통과 (1.19ms, 88.9MB)
테스트 5 〉	통과 (1.89ms, 94.9MB)
테스트 6 〉	통과 (10.46ms, 149MB)
테스트 7 〉	통과 (9.04ms, 131MB)
테스트 8 〉	통과 (9.59ms, 141MB)
테스트 9 〉	통과 (11.25ms, 132MB)
테스트 10 〉	통과 (11.78ms, 137MB)
테스트 11 〉	통과 (0.96ms, 74.2MB)

채점 결과
정확성: 100.0
합계: 100.0 / 100.0
 */