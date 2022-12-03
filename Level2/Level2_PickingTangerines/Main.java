package Level2.Level2_PickingTangerines;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> tangerineMap = new HashMap<>();
        for (int size : tangerine) {
            tangerineMap.put(size, tangerineMap.containsKey(size) ? tangerineMap.get(size) + 1 : 1);
        }

        List<Integer> tangerineKeyList = new ArrayList<>(tangerineMap.keySet());
        tangerineKeyList.sort((o1, o2) -> Integer.compare(tangerineMap.get(o2), tangerineMap.get(o1)));

        int count = 0;
        for (Integer size : tangerineKeyList) {
            Integer value = tangerineMap.get(size);
            count++; // 종류 추가
            if (value >= k) {
                break;
            } else {
                k -= value;
            }
        }
        return count;
    }
}

public class Main {
    static void start(int k, int[] tangerine, int expect){
        int solution = new Solution().solution(k, tangerine);

        StringBuilder result = new StringBuilder();
        result.append("## 테스트 케이스 ##").append("\n")
                .append("[Parameter -> int k]").append("\n")
                .append("-> ").append(k).append("\n\n")
                .append("[Parameter -> int[] tangerine]").append("\n")
                .append("-> ").append(Arrays.toString(tangerine)).append("\n\n")
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
        start(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3}, 3);
    }

    @Test
    public void 테스트케이스2(){
        start(4, new int[]{1, 3, 2, 5, 4, 5, 2, 3}, 2);
    }

    @Test
    public void 테스트케이스3(){
        start(2, new int[]{1, 1, 1, 1, 2, 2, 2, 3}, 1);
    }
}

/*
채점을 시작합니다.

정확성  테스트
테스트 1 〉	통과 (37.66ms, 91.9MB)
테스트 2 〉	통과 (41.02ms, 84.6MB)
테스트 3 〉	통과 (42.61ms, 84.3MB)
테스트 4 〉	통과 (34.23ms, 91.7MB)
테스트 5 〉	통과 (26.34ms, 95.1MB)
테스트 6 〉	통과 (25.10ms, 80.9MB)
테스트 7 〉	통과 (25.11ms, 90.9MB)
테스트 8 〉	통과 (28.59ms, 96.2MB)
테스트 9 〉	통과 (25.62ms, 94.4MB)
테스트 10 〉	통과 (35.02ms, 97.4MB)
테스트 11 〉	통과 (1.07ms, 71.7MB)
테스트 12 〉	통과 (0.67ms, 76.3MB)
테스트 13 〉	통과 (0.85ms, 74MB)
테스트 14 〉	통과 (0.73ms, 71.5MB)
테스트 15 〉	통과 (0.88ms, 75.9MB)
테스트 16 〉	통과 (0.88ms, 75.4MB)
테스트 17 〉	통과 (0.82ms, 77MB)
테스트 18 〉	통과 (0.88ms, 82.4MB)
테스트 19 〉	통과 (0.75ms, 73.2MB)
테스트 20 〉	통과 (0.87ms, 77.4MB)
테스트 21 〉	통과 (1.77ms, 79.1MB)
테스트 22 〉	통과 (1.90ms, 75.1MB)
테스트 23 〉	통과 (3.31ms, 88.5MB)
테스트 24 〉	통과 (3.00ms, 76MB)
테스트 25 〉	통과 (19.97ms, 84.4MB)
테스트 26 〉	통과 (17.37ms, 84.3MB)
테스트 27 〉	통과 (80.87ms, 102MB)
테스트 28 〉	통과 (56.98ms, 103MB)
테스트 29 〉	통과 (78.26ms, 96.8MB)
테스트 30 〉	통과 (60.66ms, 102MB)
테스트 31 〉	통과 (23.43ms, 86.3MB)
테스트 32 〉	통과 (28.37ms, 87.5MB)
테스트 33 〉	통과 (64.29ms, 107MB)
테스트 34 〉	통과 (70.67ms, 91.1MB)

채점 결과
정확성: 100.0
합계: 100.0 / 100.0
 */