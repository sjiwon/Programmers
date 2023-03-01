package Level2.Level2_Fatigue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class Solution {
    static boolean[] visited;
    static int answer = 0;

    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length]; // 던전 방문 여부
        dfs(0, k, dungeons);
        return answer;
    }

    private void dfs(int depth, int k, int[][] dungeons) {
        for(int i=0; i<dungeons.length; i++) {
            if(!visited[i]) { // 아직 방문하지 않은 던전
                if(k >= dungeons[i][0]) { // 방문할 수 있는 피로도라면
                    visited[i] = true; // 방문 O
                    dfs(depth + 1, k - dungeons[i][1], dungeons);
                    visited[i] = false; // rollback
                }
            }
        }

        answer = Math.max(answer, depth);
    }
}

public class Main {
    static void start(int k, int[][] dungeons, int expect){
        int solution = new Solution().solution(k, dungeons);

        StringBuilder result = new StringBuilder();
        result.append("## 테스트 케이스 ##").append("\n")
                .append("[Parameter -> int k]").append("\n")
                .append("-> ").append(k).append("\n\n")
                .append("[Parameter -> int[][] dungeons]").append("\n")
                .append("-> ").append(Arrays.deepToString(dungeons)).append("\n\n")
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
        start(80, new int[][] {{80, 20}, {50, 40}, {30, 10}}, 3);
    }
}
