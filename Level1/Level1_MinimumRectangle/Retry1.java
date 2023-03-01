package Level1.Level1_MinimumRectangle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class Solution1 {
    public int solution(int[][] sizes) {
        // 가로는 무조건 max, 세로는 무조건 min하게 정렬
        for(int[] row : sizes) {
            if(row[0] < row[1]) { // 세로가 가로보다 max일 경우
                int tmp = row[0];
                row[0] = row[1];
                row[1] = tmp;
            }
        }

        // 가로 vs 세로 각각 max 뽑으면 모든 명함 충족
        int hmax = 0; // 가로 max
        int vmax = 0; // 세로 max

        for(int[] row : sizes) {
            int h = row[0];
            int v = row[1];

            hmax = Math.max(hmax, h);
            vmax = Math.max(vmax, v);
        }

        return hmax * vmax;
    }
}

public class Retry1 {
    static void start(int[][] sizes, int expect){
        int solution = new Solution1().solution(sizes);

        StringBuilder result = new StringBuilder();
        result.append("## 테스트 케이스 ##").append("\n")
                .append("[Parameter -> int[][] sizes]").append("\n")
                .append("-> ").append(Arrays.deepToString(sizes)).append("\n\n")
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
        start(
                new int[][] {{60, 50}, {30, 70}, {60, 30}, {80, 40}},
                4000
        );
    }

    @Test
    public void 테스트케이스2(){
        start(
                new int[][] {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}},
                120
        );
    }

    @Test
    public void 테스트케이스3(){
        start(
                new int[][] {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}},
                133
        );
    }
}
