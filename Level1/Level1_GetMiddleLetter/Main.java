package Level1.Level1_GetMiddleLetter;
// Level 1 : 가운데 글자 가져오기

class Solution {
    public String solution(String s) {
        if(s.length() % 2 == 0)
            return s.substring(s.length()/2-1, s.length()/2+1);
        else
            return s.substring(s.length()/2, s.length()/2+1);
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
