package Level1.Level1_StringHandling;
// Level 1 : 문자열 다루기 기본

import java.util.regex.*;
class Solution {
    public boolean solution(String s) {
        Pattern p = Pattern.compile("^[0-9]{4}|{6}$");
        Matcher m = p.matcher(s);

        return m.matches();
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.solution("a234"));
        System.out.println(s.solution("1234"));
    }
}
