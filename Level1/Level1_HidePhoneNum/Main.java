package Level1.Level1_HidePhoneNum;
// Level 1 : 핸드폰 번호 가리기

class Solution {
    public String solution(String phone_number) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<phone_number.length(); i++){
            if(i<phone_number.length() - 4)
                sb.append("*");
            else
                sb.append(phone_number.charAt(i));
        }
        return sb.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.solution("01033334444"));
        System.out.println(s.solution("027778888"));
    }
}
