package Level1.Level1_MockExam;
// Level 1 : 모의고사

import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int [] answer = {};
        int [] person1 = {1, 2, 3, 4, 5};
        int [] person2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int [] person3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int [] score = new int[3];
        for(int i=0; i<answers.length; i++){
            int answer_1 = person1[i%(person1.length)];
            int answer_2 = person2[i%(person2.length)];
            int answer_3 = person3[i%(person3.length)];

            if(answer_1 == answers[i]) score[0]++;
            if(answer_2 == answers[i]) score[1]++;
            if(answer_3 == answers[i]) score[2]++;
        }

        int max = get_max(score);

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<score.length; i++){
            if(score[i] == max)
                list.add(i+1);
        }

        answer = new int[list.size()];
        for(int i=0; i<list.size(); i++)
            answer[i] = list.get(i);

        return answer;
    }

    static int get_max(int [] score){
        int max = score[0];
        for(int i=1; i<score.length; i++){
            if(score[i] > max)
                max = score[i];
        }
        return max;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int [] answer1 = {1, 2, 3, 4, 5};
        int [] answer2 = {1, 3, 2, 4, 2};

        int [] result = s.solution(answer1);
        int [] result2 = s.solution(answer2);

        for (int j : result) System.out.println(j);
        for (int j : result2) System.out.println(j);
    }
}
