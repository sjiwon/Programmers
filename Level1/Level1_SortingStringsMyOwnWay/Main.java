package Level1.Level1_SortingStringsMyOwnWay;
// Level 1 : 문자열 내 마음대로 정렬하기

import java.util.*;
class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.charAt(n) < o2.charAt(n))
                    return -1;
                else if(o1.charAt(n) > o2.charAt(n))
                    return 1;
                else
                    return o1.compareTo(o2);
                    // n번째 인덱스 같으면 그냥 사전 순
            }
        });

        return strings;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String [] s1 = {"sun", "bed", "car"};
        String [] s2 = {"abce", "abcd", "cdx"};

        System.out.println(Arrays.toString(Arrays.stream(s.solution(s1, 1)).toArray()));
        System.out.println(Arrays.toString(Arrays.stream(s.solution(s2, 2)).toArray()));
    }
}
