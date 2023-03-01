package Level2.Level2_Carpet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

class Solution {
    // 가로 - 세로의 경우의 수를 저장하는 Square
    static class Square {
        int row;
        int col;

        public Square(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int[] solution(int brown, int yellow) {
        // 중앙 노랜색 카펫의 가로-세로 경우의 수를 저장하는 list
        List<Square> list = new ArrayList<>();
        applySituation(yellow, list);

        for(Square s : list) {
            int row = s.row;
            int col = s.col;

            // brown의 가로-세로 계산
            int rowB = row + 2;
            int colB = col;
            int total = rowB * 2 + colB * 2;

            if(brown == total) {
                return new int[] {rowB, colB + 2};
            }
        }
        return null;
    }

    public void applySituation(int yellow, List<Square> list) {
        for(int i=1; i<=yellow; i++) {
            if(yellow % i == 0) {
                int row = i;
                int col = yellow/i;

                if(row >= col) {
                    list.add(new Square(row, col));
                }
            }
        }
    }
}

public class Main {
    static void start(int brown, int yellow, int[] expect){
        int[] solution = new Solution().solution(brown, yellow);

        StringBuilder result = new StringBuilder();
        result.append("## 테스트 케이스 ##").append("\n")
                .append("[Parameter -> int brown]").append("\n")
                .append("-> ").append(brown).append("\n\n")
                .append("[Parameter -> int yellow]").append("\n")
                .append("-> ").append(yellow).append("\n\n")
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
        start(10, 2, new int[] {4, 3});
    }

    @Test
    public void 테스트케이스2(){
        start(8, 1, new int[] {3, 3});
    }

    @Test
    public void 테스트케이스3(){
        start(24, 24, new int[] {8, 6});
    }
}
