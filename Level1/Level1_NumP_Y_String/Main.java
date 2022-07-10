package Level1.Level1_NumP_Y_String;
// Level 1 : 문자열 내의 p와 y의 개수

class Solution {
    boolean solution(String s) {
        int p_count = 0;
        int y_count = 0;

        StringBuilder sb = new StringBuilder(s.toLowerCase());

        for(int i=0; i<sb.length(); i++){
            if(sb.charAt(i) == 'p')
                p_count++;
            else if(sb.charAt(i) == 'y')
                y_count++;
        }

        if(p_count == y_count)
            return true;
        else
            return false;
    }
}
