package Level1.Level1_TakeTwoAndAdd;
// Level 1 : 두개 뽑아서 더하기

import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> set = new TreeSet<>();
        // 자동 오름차순 정렬

        for(int i=0; i<numbers.length-1; i++) {
            for (int j = i + 1; j < numbers.length; j++)
                set.add(numbers[i] + numbers[j]);
        }

        ArrayList<Integer> list = new ArrayList<>(set);

        int [] result = new int[list.size()];

        for(int i=0; i<result.length; i++)
            result[i] = list.get(i);

        return result;
    }
}

