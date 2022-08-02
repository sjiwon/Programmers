package Level2.Level2_ParenthesisConversion;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

class Solution {
    public String solution(String p) {
        return recursionString(p);
    }

    static String recursionString(String p){
        if(p.length() == 0){
            return ""; // [1]
        }

        String[] splitP = getSplitP(p); // [2]
        if(isCorrectString(splitP[0])){ // [3]
            return splitP[0] + recursionString(splitP[1]); // 3-1
        } else { // [4]
            return "(" // 4-1
                    + recursionString(splitP[1]) + // 4-2
                    ")" // 4-3
                    + getReverseParenthesis(splitP[0].substring(1, splitP[0].length() - 1)); // 4-4
        }
    }

    static String[] getSplitP(String p){
        // 2단계 - 문자열 p를 u/v로 분리 (u=균형잡힌 괄호 문자열, v=빈 문자열 가능)
        StringBuilder u = new StringBuilder();
        StringBuilder v = new StringBuilder();

        int leftCount = 0; // "("
        int rightCount = 0; // ")"

        int index = 0;
        for(char c : p.toCharArray()){
            if(c == '('){
                index++;
                leftCount++;
                u.append(c);
            } else {
                index++;
                rightCount++;
                u.append(c);
            }

            if(leftCount == rightCount){
                break;
            }
        }

        v.append(p.substring(index));

        return new String[]{u.toString(), v.toString()};
    }

    static boolean isCorrectString(String p){
        Stack<Character> stack = new Stack<>();

        for(char c : p.toCharArray()){
            if(c == '('){
                stack.push(c);
            } else{
                if(stack.isEmpty()){
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    static String getReverseParenthesis(String s){
        /*
        단순히 sb.reverse()를 통해서 문자열 역순으로 하는거랑 괄호 하나하나 방향 뒤집는거랑 결과가 다름
        -> 괄호 하나하나 방향 뒤집기
         */
        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray()){
            if(c == '('){
                sb.append(")");
            } else{
                sb.append("(");
            }
        }

        return sb.toString();
    }
}

public class Main {
    static void start(String p, String expect){
        System.out.println("## 테스트 케이스 ##");
        System.out.println("<주어진괄호 p>");
        System.out.println(p);

        String solution = new Solution().solution(p);
        System.out.println("\n<Result>");
        System.out.println(solution + "\n");
        System.out.println("expect(도출한 답) = " + solution + " -> actual(실제 도출되어야 하는 답) = " + expect);
        Assert.assertEquals(solution, expect);
    }

    @Test
    public void 테스트케이스1(){
        start("(()())()", "(()())()");
    }

    @Test
    public void 테스트케이스2(){
        start(")(", "()");
    }

    @Test
    public void 테스트케이스3(){
        start("()))((()", "()(())()");
    }

    // "))))(((("
    @Test
    public void 테스트케이스4(){
        start("))))((((", "()((()))");
    }
}

/*
테스트 1 〉	통과 (1.31ms, 76.4MB)
테스트 2 〉	통과 (8.30ms, 72.5MB)
테스트 3 〉	통과 (1.34ms, 77.1MB)
테스트 4 〉	통과 (9.60ms, 86.3MB)
테스트 5 〉	통과 (1.25ms, 75.4MB)
테스트 6 〉	통과 (8.42ms, 73.1MB)
테스트 7 〉	통과 (8.55ms, 78.1MB)
테스트 8 〉	통과 (1.27ms, 74.3MB)
테스트 9 〉	통과 (8.01ms, 72.9MB)
테스트 10 〉	통과 (8.64ms, 77.7MB)
테스트 11 〉	통과 (8.51ms, 86.8MB)
테스트 12 〉	통과 (9.76ms, 74.9MB)
테스트 13 〉	통과 (8.08ms, 78.3MB)
테스트 14 〉	통과 (8.36ms, 78.1MB)
테스트 15 〉	통과 (9.53ms, 80.6MB)
테스트 16 〉	통과 (9.42ms, 83.6MB)
테스트 17 〉	통과 (8.83ms, 74.6MB)
테스트 18 〉	통과 (10.91ms, 74.4MB)
테스트 19 〉	통과 (12.36ms, 80.4MB)
테스트 20 〉	통과 (12.44ms, 87MB)
테스트 21 〉	통과 (11.53ms, 74.4MB)
테스트 22 〉	통과 (8.57ms, 73.9MB)
테스트 23 〉	통과 (9.72ms, 77.8MB)
테스트 24 〉	통과 (8.98ms, 78.8MB)
테스트 25 〉	통과 (9.15ms, 78.7MB)
 */
