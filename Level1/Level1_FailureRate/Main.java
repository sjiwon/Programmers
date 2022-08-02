package Level1.Level1_FailureRate;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {

    static class Stage{
        private int idx; // 스테이지 번호
        private double failurePercent; // 해당 스테이지 실패율

        public Stage(int idx, double failurePercent) {
            this.idx = idx;
            this.failurePercent = failurePercent;
        }

        public int getIdx() {
            return idx;
        }

        public double getFailurePercent() {
            return failurePercent;
        }
    }

    public int[] solution(int N, int[] stages) {
        List<Stage> list = new ArrayList<>();

        for(int i=1; i<=N; i++){
            int reachedStageCount = getReachedStageCount(stages, i);
            int stageNotClearCount = getStageNotClearCount(stages, i);
            list.add(new Stage(i, (double)stageNotClearCount/reachedStageCount));
        }

        list.sort(new Comparator<Stage>() {
            @Override
            public int compare(Stage o1, Stage o2) {
                if(o1.getFailurePercent() > o2.getFailurePercent()){
                    return -1;
                } else if(o1.getFailurePercent() < o2.getFailurePercent()){
                    return 1;
                } else{
                    return Integer.compare(o1.getIdx(), o2.getIdx());
                }
            }
        });

        int[] result = new int[N];
        for(int i=0; i<N; i++){
            result[i] = list.get(i).getIdx();
        }
        return result;
    }

    static int getReachedStageCount(int[] stages, int idx){
        int count = 0;

        for (int stage : stages) {
            if(stage >= idx){
                count++;
            }
        }

        return count;
    }

    static int getStageNotClearCount(int[] stages, int idx){
        int count = 0;

        for (int stage : stages) {
            if(stage == idx){
                count++;
            }
        }

        return count;
    }
}

public class Main {
    static void start(int N, int[] stages, int[] expect){
        System.out.println("## 테스트 케이스 ##");
        System.out.println("<stages>");
        System.out.println(Arrays.toString(stages));

        int[] solution = new Solution().solution(N, stages);
        System.out.println("<Result>");
        System.out.println(Arrays.toString(solution) + "\n");
        System.out.println("expect(도출한 답) = " + Arrays.toString(solution) + " -> actual(실제 도출되어야 하는 답) = " + Arrays.toString(expect));

        Assert.assertArrayEquals(solution, expect);
    }

    @Test
    public void 테스트케이스1(){
        start(
                5,
                new int[] {2, 1, 2, 6, 2, 4, 3, 3},
                new int[] {3, 4, 2, 1, 5}
        );
    }

    @Test
    public void 테스트케이스2(){
        start(
                4,
                new int[] {4, 4, 4, 4, 4},
                new int[] {4, 1, 2, 3}
        );
    }
}

/*
테스트 1 〉	통과 (1.40ms, 82.6MB)
테스트 2 〉	통과 (1.29ms, 76.7MB)
테스트 3 〉	통과 (17.61ms, 80.1MB)
테스트 4 〉	통과 (74.76ms, 76.3MB)
테스트 5 〉	통과 (263.71ms, 99.8MB)
테스트 6 〉	통과 (3.35ms, 75.8MB)
테스트 7 〉	통과 (8.32ms, 79.5MB)
테스트 8 〉	통과 (69.20ms, 85.7MB)
테스트 9 〉	통과 (270.96ms, 86.4MB)
테스트 10 〉	통과 (28.96ms, 88.2MB)
테스트 11 〉	통과 (72.05ms, 96.7MB)
테스트 12 〉	통과 (41.77ms, 88.9MB)
테스트 13 〉	통과 (60.30ms, 80.2MB)
테스트 14 〉	통과 (0.56ms, 73MB)
테스트 15 〉	통과 (8.97ms, 77.8MB)
테스트 16 〉	통과 (8.82ms, 84.5MB)
테스트 17 〉	통과 (8.42ms, 72.3MB)
테스트 18 〉	통과 (10.48ms, 84.4MB)
테스트 19 〉	통과 (3.29ms, 78.6MB)
테스트 20 〉	통과 (9.38ms, 78.2MB)
테스트 21 〉	통과 (11.17ms, 87.4MB)
테스트 22 〉	통과 (82.21ms, 85.5MB)
테스트 23 〉	통과 (11.87ms, 90.3MB)
테스트 24 〉	통과 (18.68ms, 84.2MB)
테스트 25 〉	통과 (0.50ms, 73.5MB)
테스트 26 〉	통과 (0.53ms, 74.7MB)
테스트 27 〉	통과 (0.52ms, 82.9MB)
 */