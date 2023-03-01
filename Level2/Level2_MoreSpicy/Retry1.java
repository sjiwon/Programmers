package Level2.Level2_MoreSpicy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution1 {
    public int solution(int[] scoville, int K) {
        // 음식을 넣는 우선순위 큐
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(long value : scoville) {
            pq.offer(value);
        }

        int count = 0;
        while(pq.size() > 1) { // pq 내부에 음식이 2개 이상 있는동안 계속 update
            if(pq.peek() >= K) { // 모두 k 이상이 되었을 경우
                break;
            }

            long first = pq.poll();
            long second = pq.poll();
            pq.offer(first + second * 2); // 섞기
            count++; // 섞은 횟수 증가
        }

        if(pq.peek() < K) {
            return -1;
        } else {
            return count;
        }
    }
}

public class Retry1 {
    static void start(int[] scoville, int K, int expect){
        int solution = new Solution1().solution(scoville, K);

        StringBuilder result = new StringBuilder();
        result.append("## 테스트 케이스 ##").append("\n")
                .append("[Parameter -> int[] scoville]").append("\n")
                .append("-> ").append(Arrays.toString(scoville)).append("\n\n")
                .append("[Parameter -> int K]").append("\n")
                .append("-> ").append(K).append("\n\n")
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
        start(new int[] {1, 2, 3, 9, 10, 12}, 7, 2);
    }
}
