package Level2.Level2_MoreSpicy;

import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        /*
        1. 스코빌 지수 가장 낮은 2개 음식 일단 선택
        2. 2개 음식 섞어서 새로운 음식으로

        새로운 음식 스코빌 = 가장 낮은 음식 스코빌 + (2번째로 낮은 음식 스코빌) * 2
         */

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        for(int n : scoville){
            pq.offer(n);
        }

        int count = 0; // 총 음식 섞는 횟수

        while (!isAllHigh(pq, K) && !pq.isEmpty() && pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();

            int new_s = first + second * 2;
            count++;

            pq.offer(new_s);
        }

        if(!isAllHigh(pq, K)){
            return -1;
        }
        else{
            return count;
        }
    }

    static boolean isAllHigh(PriorityQueue<Integer> pq, int K){
        for(Integer n : pq){
            if(n < K)
                return false;
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        int [] scoville = {1, 2, 3, 9, 10, 12};

        System.out.println(new Solution().solution(scoville, 7));
    }
}
