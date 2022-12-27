package Level1.Level1_SmallSubstring;

import org.junit.Assert;
import org.junit.Test;

class Solution {
    public int solution(String t, String p) {
        int result = 0;
        for (int i = 0; i <= t.length() - p.length(); i++) {
            String compare = t.substring(i, i + p.length());
            if (isConditionSatisfied(p, compare)) {
                result++;
            }
        }
        return result;
    }

    private boolean isConditionSatisfied(String p, String compare) {
        return Long.parseLong(p) >= Long.parseLong(compare);
    }
}

public class Main {
    static void start(String t, String p, int expect) {
        int solution = new Solution().solution(t, p);

        StringBuilder result = new StringBuilder();
        result.append("## 테스트 케이스 ##").append("\n")
                .append("[Parameter -> String t]").append("\n")
                .append("-> ").append(t).append("\n\n")
                .append("[Parameter -> String p]").append("\n")
                .append("-> ").append(p).append("\n\n")
                .append("[Result]").append("\n")
                .append("-> ").append(solution).append("\n\n")
                .append("======================================\n")
                .append("예상 정답 = ").append(solution).append("\n")
                .append("실제 정답 = ").append(expect);

        System.out.println(result);
        Assert.assertEquals(solution, expect);
    }

    @Test
    public void 테스트케이스1() {
        start("3141592", "271", 2);
    }

    @Test
    public void 테스트케이스2() {
        start("500220839878", "7", 8);
    }

    @Test
    public void 테스트케이스3() {
        start("10203", "15", 3);
    }
}

/*
정확성  테스트
테스트 1 〉	통과 (4.04ms, 70.6MB)
테스트 2 〉	통과 (4.97ms, 75.4MB)
테스트 3 〉	통과 (5.12ms, 81.5MB)
테스트 4 〉	통과 (3.19ms, 77MB)
테스트 5 〉	통과 (2.75ms, 72.4MB)
테스트 6 〉	통과 (3.52ms, 73.9MB)
테스트 7 〉	통과 (7.39ms, 79.4MB)
테스트 8 〉	통과 (3.01ms, 79.7MB)
테스트 9 〉	통과 (2.40ms, 73.5MB)
테스트 10 〉	통과 (0.42ms, 75.8MB)
테스트 11 〉	통과 (4.06ms, 73.4MB)
테스트 12 〉	통과 (6.53ms, 73.4MB)
테스트 13 〉	통과 (6.48ms, 74.5MB)
테스트 14 〉	통과 (3.91ms, 66.5MB)
테스트 15 〉	통과 (3.36ms, 76MB)
테스트 16 〉	통과 (3.40ms, 81.6MB)
테스트 17 〉	통과 (6.33ms, 72.9MB)
테스트 18 〉	통과 (3.87ms, 77.8MB)
테스트 19 〉	통과 (1.86ms, 73.6MB)
테스트 20 〉	통과 (1.77ms, 77.4MB)
테스트 21 〉	통과 (0.16ms, 72.2MB)
테스트 22 〉	통과 (2.26ms, 75.7MB)
테스트 23 〉	통과 (5.33ms, 75.7MB)
테스트 24 〉	통과 (0.22ms, 76.2MB)
테스트 25 〉	통과 (0.51ms, 72.1MB)
테스트 26 〉	통과 (0.32ms, 76.5MB)
테스트 27 〉	통과 (0.31ms, 72.2MB)
테스트 28 〉	통과 (0.22ms, 73.7MB)
테스트 29 〉	통과 (0.23ms, 81.8MB)
테스트 30 〉	통과 (2.06ms, 76.6MB)
테스트 31 〉	통과 (0.07ms, 73.5MB)
테스트 32 〉	통과 (0.06ms, 75.5MB)
테스트 33 〉	통과 (0.06ms, 72.6MB)
테스트 34 〉	통과 (0.09ms, 73.2MB)
테스트 35 〉	통과 (0.11ms, 73.7MB)
테스트 36 〉	통과 (0.17ms, 71.8MB)
테스트 37 〉	통과 (0.07ms, 73.5MB)
테스트 38 〉	통과 (0.11ms, 77.6MB)

채점 결과
정확성: 100.0
합계: 100.0 / 100.0
 */