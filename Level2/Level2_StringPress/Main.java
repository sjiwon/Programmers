package Level2.Level2_StringPress;

import org.junit.Assert;
import org.junit.Test;

class Solution {
    public int solution(String s) {
        int length = s.length();

        for (int i = 1; i <= s.length() / 2; i++) {
            // [i] = 문자열 압축하는 단위
            length = Math.min(length, stringPress(s, i));
        }

        return length;
    }

    static int stringPress(String s, int i) {
        // [i] 단위로 문자열 압축하기
        StringBuilder sb = new StringBuilder(); // 최종 압축된 문자열

        String remainString = s; // [i] 단위와 비교될 '남은 문자열'

        while (remainString.length() >= i) { // 비교될 최소 [i] 단위가 남을때까지
            String standard = remainString.substring(0, i); // 단계마다 기준이 되는 [i] 단위 subString
            String compare = remainString.substring(i); // remainString에서 standard를 제외한 나머지 문자열

            int count = 1; // compare의 시작에서부터 standard가 반복된다면 증가
            while (compare.startsWith(standard) && compare.length() >= i) {
                // 반복 조건이 성립한다면 - 얼마나 반복되는지
                count++;
                compare = compare.replaceFirst(standard, ""); // 반복되어서 count에 반영된 subString은 제거
            }

            if (count > 1) { // 2번이상 반복되면 반복횟수 add
                sb.append(count);
            }

            sb.append(standard);
            remainString = compare; // 반복안되는 남은 부분부터 다시 시작
        }
        sb.append(remainString); // 압축이 되지 않은 남은 문자열 add
        return sb.length();
    }
}

public class Main {
    static void start(String s, int expect){
        System.out.println("## 테스트 케이스 ##");
        System.out.println("s = " + s);
        int solution = new Solution().solution(s);
        System.out.println("expect = " + expect + " -> actual = " + solution + "\n");
        Assert.assertEquals(solution, expect);
    }
    @Test
    public void 테스트케이스1(){
        start("aabbaccc", 7);
    }

    @Test
    public void 테스트케이스2(){
        start("ababcdcdababcdcd", 9);
    }

    @Test
    public void 테스트케이스3(){
        start("abcabcdede", 8);
    }

    @Test
    public void 테스트케이스4(){
        start("abcabcabcabcdededededede", 14);
    }

    @Test
    public void 테스트케이스5() {
        start("xababcdcdababcdcd", 17);
    }
}
