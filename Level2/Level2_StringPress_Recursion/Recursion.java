package Level2.Level2_StringPress_Recursion;

class Solution2 {
    public int solution(String s) {
        int ShortestLength = s.length();

        for(int i=1; i<=s.length()/2; i++){
            // [i] : 문자열 자르는 단위
            StringBuilder sb = new StringBuilder();
            ShortestLength = Math.min(ShortestLength, recursion(s, i, sb));
        }

        return ShortestLength;
    }

    static int recursion(String s, int i, StringBuilder sb){
        /*
        s : 문자열 & recursion 돌리면서 계속 size 작아짐
        i : 문자열 자르는 단위
        sb : 새로 생성되는 [i]단위로 잘라서 압축한 문자열
         */
        if(s.length() < i){
            sb.append(s);
            //System.out.println(sb);
            return sb.length();
        }

        String standard = s.substring(0, i);
        // [i]길이만큼의 기준 문자열 선정 :: 뒤에 남은 문자열하고 같은지 판별

        String compare = s.substring(i); // 남은 문자열들

        int count = 1;
        while (compare.startsWith(standard) && compare.length() > 0) {
            count++;
            compare = compare.replaceFirst(standard, "");
        }

        if(count > 1) {
            sb.append(count);
        }
        sb.append(standard);

        return recursion(compare, i, sb);
    }
}

public class Recursion {
    public static void main(String[] args) {
        String [] example = {
                "aabbaccc",
                "ababcdcdababcdcd",
                "abcabcdede",
                "abcabcabcabcdededededede",
                "xababcdcdababcdcd"
        };
        Solution2 slt = new Solution2();

        for(String s : example){
            System.out.println(slt.solution(s));
        }
    }
}
