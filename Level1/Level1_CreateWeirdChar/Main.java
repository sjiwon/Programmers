package Level1.Level1_CreateWeirdChar;
// Level 1 : 이상한 문자 만들기

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();

        while(sb.length() != s.length()){
            int index = 0;
            for(String word : s.split("")){
                if(!word.equals(" ")){
                    if(index%2 == 0){
                        sb.append(word.toUpperCase());
                    }
                    else{
                        sb.append(word.toLowerCase());
                    }
                    index++;
                }
                else{
                    sb.append(" ");
                    index = 0;
                }
            }
        }

        return sb.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.solution("try hello world"));
    }
}
