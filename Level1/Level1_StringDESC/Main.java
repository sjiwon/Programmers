package Level1.Level1_StringDESC;

import java.util.*;
class Solution {
    public String solution(String s) {
        char [] arr = s.toCharArray();

        Arrays.sort(arr);
        // 대문자가 먼저 온다 -> 아스키코드상으로 대문자가 소문자보다 작음

        StringBuilder sb = new StringBuilder(new String(arr));

        return sb.reverse().toString();
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
