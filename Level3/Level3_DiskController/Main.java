package Level3.Level3_DiskController;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        // 1. 요청 시간 기준 오름차순 정렬
        Arrays.sort(jobs, (o1, o2) -> {
            if(o1[0] < o2[0]) {
                return -1;
            } else if(o1[0] > o2[0]) {
                return 1;
            } else {
                return Integer.compare(o1[1], o2[1]);
            }
        });

        // 2. 처리 시간 기준 오름차순 정렬 우선순위 큐
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return Integer.compare(o1[1], o2[1]);
        });

        pq.offer(jobs[0]); // 가장 처음 들어온 job 추가
        int currentTime = jobs[0][0]; // 현재 작업 이전 작업이 종료된 시각
        int workTime = 0; // 작업별로 요청 -> 종료 시각 누적
        int index = 1; // job index

        while(!pq.isEmpty()) {
            int[] job = pq.poll();
            currentTime += job[1];
            workTime += currentTime - job[0];

            // job이 실행중인데 들어오는 새로운 job이 있을 경우
            while(index < jobs.length && jobs[index][0] <= currentTime) {
                pq.offer(jobs[index++]);
            }

            // currentTime보다 Waiting Queue에 있는 job의 start가 더 늦은 상황 = Ready Queue 비어있는
             if(index < jobs.length && pq.isEmpty()) {
                 currentTime = jobs[index][0]; // 현재 시각을 강제로 업데이트
                 pq.offer(jobs[index++]);
             }
        }

        return workTime / jobs.length;
    }
}

public class Main {
    static void start(int[][] jobs, int expect){
        int solution = new Solution().solution(jobs);

        StringBuilder result = new StringBuilder();
        result.append("## 테스트 케이스 ##").append("\n")
                .append("[Parameter -> int[][] jobs]").append("\n")
                .append("-> ").append(Arrays.deepToString(jobs)).append("\n\n")
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
        start(new int[][] {{0, 3}, {1, 9}, {2, 6}}, 9);
    }
}
