package Level2.Level2_NightTacticalWalk;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

class Solution {
    static final Boolean WORKING_MARK = Boolean.TRUE; // 근무 시간 마킹

    public int solution(int distance, int[][] scope, int[][] times) {
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < scope.length; i++) {
            int[] monitorRange = scope[i]; // 감시 활성화 구간
            boolean[] schedule = getSpecificSoldierSchedule(distance, times[i]); // 경비병 근무 시간 정보

            for (int index = Math.min(monitorRange[0], monitorRange[1]) - 1; index < Math.max(monitorRange[0], monitorRange[1]); index++) {
                if (schedule[index] == WORKING_MARK) {
                    result = Math.min(result, index);
                    break;
                }
            }
        }

        return (result == Integer.MAX_VALUE) ? distance : result + 1;
    }

    private boolean[] getSpecificSoldierSchedule(int distance, int[] time) {
        boolean[] schedule = new boolean[distance];

        int value = 0;
        int working = time[0]; // 근무 시간
        int rest = time[1]; // 휴식 시간

        while (value < distance) {
            int reachValue = (value + working - 1 >= distance) ? distance - 1 : value + working - 1;

            for (int i = value; i <= reachValue; i++) {
                schedule[i] = WORKING_MARK;
            }

            value += working + rest;
        }

        return schedule;
    }
}

public class Main {
    static void start(int distance, int[][] scope, int[][] times, int expect){
        System.out.println("## 테스트 케이스 ##");
        System.out.println("<Distance>");
        System.out.println(distance + "\n");
        System.out.println("<Scope[][]>");
        System.out.println(Arrays.deepToString(scope) + "\n");
        System.out.println("<Times[][]>");
        System.out.println(Arrays.deepToString(times) + "\n");

        System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────────────");

        int result = new Solution().solution(distance, scope, times);
        System.out.println("\n<Result>");
        System.out.println(result + "\n");
        System.out.println("result(도출한 답) = " + result + " -> expect(실제 도출되어야 하는 답) = " + expect);
        Assert.assertEquals(result, expect);
    }

    @Test
    public void 테스트케이스1(){
        start(
                10,
                new int[][]{
                        {3, 4},
                        {5, 8}
                },
                new int[][]{
                        {2, 5},
                        {4, 3}
                },
                8
        );
    }

    @Test
    public void 테스트케이스2(){
        start(
                12,
                new int[][]{
                        {7, 8},
                        {4, 6},
                        {11, 10}
                },
                new int[][]{
                        {2, 2},
                        {2, 4},
                        {3, 3}
                },
                12
        );
    }
}

/*
정확성 테스트

테스트 1 〉	통과 (0.05ms, 76.6MB)
테스트 2 〉	통과 (4913.05ms, 318MB)
테스트 3 〉	통과 (1036.31ms, 310MB)
테스트 4 〉	통과 (59.59ms, 109MB)
테스트 5 〉	통과 (140.16ms, 156MB)
테스트 6 〉	통과 (127.53ms, 166MB)
테스트 7 〉	통과 (846.47ms, 312MB)
테스트 8 〉	통과 (1741.10ms, 306MB)
테스트 9 〉	통과 (4682.11ms, 320MB)
테스트 10 〉	통과 (145.70ms, 188MB)
테스트 11 〉	통과 (1844.11ms, 270MB)
테스트 12 〉	통과 (312.80ms, 273MB)
테스트 13 〉	통과 (5607.55ms, 307MB)
테스트 14 〉	통과 (4746.54ms, 328MB)

채점 결과
정확성: 100.0
합계: 100.0 / 100.0
 */