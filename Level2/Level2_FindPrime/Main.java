package Level2.Level2_FindPrime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

class Solution {
    static Set<Integer> set;
    static char[] ch;
    static boolean[] visited;

    public int solution(String numbers) {
        // 문자 하나하나 저장
        set = new HashSet<>();
        ch = new char[numbers.length()];
        visited = new boolean[numbers.length()];
        for(int i=0; i<numbers.length(); i++){
            ch[i] = numbers.charAt(i);
        }

        // BackTracking으로 모든 경우의 수 적용
        backtracking("", 0);
        return set.size();
    }

    // str = backtracking 과정에서 만들어지는 문자열
    // index = char[] ch에서 몇번째 문자 선택하는지
    private void backtracking(String str, int index) {
        if(str != null && !str.equals("")) { // 문자 만들어졌으면
            int strToNum = Integer.parseInt(str);
            if(isPrime(strToNum)) {
                set.add(strToNum);
            }
        }

        if(index == ch.length) { // 모든 문자 탐색했으면
            return;
        }

        for(int i=0; i<ch.length; i++){
            if(!visited[i]) {
                visited[i] = true;
                backtracking(str + ch[i], index + 1);
                visited[i] = false;
            }
        }
    }

    private boolean isPrime(int value) {
        if(value < 2) return false;

        for(int i=2; i<value; i++) {
            if(value % i == 0) {
                return false;
            }
        }
        return true;
    }
}

public class Main {
    static void start(String numbers, int expect){
        int solution = new Solution().solution(numbers);

        StringBuilder result = new StringBuilder();
        result.append("## 테스트 케이스 ##").append("\n")
                .append("[Parameter -> String numbers]").append("\n")
                .append("-> ").append(numbers).append("\n\n")
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
        start("17", 3);
    }

    @Test
    public void 테스트케이스2(){
        start("011", 2);
    }
}
