package Level1.Level1_Doll;
// Level 1 : 크레인 인형뽑기 게임

import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        for(int move : moves){
            for(int i=0; i<board.length; i++){
                int value = board[i][move-1];
                if(value != 0){
                    if(!stack.isEmpty() && stack.peek() == value){
                        stack.pop();
                        answer+=2;
                    }
                    else {
                        stack.push(value);
                    }
                    board[i][move-1] = 0;
                    break;
                }
            }
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        int [][] board = {
                {0,0,0,0,0},
                {0,0,1,0,3},
                {0,2,5,0,1},
                {4,2,4,4,2},
                {3,5,1,3,1}
        };
        int [] moves = {1, 5, 3, 5, 1, 2, 1, 4};

        Solution s = new Solution();

        System.out.println(s.solution(board, moves));
    }
}