package Level1.Level1_SplitString;

import org.junit.Assert;
import org.junit.Test;

class Solution {
    public int solution(String s) {
        int result = 0;

        while (s.length() > 1) {
            String x = s.substring(0, 1);
            String compare = s.substring(1);

            int same = 1;
            int diff = 0;
            for (int i = 0; i < compare.length(); i++) {
                String ch = String.valueOf(compare.charAt(i));
                if (x.equals(ch)) {
                    same += 1;
                } else {
                    diff += 1;
                }

                if (same == diff) {
                    break;
                }
            }

            s = s.substring(same + diff);
            result++;
        }

        if (s.length() != 0) {
            result++;
        }

        return result;
    }
}

public class Main {
    static void start(String s, int expect){
        int solution = new Solution().solution(s);

        StringBuilder result = new StringBuilder();
        result.append("## 테스트 케이스 ##").append("\n")
                .append("[Parameter -> String s]").append("\n")
                .append("-> ").append(s).append("\n\n")
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
        start("banana", 3);
    }

    @Test
    public void 테스트케이스2(){
        start("abracadabra", 6);
    }

    @Test
    public void 테스트케이스3(){
        start("aaabbaccccabba", 3);
    }
}

/*
정확성  테스트
테스트 1 〉	통과 (0.03ms, 73.7MB)
테스트 2 〉	통과 (6.85ms, 89.8MB)
테스트 3 〉	통과 (15.07ms, 87.2MB)
테스트 4 〉	통과 (0.03ms, 72.5MB)
테스트 5 〉	통과 (0.05ms, 67.5MB)
테스트 6 〉	통과 (0.03ms, 74.8MB)
테스트 7 〉	통과 (0.03ms, 73.6MB)
테스트 8 〉	통과 (0.03ms, 78.1MB)
테스트 9 〉	통과 (3.36ms, 77.4MB)
테스트 10 〉	통과 (25.12ms, 103MB)
테스트 11 〉	통과 (2.00ms, 73.6MB)
테스트 12 〉	통과 (8.46ms, 94.5MB)
테스트 13 〉	통과 (17.53ms, 91.1MB)
테스트 14 〉	통과 (23.54ms, 96.7MB)
테스트 15 〉	통과 (1.53ms, 77.3MB)
테스트 16 〉	통과 (16.47ms, 97.2MB)
테스트 17 〉	통과 (6.49ms, 86.7MB)
테스트 18 〉	통과 (16.78ms, 89.1MB)
테스트 19 〉	통과 (8.12ms, 93.9MB)
테스트 20 〉	통과 (40.31ms, 93.9MB)
테스트 21 〉	통과 (18.17ms, 96.4MB)
테스트 22 〉	통과 (12.01ms, 90.5MB)
테스트 23 〉	통과 (2.61ms, 78MB)
테스트 24 〉	통과 (33.53ms, 80.1MB)
테스트 25 〉	통과 (23.24ms, 95MB)
테스트 26 〉	통과 (25.64ms, 90.6MB)
테스트 27 〉	통과 (15.59ms, 97.9MB)
테스트 28 〉	통과 (7.60ms, 74.5MB)
테스트 29 〉	통과 (23.85ms, 98.5MB)
테스트 30 〉	통과 (8.93ms, 87.8MB)
테스트 31 〉	통과 (0.02ms, 78.1MB)
테스트 32 〉	통과 (0.05ms, 82.5MB)
테스트 33 〉	통과 (0.05ms, 78.4MB)
테스트 34 〉	통과 (0.04ms, 83MB)
테스트 35 〉	통과 (0.04ms, 74.4MB)
테스트 36 〉	통과 (0.04ms, 69.4MB)
테스트 37 〉	통과 (0.04ms, 71.9MB)
테스트 38 〉	통과 (0.03ms, 72.8MB)
테스트 39 〉	통과 (0.05ms, 81.7MB)
테스트 40 〉	통과 (0.09ms, 86.4MB)
테스트 41 〉	통과 (17.74ms, 86MB)
테스트 42 〉	통과 (11.68ms, 94.4MB)

채점 결과
정확성: 100.0
합계: 100.0 / 100.0
 */