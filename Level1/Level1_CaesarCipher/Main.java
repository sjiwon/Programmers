package Level1.Level1_CaesarCipher;
// Level 1 : 시저 암호

class Solution {
    public String solution(String s, int n) {
        char [] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();

        for(char c : arr){
            int ascii = 0;
            if(Character.isUpperCase(c)){
                ascii = (c - 'A' + n)%26;
                sb.append((char)(ascii + 'A'));
            }
            else if(Character.isLowerCase(c)){
                ascii = (c - 'a' + n)%26;
                sb.append((char)(ascii + 'a'));
            }
            else
                sb.append(c);
        }

        return sb.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("AB", 1));
        System.out.println(s.solution("z", 1));
        System.out.println(s.solution("a B z", 4));
    }
}
