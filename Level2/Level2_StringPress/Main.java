package Level2.Level2_StringPress;

class Solution {
    public int solution(String s) {
        int ShortestLength = s.length();

        for(int i=1; i<=s.length()/2; i++){
            // 단위 : 1, 2, 3, ....., s.length()/2까지 :: 어차피 반 이상으로 자르면 문제 조건에 어긋남
            StringBuilder sb = new StringBuilder(); // [i]길이로 압축한 새로운 문자열

            String s_sub = s;

            while(s_sub.length() >= i) {
                // 문자열 내에서 [i]길이 끼리 비교
                String standard = s_sub.substring(0, i);
                // [i]길이만큼의 기준 문자열 선정 :: 뒤에 남은 문자열하고 같은지 판별

                String compare = s_sub.substring(i); // 남은 문자열들

                int count = 1;
                while (compare.startsWith(standard) && compare.length() > 0) {
                    count++;
                    compare = compare.replaceFirst(standard, "");
                }

                if(count > 1) {
                    sb.append(count);
                }
                sb.append(standard);

                s_sub = compare;
            }
            sb.append(s_sub);

            ShortestLength = Math.min(ShortestLength, sb.length());
        }

        return ShortestLength;
    }
}

public class Main {
    public static void main(String[] args) {
        String [] example = {
                "aabbaccc",
                "ababcdcdababcdcd",
                "abcabcdede",
                "abcabcabcabcdededededede",
                "xababcdcdababcdcd"
        };
        Solution slt = new Solution();

        for(String s : example){
            System.out.println(slt.solution(s));
        }
    }
}
