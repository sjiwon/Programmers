package Level1.Level1_HallOfFame;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int[] solution(int k, int[] score) {
        int day = score.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] result = new int[day];

        for (int i = 0; i < day; i++) {
            if (i < k) {
                pq.offer(score[i]);
            } else { // k일 이후부터는 탈락자 존재
                if (!pq.isEmpty() && score[i] > pq.peek()) {
                    pq.poll();
                    pq.offer(score[i]);
                }
            }
            result[i] = pq.peek();
        }

        return result;
    }
}

public class Main {
    static void start(int k, int[] score, int[] expect) {
        int[] solution = new Solution().solution(k, score);

        StringBuilder result = new StringBuilder();
        result.append("## 테스트 케이스 ##").append("\n")
                .append("[Parameter -> int k]").append("\n")
                .append("-> ").append(k).append("\n\n")
                .append("[Parameter -> int[] score]").append("\n")
                .append("-> ").append(Arrays.toString(score)).append("\n\n")
                .append("[Result]").append("\n")
                .append("-> ").append(Arrays.toString(solution)).append("\n\n")
                .append("======================================\n")
                .append("예상 정답 = ").append(Arrays.toString(solution)).append("\n")
                .append("실제 정답 = ").append(Arrays.toString(expect));

        System.out.println(result);
        Assert.assertArrayEquals(solution, expect);
    }

    @Test
    public void 테스트케이스1() {
        start(
                3,
                new int[]{10, 100, 20, 150, 1, 100, 200},
                new int[]{10, 10, 10, 20, 20, 100, 100}
        );
    }

    @Test
    public void 테스트케이스2() {
        start(
                4,
                new int[]{0, 300, 40, 300, 20, 70, 150, 50, 500, 1000},
                new int[]{0, 0, 0, 0, 20, 40, 70, 70, 150, 300}
        );
    }
}

/*
정확성  테스트
테스트 1 〉	통과 (0.40ms, 70.4MB)
테스트 2 〉	통과 (0.45ms, 74.6MB)
테스트 3 〉	통과 (0.49ms, 74MB)
테스트 4 〉	통과 (0.37ms, 72.4MB)
테스트 5 〉	통과 (0.45ms, 75.9MB)
테스트 6 〉	통과 (0.31ms, 76.9MB)
테스트 7 〉	통과 (0.48ms, 75.8MB)
테스트 8 〉	통과 (0.37ms, 84.2MB)
테스트 9 〉	통과 (0.44ms, 70.4MB)
테스트 10 〉	통과 (0.33ms, 73.2MB)
테스트 11 〉	통과 (0.45ms, 76.7MB)
테스트 12 〉	통과 (0.89ms, 68.8MB)
테스트 13 〉	통과 (1.14ms, 72.4MB)
테스트 14 〉	통과 (1.20ms, 78.4MB)
테스트 15 〉	통과 (1.46ms, 75MB)
테스트 16 〉	통과 (1.11ms, 79.4MB)
테스트 17 〉	통과 (1.40ms, 83.8MB)
테스트 18 〉	통과 (1.08ms, 78.9MB)
테스트 19 〉	통과 (0.94ms, 77.2MB)
테스트 20 〉	통과 (0.65ms, 76.7MB)
테스트 21 〉	통과 (1.04ms, 80.7MB)
테스트 22 〉	통과 (0.70ms, 82.8MB)
테스트 23 〉	통과 (0.78ms, 74.8MB)
테스트 24 〉	통과 (0.77ms, 76.1MB)
테스트 25 〉	통과 (0.81ms, 80.5MB)
테스트 26 〉	통과 (0.31ms, 73.7MB)

채점 결과
정확성: 100.0
합계: 100.0 / 100.0
 */