package Level2.Level2_VowelDictionary;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class Solution {
    static List<String> list; // 단어 조합 모든 경우의 수
    static char[] ch;

    public int solution(String word) {
        list = new ArrayList<>();
        ch = new char[] {'A', 'E', 'I', 'O', 'U'};

        // 모든 경우의 수 적용 backtracking
        backtracking("", 0);

        int result = 1;
        for(String value : list) {
            if(word.equals(value)) {
                return result;
            } else {
                result++;
            }
        }
        return -1;
    }

    private void backtracking(String str, int index) {
        if(str != null && !str.equals("")) {
            list.add(str);
        }

        if(index == 5) {
            return;
        }

        for(int i=0; i<ch.length; i++) {
            backtracking(str + ch[i], index + 1);;
        }
    }
}

public class Main {
    static void start(String word, int expect){
        int solution = new Solution().solution(word);

        StringBuilder result = new StringBuilder();
        result.append("## 테스트 케이스 ##").append("\n")
                .append("[Parameter -> String word]").append("\n")
                .append("-> ").append(word).append("\n\n")
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
        start("AAAAE", 6);
    }

    @Test
    public void 테스트케이스2(){
        start("AAAE", 10);
    }

    @Test
    public void 테스트케이스3(){
        start("I", 1563);
    }

    @Test
    public void 테스트케이스4(){
        start("EIO", 1189);
    }


}
