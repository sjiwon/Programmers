package Level2.Level2_CorrectParentheses;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

class Solution {
    boolean solution(String s) {
        // 괄호를 저장하는 스택
        Stack<Character> stack = new Stack<>();
        char[] c = s.toCharArray();

        for(char ch : c) {
            if(ch == '(') { // 여는 괄호면 스택에 넣기
                stack.push(ch);
            } else { // 닫는 괄호면
                if(stack.isEmpty()) { // 만약 스택이 비어있으면 여는 괄호가 없다는 의미
                    return false;
                } else {
                    stack.pop(); // pop
                }
            }
        }

        return stack.isEmpty(); // 모든 과정 진행 후 스택이 비어있으면 옳은 괄호
    }
}

public class Main {
    static void start(String s, boolean expect){
        boolean solution = new Solution().solution(s);

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
        Assertions.assertEquals(solution, expect);
    }

    @Test
    public void 테스트케이스1(){
        start("()()", true);
    }

    @Test
    public void 테스트케이스2(){
        start("(())()", true);
    }

    @Test
    public void 테스트케이스3(){
        start(")()(", false);
    }

    @Test
    public void 테스트케이스4(){
        start("(()(", false);
    }

}
