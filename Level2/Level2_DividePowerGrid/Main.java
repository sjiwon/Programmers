package Level2.Level2_DividePowerGrid;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static int[][] graph; // 그래프
    final static int CONNECT = 1;
    final static int NON_CONNECT = 0;
    static Queue<Integer> queue;
    static boolean[] visited;

    public int solution(int n, int[][] wires) {
        int result = n;
        graph = new int[n][n];

        for(int i=0; i<wires.length; i++){
            int a = wires[i][0] - 1;
            int b = wires[i][1] - 1;

            graph[a][b] = graph[b][a] = CONNECT; // 연결
        }

        for(int i=0; i<wires.length; i++){
            int a = wires[i][0] - 1;
            int b = wires[i][1] - 1;

            // (a, b) = (b, a) 전선 끊어보기
            graph[a][b] = graph[b][a] = NON_CONNECT;

            // 끊은채로 bfs
            result = Math.min(result, bfs(n, a));

            // 다시 연결
            graph[a][b] = graph[b][a] = CONNECT;
        }

        return result;
    }

    private int bfs(int n, int start) {
        queue = new LinkedList<>();
        visited = new boolean[graph.length];
        queue.offer(start);
        visited[start] = true;

        int count = 1; // 연결된 송전탑 개수

        while(!queue.isEmpty()) {
            int point = queue.poll();

            for(int i=0; i<graph.length; i++) { // point와 연결된 점들
                if(graph[point][i] == CONNECT && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                    count++;
                }
            }
        }

        return Math.abs(n - 2 * count);
    }
}

public class Main {
    static void start(int n, int[][] wires, int expect){
        int solution = new Solution().solution(n, wires);

        StringBuilder result = new StringBuilder();
        result.append("## 테스트 케이스 ##").append("\n")
                .append("[Parameter -> int n]").append("\n")
                .append("-> ").append(n).append("\n\n")
                .append("[Parameter -> int[][] wires]").append("\n")
                .append("-> ").append(Arrays.deepToString(wires)).append("\n\n")
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
        start(9, new int[][] {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}}, 3);
    }

    @Test
    public void 테스트케이스2(){
        start(4, new int[][] {{1, 2}, {2, 3}, {3, 4}}, 0);
    }

    @Test
    public void 테스트케이스3(){
        start(7, new int[][] {{1, 2}, {2, 7}, {3, 7}, {3, 4}, {4, 5}, {6, 7}}, 1);
    }
}
