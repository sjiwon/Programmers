package Level2.Level2_Printer;

/*
1. 일단 맨 앞 문서 꺼내기 (A)
2-1. 나머지 인쇄 대기 문서중에 중요도가 A보다 높은 문서가 있으면 A를 가장 마지막에 넣기
2-2. A의 중요도가 가장 높으면 A 인쇄
*/

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[] priorities, int location) {
        // PriorityQueue
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int value : priorities) {
            pq.offer(value);
        }

        int realLocation = 1;
        while(!pq.isEmpty()){
            for(int i=0; i<priorities.length; i++){
                if(priorities[i] == pq.peek()) { // 1. 값 동일
                    if(location == i) { // 2. 위치 동일
                        return realLocation;
                    } else {
                        pq.poll();
                        realLocation++;
                    }
                }
            }
        }

        return realLocation;
    }
}

public class Main {
    static void start(int[] priorities, int location, int expect){
        int solution = new Solution().solution(priorities, location);

        StringBuilder result = new StringBuilder();
        result.append("## 테스트 케이스 ##").append("\n")
                .append("[Parameter -> int[] priorities]").append("\n")
                .append("-> ").append(Arrays.toString(priorities)).append("\n\n")
                .append("[Parameter -> int location]").append("\n")
                .append("-> ").append(location).append("\n\n")
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
        start(new int[] {2, 1, 3, 2}, 2, 1);
    }

    @Test
    public void 테스트케이스2(){
        start(new int[] {1, 1, 9, 1, 1, 1}, 2, 1);
    }
}
