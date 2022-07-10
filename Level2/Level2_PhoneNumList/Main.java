package Level2.Level2_PhoneNumList;
// Level 2 : 전화번호 목록

import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        HashMap<String, Integer> hm = new HashMap<>();
        // 폰북 번호 저장 : 접두사 비교 전용 해시맵

        for(String s : phone_book)
            hm.put(s, 0);

        for(String s : phone_book){
            for(int i = 0; i<s.length(); i++){
                String tmp = s.substring(0, i);
                //System.out.println(tmp); // 각 substring 확인 임시 출력
                if(hm.containsKey(tmp))
                    return false;
            }
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        String [] s1 = {"119", "97674223", "1195524421"};
        String [] s2 = {"123", "456", "789"};
        String [] s3 = {"12", "123", "1235", "567", "88"};

        Solution s = new Solution();

        if(!s.solution(s1))
            System.out.println("false");
        else
            System.out.println("true");

        if(!s.solution(s2))
            System.out.println("false");
        else
            System.out.println("true");

        if(!s.solution(s3))
            System.out.println("false");
        else
            System.out.println("true");
    }
}
