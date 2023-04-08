package Level3.Level3_DoublePriorityQueue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

class Solution1 {
    static final String INSERT = "I";
    static PriorityQueue<Integer> tmp;

    public int[] solution(String[] operations) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (String operation : operations) {
            String[] split = operation.split(" ");
            String command = split[0];
            int number = Integer.parseInt(split[1]);

            if (command.equals(INSERT)) {
                queue.offer(number);
            } else {
                if (queue.isEmpty()) { // 삭제 명령어 -> 큐 비어있으면 무시
                    continue;
                }

                if (number < 0) { // 최솟값 삭제
                    queue = makeAsc(queue);
                    queue.poll();
                } else { // 최댓값 삭제
                    queue = makeDesc(queue);
                    queue.poll();
                }
            }
        }

        if (queue.isEmpty()) {
            return new int[]{0, 0};
        } else {
            queue = makeDesc(queue);
            int max = queue.peek();

            queue = makeAsc(queue);
            int min = queue.peek();

            return new int[]{max, min};
        }
    }

    private PriorityQueue<Integer> makeAsc(PriorityQueue<Integer> queue) {
        tmp = new PriorityQueue<>();
        while (!queue.isEmpty()) {
            tmp.offer(queue.poll());
        }
        return tmp;
    }

    private PriorityQueue<Integer> makeDesc(PriorityQueue<Integer> queue) {
        tmp = new PriorityQueue<>(Collections.reverseOrder());
        while (!queue.isEmpty()) {
            tmp.offer(queue.poll());
        }
        return tmp;
    }
}

public class Retry1 {
    static void start(String[] operations, int[] expect){
        int[] solution = new Solution1().solution(operations);

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
