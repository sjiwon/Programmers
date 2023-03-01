package Level1.Level1_MockExam;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution1 {
    final static int[] person1 = {1, 2, 3, 4, 5};
    final static int[] person2 = {2, 1, 2, 3, 2, 4, 2, 5};
    final static int[] person3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    public int[] solution(int[] answers) {
        int[] answerCount = new int[3]; // 3명 각각 몇개 맞췄는지 저장

        for(int i=0; i<answers.length; i++) {
            // 현재 선택한 답안
            int current1 = person1[i % person1.length];
            int current2 = person2[i % person2.length];
            int current3 = person3[i % person3.length];

            if(answers[i] == current1) {
                answerCount[0]++;
            }
            if(answers[i] == current2) {
                answerCount[1]++;
            }
            if(answers[i] == current3) {
                answerCount[2]++;
            }
        }

        int max = getMaxScore(answerCount); // 가장 높은 점수

        List<Integer> resultList = new ArrayList<>(); // 높은 점수 받은 학생들
        for(int i=0; i<3; i++) {
            if(answerCount[i] == max) {
                resultList.add(i + 1);
            }
        }

        Collections.sort(resultList);

        int[] result = new int[resultList.size()];
        for(int i=0; i<resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }

    private int getMaxScore(int[] answerCount) {
        int max = 0;
        for(int value : answerCount) {
            max = Math.max(max, value);
        }
        return max;
    }
}

public class Retry1 {
    static void start(int[] answers, int[] expect){
        int[] solution = new Solution1().solution(answers);

        StringBuilder result = new StringBuilder();
        result.append("## 테스트 케이스 ##").append("\n")
                .append("[Parameter -> int[] answers]").append("\n")
                .append("-> ").append(Arrays.toString(answers)).append("\n\n")
                .append("[Result]").append("\n")
                .append("-> ").append(Arrays.toString(solution)).append("\n\n")
                .append("======================================\n")
                .append("예상 정답 = ").append(Arrays.toString(solution)).append("\n")
                .append("실제 정답 = ").append(Arrays.toString(expect));

        System.out.println(result);
        Assertions.assertArrayEquals(solution, expect);
    }

    @Test
    public void 테스트케이스1(){
        start(new int[] {1, 2, 3, 4, 5}, new int[] {1});
    }

    @Test
    public void 테스트케이스2(){
        start(new int[] {1, 3, 2, 4, 2}, new int[] {1, 2, 3});
    }
}
