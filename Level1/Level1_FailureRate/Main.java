package Level1.Level1_FailureRate;
// Level 1 : 실패율

import java.util.*;
class Solution {
    static class stage_fail{
        private int stage;
        private double fail_percent;
        stage_fail(int stage, double fail_percent){
            this.stage = stage;
            this.fail_percent = fail_percent;
        }
        int getStage(){
            return stage;
        }
        double getFail_percent(){
            return fail_percent;
        }
    }

    public int[] solution(int N, int[] stages) {
        int [] result = new int[N];
        // 스테이지 별 실패율 저장 우선순위 큐 (실패율 높은순서부터 내림차순)
        PriorityQueue<stage_fail> pq = new PriorityQueue<stage_fail>((o1, o2) -> {
            if(o1.getFail_percent() > o2.getFail_percent())
                return -1;
            else if(o1.getFail_percent() < o2.getFail_percent())
                return 1;
            else {
                if(o1.getStage() < o2.getStage())
                    return -1;
                else if(o1.getStage() > o2.getStage())
                    return 1;
                else
                    return 0;
            }
        });

        for(int i=1; i<=N; i++){
            if(success(stages, i) == 0)
                pq.offer(new stage_fail(i, 0));
            else{
                double fail_percent = (double)fail(stages, i)/success(stages, i);
                pq.offer(new stage_fail(i, fail_percent));
            }
        }
        for(int i=0; i<result.length; i++)
            result[i] = pq.poll().getStage();

        return result;
    }

    static int success(int [] stages, int num){
        // 해당 스테이지 도달한 사람의 수 return
        int count = 0;
        for(int s : stages){
            if(s >= num)
                count++;
        }
        return count;
    }

    static int fail(int [] stages, int num){
        // 해당 스테이지 아직 통과못한 사람의 수 return
        int count = 0;
        for(int s : stages){
            if(s == num)
                count++;
        }
        return count;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int [] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        int [] stages2 = {4, 4, 4, 4, 4};
        int [] result1 = s.solution(5, stages);
        int [] result2 = s.solution(4, stages2);

        for(int num : result1)
            System.out.print(num + " ");
        System.out.println();
        for(int num : result2)
            System.out.print(num + " ");
    }
}
