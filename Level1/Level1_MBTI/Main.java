package Level1.Level1_MBTI;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 매우 [...] = 3점
 * [...] = 2점
 * 약간 [...] = 1점
 * 모르겠음 = 0점
 */

class Solution {

    static final String[][] CATEGORY = {
        {"R", "T"},
        {"C", "F"},
        {"J", "M"},
        {"A", "N"}
    };

    public String solution(String[] survey, int[] choices) {
        Map<String, Integer> score = new HashMap<>(){
            {
                put("R", 0);
                put("T", 0);
                put("C", 0);
                put("F", 0);
                put("J", 0);
                put("M", 0);
                put("A", 0);
                put("N", 0);
            }
        };

        for (int i = 0; i < survey.length; i++) {
            String type = survey[i];
            String firstType = String.valueOf(type.charAt(0));
            String secondType = String.valueOf(type.charAt(1));

            int choice = choices[i] - 4;

            if (choice < 0) {
                score.put(firstType, score.get(firstType) + Math.abs(choice));
            } else {
                score.put(secondType, score.get(secondType) + Math.abs(choice));
            }
        }

        StringBuilder result = new StringBuilder();
        for (String[] type : CATEGORY) {
            String firstType = type[0];
            String secondType = type[1];

            if (score.get(firstType) > score.get(secondType)) {
                result.append(firstType);
            } else if (score.get(firstType) < score.get(secondType)) {
                result.append(secondType);
            } else {
                result.append(firstType);
            }
        }

        return result.toString();
    }
}

public class Main {
    static void start(String[] survey, int[] choices, String expect){
        System.out.println("## 테스트 케이스 ##");
        System.out.println("<Survey>");
        System.out.println(Arrays.toString(survey) + "\n");
        System.out.println("<Choices>");
        System.out.println(Arrays.toString(choices) + "\n");

        String solution = new Solution().solution(survey, choices);
        System.out.println("\n<Result>");
        System.out.println(solution + "\n");
        System.out.println("expect(도출한 답) = " + solution + " -> actual(실제 도출되어야 하는 답) = " + expect);
        Assert.assertEquals(solution, expect);
    }

    @Test
    public void 테스트케이스1(){
        start(
                new String[]{"AN", "CF", "MJ", "RT", "NA"},
                new int[]{5, 3, 2, 7, 5},
                "TCMA"
        );
    }

    @Test
    public void 테스트케이스2(){
        start(
                new String[]{"TR", "RT", "TR"},
                new int[]{7, 1, 3},
                "RCJA"
        );
    }
}
