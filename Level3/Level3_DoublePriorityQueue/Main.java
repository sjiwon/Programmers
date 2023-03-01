package Level3.Level3_DoublePriorityQueue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    final static String INSERT = "I";
    static PriorityQueue<Integer> tmp;

    public int[] solution(String[] operations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(String command : operations) {
            String[] split = command.split(" ");

            if(split[0].equals(INSERT)) { // INSERT
                pq.offer(Integer.parseInt(split[1]));
            } else { // DELETE
                if(pq.isEmpty()) { // 큐가 비어있는데 DELETE 연산이 들어오면 무시
                    continue;
                }

                if(Integer.parseInt(split[1]) < 0) { // 최솟값 삭제
                    pq = updateMin(pq);
                    pq.poll();
                } else { // 최댓값 삭제
                    pq = updateMax(pq);
                    pq.poll();
                }
            }
        }

        if(pq.isEmpty()) {
            return new int[]{0, 0};
        } else {
            int[] result = new int[2];
            pq = updateMax(pq);
            result[0] = pq.poll();
            pq = updateMin(pq);
            result[1] = pq.poll();
            return result;
        }
    }

    private PriorityQueue<Integer> updateMin(PriorityQueue<Integer> pq) {
        tmp = new PriorityQueue<>();
        while(!pq.isEmpty()) {
            tmp.offer(pq.poll());
        }
        return tmp;
    }

    private PriorityQueue<Integer> updateMax(PriorityQueue<Integer> pq) {
        tmp = new PriorityQueue<>(Collections.reverseOrder());
        while(!pq.isEmpty()) {
            tmp.offer(pq.poll());
        }
        return tmp;
    }
}

public class Main {
    static void start(String[] operations, int[] expect){
        int[] solution = new Solution().solution(operations);

        StringBuilder result = new StringBuilder();
        result.append("## 테스트 케이스 ##").append("\n")
                .append("[Parameter -> String[] operations]").append("\n")
                .append("-> ").append(Arrays.toString(operations)).append("\n\n")
                .append("[Result]").append("\n")
                .append("-> ").append(Arrays.toString(solution)).append("\n\n")
                .append("======================================\n")
                .append("예상 정답 = ").append(Arrays.toString(solution)).append("\n")
                .append("실제 정답 = ").append(Arrays.toString(expect));

        System.out.println(result);
        Assertions.assertArrayEquals(solution, expect);
    }

    @Test
    public void 테스트케이스1(){
        start(
                new String[] {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"},
                new int[] {0, 0}
        );
    }

    @Test
    public void 테스트케이스2(){
        start(
                new String[] {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"},
                new int[] {333, -45}
        );
    }
}
