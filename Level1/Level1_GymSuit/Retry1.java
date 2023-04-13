package Level1.Level1_GymSuit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class Solution1 {
    public int solution(int n, int[] lost, int[] reserve) {
        int result = n - lost.length; // lost는 일단 전부 못입는다고 가정

        Arrays.sort(lost);
        Arrays.sort(reserve);

        // 여벌 체육복 존재 -> 도난당한 경우 => lost, reserve에서 제외
        for(int i=0; i<lost.length; i++) {
            for(int j=0; j<reserve.length; j++) {
                if(lost[i] == reserve[j]) {
                    lost[i] = -1;
                    reserve[j] = -1;
                    result++; // lost지만 그냥 여벌옷 입으면 되니까
                    break;
                }
            }
        }

        // 체육복 빌려주기
        for(int i=0; i<lost.length; i++) {
            for(int j=0; j<reserve.length; j++) {
                if (lost[i] == reserve[j] - 1 || lost[i] == reserve[j] + 1) { // 양쪽 중 1명에게 빌려준 경우
                    result++;
                    reserve[j] = -1; // 빌려주기 완료
                    break;
                }
            }
        }

        return result;
    }
}

public class Retry1 {
    static void start(int n, int[] lost, int[] reserve, int expect){
        int solution = new Solution1().solution(n, lost, reserve);

        StringBuilder result = new StringBuilder();
        result.append("## 테스트 케이스 ##").append("\n")
                .append("[Parameter -> int n]").append("\n")
                .append("-> ").append(n).append("\n\n")
                .append("[Parameter -> int[] lost]").append("\n")
                .append("-> ").append(Arrays.toString(lost)).append("\n\n")
                .append("[Parameter -> int[] reserve]").append("\n")
                .append("-> ").append(Arrays.toString(reserve)).append("\n\n")
                .append("[Result]").append("\n")
                .append("-> ").append(solution).append("\n\n")
                .append("======================================\n")
                .append("예상 정답 = ").append(solution).append("\n")
                .append("실제 정답 = ").append(expect);

        System.out.println(result);
        Assertions.assertEquals(solution, expect);
    }

    @Test
    public void 테스트케이스1(){
        start(5, new int[]{2, 4}, new int[]{1, 3, 5}, 5);
    }

    @Test
    public void 테스트케이스2(){
        start(5, new int[]{2, 4}, new int[]{3}, 4);
    }

    @Test
    public void 테스트케이스3(){
        start(3, new int[]{3}, new int[]{1}, 2);
    }
}
