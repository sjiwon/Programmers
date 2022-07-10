package Level1.Level1_DartGame;
// Level 1 : 다트게임

import java.util.*;
import java.util.regex.*;

class Solution {
    public int solution(String dartResult) {
        Pattern p = Pattern.compile("([0-9]0?)([SDT])([*#]?)");
        // 점수 : [0-9]0? -> 0~9중 하나 나오고, 만약 1이 나오고 뒤에 0이 나오면 10
        // 보너스 : [SDT] -> S, D, T중 하나
        // 옵션 : [*#]? -> *, #중 하나 (0번 or 1번 나옴)
        // group(1) = 점수, group(2) = 보너스, group(3) = 옵션
        Matcher m = p.matcher(dartResult);

        LinkedList<Integer> score = new LinkedList<>();
        // 각 문자열 (점수|보너스|옵션) 별 점수 push

        while(m.find()){
            int value = Integer.parseInt(m.group(1));

            switch(m.group(2)){
                case "D":
                    value = value*value;
                    break;
                case "T":
                    value = value*value*value;
                    break;
            }

            switch(m.group(3)){
                case "*":
                    // score list에 존재하는 점수 전부 2배
                    if(!score.isEmpty())
                        score.push(score.pop()*2);
                    value *= 2;
                    break;
                case "#":
                    // 해당 점수 -1배
                    value *= -1;
                    break;
            }

            score.push(value);
        }

        int result = 0;
        for(Integer s : score)
            result += s;

        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        String s1 = "1S2D*3T";
        String s2 = "1D2S#10S";
        String s3 = "1S*2T*3S";
        String s4 = "1T2D3D#";
        String s5 = "1D2S3T*";

        System.out.println(s.solution(s1));
        System.out.println(s.solution(s2));
        System.out.println(s.solution(s3));
        System.out.println(s.solution(s4));
        System.out.println(s.solution(s5));
    }
}
