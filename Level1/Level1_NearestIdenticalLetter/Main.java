package Level1.Level1_NearestIdenticalLetter;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String s) {
        int[] result = new int[s.length()];
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            result[i] = map.containsKey(ch) ? i - map.get(ch) : -1;
            map.put(ch, i);
        }

        return result;
    }
}

public class Main {
    static void start(String s, int[] expect){
        int[] solution = new Solution().solution(s);

        StringBuilder result = new StringBuilder();
        result.append("## 테스트 케이스 ##").append("\n")
                .append("[Parameter -> String s]").append("\n")
                .append("-> ").append(s).append("\n\n")
                .append("[Result]").append("\n")
                .append("-> ").append(Arrays.toString(solution)).append("\n\n")
                .append("======================================\n")
                .append("예상 정답 = ").append(Arrays.toString(solution)).append("\n")
                .append("실제 정답 = ").append(Arrays.toString(expect));

        System.out.println(result);
        Assert.assertArrayEquals(solution, expect);
    }

    @Test
    public void 테스트케이스1(){
        start("banana", new int[]{-1, -1, -1, 2, 2, 2});
    }

    @Test
    public void 테스트케이스2(){
        start("foobar", new int[]{-1, -1, 1, -1, -1, -1});
    }

    @Test
    public void 테스트케이스3(){
        start("ss", new int[]{-1, 1});
    }

    @Test
    public void 테스트케이스4(){
        start("sss", new int[]{-1, 1, 1});
    }

    @Test
    public void 테스트케이스5(){
        start("ssss", new int[]{-1, 1, 1, 1});
    }
}

/*
정확성  테스트
테스트 1 〉	통과 (0.14ms, 72.8MB)
테스트 2 〉	통과 (0.24ms, 75.5MB)
테스트 3 〉	통과 (0.34ms, 68.2MB)
테스트 4 〉	통과 (0.69ms, 77.6MB)
테스트 5 〉	통과 (4.85ms, 76.3MB)
테스트 6 〉	통과 (2.37ms, 77.8MB)
테스트 7 〉	통과 (3.18ms, 89.3MB)
테스트 8 〉	통과 (1.33ms, 81MB)
테스트 9 〉	통과 (3.02ms, 80.8MB)
테스트 10 〉	통과 (1.05ms, 72.6MB)
테스트 11 〉	통과 (3.21ms, 78.1MB)
테스트 12 〉	통과 (0.18ms, 75.8MB)
테스트 13 〉	통과 (0.12ms, 73.9MB)
테스트 14 〉	통과 (0.67ms, 85.1MB)
테스트 15 〉	통과 (0.11ms, 71.9MB)
테스트 16 〉	통과 (0.13ms, 73.1MB)
테스트 17 〉	통과 (0.16ms, 71.8MB)
테스트 18 〉	통과 (0.82ms, 78.9MB)
테스트 19 〉	통과 (1.03ms, 87.6MB)
테스트 20 〉	통과 (0.45ms, 72.9MB)
테스트 21 〉	통과 (0.18ms, 78.6MB)
테스트 22 〉	통과 (2.31ms, 68.8MB)
테스트 23 〉	통과 (1.09ms, 74.8MB)
테스트 24 〉	통과 (0.60ms, 76.6MB)
테스트 25 〉	통과 (0.60ms, 73.4MB)
테스트 26 〉	통과 (0.38ms, 77MB)
테스트 27 〉	통과 (0.85ms, 76MB)
테스트 28 〉	통과 (0.68ms, 76MB)
테스트 29 〉	통과 (0.14ms, 75.6MB)
테스트 30 〉	통과 (3.56ms, 81.4MB)

채점 결과
정확성: 100.0
합계: 100.0 / 100.0
 */