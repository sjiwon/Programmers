package Level2.Level2_MakeTwoQueueSumEqual;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Long> firstQueue = new LinkedList<>();
        Queue<Long> secondQueue = new LinkedList<>();

        long sum1 = 0;
        for (int num : queue1) {
            sum1 += num;
            firstQueue.offer((long) num);
        }

        long sum2 = 0;
        for (int num : queue2) {
            sum2 += num;
            secondQueue.offer((long) num);
        }

        if ((sum1 + sum2) % 2 != 0) { // 동일 합을 만들 수 없는 경우
            return -1;
        }

        int count = 0;
        while (sum1 != sum2) {
            count++;

            if (sum1 > sum2) { // firstQueue합이 더 클 경우 poll하고 secondQueue에 넣어주기
                Long pollNum = firstQueue.poll();

                sum1 -= pollNum;
                sum2 += pollNum;
                secondQueue.offer(pollNum);
            } else { // secondQueue합이 더 클 경우 poll하고 firstQueue에 넣어주기
                Long pollNum = secondQueue.poll();

                sum1 += pollNum;
                sum2 -= pollNum;
                firstQueue.offer(pollNum);
            }

            if (count > (queue1.length + queue2.length) * 2) { // 두 Queue를 번갈아 가면서 전부 시도했는데 합이 동일하지 않을 경우
                return -1;
            }
        }

        return count;
    }
}

public class Main {
    static void start(int[] queue1, int[] queue2, int expect){
        System.out.println("## 테스트 케이스 ##");
        System.out.println("<Queue 1>");
        System.out.println(Arrays.toString(queue1) + "\n");
        System.out.println("<Queue 2>");
        System.out.println(Arrays.toString(queue2) + "\n");

        int solution = new Solution().solution(queue1, queue2);
        System.out.println("\n<Result>");
        System.out.println(solution + "\n");
        System.out.println("expect(도출한 답) = " + solution + " -> actual(실제 도출되어야 하는 답) = " + expect);
        Assert.assertEquals(solution, expect);
    }

    @Test
    public void 테스트케이스1(){
        start(
                new int[]{3, 2, 7, 2},
                new int[]{4, 6, 5, 1},
                2
        );
    }

    @Test
    public void 테스트케이스2(){
        start(
                new int[]{1, 2, 1, 2},
                new int[]{1, 10, 1, 2},
                7
        );
    }

    @Test
    public void 테스트케이스3(){
        start(
                new int[]{1, 1},
                new int[]{1, 5},
                -1
        );
    }
}
