package Level1.Level1_PlaceNumDesc;
// Level 1 : 정수 내림차순으로 배치하기

import java.util.*;
class Solution {
    public long solution(long n) {
        StringBuilder sb = new StringBuilder();

        ArrayList<Integer> list = new ArrayList<>();

        while(n!=0){
            list.add((int) (n%10));
            n/=10;
        }

        list.sort(Collections.reverseOrder());

        for (Integer integer : list) {
            sb.append(integer);
        }

        return Long.parseLong(sb.toString());
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
