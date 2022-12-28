package Level2.Level2_DefenseGame;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

// O(log n)
class Solution {
    public int solution(int n, int k, int[] enemy) {
        int left = 0;
        int right = enemy.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (canDefense(mid, n, k, enemy)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    private boolean canDefense(int mid, int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i <= mid; i++) {
            pq.offer(enemy[i]);
        }

        while (!pq.isEmpty()) {
            int fight = pq.poll();
            if (n < fight) { // 남은 병사로 처리 불가
                pq.offer(fight); // 현재 대결 대상 몬스터들 다시 pq에 집어넣기
                break;
            } else {
                n -= fight; // 싸우기
            }
        }

        // 방어권으로 커버 가능한지
        return k >= pq.size();
    }
}

public class Main {
    static void start(int n, int k, int[] enemy, int expect){
        int solution = new Solution().solution(n, k, enemy);

        StringBuilder result = new StringBuilder();
        result.append("## 테스트 케이스 ##").append("\n")
                .append("[Parameter -> int n]").append("\n")
                .append("-> ").append(n).append("\n\n")
                .append("[Parameter -> int k]").append("\n")
                .append("-> ").append(k).append("\n\n")
                .append("[Parameter -> int[] enemy]").append("\n")
                .append("-> ").append(Arrays.toString(enemy)).append("\n\n")
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
        start(7, 3, new int[]{4, 2, 4, 5, 3, 3, 1}, 5);
    }

    @Test
    public void 테스트케이스2(){
        start(2, 4, new int[]{3, 3, 3, 3}, 4);
    }
}
